package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.content.*;
import android.graphics.Bitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.*;

import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.github.gcacace.signaturepad.views.SignaturePad;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Activity_Signature extends AppCompatActivity {

  //region ====================================  GLOBAL DECLARATION AREA  ========================================================
  Button clear, save;
  SignaturePad signaturePad;
  SharedPreferenceForDataTransfer spdt;
  Toolbar custom_toolbar;
  //endregion

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity__signature);
    controlbinding();
    spdt = new SharedPreferenceForDataTransfer(this);

    clear.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        signaturePad.clear();
      }
    });

    save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        if (signaturePad.isEmpty()) {
          Toast.makeText(Activity_Signature.this, "Signature Required.", Toast.LENGTH_SHORT).show();
        } else {

          if (spdt.pref_data_transfer.getString("side", null).equals("orderside")) {
            savetointernalstorate(signaturePad.getTransparentSignatureBitmap());
            Intent returnIntent = new Intent();
            setResult(RESULT_OK, returnIntent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
          } else if (spdt.pref_data_transfer.getString("side", null).equals("customerside")) {
            savetointernalstorate(signaturePad.getTransparentSignatureBitmap());
            Intent returnIntent = new Intent();
            setResult(RESULT_OK, returnIntent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
          }
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

  public void controlbinding() {
    custom_toolbar = findViewById(R.id.orderpayavtivity_toolbar);
    setSupportActionBar(custom_toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);


    signaturePad = findViewById(R.id.signature_pad);
    clear = findViewById(R.id.btn_activity_signature_clear);
    save = findViewById(R.id.btn_activity_signature_save);
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }

  private String savetointernalstorate(Bitmap bitmap) {
    Bundle bundle = getIntent().getExtras();
    String invoiceno, invoice_type;
    invoiceno = bundle.getString("orderno");
    invoice_type = bundle.getString("invoice_type");
    ContextWrapper cw = new ContextWrapper(getApplicationContext());
    File directory = cw.getDir("Signatures_Images", Context.MODE_APPEND);

    // Create imageDir

    String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
    File mypath = new File(directory, invoice_type + "-" + invoiceno + ".jpg");

    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(mypath);
      // Use the compress method on the BitMap object to write image to the OutputStream
      bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
      signaturePad.clear();
      //Toast.makeText(cw, "Signature is Succesfully Saved", Toast.LENGTH_SHORT).show();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return directory.getAbsolutePath();
  }
}
