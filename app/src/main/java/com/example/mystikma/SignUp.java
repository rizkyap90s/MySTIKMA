package com.example.mystikma;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.mystikma.detail.IsiKRS;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    FirebaseAuth auth;
    TextInputEditText editnim, editnama, editemail,edittelpon, editpin;
    Button btnsubmit;
    ProgressBar progressBar;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        progressBar = findViewById(R.id.progress);

       init();

        btnsubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String getEmail = editemail.getText().toString();
                final String getPin = editpin.getText().toString();
                final String getnama = editnama.getText().toString();
                final String getnim = editnim.getText().toString();
                final String gettelpon = edittelpon.getText().toString();

                progressBar.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(getEmail,getPin)
                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    auth.signInWithEmailAndPassword(getEmail, getPin)
                                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (task.isSuccessful()){
                                                        progressBar.setVisibility(View.GONE);
                                                        imageView.setVisibility(View.GONE);
                                                    }
                                                }
                                            });
                                    Intent intent = new Intent(SignUp.this, Main.class);
                                    intent.putExtra("nim", getnim);

                                    FirebaseFirestore ft = FirebaseFirestore.getInstance();
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("email", getEmail);
                                    user.put("pin", getPin);
                                    user.put("nama", getnama);
                                    user.put("nim", getnim);
                                    user.put("telpon", gettelpon);

                                    String angkatan = getnim.substring(0,2);

                                    ft.collection("db_mahasiswa").document("angkatan")
                                            .collection(angkatan).document(getnim)
                                            .set(user)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {

                                                        Log.d("signup", "Succes");

                                                    }else {

                                                        Log.d("signup", "Aw. Snap !");
                                                    }
                                                }
                                            });

                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    progressBar.setVisibility(View.GONE);
                                    imageView.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });



    }

    private void init() {
        editnim = findViewById(R.id.signupnim);
        editnama = findViewById(R.id.signupnama);
        editemail = findViewById(R.id.email);
        edittelpon = findViewById(R.id.signuptelpon);
        editpin = findViewById(R.id.pin);
        btnsubmit = findViewById(R.id.btnsubmit);

        imageView = findViewById(R.id.dark_signup);
        auth = FirebaseAuth.getInstance();
        auth.getCurrentUser();
    }

    public void kelogin(View view) {
        Intent intent = new Intent(SignUp.this, Login.class);
        startActivity(intent);


    }
}
