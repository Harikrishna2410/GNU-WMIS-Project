package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.MainActivity;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncSalesRep;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class AsyncUpdateSalesRep extends AsyncTask<String, Integer, String> {


  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCustomers sc;
  ProgressBarHandler pb;
  JSONObject response;
  String salesrep_for_api;

  public AsyncUpdateSalesRep(Context ctx, JSONObject response, ProgressBarHandler pb) {
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
  }

  @Override
  protected String doInBackground(String... strings) {
    processResponse();
    return null;
  }

  private void processResponse() {
    try {
      ArrayList<SyncSalesRep> syncSalesReps = new ArrayList<>();
      //Toast.makeText(main_menu.getApplicationContext(), "getting all Sales Rep", Toast.LENGTH_SHORT).show();
      JSONArray jsonArray = response.getJSONArray("all_salesrep_detail");
      syncSalesReps.clear();
      for (int i = 0; i < jsonArray.length(); i++) {
        SyncSalesRep ob = new SyncSalesRep();
        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
        ob.setId(jsonObject.getString("id"));
        ob.setClient_id(jsonObject.getString("client_id"));
        ob.setInitial(jsonObject.getString("initial"));
        ob.setRegion(jsonObject.getString("region"));
        ob.setIs_active(jsonObject.getString("is_active"));
        syncSalesReps.add(ob);
      }
      //setting sales rep data from response to local DB
      dbHelper.syncSalesRepTable((Main_Menu) ctx, syncSalesReps);
    } catch (JSONException e) {
      e.printStackTrace();
      Toast.makeText(ctx, "AsyncUpdateSalesRep : line 58", Toast.LENGTH_SHORT).show();
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
    pb.dismiss();
    if (spdt.pref_client.getString("sales_rep_id", null).equals("null")) {
      ((Main_Menu) ctx).getSalesRepFromDbToDialog();
//      Toast.makeText(ctx, "Sales rep table updated.", Toast.LENGTH_SHORT).show();
    }
  }

}
