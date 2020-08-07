package com.example.admin.warehousemobileinvoicingsystem.API;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.*;
import com.example.admin.warehousemobileinvoicingsystem.Customers.Customer_List;
import com.example.admin.warehousemobileinvoicingsystem.Customers.Customer_new_order;
import com.example.admin.warehousemobileinvoicingsystem.Customers.NewCustomerRegistration;
import com.example.admin.warehousemobileinvoicingsystem.Orders.Orders_List_Activity;
import com.google.gson.JsonObject;

import org.json.*;

import java.util.*;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class GetCustomerCountAPI {

  Context ctx;
  Activity activity;
  ApiUrl apiUrl;
  SharedPreferenceForDataTransfer spdt;
  ProgressBarHandler pb;

  public GetCustomerCountAPI(Main_Menu main_menu) {
    this.ctx = main_menu;
    this.activity = main_menu;
    apiUrl = new ApiUrl(ctx);
    spdt = new SharedPreferenceForDataTransfer(ctx);
  }

  public GetCustomerCountAPI(Customer_List customerList) {
    this.ctx = customerList;
    this.activity = customerList;
    apiUrl = new ApiUrl(ctx);
    spdt = new SharedPreferenceForDataTransfer(ctx);
  }

  public void GetCustomerCountAPI(final ProgressBarHandler pb) {
    JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, apiUrl.URL_LOCAL_JSON_ARRAY_GETCUSTOMERCOUNT, null, new Response.Listener<JSONObject>() {
      @Override
      public void onResponse(JSONObject response) {
        try {
          if (response.get("Message").equals("Limit Reached")) {
            pb.dismiss();

//            new SweetAlertDialog(ctx, SweetAlertDialog.ERROR_TYPE)
//                    .setTitleText("Max Limit Reached")
//                    .setContentText("Please contact support for more information at support@invoit.in")
//                    .setConfirmText("OK")
//                    .show();

            showAlertDialog(ctx);


          } else {
            pb.dismiss();
            Intent intent = new Intent(ctx, NewCustomerRegistration.class);
            ctx.startActivity(intent);
            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            spdt.editor_data_tranfer.putString("Limit Reached", "yes");
            spdt.editor_data_tranfer.commit();
          }
        } catch (JSONException e) {
          e.printStackTrace();
        }
      }

      private void showAlertDialog(Context ctx) {

        String heading = "Limit Reached";
        String desc = "Please contact support at support@invoit.in";
        int drawable = com.example.admin.warehousemobileinvoicingsystem.R.drawable.outline_cancel_presentation_blue_900_24dp;
        MyGlobals.setAlertDialog(ctx, drawable, heading, desc,0,1,"OK",null);
      } //  showAlertDialog end


    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        pb.dismiss();
        if (error instanceof NetworkError) {
          Toast.makeText(ctx, "NewCustomerAPI : Cannot connect to Internet...Please check your connection!", Toast.LENGTH_SHORT).show();
        } else if (error instanceof ServerError) {
          Toast.makeText(ctx, "NewCustomerAPI : The server could not be found. Please try again after some time!!", Toast.LENGTH_SHORT).show();
        } else if (error instanceof AuthFailureError) {
          Toast.makeText(ctx, "NewCustomerAPI : AuthFailureError", Toast.LENGTH_SHORT).show();
        } else if (error instanceof ParseError) {
          Toast.makeText(ctx, "NewCustomerAPI : Parsing error! Please try again after some time!!", Toast.LENGTH_SHORT).show();
        } else if (error instanceof NoConnectionError) {
          Toast.makeText(ctx, "NewCustomerAPI : NoConnectionError", Toast.LENGTH_SHORT).show();
        } else if (error instanceof TimeoutError) {
          Toast.makeText(ctx, "NewCustomerAPI : Connection TimeOut! Please check your internet connection.", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(ctx, "NewCustomerAPI : " + error.getMessage(), Toast.LENGTH_LONG).show();
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
    RetryPolicy policy = new DefaultRetryPolicy(1500, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    req.setRetryPolicy(policy);
    req.setShouldCache(false);
    AppController.getInstance().addToRequestQueue(req);


  }

}
