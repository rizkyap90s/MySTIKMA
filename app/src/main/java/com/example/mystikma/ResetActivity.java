package com.example.mystikma;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetActivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText txtresetemail;
    Button btnresetsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        txtresetemail = findViewById(R.id.txtreset);
        btnresetsubmit = findViewById(R.id.btnreset);

        auth = FirebaseAuth.getInstance();

        btnresetsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtresetemail.getText().toString();
                auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            AlertDialog.Builder builder = new AlertDialog.Builder(ResetActivity.this);
                            builder
                                    .setTitle("Reset Success")
                                    .setMessage("Check your email and set your password")
                                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(ResetActivity.this, Login.class);
                                            startActivity(intent);
                                        }
                                    });
                            Dialog dialog = builder.create(); dialog.show();
                        }
                    }
                });

            }
        });




    }
}
