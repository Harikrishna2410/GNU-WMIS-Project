package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

public class Customer_model {
  public ArrayList<String> customers_id_list = new ArrayList<String>();
  public ArrayList<String> customers_name_list = new ArrayList<String>();
  public ArrayList<String> customers_tax_rule_id_list = new ArrayList<String>();
  Context ctx;

  public Customer_model(ArrayList<String> customers_id_list, ArrayList<String> customers_name_list, ArrayList<String> customers_tax_rule_id_list) {
    this.customers_id_list = customers_id_list;
    this.customers_name_list = customers_name_list;
    this.customers_tax_rule_id_list = customers_tax_rule_id_list;
  }

  public Customer_model(Customer_List customer_list) {
    this.ctx = customer_list;
  }

  public Customer_model(Activity ctx) {
    this.ctx = ctx;
  }

  public Customer_model() {

  }

  public Customer_model(ArrayList<String> customers_name_list, ArrayList<String> customers_tax_rule_id_list) {
    this.customers_name_list = customers_name_list;
    this.customers_tax_rule_id_list = customers_tax_rule_id_list;
  }

  public int getSize() {
    return customers_name_list.size();
  }

  public ArrayList<String> getCustomers_id_list() {
    return customers_id_list;
  }

  public void setCustomers_id_list(ArrayList<String> customers_id_list) {
    this.customers_id_list = customers_id_list;
  }

  public ArrayList<String> getCustomers_name_list() {
    return customers_name_list;
  }

  public void setCustomers_name_list(ArrayList<String> customers_name_list) {
    this.customers_name_list = customers_name_list;
  }

  public ArrayList<String> getCustomers_tax_rule_id_list() {
    return customers_tax_rule_id_list;
  }

  public void setCustomers_tax_rule_id_list(ArrayList<String> customers_tax_rule_id_list) {
    this.customers_tax_rule_id_list = customers_tax_rule_id_list;
  }
}
