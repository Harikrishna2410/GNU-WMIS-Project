package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.GetSignatureFile;
import com.example.admin.warehousemobileinvoicingsystem.MainActivity;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Slider_activity;
import com.example.admin.warehousemobileinvoicingsystem.Splash_screen_activity;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;

import org.json.JSONObject;

import java.io.File;

public class AsyncLogout extends AsyncTask<String, Integer, String> {

  Context ctx;
  Activity activity;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCustomers sc;
  ProgressBarHandler pb;
  JSONObject response;
  String message = null;

  public AsyncLogout(Context ctx, Activity activity, JSONObject response, ProgressBarHandler pb) {
    this.ctx = ctx;
    this.activity = activity;
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.apiUrl = new ApiUrl(ctx);
    this.dbHelper = new DbHelper(ctx);
    this.sc = new SyncCustomers();
    this.pb = pb;
    this.response = response;

  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
  }

  @Override
  protected String doInBackground(String... strings) {
    processResponse();
    return null;
  }

  private void processResponse() {
    try {
      String messaage = response.getString("message");
      switch (messaage) {
        case "Success":
          //pb.dismiss();
          ClearPrefFile_And_Database();
          break;
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "LOGOUTAPI : line 1066 :  " + ex.getMessage(), Toast.LENGTH_SHORT).show();
      ex.printStackTrace();
      // pb.dismiss();
    }
  }

  private void ClearPrefFile_And_Database() {
    // Below code will clear both preference file and deleste database when user logs out
    File f = new File("/data/data/com.example.admin.warehousemobileinvoicingsystem/shared_prefs/PrefFileDataTransfer.xml");
    if (f.exists()) {
      spdt.editor_data_tranfer.clear();
      spdt.editor_data_tranfer.commit();
      //Toast.makeText(this, "Cleared PrefFileDataTransfer.xml ", Toast.LENGTH_SHORT).show();
    }
    File f1 = new File("/data/data/com.example.admin.warehousemobileinvoicingsystem/shared_prefs/ClientPrefFile.xml");
    if (f1.exists()) {
      spdt.editor_client.clear();
      spdt.editor_client.commit();
      //Toast.makeText(this, "Cleared ClientPrefFile.xml ", Toast.LENGTH_SHORT).show();
    }
    ctx.deleteDatabase("WMIS.db");
  }

  protected void onProgressUpdate(Integer... values) {
    super.onProgressUpdate(values);
  }

  @Override
  protected void onPostExecute(String s) {
    super.onPostExecute(s);
    //Clear signature files if there ?
    GetSignatureFile getSignatureFile = new GetSignatureFile(ctx);
    getSignatureFile.deleteSignatureFile();
    Toast.makeText(ctx, "Logged out Successfully.", Toast.LENGTH_LONG).show();

    //After user logs in Main_Menu class is opened.
    Intent i = new Intent(ctx, MainActivity.class);
    ctx.startActivity(i);
    activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    activity.finish();

  }


}
