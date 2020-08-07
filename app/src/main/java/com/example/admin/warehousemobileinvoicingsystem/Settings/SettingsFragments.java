package com.example.admin.warehousemobileinvoicingsystem.Settings;

import android.content.*;
import android.os.Bundle;
import android.preference.*;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

public class SettingsFragments extends PreferenceFragment {

  SharedPreferences pref, pref1;
  SharedPreferences.Editor editor;
  SharedPreferences.Editor editor1;
  SharedPreferenceForDataTransfer spdt;
  CharSequence[] initials, sales_rep_id;
  DbHelper dbHelper;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.preferencesettings);

    final Preference pref_compny_info = findPreference("pref_compny_info");
//    final ListPreference pref_sales_rep = (ListPreference) findPreference("pref_sales_rep");
    final ListPreference pref_default_order_type = (ListPreference) findPreference("pref_default_order_type");
    final EditTextPreference pref_last_order_no = (EditTextPreference) findPreference("pref_last_order_no");
    final EditTextPreference pref_last_sales_order_no = (EditTextPreference) findPreference("pref_last_sales_order_no");
    final EditTextPreference pref_last_estimate_no = (EditTextPreference) findPreference("pref_last_estimate_no");
    final CheckBoxPreference pref_require_signature = (CheckBoxPreference) getPreferenceManager().findPreference("pref_require_signature");
    final CheckBoxPreference pref_hide_inventory_balance = (CheckBoxPreference) getPreferenceManager().findPreference("pref_hide_inventory_balance");
    final CheckBoxPreference pref_hide_cost = (CheckBoxPreference) getPreferenceManager().findPreference("pref_hide_cost");

    final Context context = getActivity();
    pref = context.getSharedPreferences(spdt.ClientPrefFile, Context.MODE_PRIVATE);
    editor = pref.edit();
    dbHelper = new DbHelper(context);

    initials = dbHelper.getSalesRepData();
    sales_rep_id = dbHelper.getSalesRepId();
//    pref_sales_rep.setEntries(initials);
//    pref_sales_rep.setEntryValues(sales_rep_id);

    if (pref.getBoolean("hide_inventory", false) == false) {
      pref_hide_inventory_balance.setChecked(false);
    }

    pref_hide_inventory_balance.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
      @Override
      public boolean onPreferenceClick(Preference preference) {

        assert pref_hide_inventory_balance != null;
        if (pref_hide_inventory_balance.isChecked()) {
          editor.putBoolean("hide_inventory", true).apply();
        } else {
          editor.putBoolean("hide_inventory", false).apply();
        }
        editor.commit();

        return false;
      }
    });

    if (pref.getBoolean("hide_cost",false) == false){
      pref_hide_cost.setChecked(false);
    }

    pref_hide_cost.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(){
      @Override
      public boolean onPreferenceClick(Preference preference) {

        assert pref_hide_cost != null;
        if (pref_hide_cost.isChecked()){
          editor.putBoolean("hide_cost",true).apply();
        }else {
          editor.putBoolean("hide_cost",false).apply();
        }
        editor.commit();

        return false;
      }
    });


    pref_default_order_type.setValue(pref.getString("default_order_type", null));

    pref_default_order_type.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        pref = context.getSharedPreferences(spdt.ClientPrefFile, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("default_order_type", String.valueOf(newValue)).apply();
        Toast.makeText(context, "" + newValue, Toast.LENGTH_SHORT).show();
        editor.commit();
        return false;
      }
    });

//    pref_sales_rep.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//      @Override
//      public boolean onPreferenceChange(Preference preference, Object newValue) {
//        pref = context.getSharedPreferences(spdt.ClientPrefFile, Context.MODE_PRIVATE);
//        editor = pref.edit();
//        editor.putString("sales_rep_id", String.valueOf(newValue)).apply();
//        Toast.makeText(context, "" + newValue, Toast.LENGTH_SHORT).show();
//        editor.commit();
//        return true;
//      }
//    });


    pref_compny_info.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
      @Override
      public boolean onPreferenceClick(Preference preference) {
        //Context context = getActivity();
        Intent intent = new Intent(context, Company_Details.class);
        startActivity(intent);
        return true;
      }
    });

    if (pref.getBoolean("signature", true) == true) {

      pref_require_signature.setChecked(true);


    }

    pref_require_signature.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
      @Override
      public boolean onPreferenceClick(Preference preference) {

        assert pref_require_signature != null;
        if (pref_require_signature.isChecked()) {
          editor.putBoolean("signature", true).apply();
        } else {
          editor.putBoolean("signature", false).apply();
        }
        editor.commit();
        return true;
      }
    });


    pref_last_order_no.setText(String.valueOf(pref.getString("client_invoice_no", null)));
    pref_last_sales_order_no.setText(String.valueOf(pref.getString("client_sales_order_no", null)));
    pref_last_estimate_no.setText(String.valueOf(pref.getString("client_estimate_no", null)));
//    pref_sales_rep.setValue(pref.getString("sales_rep_id", null));
    //pref_default_order_type.setValue(String.valueOf(pref.getString("default_order_type",null)));

    pref_last_order_no.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        pref = context.getSharedPreferences(spdt.ClientPrefFile, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("client_invoice_no", String.valueOf(newValue));
        editor.commit();
        // Log.w(TAG, "set debug newValue:" + newValue);
        return true;
      }
    });

    pref_last_sales_order_no.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        pref = context.getSharedPreferences(spdt.ClientPrefFile, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("client_sales_order_no", String.valueOf(newValue));
        editor.commit();
        // Log.w(TAG, "set debug newValue:" + newValue);
        return true;
      }
    });

    pref_last_estimate_no.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        pref = context.getSharedPreferences(spdt.ClientPrefFile, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("client_estimate_no", String.valueOf(newValue));
        editor.commit();
        // Log.w(TAG, "set debug newValue:" + newValue);
        return true;
      }
    });
  }
}