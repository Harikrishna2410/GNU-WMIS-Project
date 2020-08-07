package com.example.admin.warehousemobileinvoicingsystem.Products;


import android.net.Uri;

public class ProductModel {

  String id;
  String client_id;
  String tax_rule_id;
  String category_id;
  String supplier_id;
  String discountrule_id;
  String imgUrl;
  String barcodeno;
  String name;
  String price;
  String cost;
  String discount_type;
  String discount_rate;
  String quantity;
  String is_active;
  String is_taxable;
  String reorder_level;
  String expires_at;
  String days_left;
  String created_at;
  String updated_at;
  String deleted_at;

  // These fields to show value in product list do not remove or product list will stop working
  String tax_rule_name;
  String tax_rate;
  String category_name;
  String supplier_name;

  String discount_amount;
  String price_after_discount;
  String tax_on_discounted_price;
  String amount_after_tax;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClient_id() {
    return client_id;
  }

  public void setClient_id(String client_id) {
    this.client_id = client_id;
  }

  public String getTax_rule_id() {
    return tax_rule_id;
  }

  public void setTax_rule_id(String tax_rule_id) {
    this.tax_rule_id = tax_rule_id;
  }

  public String getCategory_id() {
    return category_id;
  }

  public void setCategory_id(String category_id) {
    this.category_id = category_id;
  }

  public String getSupplier_id() {
    return supplier_id;
  }

  public void setSupplier_id(String supplier_id) {
    this.supplier_id = supplier_id;
  }

  public String getDiscountrule_id() {
    return discountrule_id;
  }

  public void setDiscountrule_id(String discountrule_id) {
    this.discountrule_id = discountrule_id;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getBarcodeno() {
    return barcodeno;
  }

  public void setBarcodeno(String barcodeno) {
    this.barcodeno = barcodeno;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getCost() {
    return cost;
  }

  public void setCost(String cost) {
    this.cost = cost;
  }

  public String getDiscount_type() {
    return discount_type;
  }

  public void setDiscount_type(String discount_type) {
    this.discount_type = discount_type;
  }

  public String getDiscount_rate() {
    return discount_rate;
  }

  public void setDiscount_rate(String discount_rate) {
    this.discount_rate = discount_rate;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getIs_active() {
    return is_active;
  }

  public void setIs_active(String is_active) {
    this.is_active = is_active;
  }

  public String getIs_taxable() {
    return is_taxable;
  }

  public void setIs_taxable(String is_taxable) {
    this.is_taxable = is_taxable;
  }

  public String getReorder_level() {
    return reorder_level;
  }

  public void setReorder_level(String reorder_level) {
    this.reorder_level = reorder_level;
  }

  public String getExpires_at() {
    return expires_at;
  }

  public void setExpires_at(String expires_at) {
    this.expires_at = expires_at;
  }

  public String getDays_left() {
    return days_left;
  }

  public void setDays_left(String days_left) {
    this.days_left = days_left;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }

  public String getDeleted_at() {
    return deleted_at;
  }

  public void setDeleted_at(String deleted_at) {
    this.deleted_at = deleted_at;
  }

  public String getTax_rule_name() {
    return tax_rule_name;
  }

  public void setTax_rule_name(String tax_rule_name) {
    this.tax_rule_name = tax_rule_name;
  }

  public String getTax_rate() {
    return tax_rate;
  }

  public void setTax_rate(String tax_rate) {
    this.tax_rate = tax_rate;
  }

  public String getCategory_name() {
    return category_name;
  }

  public void setCategory_name(String category_name) {
    this.category_name = category_name;
  }

  public String getSupplier_name() {
    return supplier_name;
  }

  public void setSupplier_name(String supplier_name) {
    this.supplier_name = supplier_name;
  }

  public String getDiscount_amount() {
    return discount_amount;
  }

  public void setDiscount_amount(String discount_amount) {
    this.discount_amount = discount_amount;
  }


  public String getPrice_after_discount() {
    return price_after_discount;
  }

  public void setPrice_after_discount(String price_after_discount) {
    this.price_after_discount = price_after_discount;
  }

  public String getTax_on_discounted_price() {
    return tax_on_discounted_price;
  }

  public void setTax_on_discounted_price(String tax_on_discounted_price) {
    this.tax_on_discounted_price = tax_on_discounted_price;
  }

  public String getAmount_after_tax() {
    return amount_after_tax;
  }

  public void setAmount_after_tax(String amount_after_tax) {
    this.amount_after_tax = amount_after_tax;
  }
}
