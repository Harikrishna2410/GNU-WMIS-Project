package com.example.admin.warehousemobileinvoicingsystem.API;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.AppController;
import com.example.admin.warehousemobileinvoicingsystem.Reports.Daily_Reports_Activity;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.Reports_model;

import org.json.*;

import java.util.*;

public class AllReportsAPI {

  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;

  public AllReportsAPI(Daily_Reports_Activity daily_reports_activity) {
    this.ctx = daily_reports_activity;
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.apiUrl = new ApiUrl(ctx);
  }

  public ArrayList<Reports_model> AllReports_API(final Daily_Reports_Activity daily_reports_activity, final String report_type) {
    this.ctx = daily_reports_activity;
    final ArrayList<Reports_model> reportsModel = new ArrayList<>();
    try {
      final HashMap<String, String> params = new HashMap<String, String>();
      RequestQueue queue = Volley.newRequestQueue(daily_reports_activity);
      params.put("type", report_type);

      final JSONObject jsonBody = new JSONObject();
      jsonBody.put("type", report_type);
      String sales_rep_id = spdt.pref_client.getString("sales_rep_id", null);
      final String access_token = spdt.pref_client.getString("Access_token", null);

      JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, apiUrl.URL_LOCAL_JSON_ARRAY_REPORTS + sales_rep_id, jsonBody, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
          try {
            JSONArray jsonArray = response.getJSONArray("Reportdata");
            if (jsonArray.length() > 0) {
              for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Reports_model ob = new Reports_model();
                ob.setInvoice_no(jsonObject.getString("invoice_no"));
                ob.setName(jsonObject.getString("name"));
                ob.setQty(jsonObject.getString("totalqty"));
                ob.setTax(jsonObject.getString("totaltax").equals("null") ? "0" : jsonObject.getString("totaltax"));
                ob.setTotal(jsonObject.getString("total").equals("null") ? "0" : jsonObject.getString("total"));
                reportsModel.add(ob);
              }
              daily_reports_activity.setReportData(reportsModel);
            } else {
              Toast.makeText(daily_reports_activity, "No Orders.", Toast.LENGTH_SHORT).show();
              daily_reports_activity.dialog.dismiss();
            }

          } catch (Exception ex) {
            Toast.makeText(daily_reports_activity, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
          }
        }
      }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
          if (error instanceof NetworkError) {
            Toast.makeText(ctx, "AllReportsAPI : Cannot connect to Internet...Please check your connection!", Toast.LENGTH_SHORT).show();
          } else if (error instanceof ServerError) {
            Toast.makeText(ctx, "AllReportsAPI : The server could not be found. Please try again after some time!!", Toast.LENGTH_SHORT).show();
          } else if (error instanceof AuthFailureError) {
            Toast.makeText(ctx, "AllReportsAPI : AuthFailureError", Toast.LENGTH_SHORT).show();
          } else if (error instanceof ParseError) {
            Toast.makeText(ctx, "AllReportsAPI : Parsing error! Please try again after some time!!", Toast.LENGTH_SHORT).show();
          } else if (error instanceof NoConnectionError) {
            Toast.makeText(ctx, "AllReportsAPI : NoConnectionError", Toast.LENGTH_SHORT).show();
          } else if (error instanceof TimeoutError) {
            Toast.makeText(ctx, "AllReportsAPI : Connection TimeOut! Please check your internet connection.", Toast.LENGTH_SHORT).show();
          } else {
            Toast.makeText(ctx, "AllReportsAPI : " + error.getMessage(), Toast.LENGTH_LONG).show();
          }
        }
      }) {
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
          Map<String, String> headers = new HashMap<String, String>();
          headers.put("Authorization", access_token);
          return headers;
        }
      };
      req.setShouldCache(false);
      AppController.getInstance().addToRequestQueue(req);

    } catch (Exception ex) {
      Toast.makeText(ctx, "AllReportsAPI : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
    }
    daily_reports_activity.ob = reportsModel;
    return reportsModel;
  }
}
