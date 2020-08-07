package com.example.admin.warehousemobileinvoicingsystem.API;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.warehousemobileinvoicingsystem.*;
import com.example.admin.warehousemobileinvoicingsystem.AsynApiRequest.AsyncSendOrderAndOrderDetails;
import com.example.admin.warehousemobileinvoicingsystem.Sync.*;
import com.google.gson.Gson;

import org.json.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SendOrdersAndOrderDetailsAPI {

    Context ctx;
    SharedPreferenceForDataTransfer spdt;
    //ProgressBarHandler pb;
    ApiUrl apiUrl;
    DateFormat dateFormat;
    Date date;

    public SendOrdersAndOrderDetailsAPI(Context ctx) {
        this.ctx = ctx;
        this.apiUrl = new ApiUrl(ctx);
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = new Date();
    }

    //THIS METHOD IS CALLED WHEN WE ADD NEW CUSTOMERS AND ADD NEW ORDERS TO SEND ONLY NEW CUSTOMER AND ORDERS TO SERVER
    //Sending order and order details
    //This function is called inside NewCustomerAPI
    public void sendOrdersAndOrderDetails_API(ArrayList<SyncOrders> syncOrders, final ProgressBarHandler pb) {

        try {
            final JSONObject jsonBody = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < syncOrders.size(); i++) {
                //=================getting jpg file for signature============================
                GetSignatureFile getSignatureFile = new GetSignatureFile(ctx);
                String imageString = getSignatureFile.getStringImage(syncOrders.get(i).getInvoice_no(), syncOrders.get(i).getOrder_type());
                //============================================================================

                JSONObject orders = new JSONObject();
                orders.put("customer_id", syncOrders.get(i).getServer_id());    //send customer_id = server_id  (server_id is id in customer table on server)
                orders.put("sale_rep_id", syncOrders.get(i).getSales_rep_id());
                orders.put("sales_rep_name", syncOrders.get(i).getSales_rep_name());
                orders.put("is_cust_taxable", syncOrders.get(i).getIs_cust_taxable());

                if(syncOrders.get(i).getOrder_type().equals("Invoice")){ orders.put("order_type", "1"); }
                else if(syncOrders.get(i).getOrder_type().equals("Sales Order")){ orders.put("order_type", "2"); }
                else if(syncOrders.get(i).getOrder_type().equals("Estimate")){ orders.put("order_type", "3"); }

                orders.put("notes", syncOrders.get(i).getNotes());
                orders.put("signature", imageString);
                orders.put("created_at", syncOrders.get(i).getCreated_at());

                ArrayList<SyncOrderDetails> syncOrderDetails;
                String order_id = syncOrders.get(i).getId();
                DbHelper dbHelper = new DbHelper(ctx);
                syncOrderDetails = dbHelper.getAllOrderDetailsForAPI(order_id);
                JSONArray jsonArray1 = new JSONArray();
                for (int j = 0; j < syncOrderDetails.size(); j++) {
                    JSONObject orders_detail = new JSONObject();
                    orders_detail.put("product_id", syncOrderDetails.get(j).getProduct_id());
                    orders_detail.put("quantity", syncOrderDetails.get(j).getQuantity());
                    orders_detail.put("price", syncOrderDetails.get(j).getPrice());
                    orders_detail.put("discount_type", syncOrderDetails.get(j).getDiscount_type());
                    orders_detail.put("discount_rate", syncOrderDetails.get(j).getDiscount_rate());
                    orders_detail.put("is_taxable", syncOrderDetails.get(j).getIs_taxable());
                    orders_detail.put("tax_rate", syncOrderDetails.get(j).getTax_rate());
                    jsonArray1.put(j, orders_detail);
                }
                orders.put("order_detail", jsonArray1);
                jsonArray.put(i, orders);
            }
            jsonBody.put("orders", jsonArray);
            //Toast.makeText(ctx, ""+jsonBody.toString(), Toast.LENGTH_SHORT).show();
            //Toast.makeText(ctx, "Access token : "+spdt.pref_client.getString("Access_token",null), Toast.LENGTH_SHORT).show();
            Log.d("tagg", jsonBody.toString(2));

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, apiUrl.URL_LOCAL_JSON_ARRAY_SENDNEWORDERS, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
//                    Toast.makeText(ctx, "msgsss = "+response, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(ctx, "syncorder response received" , Toast.LENGTH_SHORT).show();
                    new AsyncSendOrderAndOrderDetails(ctx, response, pb).execute();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    if (error instanceof NetworkError) {
                        Toast.makeText(ctx, "SendOrdersAndOrderDetailsAPI : Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                        //pb.dismiss();
                    } else if (error instanceof ServerError) {
                        Toast.makeText(ctx, "SendOrdersAndOrderDetailsAPI : The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                        // pb.dismiss();
                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(ctx, "SendOrdersAndOrderDetailsAPI : AuthFailureError", Toast.LENGTH_LONG).show();
                        //  pb.dismiss();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(ctx, "SendOrdersAndOrderDetailsAPI : Parsing error! Please try again after some time!!", Toast.LENGTH_LONG).show();
                        // pb.dismiss();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(ctx, "SendOrdersAndOrderDetailsAPI : NoConnectionError", Toast.LENGTH_LONG).show();
                        // pb.dismiss();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(ctx, "SendOrdersAndOrderDetailsAPI : Connection TimeOut! Please check your internet connection.", Toast.LENGTH_LONG).show();
                        // pb.dismiss();
                    } else {
                        //  pb.dismiss();
                        Toast.makeText(ctx, "SendOrdersAndOrderDetailsAPI : " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<String, String>();
                    headers.put("Authorization", spdt.pref_client.getString("Access_token", null));
                    headers.put("Content-Type", "application/json");
                    return headers;
                }
            };
            req.setShouldCache(false);  //  important! this will not cache request on the phone
            int socketTimeout = 15000 * syncOrders.size();

            //RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            // THIS WILL PREVENT VOLLEY FROM SENDING REQUEST 2 TIMES TO SERVER IF NOT REMOVE BELOW AND ENABLE ABOVE CODE
            RetryPolicy policy = new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            req.setRetryPolicy(policy);
            AppController.getInstance().addToRequestQueue(req);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(ctx, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            // pb.dismiss();
        }
    }


}
