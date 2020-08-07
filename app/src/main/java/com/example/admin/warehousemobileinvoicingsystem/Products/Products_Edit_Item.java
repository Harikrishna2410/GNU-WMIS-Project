package com.example.admin.warehousemobileinvoicingsystem.Products;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.admin.warehousemobileinvoicingsystem.AllTableNames;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Products_Edit_Item extends AppCompatActivity {

  //region ***************************** GLOBAL DECLARATION SECTION ******************************
  AllTableNames tn;
  androidx.appcompat.widget.Toolbar toolbar;
  TextView tv_barcode, tv_qty;
  EditText ed_prod_name, ed_price, ed_cost, ed_category, ed_expiry, ed_discountrate;
  Button btn_save;
  SQLiteDatabase db;
  DbHelper dbHelper;
  CheckBox cb;
  String p_id_for_update;
  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
  Product_List productList;
  Bundle bundle;
  DecimalFormat df = new DecimalFormat("#.00");
  SharedPreferenceForDataTransfer spdt;
  SharedPreferences pref;
  SharedPreferences.Editor editor;


  //endregion ************************************************************************************

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_products__edit__items);

    productList = new Product_List();
    dbHelper = new DbHelper(this);
    tn = new AllTableNames();
    bindAllcontrols();

    //---------Setting Shared preference file for transfer of data -------------------------------
    spdt = new SharedPreferenceForDataTransfer(this);
    pref = getSharedPreferences(spdt.ClientPrefFile, MODE_PRIVATE);
    editor = pref.edit();

    if (pref.getBoolean("hide_cost",true) == true){
      ed_cost.setVisibility(View.GONE);
    }
    if (pref.getBoolean("hide_inventory",true) == true){
      tv_qty.setVisibility(View.GONE);
    }

    //*************** SETTING REST DATA FROM BUNDLE RECEIVED FROM MyAdapter_Products ************
    bundle = getIntent().getExtras();
    displayDataFromBundle(bundle);
    //********************************************************************************************

    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      try {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Edit Item");
      } catch (Exception ex) {
        Toast.makeText(this, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
      }
    }


    btn_save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Integer taxable = cb.isChecked() ? 1 : 0;
        try {
          ContentValues contentValues = new ContentValues();
          contentValues.put(tn.products_col_name, ed_prod_name.getText().toString());
          contentValues.put(tn.products_col_price, ed_price.getText().toString());
          contentValues.put(tn.products_col_is_taxable, taxable);
          long rows_updated = dbHelper.getWritableDatabase().update(tn.products_tablename, contentValues, tn.products_col_id + " = ?",
            new String[]{String.valueOf(bundle.getString("product_id_list"))});
          finish();
        } catch (Exception ex) {
          Toast.makeText(Products_Edit_Item.this, "prod update error" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
      }
    });


  }

  public void displayDataFromBundle(Bundle bundle) {

    tv_barcode.setText(bundle.getString("products_barcode_list"));
    ed_prod_name.setText(bundle.getString("product_name"));
    ed_price.setText(bundle.getString("product_price"));
    ed_cost.setText(bundle.getString("product_cost"));
    tv_qty.setText(bundle.getString("product_quantity"));
    ed_category.setText(bundle.getString("product_category_name") == null ? "None" : bundle.getString("product_category_name"));
    ed_expiry.setText(bundle.getString("product_expiry").equals("null") ? "None" : bundle.getString("product_expiry"));
    ed_discountrate.setText(bundle.getString("product_discounttype").equals("0") ? bundle.getString("product_discountrate") + " %" : "Rs " + bundle.getString("product_discountrate"));
    cb.setChecked(bundle.getString("product_istaxable").equals("1") ? true : false);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_products__edit__items_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_item_delete:
        //deleteItem();
        break;
    }
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void deleteItem() {

    try {
      db.execSQL("delete from " + tn.products_tablename + " where " + tn.products_col_id + " = " + p_id_for_update);
      finish();

      //Toast.makeText(this, "Item deleted...", Toast.LENGTH_SHORT).show();
    } catch (Exception ex) {
      Toast.makeText(this, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    }

  }

  private void bindAllcontrols() {
    toolbar = findViewById(R.id.activity_products__edit__items_toolbar);
    btn_save = findViewById(R.id.btn_save_product_edit_item);
    tv_barcode = findViewById(R.id.tv_products_edit_items_xml_barcode);
    tv_qty = findViewById(R.id.tv_products_edit_items_xml_qty);
    ed_price = findViewById(R.id.ed_products_edit_items_xml_price);
    ed_prod_name = findViewById(R.id.ed_products_edit_items_xml_prodname);
    cb = findViewById(R.id.checkBox);
    ed_cost = findViewById(R.id.ed_products_edit_items_xml_cost);
    ed_category = findViewById(R.id.ed_products_edit_items_category);
    ed_expiry = findViewById(R.id.ed_products_edit_items_expiry);
    ed_discountrate = findViewById(R.id.ed_products_edit_items_discountrate);
  }
}
