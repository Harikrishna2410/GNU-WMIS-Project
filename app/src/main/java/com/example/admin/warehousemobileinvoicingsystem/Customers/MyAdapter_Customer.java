package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.app.Activity;
import android.app.Dialog;
import android.content.*;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.*;
import android.widget.*;

import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;

import java.util.*;

public class MyAdapter_Customer extends RecyclerView.Adapter<MyHolder> implements Filterable {

  //region ======================== Global Declaration Section ===================================
  Activity ctx;
  ArrayList<CustModel> customers, filterList;
  CustomFilter filter;
  ArrayList<SyncCustomers> syncCustomers;
  TextView tv_storename, tv_contact, tv_gstin, tv_phoneno, tv_address, tv_city;
  CardView cv_edit_customer, cv_new_order;
  DbHelper dbHelper;
  SharedPreferenceForDataTransfer spdt;
  //endregion

  public MyAdapter_Customer(Customer_List ctx, ArrayList<CustModel> customers) {
    this.ctx = ctx;
    this.customers = customers;
    this.filterList = customers;
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.syncCustomers = new ArrayList<>();
    this.dbHelper = new DbHelper(ctx);
  }

  @Override
  public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //CONVERT XML TO VIEW ONBJ
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_list_card_view_layout, parent, false);

    //HOLDER
    MyHolder holder = new MyHolder(v);

    return holder;
  }

  //DATA BOUND TO VIEWS
  @Override
  public void onBindViewHolder(final MyHolder holder, final int position) {

    //**************************** BINDING DATA *************************************************
    holder.name.setText(customers.get(position).getName());
    holder.tv_address.setText(customers.get(position).getAddress());


    //region ************************************ BUTTON CREATE ORDER CLICK EVENT ******************************************************************
    holder.btn_new_order.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

//        Toast.makeText(ctx, "new order clicked", Toast.LENGTH_SHORT).show();

        //DbHelper dbHelper = new DbHelper(ctx);
        //Toast.makeText(ctx, "name = "+holder.name.getText(), Toast.LENGTH_SHORT).show();
        //this will get selected customer detail and load into dialog box.===============================
        syncCustomers = dbHelper.getSingleCustomerData(customers.get(position).getId());
        Intent intent = new Intent(ctx, Customer_new_order.class);

        spdt.editor_data_tranfer.putString("customer_name", holder.name.getText().toString());
        spdt.editor_data_tranfer.putString("products_qty", "0");
        spdt.editor_data_tranfer.putString("prod_total", "0");
        spdt.editor_data_tranfer.putString("customer_is_product_tax", syncCustomers.get(0).getIs_product_tax());
        spdt.editor_data_tranfer.putString("customer_id", syncCustomers.get(0).getId());
        spdt.editor_data_tranfer.putString("server_id", syncCustomers.get(0).getServer_id());
        spdt.editor_data_tranfer.putString("edit_customer", "no");
        spdt.editor_data_tranfer.commit();
        ctx.startActivityForResult(intent, 1);
        ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
      }
    });
    //endregion

    //*********************** ROW CLICK EVENT OPENS EDIT CUSTOMER AND NEW ORDER **************************************************
    holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
