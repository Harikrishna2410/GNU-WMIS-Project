package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;

import android.telephony.TelephonyManager;

public class IMEIUtil {

  public static String getDeviceId(Context context) {
    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling
      //    ActivityCompat#requestPermissions
      // here to request the missing permissions, and then overriding
      //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
      //                                          int[] grantResults)
      // to handle the case where the user grants the permission. See the documentation
      // for ActivityCompat#requestPermissions for more details.
      return null;
    }
    String deviceId = telephonyManager.getDeviceId().trim();
    if (deviceId == null) {
      String androidId = Settings.Secure.getString(context.getContentResolver(),
              Settings.Secure.ANDROID_ID);
      deviceId = android.os.Build.SERIAL + "#" + androidId;
    }
    return deviceId.trim();
  }
}
