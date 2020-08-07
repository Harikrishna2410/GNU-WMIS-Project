package com.example.admin.warehousemobileinvoicingsystem.Reports;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.*;
import android.widget.*;

import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.Sync.Reports_model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Daily_Reports_adapter extends RecyclerView.Adapter<Daily_Reports_adapter.viewholder> {

  Context ctx;
  //private LayoutInflater mInflater;
  //ArrayList<Daily_Report_pojo> pojos;
  Daily_Report_pojo drp;
  //ArrayList<String> orderno,customer,amount;
  DecimalFormat df;
  ArrayList<Reports_model> reportsModel;

  public Daily_Reports_adapter(Daily_Reports_Activity daily_reports_activity, ArrayList<Reports_model> reportsModel) {
    this.ctx = daily_reports_activity;
    this.reportsModel = reportsModel;
    this.df = new DecimalFormat("#.00");
  }

  @NonNull
  @Override
  public Daily_Reports_adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_for_daily_reports, parent, false);
    Daily_Reports_adapter.viewholder vh = new Daily_Reports_adapter.viewholder(view);
    return vh;
  }

  @Override
  public void onBindViewHolder(@NonNull Daily_Reports_adapter.viewholder viewholder, int i) {
    //Toast.makeText(ctx, "name === "+reportsModel.get(0).getName(), Toast.LENGTH_SHORT).show();
    viewholder.orderno.setText(reportsModel.get(i).getInvoice_no());
    viewholder.customer.setText(reportsModel.get(i).getName());
    viewholder.amount.setText(df.format(Double.parseDouble(reportsModel.get(i).getTotal())));
    viewholder.qty.setText(reportsModel.get(i).getQty());
    if (reportsModel.get(i).getTax().equals("0")) {
      viewholder.tax.setText("-");
    } else {
      viewholder.tax.setText(df.format(Double.parseDouble(reportsModel.get(i).getTax())));
    }

  }

  @Override
  public int getItemCount() {
    return reportsModel.size();
  }

  public Double grandTotal() {

    Double totalPrice = 0.0;
    for (int i = 0; i < drp.getCustomername().size(); i++) {
      totalPrice += Double.parseDouble(drp.getAmount().get(i));
    }
    return Double.valueOf(df.format(totalPrice));

  }

  public class viewholder extends RecyclerView.ViewHolder {

    TextView amount, customer, orderno, qty, tax;

    public viewholder(@NonNull View itemView) {
      super(itemView);
      amount = itemView.findViewById(R.id.amount_custom_lauout_for_daily_reports);
      customer = itemView.findViewById(R.id.customer_name_custom_lauout_for_daily_reports);
      orderno = itemView.findViewById(R.id.order_no_custom_lauout_for_daily_reports);
      qty = itemView.findViewById(R.id.tv_qty_reports);
      tax = itemView.findViewById(R.id.tv_tax_reports);
    }
  }


}