//        Toast.makeText(ctx, "Constraint layout clicked", Toast.LENGTH_SHORT).show();

        final Dialog dialog = new Dialog(ctx);
        dialog.setContentView(R.layout.customer_info_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setLayout(width, height);

        syncCustomers = new ArrayList<SyncCustomers>();
        //DbHelper dbHelper = new DbHelper(ctx);
//        Toast.makeText(ctx, "customer = " + customers.get(pos).getId(), Toast.LENGTH_SHORT).show();

        //***************** THIS WILL GET SINGLE CUSTOMER DATA FOR SHOWING IN DIALOG **********************************************
        syncCustomers = dbHelper.getSingleCustomerData(customers.get(position).getId());
//        Toast.makeText(ctx, "customer count :  " + syncCustomers.size(), Toast.LENGTH_SHORT).show();

        //************************** BINDING ALL CONTROL OF THE CUSTOM DIALOG *****************************************************
        tv_phoneno = dialog.findViewById(R.id.tv_store_phoneno);
        tv_storename = dialog.findViewById(R.id.tv_store_name_customerinformationactivity);
        tv_gstin = dialog.findViewById(R.id.tv_edit_gstin);
        tv_address = dialog.findViewById(R.id.tv_store_address);
        tv_city = dialog.findViewById(R.id.tv_store_city);
        tv_contact = dialog.findViewById(R.id.tv_store_owner_name);
        cv_edit_customer = dialog.findViewById(R.id.update_button_select_sync_type);
        cv_new_order = dialog.findViewById(R.id.send_c_and_o_button_select_sync_type);
        //*************************************************************************************************************************

        tv_storename.setText(syncCustomers.get(0).getName());
        tv_address.setText(syncCustomers.get(0).getAddress());
        tv_gstin.setText(syncCustomers.get(0).getGstin());
        tv_city.setText(syncCustomers.get(0).getCity() + " " + syncCustomers.get(0).getState() + " " + syncCustomers.get(0).getPostcode());
        tv_phoneno.setText(syncCustomers.get(0).getContact_no());
        tv_contact.setText(syncCustomers.get(0).getContact_name());

        cv_new_order.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
//            Toast.makeText(ctx, "New order clicked", Toast.LENGTH_SHORT).show();
            if (spdt.pref_client.getString("sales_rep_id", null).equals("null")) {
//              Toast.makeText(ctx, "Please select Sales rep first.", Toast.LENGTH_SHORT).show();
            } else {
              Intent intent = new Intent(ctx, Customer_new_order.class);
              spdt.editor_data_tranfer.putString("customer_name", tv_storename.getText().toString());
              spdt.editor_data_tranfer.putString("products_qty", "0");
              spdt.editor_data_tranfer.putString("prod_total", "0");
              spdt.editor_data_tranfer.putString("customer_is_product_tax", syncCustomers.get(0).getIs_product_tax());
              spdt.editor_data_tranfer.putString("customer_id", syncCustomers.get(0).getId());
              spdt.editor_data_tranfer.putString("server_id", syncCustomers.get(0).getServer_id());
              spdt.editor_data_tranfer.putString("edit_customer", "no");
              spdt.editor_data_tranfer.commit();
              ctx.startActivityForResult(intent, 1);
              dialog.dismiss();
              ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
          }
        });

        cv_edit_customer.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            spdt.editor_data_tranfer.putString("edit_customer", "yes");
            spdt.editor_data_tranfer.commit();

            Intent intent = new Intent(ctx, NewCustomerRegistration.class);
            intent.putExtra("customer_row_id", syncCustomers.get(0).getId());
            intent.putExtra("customer_server_id", syncCustomers.get(0).getServer_id());
            intent.putExtra("customer_name", tv_storename.getText().toString());
            intent.putExtra("customer_contact", syncCustomers.get(0).getContact_name());
            intent.putExtra("customer_gstin", syncCustomers.get(0).getGstin());
            intent.putExtra("customer_address", syncCustomers.get(0).getAddress());
            intent.putExtra("customer_state", syncCustomers.get(0).getState());
            intent.putExtra("customer_city", syncCustomers.get(0).getCity());
            intent.putExtra("customer_zip", syncCustomers.get(0).getPostcode());
            intent.putExtra("customer_phoneno", syncCustomers.get(0).getContact_no());
            intent.putExtra("customer_email", syncCustomers.get(0).getEmail());
            intent.putExtra("customer_is_product_tax", syncCustomers.get(0).getIs_product_tax());
            ctx.startActivity(intent);
            dialog.dismiss();
            ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
          }
        });
        dialog.show();
      }
    });
