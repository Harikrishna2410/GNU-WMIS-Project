package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.content.Context;
import android.os.AsyncTask;

import com.example.admin.warehousemobileinvoicingsystem.API.GetAllTaxRulesAPI;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCategories;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncSuppliers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AsyncGetAllCategories extends AsyncTask<String, Integer, String> {

  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCategories sc;
  ProgressBarHandler pb;
  JSONObject response;

  public AsyncGetAllCategories(Context ctx, JSONObject response, ProgressBarHandler pb) {
    this.ctx = ctx;
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.apiUrl = new ApiUrl(ctx);
    this.dbHelper = new DbHelper(ctx);
    this.sc = new SyncCategories();
    this.pb = pb;
    this.response = response;
  }

  @Override
  protected void onPreExecute() {
    pb.pb_load_tv.setText("Loading Categories...");
    super.onPreExecute();
  }

  @Override
  protected String doInBackground(String... strings) {
    processResponse();
    return null;
  }

  private void processResponse() {
    try {

      ArrayList<SyncCategories> syncCategories = new ArrayList<>();
      JSONArray jsonArray = response.getJSONArray("all_category_detail");
      if (jsonArray.length() > 0) {
        for (int i = 0; i < jsonArray.length(); i++) {
          SyncCategories ob = new SyncCategories();
          JSONObject jsonObject = (JSONObject) jsonArray.get(i);

          ob.setId(jsonObject.getString("id"));
          ob.setClient_id(jsonObject.getString("client_id"));
          ob.setDiscountrule_id(jsonObject.getString("client_id"));
          ob.setName(jsonObject.getString("name"));
          ob.setCreated_at(jsonObject.getString("created_at"));
          ob.setUpdated_at(jsonObject.getString("updated_at"));
          ob.setDeleted_at(jsonObject.getString("deleted_at"));
          syncCategories.add(ob);
        }
        // THIS WILL INSERT DATA OF SUPPLIERS IN SQLITE DB
        dbHelper.syncCategoriesTable(syncCategories);
      }
    } catch (JSONException e) {
      e.printStackTrace();
      pb.dismiss();
    }
  }

  @Override
  protected void onProgressUpdate(Integer... values) {
    pb.progressBar_dynamic.setProgress(values[0]);
    super.onProgressUpdate(values);
  }

  @Override
  protected void onPostExecute(String s) {
    GetAllTaxRulesAPI obj = new GetAllTaxRulesAPI(ctx);
    obj.GetAllTaxRules_API(pb);
    super.onPostExecute(s);
  }

}
