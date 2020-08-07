package com.example.admin.warehousemobileinvoicingsystem;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import com.example.admin.warehousemobileinvoicingsystem.API.LoginAPI;

public class ApiUrl {

    //Ketan

    public Context ctx;
    SharedPreferenceForDataTransfer spdt;
    public static  String URL_LOCAL_JSON_ARRAY_LOGIN ;
    public static  String URL_LOCAL_JSON_ARRAY_CUST ;// cust-sales_rep_id
    public static  String URL_LOCAL_JSON_ARRAY_SUPPLIERS ;// cust-sales_rep_id
    public static  String URL_LOCAL_JSON_ARRAY_PRODUCT ; // getproduct-sales_rep_id
    public static  String URL_LOCAL_JSON_ARRAY_TAXRULES ; // gettaxrules-sales_rep_id
    public static  String URL_LOCAL_JSON_ARRAY_SALESREP ;
    public static  String URL_LOCAL_JSON_ARRAY_CATEGORIES ;
    public static  String URL_LOCAL_JSON_ARRAY_ALL_SALESREP ;
    public static  String URL_LOCAL_JSON_ARRAY_SENDNEWCUSTOMERS ;
    public static  String URL_LOCAL_JSON_ARRAY_SENDNEWORDERS ;
    public static  String URL_LOCAL_JSON_ARRAY_NEWLOGIN ;
    public static  String URL_LOCAL_JSON_ARRAY_REPORTS ;
    public static String URL_LOCAL_JSON_ARRAY_LOGOUT ;
    public static String URL_LOCAL_JSON_ARRAY_LOGIN_SETTINGS ;
    public static String URL_LOCAL_JSON_ARRAY_GETCUSTOMERCOUNT ;

    public ApiUrl()
    {

    }

    public ApiUrl(Context context) {
        this.ctx = context;
        this.spdt = new SharedPreferenceForDataTransfer(ctx);
        if (spdt.pref_data_transfer.getString("switch_server",null).equals("true")){

            URL_LOCAL_JSON_ARRAY_LOGIN = "https://dashboard.invoit.in/api/login";
            URL_LOCAL_JSON_ARRAY_CUST = "https://dashboard.invoit.in/api/cust-";  // cust-sales_rep_id
            URL_LOCAL_JSON_ARRAY_PRODUCT = "https://dashboard.invoit.in/api/getproduct-"; // getproduct-sales_rep_id
            URL_LOCAL_JSON_ARRAY_TAXRULES = "https://dashboard.invoit.in/api/gettaxrules-"; // gettaxrules-sales_rep_id
            URL_LOCAL_JSON_ARRAY_SALESREP = "https://dashboard.invoit.in/api/getsalesrep-";
            URL_LOCAL_JSON_ARRAY_CATEGORIES = "https://dashboard.invoit.in/api/getCategories-";
            URL_LOCAL_JSON_ARRAY_ALL_SALESREP = "https://dashboard.invoit.in/api/getsalesrep";
            URL_LOCAL_JSON_ARRAY_SENDNEWCUSTOMERS = "https://dashboard.invoit.in/api/newcustomer";
            URL_LOCAL_JSON_ARRAY_SENDNEWORDERS = "https://dashboard.invoit.in/api/neworder";
            URL_LOCAL_JSON_ARRAY_NEWLOGIN = "https://dashboard.invoit.in/api/newlogin-";
            URL_LOCAL_JSON_ARRAY_REPORTS = "https://dashboard.invoit.in/api/reports-";
            URL_LOCAL_JSON_ARRAY_LOGOUT = "https://dashboard.invoit.in/api/logout-";
            URL_LOCAL_JSON_ARRAY_LOGIN_SETTINGS = "https://dashboard.invoit.in/api/login_settings";
            URL_LOCAL_JSON_ARRAY_SUPPLIERS = "https://dashboard.invoit.in/api/getSuppliers-";
            URL_LOCAL_JSON_ARRAY_GETCUSTOMERCOUNT = "https://dashboard.invoit.in/api/getCustomerCount";
        }
        else if(spdt.pref_data_transfer.getString("switch_server",null).equals("false")){

            URL_LOCAL_JSON_ARRAY_LOGIN = "http://192.168.1.2:8000/api/login";
            URL_LOCAL_JSON_ARRAY_NEWLOGIN = "http://192.168.1.2:8000/api/newlogin-";
            URL_LOCAL_JSON_ARRAY_CUST = "http://192.168.1.2:8000/api/cust-";  // cust-sales_rep_id
            URL_LOCAL_JSON_ARRAY_SUPPLIERS = "http://192.168.1.2:8000/api/getSuppliers-"; //getSuppliers-sales_rep_id
            URL_LOCAL_JSON_ARRAY_PRODUCT = "http://192.168.1.2:8000/api/getproduct-"; // getproduct-sales_rep_id
            URL_LOCAL_JSON_ARRAY_CATEGORIES = "http://192.168.1.2:8000/api/getCategories-";
            URL_LOCAL_JSON_ARRAY_TAXRULES = "http://192.168.1.2:8000/api/gettaxrules-"; // gettaxrules-sales_rep_id
            URL_LOCAL_JSON_ARRAY_SALESREP = "http://192.168.1.2:8000/api/getsalesrep-";
            URL_LOCAL_JSON_ARRAY_ALL_SALESREP = "http://192.168.1.2:8000/api/getsalesrep";
            URL_LOCAL_JSON_ARRAY_SENDNEWCUSTOMERS = "http://192.168.1.2:8000/api/newcustomer";
            URL_LOCAL_JSON_ARRAY_SENDNEWORDERS = "http://192.168.1.2:8000/api/neworder";
            URL_LOCAL_JSON_ARRAY_REPORTS = "http://192.168.1.2:8000/api/reports-";
            URL_LOCAL_JSON_ARRAY_LOGOUT = "http://192.168.1.2:8000/api/logout-";
            URL_LOCAL_JSON_ARRAY_LOGIN_SETTINGS = "http://192.168.1.2:8000/api/login_settings";
            URL_LOCAL_JSON_ARRAY_GETCUSTOMERCOUNT = "http://192.168.1.2:8000/api/getCustomerCount";

        }
    }



}