//    holder.setItemClickListener(new ItemClickListener() {
//      @Override
//      public void onItemClick(View v, int pos) {
//
//        Toast.makeText(ctx, "holder clicked", Toast.LENGTH_SHORT).show();
//
//        final Dialog dialog = new Dialog(ctx);
//        dialog.setContentView(R.layout.customer_info_dialog);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        int width = ViewGroup.LayoutParams.MATCH_PARENT;
//        int height = ViewGroup.LayoutParams.MATCH_PARENT;
//        dialog.getWindow().setLayout(width, height);
//
//        syncCustomers = new ArrayList<SyncCustomers>();
//        //DbHelper dbHelper = new DbHelper(ctx);
////        Toast.makeText(ctx, "customer = " + customers.get(pos).getId(), Toast.LENGTH_SHORT).show();
//
//        //***************** THIS WILL GET SINGLE CUSTOMER DATA FOR SHOWING IN DIALOG **********************************************
//        syncCustomers = dbHelper.getSingleCustomerData(customers.get(pos).getId());
////        Toast.makeText(ctx, "customer count :  " + syncCustomers.size(), Toast.LENGTH_SHORT).show();
//
//        //************************** BINDING ALL CONTROL OF THE CUSTOM DIALOG *****************************************************
//        tv_phoneno = dialog.findViewById(R.id.tv_store_phoneno);
//        tv_storename = dialog.findViewById(R.id.tv_store_name_customerinformationactivity);
//        tv_gstin = dialog.findViewById(R.id.tv_edit_gstin);
//        tv_address = dialog.findViewById(R.id.tv_store_address);
//        tv_city = dialog.findViewById(R.id.tv_store_city);
//        tv_contact = dialog.findViewById(R.id.tv_store_owner_name);
//        cv_edit_customer = dialog.findViewById(R.id.update_button_select_sync_type);
//        cv_new_order = dialog.findViewById(R.id.send_c_and_o_button_select_sync_type);
//        //*************************************************************************************************************************
//
//        tv_storename.setText(syncCustomers.get(0).getName());
//        tv_address.setText(syncCustomers.get(0).getAddress());
//        tv_gstin.setText(syncCustomers.get(0).getGstin());
//        tv_city.setText(syncCustomers.get(0).getCity() + " " + syncCustomers.get(0).getState() + " " + syncCustomers.get(0).getPostcode());
//        tv_phoneno.setText(syncCustomers.get(0).getContact_no());
//        tv_contact.setText(syncCustomers.get(0).getContact_name());
//
//        cv_new_order.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//            Toast.makeText(ctx, "New order clicked", Toast.LENGTH_SHORT).show();
//            if (spdt.pref_client.getString("sales_rep_id", null).equals("null")) {
////              Toast.makeText(ctx, "Please select Sales rep first.", Toast.LENGTH_SHORT).show();
//            } else {
//              Intent intent = new Intent(ctx, Customer_new_order.class);
//              spdt.editor_data_tranfer.putString("customer_name", tv_storename.getText().toString());
//              spdt.editor_data_tranfer.putString("products_qty", "0");
//              spdt.editor_data_tranfer.putString("prod_total", "0");
//              spdt.editor_data_tranfer.putString("customer_is_product_tax", syncCustomers.get(0).getIs_product_tax());
//              spdt.editor_data_tranfer.putString("customer_id", syncCustomers.get(0).getId());
//              spdt.editor_data_tranfer.putString("server_id", syncCustomers.get(0).getServer_id());
//              spdt.editor_data_tranfer.putString("edit_customer", "no");
//              spdt.editor_data_tranfer.commit();
//              ctx.startActivityForResult(intent, 1);
//              dialog.dismiss();
//              ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//            }
//          }
//        });
//
//        cv_edit_customer.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//            spdt.editor_data_tranfer.putString("edit_customer", "yes");
//            spdt.editor_data_tranfer.commit();
//
//            Intent intent = new Intent(ctx, NewCustomerRegistration.class);
//            intent.putExtra("customer_row_id", syncCustomers.get(0).getId());
//            intent.putExtra("customer_server_id", syncCustomers.get(0).getServer_id());
//            intent.putExtra("customer_name", tv_storename.getText().toString());
//            intent.putExtra("customer_contact", syncCustomers.get(0).getContact_name());
//            intent.putExtra("customer_gstin", syncCustomers.get(0).getGstin());
//            intent.putExtra("customer_address", syncCustomers.get(0).getAddress());
//            intent.putExtra("customer_state", syncCustomers.get(0).getState());
//            intent.putExtra("customer_city", syncCustomers.get(0).getCity());
//            intent.putExtra("customer_zip", syncCustomers.get(0).getPostcode());
//            intent.putExtra("customer_phoneno", syncCustomers.get(0).getContact_no());
//            intent.putExtra("customer_email", syncCustomers.get(0).getEmail());
//            intent.putExtra("customer_is_product_tax", syncCustomers.get(0).getIs_product_tax());
//            ctx.startActivity(intent);
//            dialog.dismiss();
//            ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//          }
//        });
//        dialog.show();
//      }
//    });
  }

  //GET TOTAL NUM OF PLAYERS
  @Override
  public int getItemCount() {
    //Toast.makeText(c, ""+customers.size(), Toast.LENGTH_SHORT).show();
    return customers.size();
  }

  //RETURN FILTER OBJ
  @Override
  public Filter getFilter() {
    if (filter == null) {
      filter = new CustomFilter(filterList, this);
    }

    return filter;
  }

}