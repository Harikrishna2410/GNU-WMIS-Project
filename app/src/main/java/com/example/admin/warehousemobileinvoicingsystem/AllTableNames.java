package com.example.admin.warehousemobileinvoicingsystem;

import android.content.ContentValues;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AllTableNames {
  public AllTableNames() {

  }

  public static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
  public static final Date date = new Date();

  //************************** ALL TABLE NAME ****************************************************
  public static final String clients_tablename = "clients";
  public static final String customers_tablename = "customers";
  public static final String products_tablename = "products";
  public static final String categories_tablename = "category";
  public static final String discount_tablename = "discount_rules";
  public static final String sale_reps_tablename = "sales_rep";
  public static final String tax_rules_tablename = "tax_rules";
  public static final String suppliers_tablename = "suppliers";
  public static final String orders_tablename = "orders";
  public static final String order_details_tablename = "order_details";

  //************************* CLIENT COLUMN NAMES ************************************************
  public static final String clients_col_id = "id";
  public static final String clients_col_name = "name";
  public static final String clients_col_email = "email";
  public static final String clients_col_password = "password";
  public static final String clients_col_contact_no = "contact_no";
  public static final String clients_col_company_detail = "company_detail";
  public static final String clients_col_active = "active";
  public static final String clients_col_created_by = "created_by";
  public static final String clients_col_updated_by = "updated_by";
  public static final String clients_col_created_at = "created_at";
  public static final String clients_col_expires_at = "expires_at";
  public static final String clients_col_updated_at = "updated_at";

  //************************* CUSTOMERS COLUMN NAMES *********************************************
  public static final String customers_col_id = "id";
  public static final String customers_col_client_id = "client_id";
  public static final String customers_col_server_id = "server_id";
  public static final String customers_col_name = "name";
  public static final String customers_col_contact_name = "contact_name";
  public static final String customers_col_gstin = "gstin";
  public static final String customers_col_email = "email";
  public static final String customers_col_address = "address";
  public static final String customers_col_city = "city";
  public static final String customers_col_state = "state";
  public static final String customers_col_postcode = "postcode";
  public static final String customers_col_contact_no = "contact_no";
  public static final String customers_col_status = "status";
  public static final String customers_col_is_product_tax = "is_product_tax";
  public static final String customers_col_created_at = "created_at";
  public static final String customers_col_updated_at = "updated_at";
  public static final String customers_col_deleted_at = "deleted_at";

  //************************ PRODUCTS COLUMN NAME ************************************************
  public static final String products_col_id = "id";
  public static final String products_col_client_id = "client_id";
  public static final String products_col_tax_rule_id = "tax_rule_id";
  public static final String products_col_category_id = "category_id";
  public static final String products_col_supplier_id = "supplier_id";
  public static final String products_col_discountrule_id = "discountrule_id";
  public static final String products_col_imgUrl = "imgUrl";
  public static final String products_col_barcodeno = "barcodeno";
  public static final String products_col_name = "name";
  public static final String products_col_price = "price";
  public static final String products_col_cost = "cost";
  public static final String products_col_discount_type = "discount_type";
  public static final String products_col_discount_rate = "discount_rate";
  public static final String products_col_quantity = "quantity";
  public static final String products_col_is_active = "is_active";
  public static final String products_col_is_taxable = "is_taxable";
  public static final String products_col_reorder_level = "reorder_level";
  public static final String products_col_expires_at = "expires_at";
  public static final String products_col_days_left = "days_left";
  public static final String products_col_created_at = "created_at";
  public static final String products_col_updated_at = "updated_at";
  public static final String products_col_deleted_at = "deleted_at";


  //**************************** CATEGORY COLUMN NAMES *******************************************
  public static final String category_col_id = "id";
  public static final String category_col_client_id = "client_id";
  public static final String category_col_discountrule_id = "disccountrule_id";
  public static final String category_col_name = "name";
  public static final String category_col_created_at = "created_at";
  public static final String category_col_updated_at = "updated_at";
  public static final String category_col_deleted_at = "deleted_at";


  //************************** DISCOUNTRULES COLUMN NAMES ****************************************
  public static final String discount_col_id = "id";
  public static final String discount_col_client_id = "client_id";
  public static final String discount_col_name = "name";
  public static final String discount_col_discount_on = "discount_on";
  public static final String discount_col_rate_type = "rate_type";
  public static final String discount_col_rate = "rate";
  public static final String discount_col_startdate = "startdate";
  public static final String discount_col_enddate = "enddate";
  public static final String discount_col_status = "enddate";
  public static final String discount_col_created_at = "created_at";
  public static final String discount_col_updated_at = "updated_at";
  public static final String discount_col_deleted_at = "deleted_at";

  //*************************** SALES REP COLUMN NAMES *******************************************
  public static final String sale_reps_col_id = "id";
  public static final String sale_reps_col_client_id = "client_id";
  public static final String sale_reps_col_initial = "initial";
  public static final String sale_reps_col_region = "region";
  public static final String sale_reps_col_is_active = "is_active";
  public static final String sale_reps_col_created_at = "created_at";
  public static final String sale_reps_col_updated_at = "updated_at";
  public static final String sale_reps_col_deleted_at = "deleted_at";

  //*************************** TAX RULES COLUMN NAMES *******************************************
  public static final String tax_rules_col_id = "id";
  public static final String tax_rules_col_client_id = "client_id";
  public static final String tax_rules_col_name = "name";
  public static final String tax_rules_col_rate = "rate";
  public static final String tax_rules_col_created_at = "created_at";
  public static final String tax_rules_col_updated_at = "updated_at";
  public static final String tax_rules_col_deleted_at = "deleted_at";


  //***************************** SUPPLIERS COLUMN NAMES *****************************************
  public static final String suppliers_col_id = "id";
  public static final String suppliers_col_client_id = "client_id";
  public static final String suppliers_col_name = "name";
  public static final String suppliers_col_address = "address";
  public static final String suppliers_col_phoneno = "phoneno";
  public static final String suppliers_col_status = "status";
  public static final String suppliers_col_created_at = "created_at";
  public static final String suppliers_col_updated_at = "updated_at";
  public static final String suppliers_col_deleted_at = "deleted_at";


  //******************************** ORDERS COLUMN NAMES *****************************************
  public static final String orders_col_id = "id";
  public static final String orders_col_client_id = "client_id";
  public static final String orders_col_customer_id = "customer_id";
  public static final String orders_col_is_cust_taxable = "is_cust_taxable";
  public static final String orders_col_server_id = "server_id";
  public static final String orders_col_sale_rep_id = "sale_rep_id";
  public static final String orders_col_sales_rep_name = "sales_rep_name";
  public static final String orders_col_invoice_no = "invoice_no";
  public static final String orders_col_order_type = "order_type";
  public static final String orders_col_is_posted = "is_posted";
  public static final String orders_col_notes = "notes";
  public static final String orders_col_created_at = "created_at";
  public static final String orders_col_updated_at = "updated_at";
  public static final String orders_col_deleted_at = "deleted_at";


  //****************************** ORDER DETAILS COLUMN NAMES ************************************
  public static final String order_details_col_id = "id";
  public static final String order_details_col_order_id = "order_id";
  public static final String order_details_col_product_id = "product_id";
  public static final String order_details_col_quantity = "quantity";
  public static final String order_details_col_price = "price";
  public static final String order_details_col_discount_type = "discount_type";
  public static final String order_details_col_discount_rate = "discount_rate";
  public static final String order_details_col_is_taxable = "is_taxable";
  public static final String order_details_col_tax_rate = "tax_rate";


  //******************************************* CREATE CLIENT TABLE QUERY **************************************

  public static final String create_clients_table = "create table if not exists " + clients_tablename + " (" +
          clients_col_id + " integer primary key autoincrement," +
          clients_col_name + " varchar, " +
          clients_col_email + " varchar, " +
          clients_col_password + " varchar, " +
          clients_col_contact_no + " varchar, " +
          clients_col_company_detail + " varchar, " +
          clients_col_active + " varchar default 'active'," +
          clients_col_created_by + " integer," +
          clients_col_updated_by + " integer," +
          clients_col_created_at + " datetime," +
          clients_col_expires_at + " datetime," +
          clients_col_updated_at + " datetime )";

  //***************************************** CREATE CUSTOMERS TABLE QUERY **************************************************

  public static final String create_customers_table = "create table if not exists " + customers_tablename + " (" +
          customers_col_id + " integer primary key autoincrement, " +
          customers_col_server_id + " integer , " +
          customers_col_client_id + " integer, " +
          customers_col_name + " varchar," +
          customers_col_contact_name + " varchar," +
          customers_col_gstin + " varchar," +
          customers_col_email + " varchar," +
          customers_col_address + " text, " +
          customers_col_city + " varchar, " +
          customers_col_state + " varchar, " +
          customers_col_postcode + " integer, " +
          customers_col_contact_no + " varchar, " +
          customers_col_status + " varchar, " +
          customers_col_is_product_tax + " integer, " +
          customers_col_created_at + " datetime," +
          customers_col_updated_at + " datetime," +
          customers_col_deleted_at + " datetime)";

  //region ************************************************* CREATE PRODUCTS TABLE QUERY **********************************************

  public static final String create_products_table = "create table if not exists " + products_tablename + " (" +
          products_col_id + " integer ," +
          products_col_client_id + " integer, " +
          products_col_tax_rule_id + " integer, " +
          products_col_category_id + " integer, " +
          products_col_supplier_id + " integer, " +
          products_col_discountrule_id + " integer, " +
          products_col_imgUrl + " varchar," +
          products_col_barcodeno + " varchar, " +
          products_col_name + " varchar, " +
          products_col_price + " double, " +
          products_col_cost + " double, " +
          products_col_discount_type + " integer, " +
          products_col_discount_rate + " double, " +
          products_col_quantity + " integer, " +
          products_col_is_active + " integer, " +
          products_col_is_taxable + " integer, " +
          products_col_reorder_level + " integer, " +
          products_col_expires_at + " datetime, " +
          products_col_days_left + " integer, " +
          products_col_created_at + " datetime," +
          products_col_updated_at + " datetime," +
          products_col_deleted_at + " datetime)";
  //endregion

  //region ************************************************** CREATE CATEGORY TABLE QUERY *****************************************************************

  public static final String create_category_table = "create table if not exists " + categories_tablename + " (" +
          category_col_id + " integer , " +
          category_col_client_id + " integer , " +
          category_col_discountrule_id + " integer , " +
          category_col_name + " varchar, " +
          category_col_created_at + " datetime," +
          category_col_updated_at + " datetime," +
          category_col_deleted_at + " datetime)";
  //endregion

  //region************************************************* CREATE DISCOUNTRULE TABLE QUERY **************************************************************

  public static final String create_discount_rules_table = "create table if not exists " + discount_tablename + " (" +
          discount_col_id + " integer, " +
          discount_col_client_id + " integer, " +
          discount_col_name + " varchar , " +
          discount_col_discount_on + " boolean , " +
          discount_col_rate_type + " boolean , " +
          discount_col_rate + " double , " +
          discount_col_startdate + " datetime," +
          discount_col_enddate + " datetime," +
          discount_col_status + " integer," +
          discount_col_created_at + " datetime," +
          discount_col_updated_at + " datetime," +
          discount_col_deleted_at + " datetime)";
  //endregion

  //region ************************************************* CREATE SALESREP TABLE QUERY ************************************************************

  public static final String create_sale_reps = "create table if not exists " + sale_reps_tablename + " (" +
          sale_reps_col_id + " integer ," +
          sale_reps_col_client_id + " integer, " +
          sale_reps_col_initial + " varchar, " +
          sale_reps_col_region + " varchar, " +
          sale_reps_col_is_active + " integer, " +
          sale_reps_col_created_at + " datetime, " +
          sale_reps_col_updated_at + " datetime, " +
          sale_reps_col_deleted_at + " datetime)";
  //endregion

  //region ************************************************ CREATE TAX RULES TABLE QUERY *********************************************************

  public static final String create_tax_rules_table = "create table if not exists " + tax_rules_tablename + " (" +
          tax_rules_col_id + " integer," +
          tax_rules_col_client_id + " integer, " +
          tax_rules_col_name + " varchar, " +
          tax_rules_col_rate + " double, " +
          tax_rules_col_created_at + " datetime," +
          tax_rules_col_updated_at + " datetime," +
          tax_rules_col_deleted_at + " datetime)";
  //endregion

  //region ************************************************ CREATE SUPPLIERS TABLE QUERY ************************************************

  public static final String create_suppliers_table = "create table if not exists " + suppliers_tablename + " (" +
          suppliers_col_id + " integer," +
          suppliers_col_client_id + " integer, " +
          suppliers_col_name + " varchar, " +
          suppliers_col_address + " varchar, " +
          suppliers_col_phoneno + " varchar, " +
          suppliers_col_status + " integer, " +
          suppliers_col_created_at + " datetime, " +
          suppliers_col_updated_at + " datetime, " +
          suppliers_col_deleted_at + " datetime)";
  //endregion

  //region ************************************************ CREATE ORDERS TABLE QUERY ************************************************

  public static final String create_orders_table = "create table if not exists " + orders_tablename + " (" +
          orders_col_id + " integer primary key autoincrement," +
          orders_col_client_id + " integer, " +
          orders_col_customer_id + " integer, " +
          orders_col_is_cust_taxable + " integer, " +
          orders_col_server_id + " integer, " +
          orders_col_sale_rep_id + " integer, " +
          orders_col_sales_rep_name + " varchar, " +
          orders_col_invoice_no + " varchar, " +
          orders_col_order_type + " varchar, " +
          orders_col_is_posted + " integer, " +
          orders_col_notes + " varchar, " +
          orders_col_created_at + " datetime, " +
          orders_col_updated_at + " datetime, " +
          orders_col_deleted_at + " datetime)";
  //endregion

  //region ************************************************  CREATE ORDER_DETAILS TABLE QUERY ************************************************

  public static final String create_orders_details_table = "create table if not exists " + order_details_tablename + " (" +
          order_details_col_id + " integer primary key autoincrement," +
          order_details_col_order_id + " integer, " +
          order_details_col_product_id + " integer, " +
          order_details_col_quantity + " integer, " +
          order_details_col_price + " double, " +
          order_details_col_is_taxable + " integer, " +
          order_details_col_tax_rate + " double, " +
          order_details_col_discount_type + " integer, " +
          order_details_col_discount_rate + " double)";
  //endregion

}
