package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.content.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.*;

import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

public class Order_pay_activity extends AppCompatActivity {

  //region ==================================  GLOBAL DECLARATION SECTION  ======================================================
  Spinner onaccount;
  EditText notes;
  TextView incoiceno, amount, tv_title, tv_notes;
  //    SharedPreferences pref,pref1;
//    SharedPreferences.Editor editor,editor1;
  SharedPreferenceForDataTransfer spdt;
  Button save;
  Spinner spinner;
  Toolbar toolbar67;
  //endregion

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_pay_activity);
    setSupportActionBar(toolbar67);

        /*if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/
    ControllBinding();
    spdt = new SharedPreferenceForDataTransfer(this);
//        pref = getSharedPreferences(spdt.ClientPrefFile,MODE_PRIVATE);
//        pref1  = getSharedPreferences(spdt.PrefFileDataTransfer,MODE_PRIVATE);
//        editor1 = pref1.edit();
    Bundle bundle = getIntent().getExtras();
    incoiceno.setText(bundle.getString("tv_invoiceno"));
    tv_title.setText(bundle.getString("tv_title"));
    amount.setText(bundle.getString("tv_totalwithtax"));

    //===========Setting Spinner
    String[] payment_type_list = {"CASH", "CHEQUE"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, payment_type_list);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);


    if (spdt.pref_data_transfer.getString("side", null).equals("orderside")) {
      DbHelper dbHelper = new DbHelper(this);
      String notes = dbHelper.getNotes(incoiceno.getText().toString());

      if (notes != null && notes.equals("null")) {
        tv_notes.setText("");
      } else {
        tv_notes.setText(notes);
      }
    }

    save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        if (spdt.pref_client.getBoolean("signature", false) == true) {
          Intent intent = new Intent(Order_pay_activity.this, Activity_Signature.class);
          intent.putExtra("orderno", incoiceno.getText().toString());
          intent.putExtra("invoice_type", tv_title.getText().toString());
//                    intent.putExtra("notes",tv_notes.getText().toString());
          spdt.editor_data_tranfer.putString("notes", tv_notes.getText().toString());
          spdt.editor_data_tranfer.commit();
          startActivityForResult(intent, 1);
          overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        } else {
          //Toast.makeText(Order_pay_activity.this, "Signature Settings Disabled", Toast.LENGTH_SHORT).show();
          Intent returnIntent = new Intent();
          setResult(RESULT_OK, returnIntent);
          finish();
        }
      }
    });
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == 1 && resultCode == RESULT_OK) {
      Intent returnIntent = new Intent();
      setResult(RESULT_OK, returnIntent);
      finish();
    }
  }

  public void ControllBinding() {
    toolbar67 = findViewById(R.id.orderpayavtivity_toolbar);
    setSupportActionBar(toolbar67);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);


    notes = findViewById(R.id.pay_activity_notes);
    incoiceno = findViewById(R.id.pay_activity_invoice_no);
    amount = findViewById(R.id.pay_activity_amount);
    save = findViewById(R.id.btn_order_pay_activity_save_and_pay);
    tv_title = findViewById(R.id.tv_title_invoiceno_estimate_salesorder);
    tv_notes = findViewById(R.id.pay_activity_notes);
    spinner = findViewById(R.id.spinner_payment_type);
  }

}
