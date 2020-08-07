package com.example.admin.warehousemobileinvoicingsystem.Website_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.*;

import com.example.admin.warehousemobileinvoicingsystem.R;

public class Signup_registration extends AppCompatActivity {

  WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup_registration);

    webView = findViewById(R.id.registration_webview);
    webView.setWebViewClient(new WebViewClient());
    webView.loadUrl("http://wsapp.webbakerlab.com/register");

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
