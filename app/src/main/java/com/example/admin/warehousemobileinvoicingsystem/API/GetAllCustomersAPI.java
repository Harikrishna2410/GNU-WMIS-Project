package com.example.admin.warehousemobileinvoicingsystem.API;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.AppController;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncGetAllCustomers;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GetAllCustomersAPI {

    Context ctx;
    SharedPreferenceForDataTransfer spdt;
    ApiUrl apiUrl;
    SyncCustomers sc;
    LogoutAPI logoutAPI;
    DbHelper dbHelper;
    //ProgressBarHandler pb;

    public GetAllCustomersAPI(Main_Menu main_menu)
    {
        this.ctx = main_menu;
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.apiUrl = new ApiUrl(ctx);
        this.sc = new SyncCustomers();
        this.logoutAPI = new LogoutAPI(main_menu);
        this.dbHelper = new DbHelper(ctx);
    }

    public GetAllCustomersAPI() {

    }
    //****************************** MAKING REQUEST TO CUSTOMERS API  **********************************************************************************

    public void GetAllCustomers_API(final Main_Menu main_menu, final ProgressBarHandler pb) {
        try{
            this.ctx = main_menu;
            final JSONObject jsonBody = new JSONObject();
            final String rep_id = spdt.pref_client.getString("sales_rep_id",null);

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, apiUrl.URL_LOCAL_JSON_ARRAY_CUST+rep_id, jsonBody, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
//                    Toast.makeText(ctx, "get customer response received" , Toast.LENGTH_SHORT).show();
                    //********************************* RESPONSE RECEIVED FROM SERVER IN JSONObject **********************************
                    //********************************* PASSING JSONOBJECT TO ASYNCHRONEOUS METHOD AsyncGetAllCustomers **********************
                    try {
                        if (response.getString("message").equals("Expired")) {

//                            LogoutAPI logoutAPI = new LogoutAPI((Main_Menu) ctx);
//                            logoutAPI.Logout_API(pb);
                        } else if (response.getString("message").equals("Success")) {
                            new AsyncGetAllCustomers(ctx, response, pb).execute();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                //*************** ERROR RESPONSE FROM SERVER *************************************************************
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"GetAllCustomersAPI : Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"GetAllCustomersAPI : The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"GetAllCustomersAPI : AuthFailureError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"GetAllCustomersAPI : Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"GetAllCustomersAPI : NoConnectionError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"GetAllCustomersAPI : Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    }
                    else
                    {
                        Toast.makeText(main_menu, "GetAllCustomersAPI : "+error.getMessage(), Toast.LENGTH_SHORT).show();
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
            AppController.getInstance().addToRequestQueue(req);
        }catch (Exception ex)
        {
            Toast.makeText(main_menu, "GetAllCustomersAPI : "+ex.getMessage(), Toast.LENGTH_SHORT).show();
            pb.dismiss();
        }
    }

}
