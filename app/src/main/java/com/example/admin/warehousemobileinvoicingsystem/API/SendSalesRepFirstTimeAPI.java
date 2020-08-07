package com.example.admin.warehousemobileinvoicingsystem.API;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.*;
import org.json.*;
import java.util.*;

public class SendSalesRepFirstTimeAPI {

    Context ctx;
    ApiUrl apiUrl;
    SharedPreferenceForDataTransfer spdt;

    public SendSalesRepFirstTimeAPI(Main_Menu main_menu)
    {
        this.ctx = main_menu;
        this.apiUrl = new ApiUrl(ctx);
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
    }

    // This method will send selected sales rep and get Last invoice/estimate/salesorder and set in view
    public void SendSalesRepFirstTime_API(final Main_Menu main_menu, final String sales_rep_id, final String access_token, String imei) {

        final JSONObject jsonBody = new JSONObject();
//        Toast.makeText(main_menu, "selected rep = "+sales_rep_id+" - "+imei, Toast.LENGTH_SHORT).show();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,apiUrl.URL_LOCAL_JSON_ARRAY_NEWLOGIN+sales_rep_id+"-"+imei,jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
//                Toast.makeText(ctx, "get first time sales rep response received"+response.toString() , Toast.LENGTH_LONG).show();

                try {
                    //now saving sales rep id in pref file
                    spdt.editor_client.putString("sales_rep_id",sales_rep_id);

                    String invoice_no = response.getString("LastInvoiceno");
                    String estimate_no = response.getString("LastEstimateno");
                    String sales_orderno = response.getString("LastSalesorderno");
                    //Toast.makeText(main_menu, ""+invoice_no+estimate_no+sales_orderno, Toast.LENGTH_SHORT).show();
                    if(invoice_no.equals("")) {
                        spdt.editor_client.putString("client_invoice_no","0");
                    } else {
                        spdt.editor_client.putString("client_invoice_no",invoice_no);
                    }

                    if(estimate_no.equals("")) {
                        spdt.editor_client.putString("client_estimate_no","0");
                    }else{
                        spdt.editor_client.putString("client_estimate_no",estimate_no);
                    }

                    if(sales_orderno.equals("")) {
                        spdt.editor_client.putString("client_sales_order_no","0");
                    }else{
                        spdt.editor_client.putString("client_sales_order_no",sales_orderno);
                    }

                    spdt.editor_client.commit();
                    //main_menu.reportdialog.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                if (error instanceof NetworkError) {
                    Toast.makeText(ctx,"SendSalesRepFirstTimeAPI : Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    //main_menu.dialog.dismiss();
                } else if (error instanceof ServerError) {
                    Toast.makeText(ctx,"SendSalesRepFirstTimeAPI : The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    //main_menu.dialog.dismiss();
                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(ctx,"SendSalesRepFirstTimeAPI : AuthFailureError",Toast.LENGTH_SHORT).show();
                    //main_menu.dialog.dismiss();
                } else if (error instanceof ParseError) {
                    Toast.makeText(ctx,"SendSalesRepFirstTimeAPI : Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    //main_menu.dialog.dismiss();
                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(ctx,"SendSalesRepFirstTimeAPI : NoConnectionError",Toast.LENGTH_SHORT).show();
                   //main_menu.dialog.dismiss();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(ctx,"SendSalesRepFirstTimeAPI : Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    //main_menu.dialog.dismiss();
                }
                else
                {
                    Toast.makeText(ctx, "SendSalesRepFirstTimeAPI : "+error.getMessage(), Toast.LENGTH_LONG).show();
                    //main_menu.dialog.dismiss();
                }
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Authorization",access_token);
                headers.put("Content-Type", "application/json");
                return headers;
            }
        };
        req.setShouldCache(false);
        AppController.getInstance().addToRequestQueue(req);


    }
}
