package com.example.admin.warehousemobileinvoicingsystem.API;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.*;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncNewCustomer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.*;

import org.joda.time.DateTime;
import org.joda.time.format.*;
import org.json.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class NewCustomerAPI {

  Context ctx;
  Activity activity;
  ApiUrl apiUrl;
  SharedPreferenceForDataTransfer spdt;
  ProgressBarHandler pb;

  public NewCustomerAPI(Main_Menu main_menu) {
    this.ctx = main_menu;
    this.activity = main_menu;
    apiUrl = new ApiUrl(ctx);
    spdt = new SharedPreferenceForDataTransfer(ctx);
  }

  public void NewCustomer_API(final Main_Menu main_menu, final ArrayList<SyncCustomers> syncCustomers, final ProgressBarHandler pb) {

    try {
      //Toast.makeText(main_menu, "sending new customers", Toast.LENGTH_SHORT).show();
      final JSONObject jsonBody = new JSONObject();
      JSONArray jsonArray = new JSONArray();
      for (int i = 0; i < syncCustomers.size(); i++) {
        JSONObject customers = new JSONObject();
        customers.put("id", syncCustomers.get(i).getId());
        customers.put("name", syncCustomers.get(i).getName());
        customers.put("contact_name", syncCustomers.get(i).getContact_name());
        customers.put("gstin", syncCustomers.get(i).getGstin());
        customers.put("email", syncCustomers.get(i).getEmail());
        customers.put("address", syncCustomers.get(i).getAddress());
        customers.put("city", syncCustomers.get(i).getCity());
        customers.put("state", syncCustomers.get(i).getState());
        customers.put("postcode", syncCustomers.get(i).getPostcode());
        customers.put("contact_no", syncCustomers.get(i).getContact_no());
        customers.put("status", syncCustomers.get(i).getStatus());
        customers.put("is_product_tax", syncCustomers.get(i).getIs_product_tax());
        String currentDateTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        customers.put("created_at", currentDateTimeString);
        jsonArray.put(i, customers);
        //Toast.makeText(main_menu, "Adding new Customer....", Toast.LENGTH_SHORT).show();
      }
      jsonBody.put("customers", jsonArray);
      Log.e("statuss", "body = " + jsonBody);
      Log.d("tagg", jsonBody.toString(4));
      Toast.makeText(main_menu, "sending new customer to new customer api", Toast.LENGTH_SHORT).show();

      JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, apiUrl.URL_LOCAL_JSON_ARRAY_SENDNEWCUSTOMERS, jsonBody, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
//          Toast.makeText(main_menu, "new customer response received" + response, Toast.LENGTH_SHORT).show();
          Log.e("kj", response.toString());
          new AsyncNewCustomer(ctx, response, pb).execute();
        }
      }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
          if (error instanceof NetworkError) {
            Toast.makeText(ctx, "NewCustomerAPI : Cannot connect to Internet...Please check your connection!", Toast.LENGTH_SHORT).show();
//                        NewCustomerAPI.this.pb.dismiss();
          } else if (error instanceof ServerError) {
            Toast.makeText(ctx, "NewCustomerAPI : The server could not be found. Please try again after some time!!", Toast.LENGTH_SHORT).show();
//                        NewCustomerAPI.this.pb.dismiss();
          } else if (error instanceof AuthFailureError) {
            Toast.makeText(ctx, "NewCustomerAPI : AuthFailureError", Toast.LENGTH_SHORT).show();
//                        NewCustomerAPI.this.pb.dismiss();
          } else if (error instanceof ParseError) {
            Toast.makeText(ctx, "NewCustomerAPI : Parsing error! Please try again after some time!!", Toast.LENGTH_SHORT).show();
//                        NewCustomerAPI.this.pb.dismiss();
          } else if (error instanceof NoConnectionError) {
            Toast.makeText(ctx, "NewCustomerAPI : NoConnectionError", Toast.LENGTH_SHORT).show();
//                        NewCustomerAPI.this.pb.dismiss();
          } else if (error instanceof TimeoutError) {
            Toast.makeText(ctx, "NewCustomerAPI : Connection TimeOut! Please check your internet connection.", Toast.LENGTH_SHORT).show();
//                        NewCustomerAPI.this.pb.dismiss();
          } else {
            Toast.makeText(ctx, "NewCustomerAPI : " + error.getMessage(), Toast.LENGTH_LONG).show();
            NewCustomerAPI.this.pb.dismiss();
          }
        }
      }) {
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
          Map<String, String> headers = new HashMap<String, String>();
          headers.put("Authorization", spdt.pref_client.getString("Access_token", null));
          headers.put("Content-Type", "application/json");
          return headers;
        }
      };
//      int socketTimeout = 15000 * syncCustomers.size();
//      RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
//      req.setRetryPolicy(policy);
      req.setShouldCache(false);
      AppController.getInstance().addToRequestQueue(req);
    } catch (JSONException e) {
      e.printStackTrace();
      this.pb.dismiss();
      Toast.makeText(ctx, "NewCustomerAPI : " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
  }
}
