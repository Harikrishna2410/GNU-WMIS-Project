package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.API.GetAllProductsAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.GetAllSuppliersAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.LogoutAPI;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AsyncGetAllCustomers extends AsyncTask<String, Integer, String> {

  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCustomers sc;
  ProgressBarHandler pb;
  JSONObject response;

  public AsyncGetAllCustomers(Context ctx, JSONObject response, ProgressBarHandler pb) {
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
    Toast.makeText(ctx, "Syncing", Toast.LENGTH_SHORT).show();
    pb.pb_load_tv.setText("Loading Customers...");
    super.onPreExecute();
  }

  @Override
  protected String doInBackground(String... strings) {
    processResponse();
    return null;
  }

  private void processResponse() {
    try {
      if (response.getString("message").equals("Success")) {
        ArrayList<SyncCustomers> syncCustomers = new ArrayList<>();
        JSONArray jsonArray = response.getJSONArray("all_customer_detail");
//                pb.progressBar_dynamic.setMax(jsonArray.length());
        if (jsonArray.length() > 0) {
          for (int i = 0; i < jsonArray.length(); i++) {
            SyncCustomers ob = new SyncCustomers();
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

            ob.setId(jsonObject.getString("id"));
            ob.setClient_id(jsonObject.getString("client_id"));
            ob.setName(jsonObject.getString("name"));
            ob.setContact_name(jsonObject.getString("contact_name"));
            ob.setGstin(jsonObject.getString("gstin"));
            ob.setEmail(jsonObject.getString("email"));
            ob.setAddress(jsonObject.getString("address"));
            ob.setCity(jsonObject.getString("city"));
            ob.setState(jsonObject.getString("state"));
            ob.setPostcode(jsonObject.getString("postcode"));
            ob.setContact_no(jsonObject.getString("contact_no"));
            ob.setStatus(jsonObject.getString("status"));
            ob.setIs_product_tax(jsonObject.getString("is_product_tax"));
            ob.setCreated_at(jsonObject.getString("created_at"));
            ob.setUpdated_at(jsonObject.getString("updated_at"));
            ob.setDeleted_at(jsonObject.getString("deleted_at"));
            syncCustomers.add(ob);
          }
          // THIS WILL INSERT DATA OF CUSTOMERS IN SQLITE DB
          dbHelper.syncCustomerTable(ctx, syncCustomers, sc);
        }
      }
    } catch (JSONException e) {
      e.printStackTrace();
//      Toast.makeText(ctx, "GetAllCustomers_API : line 105" + e.getMessage(), Toast.LENGTH_SHORT).show();
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
    GetAllSuppliersAPI obj = new GetAllSuppliersAPI(ctx);
    obj.GetAllSuppliers_API(pb);
    super.onPostExecute(s);
  }

}
