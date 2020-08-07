package com.example.admin.warehousemobileinvoicingsystem;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

  Context context;
  LayoutInflater layoutInflater;


  public SliderAdapter(Context context) {
    this.context = context;
  }

  public int[] slide_image = {
          R.drawable.invoit_white_1_with_white_circle,
          R.drawable.invoit_white_1_with_white_circle,
          R.drawable.invoit_white_1_with_white_circle,
//          R.drawable.ic_assignment_late_white_48dp,
//          R.drawable.ic_assignment_turned_in_white_48dp
  };

  public String[] slide_title = {
          "MOBILE DSD SOFTWARE FOR DISTRIBUTORS",
          "Seamlessly Integrate your day",
          "Features"
  };
  public String[] slide_dis = {
          "Deliver software products and support services that exceed expectations in value and performance.",

          "\u2713 Account Integration\n" +
                  "\u2713 Route\n" +
                  "\u2713 Order\n" +
                  "\u2713 Plan\n" +
                  "\u2713 Optimize\n" +
                  "\u2713 Track Inventory\n" +
                  "\u2713 Moble Invoicing\n" +
                  "\u2713 Payments\n" +
                  "\u2713 Settle",

                  " \u2713 Easy to use\n " +
                  "\u2713 Simple Invoicing\n " +
                  "\u2713 Cloud Storage\n " +
                  "\u2713 Inventory Management\n " +
                  "\u2713 Increase Sales\n " +
                  "\u2713 Increase Efficiency\n " +
                  "\u2713 Signature Capture\n " +
                  "\u2713 Reduce Waste\n " +
                  "\u2713 Smart Reporting"
  };


  @Override
  public int getCount() {
    return slide_title.length;
  }

  @Override
  public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
    return view == (ConstraintLayout) object;
  }

  @NonNull
  @Override
  public Object instantiateItem(@NonNull ViewGroup container, int position) {

    layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    View view = layoutInflater.inflate(R.layout.slide_layout, container, false);


    ImageView simage = view.findViewById(R.id.imglayout);
    TextView sheading = view.findViewById(R.id.heading);
    TextView sdis = view.findViewById(R.id.discription);

    simage.setImageResource(slide_image[position]);
    sheading.setText(slide_title[position]);
    sdis.setText(slide_dis[position]);

    container.addView(view);

    return view;

  }

  @Override
  public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    container.removeView((ConstraintLayout) object);

  }
}
