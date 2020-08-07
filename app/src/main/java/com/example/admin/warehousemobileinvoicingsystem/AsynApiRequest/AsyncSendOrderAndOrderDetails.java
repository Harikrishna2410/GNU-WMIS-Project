package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.API.GetAllCustomersAPI;
import com.example.admin.warehousemobileinvoicingsystem.AllTableNames;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.GetSignatureFile;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.admin.warehousemobileinvoicingsystem.AllTableNames.dateFormat;

public class AsyncSendOrderAndOrderDetails extends AsyncTask<String, Integer, String> {

  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCustomers sc;
  ProgressBarHandler pb;
  JSONObject response;
  String message;
  GetSignatureFile getSignatureFile;
  AllTableNames tn;
  DateFormat dateFormat;
  Date date;

  public AsyncSendOrderAndOrderDetails(Context ctx, JSONObject response, ProgressBarHandler pb) {
    this.ctx = ctx;
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.apiUrl = new ApiUrl(ctx);
    this.dbHelper = new DbHelper(ctx);
    this.sc = new SyncCustomers();
    this.pb = pb;
    this.response = response;
    this.getSignatureFile = new GetSignatureFile(ctx);
    tn = new AllTableNames();
    this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    this.date = new Date();


  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
    pb.pb_load_tv.setText("Sending Orders...");
  }

  @Override
  protected String doInBackground(String... strings) {
    processResponse();
    return null;
  }

  private void processResponse() {

    try {

      if (response.getString("message").equals("Expired")) {
        //Toast.makeText(logoutAPI, " Sendorderandorderdetails : Expired Account", Toast.LENGTH_SHORT).show();
        //logoutAPI.Logout_API(pb);
        message = "Account Expired!";
      } else {
        if (response.getString("message").equals("Success")) {
          //=================Deleting Signature ==========================================
          //GetSignatureFile getSignatureFile = new GetSignatureFile(ctx);
          getSignatureFile.deleteSignatureFile();
          //==============================================================================
          dbHelper.getWritableDatabase().execSQL("drop table orders");
          dbHelper.getWritableDatabase().execSQL("drop table order_details");
          dbHelper.getWritableDatabase().execSQL(tn.create_orders_table);
          dbHelper.getWritableDatabase().execSQL(tn.create_orders_details_table);
        }
      }

    } catch (JSONException e) {
      e.printStackTrace();
      Toast.makeText(ctx, "sendOrdersAndOrderDetails_API : " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }


  }

  @Override
  protected void onProgressUpdate(Integer... values) {
    super.onProgressUpdate(values);
  }

  @Override
  protected void onPostExecute(String s) {
    super.onPostExecute(s);
    GetSignatureFile getSignatureFile = new GetSignatureFile(ctx);
    getSignatureFile.deleteSignatureFile();

    if (spdt.pref_data_transfer.getString("sync_all", null).equals("no")) {
//      Toast.makeText(ctx, "sync_all=no", Toast.LENGTH_SHORT).show();
      pb.dismiss();
      String sync_date = dateFormat.format(date);
      spdt.editor_client.putString("last_sync_date", sync_date);
      spdt.editor_client.commit();
      Toast.makeText(ctx, "Sync Complete", Toast.LENGTH_SHORT).show();
    }

    if (spdt.pref_data_transfer.getString("sync_all", null).equals("yes")) {
//      Toast.makeText(ctx, "sync_all=yes", Toast.LENGTH_SHORT).show();
      GetAllCustomersAPI GetAllCustomersOBJ = new GetAllCustomersAPI((Main_Menu) ctx);
      GetAllCustomersOBJ.GetAllCustomers_API((Main_Menu) ctx, pb);
    }


  }
}
