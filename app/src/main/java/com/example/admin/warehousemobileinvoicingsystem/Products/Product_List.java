package com.example.admin.warehousemobileinvoicingsystem.Products;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.warehousemobileinvoicingsystem.AllTableNames;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product_List extends AppCompatActivity {

  //region==================================== GLOBAL DECLARATION SECTION===============================
//    SharedPreferences pref;
//    SharedPreferences.Editor editor;
  SharedPreferenceForDataTransfer spdt;
  AllTableNames tn;
  //Toolbar toolbar;
  SQLiteDatabase db;
  RecyclerView rv;
  Bundle bundle;
  public MyAdapter_Products adapter;
  boolean shouldExecuteOnResume;
  SearchView searchView;
  ImageView search_by_filter_product_list, product_search_by_barcode;
  ArrayList<ProductModel> products = new ArrayList<ProductModel>();
  ProductModel ob = new ProductModel();
  //endregion

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_list);

    ob = new ProductModel();
    //----------Bind all controls here-----------------------------------------------------------
    bindAllControls();

    //---------Setting Shared preference file for transfer of data -------------------------------
    spdt = new SharedPreferenceForDataTransfer(this);
//        pref = getSharedPreferences(spdt.PrefFileDataTransfer,MODE_PRIVATE);
//        editor = pref.edit();

    //--------- Getting all table names and columns using this class---------------------------------
    tn = new AllTableNames();

    bundle = getIntent().getExtras();
    shouldExecuteOnResume = false;

    androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_productlist_activity);
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//        String url = "http://192.168.1.3/img.jpg";

    adapter = new MyAdapter_Products(Product_List.this, fetchProducts());
    rv.setLayoutManager(new LinearLayoutManager(this));

    rv.setItemAnimator(new DefaultItemAnimator());
    rv.setAdapter(adapter);


    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        return false;
      }

      @Override
      public boolean onQueryTextChange(String query) {
        adapter.getFilter().filter(query);
        return false;
      }
    });

