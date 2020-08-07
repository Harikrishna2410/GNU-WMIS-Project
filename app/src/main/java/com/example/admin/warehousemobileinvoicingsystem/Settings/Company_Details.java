package com.example.admin.warehousemobileinvoicingsystem.Settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Company_Details extends AppCompatActivity {

  TextView c_name, address, city, state, pincode, phone_no, email, person_name, tv_totalCustomers, tv_totalProducts, tv_expirydate;
  ImageButton call, email_button;
  //    SharedPreferences pref;
//    SharedPreferences.Editor editor1;
  SharedPreferenceForDataTransfer spdt;
  Toolbar toolbar;
  String total_customers = null, total_products = null;
  DbHelper dbHelper;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_company__details);
    ControllBinding();
    dbHelper = new DbHelper(this);
    spdt = new SharedPreferenceForDataTransfer(this);

    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //pref = this.getSharedPreferences(spdt.ClientPrefFile, Context.MODE_PRIVATE);
    data_setting();
    ButtonsClick();

    total_customers = dbHelper.getTotalCustomers(this);
    tv_totalCustomers.setText(total_customers);
    total_products = dbHelper.getTotalProducts(this);
    tv_totalProducts.setText(total_products);

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
  protected void onResume() {
    data_setting();
    super.onResume();

  }

  void data_setting() {

    c_name.setText(spdt.pref_client.getString("client_company_name", null));
    address.setText(spdt.pref_client.getString("client_address", null));
    city.setText(spdt.pref_client.getString("client_city", null));
    state.setText(spdt.pref_client.getString("client_state", null));
    pincode.setText(spdt.pref_client.getString("client_zip", null));
    email.setText(spdt.pref_client.getString("client_email", null));
    phone_no.setText(spdt.pref_client.getString("client_phone_no", null));
    person_name.setText(spdt.pref_client.getString("client_contact_person_name", null));

    DateFormat format = new SimpleDateFormat("YYYY-DD-MM");



    try {
      String originalString = spdt.pref_client.getString("client_expires_at", null);

      Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(originalString);

      String newDate = new SimpleDateFormat("YYYY-MM-dd").format(date);


      tv_expirydate.setText(newDate);

    }catch (ParseException e){

      e.printStackTrace();

    }

  }

  void ControllBinding() {
    dbHelper = new DbHelper(this);

    toolbar = findViewById(R.id.company_details_activity_toolbar);
    c_name = findViewById(R.id.company_details_name);
    address = findViewById(R.id.company_details_address);
    city = findViewById(R.id.company_details_city);
    state = findViewById(R.id.company_details_state);
    pincode = findViewById(R.id.company_details_pincode);
    phone_no = findViewById(R.id.company_details_phoneno);
    email = findViewById(R.id.company_details_email);
    person_name = findViewById(R.id.company_details_person_name);
    call = findViewById(R.id.company_details_call_button);
    email_button = findViewById(R.id.company_details_email_button);
    tv_totalCustomers = findViewById(R.id.company_details_total_customers);
    tv_totalProducts = findViewById(R.id.company_details_total_products);
    tv_expirydate = findViewById(R.id.company_details_expiry_date);

  }

  void ButtonsClick() {

    call.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phone_no.getText().toString().trim()));
        startActivity(intent);

      }
    });

    email_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString().trim()});
        startActivity(Intent.createChooser(intent, ""));

      }
    });

  }

}
