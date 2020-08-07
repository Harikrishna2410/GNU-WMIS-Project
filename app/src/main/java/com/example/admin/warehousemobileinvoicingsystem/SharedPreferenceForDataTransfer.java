package com.example.admin.warehousemobileinvoicingsystem;

import android.content.*;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferenceForDataTransfer {

  public static final String PrefFileDataTransfer = "PrefFileDataTransfer";
  public static final String ClientPrefFile = "ClientPrefFile";
  public static final String CustomersPrefFile = "CustomersPrefFile";
  public SharedPreferences pref_client, pref_customer, pref_data_transfer;
  public SharedPreferences.Editor editor_client, editor_customer, editor_data_tranfer;
  Context ctx;

  public SharedPreferenceForDataTransfer(Context context) {
    this.ctx = context;
    this.pref_client = ctx.getSharedPreferences(ClientPrefFile, MODE_PRIVATE);
    this.editor_client = pref_client.edit();
    this.pref_customer = ctx.getSharedPreferences(CustomersPrefFile, MODE_PRIVATE);
    this.editor_customer = pref_customer.edit();
    this.pref_data_transfer = ctx.getSharedPreferences(PrefFileDataTransfer, MODE_PRIVATE);
    this.editor_data_tranfer = pref_data_transfer.edit();
  }
}
