package com.example.admin.warehousemobileinvoicingsystem.Products;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter_Products extends Filter {

  MyAdapter_Products adapter;
  ArrayList<ProductModel> filterList;

  public CustomFilter_Products(ArrayList<ProductModel> filterList, MyAdapter_Products adapter) {
    this.adapter = adapter;
    this.filterList = filterList;
  }

  //FILTERING OCURS
  @Override
  protected FilterResults performFiltering(CharSequence constraint) {
    FilterResults results = new FilterResults();

    //CHECK CONSTRAINT VALIDITY
    if (constraint != null && constraint.length() > 0) {
      //CHANGE TO UPPER
      constraint = constraint.toString().toUpperCase();
      //STORE OUR FILTERED PLAYERS
      ArrayList<ProductModel> filteredProducts = new ArrayList<>();

      for (int i = 0; i < filterList.size(); i++) {
        //CHECK
        if (filterList.get(i).getName().toUpperCase().contains(constraint)) {
          //ADD PLAYER TO FILTERED PLAYERS
          filteredProducts.add(filterList.get(i));
        }
      }

      results.count = filteredProducts.size();
      results.values = filteredProducts;
    } else {
      results.count = filterList.size();
      results.values = filterList;

    }

    return results;
  }

  @Override
  protected void publishResults(CharSequence constraint, FilterResults results) {

    adapter.products = (ArrayList<ProductModel>) results.values;

    //REFRESH
    adapter.notifyDataSetChanged();
  }

}
