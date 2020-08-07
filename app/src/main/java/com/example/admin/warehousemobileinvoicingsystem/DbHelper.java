package com.example.admin.warehousemobileinvoicingsystem;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.*;
import android.widget.*;

import com.example.admin.warehousemobileinvoicingsystem.Customers.CustModel;
import com.example.admin.warehousemobileinvoicingsystem.Customers.Customer_new_order;
import com.example.admin.warehousemobileinvoicingsystem.Customers.NewCustomerRegistration;
import com.example.admin.warehousemobileinvoicingsystem.Products.ProductModel;
import com.example.admin.warehousemobileinvoicingsystem.Settings.Company_Details;
import com.example.admin.warehousemobileinvoicingsystem.Sync.*;

import org.joda.time.DateTime;

import java.text.*;
import java.util.*;

public class DbHelper extends SQLiteOpenHelper {

  //region GLOBAL DECLARATION SECTION
  SQLiteDatabase db;
  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  public static final String DB_NAME = "WMIS.db";
  public static final int DB_VERSION = 1;
  DateFormat dateFormat;
  Date date;
  AllTableNames tn;
  ArrayList<SyncCustomers> syncCustomers;
  ArrayList<ProductModel> productModel;
  ArrayList<SyncTaxRules> syncTaxRules;
  private ArrayList<SyncSuppliers> syncSuppliers;
  ArrayList<SyncSalesRep> syncSalesReps;
  SyncCustomers sc;
  //endregion

  //-------------Default Constructor--------------------------------------------------------------
  public DbHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
    this.db = db;
    this.ctx = context;
    this.tn = new AllTableNames();
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    this.date = new Date();
    this.syncCustomers = new ArrayList<SyncCustomers>();
    this.productModel = new ArrayList<ProductModel>();
    this.syncTaxRules = new ArrayList<SyncTaxRules>();
    this.syncSalesReps = new ArrayList<SyncSalesRep>();
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    spdt.editor_client.putInt("invoiceno", '0');
    spdt.editor_client.commit();

