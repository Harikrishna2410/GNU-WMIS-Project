package com.example.admin.warehousemobileinvoicingsystem;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MyGlobals {

//  https://stackoverflow.com/questions/46275038/display-snackbar-without-coordinatorlayout
  public static void setSnackBar(View root, String snackTitle) {
    Snackbar snackbar = Snackbar.make(root, snackTitle, Snackbar.LENGTH_LONG);
    View view = snackbar.getView();
    view.setBackgroundColor(view.getResources().getColor(R.color.Primary));

    TextView textView = (TextView)view.findViewById(com.google.android.material.R.id.snackbar_text);
    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.wifi_disconnected_white_96px, 0, 0, 0);
    textView.setCompoundDrawablePadding(150);
    snackbar.show();
  }

  public static void setAlertDialog(Context ctx, int icon, String heading, String text, int yes_btn_visible, int no_btn_visible,String yes_btn_text, String no_btn_text){
    Dialog dialog = new Dialog(ctx);
    dialog.setContentView(R.layout.exit_dialog_layout);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    int width = ViewGroup.LayoutParams.MATCH_PARENT;
    int height = ViewGroup.LayoutParams.WRAP_CONTENT;
    dialog.getWindow().setLayout(width, height);

    ImageView logout_image = dialog.findViewById(R.id.logoutdialogimage);
    TextView logout_heading = dialog.findViewById(R.id.logoutdialogheading);
    TextView logout_txt = dialog.findViewById(R.id.logoutdialogtxt);
    Button yesbtn = dialog.findViewById(R.id.exit_dialog_btn_yes);
    Button nobtn = dialog.findViewById(R.id.exit_dialog_btn_no);

    logout_image.setImageResource(icon);
    logout_heading.setText(heading);
    logout_txt.setText(text);
    yesbtn.setText(yes_btn_text);
    nobtn.setText(no_btn_text);
    if(yes_btn_visible==1){
      yesbtn.setVisibility(View.GONE);
    }
    if(no_btn_visible==1){
      nobtn.setVisibility(View.GONE);
    }

    yesbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        dialog.dismiss();
      }
    });
//    nobtn.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        dialog.dismiss();
//      }
//    });
    dialog.show();
  }
}
