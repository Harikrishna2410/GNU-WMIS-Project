package com.example.admin.warehousemobileinvoicingsystem.Sync;

public class Reports_model {

  String invoice_no, name, qty, tax, total;

  public String getInvoice_no() {
    return invoice_no;
  }

  public void setInvoice_no(String invoice_no) {
    this.invoice_no = invoice_no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }

  public String getTax() {
    return tax;
  }

  public void setTax(String tax) {
    this.tax = tax;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }
}