    try {
      //*************************** CREATE CLIENT TABLE **************************************
      db.execSQL(tn.create_clients_table);
      Log.e("tables created", "Clients Table created");

      //*************************** CREATE CUSTOMERS TABLE **************************************
      db.execSQL(tn.create_customers_table);
      Log.e("tables created", "Customers Table created...");

      //*************************** CREATE PRODUCTS TABLE **************************************
      db.execSQL(tn.create_products_table);
      Log.e("tables created", "Product Table created...");

      //*************************** CREATE SALES REP TABLE **************************************
      db.execSQL(tn.create_sale_reps);
      Log.e("tables created", "Sales_reps Table created");

      //*************************** CREATE TAX_RULES TABLE **************************************
      db.execSQL(tn.create_tax_rules_table);
      Log.e("tables created", "Tax_rules Table created");

      //*************************** CREATE SUPPLIERS TABLE **************************************
      db.execSQL(tn.create_suppliers_table);
      Log.e("tables created", "Suppliers Table created");

      //*************************** CREATE CATAGORY TABLE **************************************
      db.execSQL(tn.create_category_table);
      Log.e("tables created", "Categories Table created");

      //*************************** CREATE ORDERS TABLE **************************************
      db.execSQL(tn.create_orders_table);
      Log.e("tables created", "Orders Table created");

      //*************************** CREATE ORDER DETIALS TABLE **************************************
      db.execSQL(tn.create_orders_details_table);
      Log.e("tables created", "Order_details Table created");

    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_LONG).show();
    } finally {

    }

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("drop table if exists " + tn.clients_tablename);
    db.execSQL("drop table if exists " + tn.customers_tablename);
    db.execSQL("drop table if exists " + tn.products_tablename);
    db.execSQL("drop table if exists " + tn.sale_reps_tablename);
    db.execSQL("drop table if exists " + tn.tax_rules_tablename);
    db.execSQL("drop table if exists " + tn.orders_tablename);
    db.execSQL("drop table if exists " + tn.order_details_tablename);
    db.execSQL("drop table if exists " + tn.suppliers_tablename);
    onCreate(db);
  }

  @Override
  public void onOpen(SQLiteDatabase db) {
    super.onOpen(db);
    if (!db.isReadOnly()) {
      // Enable foreign key constraints
      db.execSQL("PRAGMA foreign_keys=ON;");
    }
  }

  public void insertCustomer(NewCustomerRegistration newCustomerRegistration, CustModel custModel) {
    this.ctx = newCustomerRegistration;
    try {
      DateTime dateTime = new DateTime();
      ContentValues values = new ContentValues();
      values.put(tn.customers_col_client_id, custModel.getClient_id());
      values.put(tn.customers_col_name, custModel.getName());
      values.put(tn.customers_col_contact_name, custModel.getContact_name());
      values.put(tn.customers_col_gstin, custModel.getGstin());
      values.put(tn.customers_col_address, custModel.getAddress());
      values.put(tn.customers_col_city, custModel.getCity());
      values.put(tn.customers_col_state, custModel.getState());
      values.put(tn.customers_col_postcode, custModel.getPostcode());
      values.put(tn.customers_col_contact_no, custModel.getContact_no());
      values.put(tn.customers_col_email, custModel.getEmail());
      values.put(tn.customers_col_is_product_tax, custModel.getIs_product_tax());
      values.put(tn.customers_col_created_at, String.valueOf(dateTime.toDateTime()));
      values.put(tn.customers_col_status, custModel.getStatus());
      long lastrowid = getWritableDatabase().insert(tn.customers_tablename, null, values);
      Toast.makeText(ctx, "inserted id = " + lastrowid, Toast.LENGTH_SHORT).show();
    } catch (Exception ex) {
      Toast.makeText(newCustomerRegistration, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      getWritableDatabase().close();
    }
  }

  public void updateCustomerInfo(NewCustomerRegistration newCustomerRegistration, CustModel custModel) {
    this.ctx = newCustomerRegistration;
    try {
      ContentValues values = new ContentValues();
      values.put(tn.customers_col_client_id, custModel.getClient_id());
      values.put(tn.customers_col_name, custModel.getName());
      values.put(tn.customers_col_contact_name, custModel.getContact_name());
      values.put(tn.customers_col_gstin, custModel.getGstin());
      values.put(tn.customers_col_address, custModel.getAddress());
      values.put(tn.customers_col_city, custModel.getCity());
      values.put(tn.customers_col_state, custModel.getState());
      values.put(tn.customers_col_postcode, custModel.getPostcode());
      values.put(tn.customers_col_contact_no, custModel.getContact_no());
      values.put(tn.customers_col_email, custModel.getEmail());
      values.put(tn.customers_col_id, custModel.getId());
      values.put(tn.customers_col_is_product_tax, custModel.getIs_product_tax());
      values.put(tn.customers_col_status, custModel.getStatus());
      getWritableDatabase().update(tn.customers_tablename, values, tn.customers_col_id + " = ?", new String[]{custModel.getId()});
    } catch (Exception ex) {
      Toast.makeText(newCustomerRegistration, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      getWritableDatabase().close();
    }
  }

  public CharSequence[] getSalesRepData() {
    ArrayList<String> initals = new ArrayList<String>();
    Cursor c = null;

    try {
      c = getReadableDatabase().rawQuery("select initial from " + tn.sale_reps_tablename + ";", null);
      while (c.moveToNext()) {
        initals.add(c.getString(0));
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }

    final CharSequence[] charSequenceItem = initals.toArray(new CharSequence[initals.size()]);
    return charSequenceItem;
  }


  public long insertOrder(Customer_new_order customer_new_order, ArrayList<SyncOrders> syncOrders) {
    this.ctx = customer_new_order;
    try {
      ContentValues values = new ContentValues();
      values.put(tn.orders_col_client_id, syncOrders.get(0).getClient_id());
      values.put(tn.orders_col_customer_id, syncOrders.get(0).getCustomer_id());
      values.put(tn.orders_col_is_cust_taxable, syncOrders.get(0).getIs_cust_taxable());
      values.put(tn.orders_col_server_id, syncOrders.get(0).getServer_id());
      values.put(tn.orders_col_sale_rep_id, syncOrders.get(0).getSales_rep_id());
      values.put(tn.orders_col_sales_rep_name, syncOrders.get(0).getSales_rep_name());
      values.put(tn.orders_col_invoice_no, syncOrders.get(0).getInvoice_no());
      values.put(tn.orders_col_order_type, syncOrders.get(0).getOrder_type());
      values.put(tn.orders_col_is_posted, 0);
      values.put(tn.orders_col_notes, syncOrders.get(0).getNotes());
      values.put(tn.orders_col_created_at, dateFormat.format(date));
      values.put(tn.orders_col_updated_at, dateFormat.format(date));
      long rows_inserted = getWritableDatabase().insert(tn.orders_tablename, null, values);
      return rows_inserted;
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      getWritableDatabase().close();
    }
    return 0;
  }

  public void insertOrderDetails(Customer_new_order customer_new_order, String newOrderID, ArrayList<String> arrProdID, ArrayList<String> arrProdQty,
                                 ArrayList<String> arrProdPrice, ArrayList<String> arrProdTaxable, ArrayList<String> arrProdTaxRate,
                                 ArrayList<String> arrProdDiscountType, ArrayList<String> arrProdDiscountRate) {
    try {
      for (int i = 0; i < arrProdID.size(); i++) {
        ContentValues values = new ContentValues();
        values.put(tn.order_details_col_order_id, newOrderID);
        values.put(tn.order_details_col_product_id, arrProdID.get(i));
        values.put(tn.order_details_col_quantity, arrProdQty.get(i));
        values.put(tn.order_details_col_price, arrProdPrice.get(i));
        values.put(tn.order_details_col_is_taxable, arrProdTaxable.get(i));
        values.put(tn.order_details_col_tax_rate, arrProdTaxRate.get(i));
        values.put(tn.order_details_col_discount_type, arrProdDiscountType.get(i));
        values.put(tn.order_details_col_discount_rate, arrProdDiscountRate.get(i));

        long lastrowid = getWritableDatabase().insert(tn.order_details_tablename, null, values);
      }
    } catch (Exception ex) {
      Log.e("statuss", "" + ex.getMessage());
    } finally {
      getWritableDatabase().close();
    }
  }

  public void updateOrderDetails(Customer_new_order customer_new_order, String order_id, ArrayList<String> arrProdID, ArrayList<String> arrProdQty,
                                 ArrayList<String> arrProdPrice, ArrayList<String> arrProdTaxable, ArrayList<String> arrProdTaxRate,
                                 ArrayList<String> arrProdDiscountType, ArrayList<String> arrProdDiscountRate) {
    try {
      getReadableDatabase().delete(tn.order_details_tablename, tn.order_details_col_order_id + " = ?",
              new String[]{String.valueOf(order_id)});

      for (int i = 0; i < arrProdID.size(); i++) {

        ContentValues values = new ContentValues();
        values.put(tn.order_details_col_order_id, order_id);
        values.put(tn.order_details_col_product_id, arrProdID.get(i));
        values.put(tn.order_details_col_quantity, arrProdQty.get(i));
        values.put(tn.order_details_col_price, arrProdPrice.get(i));
        values.put(tn.order_details_col_is_taxable, arrProdTaxable.get(i));
        values.put(tn.order_details_col_tax_rate, arrProdTaxRate.get(i));
        values.put(tn.order_details_col_discount_type, arrProdDiscountType.get(i));
        values.put(tn.order_details_col_discount_rate, arrProdDiscountRate.get(i));

        long lastrowid = getWritableDatabase().insert(tn.order_details_tablename, null, values);
      }
    } catch (Exception ex) {
      Toast.makeText(customer_new_order, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      getWritableDatabase().close();
    }
  }

  public void deleteOrder(Customer_new_order customer_new_order, String order_id) {
    try {
      if (order_id != null) {
        getWritableDatabase().execSQL("delete from order_details where order_id=" + order_id + ";");
        getWritableDatabase().execSQL("delete from orders where id=" + order_id + ";");
      }
    } catch (Exception ex) {
      Toast.makeText(customer_new_order, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      getWritableDatabase().close();
    }
  }

  //  ****************************************** SYNC ALL TABLES ******************************************************
  public void syncCustomerTable(Context ctx, ArrayList<SyncCustomers> syncCustomers, SyncCustomers sc) {
    this.ctx = ctx;
    this.syncCustomers = syncCustomers;
    this.sc = sc;
    Cursor c = null;
    long rows_inserted = 0;
    long rows_updated = 0;
    long rows_deleted = 0;

    for (int i = 0; i < syncCustomers.size(); i++) {
      try {
        c = getReadableDatabase().rawQuery("select * from " + tn.customers_tablename + " where " + tn.customers_col_server_id + " = '" + syncCustomers.get(i).getId() + "'", null);

        // ******** BELOW CODE CLEANS DATA IF IT HAS (') IN DATA WHICH CAN CREATE PROBLEM FOR INSERT OR UPDATE *********************************
        if (syncCustomers.get(i).getContact_name().contains("'") || syncCustomers.get(i).getName().contains("'") ||
                syncCustomers.get(i).getAddress().contains("'") || syncCustomers.get(i).getCity().contains("'") ||
                syncCustomers.get(i).getState().contains("'") || syncCustomers.get(i).getEmail().contains("'")) {
          syncCustomers.get(i).setContact_name(syncCustomers.get(i).getContact_name().replaceAll("\\'", "''"));
          syncCustomers.get(i).setName(syncCustomers.get(i).getName().replaceAll("\\'", "''"));
          syncCustomers.get(i).setAddress(syncCustomers.get(i).getAddress().replaceAll("\\'", "''"));
          syncCustomers.get(i).setCity(syncCustomers.get(i).getCity().replaceAll("\\'", "''"));
          syncCustomers.get(i).setState(syncCustomers.get(i).getState().replaceAll("\\'", "''"));
          syncCustomers.get(i).setEmail(syncCustomers.get(i).getEmail().replaceAll("\\'", "''"));
        }

        ContentValues values = new ContentValues();
        values.put(tn.customers_col_server_id, syncCustomers.get(i).getId());
        values.put(tn.customers_col_client_id, syncCustomers.get(i).getClient_id());
        values.put(tn.customers_col_name, syncCustomers.get(i).getName());
        values.put(tn.customers_col_contact_name, syncCustomers.get(i).getContact_name());
        values.put(tn.customers_col_gstin, syncCustomers.get(i).getGstin());
        values.put(tn.customers_col_email, syncCustomers.get(i).getEmail());
        values.put(tn.customers_col_address, syncCustomers.get(i).getAddress());
        values.put(tn.customers_col_city, syncCustomers.get(i).getCity());
        values.put(tn.customers_col_state, syncCustomers.get(i).getState());
        values.put(tn.customers_col_postcode, syncCustomers.get(i).getPostcode());
        values.put(tn.customers_col_contact_no, syncCustomers.get(i).getContact_no());
        values.put(tn.customers_col_status, syncCustomers.get(i).getStatus());
        values.put(tn.customers_col_is_product_tax, syncCustomers.get(i).getIs_product_tax());

        if (c.getCount() > 0) {
          //****************************************** IF CUSTOMER FOUND UPDATE OR DELETE ******************************************
          if (!syncCustomers.get(i).getDeleted_at().equals("null") || syncCustomers.get(i).getStatus().equals("0")) {
            rows_deleted = getReadableDatabase().delete(tn.customers_tablename, tn.customers_col_server_id + " = ?",
                    new String[]{String.valueOf(syncCustomers.get(i).getId())});
          } else {
            rows_updated = getWritableDatabase().update(tn.customers_tablename, values, tn.customers_col_server_id + " = ?",
                    new String[]{String.valueOf(syncCustomers.get(i).getId())});
          }
        } else {

          // IF CUSTOMER NOT FOUND INSERT INTO DB BUT CHECK IF DELETED = NULL and STATUS = 1 THEN INSERT CUSTOMER
          if (syncCustomers.get(i).getDeleted_at().equals("null") && syncCustomers.get(i).getStatus().equals("1")) {
            rows_inserted = getWritableDatabase().insert(tn.customers_tablename, null, values);
            getWritableDatabase().close();
          }
        }
      } catch (Exception ex) {
        Log.e("statuss", "DBHelper line 422" + ex.getMessage());
      } finally {
        c.close();
      }
    }
    Log.e("statuss", "Customers Table imported successfully.");
    Log.e("statuss : ", "Rows inserted: " + rows_inserted + "  Rows updated: " + rows_updated + "  Rows deleted: " + rows_deleted);
  }

  public void syncSuppliersTable(ArrayList<SyncSuppliers> syncSuppliers) {
    Cursor c = null;
    long rows_inserted = 0;
    long rows_updated = 0;
    long rows_deleted = 0;

    for (int i = 0; i < syncSuppliers.size(); i++) {
      try {
        c = getReadableDatabase().rawQuery("select * from suppliers where id=" + syncSuppliers.get(i).getId(), null);

        ContentValues values = new ContentValues();
        values.put(tn.suppliers_col_id, syncSuppliers.get(i).getId());
        values.put(tn.suppliers_col_client_id, syncSuppliers.get(i).getClient_id());
        values.put(tn.suppliers_col_name, syncSuppliers.get(i).getName());
        values.put(tn.suppliers_col_address, syncSuppliers.get(i).getAddress());
        values.put(tn.suppliers_col_phoneno, syncSuppliers.get(i).getPhoneno());
        values.put(tn.suppliers_col_status, syncSuppliers.get(i).getStatus());
        values.put(tn.suppliers_col_created_at, syncSuppliers.get(i).getCreated_at());
        values.put(tn.suppliers_col_updated_at, syncSuppliers.get(i).getUpdated_at());
        values.put(tn.suppliers_col_deleted_at, syncSuppliers.get(i).getDeleted_at());

        if (c.getCount() > 0) {
          // IF FOUND UPDATE OR DELETE
          if (!syncSuppliers.get(i).getDeleted_at().equals("null") || syncSuppliers.get(i).getStatus().equals("0")) {
            rows_deleted = getReadableDatabase().delete(tn.suppliers_tablename, tn.suppliers_col_id + " = ?",
                    new String[]{String.valueOf(syncSuppliers.get(i).getId())});
          } else {
            rows_updated = getWritableDatabase().update(tn.suppliers_tablename, values, tn.suppliers_col_id + " = ?",
                    new String[]{String.valueOf(syncSuppliers.get(i).getId())});
          }
          c.close();
        } else {
          // IF Suppliers NOT FOUND INSERT INTO DB BUT CHECK IF DELETED = NULL and STATUS = 1 THEN INSERT CUSTOMER
          if (syncSuppliers.get(i).getDeleted_at().equals("null") && syncSuppliers.get(i).getStatus().equals("1")) {
            rows_inserted = getWritableDatabase().insert(tn.suppliers_tablename, null, values);
            getWritableDatabase().close();
          }
        }
      } catch (Exception ex) {
        Log.e("statuss: ", "" + ex.getMessage());
      } finally {
        c.close();
        getWritableDatabase().close();
        getReadableDatabase().close();
      }
    }
    Log.e("statuss", "Suppliers Table imported successfully.");
    Log.e("statuss : ", "Rows inserted: " + rows_inserted + "  Rows updated: " + rows_updated + "  Rows deleted: " + rows_deleted);
  }

  public void syncProductsTable(ArrayList<ProductModel> syncProducts) {
    Cursor c = null;
    long rows_inserted = 0;
    long rows_updated = 0;
    long rows_deleted = 0;

    for (int i = 0; i < syncProducts.size(); i++) {
      try {
        c = getReadableDatabase().rawQuery("select * from " + tn.products_tablename + " where " + tn.products_col_id + " = " + syncProducts.get(i).getId(), null);
        ContentValues values = new ContentValues();
        values.put(tn.products_col_id, syncProducts.get(i).getId());
        values.put(tn.products_col_client_id, syncProducts.get(i).getClient_id());
        values.put(tn.products_col_tax_rule_id, syncProducts.get(i).getTax_rule_id());
        values.put(tn.products_col_category_id, syncProducts.get(i).getCategory_id());
        values.put(tn.products_col_supplier_id, syncProducts.get(i).getSupplier_id());
        values.put(tn.products_col_discountrule_id, syncProducts.get(i).getDiscountrule_id());
        values.put(tn.products_col_imgUrl, syncProducts.get(i).getImgUrl());
        values.put(tn.products_col_barcodeno, syncProducts.get(i).getBarcodeno());
        values.put(tn.products_col_name, syncProducts.get(i).getName());
        values.put(tn.products_col_price, syncProducts.get(i).getPrice());
        values.put(tn.products_col_cost, syncProducts.get(i).getCost());
        values.put(tn.products_col_discount_type, syncProducts.get(i).getDiscount_type());
        values.put(tn.products_col_discount_rate, syncProducts.get(i).getDiscount_rate());
        values.put(tn.products_col_quantity, syncProducts.get(i).getQuantity());
        values.put(tn.products_col_is_active, syncProducts.get(i).getIs_active());
        values.put(tn.products_col_is_taxable, syncProducts.get(i).getIs_taxable());
        values.put(tn.products_col_reorder_level, syncProducts.get(i).getReorder_level());
        values.put(tn.products_col_expires_at, syncProducts.get(i).getExpires_at());
        values.put(tn.products_col_days_left, syncProducts.get(i).getDays_left());
        values.put(tn.products_col_created_at, syncProducts.get(i).getCreated_at());
        values.put(tn.products_col_updated_at, syncProducts.get(i).getUpdated_at());
        values.put(tn.products_col_deleted_at, syncProducts.get(i).getDeleted_at());

        if (c.getCount() > 0) {
//
          if (!syncProducts.get(i).getDeleted_at().equals("null") || syncProducts.get(i).getIs_active().equals("0")) {
            rows_deleted = getReadableDatabase().delete(tn.products_tablename, tn.products_col_id + " = ?",
                    new String[]{String.valueOf(syncProducts.get(i).getId())});
          } else {
            rows_updated = getWritableDatabase().update(tn.products_tablename, values, tn.products_col_id + " = ?",
                    new String[]{String.valueOf(syncProducts.get(i).getId())});
          }
        } else {
          // IF PRODUCTS NOT FOUND INSERT INTO DB BUT CHECK IF DELETED = NULL and STATUS = 1 THEN INSERT CUSTOMER
          if (syncProducts.get(i).getDeleted_at().equals("null") && syncProducts.get(i).getIs_active().equals("1")) {
            rows_inserted = getWritableDatabase().insert(tn.products_tablename, null, values);
            getWritableDatabase().close();
          }
        }
      } catch (Exception ex) {
        Log.e("statuss", "DBHelper line 520 : " + ex.getMessage());
      } finally {
        c.close();
      }
    }
    Log.e("statuss", "Products Table imported successfully.");
    Log.e("statuss : ", "Rows inserted: " + rows_inserted + "  Rows updated: " + rows_updated + "  Rows deleted: " + rows_deleted);
  }

  public void syncSalesRepTable(Main_Menu main_menu, ArrayList<SyncSalesRep> syncSalesReps) {
    this.syncSalesReps = syncSalesReps;
    this.ctx = main_menu;
    Cursor c = null;
    long rows_inserted = 0;
    long rows_updated = 0;
    long rows_deleted = 0;

    for (int i = 0; i < syncSalesReps.size(); i++) {
      try {
        c = getReadableDatabase().rawQuery("select * from sales_rep where id =" + syncSalesReps.get(i).getId(), null);

        ContentValues values = new ContentValues();
        values.put(tn.sale_reps_col_id, syncSalesReps.get(i).getId());
        values.put(tn.sale_reps_col_client_id, syncSalesReps.get(i).getClient_id());
        values.put(tn.sale_reps_col_initial, syncSalesReps.get(i).getInitial());
        values.put(tn.sale_reps_col_region, syncSalesReps.get(i).getRegion());
        values.put(tn.sale_reps_col_is_active, syncSalesReps.get(i).getIs_active());
        values.put(tn.sale_reps_col_created_at, syncSalesReps.get(i).getCreated_at());
        values.put(tn.sale_reps_col_updated_at, syncSalesReps.get(i).getUpdated_at());
        values.put(tn.sale_reps_col_deleted_at, syncSalesReps.get(i).getDeleted_at());

        if (c.getCount() > 0) {
          if (!syncSalesReps.get(i).getDeleted_at().equals("null") || syncSalesReps.get(i).getIs_active().equals("0")) {
            rows_deleted = getReadableDatabase().delete(tn.sale_reps_tablename, tn.sale_reps_col_id + " = ?",
                    new String[]{String.valueOf(syncSalesReps.get(i).getId())});
          } else {
            rows_updated = getWritableDatabase().update(tn.sale_reps_tablename, values, tn.sale_reps_col_id + " = ?",
                    new String[]{String.valueOf(syncSalesReps.get(i).getId())});
          }
        } else {
          rows_inserted = getWritableDatabase().insert(tn.sale_reps_tablename, null, values);
        }
      } catch (Exception ex) {
        Log.e("statuss", "DBHelper line 603" + ex.getMessage());
      } finally {
        c.close();
        getReadableDatabase().close();
        getWritableDatabase().close();
      }
    }
    Log.e("statuss", "TaxRules Table imported successfully.");
    Log.e("statuss : ", "Rows inserted: " + rows_inserted + "  Rows updated: " + rows_updated + "  Rows deleted: " + rows_deleted);
  }

  public void syncCategoriesTable(ArrayList<SyncCategories> syncCategories) {
    Cursor c = null;
    long rows_inserted = 0;
    long rows_updated = 0;
    long rows_deleted = 0;

    for (int i = 0; i < syncCategories.size(); i++) {
      try {
        c = getReadableDatabase().rawQuery("select * from category where id=" + syncCategories.get(i).getId(), null);
        if (c.getCount() > 0) {
          // IF FOUND UPDATE OR DELETE
          if (syncCategories.get(i).getDeleted_at().equals("null")) {
            rows_deleted = getReadableDatabase().delete(tn.categories_tablename, tn.category_col_id + " = ?",
                    new String[]{String.valueOf(syncCategories.get(i).getId())});
          } else {
            // UPDATE CATEEGORY DATA
            ContentValues values = new ContentValues();
            values.put(tn.category_col_name, syncCategories.get(i).getName());
            values.put(tn.category_col_discountrule_id, syncCategories.get(i).getDiscountrule_id());
            values.put(tn.category_col_created_at, syncCategories.get(i).getCreated_at());
            values.put(tn.category_col_updated_at, syncCategories.get(i).getUpdated_at());
            rows_updated = getWritableDatabase().update(tn.categories_tablename, values, tn.category_col_client_id + " = ?",
                    new String[]{String.valueOf(syncCategories.get(i).getId())});
          }
        } else {
          // IF CATEGORY NOT FOUND INSERT INTO DB BUT CHECK IF DELETED = NULL THEN INSERT
          if (syncCategories.get(i).getDeleted_at().equals("null")) {
            ContentValues values = new ContentValues();
            values.put(tn.category_col_id, syncCategories.get(i).getId());
            values.put(tn.category_col_client_id, syncCategories.get(i).getClient_id());
            values.put(tn.category_col_discountrule_id, syncCategories.get(i).getDiscountrule_id());
            values.put(tn.category_col_name, syncCategories.get(i).getName());
            values.put(tn.category_col_created_at, syncCategories.get(i).getCreated_at());
            values.put(tn.category_col_updated_at, syncCategories.get(i).getUpdated_at());
            values.put(tn.category_col_deleted_at, syncCategories.get(i).getDeleted_at());
            rows_inserted = getWritableDatabase().insert(tn.categories_tablename, null, values);
          }
        }
      } catch (Exception ex) {
        Log.e("statuss: ", "DBHelper line syncCategoriesTable : " + ex.getMessage());
      } finally {
        c.close();
        getReadableDatabase().close();
        getWritableDatabase().close();
      }
    }
    Log.e("statuss", "Categories Table imported successfully.");
    Log.e("statuss : ", "Rows inserted: " + rows_inserted + "  Rows updated: " + rows_updated + "  Rows deleted: " + rows_deleted);
  }

  public void syncTaxRulesTable(ArrayList<SyncTaxRules> syncTaxRules) {
    Cursor c = null;
    long rows_inserted = 0;
    long rows_updated = 0;
    long rows_deleted = 0;
    for (int i = 0; i < syncTaxRules.size(); i++) {
      try {
        c = getReadableDatabase().rawQuery("select * from tax_rules where id=" + syncTaxRules.get(i).getId(), null);
        ContentValues values = new ContentValues();
        values.put(tn.tax_rules_col_id, syncTaxRules.get(i).getId());
        values.put(tn.tax_rules_col_client_id, syncTaxRules.get(i).getClient_id());
        values.put(tn.tax_rules_col_name, syncTaxRules.get(i).getName());
        values.put(tn.tax_rules_col_rate, syncTaxRules.get(i).getRate());

        if (c.getCount() > 0) {
          if (!syncTaxRules.get(i).getDeleted_at().equals("null")) {
            rows_deleted = getReadableDatabase().delete(tn.tax_rules_tablename, tn.tax_rules_col_id + " = ?",
                    new String[]{String.valueOf(syncTaxRules.get(i).getId())});
          } else {
            rows_updated = getWritableDatabase().update(tn.tax_rules_tablename, values, tn.tax_rules_col_id + " = ?",
                    new String[]{String.valueOf(syncTaxRules.get(i).getId())});
          }
        } else {
          // IF TAXRULES NOT FOUND INSERT INTO DB BUT CHECK IF DELETED = NULL THEN INSERT TAXRULE
          if (syncTaxRules.get(i).getDeleted_at().equals("null")) {
            rows_inserted = getWritableDatabase().insert(tn.tax_rules_tablename, null, values);
            getWritableDatabase().close();
          }
        }
      } catch (Exception ex) {
        Log.e("statuss", "DBHelper line 564" + ex.getMessage());
      } finally {
        c.close();
        getWritableDatabase().close();
        getReadableDatabase().close();
      }
    }
    Log.e("statuss", "TaxRules Table imported successfully.");
    Log.e("statuss : ", "Rows inserted: " + rows_inserted + "  Rows updated: " + rows_updated + "  Rows deleted: " + rows_deleted);
  }

  //  ****************************************** SYNC ALL TABLES ******************************************************


  public ArrayList<SyncCustomers> getNewCustomersForAPI() {
    ArrayList<SyncCustomers> syncCustomers = new ArrayList<SyncCustomers>();
    Cursor c = null;
    try {
      c = getReadableDatabase().rawQuery("select * from " + tn.customers_tablename + " where " + tn.customers_col_server_id + " is null; ", null);

      if (c.getCount() > 0) {
        while (c.moveToNext()) {
          SyncCustomers ob = new SyncCustomers();
          ob.setId(c.getString(0));
          ob.setServer_id(c.getString(1));
          ob.setClient_id(c.getString(2));
          ob.setName(c.getString(3));
          ob.setContact_name(c.getString(4));
          ob.setGstin(c.getString(5));
          ob.setEmail(c.getString(6));
          ob.setAddress(c.getString(7));
          ob.setCity(c.getString(8));
          ob.setState(c.getString(9));
          ob.setPostcode(c.getString(10));
          ob.setContact_no(c.getString(11));
          ob.setStatus(c.getString(12));
          ob.setIs_product_tax(c.getString(13));
          ob.setCreated_at(c.getString(14));
          ob.setUpdated_at(c.getString(15));
          syncCustomers.add(ob);
        }
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }
    return syncCustomers;
  }

  public void updateServer_Id_InCustomers(Context ctx, String oldValue, String newValue) {
    this.ctx = ctx;

    try {
      getWritableDatabase().execSQL("update customers set server_id = '" + newValue + "' where id = '" + oldValue + "'");
      getWritableDatabase().execSQL("update orders set server_id = '" + newValue + "' where customer_id = '" + oldValue + "'");
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      getWritableDatabase().close();
    }
  }

  public ArrayList<SyncOrders> getAllOrdersForAPI() {
    ArrayList<SyncOrders> syncOrders = new ArrayList<SyncOrders>();
    Cursor c = null;

    try {
      c = getReadableDatabase().rawQuery("select * from " + tn.orders_tablename + ";", null);
      if (c.getCount() > 0) {
        while (c.moveToNext()) {
          SyncOrders ob = new SyncOrders();
          ob.setId(c.getString(0));
          ob.setClient_id(c.getString(1));
          ob.setCustomer_id(c.getString(2));
          ob.setIs_cust_taxable(c.getString(3));
          ob.setServer_id(c.getString(4));
          ob.setSales_rep_id(c.getString(5));
          ob.setSales_rep_name(c.getString(6));
          ob.setInvoice_no(c.getString(7));
          ob.setOrder_type(c.getString(8));
          ob.setIs_posted(c.getString(9));
          ob.setNotes(c.getString(10));
          ob.setCreated_at(c.getString(11));
          ob.setUpdated_at(c.getString(12));
          ob.setDeleted_at(c.getString(13));
          syncOrders.add(ob);
        }
        c.close();
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }
    return syncOrders;
  }

  public ArrayList<SyncOrderDetails> getAllOrderDetailsForAPI(String order_id) {
    ArrayList<SyncOrderDetails> syncOrderDetails = new ArrayList<SyncOrderDetails>();
    Cursor c = null;
    try {
      c = getReadableDatabase().rawQuery("select * from order_details where order_id = " + order_id, null);
      if (c.getCount() > 0) {
        while (c.moveToNext()) {
          SyncOrderDetails ob = new SyncOrderDetails();
          ob.setProduct_id(c.getString(2));
          ob.setQuantity(c.getString(3));
          ob.setPrice(c.getString(4));
          ob.setIs_taxable(c.getString(5));
          ob.setTax_rate(c.getString(6));
          ob.setDiscount_type(c.getString(7));
          ob.setDiscount_rate(c.getString(8));
          syncOrderDetails.add(ob);
        }
        c.close();
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }
    return syncOrderDetails;
  }

  public CharSequence[] getSalesRepId() {
    ArrayList<String> sales_rep_id = new ArrayList<String>();
    Cursor c = null;
    try {
      c = getReadableDatabase().rawQuery("select id from " + tn.sale_reps_tablename + ";", null);
      while (c.moveToNext()) {
        sales_rep_id.add(c.getString(0));
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }

    final CharSequence[] charSequenceItem = sales_rep_id.toArray(new CharSequence[sales_rep_id.size()]);
    return charSequenceItem;

  }

  public ArrayList<SyncSalesRep> getsalesRepIdAndInitials() {
    ArrayList<SyncSalesRep> syncSalesRep = new ArrayList<SyncSalesRep>();
    Cursor c = null;
    try {
      c = getReadableDatabase().rawQuery("select id,initial from sales_rep;", null);
      while (c.moveToNext()) {
        SyncSalesRep ob = new SyncSalesRep();
        ob.setId(c.getString(0));
        ob.setInitial(c.getString(1));
        syncSalesRep.add(ob);
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }
    return syncSalesRep;
  }

  public String getTotalCustomers(Company_Details preference_compeny_info) {
    String total_customers = null;
    Cursor c = null;
    try {
      c = getReadableDatabase().rawQuery("select count(*) from customers", null);
      while (c.moveToNext()) {
        total_customers = c.getString(0);
      }
    } catch (Exception ex) {
      Toast.makeText(preference_compeny_info, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }
    return total_customers;
  }

  public String getTotalProducts(Company_Details preference_compeny_info) {
    String total_products = null;
    Cursor c = null;
    try {
      c = getReadableDatabase().rawQuery("select count(*) from products", null);
      while (c.moveToNext()) {
        total_products = c.getString(0);
      }
    } catch (Exception ex) {
      Toast.makeText(preference_compeny_info, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }
    return total_products;
  }

  public ArrayList<SyncCustomers> getSingleCustomerData(String argCustomerID) {
    ArrayList<SyncCustomers> customers = new ArrayList<SyncCustomers>();
    Cursor c = null;
    try {
      c = getReadableDatabase().rawQuery("select * from customers where id = " + argCustomerID, null);
      if (c.getCount() > 0) {
        customers.clear();
        while (c.moveToNext()) {
          SyncCustomers ob = new SyncCustomers();
          ob.setId(c.getString(0));
          ob.setServer_id(c.getString(1));
          ob.setClient_id(c.getString(2));
          ob.setName(c.getString(3));
          ob.setContact_name(c.getString(4));
          ob.setGstin(c.getString(5));
          ob.setEmail(c.getString(6));
          ob.setAddress(c.getString(7));
          ob.setCity(c.getString(8));
          ob.setState(c.getString(9));
          ob.setPostcode(c.getString(10));
          ob.setContact_no(c.getString(11));
          ob.setStatus(c.getString(12));
          ob.setIs_product_tax(c.getString(13));
          customers.add(ob);
        }
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {

    }
    return customers;
  }

  public String getNotes(String invoice_no) {
    String notes = null;
    Cursor c = null;
    try {
      c = getReadableDatabase().rawQuery("select notes from orders where invoice_no = " + invoice_no, null);
      while (c.moveToNext()) {
        notes = c.getString(0);
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }
    return notes;
  }


  public ProductModel getsingleProductData(String argProductID) {
    Log.e("statuss", "Getting single product data");
    ProductModel product = new ProductModel();
    Cursor c = null;
    try {
      c = getReadableDatabase().rawQuery("select * from products where id = " + argProductID, null);
      if (c.getCount() > 0) {
        while (c.moveToNext()) {
          product.setId(c.getString(0));
          product.setBarcodeno(c.getString(7));
          product.setName(c.getString(8));
          product.setPrice(c.getString(9));
          product.setCost(c.getString(10));
          product.setDiscount_type(c.getString(11));
          product.setDiscount_rate(c.getString(12));
          product.setIs_taxable(c.getString(15));
        }
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {

    }
    return product;

  }

  public String getAllCustomersCount() {
    Cursor c = null;
    String customersCount = null;
    try {
      c = getReadableDatabase().rawQuery("select count(*) from customers;", null);
      while (c.moveToNext()) {
        customersCount = c.getString(0);
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
    }
    return customersCount;
  }

  public String getSalesRepName(String sales_rep_id) {
    Cursor c = null;
    String name = null;
    try {
      c = getReadableDatabase().rawQuery("select initial from sales_rep where id = " + sales_rep_id, null);
      while (c.moveToNext()) {
        name = c.getString(0);
      }
    } catch (Exception ex) {
      Toast.makeText(ctx, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
    } finally {
      c.close();
    }
    return name;
  }
}
