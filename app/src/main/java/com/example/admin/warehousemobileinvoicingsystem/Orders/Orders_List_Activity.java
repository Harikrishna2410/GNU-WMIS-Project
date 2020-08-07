package com.example.admin.warehousemobileinvoicingsystem.Orders;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.example.admin.warehousemobileinvoicingsystem.Customers.Customer_new_order;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Orders_List_Activity extends AppCompatActivity implements Order_List_Activity_Adapter.ItemClickListener {

  //region Global Declaration Section
  RecyclerView rv;
  SQLiteDatabase db;
  TextView tv_total;
  private ArrayList<String> arr_invoiceno = new ArrayList<String>();
  private ArrayList<String> arr_id = new ArrayList<String>();
  private ArrayList<String> arr_order_type = new ArrayList<String>();
  private ArrayList<String> arr_customer_name = new ArrayList<String>();
  private ArrayList<String> arr_is_cust_tax = new ArrayList<String>();
  private ArrayList<String> arr_sum_total = new ArrayList<String>();
  private ArrayList<String> arr_tax_rate = new ArrayList<String>();
  private ArrayList<String> arr_tax_ruleid = new ArrayList<String>();
  Order_List_Pojo_Class ob;
  private ArrayList<Order_List_Pojo_Class> order_items = new ArrayList<Order_List_Pojo_Class>();
  public Order_List_Activity_Adapter adapter;
  SharedPreferenceForDataTransfer spdt;
  DecimalFormat df;
  DbHelper dbHelper;
  //endregion

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_orders__list_);
    controlbinding();
    dbHelper = new DbHelper(this);
    spdt = new SharedPreferenceForDataTransfer(this);
    df = new DecimalFormat("#.00");
    ob = new Order_List_Pojo_Class();

    fetchAllOrders();

    androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      try {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Orders");
      } catch (Exception ex) {
        Toast.makeText(this, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
      }
    }
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


  private void fetchAllOrders() {

    //select distinct o.invoice_no,o.id,o.order_type,c.name,sum(od.price*od.quantity) from orders o join customers c on c.id==o.customer_id join order_details od on od.order_id==o.id group by od.order_id;
    //select p.barcodeno,p.name,od.quantity,od.price from order_details od join products p on p.id==od.product_id where order_id ==1;
    db = openOrCreateDatabase("WMIS.db", MODE_PRIVATE, null);

/*
    select o.invoice_no,o.id,o.order_type,c.name,o.is_cust_taxable,
    round(sum(case when p.is_taxable=1 AND c.is_product_tax=1 then (od.quantity*od.price) else od.quantity*od.price end ),2) as total
    from order_details od
    left join products p on p.id = od.product_id
    left join orders o on o.id = od.order_id
    left join tax_rules tr on p.tax_rule_id = tr.id
    left join customers c on o.customer_id=c.id
    group by od.order_id;
*/
    Cursor c = db.rawQuery("    select o.invoice_no,o.id,o.order_type,c.name,o.is_cust_taxable,\n" +
            "    round(sum(case when p.is_taxable=1 AND c.is_product_tax=1 then (od.quantity*od.price) else od.quantity*od.price end ),2) as total \n" +
            "    from order_details od\n" +
            "    left join products p on p.id = od.product_id\n" +
            "    left join orders o on o.id = od.order_id\n" +
            "    left join tax_rules tr on p.tax_rule_id = tr.id\n" +
            "    left join customers c on o.customer_id=c.id\n" +
            "    group by od.order_id;", null);

    arr_invoiceno.clear();
    arr_id.clear();
    arr_order_type.clear();
    arr_sum_total.clear();
    arr_customer_name.clear();
    arr_is_cust_tax.clear();

    if (c.getCount() > 0) {
      while (c.moveToNext()) {
        arr_invoiceno.add(c.getString(0));
        arr_id.add(c.getString(1));
        arr_order_type.add(c.getString(2));
        arr_customer_name.add(c.getString(3));
        arr_is_cust_tax.add(c.getString(4));

        String totalTax = getTotalTax(c.getString(1));
        String totalDiscount = getTotalDiscount(c.getString(1));
        double grandTotal = Double.parseDouble(totalTax) + Double.parseDouble(c.getString(5)) - Double.parseDouble(totalDiscount);
        arr_sum_total.add(String.valueOf(grandTotal));
      }

      ob.setArr_invoiceno(arr_invoiceno);
      ob.setArr_id(arr_id);
      ob.setArr_order_type(arr_order_type);
      ob.setArr_customer_name(arr_customer_name);
      ob.setArr_is_product_tax(arr_is_cust_tax);
      ob.setArr_sum_total(arr_sum_total);
      order_items.add(ob);

      LinearLayoutManager lm = new LinearLayoutManager(this);
      lm.setOrientation(LinearLayoutManager.VERTICAL);
      rv.setLayoutManager(lm);
      adapter = new Order_List_Activity_Adapter(this, order_items, ob);
      adapter.setClickListener(this);
      overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
      rv.setAdapter(adapter);
      tv_total.setText(df.format(Double.parseDouble(adapter.grandTotal().toString())));
    } else {
      tv_total.setText(df.format(Double.parseDouble("0.00")));
      LinearLayoutManager lm = new LinearLayoutManager(this);
      lm.setOrientation(LinearLayoutManager.VERTICAL);
      rv.setLayoutManager(lm);
      adapter = new Order_List_Activity_Adapter(this, order_items, ob);
      adapter.setClickListener(this);
      rv.setAdapter(adapter);
      overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
  }

  private String getTotalDiscount(String orderID) {

/*
        select sum(case when od.discount_type=0 then round(od.price * od.quantity * od.discount_rate/100 ,2)
            else round(od.quantity * od.discount_rate,2)  end) as totalDiscount

        from order_details od
        left join orders o on o.id = od.order_id
        where od.order_id=3
*/

    Cursor cdiscount = db.rawQuery("select sum(case when od.discount_type=0 then round(od.price * od.quantity * od.discount_rate/100 ,2)\n" +
            "            else round(od.quantity * od.discount_rate,2)  end) as totalDiscount\t\n" +
            "    from order_details od\n" +
            "    left join orders o on o.id = od.order_id\n" +
            "    where od.order_id=" + orderID, null);
    while (cdiscount.moveToNext()) {
      return cdiscount.getString(0);
    }
    return "0";
  }

  private String getTotalTax(String orderID) {

/*
        select sum(case when o.is_cust_taxable=1 and od.is_taxable=1
        then (od.quantity*od.price - (case when od.discount_type=0 then od.price * od.quantity * od.discount_rate/100
                                                    else od.quantity * od.discount_rate  end)) *od.tax_rate/100
                else 0 end)
        as totalTax
        from order_details od
        join orders o on o.id = od.order_id
        where od.order_id = 3
*/
    Cursor ctax = db.rawQuery("select sum(case when o.is_cust_taxable=1 and od.is_taxable=1\n" +
            "                then (od.quantity*od.price - (case when od.discount_type=0 then od.price * od.quantity * od.discount_rate/100 \n" +
            "                                                    else od.quantity * od.discount_rate  end)) *od.tax_rate/100 \n" +
            "                else 0 end)\n" +
            "                as totalTax\n" +
            "        from order_details od \n" +
            "        join orders o on o.id = od.order_id \n" +
            "        where od.order_id = " + orderID, null);
    while (ctax.moveToNext()) {
      return ctax.getString(0);
    }
    return "0";
  }

  public void controlbinding() {
    rv = findViewById(R.id.rv_order_list_activity);
    tv_total = findViewById(R.id.tv_total_activity_list);
  }

  @Override
  public void onItemClick(View view, int position) {
//    Toast.makeText(this, "order clicked", Toast.LENGTH_SHORT).show();
    try {
      //String customer_is_product_tax = adapter.get_cb_value(position);
      spdt.editor_data_tranfer.putString("customer_is_product_tax", adapter.get_cb_value(position));
      spdt.editor_data_tranfer.putString("product_is_taxable", "1");
      spdt.editor_data_tranfer.putString("is_order_for_update", "1");
      spdt.editor_data_tranfer.commit();

      Intent intent = new Intent(this, Customer_new_order.class);
      intent.putExtra("invoice_no", adapter.getInvoiceno(position));
      //Toast.makeText(this, "iv# = "+adapter.getInvoiceno(position), Toast.LENGTH_SHORT).show();
      intent.putExtra("name", adapter.getName(position));
      intent.putExtra("orderid", adapter.getOrderId(position));
      intent.putExtra("ordertype", adapter.getOrdertype(position));
      startActivityForResult(intent, 13);
      overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    } catch (Exception ex) {
      Toast.makeText(this, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    fetchAllOrders();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == 13) {
      //Toast.makeText(this, "rq = 13", Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    spdt.editor_data_tranfer.putString("is_order_for_update", "0");
    spdt.editor_data_tranfer.commit();
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
  }

}
