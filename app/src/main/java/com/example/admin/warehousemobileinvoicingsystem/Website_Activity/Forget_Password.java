package com.example.admin.warehousemobileinvoicingsystem.Website_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.*;

import com.example.admin.warehousemobileinvoicingsystem.R;

public class Forget_Password extends AppCompatActivity {


  WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_forget__password);

    webView = findViewById(R.id.forget_password_webview);
    webView.setWebViewClient(new WebViewClient());
    webView.loadUrl("http://wsapp.webbakerlab.com/log");

    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);

  }

  @Override
  public void onBackPressed() {
    if (webView.canGoBack()) {

      webView.goBack();

    } else {

      super.onBackPressed();

    }
  }
}
