package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;

import org.json.JSONException;
import org.json.JSONObject;

public class AsyncLogin extends AsyncTask<String, Integer, String> {


  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCustomers sc;
  ProgressBarHandler pb;
  JSONObject response;
  String message = null;

  public AsyncLogin(Context ctx, JSONObject response, ProgressBarHandler pb) {
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
      //ArrayList<SyncSalesRep> syncSalesReps = new ArrayList<>();
      message = response.getString("message");
      if (message.equals("Success")) {
        //Toast.makeText(mainActivity, "MESSAGE = "+message, Toast.LENGTH_SHORT).show();
        JSONObject object = response.getJSONObject("user_detail");
        spdt.editor_client.putString("client_id", object.getString("id"));
        spdt.editor_client.putString("max_customers", response.getString("max_customers"));
        spdt.editor_client.putString("max_sales_rep", response.getString("max_sales_rep"));
        spdt.editor_client.putString("max_products", response.getString("max_products"));
        spdt.editor_client.putString("client_company_name", object.getString("company_name"));
        spdt.editor_client.putString("client_email", object.getString("email"));
        spdt.editor_client.putString("client_contact_person_name", object.getString("contact_person_name"));
        spdt.editor_client.putString("client_phone_no", object.getString("phone_no"));
        spdt.editor_client.putString("client_address", object.getString("address"));
        spdt.editor_client.putString("client_city", object.getString("city"));
        spdt.editor_client.putString("client_state", object.getString("state"));
        spdt.editor_client.putString("client_zip", object.getString("zip"));
        spdt.editor_client.putString("client_status", object.getString("status"));
        spdt.editor_client.putString("client_role", object.getString("role"));
        spdt.editor_client.putString("client_remember_token", object.getString("remember_token"));
        spdt.editor_client.putString("client_created_by", object.getString("created_by"));
        spdt.editor_client.putString("client_updated_by", object.getString("updated_by"));
        spdt.editor_client.putString("client_created_at", object.getString("created_at"));
        spdt.editor_client.putString("client_expires_at", object.getString("expires_at"));
        spdt.editor_client.putString("client_updated_at", object.getString("updated_at"));
        spdt.editor_client.putString("client_deleted_at", object.getString("deleted_at"));
        spdt.editor_client.putString("sales_rep_id", "null");
        spdt.editor_client.putString("default_order_type", "Invoice");
        spdt.editor_client.putBoolean("signature", true);
        spdt.editor_client.putBoolean("hide_inventory", false);
        spdt.editor_client.putString("Access_token", "Bearer " + response.getString("Access_token"));
        spdt.editor_client.putString("last_sync_date", "null");
        spdt.editor_client.putString("sales_rep_id", "null");
        spdt.editor_client.putString("first_sync", "yes");
        spdt.editor_client.commit();
        Intent i = new Intent(ctx, Main_Menu.class);
        ctx.startActivity(i);
        ((Activity) ctx).finish();

      } else if (message.equals("Unauthorized")) {
        message = "Invalid Username or password!!!";
        pb.dismiss();

      } else if (message.equals("Expired")) {
        message = "Account Expired! Please contact Customer Support to upgrade your account.";
        pb.dismiss();
      } else if (message.equals("LimitReached")) {
        message = "Limit Reached. Please contact Customer Support to upgrade your account.";
        //Toast.makeText(ctx, "Limit Reached. Please contact Customer Support to upgrade your account.", Toast.LENGTH_LONG).show();
        pb.dismiss();

      }

    } catch (JSONException e) {
      e.printStackTrace();
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
    if (message != null) {
      Toast.makeText(ctx, "" + message, Toast.LENGTH_SHORT).show();
    }
  }
}
