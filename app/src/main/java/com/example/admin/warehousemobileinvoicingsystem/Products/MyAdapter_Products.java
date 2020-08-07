package com.example.admin.warehousemobileinvoicingsystem.Products;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.admin.warehousemobileinvoicingsystem.Customers.Products_Add_Item_To_Order;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

import java.text.DecimalFormat;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter_Products extends RecyclerView.Adapter<MyAdapter_Products.ViewHolder> implements Filterable {

  Activity ctx;
  public ArrayList<ProductModel> products, filterList;
  CustomFilter_Products filter;
  SharedPreferenceForDataTransfer spdt;
  DecimalFormat df = new DecimalFormat("#.00");

  public MyAdapter_Products(Product_List product_list, ArrayList<ProductModel> products) {
    this.ctx = product_list;
    this.products = products;
    this.filterList = products;
    spdt = new SharedPreferenceForDataTransfer(ctx);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_product_recylerview_layout, parent, false);
    ViewHolder vh = new ViewHolder(view);
    return vh;
  }

  public void onBindViewHolder(@NonNull final MyAdapter_Products.ViewHolder holder, final int position) {
    holder.tv_barcode.setText("Barcode: " + products.get(position).getBarcodeno());
    holder.tv_name.setText(products.get(position).getName());
    holder.tv_price.setText(ctx.getString(R.string.Rs) + df.format(Double.parseDouble(products.get(position).getPrice())));
    holder.tv_qty.setText("Stock - " + products.get(position).getQuantity());
//    holder.tv_id.setText(products.get(position).getId());

    //      THIS GLIDE ID FOR RECYCLERVIEW
    ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
      //we are connected to a network
      final RequestOptions requestOptions = new RequestOptions();
      requestOptions.placeholder(R.drawable.no_image);

      //requestOptions.error(R.drawable.ic_launcher_background);
      requestOptions.error(R.drawable.no_image);
      requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
      requestOptions.skipMemoryCache(true);
//            requestOptions.override(150,150).fitCenter();
      Glide.with(ctx)
              .asBitmap()
              .apply(requestOptions)
              .load(products.get(position).getImgUrl().trim())
              .into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                  holder.imageView.setImageBitmap(resource);
                }
              });
//                    .into(holder.imageView);
    } else {
      holder.imageView.setImageResource(R.drawable.no_image);
    }

    if (spdt.pref_client.getBoolean("hide_inventory", false) == true) {
      holder.tv_qty.setVisibility(View.GONE);
//      holder.stock_name.setVisibility(View.INVISIBLE);
    }


//    if (products.get(position).getIs_taxable().equals("1")) {
//      holder.cb_taxable.setChecked(true);
//    } else {
//      holder.cb_taxable.setChecked(false);
//    }

    holder.imageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final Dialog imageview_dialog = new Dialog(ctx);
//        imageview_dialog.setCancelable(true);
        imageview_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        imageview_dialog.setContentView(R.layout.product_imageview_layout_dialog);
        imageview_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //========================================================
          int h = WindowManager.LayoutParams.MATCH_PARENT;
        int w = WindowManager.LayoutParams.MATCH_PARENT;
        imageview_dialog.getWindow().setLayout(h, w);
        ImageView iv = imageview_dialog.findViewById(R.id.product_dialog_image);
//                Drawable myDrawable = holder.imageView.getDrawable();
        iv.setImageDrawable(holder.imageView.getDrawable());
