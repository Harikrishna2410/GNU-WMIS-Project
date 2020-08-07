package com.example.admin.warehousemobileinvoicingsystem.Reports;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.*;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.warehousemobileinvoicingsystem.API.AllReportsAPI;
import com.example.admin.warehousemobileinvoicingsystem.API.CustomReportAPI;
import com.example.admin.warehousemobileinvoicingsystem.Main_Menu;
import com.example.admin.warehousemobileinvoicingsystem.R;
import com.example.admin.warehousemobileinvoicingsystem.Sync.Reports_model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Daily_Reports_Activity extends AppCompatActivity {

  //region ============================== Global Declaration Section================================
  RecyclerView rv;
  TextView tv_total;
  LinearLayout btn_print;
  //    SQLiteDatabase db;
//    AllTableNames tn;
//    ArrayList<String> arr_Orderno,arr_customername,arr_amount;
//    ArrayList<Daily_Report_pojo> daily_report_pojos;
  Daily_Reports_adapter adapter;
  ConstraintLayout layout;
  DecimalFormat df;
  //VolleyRequest volleyRequest;
  public ArrayList<Reports_model> ob;
  Toolbar toolbar123;
  Double total = 0.00;
  public Dialog dialog;
  AllReportsAPI allReportsAPI;

  //endregion

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_daily__reports_);
    ControllBinding();
    allReportsAPI = new AllReportsAPI(this);
    df = new DecimalFormat("#.00");

    //========================Making view reay for loading progressbar================================================
    View view1 = getLayoutInflater().inflate(R.layout.full_screen_progressbar, null);
    dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_NoActionBar_TranslucentDecor);
    dialog.setCancelable(false);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.darktransparent)));
    dialog.setContentView(view1);
    dialog.show();
    //==============================================================================================================

    String report_type = "";
    Bundle bundle = getIntent().getExtras();
    report_type = bundle.getString("order_type", null);
    //volleyRequest = new VolleyRequest(this);
    //Toast.makeText(this, "report type = "+report_type, Toast.LENGTH_SHORT).show();
    Main_Menu mm = new Main_Menu();

    toolbar123.setTitle(report_type.toString());

    switch (report_type) {
      case "Daily":   //Today's
        allReportsAPI.AllReports_API(this, report_type);
        //volleyRequest.makeJsonArrayRequest_reports(this, report_type);
        break;
      case "Monthly": //Current Month
        allReportsAPI.AllReports_API(this, report_type);
        //volleyRequest.makeJsonArrayRequest_reports(this, report_type);
        break;
      case "Current": //Current year
        allReportsAPI.AllReports_API(this, report_type);
        //volleyRequest.makeJsonArrayRequest_reports(this, report_type);
        break;
      case "Last":    //Last Year
        allReportsAPI.AllReports_API(this, report_type);
        //volleyRequest.makeJsonArrayRequest_reports(this, report_type);
        break;
      case "Custom":  //Custom Date with 3 parameters
        ArrayList<String> start_date = new ArrayList<>();
        ArrayList<String> end_date = new ArrayList<>();
        start_date.add(bundle.getString("start_date", null));
        end_date.add(bundle.getString("end_date", null));

        CustomReportAPI obj = new CustomReportAPI(Daily_Reports_Activity.this);
        obj.CustomReport_API(this, report_type, start_date.get(0), end_date.get(0));
//                volleyRequest.makeJsonArrayRequest_reports_custom(this, report_type,start_date.get(0),end_date.get(0));
        break;
    }

    btn_print.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        //Toast.makeText(Daily_Reports_Activity.this, "Daily Report Print Button Clicked", Toast.LENGTH_LONG).show();
      }
    });


  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }

  void ControllBinding() {
    toolbar123 = findViewById(R.id.report_toolbar);
    setSupportActionBar(toolbar123);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);


    rv = findViewById(R.id.daily_reports_rv);
    tv_total = findViewById(R.id.tv_total_activity_daily_reports);
    btn_print = findViewById(R.id.btn_print_activity_daily_reports);
    layout = findViewById(R.id.layout_screen_activity_daily_reports);
  }

  public void setReportData(ArrayList<Reports_model> reportsModel) {

    //Toast.makeText(this, "hhh="+reportsModel.get(0).getName(), Toast.LENGTH_SHORT).show();

    adapter = new Daily_Reports_adapter(this, reportsModel);
    rv.setAdapter(adapter);
    LinearLayoutManager lm = new LinearLayoutManager(this);
    lm.setOrientation(LinearLayoutManager.VERTICAL);
    rv.setLayoutManager(lm);

    //Toast.makeText(this, "rem = "+reportsModel.size(), Toast.LENGTH_SHORT).show();
    for (int i = 0; i < reportsModel.size(); i++) {
      total = total + Double.parseDouble(reportsModel.get(i).getTotal());
    }
    //Toast.makeText(this, "total = "+total, Toast.LENGTH_SHORT).show();
    tv_total.setText(df.format(total));
    dialog.dismiss();
  }
}