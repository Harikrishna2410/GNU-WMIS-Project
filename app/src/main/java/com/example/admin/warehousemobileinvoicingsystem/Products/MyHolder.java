package com.example.admin.warehousemobileinvoicingsystem.Products;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.warehousemobileinvoicingsystem.R;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
  TextView tv_barcode, tv_name, tv_qty, tv_price, tv_id;
  CheckBox cb_taxable;
  ImageView imageView;
  ItemClickListener_products itemClickListener;
  LinearLayout stock_name;
  Product_List pl;
  Context ctx;

  public MyHolder(View itemView) {
    super(itemView);
    this.tv_name = itemView.findViewById(R.id.tv_description_custom_prod_rv_layout);
    this.tv_barcode = itemView.findViewById(R.id.tv_barcode_custom_prod_rv_layout);
    this.tv_qty = itemView.findViewById(R.id.tv_qty_custom_prod_rv_layout);
    this.tv_price = itemView.findViewById(R.id.tv_price_custom_prod_rv_layout);
//    this.cb_taxable = itemView.findViewById(R.id.cb_taxable);
//    tv_id = itemView.findViewById(R.id.tv_productid_custom_prod_rv_layout);
//    stock_name = itemView.findViewById(R.id.static_stock_name_linearLayout);
    imageView = itemView.findViewById(R.id.product_imageview);


    itemView.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    this.itemClickListener.onItemClick(v, getLayoutPosition());

  }

  public void setItemClickListener(com.example.admin.warehousemobileinvoicingsystem.Products.ItemClickListener_products ic) {
    this.itemClickListener = ic;
  }
}
