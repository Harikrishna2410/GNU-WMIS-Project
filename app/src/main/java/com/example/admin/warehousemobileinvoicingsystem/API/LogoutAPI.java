package com.example.admin.warehousemobileinvoicingsystem.API;

import android.app.Activity;
import android.content.*;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.*;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncLogout;

import org.json.JSONObject;
import java.io.File;
import java.util.*;

public class LogoutAPI extends AppCompatActivity {

    Context ctx;
    Activity activity;
    SharedPreferenceForDataTransfer spdt;
    ApiUrl apiUrl;
    DbHelper dbHelper;


    public LogoutAPI(Main_Menu main_menu)
    {
        this.ctx = main_menu;
        this.activity = main_menu;
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.apiUrl = new ApiUrl(ctx);
        dbHelper = new DbHelper(ctx);
    }

    //This request will send logout is clicked in the application.
    //This will also send sales rep id to reset imei in the client_devices_lisences table in db
    public void Logout_API(final ProgressBarHandler pb) {
        try{
            String sales_rep_id = spdt.pref_client.getString("sales_rep_id",null);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiUrl.URL_LOCAL_JSON_ARRAY_LOGOUT+sales_rep_id, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    new AsyncLogout(ctx,activity,response,pb).execute();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        //pb.dismiss();
                        Toast.makeText(ctx,"LogoutAPI: Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        //pb.dismiss();
                        Toast.makeText(ctx,"LogoutAPI: The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"LogoutAPI: AuthFailureError",Toast.LENGTH_SHORT).show();
                        //pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Log.e("ketan"+error.getMessage(),"hi");
                        // pb.dismiss();
                        Toast.makeText(ctx,"LogoutAPI: Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"LogoutAPI: NoConnectionError",Toast.LENGTH_SHORT).show();
                        //pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"LogoutAPI: Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        // pb.dismiss();
                    }
                    else
                    {
                        Toast.makeText(ctx, "Logout_API = "+error.getMessage(), Toast.LENGTH_LONG).show();
                        // pb.dismiss();
                    }
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authorization", spdt.pref_client.getString("Access_token",null));
                    return headers;
                }
            };

            int socketTimeout = 15000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            request.setRetryPolicy(policy);
            request.setShouldCache(false);
            AppController.getInstance().addToRequestQueue(request);
        }catch (Exception ex)  {
            //pb.dismiss();
            Toast.makeText(ctx, "LOGOUTAPI-line 1107 = "+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void ClearPrefFile_And_Database() {
        // Below code will clear both preference file and deleste database when user logs out
        File f = new File("/data/data/com.example.admin.warehousemobileinvoicingsystem/shared_prefs/PrefFileDataTransfer.xml");
        if(f.exists()) {
            spdt.editor_data_tranfer.clear();
            spdt.editor_data_tranfer.commit();
            //Toast.makeText(this, "Cleared PrefFileDataTransfer.xml ", Toast.LENGTH_SHORT).show();
        }
        File f1 = new File("/data/data/com.example.admin.warehousemobileinvoicingsystem/shared_prefs/ClientPrefFile.xml");
        if(f1.exists()) {
            spdt.editor_client.clear();
            spdt.editor_client.commit();
            //Toast.makeText(this, "Cleared ClientPrefFile.xml ", Toast.LENGTH_SHORT).show();
        }
        ctx.deleteDatabase("WMIS.db");

        //After user logs in Main_Menu class is opened.
        Intent i = new Intent(ctx, Splash_screen_activity.class);
        ctx.startActivity(i);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        spdt.editor_client.putString("sales_rep_id",null);
        spdt.editor_client.commit();
        finish();
    }


}
