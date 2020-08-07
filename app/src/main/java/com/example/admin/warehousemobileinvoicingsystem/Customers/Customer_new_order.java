package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.warehousemobileinvoicingsystem.AllTableNames;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.Orders.Orders_List_Activity;
import com.example.admin.warehousemobileinvoicingsystem.Products.Product_List;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncOrders;

import java.text.DecimalFormat;
import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Customer_new_order extends AppCompatActivity implements CustomAdapter_rv_custneworder.ItemClickListener, AdapterView.OnItemSelectedListener {

    //region ================================================   Global Declaration area  ===============================================================
    SharedPreferenceForDataTransfer spdt;
    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    Button btn_add_item, btn_scan, btn_pay;
    LinearLayout linearLayout;
    Bundle bundle;
    Bundle productBundle;
    Spinner spinner;
    TextView tv_order_activity_subtotal, tv_order_activity_grandDiscount, tv_order_activity_qtytotal, tv_order_activity_grandTotal, tv_order_activity_salestax, tv_order_activity_orderid, tv_storename, tv_invoiceno;
    ArrayList<String> arrayList_prod_barcode = new ArrayList<String>();
    ArrayList<String> arrayList_prod_qty = new ArrayList<String>();
    ArrayList<String> arrayList_prod_cost = new ArrayList<String>();
    ArrayList<String> arrayList_prod_price = new ArrayList<String>();
    ArrayList<String> arrayList_prod_desc = new ArrayList<String>();
    ArrayList<String> arrayList_prod_total = new ArrayList<String>();
    ArrayList<String> arrayList_prod_taxable = new ArrayList<String>();
    ArrayList<String> arrayList_prod_tax_rate = new ArrayList<String>();
    ArrayList<String> arrayList_prod_total_tax = new ArrayList<String>();
    ArrayList<String> arrayList_prod_id = new ArrayList<String>();

    ArrayList<String> arrayList_prod_discount_type = new ArrayList<String>();
    ArrayList<String> arrayList_prod_discount_rate = new ArrayList<String>();
    ArrayList<String> arrayList_prod_total_discount = new ArrayList<String>();

    CustomAdapter_rv_custneworder adapter;
    Double subtotal = 0.00, tax_amount = 0.00;
    Integer total_qty = 0, check = 0;
    AllTableNames tn;
    DecimalFormat df = new DecimalFormat("#.00");
    DbHelper dbHelper;
    String getSelected_tax_rule_id;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        bindAllcontrols();
        tn = new AllTableNames();
        dbHelper = new DbHelper(this);
        bundle = getIntent().getExtras();
        spdt = new SharedPreferenceForDataTransfer(this);
        df = new DecimalFormat("#.00");
        spinner.setOnItemSelectedListener(this);

        if (spdt.pref_data_transfer.getString("side", null).equals("customerside")) {
            tv_storename.setText(spdt.pref_data_transfer.getString("customer_name", ""));
            Integer invoiceno = null;

            if (spdt.pref_client.getString("default_order_type", null).equals("Invoice")) {

                spinner.setSelection(0);
                if (spinner.getSelectedItem().equals("Invoice")) {
                    invoiceno = Integer.parseInt(spdt.pref_client.getString("client_invoice_no", null));
                }

            } else if (spdt.pref_client.getString("default_order_type", null).equals("Estimate")) {

                spinner.setSelection(2);
                if (spinner.getSelectedItem().equals("Estimate")) {
                    invoiceno = Integer.parseInt(spdt.pref_client.getString("client_estimate_no", null));
                }

            } else if (spdt.pref_client.getString("default_order_type", null).equals("Sales Order")) {
                spinner.setSelection(1);
                if (spinner.getSelectedItem().equals("Sales Order")) {
                    invoiceno = Integer.parseInt(spdt.pref_client.getString("client_sales_order_no", null));
                }
            }
            invoiceno++;
            tv_invoiceno.setText(invoiceno.toString());
        }

        else if (spdt.pref_data_transfer.getString("side", null).equals("orderside")) {
            //Toast.makeText(this, "orderssssside", Toast.LENGTH_SHORT).show();
            bundle = getIntent().getExtras();
            tv_storename.setText(bundle.getString("name"));
            tv_invoiceno.setText(bundle.getString("invoice_no"));
            tv_order_activity_orderid.setText(bundle.getString("orderid"));
            String get_order_type = bundle.getString("ordertype");
            spinner.setSelection(((ArrayAdapter<String>) spinner.getAdapter()).getPosition(get_order_type));
            getAllProductsForOrderid();
        }

        // tool bar binding // HK
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //------------On Save button clicked event--------------------------------------------------
        btn_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spdt.editor_data_tranfer.putString("item_added_to_rv", "no");
                spdt.editor_data_tranfer.putString("item_selected_for_update", "no");
                spdt.editor_data_tranfer.putString("product_scanned", "0");
                spdt.editor_data_tranfer.commit();
                Intent intent = new Intent(Customer_new_order.this, Product_List.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        // set up the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPhoneCameraPermission();

            }
        });

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Double.parseDouble(tv_order_activity_grandTotal.getText().toString()) > 0) {
                    Intent intent = new Intent(Customer_new_order.this, Order_pay_activity.class);
                    intent.putExtra("tv_invoiceno", tv_invoiceno.getText().toString());
                    intent.putExtra("tv_totalwithtax", tv_order_activity_grandTotal.getText().toString());
                    intent.putExtra("tv_title", spinner.getSelectedItem().toString());
                    startActivityForResult(intent, 12);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else {

                    new SweetAlertDialog(Customer_new_order.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Oops...")
                            .setContentText("Please add items to Order before Pay !!!")
                            .show();

//                    final Dialog dialog = new Dialog(Customer_new_order.this);
//                    dialog.setContentView(R.layout.exit_dialog_new_orders);
//                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                    int width = ViewGroup.LayoutParams.MATCH_PARENT;
//                    int height = ViewGroup.LayoutParams.WRAP_CONTENT;
//                    dialog.getWindow().setLayout(width, height);
//
//                    TextView main_message = dialog.findViewById(R.id.order_exit_dialog_txtv_main_message);
//                    TextView message = dialog.findViewById(R.id.order_exit_dialog_txtv_message1);
//                    Button yes = dialog.findViewById(R.id.order_exit_dialog_btn_yes);
//                    Button no = dialog.findViewById(R.id.order_exit_dialog_btn_no);
//
//                    main_message.setText("Error");
//                    message.setText("Please add items to Order before Pay.");
//
//                    yes.setText("OK");
//                    yes.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            dialog.dismiss();
//                        }
//                    });
//
//                    no.setVisibility(View.GONE);
//                    dialog.show();
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }
        });
    }

    private void showPhoneCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            //Toast.makeText(this, "Camera permission Granted", Toast.LENGTH_SHORT).show();
            //If permission is previously granted get imei  -- inside imei call api to send imei
            //getIMEI();
            Intent intent = new Intent(getApplicationContext(), ScanActivity.class);
            startActivityForResult(intent, 1);
            spdt.editor_data_tranfer.putString("product_scanned", "1");
            spdt.editor_data_tranfer.commit();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        } else {
            //requesting for READ_PHONE_STATE permissions
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(getApplicationContext(), "pPermission granted ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ScanActivity.class);
                    startActivityForResult(intent, 1);
                    spdt.editor_data_tranfer.putString("product_scanned", "1");
                    spdt.editor_data_tranfer.commit();
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    //getIMEI();
                    //alertDialogss.dismiss();
                } else {
                    //Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();

                    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //finish();
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Warning")
                            .setMessage(R.string.no_camera_permission)
                            .setPositiveButton(R.string.ok, listener)
                            .show();
                }
                return;
            }
        }
    }

    private void getAllProductsForOrderid() {
        //Toast.makeText(this, "getAllProductsForOrderid called...", Toast.LENGTH_SHORT).show();

        SQLiteDatabase db = openOrCreateDatabase("WMIS.db", MODE_PRIVATE, null);

/*
       select o.client_id, c.is_product_tax  as is_cust_taxable, c.name as cust_name, p.id, p.barcodeno, p.name,
        od.quantity, round(p.cost,2), od.price, sum(od.quantity*od.price) as total, od.discount_type, od.discount_rate,

        case when od.discount_type=0 then round(od.price * od.quantity * od.discount_rate/100 ,2)
             else round(od.quantity * od.discount_rate,2)  end as totalDiscount,

        round(sum(od.quantity*od.price) - (case when od.discount_type=0 then od.price * od.quantity * od.discount_rate/100
             else od.quantity * od.discount_rate  end),2) as priceAftDisc,

        p.is_taxable,
        od.tax_rate,

        case when od.is_taxable=1  and o.is_cust_taxable=1
                    then (sum(od.quantity*od.price) - (case when od.discount_type=0 then od.price * od.quantity * od.discount_rate/100
                                                                  else od.quantity * od.discount_rate  end)) *od.tax_rate/100
             else 0 end
             as totalTax

        from order_details od
        left join products p on p.id = od.product_id
        left join orders o on o.id = od.order_id
        left join tax_rules on p.tax_rule_id = tax_rules.id
        left join customers c on o.customer_id = c.id
        where od.order_id = 2 group by od.id
*/

        Cursor c = db.rawQuery("select o.client_id, c.is_product_tax  as is_cust_taxable, c.name as cust_name, p.id, p.barcodeno, p.name,\n" +
                "        od.quantity, round(p.cost,2), od.price, sum(od.quantity*od.price) as total, od.discount_type, od.discount_rate,\n" +
                "\n" +
                "        case when od.discount_type=0 then round(od.price * od.quantity * od.discount_rate/100 ,2)\n" +
                "             else round(od.quantity * od.discount_rate,2)  end as totalDiscount,\n" +
                "        \n" +
                "        round(sum(od.quantity*od.price) - (case when od.discount_type=0 then od.price * od.quantity * od.discount_rate/100 \n" +
                "             else od.quantity * od.discount_rate  end),2) as priceAftDisc,\n" +
                "             \n" +
                "        p.is_taxable, \n" +
                "        od.tax_rate,\n" +
                "               \n" +
                "        case when od.is_taxable=1  and o.is_cust_taxable=1\n" +
                "                    then (sum(od.quantity*od.price) - (case when od.discount_type=0 then od.price * od.quantity * od.discount_rate/100 \n" +
                "                                                                  else od.quantity * od.discount_rate  end)) *od.tax_rate/100 \n" +
                "             else 0 end\n" +
                "             as totalTax\n" +
                "\n" +
                "        from order_details od \n" +
                "        left join products p on p.id = od.product_id \n" +
                "        left join orders o on o.id = od.order_id \n" +
                "        left join tax_rules on p.tax_rule_id = tax_rules.id \n" +
                "        left join customers c on o.customer_id = c.id \n" +
                "        where od.order_id=" + tv_order_activity_orderid.getText().toString() + " group by od.id;", null);
//                "where od.order_id=" + tv_order_activity_orderid.getText().toString() + " group by od.id;", null)
        if (c.getCount() > 0) {
            arrayList_prod_id.clear();
            arrayList_prod_barcode.clear();
            arrayList_prod_desc.clear();
            arrayList_prod_price.clear();
            arrayList_prod_qty.clear();
            arrayList_prod_discount_type.clear();
            arrayList_prod_discount_rate.clear();
            arrayList_prod_total_discount.clear();
            arrayList_prod_total.clear();
            arrayList_prod_taxable.clear();
            arrayList_prod_total_tax.clear();

            while (c.moveToNext()) {
                arrayList_prod_id.add(c.getString(3));
                arrayList_prod_barcode.add(c.getString(4));
                arrayList_prod_desc.add(c.getString(5));
                arrayList_prod_qty.add(c.getString(6));
                arrayList_prod_cost.add(c.getString(7));
                arrayList_prod_price.add(c.getString(8));
                arrayList_prod_discount_type.add(c.getString(10));
                arrayList_prod_discount_rate.add(c.getString(11));
                arrayList_prod_total_discount.add(c.getString(12));
                arrayList_prod_total.add(c.getString(9));
                arrayList_prod_taxable.add(c.getString(14));
                arrayList_prod_tax_rate.add(c.getString(15));
                arrayList_prod_total_tax.add(c.getString(16));
            }
        }
        //------------------------------

        adapter = new CustomAdapter_rv_custneworder(this, arrayList_prod_barcode, arrayList_prod_desc, arrayList_prod_cost, arrayList_prod_price, arrayList_prod_qty, arrayList_prod_total, arrayList_prod_taxable, arrayList_prod_tax_rate, arrayList_prod_total_tax, arrayList_prod_id, arrayList_prod_discount_type, arrayList_prod_discount_rate, arrayList_prod_total_discount);
        adapter = new CustomAdapter_rv_custneworder(this, arrayList_prod_barcode, arrayList_prod_desc, arrayList_prod_cost, arrayList_prod_price, arrayList_prod_qty, arrayList_prod_total, arrayList_prod_taxable, arrayList_prod_tax_rate, arrayList_prod_total_tax, arrayList_prod_id, arrayList_prod_discount_type, arrayList_prod_discount_rate, arrayList_prod_total_discount);
        adapter.setClickListener(Customer_new_order.this);
        recyclerView.setAdapter(adapter);
        tv_order_activity_subtotal.setText(df.format(Double.parseDouble(adapter.grandTotal().toString())));
        tv_order_activity_salestax.setText(df.format(Double.parseDouble(adapter.calc_tax().toString())));
        tv_order_activity_qtytotal.setText(adapter.grandQty().toString());
        double total_with_tax = Double.parseDouble(tv_order_activity_subtotal.getText().toString()) + Double.parseDouble(tv_order_activity_salestax.getText().toString());
        tv_order_activity_grandDiscount.setText("-"+df.format(Double.parseDouble(adapter.grandDiscount().toString())));
        tv_order_activity_grandTotal.setText(String.valueOf(df.format(total_with_tax - Double.parseDouble(adapter.grandDiscount().toString()))));
    }

    @Override
    public void onBackPressed() {
        if (!tv_order_activity_subtotal.getText().equals("0.00")) {

            final Dialog dialog = new Dialog(Customer_new_order.this);
            dialog.setContentView(R.layout.exit_dialog_new_orders);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.setCancelable(false);

            Button yes = dialog.findViewById(R.id.order_exit_dialog_btn_yes);
            Button no = dialog.findViewById(R.id.order_exit_dialog_btn_no);

            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });


            dialog.show();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_order_xml_menu, menu);
