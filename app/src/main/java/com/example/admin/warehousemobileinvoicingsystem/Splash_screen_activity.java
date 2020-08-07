package com.example.admin.warehousemobileinvoicingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_screen_activity extends AppCompatActivity {
  private static int SPLASH_TIME_OUT = 1000;

  SharedPreferenceForDataTransfer spdt;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen_activity);
    spdt = new SharedPreferenceForDataTransfer(this);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        if (spdt.pref_client.contains("sales_rep_id")) {
          if (!TextUtils.isEmpty(spdt.pref_client.getString("sales_rep_id", null))) {
            //Toast.makeText(Splash_screen_activity.this, "sales rep id not null redirecting to main menu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Splash_screen_activity.this, Main_Menu.class);
            startActivity(intent);
            finish();
          }
        } else {
//          Toast.makeText(Splash_screen_activity.this, "Splash screeen display", Toast.LENGTH_SHORT).show();
          Intent i = new Intent(Splash_screen_activity.this, MainActivity.class);
          startActivity(i);
          overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
          finish();
        }

      }
    }, SPLASH_TIME_OUT);

  }
}
