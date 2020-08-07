package com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.admin.warehousemobileinvoicingsystem.API.GetAllSalesRepAPI;
import com.example.admin.warehousemobileinvoicingsystem.ApiUrl;
import com.example.admin.warehousemobileinvoicingsystem.DbHelper;
import com.example.admin.warehousemobileinvoicingsystem.Products.ProductModel;
import com.example.admin.warehousemobileinvoicingsystem.ProgressBarHandler;
import com.example.admin.warehousemobileinvoicingsystem.SharedPreferenceForDataTransfer;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AsyncGetAllProducts extends AsyncTask<String, Integer, String> {

  Context ctx;
  SharedPreferenceForDataTransfer spdt;
  ApiUrl apiUrl;
  DbHelper dbHelper;
  SyncCustomers sc;
  ProgressBarHandler pb;
  JSONObject response;

  public AsyncGetAllProducts(Context ctx, JSONObject response, ProgressBarHandler pb) {
    this.ctx = ctx;
    this.spdt = new SharedPreferenceForDataTransfer(ctx);
    this.apiUrl = new ApiUrl(ctx);
    this.dbHelper = new DbHelper(ctx);
    this.sc = new SyncCustomers();
    this.pb = pb;
    this.response = response;

  }

  @Override
  protected void onPreExecute() {
    pb.pb_load_tv.setText("Loading Products...");
    //pb.show();
    super.onPreExecute();
  }

  @Override
  protected String doInBackground(String... strings) {
    processResponse();
    return null;
  }

  private void processResponse() {

    try {
      ArrayList<ProductModel> productModel = new ArrayList<>();
      JSONArray jsonArray = response.getJSONArray("all_products_detail");
      if (jsonArray.length() > 0) {
        productModel.clear();
        for (int i = 0; i < jsonArray.length(); i++) {
          ProductModel ob = new ProductModel();
          JSONObject jsonObject = (JSONObject) jsonArray.get(i);
          ob.setId(jsonObject.getString("id").trim());
          ob.setClient_id(jsonObject.getString("client_id").trim());
          ob.setTax_rule_id(jsonObject.getString("tax_rule_id").trim());
          ob.setCategory_id(jsonObject.getString("category_id").trim());
          ob.setSupplier_id(jsonObject.getString("supplier_id").trim());
          ob.setDiscountrule_id(jsonObject.getString("discountrule_id").trim());
          ob.setImgUrl(jsonObject.getString("imgUrl").trim());
          ob.setBarcodeno(jsonObject.getString("barcodeno").trim());
          ob.setName(jsonObject.getString("name").trim());
          ob.setPrice(jsonObject.getString("price").trim());
          ob.setCost(jsonObject.getString("cost").trim());
          ob.setDiscount_type(jsonObject.getString("discount_type").trim());
          ob.setDiscount_rate(jsonObject.getString("discount_rate").trim());
          ob.setQuantity(jsonObject.getString("quantity").trim());
          ob.setIs_active(jsonObject.getString("is_active").trim());
          ob.setIs_taxable(jsonObject.getString("is_taxable").trim());
          ob.setReorder_level(jsonObject.getString("reorder_level").trim());
          ob.setExpires_at(jsonObject.getString("expires_at").trim());
          ob.setDays_left(jsonObject.getString("days_left").trim());
          ob.setCreated_at(jsonObject.getString("created_at").trim());
          ob.setUpdated_at(jsonObject.getString("updated_at").trim());
          ob.setDeleted_at(jsonObject.getString("deleted_at").trim());
          productModel.add(ob);
        }
        dbHelper.syncProductsTable(productModel);       //Adds all products in local DB
      } else {
//                GetAllSalesRepAPI obj = new GetAllSalesRepAPI(ctx);
//                obj.GetAllSalesRep_API(main_menu, pb);
      }
    } catch (JSONException e) {
      e.printStackTrace();
      Toast.makeText(ctx, "GetAllProducts_API : line 73", Toast.LENGTH_SHORT).show();
      pb.dismiss();
    }
  }

  @Override
  protected void onProgressUpdate(Integer... values) {

    pb.progressBar_dynamic.setProgress(values[0]);
    super.onProgressUpdate(values);
  }


  @Override
  protected void onPostExecute(String s) {
    //pb.dismiss();
    //Toast.makeText(ctx, "Syncccing Completeee", Toast.LENGTH_SHORT).show();
    GetAllSalesRepAPI obj = new GetAllSalesRepAPI(ctx);
    obj.GetAllSalesRep_API(pb);

    super.onPostExecute(s);

  }
}
