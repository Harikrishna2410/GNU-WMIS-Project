package com.example.admin.warehousemobileinvoicingsystem.Orders;

import java.util.ArrayList;

public class Order_List_Pojo_Class {

  ArrayList<String> arr_invoiceno = new ArrayList<String>();
  ArrayList<String> arr_id = new ArrayList<String>();
  ArrayList<String> arr_order_type = new ArrayList<String>();
  ArrayList<String> arr_customer_name = new ArrayList<String>();
  ArrayList<String> arr_is_cust_tax = new ArrayList<String>();


  public ArrayList<String> getArr_is_product_tax() {
    return arr_is_cust_tax;
  }

  public void setArr_is_product_tax(ArrayList<String> arr_is_product_tax) {
    this.arr_is_cust_tax = arr_is_product_tax;
  }

  public Order_List_Pojo_Class() {
  }

  public ArrayList<String> getArr_invoiceno() {
    return arr_invoiceno;
  }

  public void setArr_invoiceno(ArrayList<String> arr_invoiceno) {
    this.arr_invoiceno = arr_invoiceno;
  }

  public ArrayList<String> getArr_id() {
    return arr_id;
  }

  public void setArr_id(ArrayList<String> arr_id) {
    this.arr_id = arr_id;
  }

  public ArrayList<String> getArr_order_type() {
    return arr_order_type;
  }

  public void setArr_order_type(ArrayList<String> arr_order_type) {
    this.arr_order_type = arr_order_type;
  }

  public ArrayList<String> getArr_customer_name() {
    return arr_customer_name;
  }

  public void setArr_customer_name(ArrayList<String> arr_customer_name) {
    this.arr_customer_name = arr_customer_name;
  }

  public ArrayList<String> getArr_sum_total() {
    return arr_sum_total;
  }

  public void setArr_sum_total(ArrayList<String> arr_sum_total) {
    this.arr_sum_total = arr_sum_total;
  }

  ArrayList<String> arr_sum_total = new ArrayList<String>();
}
