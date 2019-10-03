package android.example.simplenotesapp.user_sign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.example.simplenotesapp.MainActivity;
import android.example.simplenotesapp.R;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
private EditText email,password;
private Button login;
private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.input_log_email);
        password = findViewById(R.id.input_log_pass);
        login =  findViewById(R.id.btn_log);
        firebaseAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lemail = email.getText().toString();
                String lpassword = password.getText().toString();

                if(!TextUtils.isEmpty(lemail)&& !TextUtils.isEmpty(lpassword)){
                    login(lemail, lpassword);
                }
            }
        });

    }

    private void login(String Email, String Password){

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loggin in, please wait....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

           if(task.isSuccessful()){

               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
               startActivity(intent);
               finish();
            Toast.makeText(LoginActivity.this, " Sign IN Succuesful", Toast.LENGTH_SHORT).show();
           }
           else
           {
               Toast.makeText(LoginActivity.this, "ERROR: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
           }


            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.home:
            finish();
            break;
        }
            return true;

    }
}
