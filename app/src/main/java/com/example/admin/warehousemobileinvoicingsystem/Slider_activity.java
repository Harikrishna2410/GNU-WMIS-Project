package com.example.admin.warehousemobileinvoicingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class Slider_activity extends AppCompatActivity {

  ViewPager sliderpage;
  LinearLayout dorlayout;
  ImageView back, forward;
  TextView[] mdot;
  int currentpage;

  SliderAdapter sliderAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_slider_activity);

    Binding();

    sliderAdapter = new SliderAdapter(this);

    sliderpage.setAdapter(sliderAdapter);

    addDotsIndicator(0);

    sliderpage.addOnPageChangeListener(viewListner);

    forward.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        sliderpage.setCurrentItem(currentpage + 1);

      }
    });
    back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        sliderpage.setCurrentItem(currentpage - 1);

      }
    });


  }

  public void addDotsIndicator(int position) {
    mdot = new TextView[sliderAdapter.slide_title.length];
    dorlayout.removeAllViews();

    for (int i = 0; i < mdot.length; i++) {

      mdot[i] = new TextView(this);
      mdot[i].setText(Html.fromHtml("&#8226;"));
      mdot[i].setTextSize(35);
      mdot[i].setTextColor(getResources().getColor(R.color.grayesh));

      dorlayout.addView(mdot[i]);

    }

    if (mdot.length > 0) {

      mdot[position].setTextColor(getResources().getColor(R.color.blueesh));

    }


  }


  ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

      addDotsIndicator(position);

      currentpage = position;

      if (position == 0) {

        forward.setEnabled(true);
        forward.setVisibility(View.VISIBLE);
        back.setEnabled(false);
        back.setVisibility(View.INVISIBLE);

      } else if (position == mdot.length) {

        forward.setEnabled(true);
        forward.setVisibility(View.VISIBLE);
        back.setEnabled(true);
        back.setVisibility(View.VISIBLE);


      } else {
        forward.setEnabled(true);
        forward.setVisibility(View.VISIBLE);
        forward.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent i = new Intent(Slider_activity.this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
          }
        });
        back.setEnabled(true);
        back.setVisibility(View.VISIBLE);

      }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
  };

  void Binding() {

    sliderpage = findViewById(R.id.Viewpager);
    dorlayout = findViewById(R.id.dot_layout);
    back = findViewById(R.id.button_backward);
    forward = findViewById(R.id.button_forward);

  }

}
