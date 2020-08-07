package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.*;
import android.util.Log;
import android.view.*;
import android.widget.*;

import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.*;

public class NewCustomerRegistration extends AppCompatActivity {

  //region  ========================= GLOBAL DECLARATION SECTION =================================
  Button btn_save;
  DbHelper dbHelper;
  Toolbar toolbar;
  EditText ed_name, ed_contact, ed_gstin, ed_address, ed_city, ed_state, ed_zipcode, ed_phone, ed_email;
  TextView tv_rowID, tv_serverID;
  CheckBox cb_taxable;
  SharedPreferenceForDataTransfer spdt;
  ArrayAdapter<String> adapter;
  String customer_salestax = null;
  String edit_customer = null;
  //endregion


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_customer_registration);
    bindAllcontrols();
    dbHelper = new DbHelper(this);
    spdt = new SharedPreferenceForDataTransfer(this);
    setSupportActionBar(toolbar);

//    edit_customer = spdt.pref_data_transfer.getString("edit_customer", null);

    if (spdt.pref_data_transfer.contains("edit_customer") && spdt.pref_data_transfer.getString("edit_customer", null).equals("yes")) {
      tv_rowID.setText(getIntent().getExtras().getString("customer_row_id"));
      tv_serverID.setText(getIntent().getExtras().getString("customer_server_id"));
      ed_name.setText(getIntent().getExtras().getString("customer_name"));
      ed_contact.setText(getIntent().getExtras().getString("customer_contact"));
      ed_gstin.setText(getIntent().getExtras().getString("customer_gstin"));
      ed_address.setText(getIntent().getExtras().getString("customer_address"));
      ed_state.setText(getIntent().getExtras().getString("customer_state"));
      ed_city.setText(getIntent().getExtras().getString("customer_city"));
      ed_zipcode.setText(getIntent().getExtras().getString("customer_zip"));
      ed_phone.setText(getIntent().getExtras().getString("customer_phoneno"));
      ed_email.setText(getIntent().getExtras().getString("customer_email"));
      customer_salestax = getIntent().getExtras().getString("customer_salestax");
      cb_taxable.setChecked(getIntent().getExtras().getString("customer_is_product_tax").equals("1") ? true : false);
      Log.e("statuss", "server id = " + getIntent().getExtras().getString("server_id", null));
      cb_taxable.setClickable(getIntent().getExtras().getString("server_id") == null ? true : false);
    }

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      try {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Customer Information");
      } catch (Exception ex) {
        Toast.makeText(this, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
      }
    }

    btn_save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        validateAllData();
      }
    });
  }

  private void validateAllData() {
    if (TextUtils.isEmpty(ed_name.getText())) {
      ed_name.setError("required");
      ed_name.selectAll();
    } else if (TextUtils.isEmpty(ed_contact.getText())) {
      ed_contact.setError("required");
      ed_contact.selectAll();
    } else if (TextUtils.isEmpty(ed_address.getText())) {
      ed_address.setError("required");
      ed_address.selectAll();
    } else if (TextUtils.isEmpty(ed_city.getText())) {
      ed_city.setError("required");
      ed_city.selectAll();
    } else if (TextUtils.isEmpty(ed_state.getText())) {
      ed_state.setError("required");
      ed_state.selectAll();
    } else if (TextUtils.isEmpty(ed_zipcode.getText())) {
      ed_zipcode.setError("required");
      ed_zipcode.selectAll();
    } else if (TextUtils.isEmpty(ed_phone.getText())) {
      ed_phone.setError("required");
      ed_phone.selectAll();
    } else if (TextUtils.isEmpty(ed_email.getText())) {
      ed_email.setError("required");
      ed_email.selectAll();
    } else {
      saveAllData();
    }
  }

  private void saveAllData() {
    String currentDateTimeString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    CustModel custModel = new CustModel();
    custModel.setId(tv_rowID.getText().toString());
    custModel.setServer_id(tv_serverID.getText().toString());
    custModel.setClient_id(spdt.pref_client.getString("client_id", null));
    custModel.setName(ed_name.getText().toString());
    custModel.setContact_name(ed_contact.getText().toString());
    custModel.setGstin(ed_gstin.getText().toString());
    custModel.setAddress(ed_address.getText().toString());
    custModel.setCity(ed_city.getText().toString());
    custModel.setState(ed_state.getText().toString());
    custModel.setPostcode(ed_zipcode.getText().toString());
    custModel.setContact_no(ed_phone.getText().toString());
    custModel.setEmail(ed_email.getText().toString());
    custModel.setIs_product_tax(cb_taxable.isChecked() == true ? "1" : "0");
    custModel.setStatus("1");
    custModel.setCreated_at(currentDateTimeString);

    if (spdt.pref_data_transfer.contains("edit_customer") && spdt.pref_data_transfer.getString("edit_customer",null).equals("yes")) {
//      Toast.makeText(this, "update called", Toast.LENGTH_SHORT).show();
      dbHelper.updateCustomerInfo(NewCustomerRegistration.this, custModel);
      spdt.editor_data_tranfer.putString("edit_customer", "no");
      spdt.editor_data_tranfer.commit();
      finish();
    } else {
      Toast.makeText(this, "insert called", Toast.LENGTH_SHORT).show();
      dbHelper.insertCustomer(NewCustomerRegistration.this, custModel);
      spdt.editor_data_tranfer.putString("edit_customer", "no");
      spdt.editor_data_tranfer.commit();
      finish();
    }
  }

  private void bindAllcontrols() {

    toolbar = (Toolbar) findViewById(R.id.toolbar_productlist_activity);
    tv_rowID = findViewById(R.id.tv_form_customer_rowid);
    tv_serverID = findViewById(R.id.tv_form_customer_serverid);
    btn_save = findViewById(R.id.btn_sav_new_customer);
    ed_name = findViewById(R.id.ed_form_store_name);
    ed_gstin = findViewById(R.id.ed_form_gstin);
    ed_address = findViewById(R.id.ed_form_address);
    ed_city = findViewById(R.id.ed_form_city);
    ed_state = findViewById(R.id.ed_form_state);
    ed_zipcode = findViewById(R.id.ed_form_zipcode);
    ed_phone = findViewById(R.id.ed_form_phone);
    ed_contact = findViewById(R.id.ed_form_contact);
    ed_email = findViewById(R.id.ed_form_email);
    cb_taxable = findViewById(R.id.checkbox_form_taxable);
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
  }

}
