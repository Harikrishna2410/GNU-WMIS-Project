package com.example.admin.warehousemobileinvoicingsystem.Settings;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.warehousemobileinvoicingsystem.API.LogoutAPI;
import com.example.admin.warehousemobileinvoicingsystem.Customers.NewCustomerRegistration;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.R;

public class SettingsActivity extends AppCompatActivity {


  androidx.appcompat.widget.Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);

    toolbar = findViewById(R.id.settings_activity_toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Settings");
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    getFragmentManager().beginTransaction().replace(R.id.fragment_layout_setting, new SettingsFragments()).commit();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        return true;
    }

    return super.onOptionsItemSelected(item);
  }


  @Override
  public void onBackPressed() {

    final Dialog logout_dialog = new Dialog(this);
    logout_dialog.setContentView(R.layout.exit_dialog_layout);
    logout_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    int width = ViewGroup.LayoutParams.MATCH_PARENT;
    int height = ViewGroup.LayoutParams.WRAP_CONTENT;
    logout_dialog.getWindow().setLayout(width, height);

    ImageView logout_image = logout_dialog.findViewById(R.id.logoutdialogimage);
    TextView logout_heading = logout_dialog.findViewById(R.id.logoutdialogheading);
    TextView logout_txt = logout_dialog.findViewById(R.id.logoutdialogtxt);
    Button yesbtn = logout_dialog.findViewById(R.id.exit_dialog_btn_yes);
    Button nobtn = logout_dialog.findViewById(R.id.exit_dialog_btn_no);

    logout_image.setImageResource(R.drawable.outline_exit_to_app_blue_900_48dp);
    logout_heading.setText("Settings?");
    logout_txt.setText("Are you sure you want to Exit from Setting?");

    yesbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(SettingsActivity.this, Main_Menu.class);
        startActivity(intent);
        finish();
      }
    });
    nobtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        logout_dialog.dismiss();
      }
    });

    logout_dialog.show();


  }
}
