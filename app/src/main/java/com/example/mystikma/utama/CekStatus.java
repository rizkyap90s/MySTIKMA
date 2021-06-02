package com.example.mystikma.utama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mystikma.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CekStatus extends AppCompatActivity {

    ImageView img;
    Button btn;
    TextView txt;
    ProgressBar progressBar;
    ImageView imageView;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_status);
        btn=findViewById(R.id.btncek);
        img=findViewById(R.id.imgcek);
        txt=findViewById(R.id.txt);
        progressBar = findViewById(R.id.prog_cek);
        imageView = findViewById(R.id.dark_cek);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);

                Map<String, Object> cekstatus = new HashMap<>();
                firebaseFirestore.collection("db_cek_status")
                        .document(firebaseAuth.getUid())
                        .set(cekstatus)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    progressBar.setVisibility(View.GONE);
                                    imageView.setVisibility(View.GONE);
                                    img.setImageResource(R.drawable.ok);
                                    txt.setText("Access Granted");
                                }
                            }
                        });

//                int interval = 4000;
//
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        img.setImageResource(R.drawable.ok);
//                        txt.setText("Access Granted");
//
//                        progressBar.setVisibility(View.GONE);
//                        imageView.setVisibility(View.GONE);
//                    }
//                },interval);


            }
        });

    }
}
