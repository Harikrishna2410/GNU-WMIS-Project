package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.API.GetAllProductsAPI;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncSuppliers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AsyncGetAllSuppliers extends AsyncTask<String, Integer, String> {

  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncSuppliers ss;
  ProgressBarHandler pb;
  JSONObject response;

  public AsyncGetAllSuppliers(Context ctx, JSONObject response, ProgressBarHandler pb) {
    this.ctx = ctx;
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.apiUrl = new ApiUrl(ctx);
    this.dbHelper = new DbHelper(ctx);
    this.ss = new SyncSuppliers();
    this.pb = pb;
    this.response = response;
  }

  @Override
  protected void onPreExecute() {
    pb.pb_load_tv.setText("Loading Suppliers...");
    super.onPreExecute();
  }

  @Override
  protected String doInBackground(String... strings) {
    processResponse();
    return null;
  }

  private void processResponse() {
    try {

      ArrayList<SyncSuppliers> syncSuppliers = new ArrayList<>();
      JSONArray jsonArray = response.getJSONArray("all_suppliers_detail");
      if (jsonArray.length() > 0) {
        for (int i = 0; i < jsonArray.length(); i++) {
          SyncSuppliers ob = new SyncSuppliers();
          JSONObject jsonObject = (JSONObject) jsonArray.get(i);
          ob.setId(jsonObject.getString("id"));
          ob.setClient_id(jsonObject.getString("client_id"));
          ob.setName(jsonObject.getString("name"));
          ob.setAddress(jsonObject.getString("address"));
          ob.setPhoneno(jsonObject.getString("phoneno"));
          ob.setStatus(jsonObject.getString("status"));
          ob.setCreated_at(jsonObject.getString("created_at"));
          ob.setUpdated_at(jsonObject.getString("updated_at"));
          ob.setDeleted_at(jsonObject.getString("deleted_at"));
          syncSuppliers.add(ob);
        }
        // THIS WILL INSERT DATA OF SUPPLIERS IN SQLITE DB
        dbHelper.syncSuppliersTable(syncSuppliers);
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
    //pb.dismiss();
    //Toast.makeText(ctx, "Syncccing Completeee", Toast.LENGTH_SHORT).show();
    GetAllProductsAPI obj = new GetAllProductsAPI(ctx);
    obj.GetAllProducts_API(pb);
    super.onPostExecute(s);
  }

}
