package com.example.admin.warehousemobileinvoicingsystem.Sync;


public class SyncOrderDetails {

  String id, order_id, product_id, quantity, price, discount_type, discount_rate, is_taxable, tax_rate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOrder_id() {
    return order_id;
  }

  public void setOrder_id(String order_id) {
    this.order_id = order_id;
  }

  public String getProduct_id() {
    return product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
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

  public String getIs_taxable() {
    return is_taxable;
  }

  public void setIs_taxable(String is_taxable) {
    this.is_taxable = is_taxable;
  }

  public String getTax_rate() {
    return tax_rate;
  }

  public void setTax_rate(String tax_rate) {
    this.tax_rate = tax_rate;
  }
}
