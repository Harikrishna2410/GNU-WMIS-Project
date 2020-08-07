package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.API.SendOrdersAndOrderDetailsAPI;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncOrders;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class AsyncNewCustomer extends AsyncTask<String, Integer, String> {

  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCustomers sc;
  ProgressBarHandler pb;
  JSONObject response;
  String message;
  ArrayList<SyncOrders> syncOrders;

  public AsyncNewCustomer(Context ctx, JSONObject response, ProgressBarHandler pb) {
    this.ctx = ctx;
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.apiUrl = new ApiUrl(ctx);
    this.dbHelper = new DbHelper(ctx);
    this.sc = new SyncCustomers();
    this.pb = pb;
    this.response = response;
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
    pb.pb_load_tv.setText("Sending New Customers...");
  }

  @Override
  protected String doInBackground(String... strings) {
    processResponse();
    return null;
  }

  private void processResponse() {
    try {
      if (response.has("Message")) {
        message = response.getString("Message");
        if (message.equals("LimitReached")) {
          pb.dismiss();
        }
      }

      if (response.has("Server_id")) {
        //THIS WILL SET SERVER ID FOR NEW CUSTOMER IN LOCAL DB
        JSONArray jsonArray1 = response.getJSONArray("Server_id");
        for (int i = 0; i < jsonArray1.length(); i++) {
          JSONObject json = jsonArray1.getJSONObject(i);
          Iterator<String> keys = json.keys();
          while (keys.hasNext()) {
            String key = keys.next();
            String oldValue = key;
            String newValue = json.get(key).toString();
            DbHelper dbHelper = new DbHelper(ctx);
            dbHelper.updateServer_Id_InCustomers(ctx, oldValue, newValue);
          }
        }
      }
    } catch (JSONException e) {
      pb.dismiss();
    }
  }

  @Override
  protected void onProgressUpdate(Integer... values) {
    super.onProgressUpdate(values);
  }

  @Override
  protected void onPostExecute(String s) {
    super.onPostExecute(s);


    if (response.has("Message")) {
      if (message.equals("LimitReached")) {
        Toast.makeText(ctx, "Max Customer Limit reached. Please contact customer support.", Toast.LENGTH_SHORT).show();
        pb.dismiss();
      }
    }

    if (response.has("Server_id")) {

      //================  BELOW CODE SEND ALL ORDERS AND ORDER_DETAILS TO SERVER  ============================================
      //DbHelper dbHelper = new DbHelper(ctx);
      syncOrders = dbHelper.getAllOrdersForAPI();
      //================== THIS METHOD IS CALLED WHEN WE ADD NEW ORDERS TO SERVER ========================================

      if (syncOrders.size() >= 1) {
        SendOrdersAndOrderDetailsAPI obj = new SendOrdersAndOrderDetailsAPI(ctx);
        obj.sendOrdersAndOrderDetails_API(syncOrders, pb);
      } else    //If there are now orders to send dismiss pb and update last sync
      {
//        Toast.makeText(ctx, "Sync Complete AsyncNewCustomer", Toast.LENGTH_SHORT).show();
        Toast.makeText(ctx, "Sync Complete", Toast.LENGTH_SHORT).show();
        pb.dismiss();
      }
    }

  }
}
