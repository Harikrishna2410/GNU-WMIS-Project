package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.R;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.*;

import info.androidhive.barcode.BarcodeReader;

import static android.Manifest.permission.READ_PHONE_STATE;

public class ScanActivity extends AppCompatActivity {

  private BarcodeDetector barcodeDetector;
  private CameraSource cameraSource;
  private SurfaceView cameraView;
  private AppCompatTextView barcodeValue;
  // helper objects for detecting taps and pinches.
  private ScaleGestureDetector scaleGestureDetector;
  private GestureDetector gestureDetector;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scan);
    cameraView = findViewById(R.id.surface_view);
    barcodeValue = findViewById(R.id.barcode_value);
    BarcodeReader barcodeDetector1 = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.surface_view);
    barcodeDetector = new BarcodeDetector.Builder(this)
            .setBarcodeFormats(Barcode.ALL_FORMATS)
            .build();

    ViewGroup.LayoutParams params = cameraView.getLayoutParams();
    DisplayMetrics dm = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(dm);
    params.width = dm.widthPixels;
    params.height = dm.heightPixels;
    cameraView.setLayoutParams(params);

    cameraSource = new CameraSource.Builder(this, barcodeDetector)
            .setAutoFocusEnabled(true)
            .build();

    cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
      @Override
      public void surfaceCreated(SurfaceHolder holder) {
        try {
          //noinspection MissingPermission
          if (ActivityCompat.checkSelfPermission(ScanActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(ScanActivity.this, "permission not", Toast.LENGTH_SHORT).show();

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(ScanActivity.this, Manifest.permission.CAMERA)) {
              //    showAlert();
              Toast.makeText(ScanActivity.this, "show alert", Toast.LENGTH_SHORT).show();
            } else {
              // No explanation needed, we can request the permission.
              ActivityCompat.requestPermissions(ScanActivity.this, new String[]{Manifest.permission.CAMERA}, 100);
            }

            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
          } else {
            cameraSource.start(cameraView.getHolder());
          }

        } catch (IOException ex) {
          ex.printStackTrace();
        }

      }

      @Override
      public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

      }

      @Override
      public void surfaceDestroyed(SurfaceHolder holder) {
        cameraSource.stop();
      }
    });

    barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
      @Override
      public void release() {

      }

      @Override
      public void receiveDetections(final Detector.Detections<Barcode> detections) {
        final SparseArray<Barcode> barcodes = detections.getDetectedItems();

        if (barcodes.size() != 0) {
          barcodeValue.post(new Runnable() {
            @Override
            public void run() {
              //Update barcode value to TextView
              String bar = barcodes.valueAt(0).displayValue.toString();
              barcodeValue.setText(barcodes.valueAt(0).displayValue);
              Intent intent = new Intent();
              intent.putExtra("barcode_Value", bar);
              setResult(1, intent);
              finish();
            }
          });
        }
      }
    });


  }

/*
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        boolean b = scaleGestureDetector.onTouchEvent(e);

        boolean c = gestureDetector.onTouchEvent(e);

        return b || c || super.onTouchEvent(e);
    }*/

  @Override
  protected void onDestroy() {
    super.onDestroy();
    cameraSource.release();
    barcodeDetector.release();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }
}
