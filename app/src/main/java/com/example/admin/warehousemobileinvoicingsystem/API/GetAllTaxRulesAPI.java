package com.example.admin.warehousemobileinvoicingsystem.API;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.*;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncGetAllCustomers;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncGetAllTaxRules;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncTaxRules;
import org.json.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetAllTaxRulesAPI {

    Context ctx;
    SharedPreferenceForDataTransfer spdt;
    ApiUrl apiUrl;
    DateFormat dateFormat;
    DbHelper dbHelper;
    ProgressBarHandler pb;


    public GetAllTaxRulesAPI(Context ctx)
    {
        this.ctx = ctx;
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.apiUrl = new ApiUrl(ctx);
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dbHelper = new DbHelper(ctx);
    }

    public void GetAllTaxRules_API(final ProgressBarHandler pb) {
        try{
            final JSONObject jsonBody = new JSONObject();
            String rep_id = spdt.pref_client.getString("sales_rep_id",null);
            final String access_token = spdt.pref_client.getString("Access_token",null);

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, apiUrl.URL_LOCAL_JSON_ARRAY_TAXRULES+rep_id, jsonBody, new Response.Listener<JSONObject>()
            {
                @Override
                public void onResponse(JSONObject response) {
//                    Toast.makeText(ctx, "getc tax rules response received" , Toast.LENGTH_SHORT).show();

                    new AsyncGetAllTaxRules(ctx,response,pb).execute();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"GetAllTaxRulesAPI : Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"GetAllTaxRulesAPI : The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"GetAllTaxRulesAPI : AuthFailureError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"GetAllTaxRulesAPI : Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"GetAllTaxRulesAPI : NoConnectionError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"GetAllTaxRulesAPI : Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    }
                    else
                    {
                        pb.dismiss();
                        Toast.makeText(ctx, "GetAllTaxRulesAPI :  "+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Authorization",access_token);
                    return params;
                }
            };
            req.setShouldCache(false);
            AppController.getInstance().addToRequestQueue(req);
        }catch (Exception ex){
            Toast.makeText(ctx, "GetAllTaxRules_API : "+ex.getMessage(), Toast.LENGTH_SHORT).show();
            pb.dismiss();
        }
    }
}
