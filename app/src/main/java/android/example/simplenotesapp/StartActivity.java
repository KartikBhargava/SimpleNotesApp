package android.example.simplenotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.simplenotesapp.user_sign.LoginActivity;
import android.example.simplenotesapp.user_sign.RegisterActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {
  private Button reg,log;
  private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
         reg= findViewById(R.id.start_reg_btn);
         log = findViewById(R.id.start_log_btn);
         firebaseAuth= FirebaseAuth.getInstance();

         updateUI();
         log.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 login();
             }
         });

         reg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 register();
             }
         });

    }
    private void register(){
  Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
  startActivity(intent);
  finish();
    }
    private void login(){
  Intent intent = new Intent(StartActivity.this, LoginActivity.class);
  startActivity(intent);
  finish();
    }
    private void updateUI(){
        if(firebaseAuth.getCurrentUser()!= null){
            Log.i("StartActivity", "firebaseAuth!=null");
            Intent intent= new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{

            Log.i("StartActivity", "firebaseAuth==null");
        }
    }
}
