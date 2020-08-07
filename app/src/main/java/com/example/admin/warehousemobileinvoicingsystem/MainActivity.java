package com.example.admin.warehousemobileinvoicingsystem;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.admin.warehousemobileinvoicingsystem.API.LoginAPI;
import com.example.admin.warehousemobileinvoicingsystem.Customers.IMEIUtil;
import com.example.admin.warehousemobileinvoicingsystem.Website_Activity.Forget_Password;
import com.example.admin.warehousemobileinvoicingsystem.Website_Activity.Signup_registration;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.Manifest.permission.READ_PHONE_STATE;

public class MainActivity extends AppCompatActivity {

  //region ===============GLOBAL DECLARATION SECTION =============================================

  SharedPreferenceForDataTransfer spdt;
  TextInputEditText ed_email, ed_password;
  TextView tv_signup, tv_forgotpassword, invalid_pass_user;
  AppCompatButton btn_login;
  private static String get_email, get_pass;
  RelativeLayout r_layout;
  ProgressBarHandler pb;
  private int REQUEST_PERMISSION_PHONE_STATE = 1;
  GoogleSignInClient mGoogleSignInClient;
  int RC_SIGN_IN = 0;
  String imei = "";
  private GoogleApiClient googleApiClient;
  //endregion
  Switch serverurl;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    bindAllControls();




    getWindow().setBackgroundDrawableResource(R.drawable.wallpapweformenu3);
    spdt = new SharedPreferenceForDataTransfer(this);
    this.pb = new ProgressBarHandler(this);     // object displays progressbar pb.show() / pb.dismiss()

    spdt.editor_data_tranfer.putString("switch_server", "false");
    spdt.editor_data_tranfer.commit();

    serverurl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
          // The toggle is enabled
          spdt.editor_data_tranfer.putString("switch_server", "true");
          spdt.editor_data_tranfer.commit();
        }

      }
    });


//    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

    // Build a GoogleSignInClient with the options specified by gso.
//    mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    // Set the dimensions of the sign-in button.
//    SignInButton signInButton = findViewById(R.id.sign_in_button);
//    signInButton.setSize(SignInButton.SIZE_STANDARD);
//    customizeGooglePlusButton(signInButton);
//
//    signInButton.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        switch (v.getId()) {
//          case R.id.sign_in_button:
//            signIn();
//            break;
//          // ...
//        }
//      }
//    });

    r_layout = findViewById(R.id.relativelayout_full_screen_progressbar);
    if (!TextUtils.isEmpty(spdt.pref_client.getString("client_email", null))) {
      Intent intent = new Intent(MainActivity.this, Main_Menu.class);
      startActivity(intent);
      finish();
    }

    tv_signup.setMovementMethod(LinkMovementMethod.getInstance());
    tv_signup.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        tv_signup.setLinkTextColor(Color.BLUE);
        Intent intent = new Intent(MainActivity.this, Signup_registration.class);
