package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class CustomAdapter_rv_custneworder extends RecyclerView.Adapter<CustomAdapter_rv_custneworder.MyViewHolder> {

  Context ctx;
  private ArrayList<String> arrayList_prod_barcode, arrayList_prod_desc, arrayList_prod_qty, arrayList_prod_price, arrayList_prod_cost;
  private ArrayList<String> arrayList_prod_total, arrayList_prod_taxable, arrayList_prod_id, arrayList_prod_tax_rate, arrayList_prod_total_tax;
  private ArrayList<String> arrayList_prod_discount_type, arrayList_prod_discount_rate, arrayList_prod_total_discount;
  private ItemClickListener mClickListener;
  private LayoutInflater mInflater;
  int totalQty = 0;
  double totalPrice = 0.00, total_tax = 0.00, total_discount = 0.00;
  SharedPreferences pref1;
  SharedPreferences.Editor editor1;
  SharedPreferenceForDataTransfer spdt;
  DecimalFormat df = new DecimalFormat("#.00");


  public CustomAdapter_rv_custneworder(Customer_new_order customer_new_order,
                                       ArrayList<String> arrayList_prod_barcode,
                                       ArrayList<String> arrayList_prod_desc,
                                       ArrayList<String> arrayList_prod_cost,
                                       ArrayList<String> arrayList_prod_price,
                                       ArrayList<String> arrayList_prod_qty,
                                       ArrayList<String> arrayList_prod_total,
                                       ArrayList<String> arrayList_prod_taxable,
                                       ArrayList<String> arrayList_prod_tax_rate,
                                       ArrayList<String> arrayList_prod_total_tax,
                                       ArrayList<String> arrayList_prod_id,
                                       ArrayList<String> arrayList_prod_discount_type,
                                       ArrayList<String> arrayList_prod_discount_rate,
                                       ArrayList<String> arrayList_prod_total_discount) {
    this.ctx = customer_new_order;
    this.mInflater = LayoutInflater.from(customer_new_order);
    this.arrayList_prod_barcode = arrayList_prod_barcode;
    this.arrayList_prod_desc = arrayList_prod_desc;
    this.arrayList_prod_cost = arrayList_prod_cost;
    this.arrayList_prod_price = arrayList_prod_price;
    this.arrayList_prod_qty = arrayList_prod_qty;
    this.arrayList_prod_total = arrayList_prod_total;
    this.arrayList_prod_taxable = arrayList_prod_taxable;
    this.arrayList_prod_tax_rate = arrayList_prod_tax_rate;
    this.arrayList_prod_total_tax = arrayList_prod_total_tax;
    this.arrayList_prod_id = arrayList_prod_id;
    this.arrayList_prod_discount_type = arrayList_prod_discount_type;
    this.arrayList_prod_discount_rate = arrayList_prod_discount_rate;
    this.arrayList_prod_total_discount = arrayList_prod_total_discount;

    pref1 = this.ctx.getSharedPreferences(spdt.PrefFileDataTransfer, MODE_PRIVATE);
    editor1 = pref1.edit();
  }

  @Override
  public CustomAdapter_rv_custneworder.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
    View view = mInflater.inflate(R.layout.custom_lvlayout_customer_new_order, parent, false);
    return new MyViewHolder(view);
  }

  public void onBindViewHolder(final CustomAdapter_rv_custneworder.MyViewHolder myViewHolder, final int position) {
    try {

      myViewHolder.tv_prod_barcode.setText(arrayList_prod_barcode.get(position));
      myViewHolder.tv_prod_qty.setText(arrayList_prod_qty.get(position));
      myViewHolder.tv_prod_desc.setText(arrayList_prod_desc.get(position));
      myViewHolder.tv_prod_cost.setText("Cost: " + df.format(Double.parseDouble(arrayList_prod_cost.get(position))));
      myViewHolder.tv_prod_price.setText(df.format(Double.parseDouble(arrayList_prod_price.get(position))));
      myViewHolder.tv_prod_total.setText(df.format(Double.parseDouble(arrayList_prod_total.get(position))));
      myViewHolder.tv_product_is_taxable.setText("Is Taxable : " + arrayList_prod_taxable.get(position));
      myViewHolder.tv_prod_id.setText(arrayList_prod_id.get(position));

      myViewHolder.tv_prod_tax_rate.setText("Tax Rate: " + df.format(Double.parseDouble(arrayList_prod_tax_rate.get(position))) + "%  (" + ctx.getString(R.string.Rs) + df.format(Double.parseDouble(arrayList_prod_total_tax.get(position))) + ")");

      myViewHolder.tv_prod_total_tax.setText("Total Tax: " + ctx.getString(R.string.Rs) + df.format(Double.parseDouble(arrayList_prod_total_tax.get(position))));

      myViewHolder.tv_prod_discount_type.setText("Disc Type : " + arrayList_prod_discount_type.get(position));

      myViewHolder.tv_prod_discount_rate.setText(arrayList_prod_discount_type.get(position).equals("1")
              ? "Disc Rate: " + ctx.getString(R.string.Rs) + df.format(Double.parseDouble(arrayList_prod_discount_rate.get(position))) + " (" + ctx.getString(R.string.Rs) + df.format(Double.parseDouble(arrayList_prod_total_discount.get(position))) + ")"
              : "Disc Rate: " + df.format(Double.parseDouble(arrayList_prod_discount_rate.get(position))) + "%  (" + ctx.getString(R.string.Rs) + df.format(Double.parseDouble(arrayList_prod_total_discount.get(position))) + ")");

      myViewHolder.tv_prod_total_discount.setText("Discount: " + ctx.getString(R.string.Rs) + df.format(Double.parseDouble(arrayList_prod_total_discount.get(position))));

      //endregion

      //region ******************** THIS LISTENER WILL DELETE AN ITEM FROM THE LIST *****************************
      myViewHolder.iv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          final Dialog dialog = new Dialog(ctx);
          dialog.setContentView(R.layout.exit_dialog_new_orders);
          dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
          int width = ViewGroup.LayoutParams.MATCH_PARENT;
          int height = ViewGroup.LayoutParams.MATCH_PARENT;
          dialog.getWindow().setLayout(width, height);
          dialog.setCancelable(false);

          Button yes = dialog.findViewById(R.id.order_exit_dialog_btn_yes);
          Button no = dialog.findViewById(R.id.order_exit_dialog_btn_no);
          ImageView img = dialog.findViewById(R.id.exit_dialog_new_order_img);
          TextView tvTitle = dialog.findViewById(R.id.order_exit_dialog_txtv_main_message);
          TextView tvDiscription = dialog.findViewById(R.id.order_exit_dialog_txtv_message1);

          img.setImageResource(R.mipmap.trash_1);
          tvTitle.setText("Are you sure?");
          tvDiscription.setText("Process cannot be undone.");

          yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              arrayList_prod_id.remove(position);
              arrayList_prod_desc.remove(position);
              arrayList_prod_barcode.remove(position);
              arrayList_prod_qty.remove(position);
              arrayList_prod_cost.remove(position);
              arrayList_prod_price.remove(position);
              arrayList_prod_total.remove(position);
              arrayList_prod_taxable.remove(position);
              arrayList_prod_tax_rate.remove(position);
              arrayList_prod_total_tax.remove(position);
              arrayList_prod_discount_type.remove(position);
              arrayList_prod_discount_rate.remove(position);
              arrayList_prod_total_discount.remove(position);
              notifyItemRemoved(position);
              notifyItemRangeChanged(position, arrayList_prod_desc.size());
              Intent intent = new Intent(ctx, Customer_new_order.class);
              ctx.startActivity(intent);
              dialog.dismiss();
            }
          });
          no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              dialog.dismiss();
            }
          });


          dialog.show();
        }
      });
      //endregion
    } catch (Exception e) {
      Toast.makeText(ctx, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public int getItemCount() {
    return arrayList_prod_desc.size();
  }

  public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tv_prod_barcode, tv_prod_qty, tv_prod_cost, tv_prod_price, tv_prod_desc, tv_prod_total, tv_product_is_taxable, tv_prod_tax_rate, tv_prod_total_tax, tv_prod_id;
    TextView tv_prod_discount_type, tv_prod_discount_rate, tv_prod_total_discount;
    ImageView iv;

    public MyViewHolder(View itemView) {
      super(itemView);
      tv_prod_barcode = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_barcode);
      tv_prod_qty = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_qty);
      tv_prod_cost = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_cost);
      tv_prod_price = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_price);
      tv_prod_desc = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_prodescription);
      tv_prod_total = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_total);
      tv_product_is_taxable = itemView.findViewById(R.id.tv_product_is_taxable);
      tv_prod_tax_rate = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_tax_rate);
      tv_prod_total_tax = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_total_tax);
      tv_prod_id = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_prodid);
      tv_prod_discount_type = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_discount_type);
      tv_prod_discount_rate = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_discount_rate);
      tv_prod_total_discount = itemView.findViewById(R.id.tv_custom_lvlayout_cust_new_order_total_discount);
      iv = itemView.findViewById(R.id.iv_trash);
      itemView.setOnClickListener(this);
      iv.setOnClickListener(this);
    }

    public void onClick(View view) {
      if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
    }
  }

  // convenience method for getting data at click position
  String getBarcode(int id) {
    return arrayList_prod_barcode.get(id);
  }

  String getQty(int id) {
    return arrayList_prod_qty.get(id);
  }

  String getCost(int id) {
    return arrayList_prod_cost.get(id);
  }

  String getPrice(int id) {
    return arrayList_prod_price.get(id);
  }

  String getDesc(int id) {
    return arrayList_prod_desc.get(id);
  }

  String getTotal(int id) {
    return arrayList_prod_total.get(id);
  }

  String getTaxable(int id) {
    return arrayList_prod_taxable.get(id);
  }

  String getTotalTax(int id) {
    return arrayList_prod_total_tax.get(id);
  }

  String getTaxRate(int id) {
    return arrayList_prod_tax_rate.get(id);
  }

  String getProdid(int id) {
    return arrayList_prod_id.get(id);
  }

  String getDiscountType(int id) {
    return arrayList_prod_discount_type.get(id);
  }

  String getDiscountRate(int id) {
    return arrayList_prod_discount_rate.get(id);
  }

  String getTotalDiscount(int id) {
    return arrayList_prod_total_discount.get(id);
  }

  // allows clicks events to be caught
  void setClickListener(ItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }

  // parent activity will implement this method to respond to click events
  public interface ItemClickListener {
    void onItemClick(View view, int position);
  }

  public Double grandTotal() {
    totalPrice = 0;
    for (int i = 0; i < arrayList_prod_desc.size(); i++) {
      totalPrice = totalPrice + Double.parseDouble(arrayList_prod_total.get(i));
    }
    return Double.valueOf(df.format(totalPrice));
  }

  public Integer grandQty() {
    totalQty = 0;
    for (int i = 0; i < arrayList_prod_desc.size(); i++) {
      totalQty += Double.parseDouble(arrayList_prod_qty.get(i));
    }
    return totalQty;
  }

  //----------Method to calculate tax on product--------------------------------------------------
  public Double calc_tax() {
    total_tax = 0;
    for (int i = 0; i < arrayList_prod_desc.size(); i++) {
      total_tax += Double.parseDouble(this.arrayList_prod_total_tax.get(i));
    }
    return Double.valueOf(df.format(total_tax));
  }

  public Double grandDiscount() {
    total_discount = 0;
    for (int i = 0; i < arrayList_prod_desc.size(); i++) {
      total_discount += Double.parseDouble(this.arrayList_prod_total_discount.get(i));
    }
    return Double.valueOf(df.format(total_discount));
  }
}
