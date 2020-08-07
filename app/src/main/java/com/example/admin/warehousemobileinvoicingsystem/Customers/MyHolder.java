package com.example.admin.warehousemobileinvoicingsystem.Customers;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.*;

import com.example.admin.warehousemobileinvoicingsystem.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

  //OUR VIEWS
  TextView name, tv_address, tv_gstin;
  LinearLayout btn_new_order;
  ConstraintLayout constraintLayout;
  ItemClickListener itemClickListener;

  public MyHolder(View itemView) {
    super(itemView);

    this.name = itemView.findViewById(R.id.tv_customer_name);
    this.tv_address = itemView.findViewById(R.id.tv_cust_address_cust_list);
    this.btn_new_order = itemView.findViewById(R.id.btn_new_order_custlist);
    tv_gstin = itemView.findViewById(R.id.tv_edit_gstin);
    this.constraintLayout = itemView.findViewById(R.id.customer_list_card_name);
    itemView.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    this.itemClickListener.onItemClick(v, getLayoutPosition());

  }

  public void setItemClickListener(ItemClickListener ic) {
    this.itemClickListener = ic;
  }
}