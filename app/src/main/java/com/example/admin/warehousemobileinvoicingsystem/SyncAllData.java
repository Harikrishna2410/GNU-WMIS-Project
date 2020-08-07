package com.example.admin.warehousemobileinvoicingsystem;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.API.GetAllCustomersAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.NewCustomerAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.SendOrdersAndOrderDetailsAPI;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncOrders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.example.admin.warehousemobileinvoicingsystem.AllTableNames.dateFormat;

public class SyncAllData {

  Context ctx;
  DbHelper dbHelper;
  Activity activity;
  SharedPreferenceForDataTransfer spdt;
  NewCustomerAPI newCustomerAPI;
  ArrayList<SyncCustomers> syncCustomers;
  ArrayList<SyncOrders> syncOrders;
  SendOrdersAndOrderDetailsAPI sendOrdersAndOrderDetailsOBJ;
  GetAllCustomersAPI GetAllCustomersOBJ;
  ProgressBarHandler pb;

  public SyncAllData(Main_Menu main_menu, ProgressBarHandler pb) {
    this.ctx = main_menu;
    this.activity = main_menu;
    this.dbHelper = new DbHelper(ctx);
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.newCustomerAPI = new NewCustomerAPI((Main_Menu) ctx);
    this.sendOrdersAndOrderDetailsOBJ = new SendOrdersAndOrderDetailsAPI(ctx);
    this.GetAllCustomersOBJ = new GetAllCustomersAPI((Main_Menu) ctx);
    this.pb = pb;
  }

  public void syncAllData() {
    spdt.editor_data_tranfer.putString("sync_all","yes");
    spdt.editor_data_tranfer.commit();
    //================  BELOW CODE SEND ALL NEW CUSTOMERS AND ORDER_DETAILS TO SERVER  =====================================
    syncCustomers = dbHelper.getNewCustomersForAPI();
    if (syncCustomers.size() >= 1) {
      //THIS METHOD IS CALLED WHEN WE ADD NEW CUSTOMERS AND ADD NEW ORDERS TO SEND ONLY NEW CUSTOMER AND ORDERS TO SERVER
      //Toast.makeText(Main_Menu.this, "Total new customers = "+syncCustomers.size(), Toast.LENGTH_SHORT).show();
      //NewCustomerAPI obj = new NewCustomerAPI((Main_Menu) ctx);
      newCustomerAPI.NewCustomer_API((Main_Menu) ctx, syncCustomers, pb);
    } else {
      //================  BELOW CODE SEND ALL ORDERS AND ORDER_DETAILS TO SERVER  ============================================
      syncOrders = dbHelper.getAllOrdersForAPI();
      //================== THIS METHOD IS CALLED WHEN WE ADD NEW ORDERS TO SERVER ========================================
      if (syncOrders.size() >= 1) {
//        Toast.makeText(ctx, "Total orders = " + syncOrders.size(), Toast.LENGTH_SHORT).show();
        //SendOrdersAndOrderDetailsAPI obj = new SendOrdersAndOrderDetailsAPI(ctx);
        sendOrdersAndOrderDetailsOBJ.sendOrdersAndOrderDetails_API(syncOrders, pb);
      } else {
        GetAllCustomersOBJ.GetAllCustomers_API((Main_Menu) ctx, pb);
      }
    }
    //====================  GETTING ALL CUSTOMERS FROM SERVER AND INSERTING IT INTO CUSTOMERS TABLE IN SQLITE DB  =======================
    //GetAllCustomersAPI obj = new GetAllCustomersAPI((Main_Menu) ctx);
//    GetAllCustomersOBJ.GetAllCustomers_API((Main_Menu) ctx, pb);
  }

  public void sendOrdersAndCustomers() {
    spdt.editor_data_tranfer.putString("sync_all","no");
    spdt.editor_data_tranfer.commit();

    ArrayList<SyncCustomers> syncCustomers = dbHelper.getNewCustomersForAPI();      //======= GETTING ALL NEW CUSTOMERS FROM LOCAL DB TO SEND IT TO SERVER.
    if (syncCustomers.size() >= 1) {
      //THIS METHOD IS CALLED WHEN WE ADD NEW CUSTOMERS AND ADD NEW ORDERS TO SEND ONLY NEW CUSTOMER AND ORDERS TO SERVER
      //NewCustomerAPI obj = new NewCustomerAPI((Main_Menu) ctx);
      newCustomerAPI.NewCustomer_API((Main_Menu) ctx, syncCustomers, pb);
    } else {
      //================  BELOW CODE SEND ALL ORDERS AND ORDER_DETAILS TO SERVER  ============================================
      syncOrders = dbHelper.getAllOrdersForAPI();
      //================== THIS METHOD IS CALLED WHEN WE ADD NEW ORDERS TO SERVER ========================================
      if (syncOrders.size() >= 1) {
        sendOrdersAndOrderDetailsOBJ.sendOrdersAndOrderDetails_API(syncOrders, pb);
      } else {
        pb.dismiss();
        Toast.makeText(ctx, "Nothing to Sync.", Toast.LENGTH_SHORT).show();
      }
    }
  }

}
