package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.API.GetAllTaxRulesAPI;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncTaxRules;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.example.admin.warehousemobileinvoicingsystem.AllTableNames.dateFormat;

public class AsyncGetAllTaxRules extends AsyncTask<String, Integer, String> {

  Context ctx;
  Activity activity;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCustomers sc;
  ProgressBarHandler pb;
  JSONObject response;

  public AsyncGetAllTaxRules(Context ctx, JSONObject response, ProgressBarHandler pb) {
    this.ctx = ctx;
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.apiUrl = new ApiUrl(ctx);
    this.dbHelper = new DbHelper(ctx);
    this.sc = new SyncCustomers();
    this.pb = pb;
    this.response = response;
    this.activity = (Activity) ctx;

  }

  @Override
  protected void onPreExecute() {
    pb.pb_load_tv.setText("Loading Tax Rules...");
    super.onPreExecute();
  }

  @Override
  protected String doInBackground(String... strings) {
    processResponse();
    return null;
  }

  private void processResponse() {


    try {
      ArrayList<SyncTaxRules> syncTaxRules = new ArrayList<>();
      //Toast.makeText(main_menu.getApplicationContext(), "getting all Taxrules  "+response.toString(), Toast.LENGTH_SHORT).show();
      JSONArray jsonArray = response.getJSONArray("all_taxrules_detail");
      if (jsonArray.length() > 0) {
        syncTaxRules.clear();
        for (int i = 0; i < jsonArray.length(); i++) {
          SyncTaxRules ob = new SyncTaxRules();
          JSONObject jsonObject = (JSONObject) jsonArray.get(i);
          ob.setId(jsonObject.getString("id"));
          ob.setClient_id(jsonObject.getString("client_id"));
          ob.setName(jsonObject.getString("name"));
          ob.setRate(jsonObject.getString("rate"));
          ob.setDeleted_at(jsonObject.getString("deleted_at"));
          syncTaxRules.add(ob);
        }
        dbHelper.syncTaxRulesTable(syncTaxRules);
        //pb.dismiss();
        //Toast.makeText(ctx, "Syncing Complete.", Toast.LENGTH_SHORT).show();
        Date currentTime = Calendar.getInstance().getTime();
        String sync_date = dateFormat.format(currentTime);
        spdt.editor_client.putString("last_sync_date", sync_date);
        spdt.editor_client.commit();
        //main_menu.last_sync_date.setText(sync_date);
      } else {
        // pb.dismiss();
        //Toast.makeText(main_menu, "Syncing Complete.", Toast.LENGTH_SHORT).show();
        Date currentTime = Calendar.getInstance().getTime();
        String sync_date = dateFormat.format(currentTime);
        spdt.editor_client.putString("last_sync_date", sync_date);
        spdt.editor_client.commit();

      }
    } catch (JSONException e) {
      Toast.makeText(ctx, "GetAllTaxRules_API : " + e.getMessage(), Toast.LENGTH_SHORT).show();
      e.printStackTrace();
    }


  }

  @Override
  protected void onProgressUpdate(Integer... values) {
    super.onProgressUpdate(values);
  }

  @Override
  protected void onPostExecute(String s) {
//        Toast.makeText(ctx, "last_sync_date = "+spdt.pref_client.getString("last_sync_date",null), Toast.LENGTH_SHORT).show();

//        if (spdt.pref_client.getString("first_sync",null).equals("yes")  ) {
//    Toast.makeText(ctx, "Sync Complete AsyncGetAllTaxRules", Toast.LENGTH_SHORT).show();
    Toast.makeText(ctx, "Sync Successful", Toast.LENGTH_SHORT).show();
    pb.dismiss();
//        }
    spdt.editor_client.putString("first_sync", "no");
    spdt.editor_client.commit();
    Main_Menu main_menu = new Main_Menu();
    Date currentTime = Calendar.getInstance().getTime();
    String sync_date = dateFormat.format(currentTime);
    spdt.editor_client.putString("last_sync_date", sync_date);
    spdt.editor_client.commit();
    TextView v1 = activity.findViewById(R.id.tv_last_sync_date);
    v1.setText(sync_date + " ");
    super.onPostExecute(s);
  }
}
