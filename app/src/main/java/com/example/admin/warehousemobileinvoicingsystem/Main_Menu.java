package com.example.admin.warehousemobileinvoicingsystem;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import com.archit.calendardaterangepicker.customviews.DateRangeCalendarView;
import com.example.admin.warehousemobileinvoicingsystem.API.GetCustomerCountAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.Login_SettingsAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.LogoutAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.SendSalesRepFirstTimeAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.UpdateSalesRepAPI;
import com.example.admin.warehousemobileinvoicingsystem.Customers.Customer_List;
import com.example.admin.warehousemobileinvoicingsystem.Customers.IMEIUtil;
import com.example.admin.warehousemobileinvoicingsystem.Orders.Orders_List_Activity;
import com.example.admin.warehousemobileinvoicingsystem.Products.Product_List;
import com.example.admin.warehousemobileinvoicingsystem.Reports.Daily_Reports_Activity;
import com.example.admin.warehousemobileinvoicingsystem.Settings.Company_Details;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncSalesRep;
import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetSequence;

import static android.Manifest.permission.READ_PHONE_STATE;

public class Main_Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

  //region ======================================GLOBAL DECLARATION SECTION =============================================
  LinearLayout btn_customers, btn_products, btn_orders, btn_reports, btn_add_customers;
  public ConstraintLayout main_menu_layout;
  DbHelper dbHelper;
  SharedPreferenceForDataTransfer spdt;
  CardView updateall, send_customers_and_orders;
  androidx.appcompat.widget.Toolbar toolbar;
  DrawerLayout drawerLayout;
  NavigationView navigationView;
  public TextView nav_header_name, nav_header_email, last_sync_date, data;
  ImageButton mainmenu_sync_imagebutton;
  public Dialog exitdialog, sync_dialog_menu;
  View exitview;
  SQLiteDatabase db;
  Button btn_yes, btn_no;
  DateFormat dateFormat;
  DateRangeCalendarView calendarView;
  String imei;
  private int REQUEST_PERMISSION_PHONE_STATE = 1;
  public Dialog selectSalesRepDialog;
  String salesrep_for_api;
  ProgressBarHandler pb;
  //endregion

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.navigation_drawer_main_menu);
    bindAllControls();
    setSupportActionBar(toolbar);

    //=========================================== INITIALIZE ALL CLASSES HERE =============================================
    dbHelper = new DbHelper(this);
    spdt = new SharedPreferenceForDataTransfer(this);
    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    pb = new ProgressBarHandler(Main_Menu.this);
    getSupportActionBar().setTitle(spdt.pref_client.getString("client_company_name", null));

    // ============================== INITIALIZE DATABASE ===================================================================
    Toast.makeText(this, "Checking Database....", Toast.LENGTH_SHORT).show();
    this.dbHelper = new DbHelper(this);
    this.db = dbHelper.getWritableDatabase();

    //=============================== MAIN LOGIC BELOW =======================================================================

    if (spdt.pref_client.getString("last_sync_date", null) == null) {
      last_sync_date.setText("");
    } else {
      last_sync_date.setText(spdt.pref_client.getString("last_sync_date", null)+" ");
    }

    nav_header_name.setText(String.valueOf(spdt.pref_client.getString("client_company_name", null)));
    nav_header_email.setText(String.valueOf(spdt.pref_client.getString("client_email", null)));

    //======================== MAKING VIEW READY FOR LOADING PROGRESSBAR ================================================
    if (spdt.pref_client.getString("sales_rep_id", null).equals("null")) {
    }
    //==============================================================================================================

    btnonClick();

    //First time when user logs in he will have access token but no sales rep selected so this will update all sales rep in db and show sales rep for selection.
    if (spdt.pref_client.getString("Access_token", null) != null && spdt.pref_client.getString("sales_rep_id", null).equals("null")) {
      //THIS METHOD IS CALLED EVERY TIME USER LOGINS
      pb.pb_load_tv.setText("Please Wait...");
      pb.show();
      UpdateSalesRepAPI obj = new UpdateSalesRepAPI(this);
      obj.UpdateSalesRep_API(this, pb);
    }


    btn_add_customers.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        pb.pb_load_tv.setText("Please Wait...");
        pb.show();
        spdt.editor_data_tranfer.putString("edit_customer", "no");
        spdt.editor_data_tranfer.commit();

        // Check for internet connection
        boolean connected = isNetworkConnected();
        // If connected== true
        if (connected) {
          GetCustomerCountAPI getCustomerCountAPI = new GetCustomerCountAPI(Main_Menu.this);
          getCustomerCountAPI.GetCustomerCountAPI(pb);
        } else {
          pb.dismiss();
          MyGlobals.setSnackBar(main_menu_layout, "Check your internet connection");
        }
      }
    });


    mainmenu_sync_imagebutton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        sync_dialog_menu = new Dialog(Main_Menu.this);
        sync_dialog_menu.setContentView(R.layout.select_sync_type);
        sync_dialog_menu.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        sync_dialog_menu.getWindow().setLayout(width, height);
        send_customers_and_orders = sync_dialog_menu.findViewById(R.id.send_c_and_o_button_select_sync_type);
        updateall = sync_dialog_menu.findViewById(R.id.update_button_select_sync_type);

        sync_dialog_menu.setCancelable(true);
        sync_dialog_menu.setCanceledOnTouchOutside(true);


        updateall.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
