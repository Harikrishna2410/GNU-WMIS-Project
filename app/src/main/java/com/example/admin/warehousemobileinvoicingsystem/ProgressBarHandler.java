package com.example.admin.warehousemobileinvoicingsystem;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.*;
import android.widget.*;

public class ProgressBarHandler {
  private Context ctx;
  public View view1;
  Dialog dialog;
  public TextView pb_load_tv;
  public ProgressBar progressBar_dynamic;

  public ProgressBarHandler(Context context) {
    this.ctx = context;
    this.view1 = LayoutInflater.from(ctx).inflate(R.layout.progressbar_dialog, null);
    this.pb_load_tv = this.view1.findViewById(R.id.progressbar_text);
    this.progressBar_dynamic = this.view1.findViewById(R.id.progressbar_dynamic);
    this.dialog = new Dialog(ctx, android.R.style.Theme_DeviceDefault_NoActionBar_TranslucentDecor);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(ctx.getResources().getColor(R.color.darktransparent)));
    dialog.setContentView(view1);
    dialog.getWindow().getAttributes();
    //========================================================
    int h = WindowManager.LayoutParams.MATCH_PARENT;
    int w = WindowManager.LayoutParams.MATCH_PARENT;
    dialog.getWindow().setLayout(h, w);
    dialog.setCancelable(false);

  }

  public void show() {
    dialog.show();
  }

  public void dismiss() {
    dialog.dismiss();
  }
}
