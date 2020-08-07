package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.API.GetAllCategoriesAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.GetAllTaxRulesAPI;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncSalesRep;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AsyncGetAllSalesrep extends AsyncTask<String, Integer, String> {

  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCustomers sc;
  ProgressBarHandler pb;
  JSONObject response;

  public AsyncGetAllSalesrep(Context ctx, JSONObject response, ProgressBarHandler pb) {
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
    pb.pb_load_tv.setText("Loading Sales Rep...");
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
      JSONArray jsonArray = response.getJSONArray("all_salesrep_detail");
      if (jsonArray.length() > 0) {
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
        dbHelper.syncSalesRepTable((Main_Menu) ctx, syncSalesReps);    //This function will add all sales rep in sales rep table.
      } else {
//                GetAllTaxRulesAPI obj = new GetAllTaxRulesAPI(ctx);
//                obj.GetAllTaxRules_API((Main_Menu) ctx,pb);
      }
    } catch (JSONException e) {
      e.printStackTrace();
      Toast.makeText(ctx, "GetAllSalesRepAPI : line 71 ", Toast.LENGTH_SHORT).show();
    }

    if (spdt.pref_client.getString("sales_rep_id", null).equals("null")) {
      Toast.makeText(ctx, "AsyncGetAllSalesrep : line 92 enable setsales rep ", Toast.LENGTH_SHORT).show();
      //ctx.setSalesRep();
    }

  }


  @Override
  protected void onProgressUpdate(Integer... values) {
    super.onProgressUpdate(values);
  }

  @Override
  protected void onPostExecute(String s) {
    GetAllCategoriesAPI obj = new GetAllCategoriesAPI(ctx);
    obj.GetAllCategories_API(pb);
    super.onPostExecute(s);
  }
}