//                        Log.e("statuss","update all clicked");
            pb.pb_load_tv.setText("Connecting...");
            pb.show();
            //============================= UPDATING ALL DATA ===================================================================================
            spdt.editor_data_tranfer.putBoolean("updateall", true);
            spdt.editor_data_tranfer.commit();
            SyncAllData obj = new SyncAllData(Main_Menu.this, pb);
            obj.syncAllData();

            sync_dialog_menu.dismiss();
          }
        });

        send_customers_and_orders.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            pb.pb_load_tv.setText("Connecting...");
            pb.show();
            spdt.editor_data_tranfer.putBoolean("updateall", false);
            spdt.editor_data_tranfer.commit();
            SyncAllData obj = new SyncAllData(Main_Menu.this, pb);
            obj.sendOrdersAndCustomers();
            sync_dialog_menu.dismiss();  // this will remove sync dialog 2 buttons sync all and sync only customers
          }
        });
        sync_dialog_menu.show();
      }
    });
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(Main_Menu.this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
    drawerLayout.setDrawerListener(toggle);
    toggle.syncState();
    navigationView.setNavigationItemSelectedListener(this);


  }

//  private boolean isLimitReached() {
//    GetCustomerCountAPI getCustomerCountAPI = new GetCustomerCountAPI(this);
//    getCustomerCountAPI.GetCustomerCountAPI(this);
////    newCustomerAPI.NewCustomer_API((Main_Menu) ctx, syncCustomers, pb);
//    return true;
//  }

  private boolean isNetworkConnected() {
    ConnectivityManager cm = (ConnectivityManager) getSystemService(Main_Menu.CONNECTIVITY_SERVICE);
    return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
  }


  // THIS METHOD IS CALLED IN ASYNCUPDATESALESREP CLASS IN POST EXECUTE.
  public void getSalesRepFromDbToDialog() {
    selectSalesRepDialog = new Dialog(this);
    selectSalesRepDialog.setTitle("Select Sales Rep from below :");
    selectSalesRepDialog.setContentView(R.layout.select_sales_rep);
    Button button = (Button) selectSalesRepDialog.findViewById(R.id.btn_okk);

    selectSalesRepDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    int width = ViewGroup.LayoutParams.MATCH_PARENT;
    int height = ViewGroup.LayoutParams.WRAP_CONTENT;
    selectSalesRepDialog.getWindow().setLayout(width, height);

    ArrayList<SyncSalesRep> syncSalesReps = new ArrayList<SyncSalesRep>();
    final ArrayList<String> arr_id = new ArrayList<>();
    final ArrayList<String> arr_initial = new ArrayList<>();
    syncSalesReps = dbHelper.getsalesRepIdAndInitials();                //get all sales rep name and id from local DB
    selectSalesRepDialog.setCancelable(false);

    //========================== This loop will set salesrep data in array ========================================
    for (int i = 0; i < syncSalesReps.size(); i++) {
      arr_id.add(syncSalesReps.get(i).getId());
      arr_initial.add(syncSalesReps.get(i).getInitial());
    }
    //==============================================================================================================
    final RadioGroup rg = (RadioGroup) selectSalesRepDialog.findViewById(R.id.RadioGroup);

    salesrep_for_api = arr_id.get(0);

    //========================== This loop will set sales rep data in dialog box ========================================
    for (int i = 0; i < syncSalesReps.size(); i++) {
      RadioButton rb = new RadioButton(this); // dynamically creating RadioButton and adding to RadioGroup.
      rb.setText(syncSalesReps.get(i).getInitial());
      rb.setTextSize(15);
      rb.setPadding(20, 20, 20, 20);
      rg.addView(rb);
      if (i == 0) {
        rb.setChecked(true);
      }
      //region radio onclick listener
      rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
          int childCount = group.getChildCount();
          for (int x = 0; x < childCount; x++) {
            RadioButton btn = (RadioButton) group.getChildAt(x);
            if (btn.getId() == checkedId) {
              salesrep_for_api = arr_id.get(x);
            }
          }
        }
      });
      //endregion

      button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          showPhoneStatePermission();


        }
      });
    }

    selectSalesRepDialog.show();


  }

  @Override
  public void onBackPressed() {

    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START);
    } else {
      //Making view ready for loading progressbar
      exitview = getLayoutInflater().inflate(R.layout.exit_dialog_layout, null);
      exitdialog = new Dialog(this, android.R.style.Theme_DeviceDefault_NoActionBar_TranslucentDecor);
      exitdialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darktransparent)));
      exitdialog.setContentView(exitview);

      btn_yes = exitdialog.findViewById(R.id.exit_dialog_btn_yes);
      btn_no = exitdialog.findViewById(R.id.exit_dialog_btn_no);

      exitdialog.show();
      btn_yes.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          finish();
        }
      });
      btn_no.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          exitdialog.dismiss();
        }
      });
    }
  }

  private void bindAllControls() {
    //bind all controls here.
//        Customer_store_name = findViewById(R.id.client_store_name);
    main_menu_layout = findViewById(R.id.main_menu_layout);
    last_sync_date = findViewById(R.id.tv_last_sync_date);
    btn_customers = findViewById(R.id.btn_customers);
    btn_products = findViewById(R.id.btn_products);
    btn_orders = findViewById(R.id.btn_orders);
    btn_reports = findViewById(R.id.btn_reports);
    btn_add_customers = findViewById(R.id.btn_new_customers);
    mainmenu_sync_imagebutton = findViewById(R.id.mainmenu_sync_imagebutton);
    drawerLayout = findViewById(R.id.drawer_layout);
    navigationView = findViewById(R.id.navigation_view);
    toolbar = findViewById(R.id.company_details_activity_toolbar);
    View headerView = navigationView.getHeaderView(0);
    nav_header_name = headerView.findViewById(R.id.nav_header_name);
    nav_header_email = headerView.findViewById(R.id.nav_header_email);
    calendarView = findViewById(R.id.calendar);

  }

  public void btnonClick() {
    //register buttons for onclick listener
    btn_customers.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Main_Menu.this, Customer_List.class);
        spdt.editor_data_tranfer.putString("side", "customerside");
        spdt.editor_data_tranfer.commit();
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
      }
    });
    btn_products.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Main_Menu.this, Product_List.class);
        spdt.editor_data_tranfer.putString("side", "productside");
        spdt.editor_data_tranfer.commit();
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
      }
    });
    btn_orders.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Main_Menu.this, Orders_List_Activity.class);
        spdt.editor_data_tranfer.putString("side", "orderside");
        spdt.editor_data_tranfer.commit();
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
      }
    });
    btn_reports.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ReportsAlertDialog();
      }
    });
  }

  public void ReportsAlertDialog() {

    final Dialog reportdialog = new Dialog(this);
    reportdialog.setContentView(R.layout.custom_report_dialog);
    reportdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    int width = ViewGroup.LayoutParams.MATCH_PARENT;
    int height = ViewGroup.LayoutParams.WRAP_CONTENT;
    reportdialog.getWindow().setLayout(width, height);

    CardView daily_report, current_sales, search_by_date, current_year_sales, last_year_sales;

    daily_report = reportdialog.findViewById(R.id.daily_sales_report_card);
    current_year_sales = reportdialog.findViewById(R.id.current_year_sales_report_card);
    current_sales = reportdialog.findViewById(R.id.current_month_sales_report_card);
    search_by_date = reportdialog.findViewById(R.id.search_by_date_report_card);
    last_year_sales = reportdialog.findViewById(R.id.last_year_sales_report_card);

    daily_report.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Main_Menu.this, Daily_Reports_Activity.class);
        intent.putExtra("order_type", "Daily");
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        reportdialog.dismiss();
      }
    });

    current_year_sales.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Main_Menu.this, Daily_Reports_Activity.class);
        intent.putExtra("order_type", "Current");
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        reportdialog.dismiss();
      }
    });

    current_sales.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Main_Menu.this, Daily_Reports_Activity.class);
        intent.putExtra("order_type", "Monthly");
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        reportdialog.dismiss();
      }
    });

    search_by_date.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final Dialog caldialog = new Dialog(Main_Menu.this);
        caldialog.setContentView(R.layout.calender_time_picker_date_picker);
        caldialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        caldialog.show();
        Button viewreport = caldialog.findViewById(R.id.viewreport);
        DateRangeCalendarView calendar = caldialog.findViewById(R.id.calendar);

        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String[] start_date = new String[1];
        final String[] end_date = new String[1];

        calendar.setCalendarListener(new DateRangeCalendarView.CalendarListener() {
          @Override
          public void onFirstDateSelected(Calendar startDate) {

          }

          @Override
          public void onDateRangeSelected(Calendar startDate, Calendar endDate) {
            start_date[0] = dateFormat.format(startDate.getTime());
            end_date[0] = dateFormat.format(endDate.getTime());
          }
        });

        viewreport.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(Main_Menu.this, Daily_Reports_Activity.class);
            intent.putExtra("order_type", "Custom");
            intent.putExtra("start_date", start_date[0]);
            intent.putExtra("end_date", end_date[0]);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            caldialog.dismiss();
          }
        });
        reportdialog.dismiss();
      }
    });

    last_year_sales.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Main_Menu.this, Daily_Reports_Activity.class);
        intent.putExtra("order_type", "Last");
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        reportdialog.dismiss();
      }
    });

    reportdialog.show();

  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

    SyncAllData obj = new SyncAllData(Main_Menu.this, pb);
    switch (menuItem.getItemId()) {

      case R.id.drawer_logout_menu:
        final Dialog logout_dialog = new Dialog(this);
        logout_dialog.setContentView(R.layout.exit_dialog_layout);
        logout_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        logout_dialog.getWindow().setLayout(width, height);

        ImageView logout_image = logout_dialog.findViewById(R.id.logoutdialogimage);
        TextView logout_heading = logout_dialog.findViewById(R.id.logoutdialogheading);
        TextView logout_txt = logout_dialog.findViewById(R.id.logoutdialogtxt);
        Button yesbtn = logout_dialog.findViewById(R.id.exit_dialog_btn_yes);
        Button nobtn = logout_dialog.findViewById(R.id.exit_dialog_btn_no);

        logout_image.setImageResource(R.drawable.outline_exit_to_app_blue_900_48dp);
        logout_heading.setText("Logout?");
        logout_txt.setText("Are you sure you want to logout?");

        yesbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            logout_dialog.dismiss();
            pb.pb_load_tv.setText("Please Wait...");
            pb.show();

            LogoutAPI obj = new LogoutAPI(Main_Menu.this);
            obj.Logout_API(pb);


            //user_logout();
          }
        });
        nobtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            logout_dialog.dismiss();
          }
        });

        logout_dialog.show();
        break;

      case R.id.drawer_Settings_menu:
        final Dialog builder = new Dialog(this);
        builder.setContentView(R.layout.custom_dialog_setting_button_click_login_layout);
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        width = ViewGroup.LayoutParams.MATCH_PARENT;
        height = ViewGroup.LayoutParams.MATCH_PARENT;
        builder.getWindow().setLayout(width, height);


        final TextView error_msg = builder.findViewById(R.id.verification_failed_error_msg);
        final EditText ed_email = builder.findViewById(R.id.varify_username);
        final EditText ed_password = builder.findViewById(R.id.varify_password);
        final LinearLayout ll = builder.findViewById(R.id.setting_login_dialog_background);