//        imageview_dialog.setCanceledOnTouchOutside(true);
        imageview_dialog.show();

      }
    });

    holder.Product_row_click.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        //*********************** THIS IS CALLED WHEN YOU COME FROM PRODUCT SIDEN AND OPENS PRODUCTS_EDIT_ITEM ****************************
        if (spdt.pref_data_transfer.getString("side", "").equals("productside")) {
//          Toast.makeText(ctx, "product side", Toast.LENGTH_SHORT).show();
          Intent intent = new Intent(ctx, Products_Edit_Item.class);
          intent.putExtra("products_barcode_list", products.get(position).getBarcodeno());
          intent.putExtra("products_name_list", products.get(position).getName());
          intent.putExtra("products_price_list", products.get(position).getPrice());
          intent.putExtra("product_id_list", products.get(position).getId());
          intent.putExtra("product_stock_qty", products.get(position).getQuantity());
          intent.putExtra("product_category_name", products.get(position).getCategory_name());
          intent.putExtra("product_discount", products.get(position).getDiscount_amount());
          intent.putExtra("product_expiry", products.get(position).getExpires_at());
          intent.putExtra("product_discounttype", products.get(position).getDiscount_type());
          intent.putExtra("product_discountrate", products.get(position).getDiscount_rate());
          intent.putExtra("product_price", products.get(position).getPrice());
          intent.putExtra("product_cost", products.get(position).getCost());
          intent.putExtra("product_name", products.get(position).getName());
          intent.putExtra("product_quantity", products.get(position).getQuantity());
          intent.putExtra("product_istaxable", products.get(position).getIs_taxable());
          spdt.editor_data_tranfer.putString("product_is_taxable", products.get(position).getIs_taxable());
          spdt.editor_data_tranfer.commit();
          ctx.startActivityForResult(intent, 0);
          ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }

        //***************************************  THIS IS CALLED WHEN YOU COME FROM CUSTOMER SIDE **************************************
        else if (spdt.pref_data_transfer.getString("side", null).equals("customerside")) {
//                    Toast.makeText(ctx, "customer side", Toast.LENGTH_SHORT).show();

          Intent intent = new Intent(ctx, Products_Add_Item_To_Order.class);
          intent.putExtra("prod_id", products.get(position).getId());
          intent.putExtra("prod_barcodeno", products.get(position).getBarcodeno());
          intent.putExtra("prod_name", products.get(position).getName());
          intent.putExtra("prod_cost", products.get(position).getCost());
          intent.putExtra("prod_price", products.get(position).getPrice());
          intent.putExtra("prod_discount_type", products.get(position).getDiscount_type());
          intent.putExtra("prod_discount_rate", products.get(position).getDiscount_rate());
          intent.putExtra("prod_discount_amount", products.get(position).getDiscount_amount());
          intent.putExtra("prod_is_taxable", products.get(position).getIs_taxable());
          intent.putExtra("prod_tax_rate", products.get(position).getTax_rate());
          intent.putExtra("prod_tax_amount", products.get(position).getTax_on_discounted_price());

//                    Toast.makeText(ctx, "pAdapter - disc rate = "+products.get(position).getDiscount_rate(), Toast.LENGTH_SHORT).show();
//          Toast.makeText(ctx, "pAdapter - p_id = " + products.get(position).getId(), Toast.LENGTH_SHORT).show();

          spdt.editor_data_tranfer.putString("product_is_taxable", products.get(position).getIs_taxable());
          spdt.editor_data_tranfer.commit();
          ctx.setResult(0, intent);
          ctx.startActivity(intent);
          ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
          ctx.finish();
        }

        //***** THIS IS CALLED WHEN YOU COME FROM ORDER SIDE TO EDIT OR DELETE ITEM
        else if (spdt.pref_data_transfer.getString("side", "").equals("orderside")) {

//          Toast.makeText(ctx, "order side", Toast.LENGTH_SHORT).show();

          Intent intent = new Intent(ctx, Products_Add_Item_To_Order.class);
          Bundle productBundle = new Bundle();
          productBundle.putString("prod_id", products.get(position).getId());
          productBundle.putString("prod_barcodeno", products.get(position).getBarcodeno());
          productBundle.putString("prod_name", products.get(position).getName());
          productBundle.putString("prod_cost", products.get(position).getCost());
          productBundle.putString("prod_price", products.get(position).getPrice());
          productBundle.putString("prod_discount_type", products.get(position).getDiscount_type());
          productBundle.putString("prod_discount_rate", products.get(position).getDiscount_rate());
          productBundle.putString("prod_discount_amount", products.get(position).getDiscount_amount());
          productBundle.putString("prod_is_taxable", products.get(position).getIs_taxable());
          productBundle.putString("prod_tax_rate", products.get(position).getTax_rate());
          productBundle.putString("prod_tax_amount", products.get(position).getTax_on_discounted_price());
          intent.putExtras(productBundle);
          ctx.startActivity(intent);
          ctx.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
          ctx.finish();
        } else {
          Log.e("statusss", "5");
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return products.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    TextView tv_barcode, tv_name, tv_qty, tv_price, tv_id;
    CheckBox cb_taxable;
//    ImageView imageView;
    CircleImageView imageView;
    ItemClickListener_products itemClickListener;
    ConstraintLayout stock_name;
    //    LinearLayout Product_row_click;
    ConstraintLayout Product_row_click;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      tv_name = itemView.findViewById(R.id.tv_description_custom_prod_rv_layout);
      tv_barcode = itemView.findViewById(R.id.tv_barcode_custom_prod_rv_layout);
      tv_qty = itemView.findViewById(R.id.tv_qty_custom_prod_rv_layout);
      tv_price = itemView.findViewById(R.id.tv_price_custom_prod_rv_layout);
//      cb_taxable = itemView.findViewById(R.id.cb_taxable);
//      tv_id = itemView.findViewById(R.id.tv_productid_custom_prod_rv_layout);
//      stock_name = itemView.findViewById(R.id.static_stock_name_linearLayout);
      imageView = itemView.findViewById(R.id.product_imageview);
      Product_row_click = itemView.findViewById(R.id.custom_product_rv_linearlayout);

    }
  }

  @Override
  public Filter getFilter() {
    if (filter == null) {
      filter = new CustomFilter_Products(filterList, this);
    }
    return filter;
  }

}
