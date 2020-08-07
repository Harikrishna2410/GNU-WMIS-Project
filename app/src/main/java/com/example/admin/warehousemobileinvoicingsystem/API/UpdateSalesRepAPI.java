package com.example.admin.warehousemobileinvoicingsystem.API;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.*;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncUpdateSalesRep;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncSalesRep;
import org.json.*;
import java.util.*;

public class UpdateSalesRepAPI {

    Context ctx;
    ApiUrl apiUrl;
    SharedPreferenceForDataTransfer spdt;
    DbHelper dbHelper;

    public UpdateSalesRepAPI(Main_Menu main_menu) {
        this.ctx = main_menu;
        this.apiUrl = new ApiUrl(ctx);
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.dbHelper = new DbHelper(ctx);
    }


    public void UpdateSalesRep_API(final Main_Menu main_menu, final ProgressBarHandler pb) {
        this.ctx = main_menu;
        try{
            final JSONObject jsonBody = new JSONObject();
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, apiUrl.URL_LOCAL_JSON_ARRAY_ALL_SALESREP, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    new AsyncUpdateSalesRep(ctx,response,pb).execute();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"UpdateSalesRep_API : Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"UpdateSalesRep_API : The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"UpdateSalesRep_API : AuthFailureError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"UpdateSalesRep_API : Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"UpdateSalesRep_API : NoConnectionError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"UpdateSalesRep_API : Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    }
                    else
                    {
                        Toast.makeText(ctx, "UpdateSalesRep_API : line 85"+error.getMessage(), Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    }

                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Authorization",spdt.pref_client.getString("Access_token",null));
                    return params;
                }
            };
            req.setShouldCache(false);
            int socketTimeout = 50000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            req.setRetryPolicy(policy);
            AppController.getInstance().addToRequestQueue(req);
        }catch (Exception ex){
            Toast.makeText(main_menu, "UpdateSalesRep_API : line 100"+ex.getMessage(), Toast.LENGTH_SHORT).show();
            pb.dismiss();
        }

    }
}