//
//        MenuItem menuItem = menu.findItem(R.id.menu_item_delete);
//        if (spdt.pref_data_transfer.getString("side", null).equals("customerside")) {
//            menuItem.setVisible(false);
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu_item_delete:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Delete Order");
                builder.setMessage("Are you sure you want to delete the order ?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteOrder();
                        Intent intent = new Intent(Customer_new_order.this, Orders_List_Activity.class);
                        setResult(13);
                        //startActivity(intent);
                        finish();
                    }
                });
                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteOrder() {
        dbHelper.deleteOrder(this, tv_order_activity_orderid.getText().toString());
        finish();
    }

    private void bindAllcontrols() {
        linearLayout = findViewById(R.id.linearLayoutabc);
        toolbar = findViewById(R.id.toolbar_order_activity);
        btn_add_item = findViewById(R.id.btn_order_activity_additem);
        tv_storename = findViewById(R.id.tv_order_activity_storename);
        tv_invoiceno = findViewById(R.id.tv_order_activity_invoiceno);
        recyclerView = findViewById(R.id.rv_customer_new_order);
        tv_order_activity_subtotal = findViewById(R.id.tv_order_activity_subtotal);
        tv_order_activity_grandDiscount = findViewById(R.id.tv_order_activity_grandDiscount);
        tv_order_activity_qtytotal = findViewById(R.id.tv_order_activity_qtytotal);
        tv_order_activity_grandTotal = findViewById(R.id.tv_order_activity_grandTotal);
        tv_order_activity_salestax = findViewById(R.id.tv_order_activity_salestax);
        tv_order_activity_orderid = findViewById(R.id.tv_order_activity_orderid);
        btn_scan = findViewById(R.id.btn_scan);
        btn_pay = findViewById(R.id.pay_btn_order);
        spinner = findViewById(R.id.spinner_order_activity);
    }

    //******************* THIS METHOD IS CALLED WHEN THIS ACITVITY IS OPENED SECOND TIME WHEN IT IS ALREADY OPENED ********************************
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
//        Toast.makeText(this, "CustNewOrd New intent start", Toast.LENGTH_SHORT).show();

        //************* GETTING PRODUCT BUNDLE FROM PRODUCTS_ADD_ITEM_TO_ORDER.JAVA ****************************************************
        Bundle productBundle = getIntent().getExtras();
        if (getIntent().hasExtra("prod_id")) {
            for (String key : productBundle.keySet()) {
                Log.e("myApplication", key + " is a key in the bundle");
            }
            Double totalTax = 0.00, totalDisc = 0.00, totalBeforeDiscTax = 0.00, subtotal = 0.00;

            String current_qty = productBundle.getString("current_prod_qty_ord");
            String current_prod_price = productBundle.getString("current_prod_price");
            String prod_discount_type = productBundle.getString("prod_discount_type");
            String prod_discount_rate = productBundle.getString("prod_discount_rate");

            //******************************************* CALCULATE TOTAL BEFORE DISCOUNT AND TAX **********************************************
            totalBeforeDiscTax = Double.parseDouble(current_qty) * Double.parseDouble(current_prod_price);
            //*********************************************** CALCULATE TOTAL DISCOUNT **********************************************************
            if (prod_discount_type.equals("0")) {
                totalDisc = (totalBeforeDiscTax * Double.parseDouble(prod_discount_rate) / 100);
            } else {
                totalDisc = Double.parseDouble(prod_discount_rate) * Double.parseDouble(current_qty);
            }
            //************************************* CALCULATE TOTAL TAX ON PRODUCT **************************************************************
            if (productBundle.getString("current_prod_is_taxable").equals("1")
                    && spdt.pref_data_transfer.getString("customer_is_product_tax", null).equals("1")) {
                totalTax = (totalBeforeDiscTax - totalDisc) * Double.parseDouble(productBundle.getString("prod_tax_rate")) / 100;
            } else {
                totalTax = 0.00;
            }
            //*************************************************************************************************************************************************

            if (productBundle.getString("current_prod_barcodeno") != null) {
                Log.e("statuss", "sdfasfassda");
                arrayList_prod_barcode.add(productBundle.getString("current_prod_barcodeno"));
                arrayList_prod_desc.add(productBundle.getString("current_prod_name"));
                arrayList_prod_qty.add(productBundle.getString("current_prod_qty_ord"));
                arrayList_prod_price.add(productBundle.getString("current_prod_price"));
                arrayList_prod_cost.add(productBundle.getString("current_prod_cost"));
                arrayList_prod_total.add(totalBeforeDiscTax.toString());
                arrayList_prod_taxable.add(productBundle.getString("current_prod_is_taxable"));
                arrayList_prod_id.add(productBundle.getString("prod_id"));
                arrayList_prod_tax_rate.add(productBundle.getString("prod_tax_rate"));
                Log.e("statuss", "" + totalTax);
                arrayList_prod_total_tax.add(df.format(totalTax));
                arrayList_prod_discount_type.add(productBundle.getString("prod_discount_type"));
                arrayList_prod_discount_rate.add(productBundle.getString("prod_discount_rate"));
                arrayList_prod_total_discount.add(df.format(totalDisc));

                adapter = new CustomAdapter_rv_custneworder(this, arrayList_prod_barcode, arrayList_prod_desc, arrayList_prod_cost, arrayList_prod_price,
                        arrayList_prod_qty, arrayList_prod_total, arrayList_prod_taxable, arrayList_prod_tax_rate, arrayList_prod_total_tax, arrayList_prod_id,
                        arrayList_prod_discount_type, arrayList_prod_discount_rate, arrayList_prod_total_discount);
                adapter.setClickListener(Customer_new_order.this);
                recyclerView.setAdapter(adapter);
            }
            //**********************************  SET total qty / total / cal_tax  **********************************************************************
            updateOrderTotal();
        } else {
            //**************** THIS IS CALLED WHEN WE DELETE ITEM FROM RV IN CUSTOMER NEW ORDER UPDATING BELOW DATA  *********************************************************
            //**********************************  SET total qty / total / cal_tax  **********************************************************************
            updateOrderTotal();
        }
    }

    private void updateOrderTotal() {
        tv_order_activity_subtotal.setText(df.format(Double.parseDouble(adapter.grandTotal().toString())));
        tv_order_activity_qtytotal.setText(adapter.grandQty().toString());
        tv_order_activity_grandDiscount.setText( "-" + df.format(Double.parseDouble(adapter.grandDiscount().toString())));
        tv_order_activity_salestax.setText(df.format(Double.parseDouble(adapter.calc_tax().toString())));
        double total_with_tax = Double.parseDouble(tv_order_activity_subtotal.getText().toString()) + Double.parseDouble(tv_order_activity_salestax.getText().toString())
                - Double.parseDouble(tv_order_activity_grandDiscount.getText().toString());
        tv_order_activity_grandTotal.setText(String.valueOf(df.format(total_with_tax)));
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        ArrayList<String> arrProdBarcode = new ArrayList<String>();
        ArrayList<String> arrProdName = new ArrayList<String>();
        ArrayList<String> arrProdPrice = new ArrayList<String>();
        ArrayList<String> arrProdCost = new ArrayList<String>();
        ArrayList<String> arrProdID = new ArrayList<String>();
        ArrayList<String> arrProdDiscountType = new ArrayList<String>();
        ArrayList<String> arrProdDiscountRate = new ArrayList<String>();
        ArrayList<String> arrProdIsTaxable = new ArrayList<String>();
        ArrayList<String> arrProdTaxRate = new ArrayList<String>();

        //region REQUEST CODE 12 IS CALLED WHEN YOU SAVE ORDER FROM ORDERSIDE
        if (requestCode == 12 && resultCode == RESULT_OK) {
//            Toast.makeText(this, "onActivityResult Request Code 12", Toast.LENGTH_SHORT).show();
            SaveOrdertoOrderTable();
            Intent returnIntent = new Intent();
            setResult(RESULT_OK, returnIntent);
            finish();
        }
        //endregion

        //region Request code 11 is called when item is updated
        if (requestCode == 11 && resultCode == RESULT_OK) {
//            Toast.makeText(this, "request code 11 called", Toast.LENGTH_SHORT).show();
            if (spdt.pref_data_transfer.getString("side", null).equals("customerside")) {
                //=======================   Function for updating Products    ===================================================
                //==================  The below code will update the items in the list.  ==================================
                updateProductsInRecyclerView(data);
            } else if (spdt.pref_data_transfer.getString("side", null).equals("orderside")) {
                String customer_tax_rate = spdt.pref_data_transfer.getString("customer_tax_rate", null);
                updateProductsInRecyclerView(data);
            }
        }
        //endregion

        //region *********************  THIS METHOD WILL PROCESS BARCODE VALUE RECEIVED FROM SCANACTIVITY  ******************************************************
        if (resultCode == 1) {

//            Toast.makeText(Customer_new_order.this, "request code 1 called... CUSTOMER_NEW_ORDER.JAVA", Toast.LENGTH_SHORT).show();
            //************************************************ WILL FETCH BARCODE RECEIVED FROM SCANACTIVITY ****************************************************
            String fetched_barcode = data.getStringExtra("barcode_Value");
            fetched_barcode = fetched_barcode.trim();

            //region Fetch_data_from_sqlite_database
            SQLiteDatabase db = openOrCreateDatabase("WMIS.db", MODE_PRIVATE, null);
/*
            select p.id, p.barcodeno,p.name, p.price, p.cost, p.is_taxable, tr.rate as tax_rate, p.discount_type, p.discount_rate  from products p
            left join tax_rules tr on tr.id = p.tax_rule_id
            where p.barcodeno='3882620775'
*/
            Cursor c = db.rawQuery("select p.id, p.barcodeno,p.name, p.price, p.cost, p.is_taxable, tr.rate as tax_rate, p.discount_type, p.discount_rate  from products p\n" +
                    "left join tax_rules tr on tr.id = p.tax_rule_id\n" +
                    "where p.barcodeno='" + fetched_barcode + "'", null);
            if (c.getCount() > 0) {

                while (c.moveToNext()) {
                    arrProdID.add(c.getString(0));
                    arrProdBarcode.add(c.getString(1));
                    arrProdName.add(c.getString(2));
                    arrProdPrice.add(String.valueOf(df.format(c.getDouble(3))));
                    arrProdCost.add(c.getString(4));
                    arrProdIsTaxable.add(c.getString(5));
                    arrProdTaxRate.add(c.getString(6));
                    arrProdDiscountType.add(c.getString(7));
                    arrProdDiscountRate.add(c.getString(8));
                }

                Intent intent = new Intent(this, Products_Add_Item_To_Order.class);
                intent.putExtra("prod_id", arrProdID.get(0));
                intent.putExtra("prod_barcodeno", arrProdBarcode.get(0));
                intent.putExtra("prod_name", arrProdName.get(0));
                intent.putExtra("prod_cost", arrProdCost.get(0));
                intent.putExtra("prod_price", arrProdPrice.get(0));
                intent.putExtra("prod_qty_ord", "1");
                intent.putExtra("prod_is_taxable", arrProdIsTaxable.get(0));
                intent.putExtra("prod_tax_rate", arrProdTaxRate.get(0));
                intent.putExtra("prod_discount_type", arrProdDiscountType.get(0));
                intent.putExtra("prod_discount_rate", arrProdDiscountRate.get(0));
                //  THIS WILL SAVE PRODUCT IS TAXABLE IN SHARED PREF FOR RETRIEVAL IN PRODUCTS_ADD_ITEM_TO_ORDER
                spdt.editor_data_tranfer.putString("product_is_taxable", arrProdIsTaxable.get(0));
                spdt.editor_data_tranfer.commit();
                startActivityForResult(intent, 11);
            } else {
                //*********** SHOW SWEET ALERT DIALOG **************************************************
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Product not found !!!")
                        .show();
            }
            //endregion
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        } else {
            //Toast.makeText(this, "Request Canceled", Toast.LENGTH_SHORT).show();
        }
        //endregion

    }


    //*********** THIS METHOD IS CALLED WHEN WE CLICK TO EDIT ITEM IN CUSTOMER NEW ORDER ACTIVITY ********
    //************ ACCESS RV ITEMS VALUES USING POSITION IN THIS METHOD *********************************
    @Override
    public void onItemClick(View view, int position) {
//        Toast.makeText(this, "item clicked for edit", Toast.LENGTH_SHORT).show();

        spdt.editor_data_tranfer.putString("item_selected_for_update", "yes");
        spdt.editor_data_tranfer.putInt("position", position);
        spdt.editor_data_tranfer.commit();
//        Toast.makeText(this, ""+adapter.getTotalTax(position), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, ""+adapter.getTotalDiscount(position), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Products_Add_Item_To_Order.class);
        productBundle = getIntent().getExtras();
        //  TOTAL 13 ITEMS SET IN RECYCLER VIEW WHICH WE CAN FETCH VALUE OF
        productBundle.putString("prod_id", adapter.getProdid(position));
        productBundle.putString("prod_barcodeno", adapter.getBarcode(position));
        productBundle.putString("prod_qty_ord", adapter.getQty(position));
        productBundle.putString("prod_cost", adapter.getCost(position));
        productBundle.putString("prod_price", adapter.getPrice(position));
        productBundle.putString("prod_name", adapter.getDesc(position));
        productBundle.putString("prod_is_taxable", adapter.getTaxable(position));
        productBundle.putString("prod_tax_rate", adapter.getTaxRate(position));
        productBundle.putString("prod_total_tax", adapter.getTotalTax(position));
        productBundle.putString("prod_discount_type", adapter.getDiscountType(position));
        productBundle.putString("prod_discount_rate", adapter.getDiscountRate(position));
        productBundle.putString("prod_total_discount", adapter.getTotalDiscount(position));
        productBundle.putString("prod_total_amount", adapter.getTotal(position));
        intent.putExtras(productBundle);
        //********** THIS WILL START PRODUCTS_ADD_ITEM_TO_ORDER ACTIVITY AND WE SEND CODE:11 TO THAT ACTIVITY *********************
        //**************************** WHEN THAT ACIVITY IS CLOSED IT WILL RETURN RESULT CODE 11 **************
        //*********** DIRECTLY GO TO BELOW METHOD NAMED updateProductsInRecyclerView *****************
        startActivityForResult(intent, 11);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    // code 11 THIS METHOD IS CALLED WHEN WE RETURN BACK TO THIS ACTIVITY AFTER EDITING AN ITEM IN RECYCLER VIEW
    private void updateProductsInRecyclerView(Intent data) {
//        Toast.makeText(this, "Code 11 update products data in recycler view", Toast.LENGTH_SHORT).show();

        Integer position = spdt.pref_data_transfer.getInt("position", 0);

        //************  SETTING DATA BACK IN RECYCLER VIEW [ DATA RECIEVED FROM PRODUCTS_ADD_ITEM_TO_ORDER (ITEM SELECTED FOR UPDATE)]
        //****************  USE Intent data in parameter to access values passed from Products_add_item_to_order ****************
        arrayList_prod_id.set(position, data.getExtras().getString("prod_id"));
        arrayList_prod_barcode.set(position, data.getExtras().getString("prod_barcodeno"));
        arrayList_prod_qty.set(position, data.getExtras().getString("prod_qty_ord"));
        arrayList_prod_price.set(position, data.getExtras().getString("prod_price"));
        arrayList_prod_cost.set(position, data.getExtras().getString("prod_cost"));
        arrayList_prod_desc.set(position, data.getExtras().getString("prod_name"));
        arrayList_prod_taxable.set(position, data.getExtras().getString("prod_is_taxable"));
        arrayList_prod_tax_rate.set(position, data.getExtras().getString("prod_tax_rate"));
        arrayList_prod_total_tax.set(position, data.getExtras().getString("prod_total_tax"));
        arrayList_prod_discount_type.set(position, data.getExtras().getString("prod_discount_type"));
        arrayList_prod_discount_rate.set(position, data.getExtras().getString("prod_discount_rate"));
        arrayList_prod_total_discount.set(position, data.getExtras().getString("prod_total_discount"));
        arrayList_prod_total.set(position, data.getExtras().getString("prod_total_price"));
        adapter.notifyItemChanged(position);


        //=========================  set totalQty and total of all products   ===========================================
        tv_order_activity_subtotal.setText(df.format(Double.parseDouble(adapter.grandTotal().toString())));
        tv_order_activity_qtytotal.setText(adapter.grandQty().toString());
        tv_order_activity_grandDiscount.setText( "-" + df.format(Double.parseDouble(adapter.grandDiscount().toString())));
        tv_order_activity_salestax.setText(df.format(Double.parseDouble(adapter.calc_tax().toString())));
        double grandTotal = Double.parseDouble(tv_order_activity_subtotal.getText().toString())
                + Double.parseDouble(tv_order_activity_salestax.getText().toString())
                - Double.parseDouble(tv_order_activity_grandDiscount.getText().toString());
        tv_order_activity_grandTotal.setText(String.valueOf(df.format(grandTotal)));
    }

    public void SaveOrdertoOrderTable() {
        dbHelper.getWritableDatabase();
        ArrayList<SyncOrders> syncOrders = new ArrayList<SyncOrders>();
        SyncOrders ob = new SyncOrders();
        ob.setClient_id(spdt.pref_client.getString("client_id", null));
        ob.setServer_id(spdt.pref_data_transfer.getString("server_id", null));
        ob.setCustomer_id(spdt.pref_data_transfer.getString("customer_id", null));
        ob.setIs_cust_taxable(spdt.pref_data_transfer.getString("customer_is_product_tax", null));
        ob.setSales_rep_id(spdt.pref_client.getString("sales_rep_id", null));
        ob.setSales_rep_name(dbHelper.getSalesRepName(spdt.pref_client.getString("sales_rep_id", null)));
        ob.setInvoice_no(tv_invoiceno.getText().toString());
        ob.setOrder_type(spinner.getSelectedItem().toString());


//        if(spinner.getSelectedItem().toString().equals("Invoice")){
//            ob.setOrder_type("1");
//        } else if(spinner.getSelectedItem().toString().equals("Sales Order")) {
//            ob.setOrder_type("2");
//        } else if(spinner.getSelectedItem().toString().equals("Estimate")) {
//            ob.setOrder_type("3");
//        }

        ob.setId(tv_order_activity_orderid.getText().toString());
        ob.setNotes(spdt.pref_data_transfer.getString("notes", null));
        syncOrders.add(ob);

        //*********************************** THIS METHOD WILL EXECUTE IF WE SAVE ORDER FROM ORDER SIDE  ****************************************************************
        if (spdt.pref_data_transfer.getString("side", null).equals("orderside")) {
            String order_id = tv_order_activity_orderid.getText().toString();

            // ==============This function will update all data from recyclerview to order_details table ============================
            dbHelper.updateOrderDetails(this, order_id, arrayList_prod_id, arrayList_prod_qty, arrayList_prod_price,
                    arrayList_prod_taxable,arrayList_prod_tax_rate,arrayList_prod_discount_type,arrayList_prod_discount_rate);
            //=======================================================================================================================
        }

        //*********************************** THIS METHOD WILL EXECUTE IF WE SAVE ORDER FROM CUSTOMER SIDE  ****************************************************************
        else if (spdt.pref_data_transfer.getString("side", null).equals("customerside")) {

            //**************************************************  INSERTING DATA IN ORDERS TABLE ***************************************************************************
            long rowID = dbHelper.insertOrder(Customer_new_order.this, syncOrders);

            //************* GETTING ORDER ID OF NEW ORDER MADE IN PREVIOUS LINE  *******************************************************************************************
            if (rowID != -1) {
                String newOrderID = String.valueOf(rowID);

//                order_id = dbHelper.getOrderId(Customer_new_order.this, invoiceno);
//                Toast.makeText(this, "New Auto Generated order id = "+ order_id, Toast.LENGTH_SHORT).show();

                //**************************************  INSERTING DATA IN ORDER DETAILS  ************************************************************************************
                dbHelper.insertOrderDetails(this, newOrderID, arrayList_prod_id, arrayList_prod_qty, arrayList_prod_price,
                        arrayList_prod_taxable,arrayList_prod_tax_rate,arrayList_prod_discount_type,arrayList_prod_discount_rate);
                Integer invoicenumber = Integer.parseInt(tv_invoiceno.getText().toString());
                if (spinner.getSelectedItem().equals("Invoice")) {
                    //Toast.makeText(this, "Invoice", Toast.LENGTH_SHORT).show();
                    spdt.editor_client.putString("client_invoice_no", invoicenumber.toString());
                } else if (spinner.getSelectedItem().equals("Sales Order")) {
                    //Toast.makeText(this, "Sales Order", Toast.LENGTH_SHORT).show();
                    spdt.editor_client.putString("client_sales_order_no", invoicenumber.toString());
                } else {
                    //Toast.makeText(this, "Estimate", Toast.LENGTH_SHORT).show();
                    spdt.editor_client.putString("client_estimate_no", invoicenumber.toString());
                }
                spdt.editor_client.commit();
                finish();

                //================== To Redirect to Home Page/Main menu ==================//
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (++check > 1) {
            Integer invoiceno = null;
            //Toast.makeText(Customer_new_order.this, "" + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            if (position == 0) {
                invoiceno = Integer.parseInt(spdt.pref_client.getString("client_invoice_no", null));
            } else if (position == 1) {
                invoiceno = Integer.parseInt(spdt.pref_client.getString("client_sales_order_no", null));
            } else if (position == 2) {
                invoiceno = Integer.parseInt(spdt.pref_client.getString("client_estimate_no", null));
            }
            invoiceno++;
            tv_invoiceno.setText(invoiceno.toString());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
