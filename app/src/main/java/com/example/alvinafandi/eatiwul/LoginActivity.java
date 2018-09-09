package com.example.alvinafandi.eatiwul;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonLogin;
    private EditText editTextEmail, editTextPassword;
    private TextView textViewSignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.masuk);
        textViewSignup = (TextView) findViewById(R.id.textViewSignup);

        editTextEmail = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.passwordLogin);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        buttonLogin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }
    public void onClick(View view){
        if(view == buttonLogin){
            loginPage();
        }
        if(view == textViewSignup){
            finish();
            startActivity(new Intent(this,RegisterActivity.class));
        }
    }
    private void loginPage(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            //email is empty
            editTextEmail.setError("Please enter a email address");
            editTextEmail.requestFocus();
            return;//stop execution

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email address");
            editTextEmail.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            editTextPassword.setError("Please enter a Password");
            editTextPassword.requestFocus();
            //stop execution
            return;
        }
        if(password.length()<6){
            editTextPassword.setError("Minimum length password should be 6 characters");
            editTextPassword.requestFocus();
            return;
        }
        //if validation are ok
        progressDialog.setMessage("Processing Login...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            Intent intent = new Intent(LoginActivity.this, CharacterActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(this,CharacterActivity.class));
        }
    }
}