//    search_by_filter_product_list.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//
//      }
//    });
//
//    product_search_by_barcode.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//
//      }
//    });
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

  @Override
  protected void onResume() {
    super.onResume();
    adapter = new MyAdapter_Products(Product_List.this, fetchProducts());
    rv.setLayoutManager(new LinearLayoutManager(this));
    rv.setItemAnimator(new DefaultItemAnimator());
    rv.setAdapter(adapter);
  }

  private void bindAllControls() {
    rv = findViewById(R.id.rv_product_list_activity);
    searchView = findViewById(R.id.product_list_SearchView);
//    search_by_filter_product_list = findViewById(R.id.search_by_filter_product_list);
//    product_search_by_barcode = findViewById(R.id.product_search_by_barcode);
  }

  public ArrayList<ProductModel> fetchProducts() {
    products = new ArrayList<ProductModel>();
    DecimalFormat df = new DecimalFormat("#.00");
    db = openOrCreateDatabase("WMIS.db", MODE_PRIVATE, null);

/*

        select p.id, p.imgUrl, p.barcodeno, p.name, printf ("%.2f",p.cost) as cost, p.quantity, p.is_active, p.reorder_level, p.expires_at, p.days_left,
                tr.id as TaxRuleID,
                c.id as catId, c.name as catName,
                s.id as supId, s.name as supName,

        printf ("%.2f",p.price) as price,
        p.discount_type as discTyp,
        printf ("%.2f",cast(p.discount_rate as float)) as discRate,

        case when p.discount_type = 0 then printf ("%.2f",round((p.price*p.discount_rate/100),2))
             else printf ("%.2f",round(p.discount_rate,2)) end as discAmt,

        case when p.discount_type = 0 then p.price-round((p.price*p.discount_rate/100),2)
             else p.price-round(p.discount_rate,2) end as Price_after_discount,

        p.is_taxable,
        printf ("%.2f",case when tr.rate is null then 0 else tr.rate end) as TaxRate,

        case when p.is_taxable = 1 then printf ("%.2f",round((case when p.discount_type = 0 then p.price-round((p.price*p.discount_rate/100),2)
                                                    else p.price-round(p.discount_rate,2) end) * case when tr.rate is null then 0 else tr.rate end/100,2))
             else printf ("%.2f",0) end as tax_discounted_price,

        case when p.is_taxable = 1 then printf ("%.2f",(case when p.discount_type = 0 then p.price-round((p.price*p.discount_rate/100),2) else p.price-round(p.discount_rate,2) end)
                                      + (case when p.is_taxable = 1 then round((case when p.discount_type = 0 then p.price-round((p.price*p.discount_rate/100),2)
                                              else p.price-round(p.discount_rate,2) end) * case when tr.rate is null then 0 else tr.rate end/100,2)
             else 0 end))
        else printf ("%.2f",0) end as amount_after_tax

        from products p
        left join tax_rules tr on tr.id = p.tax_rule_id
        left join category c on c.id = p.category_id
        left join suppliers s on s.id = p.supplier_id

*/

    Cursor c = db.rawQuery("select p.id, p.imgUrl, p.barcodeno, p.name, printf (\"%.2f\",p.cost) as cost, p.quantity, p.is_active, p.reorder_level, p.expires_at, p.days_left,\n" +
            "                tr.id as TaxRuleID,\n" +
            "                c.id as catId, c.name as catName,\n" +
            "                s.id as supId, s.name as supName,\n" +
            "\n" +
            "        printf (\"%.2f\",p.price) as price, \n" +
            "        p.discount_type as discTyp, \n" +
            "        printf (\"%.2f\",cast(p.discount_rate as float)) as discRate,\n" +
            "        \n" +
            "        case when p.discount_type = 0 then printf (\"%.2f\",round((p.price*p.discount_rate/100),2))\n" +
            "             else printf (\"%.2f\",round(p.discount_rate,2)) end as discAmt,\n" +
            "\n" +
            "        case when p.discount_type = 0 then p.price-round((p.price*p.discount_rate/100),2)\n" +
            "             else p.price-round(p.discount_rate,2) end as Price_after_discount,\n" +
            "            \n" +
            "        p.is_taxable, \n" +
            "        printf (\"%.2f\",case when tr.rate is null then 0 else tr.rate end) as TaxRate,\n" +
            "\n" +
            "        case when p.is_taxable = 1 then printf (\"%.2f\",round((case when p.discount_type = 0 then p.price-round((p.price*p.discount_rate/100),2) \n" +
            "                                                    else p.price-round(p.discount_rate,2) end) * case when tr.rate is null then 0 else tr.rate end/100,2))\n" +
            "             else printf (\"%.2f\",0) end as tax_discounted_price,\n" +
            "    \n" +
            "        \n" +
            "        case when p.is_taxable = 1 then printf (\"%.2f\",(case when p.discount_type = 0 then p.price-round((p.price*p.discount_rate/100),2) else p.price-round(p.discount_rate,2) end) \n" +
            "                                      + (case when p.is_taxable = 1 then round((case when p.discount_type = 0 then p.price-round((p.price*p.discount_rate/100),2) \n" +
            "                                              else p.price-round(p.discount_rate,2) end) * case when tr.rate is null then 0 else tr.rate end/100,2)\n" +
            "             else 0 end))\n" +
            "        else printf (\"%.2f\",0) end as amount_after_tax\n" +
            "            \n" +
            "        from products p\n" +
            "        left join tax_rules tr on tr.id = p.tax_rule_id\n" +
            "        left join category c on c.id = p.category_id\n" +
            "        left join suppliers s on s.id = p.supplier_id", null);

    searchView.setQueryHint(String.valueOf(c.getCount()) + " Products");
    if (c.getCount() > 0) {
      products.clear();
      while (c.moveToNext()) {
        ProductModel ob = new ProductModel();
        ob.setId(c.getString(0));
        ob.setImgUrl(c.getString(1));
        ob.setBarcodeno(c.getString(2));
        ob.setName(c.getString(3));
        ob.setCost(String.valueOf(df.format(c.getDouble(4))));
        ob.setQuantity(c.getString(5));
        ob.setIs_active(c.getString(6));
        ob.setReorder_level(c.getString(7));
        ob.setExpires_at(c.getString(8));
        ob.setDays_left(c.getString(9));
        ob.setTax_rule_id(c.getString(10));
        ob.setCategory_id(c.getString(11));
        ob.setCategory_name(c.getString(12));
        ob.setSupplier_id(c.getString(13));
        ob.setSupplier_name(c.getString(14));
        ob.setPrice(String.valueOf(df.format(c.getDouble(15))));
        ob.setDiscount_type(c.getString(16));
        ob.setDiscount_rate(c.getString(17));
        ob.setDiscount_amount(c.getString(18));
        ob.setPrice_after_discount(c.getString(19));
        ob.setIs_taxable(c.getString(20));
        ob.setTax_rate(c.getString(21));
        ob.setTax_on_discounted_price(c.getString(22));
        ob.setAmount_after_tax(c.getString(23));

        products.add(ob);
      }
    }
    return products;
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == 0 && resultCode == RESULT_OK) {
      Toast.makeText(this, "Product_list.java code 0", Toast.LENGTH_SHORT).show();
      String barcode = data.getExtras().getString("barcode");
      String qty = data.getExtras().getString("qty");
      String price = data.getExtras().getString("price");
      String desc = data.getExtras().getString("name");
      Integer position = spdt.pref_data_transfer.getInt("position", 0);
      adapter.notifyItemChanged(position);
    }
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
  }

}
