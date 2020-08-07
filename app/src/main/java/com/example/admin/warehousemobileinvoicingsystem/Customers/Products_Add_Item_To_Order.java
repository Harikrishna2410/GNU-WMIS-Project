package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.admin.warehousemobileinvoicingsystem.AllTableNames;
import com.example.admin.warehousemobileinvoicingsystem.Products.ProductModel;
import com.example.admin.warehousemobileinvoicingsystem.Products.Product_List;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Products_Add_Item_To_Order extends AppCompatActivity implements CustomAdapter_rv_custneworder.ItemClickListener, View.OnClickListener {

  //region Global Declaration Section
  SharedPreferenceForDataTransfer spdt;
  Intent intent;
  Button btn_save;
  ImageView btn_plus, btn_minus,btn_dot;
  TextInputEditText ed_description, ed_price, ed_qty_ord, ed_cost, ed_discountrate, ed_taxrate;
  CheckBox cb_taxable;
  Bundle productBundle = new Bundle();
  TextView tv_barcode;
  Integer count;
  AllTableNames tn;
  ArrayList<ProductModel> productItems;
  DecimalFormat df = new DecimalFormat("#.00");
  String qty, price, total;
  Toolbar activity_products__edit__items_toolbar;
  Double tax_amount = 0.00;
  String product_is_taxable = null;
  String product_id;
  SharedPreferences pref;
  SharedPreferences.Editor editor;
  //endregion

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_products__add__item__to__order);
    //---------Bind all controls here-----------------------------------------------------------
    bindAllControls();

    setSupportActionBar(activity_products__edit__items_toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    DecimalFormat df = new DecimalFormat("#.00");

    //---------Setting Shared preference file for transfer of data -------------------------------
    spdt = new SharedPreferenceForDataTransfer(this);
    pref = getSharedPreferences(spdt.ClientPrefFile, MODE_PRIVATE);
    editor = pref.edit();

    if (pref.getBoolean("hide_cost",true) == true){
      ed_cost.setVisibility(View.GONE);
    }

    //-------------------Register Buttons for onclick listener----------------------------------
    btn_plus.setOnClickListener(this);
    btn_minus.setOnClickListener(this);
    btn_save.setOnClickListener(this);
    btn_dot.setOnClickListener(this);
    //------------------------------------------------------------------------------------------

    productBundle = getIntent().getExtras();
    tn = new AllTableNames();

    //----------Setting shared preference for data transfer-------------------------------------
    spdt = new SharedPreferenceForDataTransfer(this);

    //*************** SETTING REST DATA FROM BUNDLE RECEIVED FROM MyAdapter_Products ***********
    displayDataFromBundle();
    //******************************************************************************************

    if (spdt.pref_data_transfer.getString("product_scanned", null).equals("0")) {
      cb_taxable.setChecked(productBundle.getString("prod_is_taxable").equals("1") ? true : false);
    }
  }

  private void displayDataFromBundle() {
//        for (String key : getIntent().getExtras().keySet()) {
//            Log.e("my3Application", key + " is a key in the bundle");
//        }
    //************************* SETTING DATA RECEIVED FROM MyAdapter_Products.java ************************************************
    tv_barcode.setText(getIntent().getExtras().getString("prod_barcodeno"));
    ed_price.setText(getIntent().getExtras().getString("prod_price"));
    ed_description.setText(getIntent().getExtras().getString("prod_name"));
    ed_cost.setText(getIntent().getExtras().getString("prod_cost"));
    ed_taxrate.setText(df.format(Double.parseDouble(getIntent().getExtras().getString("prod_tax_rate"))) + "%");

    ed_discountrate.setText(getIntent().getExtras().getString("prod_discount_type").equals("0")
            ? df.format(Double.parseDouble(getIntent().getExtras().getString("prod_discount_rate"))) + "%"
            :  getString(R.string.Rs) + df.format(Double.parseDouble(getIntent().getExtras().getString("prod_discount_rate"))));

    ed_qty_ord.setText(getIntent().getExtras().getString("prod_qty_ord") == null ? "1" : getIntent().getExtras().getString("prod_qty_ord"));
    if (spdt.pref_data_transfer.getString("product_is_taxable", null).equals("1")) {
      cb_taxable.setChecked(true);
    } else {
      cb_taxable.setChecked(false);
    }
    ed_qty_ord.requestFocus();
  }

  //**************  THIS METHOD IS CALLED WHEN WE OPEN NEW INTENT OF THIS ACTIVITY USAUALLY IT IS CALLED WHEN WE OPEN THIS ACTIVITY SECOND TIME  **************
  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    setIntent(intent);
    displayDataFromBundle();
  }

  private void bindAllControls() {
    btn_save = findViewById(R.id.btn_save_additemtoorder);
    ed_description = findViewById(R.id.ed_description_act_prod_add_item_to_order);
    ed_price = findViewById(R.id.tv_price_act_prod_add_item_to_order);
    tv_barcode = findViewById(R.id.tv_stockno_act_prod_add_item_to_order);
    btn_plus = findViewById(R.id.btn_plus);
    btn_minus = findViewById(R.id.btn_minus);
    ed_qty_ord = findViewById(R.id.ed_qty_ord_act_prod_add_item_to_order);
    btn_dot = findViewById(R.id.btn_dot);
    activity_products__edit__items_toolbar = findViewById(R.id.activity_products__edit__items_toolbar);
    cb_taxable = findViewById(R.id.add_item_cb_taxable);
    ed_cost = findViewById(R.id.ed_cost_act_prod_add_item_to_order);
    ed_discountrate = findViewById(R.id.ed_discount_act_prod_add_item_to_order);
    ed_taxrate = findViewById(R.id.ed_tax_rate_act_prod_add_item_to_order);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
  }

  @Override
  public void onClick(View view) {
    DecimalFormat df = new DecimalFormat("#.00");
    switch (view.getId()) {
      case R.id.btn_save_additemtoorder:
        saveItemToCustomerNewOrderRV();
        break;
      case R.id.btn_plus:
        count = Integer.parseInt(ed_qty_ord.getText().toString());
        count++;
        ed_qty_ord.setText(count.toString());
        break;
      case R.id.btn_minus:
        count = Integer.parseInt(ed_qty_ord.getText().toString());
        count--;
        ed_qty_ord.setText(count.toString());
        break;
      case R.id.btn_dot:
        intent = new Intent(this, Product_List.class);
        startActivityForResult(intent, 0);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        break;
      default:
        //Toast.makeText(this, "default", Toast.LENGTH_SHORT).show();
        break;
    }
  }

  //************************  THIS IS CALLED WHEN WE CLICK ON SAVE BUTTON IN THIS ACTIVITY  *************************************
  //**********  WHEN WE CLICK SAVE BUTTON IT WILL CHECK WHETHER WE ARE COMMING TO INSERT NEW ITEM OR UPDATA AN ITEM  **************
  private void saveItemToCustomerNewOrderRV() {
    Bundle pBundle = getIntent().getExtras();

    //************************* VALIDATING DATA BEFORE INSERT OR UPDATE PRODUCT TO RV ***************************************************
    String msg = validataData();

    if (msg.equals("success")) {
      //******************** CALLED WHEN WE ARE UPDATING ITEM IN CUSTOMER_NEW_ORDER.JAVA RECYCLER VIEW **********************************
      if (spdt.pref_data_transfer.getString("item_selected_for_update", "").equals("yes")) {
//        Toast.makeText(this, "Item selected for update", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Customer_new_order.class);
        for (String key : pBundle.keySet()) {
          Log.e("my2Application", key + " is a key in the bundle");
        }
        //************************************** CALCULATE TOTAL DISCOUNT ***************************************************************
        qty = ed_qty_ord.getText().toString();  //Getting current quantity
        price = ed_price.getText().toString();  // Getting current price
        Double totalBeforeDiscTax = Double.parseDouble(qty) * Double.parseDouble(price);
        Double totalDisc = 0.00, totalTax = 0.00;
        if (pBundle.getString("prod_discount_type").equals("0")) {
          totalDisc = (totalBeforeDiscTax * Double.parseDouble(pBundle.getString("prod_discount_rate")) / 100);
        } else {
          totalDisc = Double.parseDouble(pBundle.getString("prod_discount_rate")) * Double.parseDouble(qty);
        }
        //************************************* CALCULATE TOTAL TAX ON PRODUCT ***************************************************************************
        if (cb_taxable.isChecked() && spdt.pref_data_transfer.getString("customer_is_product_tax", null).equals("1")) {
          totalTax = (totalBeforeDiscTax - totalDisc) * Double.parseDouble(pBundle.getString("prod_tax_rate")) / 100;
        } else {
          totalTax = 0.00;
        }
//        Toast.makeText(this, "dis rate = " + pBundle.getString("prod_discount_rate"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "prod_id = " + pBundle.getString("prod_id"), Toast.LENGTH_SHORT).show();
        //*************************************************************************************************************************************************
        //  SENDING THIS CHANGES BACK TO CUSTOMER_NEWORDER.JAVA TO SET DATA IN RECYCLER VIEW
        //  DO NOT PASS THIS IN BUNDLE IT DOES NOT WORK IN STARTACTIVITY FOR RESULT
        intent.putExtra("prod_id", pBundle.getString("prod_id"));
        intent.putExtra("prod_barcodeno", pBundle.getString("prod_barcodeno"));
        intent.putExtra("prod_name", ed_description.getText().toString());
        intent.putExtra("prod_cost", pBundle.getString("prod_cost"));
        intent.putExtra("prod_price", ed_price.getText().toString());
        intent.putExtra("prod_discount_type", pBundle.getString("prod_discount_type"));
        intent.putExtra("prod_discount_rate", pBundle.getString("prod_discount_rate"));
        intent.putExtra("prod_total_discount", totalDisc.toString());
        intent.putExtra("prod_is_taxable", pBundle.getString("prod_is_taxable"));
        intent.putExtra("prod_tax_rate", pBundle.getString("prod_tax_rate"));
        intent.putExtra("prod_total_tax", totalTax.toString());
        intent.putExtra("prod_qty_ord", ed_qty_ord.getText().toString());
        intent.putExtra("position", String.valueOf(spdt.pref_data_transfer.getInt("position", 0)));
        intent.putExtra("prod_is_taxable", (cb_taxable.isChecked() == true ? "1" : "0"));
        intent.putExtra("prod_total_price", totalBeforeDiscTax.toString());
        intent.putExtra("prod_total_tax", totalTax.toString());
        //Check  private void updateProductsInRecyclerView(Intent data)  in customer_new_order
        setResult(RESULT_OK, intent);
        finish();
      }

      //******************** CALLED WHEN WE ARE INSERTING ITEM IN CUSTOMER_NEW_ORDER.JAVA RECYCLER VIEW **********************************
      else {
//        Toast.makeText(this, "item selected for INSERT.", Toast.LENGTH_SHORT).show();
        intent = new Intent(this, Customer_new_order.class);
        productBundle.putString("current_prod_is_taxable", (cb_taxable.isChecked() == true ? "1" : "0"));
        productBundle.putString("current_prod_barcodeno", tv_barcode.getText().toString());
        productBundle.putString("current_prod_name", ed_description.getText().toString());
        productBundle.putString("current_prod_qty_ord", ed_qty_ord.getText().toString());
        productBundle.putString("current_prod_price", ed_price.getText().toString());
        productBundle.putString("current_prod_cost", ed_cost.getText().toString());
        intent.putExtras(productBundle);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
      }
    }
  }

  private String validataData() {
    if (TextUtils.isEmpty(ed_description.getText())) {
      ed_description.setError("required");
      ed_description.selectAll();
    } else if (TextUtils.isEmpty(ed_qty_ord.getText()) || ed_qty_ord.getText().toString().equals("0")) {
      ed_qty_ord.setError("required");
      ed_qty_ord.selectAll();
    } else if (TextUtils.isEmpty(ed_price.getText())) {
      ed_price.setError("required");
      ed_price.selectAll();
    } else {
      return "success";
    }
    return null;
  }

  @Override
  public void onItemClick(View view, int position) {

//    Toast.makeText(this, "On item clicked ", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
//    Toast.makeText(this, "onActivityResult prod_add_item_order code = " + resultCode, Toast.LENGTH_SHORT).show();
  }
}
