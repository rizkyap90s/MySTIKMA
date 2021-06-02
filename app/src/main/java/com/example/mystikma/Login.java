package com.example.mystikma;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    Button btnlogin;
    TextInputEditText inputemailr, inputpinr;
    FirebaseAuth auth;
    FirebaseFirestore fire;
    ImageView imageView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        auth = FirebaseAuth.getInstance();
        auth .getCurrentUser();

        if(auth.getCurrentUser() != null){
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                final String email = inputemailr.getText().toString();
                final String pin = inputpinr.getText().toString();

                auth.signInWithEmailAndPassword(email,pin)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    Intent go = new Intent(Login.this, Main.class);
                                    startActivity(go);
                                    finish();
                                    progressBar.setVisibility(View.GONE);
                                    imageView.setVisibility(View.GONE);
                                }
                                else {
                                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                    imageView.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });
    }

    private void init() {
        btnlogin = findViewById(R.id.btnlogin);
        inputemailr = findViewById(R.id.loginemail);
        inputpinr = findViewById(R.id.loginpin);
        progressBar = findViewById(R.id.prog_login);
        imageView = findViewById(R.id.dark_signin);
    }

    public void kesignup(View view) {
        Intent intent = new Intent(Login.this, SignUp.class);
        startActivity(intent);
    }

    public void toReset(View view) {
        Intent intent = new Intent(this, ResetActivity.class);
        startActivity(intent);
    }
}
