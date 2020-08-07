package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.*;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.warehousemobileinvoicingsystem.API.GetCustomerCountAPI;
import com.example.admin.warehousemobileinvoicingsystem.AllTableNames;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.MyGlobals;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Customer_List extends AppCompatActivity {

  //region========================================GLOBAL DECLARATION SECTIOM  ======================================
  RecyclerView rv;
  SQLiteDatabase db;
  MyAdapter_Customer adapter;
  Intent intent;
  SharedPreferenceForDataTransfer spdt;
  AllTableNames tn;
  Toolbar toolbar;
  SearchView searchView, ed_searchview;
  ArrayList<CustModel> customers;
  DbHelper dbHelper;
  ProgressBarHandler pb;
  ConstraintLayout constraintLayout;
  //endregion

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_customer__list);
    tn = new AllTableNames();
    //bind all controls in this function
    bindAllControls();
    setSupportActionBar(toolbar);
    spdt = new SharedPreferenceForDataTransfer(this);
    dbHelper = new DbHelper(this);
    pb = new ProgressBarHandler(Customer_List.this);

    adapter = new MyAdapter_Customer(Customer_List.this, fetchCustomers());
    rv.setLayoutManager(new LinearLayoutManager(this));
    rv.setAdapter(adapter);

    // tool bar binding // HK
    androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_productlist_activity);
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      try {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Customer List");
      } catch (Exception ex) {
        Toast.makeText(this, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
      }
    }

    ed_searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String s) {
        return false;
      }

      @Override
      public boolean onQueryTextChange(String s) {
        adapter.getFilter().filter(s);
        return false;
      }
    });

  }

  private ArrayList<CustModel> fetchCustomers() {
    customers = new ArrayList<CustModel>();
    try {
      db = openOrCreateDatabase("WMIS.db", MODE_PRIVATE, null);
      Cursor c = db.rawQuery("select * from " + tn.customers_tablename + " order by " + tn.customers_col_name, null);
      ed_searchview.setQueryHint(String.valueOf(c.getCount()) + " Customers");

      if (c.getCount() > 0) {
        customers.clear();
        while (c.moveToNext()) {
          CustModel cm = new CustModel();
          cm.setId(c.getString(0));
          cm.setServer_id(c.getString(1));
          cm.setClient_id(c.getString(2));
          cm.setName(c.getString(3));
          cm.setContact_name(c.getString(4));
          cm.setGstin(c.getString(5));
          cm.setEmail(c.getString(6));
          cm.setAddress(c.getString(7));
          cm.setCity(c.getString(8));
          cm.setState(c.getString(9));
          cm.setPostcode(c.getString(10));
          cm.setContact_no(c.getString(11));
          cm.setStatus(c.getString(12));
          cm.setIs_product_tax(c.getString(13));
          customers.add(cm);
        }
      }
    } catch (Exception ex) {
      Toast.makeText(this, "Customer_List.java" + ex.getMessage(), Toast.LENGTH_LONG).show();
    } finally {
      db.close();
    }
    //Toast.makeText(this, ""+customers.size(), Toast.LENGTH_SHORT).show();
    return customers;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    if(menu instanceof MenuBuilder){
      ((MenuBuilder) menu).setOptionalIconsVisible(true);
    }
    getMenuInflater().inflate(R.menu.main, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.new_customer:
        pb.pb_load_tv.setText("Please Wait...");
        pb.show();
        spdt.editor_data_tranfer.putString("edit_customer", "no");
        spdt.editor_data_tranfer.commit();

        // Check for internet connection
        boolean connected = isNetworkConnected();
        // If connected== true
        if (connected) {
          GetCustomerCountAPI getCustomerCountAPI = new GetCustomerCountAPI(Customer_List.this);
          getCustomerCountAPI.GetCustomerCountAPI(pb);
        } else {
          pb.dismiss();
          MyGlobals.setSnackBar(constraintLayout, "Check your internet connection");
        }
//        *************************************************************
//        int max_customers = Integer.parseInt(spdt.pref_client.getString("max_customers", null));
//        String customersCount = dbHelper.getAllCustomersCount();
//
//        if (Integer.parseInt(customersCount) < max_customers) {
//          spdt.editor_data_tranfer.putString("edit_customer", "no");
//          spdt.editor_data_tranfer.commit();
//          intent = new Intent(this, NewCustomerRegistration.class);
//          startActivity(intent);
//          overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//          return true;
//        } else {
//          new SweetAlertDialog(Customer_List.this, SweetAlertDialog.ERROR_TYPE)
//                  .setTitleText("Oops...")
//                  .setContentText("Cannot Add New Customer Limit Reached !!!")
//                  .show();
//        }

        break;

      default:
        break;
    }
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private boolean isNetworkConnected() {
    ConnectivityManager cm = (ConnectivityManager) getSystemService(Main_Menu.CONNECTIVITY_SERVICE);
    return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
  }

  private void bindAllControls() {
    rv = findViewById(R.id.customer_list_rv);
    toolbar = findViewById(R.id.toolbar_productlist_activity);
    ed_searchview = findViewById(R.id.ed_Searchview);
    constraintLayout = findViewById(R.id.customer_list_constraint_layout);
  }

  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
  }

  @Override
  protected void onResume() {
    super.onResume();
    adapter = new MyAdapter_Customer(Customer_List.this, fetchCustomers());
    rv.setLayoutManager(new LinearLayoutManager(this));
    rv.setItemAnimator(new DefaultItemAnimator());
    rv.setAdapter(adapter);
  }

  @Override
  public void onBackPressed() {
    // close search view on back button pressed
        /*if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }*/
    super.onBackPressed();
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
  }


}
