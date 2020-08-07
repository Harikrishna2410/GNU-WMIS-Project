package com.example.admin.warehousemobileinvoicingsystem;

import android.content.*;
import android.graphics.*;
import android.util.*;

import java.io.*;

public class GetSignatureFile {
  Context ctx;

  public GetSignatureFile(Context ctx) {
    this.ctx = ctx;
  }

  public String getStringImage(String invoiceno, String order_type) {
    Bitmap bitmap;
    String imageString = "null";
    ContextWrapper cw = new ContextWrapper(ctx);
    File directory = cw.getDir("Signatures_Images", Context.MODE_PRIVATE);
    File[] files = directory.listFiles();
    for (int i = 0; i < files.length; i++) {
      if (files[i].getName().equals(order_type + "-" + invoiceno + ".jpg")) {
        File mypath = new File(directory, order_type + "-" + invoiceno + ".jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap = BitmapFactory.decodeFile(mypath.toString());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        break;
      }
    }
    return imageString;
  }

  public void deleteSignatureFile() {
    ContextWrapper cw = new ContextWrapper(ctx);
    File directory = cw.getDir("Signatures_Images", Context.MODE_PRIVATE);
    File[] files = directory.listFiles();
    for (int i = 0; i < files.length; i++) {
      files[i].delete();
    }
  }
}
