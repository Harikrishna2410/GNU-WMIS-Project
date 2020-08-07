package com.example.admin.warehousemobileinvoicingsystem.Customers;

class Customers {
  private String name, tax_rule_id;

  public Customers(String name, String tax_rule_id) {
    this.name = name;
    this.tax_rule_id = tax_rule_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTax_rule_id() {
    return tax_rule_id;
  }

  public void setTax_rule_id(String tax_rule_id) {
    this.tax_rule_id = tax_rule_id;
  }
}