//                intent.setData(Uri.parse("http://wsapp.webbakerlab.com/register"));
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
      }
    });

    tv_forgotpassword.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, Forget_Password.class);
                /*
                tv_forgotpassword.setLinkTextColor(Color.BLUE);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://wsapp.webbakerlab.com/log"));*/
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

      }
    });


    btn_login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //show dialog when login button is clicked.
        validateUsernamePassword();

      }

      private void validateUsernamePassword() {
        if (TextUtils.isEmpty(ed_email.getText().toString())) {
          ed_email.selectAll();
          ed_email.requestFocus();
          ed_email.setError(getString(R.string.email_field_required));
          return;
        } else if (TextUtils.isEmpty(ed_password.getText().toString())) {
          ed_password.selectAll();
          ed_password.requestFocus();
          ed_password.setError(getString(R.string.password_field_required));
          return;
        } else {
          get_email = ed_email.getText().toString().trim();
          get_pass = ed_password.getText().toString().trim();
          boolean check = isEmailValid(get_email);
          if (check == true) {
            // This Request will send email and password to server for verification.
            pb.pb_load_tv.setText("Verifying...");
            pb.show();
            LoginAPI obj = new LoginAPI(MainActivity.this, invalid_pass_user);
            obj.Login_API(get_email.trim(), get_pass.trim(), spdt, pb);
          } else {
            Toast.makeText(MainActivity.this, "Enter valid email address", Toast.LENGTH_SHORT).show();
            pb.dismiss();
          }

        }
      }

    });

  }


  public boolean isEmailValid(String email) {
    String regExpn =
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

    CharSequence inputStr = email;

    Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(inputStr);

    if (matcher.matches())
      return true;
    else
      return false;
  }

  public static void customizeGooglePlusButton(SignInButton signInButton) {
    for (int i = 0; i < signInButton.getChildCount(); i++) {
      View v = signInButton.getChildAt(i);

      if (v instanceof TextView) {
        TextView tv = (TextView) v;
        tv.setText("Sign Up with Google");
        tv.setAllCaps(true);
        //tv.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_left_blue, 0, 0, 0);
        //here you can customize what you want
        return;
      }
    }
  }

  private void signIn() {
    Intent signInIntent = mGoogleSignInClient.getSignInIntent();
    startActivityForResult(signInIntent, RC_SIGN_IN);
  }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
    if (requestCode == RC_SIGN_IN) {
      // The Task returned from this call is always completed, no need to attach
      // a listener.
      Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
      handleSignInResult(task);
    }
  }

  private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
    try {
      GoogleSignInAccount account = completedTask.getResult(ApiException.class);
      // Signed in successfully, show authenticated UI.
      Intent intent = new Intent(this, SecondActivity.class);
      startActivity(intent);
    } catch (ApiException e) {
      // The ApiException status code indicates the detailed failure reason.
      // Please refer to the GoogleSignInStatusCodes class reference for more information.
      Log.w("Error", "signInResult:failed code=" + e.getStatusCode());
    }
  }

  private void showPhoneStatePermission() {
    int permissionCheck = ContextCompat.checkSelfPermission(this, READ_PHONE_STATE);
    if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
      requestPermission(READ_PHONE_STATE, REQUEST_PERMISSION_PHONE_STATE);
    } else {
      getIMEI();
    }
  }


  private void getIMEI() {
    IMEIUtil obj = new IMEIUtil();

    String deviceId = obj.getDeviceId(this);
    toastMessage(deviceId);
  }

  private void requestPermission(String readPhoneState, int request_permission_phone_state) {
    ActivityCompat.requestPermissions(this, new String[]{readPhoneState}, request_permission_phone_state);
  }

  private void toastMessage(String msg) {
    imei = msg;
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQUEST_PERMISSION_PHONE_STATE) {
      showPhoneStatePermission();
    }
  }

  private void bindAllControls() {
    invalid_pass_user = findViewById(R.id.tv_username_pass_error);
    serverurl = findViewById(R.id.serverid);
    ed_email = findViewById(R.id.ed_email);
    ed_password = findViewById(R.id.ed_password);
    btn_login = findViewById(R.id.btn_login);
    tv_signup = findViewById(R.id.tv_signup);
    tv_forgotpassword = findViewById(R.id.tv_forgotpassword);
    tv_signup = findViewById(R.id.v_signup);

    ed_email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
          Drawable img = ed_email.getContext().getResources().getDrawable(R.drawable.ic_person_outline_grey_600_24dp);
          ed_email.setCompoundDrawablesRelativeWithIntrinsicBounds(img, null, null, null);
        } else {
          Drawable img = ed_email.getContext().getResources().getDrawable(R.drawable.outline_person_outline_blue_900_24dp);
          ed_email.setCompoundDrawablesRelativeWithIntrinsicBounds(img, null, null, null);
        }
      }
    });

    ed_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
          Drawable img = ed_password.getContext().getResources().getDrawable(R.drawable.ic_lock_outline_grey_600_24dp);
          ed_password.setCompoundDrawablesRelativeWithIntrinsicBounds(img, null, null, null);
        } else {
          Drawable img = ed_password.getContext().getResources().getDrawable(R.drawable.outline_lock_blue_900_24dp);
          ed_password.setCompoundDrawablesRelativeWithIntrinsicBounds(img, null, null, null);
        }
      }
    });
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
}
