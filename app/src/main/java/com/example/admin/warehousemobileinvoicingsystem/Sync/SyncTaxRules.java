package com.example.admin.warehousemobileinvoicingsystem.Sync;


public class SyncTaxRules {
  String id, client_id, name, rate, deleted_at;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public String getDeleted_at() {
    return deleted_at;
  }

  public void setDeleted_at(String deleted_at) {
    this.deleted_at = deleted_at;
  }
}
