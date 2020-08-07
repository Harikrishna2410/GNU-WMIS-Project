package com.example.admin.warehousemobileinvoicingsystem.Settings;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.view.*;
import android.widget.*;

import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

public class Preference_Compeny_Info extends AppCompatActivity {

  Spinner appCompatSpinner;
  //    SharedPreferences pref;
//    SharedPreferences.Editor editor1;
  SharedPreferenceForDataTransfer spdt;
  TextInputEditText cmpny_name, address, state, city, zip, phone, website, email, email_body, ccme;
  Button savebtn;
  Toolbar toolbar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_preference__compeny__info);
    controllbinding();
    spdt = new SharedPreferenceForDataTransfer(this);


    appCompatSpinner = findViewById(R.id.AppCompatSpinner_list);
    ArrayAdapter<String> myad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.settings_email_software));
    myad.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
    appCompatSpinner.setAdapter(myad);

    toolbar.setTitle("Edit Customer Info");
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//
//        Sharedpreference fetching data
    //pref = this.getSharedPreferences(spdt.ClientPrefFile,Context.MODE_PRIVATE);

    sharedpreference_dataseting();

    savedatain_sharedpreference();

  }

  public void controllbinding() {

    toolbar = findViewById(R.id.activity_preference_toolbar);

    cmpny_name = findViewById(R.id.edit_companey_information_company_name);
    address = findViewById(R.id.edit_companey_information_address);
    state = findViewById(R.id.edit_companey_information_state);
    city = findViewById(R.id.edit_companey_information_city);
    zip = findViewById(R.id.edit_companey_information_zipcode);
    phone = findViewById(R.id.edit_companey_information_phoneno);
    website = findViewById(R.id.edit_companey_information_website);
    email = findViewById(R.id.edit_companey_information_email);
    email_body = findViewById(R.id.edit_companey_information_email_body);
    ccme = findViewById(R.id.edit_companey_information_ccme);
    savebtn = findViewById(R.id.save_button_companey_information);

  }

  public void sharedpreference_dataseting() {
    cmpny_name.setText(spdt.pref_client.getString("client_company_name", null));
    address.setText(spdt.pref_client.getString("client_address", null));
    state.setText(spdt.pref_client.getString("client_state", null));
    city.setText(spdt.pref_client.getString("client_city", null));
    zip.setText(spdt.pref_client.getString("client_zip", null));
    phone.setText(spdt.pref_client.getString("client_phone_no", null));

//        otherphone.setText(pref.getString("client_other_phone", null));
    //fax.setText(pref.getString("fax", null));
    website.setText(spdt.pref_client.getString("client_website", null));
    email_body.setText(spdt.pref_client.getString("email_body", null));
    email.setText(spdt.pref_client.getString("client_email", null));
    ccme.setText(spdt.pref_client.getString("ccme", null));
  }

  void savedatain_sharedpreference() {

    savebtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        //editor1 = pref.edit();

        spdt.editor_client.putString("client_company_name", cmpny_name.getText().toString().trim());
        spdt.editor_client.putString("client_address", address.getText().toString().trim());
        spdt.editor_client.putString("client_state", state.getText().toString().trim());
        spdt.editor_client.putString("client_city", city.getText().toString().trim());
        spdt.editor_client.putString("client_zip", zip.getText().toString().trim());
        spdt.editor_client.putString("client_contact_no", phone.getText().toString().trim());
        spdt.editor_client.putString("client_email", email.getText().toString().trim());
        spdt.editor_client.putString("client_website", website.getText().toString().trim());
        spdt.editor_client.putString("email_body", email_body.getText().toString().trim());
        spdt.editor_client.putString("ccme", ccme.getText().toString().trim());
        spdt.editor_client.apply();

        Toast.makeText(Preference_Compeny_Info.this, "SharedPreference Updated", Toast.LENGTH_SHORT).show();

        finish();

      }
    });

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

}
