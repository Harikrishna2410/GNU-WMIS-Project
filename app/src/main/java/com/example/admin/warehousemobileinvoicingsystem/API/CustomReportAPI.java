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

public class CustomReportAPI {

    Context ctx;
    SharedPreferenceForDataTransfer spdt;
    ApiUrl apiUrl;

    public CustomReportAPI(Daily_Reports_Activity daily_reports_activity) {
        this.ctx = daily_reports_activity;
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.apiUrl = new ApiUrl(ctx);
    }


    public ArrayList<Reports_model> CustomReport_API(final Daily_Reports_Activity daily_reports_activity, String report_type, String start_date, String end_date)
    {

        this.ctx = daily_reports_activity;
        final ArrayList<Reports_model> reportsModel = new ArrayList<>();
        try {
            final HashMap<String, String> params = new HashMap<String, String>();
            RequestQueue queue = Volley.newRequestQueue(daily_reports_activity);
            params.put("type", report_type);
            params.put("fromdate", start_date);
            params.put("todate", end_date);
            final JSONObject jsonBody = new JSONObject();
            jsonBody.put("type", report_type);
            jsonBody.put("fromdate", start_date);
            jsonBody.put("todate", end_date);
//            pref = daily_reports_activity.getSharedPreferences(spdt.ClientPrefFile, MODE_PRIVATE);
//            String sales_rep_id = pref.getString("sales_rep_id", null);
            String sales_rep_id = spdt.pref_client.getString("sales_rep_id", null);
            final String access_token = spdt.pref_client.getString("Access_token",null);
//            Toast.makeText(daily_reports_activity, "jsobonbody = "+report_type, Toast.LENGTH_SHORT).show();

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, apiUrl.URL_LOCAL_JSON_ARRAY_REPORTS + sales_rep_id, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //Toast.makeText(ctx, ""+response.toString(), Toast.LENGTH_SHORT).show();

                    try {
                        JSONArray jsonArray = response.getJSONArray("Reportdata");
                        if (jsonArray.length() > 0)
                        {
                            //syncCustomers.clear();
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                //Toast.makeText(daily_reports_activity, ""+jsonObject.getString("name"), Toast.LENGTH_SHORT).show();
                                Reports_model ob = new Reports_model();
                                ob.setInvoice_no(jsonObject.getString("invoice_no"));
                                ob.setName(jsonObject.getString("name"));
                                ob.setQty(jsonObject.getString("totalqty"));
                                ob.setTax(jsonObject.getString("totaltax"));
                                ob.setTotal(jsonObject.getString("total"));
                                reportsModel.add(ob);
                            }
                            daily_reports_activity.setReportData(reportsModel);
                        }
                        else
                        {
                            Toast.makeText(daily_reports_activity, "No Orders.", Toast.LENGTH_SHORT).show();
                        }

                    }catch (Exception ex)
                    {
                        Toast.makeText(daily_reports_activity, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"CustomReportAPI : Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"CustomReportAPI : The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"CustomReportAPI : AuthFailureError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"CustomReportAPI : Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"CustomReportAPI : NoConnectionError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"CustomReportAPI : Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(ctx, "CustomReportAPI : "+error.getMessage(), Toast.LENGTH_LONG).show();
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

        }
        daily_reports_activity.ob = reportsModel;
        return reportsModel;
    }




}
