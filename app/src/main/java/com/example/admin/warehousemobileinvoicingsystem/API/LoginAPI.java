package com.example.admin.warehousemobileinvoicingsystem.API;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.example.admin.warehousemobileinvoicingsystem.*;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncLogin;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.AppController;
import com.example.admin.warehousemobileinvoicingsystem.MainActivity;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class LoginAPI extends AppCompatActivity {
    ApiUrl apiUrl;
    ProgressBarHandler pb;
    Context ctx;
    TextView tc;

    public LoginAPI(MainActivity mainActivity,TextView textView)
    {
        this.ctx = mainActivity;
        apiUrl = new ApiUrl(ctx);
        this.tc = textView;
        apiUrl = new ApiUrl(mainActivity);
    }


    public void Login_API(final String get_email, final String get_pass, final SharedPreferenceForDataTransfer spdt, final ProgressBarHandler pb) {
        try {
            final HashMap<String, String> params = new HashMap<String, String>();
            RequestQueue queue = Volley.newRequestQueue(ctx);
            params.put("email", get_email);
            params.put("password", get_pass);

            final JSONObject jsonBody = new JSONObject();
            jsonBody.put("email", get_email);
            jsonBody.put("password",get_pass);
            JsonObjectRequest req = new JsonObjectRequest (Request.Method.POST, apiUrl.URL_LOCAL_JSON_ARRAY_LOGIN, jsonBody,new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    new AsyncLogin(ctx,response,pb).execute();


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //Toast.makeText(mainActivity, "error"+error.toString(), Toast.LENGTH_SHORT).show();
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Login_API : Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"Login_API : The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"Login_API : AuthFailureError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Login_API : Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"Login_API : NoConnectionError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Login_API : Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    }
                    else
                    {
                        Toast.makeText(ctx, "Login_API : else ", Toast.LENGTH_SHORT).show();
                    }
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("username",get_email);
                    params.put("password",get_pass);
                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    headers.put("User-agent", "My useragent");
                    return headers;
                }
            };
            //req.setRetryPolicy(new DefaultRetryPolicy( 50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            req.setShouldCache(false);
            AppController.getInstance().addToRequestQueue(req);
        }catch (Exception ex){
            Toast.makeText(ctx, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
            pb.dismiss();
        }
    }






}