//        ll.setBackgroundResource(R.drawable.wallpapweformenu3);
        Button btn_verify = builder.findViewById(R.id.varifybtn);
        btn_verify.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            builder.hide();
            pb.show();
            final String email = ed_email.getText().toString();
            final String password = ed_password.getText().toString();
            Login_SettingsAPI obj = new Login_SettingsAPI(Main_Menu.this, builder);
            obj.Login_Settings(Main_Menu.this, email, password, pb);
          }
        });

        builder.show();

        break;

      case R.id.navigation_company_info:
        Intent intent = new Intent(this, Company_Details.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        break;
      case R.id.navigation_send_customers_and_orders:
        pb.pb_load_tv.setText("Connecting...");
        pb.show();
        spdt.editor_data_tranfer.putBoolean("updateall", false);
        spdt.editor_data_tranfer.commit();
        obj = new SyncAllData(Main_Menu.this, pb);
        obj.sendOrdersAndCustomers();
        break;
      case R.id.navigation_update_All:
        pb.pb_load_tv.setText("Connecting...");
        pb.show();
        //============================= UPDATING ALL DATA ===================================================================================
        spdt.editor_data_tranfer.putBoolean("updateall", true);
        spdt.editor_data_tranfer.commit();
        obj = new SyncAllData(Main_Menu.this, pb);
        obj.syncAllData();
        break;

    }
    drawerLayout.closeDrawer(GravityCompat.START);
    return true;
  }

  //=======================SHOW PHONE STATE PERMISSION CODE=================================================
  public synchronized void showPhoneStatePermission() {

    if (ContextCompat.checkSelfPermission(this, READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
      //If permission is previously granted get imei  -- inside imei call api to send imei
      getIMEI();
    } else {
      //requesting for READ_PHONE_STATE permissions
      ActivityCompat.requestPermissions(this, new String[]{READ_PHONE_STATE}, REQUEST_PERMISSION_PHONE_STATE);
    }
  }

  public synchronized void sendIMEIToApi() {

    //========= This Api is called as soon as the customer selects sales rep right after login page. ==================================================
    // This method will send selected sales rep and get Last invoice/estimate/salesorder and set in view
    SendSalesRepFirstTimeAPI obj = new SendSalesRepFirstTimeAPI(Main_Menu.this);
    obj.SendSalesRepFirstTime_API(Main_Menu.this, salesrep_for_api, spdt.pref_client.getString("Access_token", null), imei);
    selectSalesRepDialog.dismiss();
    showTutorials();
  }


  public synchronized void getIMEI() {
    String deviceId = IMEIUtil.getDeviceId(this);
    imei = deviceId;
    spdt.editor_client.putString("imei", imei);
    spdt.editor_client.putString("sales_rep_id", salesrep_for_api);
    spdt.editor_client.commit();
    if (!imei.isEmpty()) {
      sendIMEIToApi();   //This funtion call sendSalesRepToServerForFirstTime API
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode) {
      case 1: {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          getIMEI();
          selectSalesRepDialog.dismiss();

        }
        return;
      }
    }
  }


  public void showTutorials() {
    //**********************************************************************************************
    new MaterialTapTargetSequence()
            .addPrompt(new MaterialTapTargetPrompt.Builder(Main_Menu.this)
                    .setTarget(findViewById(R.id.mainmenu_sync_imagebutton))
                    .setBackgroundColour(getResources().getColor(R.color.Primary))
                    .setPrimaryText("Synchronization")
                    .setPrimaryTextColour(getResources().getColor(R.color.white))
                    .setSecondaryText("This will sync data with server")
                    .setSecondaryTextColour(getResources().getColor(R.color.white))
                    .setAutoDismiss(false)
                    .setAutoFinish(false)
                    .setCaptureTouchEventOnFocal(true)
                    .setCaptureTouchEventOutsidePrompt(true)
                    .create(), 4000)
            .addPrompt(new MaterialTapTargetPrompt.Builder(Main_Menu.this)
                    .setTarget(findViewById(R.id.customer_icon))
                    .setBackgroundColour(getResources().getColor(R.color.Primary))
                    .setPrimaryText("Customers")
                    .setPrimaryTextColour(getResources().getColor(R.color.white))
                    .setSecondaryText("You can create orders from here")
                    .setSecondaryTextColour(getResources().getColor(R.color.white))
                    .setAnimationInterpolator(new LinearOutSlowInInterpolator())
                    .setAutoDismiss(false)
                    .setAutoFinish(false)
                    .setCaptureTouchEventOnFocal(true)
                    .setCaptureTouchEventOutsidePrompt(true)
                    .create(), 4000)
            .addPrompt(new MaterialTapTargetPrompt.Builder(Main_Menu.this)
                    .setTarget(findViewById(R.id.product_icon))
                    .setBackgroundColour(getResources().getColor(R.color.Primary))
                    .setPrimaryText("Products")
                    .setPrimaryTextColour(getResources().getColor(R.color.white))
                    .setSecondaryText("Product Details can be viewed by clicking here")
                    .setSecondaryTextColour(getResources().getColor(R.color.white))
                    .setAnimationInterpolator(new LinearOutSlowInInterpolator())
                    .setAutoDismiss(false)
                    .setAutoFinish(false)
                    .setCaptureTouchEventOnFocal(true)
                    .setCaptureTouchEventOutsidePrompt(true)
                    .create(), 4000)
            .addPrompt(new MaterialTapTargetPrompt.Builder(Main_Menu.this)
                    .setTarget(findViewById(R.id.orders_icon))
                    .setBackgroundColour(getResources().getColor(R.color.Primary))
                    .setPrimaryText("Recent Orders")
                    .setPrimaryTextColour(getResources().getColor(R.color.white))
                    .setSecondaryText("Update or Delete Order")
                    .setSecondaryTextColour(getResources().getColor(R.color.white))
                    .setAnimationInterpolator(new LinearOutSlowInInterpolator())
                    .setAutoDismiss(false)
                    .setAutoFinish(false)
                    .setCaptureTouchEventOnFocal(true)
                    .setCaptureTouchEventOutsidePrompt(true)
                    .create(), 4000)
            .addPrompt(new MaterialTapTargetPrompt.Builder(Main_Menu.this)
                    .setTarget(findViewById(R.id.report_icon))
                    .setBackgroundColour(getResources().getColor(R.color.Primary))
                    .setPrimaryText("Reports")
                    .setPrimaryTextColour(getResources().getColor(R.color.white))
                    .setSecondaryText("View Daily, Monthly Custom Reports")
                    .setSecondaryTextColour(getResources().getColor(R.color.white))
                    .setAnimationInterpolator(new LinearOutSlowInInterpolator())
                    .setAutoDismiss(false)
                    .setAutoFinish(false)
                    .setCaptureTouchEventOnFocal(true)
                    .setCaptureTouchEventOutsidePrompt(true)
                    .create(), 4000)
            .addPrompt(new MaterialTapTargetPrompt.Builder(Main_Menu.this)
                    .setTarget(findViewById(R.id.add_customer_icon))
                    .setBackgroundColour(getResources().getColor(R.color.Primary))
                    .setPrimaryText("Customer")
                    .setPrimaryTextColour(getResources().getColor(R.color.white))
                    .setSecondaryText("Add New Customer")
                    .setSecondaryTextColour(getResources().getColor(R.color.white))
                    .setAnimationInterpolator(new LinearOutSlowInInterpolator())
                    .setAutoDismiss(false)
                    .setAutoFinish(false)
                    .setCaptureTouchEventOnFocal(true)
                    .setCaptureTouchEventOutsidePrompt(true)
                    .create(), 4000)
            .show();
  }


}

