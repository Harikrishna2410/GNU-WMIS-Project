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
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncGetAllCategories;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncGetAllSuppliers;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCategories;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncSuppliers;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class GetAllCategoriesAPI {

    Context ctx;
    SharedPreferenceForDataTransfer spdt;
    ApiUrl apiUrl;
    SyncCategories sc;
    LogoutAPI logoutAPI;
    DbHelper dbHelper;
    //ProgressBarHandler pb;

    public GetAllCategoriesAPI(Context ctx) {
        this.ctx = ctx ;
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.apiUrl = new ApiUrl(ctx);
        this.dbHelper = new DbHelper(ctx);
    }
    //****************************** MAKING REQUEST TO SUPPLIERS API  **********************************************************************************

    public void GetAllCategories_API(final ProgressBarHandler pb) {
        try {
            final JSONObject jsonBody = new JSONObject();
            final String rep_id = spdt.pref_client.getString("sales_rep_id", null);

//            ***************** MAKING REQUEST *************************************
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, apiUrl.URL_LOCAL_JSON_ARRAY_CATEGORIES + rep_id, jsonBody, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    //********************************* RESPONSE RECEIVED FROM SERVER IN JSONObject **********************************
                    //********************************* PASSING JSONOBJECT TO ASYNCHRONEOUS METHOD AsyncGetAllSuppliers **********************
                    new AsyncGetAllCategories(ctx, response, pb).execute();
                }
            }, new Response.ErrorListener() {
                //*************** ERROR RESPONSE FROM SERVER *************************************************************
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx, "GetAllCategoriesAPI : Cannot connect to Internet...Please check your connection!", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx, "GetAllCategoriesAPI : The server could not be found. Please try again after some time!!", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx, "GetAllCategoriesAPI : AuthFailureError", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx, "GetAllCategoriesAPI : Parsing error! Please try again after some time!!", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx, "GetAllCategoriesAPI : NoConnectionError", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx, "GetAllCategoriesAPI : Connection TimeOut! Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else {
                        Toast.makeText(ctx, "GetAllCategoriesAPI : " + error.getMessage(), Toast.LENGTH_SHORT).show();
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
//            Toast.makeText(ctx, "GetAllCategoriesAPI : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            pb.dismiss();
        }
    }
}
