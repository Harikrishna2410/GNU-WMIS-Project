package com.example.admin.warehousemobileinvoicingsystem;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.example.admin.warehousemobileinvoicingsystem.Reports.Daily_Reports_Activity;
import com.example.admin.warehousemobileinvoicingsystem.Sync.SyncCustomers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VolleyRequest extends AppCompatActivity {

/*    static Context ctx;
    static SharedPreferenceForDataTransfer spdt;
    static SharedPreferences pref;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    public String imei="";

    SharedPreferences.Editor editor;
    SyncCustomers sc = new SyncCustomers();*/

/*
    //region GLOBAL DECLARATION SECTION
    private static final String URL_LOCAL_JSON_ARRAY = "http://wsapp.webbakerlab.com/api/login";
    private static final String URL_LOCAL_JSON_ARRAY_CUST = "http://wsapp.webbakerlab.com/api/cust-"    ;  // cust-sales_rep_id
    private static final String URL_LOCAL_JSON_ARRAY_PRODUCT = "http://wsapp.webbakerlab.com/api/getproduct-"; // getproduct-sales_rep_id
    private static final String URL_LOCAL_JSON_ARRAY_TAXRULES = "http://wsapp.webbakerlab.com/api/gettaxrules-"; // gettaxrules-sales_rep_id
    private static final String URL_LOCAL_JSON_ARRAY_SALESREP = "http://wsapp.webbakerlab.com/api/getsalesrep-";
    private static final String URL_LOCAL_JSON_ARRAY_ALL_SALESREP = "http://wsapp.webbakerlab.com/api/getsalesrep";
    private static final String URL_LOCAL_JSON_ARRAY_SENDNEWCUSTOMERS = "http://wsapp.webbakerlab.com/api/newcustomer";
    private static final String URL_LOCAL_JSON_ARRAY_SENDNEWORDERS = "http://wsapp.webbakerlab.com/api/neworder";
    private static final String URL_LOCAL_JSON_ARRAY_NEWLOGIN = "http://wsapp.webbakerlab.com/api/newlogin-";
    private static final String URL_LOCAL_JSON_ARRAY_REPORTS = "http://wsapp.webbakerlab.com/api/reports-";
*/

/*
    private static final String URL_LOCAL_JSON_ARRAY = "http://192.168.43.223:8000/api/login";
    private static final String URL_LOCAL_JSON_ARRAY_CUST = "http://192.168.43.223:8000/api/cust-";  // cust-sales_rep_id
    private static final String URL_LOCAL_JSON_ARRAY_PRODUCT = "http://192.168.43.223:8000/api/getproduct-"; // getproduct-sales_rep_id
    private static final String URL_LOCAL_JSON_ARRAY_TAXRULES = "http://192.168.43.223:8000/api/gettaxrules-"; // gettaxrules-sales_rep_id
    private static final String URL_LOCAL_JSON_ARRAY_SALESREP = "http://192.168.43.223:8000/api/getsalesrep-";
    private static final String URL_LOCAL_JSON_ARRAY_ALL_SALESREP = "http://192.168.43.223:8000/api/getsalesrep";
    private static final String URL_LOCAL_JSON_ARRAY_SENDNEWCUSTOMERS = "http://192.168.43.223:8000/api/newcustomer";
    private static final String URL_LOCAL_JSON_ARRAY_SENDNEWORDERS = "http://192.168.43.223:8000/api/neworder";
    private static final String URL_LOCAL_JSON_ARRAY_NEWLOGIN = "http://192.168.43.223:8000/api/newlogin-";
    private static final String URL_LOCAL_JSON_ARRAY_REPORTS = "http://192.168.43.223:8000/api/reports-";
*/

/*
    private static final String URL_LOCAL_JSON_ARRAY = "http://192.168.1.3:8000/api/login";
    private static final String URL_LOCAL_JSON_ARRAY_CUST = "http://192.168.1.3:8000/api/cust-";  // cust-sales_rep_id
    private static final String URL_LOCAL_JSON_ARRAY_PRODUCT = "http://192.168.1.3:8000/api/getproduct-"; // getproduct-sales_rep_id
    private static final String URL_LOCAL_JSON_ARRAY_TAXRULES = "http://192.168.1.3:8000/api/gettaxrules-"; // gettaxrules-sales_rep_id
    private static final String URL_LOCAL_JSON_ARRAY_SALESREP = "http://192.168.1.3:8000/api/getsalesrep-";
    private static final String URL_LOCAL_JSON_ARRAY_ALL_SALESREP = "http://192.168.1.3:8000/api/getsalesrep";
    private static final String URL_LOCAL_JSON_ARRAY_SENDNEWCUSTOMERS = "http://192.168.1.3:8000/api/newcustomer";
    private static final String URL_LOCAL_JSON_ARRAY_SENDNEWORDERS = "http://192.168.1.3:8000/api/neworder";
    private static final String URL_LOCAL_JSON_ARRAY_NEWLOGIN = "http://192.168.1.3:8000/api/newlogin-";
    private static final String URL_LOCAL_JSON_ARRAY_REPORTS = "http://192.168.1.3:8000/api/reports-";
    private static final String URL_LOCAL_JSON_ARRAY_LOGOUT = "http://192.168.1.3:8000/api/logout-";*/

  //endregion

/*    public VolleyRequest(Context context,SharedPreferenceForDataTransfer spdt) {
        this.ctx = context;
        this.spdt = spdt;
    }

    public VolleyRequest(MainActivity mainActivity) {

        this.ctx = mainActivity;
//        showPhoneStatePermission();
    }


    public VolleyRequest(Main_Menu main_menu) {
        this.ctx = main_menu;
        //this.Access_token = access_token;
    }

    public VolleyRequest(Daily_Reports_Activity daily_reports_activity) {
        this.ctx = daily_reports_activity;
    }*/

    /*
    public void makeJsonArrayRequest(final MainActivity mainActivity, final String get_email, final String get_pass, final SharedPreferenceForDataTransfer spdt) {
        this.ctx = mainActivity;
        try {
            final HashMap<String, String> params = new HashMap<String, String>();
            RequestQueue queue = Volley.newRequestQueue(mainActivity);
            params.put("email", get_email);
            params.put("password", get_pass);

            final JSONObject jsonBody = new JSONObject();
            jsonBody.put("email", get_email);
            jsonBody.put("password",get_pass);
            JsonObjectRequest req = new JsonObjectRequest (Request.Method.POST, URL_LOCAL_JSON_ARRAY,jsonBody,new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try
                    {
                        //ArrayList<SyncSalesRep> syncSalesReps = new ArrayList<>();
                        String message = response.getString("message");
                        if(message.equals("Success"))
                        {
                            //Toast.makeText(mainActivity, "MESSAGE = "+message, Toast.LENGTH_SHORT).show();
                            JSONObject object = response.getJSONObject("user_detail");
                            spdt.editor_client.putString("client_id", object.getString("id"));
                            spdt.editor_client.putString("client_company_name", object.getString("company_name"));
                            spdt.editor_client.putString("client_email", object.getString("email"));
                            spdt.editor_client.putString("client_contact_person_name",object.getString("contact_person_name"));
                            spdt.editor_client.putString("client_phone_no",object.getString("phone_no"));
                            spdt.editor_client.putString("client_address",object.getString("address"));
                            spdt.editor_client.putString("client_city",object.getString("city"));
                            spdt.editor_client.putString("client_state",object.getString("state"));
                            spdt.editor_client.putString("client_zip",object.getString("zip"));
                            spdt.editor_client.putString("client_status",object.getString("status"));
                            spdt.editor_client.putString("client_role",object.getString("role"));
                            spdt.editor_client.putString("client_remember_token",object.getString("remember_token"));
                            spdt.editor_client.putString("client_created_by",object.getString("created_by"));
                            spdt.editor_client.putString("client_updated_by",object.getString("updated_by"));
                            spdt.editor_client.putString("client_created_at",object.getString("created_at"));
                            spdt.editor_client.putString("client_expires_at",object.getString("expires_at"));
                            spdt.editor_client.putString("client_updated_at",object.getString("updated_at"));
                            spdt.editor_client.putString("client_deleted_at",object.getString("deleted_at"));
                            spdt.editor_client.putString("sales_rep_id","null");
                            spdt.editor_client.putString("default_order_type","Invoice");
                            spdt.editor_client.putBoolean("signature", true);
                            spdt.editor_client.putBoolean("hide_inventory",false);
                            spdt.editor_client.putString("Access_token","Bearer "+response.getString("Access_token"));
                            spdt.editor_client.putString("last_sync_date","null");
                            spdt.editor_client.commit();
                            Intent i = new Intent(ctx,Main_Menu.class);
                            ctx.startActivity(i);
                            ((Activity) ctx).finish();
                        }
                        else if(message.equals("Unauthorized"))
                        {
                            Toast.makeText(mainActivity, "Invalid Username or password !!!", Toast.LENGTH_LONG).show();
                            mainActivity.dialog.dismiss();

                        }
                        else if(message.equals("Expired"))
                        {
                            Toast.makeText(mainActivity, "Account Expired. Please contact support.", Toast.LENGTH_SHORT).show();
                            mainActivity.dialog.dismiss();
                        }
                        else if(message.equals("LimitReached"))
                        {
                            Toast.makeText(mainActivity, "Limit Reached. Please contact Customer Support to upgrade your account.", Toast.LENGTH_LONG).show();
                            mainActivity.dialog.dismiss();

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        mainActivity.dialog.dismiss();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //Toast.makeText(mainActivity, "error"+error.toString(), Toast.LENGTH_SHORT).show();
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        mainActivity.dialog.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        mainActivity.dialog.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                        mainActivity.dialog.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        mainActivity.dialog.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                        mainActivity.dialog.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        mainActivity.dialog.dismiss();
                    }
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("username",get_email);
                    params.put("password",get_pass);
                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    headers.put("User-agent", "My useragent");
                    return headers;
                }
            };

            //req.setRetryPolicy(new DefaultRetryPolicy( 50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            AppController.getInstance().addToRequestQueue(req);

        }catch (Exception ex){
            Toast.makeText(mainActivity, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
            //pb.setVisibility(View.GONE);
            mainActivity.dialog.dismiss();
        }
        }
*/

    /*
    public void makeJsonArrayRequest_customers(final Main_Menu main_menu, final String access_token) {
        try{
            final LogoutAPI logoutAPI = new LogoutAPI(main_menu);
            //main_menu.dialog.show();
            final JSONObject jsonBody = new JSONObject();
            pref = ctx.getSharedPreferences(spdt.ClientPrefFile,MODE_PRIVATE);
            String rep_id = pref.getString("sales_rep_id",null);
            //Toast.makeText(main_menu, "Requesting all customer from server....", Toast.LENGTH_SHORT).show();
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, URL_LOCAL_JSON_ARRAY_CUST+rep_id, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response)
                {
                        try {
                            if(response.getString("message").equals("Expired"))
                            {
                                logoutAPI.user_logout();
                            }
                            else if(response.getString("message").equals("Success"))
                            {
                               // Toast.makeText(main_menu, "else ...", Toast.LENGTH_SHORT).show();
                                ArrayList<SyncCustomers> syncCustomers = new ArrayList<>();
                                JSONArray jsonArray = response.getJSONArray("all_customer_detail");
                                if (jsonArray.length() > 0) {
                                    //syncCustomers.clear();
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        SyncCustomers ob = new SyncCustomers();
                                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                                        //Toast.makeText(main_menu, "Customer "+jsonObject.getString("name")+" added.", Toast.LENGTH_SHORT).show();
                                        ob.setId(jsonObject.getString("id"));
                                        ob.setClient_id(jsonObject.getString("client_id"));
                                        ob.setContact_name(jsonObject.getString("contact_name"));
                                        ob.setTax_rule_id(jsonObject.getString("tax_rule_id"));
                                        ob.setName(jsonObject.getString("name"));
                                        ob.setEmail(jsonObject.getString("email"));
                                        ob.setAddress(jsonObject.getString("address"));
                                        ob.setCity(jsonObject.getString("city"));
                                        ob.setState(jsonObject.getString("state"));
                                        ob.setPostcode(jsonObject.getString("postcode"));
                                        ob.setContact_no(jsonObject.getString("contact_no"));
                                        ob.setStatus(jsonObject.getString("status"));
                                        ob.setIs_product_tax(jsonObject.getString("is_product_tax"));
                                        ob.setCreated_at(jsonObject.getString("created_at"));
                                        ob.setUpdated_at(jsonObject.getString("updated_at"));
                                        ob.setDeleted_at(jsonObject.getString("deleted_at"));
                                        syncCustomers.add(ob);
                                        //Toast.makeText(main_menu, ""+jsonObject.getString("name"), Toast.LENGTH_SHORT).show();
                                    }
                                    //Toast.makeText(main_menu, ""+syncCustomers.getName().get(4), Toast.LENGTH_SHORT).show();
                                    DbHelper dbHelper = new DbHelper(ctx);
                                    //Toast.makeText(main_menu, "customers = "+syncCustomers.size(), Toast.LENGTH_SHORT).show();
                                    dbHelper.syncCustomerTable(ctx, syncCustomers, sc);

                                    GetAllProductsAPI obj = new GetAllProductsAPI(ctx);
                                    obj.GetAllProducts_API(main_menu,access_token);
                                    //makeJsonArrayRequest_products(main_menu, access_token);
                                    Toast.makeText(main_menu, "Syncing...", Toast.LENGTH_LONG).show();
                                } else {
                                    //Toast.makeText(main_menu, "No new customers to add or update.", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(main_menu, "Syncing...", Toast.LENGTH_LONG).show();
                                    GetAllProductsAPI obj = new GetAllProductsAPI(ctx);
                                    obj.GetAllProducts_API(main_menu,access_token);
                                    //makeJsonArrayRequest_products(main_menu, access_token);
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            //main_menu.dialog.dismiss();
                        }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    }
                    else
                    {
                        Toast.makeText(main_menu, "makeJsonArrayRequest_customers Response error "+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Authorization",access_token);
                    return params;
                }
            };

            AppController.getInstance().addToRequestQueue(req);
            
        }catch (Exception ex)
        {
            Toast.makeText(main_menu, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //Getting all products
    public void makeJsonArrayRequest_products(final Main_Menu main_menu, final String access_token) {
        try{
            final JSONObject jsonBody = new JSONObject();
            pref = this.ctx.getSharedPreferences(spdt.ClientPrefFile,MODE_PRIVATE);
            String rep_id = pref.getString("sales_rep_id",null);
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, URL_LOCAL_JSON_ARRAY_PRODUCT+rep_id, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        ArrayList<ProductModel> productModel = new ArrayList<>();
                        JSONArray jsonArray = response.getJSONArray("all_products_detail");
                        if(jsonArray.length()>0) {
                            productModel.clear();
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                ProductModel ob = new ProductModel();
                                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                                ob.setId(jsonObject.getString("id"));
                                ob.setClient_id(jsonObject.getString("client_id"));
                                ob.setBarcodeno(jsonObject.getString("barcodeno"));
                                ob.setName(jsonObject.getString("name"));
                                ob.setPrice(jsonObject.getString("price"));
                                ob.setCost(jsonObject.getString("cost"));
                                ob.setIs_active(jsonObject.getString("is_active"));
                                ob.setIs_taxable(jsonObject.getString("is_taxable"));
                                ob.setCreated_at(jsonObject.getString("created_at"));
                                ob.setUpdated_at(jsonObject.getString("updated_at"));
                                ob.setDeleted_at(jsonObject.getString("deleted_at"));
                                ob.setQuantity(jsonObject.getString("quantity"));
                                productModel.add(ob);
                            }

                            //Toast.makeText(main_menu, ""+syncCustomers.getName().get(4), Toast.LENGTH_SHORT).show();
                            DbHelper dbHelper = new DbHelper(VolleyRequest.this.ctx);
                            dbHelper.syncProductsTable(productModel);

                            GetAllSalesRepAPI obj = new GetAllSalesRepAPI(ctx);
                            obj.GetAllSalesRep_API(main_menu,access_token);
                            //makeJsonArrayRequest_salesrepAll(main_menu,access_token);
                        }
                        else
                        {
                            //Toast.makeText(main_menu, "No new products to add or update.", Toast.LENGTH_SHORT).show();
                            GetAllSalesRepAPI obj = new GetAllSalesRepAPI(ctx);
                            obj.GetAllSalesRep_API(main_menu,access_token);
                            //makeJsonArrayRequest_salesrepAll(main_menu,access_token);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(main_menu, "makeJsonArrayRequest_products Response error "+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Authorization",access_token);
                    return params;
                }
            };

            AppController.getInstance().addToRequestQueue(req);
        }catch (Exception ex){
            Toast.makeText(this.ctx, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void makeJsonArrayRequest_taxrules(final Main_Menu main_menu, final String access_token) {
        this.ctx = main_menu;
        try{
            //pb = main_menu.findViewById(R.id.progressBar8);
            final JSONObject jsonBody = new JSONObject();
            pref = ctx.getSharedPreferences(spdt.ClientPrefFile,MODE_PRIVATE);
            editor = pref.edit();
            String rep_id = pref.getString("sales_rep_id",null);
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, URL_LOCAL_JSON_ARRAY_TAXRULES+rep_id, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        ArrayList<SyncTaxRules> syncTaxRules = new ArrayList<>();
                        //Toast.makeText(main_menu.getApplicationContext(), "getting all Taxrules  "+response.toString(), Toast.LENGTH_SHORT).show();
                        JSONArray jsonArray = response.getJSONArray("all_taxrules_detail");
                        if(jsonArray.length()>0)
                        {
                            syncTaxRules.clear();
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                SyncTaxRules ob = new SyncTaxRules();
                                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                                ob.setId(jsonObject.getString("id"));
                                ob.setClient_id(jsonObject.getString("client_id"));
                                ob.setName(jsonObject.getString("name"));
                                ob.setRate(jsonObject.getString("rate"));
                                ob.setDeleted_at(jsonObject.getString("deleted_at"));
                                syncTaxRules.add(ob);
                            }
                            //Toast.makeText(main_menu, ""+syncCustomers.getName().get(4), Toast.LENGTH_SHORT).show();
                            DbHelper dbHelper = new DbHelper(VolleyRequest.this.ctx);
                            dbHelper.syncTaxRulesTable(syncTaxRules);
                            main_menu.dialog.dismiss();
                            //Toast.makeText(main_menu, "Sync Complete.", Toast.LENGTH_SHORT).show();
                            Date currentTime = Calendar.getInstance().getTime();
                            String sync_date = dateFormat.format(currentTime);
                            editor.putString("last_sync_date",sync_date);
                            editor.commit();
                            main_menu.last_sync_date.setText(sync_date);
                        }
                        else
                        {
                            main_menu.dialog.dismiss();
                            //Toast.makeText(main_menu, "Sync Complete.", Toast.LENGTH_SHORT).show();
                            Date currentTime = Calendar.getInstance().getTime();
                            String sync_date = dateFormat.format(currentTime);
                            editor.putString("last_sync_date",sync_date);
                            editor.commit();
                            main_menu.last_sync_date.setText(sync_date);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(main_menu, "makeJsonArrayRequest_taxrules Response error "+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Authorization",access_token);
                    return params;
                }
            };

            AppController.getInstance().addToRequestQueue(req);
        }catch (Exception ex){
            Toast.makeText(ctx, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
           // main_menu.dialog.dismiss();
        }

    }

*/
  //LOGIN SALESREP//
/*
    public void makeJsonArrayRequest_salesrep(final Main_Menu main_menu, final String access_token) {
        this.ctx = main_menu;
        try{
            final JSONObject jsonBody = new JSONObject();
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, URL_LOCAL_JSON_ARRAY_ALL_SALESREP, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        ArrayList<SyncSalesRep> syncSalesReps = new ArrayList<>();
                            //Toast.makeText(main_menu.getApplicationContext(), "getting all Sales Rep", Toast.LENGTH_SHORT).show();
                            JSONArray jsonArray = response.getJSONArray("all_salesrep_detail");
                            syncSalesReps.clear();
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                SyncSalesRep ob = new SyncSalesRep();
                                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                                ob.setId(jsonObject.getString("id"));
                                ob.setClient_id(jsonObject.getString("client_id"));
                                ob.setInitial(jsonObject.getString("initial"));
                                ob.setRegion(jsonObject.getString("region"));
                                ob.setIs_active(jsonObject.getString("is_active"));
                                syncSalesReps.add(ob);
                            }
                            //Toast.makeText(main_menu, ""+syncCustomers.getName().get(4), Toast.LENGTH_SHORT).show();
                            DbHelper dbHelper = new DbHelper(ctx);
                            dbHelper.syncSalesRepTable(main_menu,syncSalesReps);
                            //main_menu.dialog.dismiss();
                        if(spdt.pref_client.getString("sales_rep_id",null).equals("null"))
                        {
                            main_menu.setSalesRep();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(main_menu, "makeJsonArrayRequest_salesrep Response error "+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Authorization",access_token);
                    return params;
                }
            };
            AppController.getInstance().addToRequestQueue(req);
        }catch (Exception ex){
            Toast.makeText(main_menu, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
*/
  //UPDATE ALL SALESREP//
/*
    public void makeJsonArrayRequest_salesrepAll(final Main_Menu main_menu, final String access_token) {
        try{
            final JSONObject jsonBody = new JSONObject();
            pref = this.ctx.getSharedPreferences(spdt.ClientPrefFile,MODE_PRIVATE);
            String rep_id = pref.getString("sales_rep_id",null);
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, URL_LOCAL_JSON_ARRAY_SALESREP+rep_id, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        ArrayList<SyncSalesRep> syncSalesReps = new ArrayList<>();
                        JSONArray jsonArray = response.getJSONArray("all_salesrep_detail");
                        if(jsonArray.length()>0) {
                            syncSalesReps.clear();
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                SyncSalesRep ob = new SyncSalesRep();
                                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                                ob.setId(jsonObject.getString("id"));
                                ob.setClient_id(jsonObject.getString("client_id"));
                                ob.setInitial(jsonObject.getString("initial"));
                                ob.setRegion(jsonObject.getString("region"));
                                ob.setIs_active(jsonObject.getString("is_active"));
                                syncSalesReps.add(ob);
                            }
                            //Toast.makeText(main_menu, ""+syncCustomers.getName().get(4), Toast.LENGTH_SHORT).show();
                            DbHelper dbHelper = new DbHelper(VolleyRequest.this.ctx);
                            dbHelper.syncSalesRepTable(main_menu,syncSalesReps);
                            makeJsonArrayRequest_taxrules(main_menu,access_token);
                        }
                        else
                        {
                            //Toast.makeText(ctx, "No new Sales Rep to add or update.", Toast.LENGTH_SHORT).show();
                            makeJsonArrayRequest_taxrules(main_menu,access_token);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if(pref.getString("sales_rep_id",null).equals("null"))
                    {
                        Main_Menu main_menu = new Main_Menu();
                        main_menu.setSalesRep();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(main_menu, "makeJsonArrayRequest_salesrepAll Response error "+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Authorization",access_token);
                    return params;
                }
            };
            AppController.getInstance().addToRequestQueue(req);
        }catch (Exception ex){
            Toast.makeText(ctx, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
*/

  //Sending new customers
/*
    public void makeJsonArrayRequest_sendCustomers(final Main_Menu main_menu, final String access_token, final ArrayList<SyncCustomers> syncCustomers) {
        try {
            main_menu.dialog.show();
            //            //Toast.makeText(main_menu, "sending new customers", Toast.LENGTH_SHORT).show();

            final JSONObject jsonBody = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for(int i=0;i<syncCustomers.size();i++)
            {
                JSONObject customers = new JSONObject();
                customers.put("id",syncCustomers.get(0).getId());
                customers.put("tax_rule_id",syncCustomers.get(0).getTax_rule_id());
                customers.put("name",syncCustomers.get(0).getName());
                customers.put("contact_name", syncCustomers.get(0).getContact_name());
                customers.put("email", syncCustomers.get(0).getEmail());
                customers.put("address", syncCustomers.get(0).getAddress());
                customers.put("city", syncCustomers.get(0).getCity());
                customers.put("state", syncCustomers.get(0).getState());
                customers.put("postcode", syncCustomers.get(0).getPostcode());
                customers.put("contact_no", syncCustomers.get(0).getContact_no());
                customers.put("status", syncCustomers.get(0).getStatus());
                customers.put("is_product_tax", syncCustomers.get(0).getIs_product_tax());
                customers.put("created_at", syncCustomers.get(0).getCreated_at());
                jsonArray.put(i,customers);
                Toast.makeText(main_menu, "Adding new Customer....", Toast.LENGTH_SHORT).show();
            }
            jsonBody.put("customers",jsonArray);
            //Toast.makeText(main_menu, "customers = "+jsonBody.toString(), Toast.LENGTH_SHORT).show();

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,URL_LOCAL_JSON_ARRAY_SENDNEWCUSTOMERS,jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                        try
                        {
                            if(response.has("Message"))
                            {
                                String msg = response.getString("Message");
                                if(msg.equals("LimitReached"))
                                Toast.makeText(main_menu, "Max Customer Limit reached. Contact support team.", Toast.LENGTH_SHORT).show();
                                //Write a code to delete customers with no server id and before that delete all orders from order as well as order details table
                                //Ask for confirmation to delete all customers and oreders recently created?

                            }
                            if (response.has("Server_id"))
                            {
                                JSONArray jsonArray1 = response.getJSONArray("Server_id");
                                Toast.makeText(main_menu, "setting server id of customer to local db.", Toast.LENGTH_SHORT).show();
//                                JSONArray jsonArray1 = response.getJSONArray("Server_id");
                                Toast.makeText(ctx, "jsonArray1 = " + jsonArray1.length(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(main_menu, "Hello", Toast.LENGTH_SHORT).show();
                                for (int i = 0; i < jsonArray1.length(); i++) {
                                    JSONObject json = jsonArray1.getJSONObject(i);
                                    Iterator<String> keys = json.keys();
                                    while (keys.hasNext()) {
                                        String key = keys.next();
                                        String oldValue = key;
                                        String newValue = json.get(key).toString();
                                        Toast.makeText(ctx, "old+new = " + oldValue + " " + newValue, Toast.LENGTH_SHORT).show();
                                        DbHelper dbHelper = new DbHelper(ctx);
                                        dbHelper.updateServer_Id_InCustomers(ctx, oldValue, newValue);
                                    }
                                }
                                //================  BELOW CODE SEND ALL ORDERS AND ORDER_DETAILS TO SERVER  ============================================
                                DbHelper dbHelper = new DbHelper(ctx);
                                ArrayList<SyncOrders> syncOrders = dbHelper.getAllOrdersForAPI();
                                //Toast.makeText(ctx, "Total orders = " + syncOrders.size(), Toast.LENGTH_SHORT).show();
                                //================== THIS METHOD IS CALLED WHEN WE ADD NEW ORDERS TO SERVER ========================================
                                if (syncOrders.size() >= 1) {
                                    makeJsonArrayRequest_sendOrdersAndOrderDetails(main_menu, access_token, syncOrders);
                                } else {
                                    main_menu.dialog.dismiss();
                                }
                            }
                        } catch (JSONException e) {
                            Toast.makeText(main_menu, "VolleyRequest line 677 : "+e.getMessage(), Toast.LENGTH_SHORT).show();
                           // main_menu.dialog.dismiss();
                        }
                    }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                        main_menu.dialog.dismiss();
                    }
                    else
                    {
                        Toast.makeText(ctx, "send new customer response error :"+error.getMessage(), Toast.LENGTH_LONG).show();
                        main_menu.dialog.dismiss();
                    }
                }
            })
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> headers = new HashMap<String, String>();
                    headers.put("Authorization",access_token);
                    headers.put("Content-Type", "application/json");
                    return headers;
                }
            };
            //AppController.getInstance().addToRequestQueue(req);

            int socketTimeout = 15000*syncCustomers.size();
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            req.setRetryPolicy(policy);
            AppController.getInstance().addToRequestQueue(req);
            //requestQueue.add(req);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(main_menu, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
//            main_menu.dialog.dismiss();
        }
    }
*/

  //Sending order and order details
  //This function is called inside makeJsonArrayRequest_sendCustomers
/*
    public void makeJsonArrayRequest_sendOrdersAndOrderDetails(final Main_Menu main_menu, final String access_token, ArrayList<SyncOrders> syncOrders) {
        try {
            final LogoutAPI logoutAPI = new LogoutAPI(main_menu);
            //Toast.makeText(main_menu, "sending new orders", Toast.LENGTH_SHORT).show();
            final JSONObject jsonBody = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            pref = ctx.getSharedPreferences(spdt.ClientPrefFile,MODE_PRIVATE);
            editor = pref.edit();

            for(int i=0;i<syncOrders.size();i++)
            {
                //=================getting jpg file for signature============================
                GetSignatureFile getSignatureFile = new GetSignatureFile(ctx);
                String imageString = getSignatureFile.getStringImage(syncOrders.get(i).getInvoice_no(),syncOrders.get(i).getOrder_type());
                //============================================================================
                JSONObject orders = new JSONObject();
                orders.put("order_id",syncOrders.get(i).getInvoice_no()); // sending order_id of sql database
//                Toast.makeText(main_menu, "oid=  "+syncOrders.get(i).getId(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(main_menu, "invno=  "+syncOrders.get(i).getInvoice_no(), Toast.LENGTH_SHORT).show();
                orders.put("customer_id",syncOrders.get(i).getServer_id());//send customer_id = server_id  (server_id is id in customer table on server)
                orders.put("sale_rep_id",syncOrders.get(i).getSales_rep_id());
                orders.put("tax_rule_id",syncOrders.get(i).getTax_rule_id());
                //orders.put("invoice_no", syncOrders.get(i).getInvoice_no());
                orders.put("order_type", syncOrders.get(i).getOrder_type());
                orders.put("notes", syncOrders.get(i).getNotes());
                orders.put("signature",imageString);
                //orders.put("signature","null");
                orders.put("created_at", syncOrders.get(i).getCreated_at());

                ArrayList<SyncOrderDetails> syncOrderDetails;
                String order_id = syncOrders.get(i).getId();
                //Toast.makeText(main_menu, "order_id = "+order_id, Toast.LENGTH_SHORT).show();
                DbHelper dbHelper = new DbHelper(ctx);
                syncOrderDetails = dbHelper.getAllOrderDetailsForAPI(order_id);
                JSONArray jsonArray1 = new JSONArray();
                //Toast.makeText(main_menu, "product_id arrya size = "+arr_obj_syncOrderDetails.get(0).getProduct_id().size(), Toast.LENGTH_SHORT).show();
                for(int j=0;j<syncOrderDetails.size();j++)
                {
                    JSONObject orders_detail = new JSONObject();
                    orders_detail.put("product_id",syncOrderDetails.get(j).getProduct_id());
                    orders_detail.put("quantity",syncOrderDetails.get(j).getQuantity());
                    orders_detail.put("price",syncOrderDetails.get(j).getPrice());
                    jsonArray1.put(j,orders_detail);
                }
                orders.put("order_detail",jsonArray1);
                jsonArray.put(i,orders);
            }
            jsonBody.put("orders",jsonArray);
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,URL_LOCAL_JSON_ARRAY_SENDNEWORDERS,jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //Toast.makeText(ctx, "Response for orders recieved"+response.toString(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(ctx, "success : "+response.toString(), Toast.LENGTH_SHORT).show();
                    try
                    {
                        if(response.getString("message").equals("Expired")) {
                            logoutAPI.user_logout();
                        }
                        else {
                            if (response.getString("message").equals("Success")) {
                                //=================Deleting Signature ==========================================
                                GetSignatureFile getSignatureFile = new GetSignatureFile(ctx);
                                getSignatureFile.deleteSignatureFile();
                                //==============================================================================
                                DbHelper dbHelper = new DbHelper(ctx);
                                dbHelper.getWritableDatabase().execSQL("drop table orders");
                                dbHelper.getWritableDatabase().execSQL("drop table order_details");
                                AllTableNames tn = new AllTableNames();
                                dbHelper.getWritableDatabase().execSQL(tn.create_orders_table);
                                dbHelper.getWritableDatabase().execSQL(tn.create_orders_details_table);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String sync_date = dateFormat.format(date);
                    editor.putString("last_sync_date",sync_date);
                    editor.commit();
                    main_menu.last_sync_date.setText(sync_date);
                    main_menu.dialog.dismiss();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    }
                    error.printStackTrace();
                    //Toast.makeText(ctx, "send order error dgdfg :"+error.getMessage()+"  "+error.networkResponse.statusCode, Toast.LENGTH_LONG).show();
                }

            })
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> headers = new HashMap<String, String>();
                    headers.put("Authorization",access_token);
                    headers.put("Content-Type", "application/json");
                    return headers;
                }
            };

            int socketTimeout = 15000*syncOrders.size();
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            req.setRetryPolicy(policy);
            AppController.getInstance().addToRequestQueue(req);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(ctx, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            //main_menu.dialog.dismiss();
        }
    }
*/


/*
    public void makeJsonArrayRequest_sendSalesRepToServerForFirstTime(final Main_Menu main_menu, String sales_rep_id, final String access_token, String imei) {

        final JSONObject jsonBody = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        //Toast.makeText(ctx, " "+jsonBody.toString(), Toast.LENGTH_LONG).show();
        //Toast.makeText(main_menu, "new imei = "+imei, Toast.LENGTH_SHORT).show();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,URL_LOCAL_JSON_ARRAY_NEWLOGIN+sales_rep_id+"-"+imei,jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                //Toast.makeText(main_menu, ""+response.toString(), Toast.LENGTH_SHORT).show();
                try {
                    pref = main_menu.getSharedPreferences(spdt.ClientPrefFile,MODE_PRIVATE);
                    editor = pref.edit();

                    String invoice_no = response.getString("LastInvoiceno");
                    String estimate_no = response.getString("LastEstimateno");
                    String sales_orderno = response.getString("LastSalesorderno");
                    //Toast.makeText(main_menu, ""+invoice_no+estimate_no+sales_orderno, Toast.LENGTH_SHORT).show();
                    if(invoice_no.equals("")) {
                        editor.putString("client_invoice_no","0");
                    } else {
                        editor.putString("client_invoice_no",invoice_no);
                    }

                    if(estimate_no.equals("")) {
                        editor.putString("client_estimate_no","0");
                    }else{
                        editor.putString("client_estimate_no",estimate_no);
                    }

                    if(sales_orderno.equals("")) {
                        editor.putString("client_sales_order_no","0");
                    }else{
                        editor.putString("client_sales_order_no",sales_orderno);
                    }

                    editor.commit();
                    main_menu.dialog.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                if (error instanceof NetworkError) {
                    Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                } else if (error instanceof ServerError) {
                    Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ctx, "Error :New Login API"+error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Authorization",access_token);
                headers.put("Content-Type", "application/json");
                return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(req);

    }
*/

/*
    public ArrayList<Reports_model> makeJsonArrayRequest_reports(final Daily_Reports_Activity daily_reports_activity, final String report_type)
    {
        this.ctx = daily_reports_activity;
        final ArrayList<Reports_model> reportsModel = new ArrayList<>();
        try {
            final HashMap<String, String> params = new HashMap<String, String>();
            RequestQueue queue = Volley.newRequestQueue(daily_reports_activity);
            params.put("type", report_type);

            final JSONObject jsonBody = new JSONObject();
            jsonBody.put("type", report_type);
            pref = daily_reports_activity.getSharedPreferences(spdt.ClientPrefFile, MODE_PRIVATE);
            String sales_rep_id = pref.getString("sales_rep_id", null);
            final String access_token = pref.getString("Access_token",null);
            //Toast.makeText(daily_reports_activity, "jsobonbody = "+report_type, Toast.LENGTH_SHORT).show();

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, URL_LOCAL_JSON_ARRAY_REPORTS + sales_rep_id, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //Toast.makeText(ctx, ""+response.toString(), Toast.LENGTH_SHORT).show();

                    try {
                        JSONArray jsonArray = response.getJSONArray("Reportdata");
                        if (jsonArray.length() > 0)
                        {
                            //syncCustomers.clear();
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                //Toast.makeText(daily_reports_activity, ""+jsonObject.getString("name"), Toast.LENGTH_SHORT).show();
                                    Reports_model ob = new Reports_model();
                                    ob.setInvoice_no(jsonObject.getString("invoice_no"));
                                    ob.setName(jsonObject.getString("name"));
                                    ob.setQty(jsonObject.getString("totalqty"));
                                    ob.setTax(jsonObject.getString("totaltax"));
                                    ob.setTotal(jsonObject.getString("total"));
                                    reportsModel.add(ob);
                            }
                            daily_reports_activity.setReportData(reportsModel);
                        }
                        else
                        {
                            Toast.makeText(daily_reports_activity, "No Orders.", Toast.LENGTH_SHORT).show();
                            daily_reports_activity.dialog.dismiss();
                        }

                    }catch (Exception ex)
                    {
                        Toast.makeText(daily_reports_activity, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(ctx, "makeJsonArrayRequest_reports = "+error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authorization", access_token);
                    return headers;
                }
            };
            AppController.getInstance().addToRequestQueue(req);

        } catch (Exception ex) {

        }
        daily_reports_activity.ob = reportsModel;
        return reportsModel;
    }
*/


    /*
    public ArrayList<Reports_model> makeJsonArrayRequest_reports_custom(final Daily_Reports_Activity daily_reports_activity, String report_type, String start_date, String end_date)
    {

        this.ctx = daily_reports_activity;
        final ArrayList<Reports_model> reportsModel = new ArrayList<>();
        try {
            final HashMap<String, String> params = new HashMap<String, String>();
            RequestQueue queue = Volley.newRequestQueue(daily_reports_activity);
            params.put("type", report_type);
            params.put("fromdate", start_date);
            params.put("todate", end_date);
            final JSONObject jsonBody = new JSONObject();
            jsonBody.put("type", report_type);
            jsonBody.put("fromdate", start_date);
            jsonBody.put("todate", end_date);
            pref = daily_reports_activity.getSharedPreferences(spdt.ClientPrefFile, MODE_PRIVATE);
            String sales_rep_id = pref.getString("sales_rep_id", null);
            final String access_token = pref.getString("Access_token",null);
//            Toast.makeText(daily_reports_activity, "jsobonbody = "+report_type, Toast.LENGTH_SHORT).show();

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, URL_LOCAL_JSON_ARRAY_REPORTS + sales_rep_id, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //Toast.makeText(ctx, ""+response.toString(), Toast.LENGTH_SHORT).show();

                    try {
                        JSONArray jsonArray = response.getJSONArray("Reportdata");
                        if (jsonArray.length() > 0)
                        {
                            //syncCustomers.clear();
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                //Toast.makeText(daily_reports_activity, ""+jsonObject.getString("name"), Toast.LENGTH_SHORT).show();
                                Reports_model ob = new Reports_model();
                                ob.setInvoice_no(jsonObject.getString("invoice_no"));
                                ob.setName(jsonObject.getString("name"));
                                ob.setQty(jsonObject.getString("totalqty"));
                                ob.setTax(jsonObject.getString("totaltax"));
                                ob.setTotal(jsonObject.getString("total"));
                                reportsModel.add(ob);
                            }
                            daily_reports_activity.setReportData(reportsModel);
                        }
                        else
                        {
                            Toast.makeText(daily_reports_activity, "No Orders.", Toast.LENGTH_SHORT).show();
                        }

                    }catch (Exception ex)
                    {
                        Toast.makeText(daily_reports_activity, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(ctx, "makeJsonArrayRequest_reports_custom = "+error.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authorization", access_token);
                    return headers;
                }
            };
            AppController.getInstance().addToRequestQueue(req);

        } catch (Exception ex) {

        }
        daily_reports_activity.ob = reportsModel;
        return reportsModel;
    }
    */


  //This request will send logout is clicked in the application.
  //This will also send sales rep id to reset imei in the client_devices_lisences table in db
    /*
    public void makeJsonArrayRequest_logout(final Main_Menu main_menu, final String sales_rep_ids, final String Access_token) {
        try{

            this.ctx = main_menu;
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL_LOCAL_JSON_ARRAY_LOGOUT+sales_rep_ids, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try
                    {
                        String messaage = response.getString("message");
                        switch (messaage)
                        {
                            case "Success" :
                                Toast.makeText(ctx, "Logged out Successfully.", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }catch (Exception ex)
                    {
                        Toast.makeText(ctx, "VolleyRequest : line 1066 :  "+ex.getMessage(), Toast.LENGTH_SHORT).show();
                        ex.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx,"The server could not be found. Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx,"AuthFailureError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx,"Parsing error! Please try again after some time!!",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx,"NoConnectionError",Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx,"Connection TimeOut! Please check your internet connection.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(ctx, "makeJsonArrayRequest_logout = "+error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", Access_token);
                    return headers;

                }
            };
            //int socketTimeout = 15000*syncCustomers.size();
            AppController.getInstance().addToRequestQueue(request);

        }catch (Exception ex)  {
            Toast.makeText(main_menu, "VolleyRequest-line 1107 = "+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    //end region
    */


}
