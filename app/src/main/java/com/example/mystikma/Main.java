package com.example.mystikma;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mystikma.model.ModelProfil;
import com.example.mystikma.utama.CekStatus;
import com.example.mystikma.utama.Info;
import com.example.mystikma.utama.KHS;
import com.example.mystikma.utama.KRS;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Main extends AppCompatActivity {

    FirebaseFirestore fire;
    FirebaseAuth auth;
    FirebaseUser user;
    List<ModelProfil> model;
    CircleImageView imgprofil;
    TextView txtnamaprofil, txtnimprofil;
    String nim, nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        fire= FirebaseFirestore.getInstance();

        fire.collection("db_mahasiswa")
                .document("angkatan")
                .collection("16")
                .document("16112343")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot doc = task.getResult();
                        nim = doc.getString("nim");
                        nama = doc.getString("nama");
                        txtnimprofil.setText(nim);
                        txtnamaprofil.setText(nama);
                    }
                });
    }

    private void init() {
        imgprofil=findViewById(R.id.imgprofil);
        txtnamaprofil = findViewById(R.id.txtnamaprofil);
        txtnimprofil=findViewById(R.id.txtnimprofil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_utama,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:
                Intent intent = new Intent(Main.this, Setting.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void kekrs(View view) {
        Intent intent = new Intent(Main.this, KRS.class);
        startActivity(intent);
    }

    public void kekhs(View view) {
        Intent go = new Intent(Main.this, KHS.class);
        startActivity(go);
    }

    public void kecekstatus(View view) {
        Intent kecek = new Intent(Main.this, CekStatus.class);
        startActivity(kecek);
    }

    public void keinfo(View view) {
        Intent keinfo = new Intent(Main.this, Info.class);
        startActivity(keinfo);
    }
}
