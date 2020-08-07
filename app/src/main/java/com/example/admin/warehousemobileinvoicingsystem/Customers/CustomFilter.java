package com.example.admin.warehousemobileinvoicingsystem.Customers;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {

  MyAdapter_Customer adapter;
  ArrayList<CustModel> filterList;

  public CustomFilter(ArrayList<CustModel> filterList, MyAdapter_Customer adapter) {
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
      ArrayList<CustModel> filteredCustomers = new ArrayList<>();

      for (int i = 0; i < filterList.size(); i++) {
        //CHECK
        if (filterList.get(i).getName().toUpperCase().contains(constraint)) {
          //ADD PLAYER TO FILTERED PLAYERS
          filteredCustomers.add(filterList.get(i));
        }
      }

      results.count = filteredCustomers.size();
      results.values = filteredCustomers;
    } else {
      results.count = filterList.size();
      results.values = filterList;

    }

    return results;
  }

  @Override
  protected void publishResults(CharSequence constraint, FilterResults results) {

    adapter.customers = (ArrayList<CustModel>) results.values;

    //REFRESH
    adapter.notifyDataSetChanged();
  }

}
