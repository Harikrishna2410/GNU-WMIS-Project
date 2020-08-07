package com.example.admin.warehousemobileinvoicingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SecondActivity extends AppCompatActivity {

  TextView name, email, id;
  Button signout;
  ImageView imageView;
  GoogleSignInClient mGoogleSignInClient;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    //updateUI(account);

    // Build a GoogleSignInClient with the options specified by gso.
    mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    name = findViewById(R.id.name);
    email = findViewById(R.id.email_address);
    id = findViewById(R.id.id);
    signout = findViewById(R.id.sign_out);
    imageView = findViewById(R.id.imageview);

    signout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        switch (view.getId()) {
          // ...
          case R.id.sign_out:
            signOut();
            break;
          // ...
        }
      }
    });

    GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
    if (acct != null) {
      String personName = acct.getDisplayName();
      String personGivenName = acct.getGivenName();
      String personFamilyName = acct.getFamilyName();
      String personEmail = acct.getEmail();
      String personId = acct.getId();
      Uri personPhoto = acct.getPhotoUrl();

      name.setText(personName);
      email.setText(personEmail);
      id.setText(personId);
      Glide.with(this).load(String.valueOf(personPhoto)).into(imageView);
    }
  }

  private void signOut() {
    mGoogleSignInClient.signOut()
            .addOnCompleteListener(this, new OnCompleteListener<Void>() {
              @Override
              public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(SecondActivity.this, "Signed Out Successfully!", Toast.LENGTH_SHORT).show();
                finish();
                // ...
              }
            });
  }


}
