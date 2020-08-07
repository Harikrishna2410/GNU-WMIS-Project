package com.example.admin.warehousemobileinvoicingsystem.API;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.*;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncGetAllProducts;
import com.example.admin.warehousemobileinvoicingsystem.Products.ProductModel;
import org.json.*;
import java.util.*;

public class GetAllProductsAPI {

    Context ctx;
    SharedPreferenceForDataTransfer spdt;
    ApiUrl apiUrl;
    DbHelper dbHelper;
    ProgressBarHandler pb;


    public GetAllProductsAPI(Context ctx)
    {
        this.ctx = ctx ;
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.apiUrl = new ApiUrl(ctx);
        this.dbHelper = new DbHelper(ctx);
    }


    public void GetAllProducts_API(final ProgressBarHandler pb) {
        try{
            final JSONObject jsonBody = new JSONObject();
            String sales_rep = spdt.pref_client.getString("sales_rep_id", null);

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, apiUrl.URL_LOCAL_JSON_ARRAY_PRODUCT+sales_rep, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response){
//                    Toast.makeText(ctx, "get products response received" , Toast.LENGTH_SHORT).show();
                    new AsyncGetAllProducts(ctx,response,pb).execute();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"GetAllProducts_API : Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"GetAllProducts_API : The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"GetAllProducts_API : AuthFailureError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"GetAllProducts_API : Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"GetAllProducts_API : NoConnectionError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"GetAllProducts_API : Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    }
                    else
                    {
                        Toast.makeText(ctx, " GetAllProducts_API : makeJsonArrayRequest_products Response error "+error.getMessage(), Toast.LENGTH_SHORT).show();
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
        }catch (Exception ex){
            Toast.makeText(this.ctx, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
            pb.dismiss();
        }
    }
}
