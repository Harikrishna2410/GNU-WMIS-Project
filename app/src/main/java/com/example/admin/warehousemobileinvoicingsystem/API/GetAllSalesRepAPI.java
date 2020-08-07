package com.example.admin.warehousemobileinvoicingsystem.API;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.*;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncGetAllSalesrep;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncSalesRep;
import org.json.*;
import java.util.*;

public class GetAllSalesRepAPI {

    Context ctx;
    SharedPreferenceForDataTransfer spdt;
    ApiUrl apiUrl;
    DbHelper dbHelper;
    Main_Menu main_menu;
    ProgressBarHandler pb;

    public GetAllSalesRepAPI(Context ctx)
    {
        this.ctx = ctx;
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.apiUrl = new ApiUrl(ctx);
        this.dbHelper = new DbHelper(ctx);
        this.main_menu = new Main_Menu();
    }

    //This function will get all sales rep and store it in a local Database.
    public void GetAllSalesRep_API(final ProgressBarHandler pb) {
        try{
            final JSONObject jsonBody = new JSONObject();

            String rep_id = spdt.pref_client.getString("sales_rep_id",null);
            final String access_token = spdt.pref_client.getString("Access_token",null);

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, apiUrl.URL_LOCAL_JSON_ARRAY_SALESREP+rep_id, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response){
//                    Toast.makeText(ctx, "getc sales rep response received" , Toast.LENGTH_SHORT).show();
                    Log.e("statuss",response.toString());

                    new AsyncGetAllSalesrep(ctx,response,pb).execute();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"GetAllSalesRepAPI : Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"GetAllSalesRepAPI : The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"GetAllSalesRepAPI : AuthFailureError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"GetAllSalesRepAPI : Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"GetAllSalesRepAPI : NoConnectionError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"GetAllSalesRepAPI : Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    }
                    else
                    {
                        Toast.makeText(main_menu, "GetAllSalesRepAPI :  "+error.getMessage(), Toast.LENGTH_SHORT).show();
                        pb.dismiss();
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
            Toast.makeText(ctx, "GetAllSalesRepAPI : "+ex.getMessage(), Toast.LENGTH_SHORT).show();
            pb.dismiss();
        }

    }

}
