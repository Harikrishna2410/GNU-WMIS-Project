package com.example.admin.warehousemobileinvoicingsystem.API;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.admin.warehousemobileinvoicingsystem.Settings.SettingsActivity;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login_SettingsAPI {

    ApiUrl apiUrl;
    ProgressBarHandler pb;
    Context ctx;
    SharedPreferenceForDataTransfer spdt;
    Dialog builder;

    public Login_SettingsAPI(Main_Menu main_menu, Dialog builder) {
        this.ctx = main_menu;
        apiUrl = new ApiUrl(ctx);
        spdt = new SharedPreferenceForDataTransfer(ctx);
        this.builder = builder;
    }


    public void Login_Settings(final Main_Menu main_menu, final String get_email, final String get_pass,final ProgressBarHandler pb) {
        this.ctx = main_menu;
        this.pb = pb;
        pb.pb_load_tv.setText("Verifying...");

        try {
            final HashMap<String, String> params = new HashMap<String, String>();
            params.put("email", get_email);
            params.put("password", get_pass);

            final JSONObject jsonBody = new JSONObject();
            jsonBody.put("email", get_email);
            jsonBody.put("password",get_pass);
            //Toast.makeText(main_menu, "body = "+jsonBody.toString(), Toast.LENGTH_SHORT).show();
            JsonObjectRequest req = new JsonObjectRequest (Request.Method.POST, apiUrl.URL_LOCAL_JSON_ARRAY_LOGIN_SETTINGS, jsonBody,new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try
                    {
                        //ArrayList<SyncSalesRep> syncSalesReps = new ArrayList<>();
                        String message = response.getString("message");
                        final TextView error_msg = builder.findViewById(R.id.verification_failed_error_msg);
                        if(message.equals("Success"))
                        {
                            Intent i = new Intent(ctx, SettingsActivity.class);
                            ctx.startActivity(i);
                            ((Activity) ctx).finish();
                        }
                        else if(message.equals("Unauthorized"))
                        {
                            error_msg.setText("Invalid username or password!");
                            error_msg.setVisibility(View.VISIBLE);

                            builder.show();
                            //Toast.makeText(main_menu, "Invalid Username or password !!!", Toast.LENGTH_LONG).show();
                            pb.dismiss();

                        }
                        else if(message.equals("Expired"))
                        {
                            error_msg.setText("Invalid username or password!");
                            //Toast.makeText(main_menu, "Account Expired. Please contact support.", Toast.LENGTH_SHORT).show();
                            pb.dismiss();
                        }
                        else if(message.equals("LimitReached"))
                        {
                            error_msg.setText("Invalid username or password!");
                            //Toast.makeText(main_menu, "Limit Reached. Please contact Customer Support to upgrade your account.", Toast.LENGTH_LONG).show();
                            pb.dismiss();

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        pb.dismiss();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //Toast.makeText(mainActivity, "error"+error.toString(), Toast.LENGTH_SHORT).show();
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Login_SettingsAPI : Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"Login_SettingsAPI : The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"Login_SettingsAPI : AuthFailureError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Login_SettingsAPI : Parsing error! "+error.getMessage(),Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"Login_SettingsAPI : NoConnectionError",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Login_SettingsAPI : Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        pb.dismiss();
                    }
                    else
                    {
                        Toast.makeText(ctx, "Login_API : else ", Toast.LENGTH_SHORT).show();
                    }
                }
            }) {
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
            Toast.makeText(main_menu, "Login_SettingsAPI : "+ex.getMessage(), Toast.LENGTH_SHORT).show();
            pb.dismiss();
        }
    }

}
