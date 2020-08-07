package com.example.admin.warehousemobileinvoicingsystem.API;

import android.content.Context;
import android.util.Log;
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
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncGetAllSuppliers;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncSuppliers;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GetAllSuppliersAPI {


    Context ctx;
    SharedPreferenceForDataTransfer spdt;
    ApiUrl apiUrl;
    SyncSuppliers ss;
    LogoutAPI logoutAPI;
    DbHelper dbHelper;
    //ProgressBarHandler pb;

    public GetAllSuppliersAPI(Context ctx) {
        this.ctx = ctx ;
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.apiUrl = new ApiUrl(ctx);
        this.dbHelper = new DbHelper(ctx);
    }
    //****************************** MAKING REQUEST TO SUPPLIERS API  **********************************************************************************

    public void GetAllSuppliers_API(final ProgressBarHandler pb) {
        try {
            final JSONObject jsonBody = new JSONObject();
            final String rep_id = spdt.pref_client.getString("sales_rep_id", null);

//            ***************** MAKING REQUEST *************************************
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, apiUrl.URL_LOCAL_JSON_ARRAY_SUPPLIERS + rep_id, jsonBody, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
//                    Toast.makeText(ctx, "getc suppliers response received" , Toast.LENGTH_SHORT).show();

                    //********************************* RESPONSE RECEIVED FROM SERVER IN JSONObject **********************************
                    //********************************* PASSING JSONOBJECT TO ASYNCHRONEOUS METHOD AsyncGetAllSuppliers **********************
                    new AsyncGetAllSuppliers(ctx, response, pb).execute();
                }
            }, new Response.ErrorListener() {
                //*************** ERROR RESPONSE FROM SERVER *************************************************************
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx, "GetAllSuppliersAPI : Cannot connect to Internet...Please check your connection!", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx, "GetAllSuppliersAPI : The server could not be found. Please try again after some time!!", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx, "GetAllSuppliersAPI : AuthFailureError", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx, "GetAllSuppliersAPI : Parsing error! Please try again after some time!!", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx, "GetAllSuppliersAPI : NoConnectionError", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx, "GetAllSuppliersAPI : Connection TimeOut! Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else {
                        Toast.makeText(ctx, "GetAllSuppliersAPI : " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    }
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Authorization", spdt.pref_client.getString("Access_token", null));
                    return params;
                }
            };
            req.setShouldCache(false);
            AppController.getInstance().addToRequestQueue(req);
        } catch (Exception ex) {
//            Toast.makeText(ctx, "GetAllSuppliersAPI : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            pb.dismiss();
        }
    }

}
