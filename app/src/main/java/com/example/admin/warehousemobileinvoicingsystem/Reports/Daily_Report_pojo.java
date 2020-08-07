package com.example.admin.warehousemobileinvoicingsystem.Reports;

import java.util.ArrayList;

public class Daily_Report_pojo {

  ArrayList<String> orderno, customername, amount;

  public Daily_Report_pojo(ArrayList<String> orderno, ArrayList<String> customername, ArrayList<String> amount) {
    this.orderno = orderno;
    this.customername = customername;
    this.amount = amount;
  }

  public Daily_Report_pojo(Daily_Reports_Activity daily_reports_activity) {
  }

  public ArrayList<String> getOrderno() {
    return orderno;
  }

  public void setOrderno(ArrayList<String> orderno) {
    this.orderno = orderno;
  }

  public ArrayList<String> getCustomername() {
    return customername;
  }

  public void setCustomername(ArrayList<String> customername) {
    this.customername = customername;
  }

  public ArrayList<String> getAmount() {
    return amount;
  }

  public void setAmount(ArrayList<String> amount) {
    this.amount = amount;
  }
}
