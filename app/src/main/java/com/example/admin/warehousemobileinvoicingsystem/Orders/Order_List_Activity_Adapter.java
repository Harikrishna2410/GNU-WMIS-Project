package com.example.admin.warehousemobileinvoicingsystem.Orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin.warehousemobileinvoicingsystem.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Order_List_Activity_Adapter extends RecyclerView.Adapter<Order_List_Activity_Adapter.ViewHolder> {

  Context context;
  ArrayList<Order_List_Pojo_Class> order_items;
  Order_List_Pojo_Class ob;
  DecimalFormat df;
  private ItemClickListener mClickListener;

  public Order_List_Activity_Adapter(Orders_List_Activity orders_list_activity, ArrayList<Order_List_Pojo_Class> order_items, Order_List_Pojo_Class ob) {
    this.context = orders_list_activity;
    this.order_items = order_items;
    this.ob = ob;
    this.df = new DecimalFormat("#.00");
  }

  @NonNull
  @Override
  public Order_List_Activity_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_list_activity_recyclerview_layout, viewGroup, false);
    ViewHolder vh = new ViewHolder(view);
    return vh;
  }

  @Override
  public void onBindViewHolder(@NonNull final Order_List_Activity_Adapter.ViewHolder viewHolder, int i) {
    //Order_List_Pojo_Class order_list_pojo_class = ob.get(i);
    viewHolder.tv_name.setText(ob.getArr_customer_name().get(i));
    viewHolder.tv_invoiceno.setText("# " + ob.getArr_invoiceno().get(i));
    viewHolder.tv_ordertype.setText(ob.getArr_order_type().get(i));
    viewHolder.tv_orderid.setText(ob.getArr_id().get(i));
    viewHolder.tv_total.setText(df.format(Double.parseDouble(ob.getArr_sum_total().get(i))));
    if (ob.getArr_is_product_tax().get(i).equals("1")) {
      viewHolder.cb_cust_taxable.setChecked(true);
    } else {
      viewHolder.cb_cust_taxable.setChecked(false);
    }

  }

  @Override
  public int getItemCount() {
    return ob.getArr_customer_name().size();
  }

  String getName(int id) {
    return ob.getArr_customer_name().get(id);
  }

  String getInvoiceno(int id) {
    return ob.getArr_invoiceno().get(id);
  }

  String getOrdertype(int id) {
    return ob.getArr_order_type().get(id);
  }

  String getOrderId(int id) {
    return ob.getArr_id().get(id);
  }

  String getTotal(int id) {
    return ob.getArr_sum_total().get(id);
  }

  String get_cb_value(int id) {
    return ob.getArr_is_product_tax().get(id);
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    LinearLayout linearLayout;
    CardView cardView;
    TextView tv_name, tv_invoiceno, tv_orderid, tv_ordertype, tv_total;
    CheckBox cb_cust_taxable;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
//      linearLayout = itemView.findViewById(R.id.linearLayout_order_list_layout);
      cardView = itemView.findViewById(R.id.cardView_orderlist_layout);
      tv_name = itemView.findViewById(R.id.tv_store_name_orderlist_layout);
      tv_invoiceno = itemView.findViewById(R.id.tv_invoice_order_list_layout);
      tv_total = itemView.findViewById(R.id.tv_total_order_list_layout);
      tv_orderid = itemView.findViewById(R.id.tv_order_id_order_list_layout);
      tv_ordertype = itemView.findViewById(R.id.tv_order_type_order_list_layout);
      cb_cust_taxable = itemView.findViewById(R.id.cb_customer_taxable_order_list_layout);
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
    }
  }

  // allows clicks events to be caught
  void setClickListener(Order_List_Activity_Adapter.ItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }

  // parent activity will implement this method to respond to click events
  public interface ItemClickListener {
    void onItemClick(View v, int position);
  }

  public Double grandTotal() {
    Double totalPrice = 0.0;
    for (int i = 0; i < ob.getArr_customer_name().size(); i++) {
      totalPrice += Double.parseDouble(ob.getArr_sum_total().get(i));
    }
    return Double.valueOf(df.format(totalPrice));
  }
}
