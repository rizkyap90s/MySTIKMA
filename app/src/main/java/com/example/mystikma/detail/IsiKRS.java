package com.example.mystikma.detail;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.mystikma.Main;
import com.example.mystikma.R;
import com.example.mystikma.adapter.AdapterKRS1;
import com.example.mystikma.adapter.AdapterKRS2;
import com.example.mystikma.adapter.AdapterKRS3;
import com.example.mystikma.model.Semester1;
import com.example.mystikma.model.Semester2;
import com.example.mystikma.model.Semester3;
import com.example.mystikma.model.TampungKRS;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class IsiKRS extends AppCompatActivity {

    Button btn_submit;
    CheckBox checkBox;

    List<Semester1> model1;
    List<Semester2> model2;
    List<Semester3> model3;
    List<TampungKRS> tampungKRS;
    RecyclerView rv_krs1, rv_krs2, rv_krs3;
    AdapterKRS1 adapter1;
    AdapterKRS2 adapter2;
    AdapterKRS3 adapter3;

    Spinner spinkrs;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isikrs);

        init();
        isi();

        Intent intent = getIntent();
        final String getnim = intent.getStringExtra("nim");
        final String getsmstr = intent.getStringExtra("smstr");


        rv_krs1.setLayoutManager(new LinearLayoutManager(this));
        adapter1 = new AdapterKRS1(this, model1, getnim, getsmstr);
        rv_krs1.setAdapter(adapter1);

        rv_krs2.setLayoutManager(new LinearLayoutManager(this));
        adapter2 = new AdapterKRS2( this, model2);
        rv_krs2.setAdapter(adapter2);

        rv_krs3.setLayoutManager(new LinearLayoutManager(this));
        adapter3= new AdapterKRS3(this, model3, getnim, getsmstr);
        rv_krs3.setAdapter(adapter3);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(IsiKRS.this);
                alert
                        .setTitle("Kamu udah yakin sama aku?")
                        .setMessage("Cek lagi matakuliah kamu, pastiin nggak ada jadwal yang tabrakan yah <3")
                        .setPositiveButton("Iya, udah yakin kok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intentlagi = new Intent(IsiKRS.this, Main.class);
                                startActivity(intentlagi);
                            }
                        })
                        .setNeutralButton("Hmm, Aku cek lagi deh", null);
                Dialog dialog = alert.create(); dialog.show();


//                TampungKRS tampungKRS = new TampungKRS();
//                String angkatan = getnim.substring(0,2);
//
//                Map<String, Object> krs = new HashMap<>();
//                Toast.makeText(IsiKRS.this, tampungKRS.getMatkulkrs(), Toast.LENGTH_SHORT).show();
//                krs.put("mata_kuliah", tampungKRS.getMatkulkrs());
//                krs.put("SKS",tampungKRS.getSkskrs());
//                krs.put("baruulang",tampungKRS.getBaruulang());
//
//                firebaseFirestore.collection("db_isi_krs")
//                        .document("angkatan")
//                        .collection(angkatan)
//                        .document(getnim)
//                        .collection(getsmstr)
//                        .document()
//                        .set(krs)
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()){
//                                    Toast.makeText(IsiKRS.this, "Success", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//                startActivity(new Intent(IsiKRS.this, Main.class));
            }
        });

    }

    private void isi() {
        spinkrs = findViewById(R.id.spinkrs);

        //smstr 1
        model1.add(new Semester1(null, "Algoritma & Pemrograman 1","3",null));
        model1.add(new Semester1(null, "Pendidikan Agama Islam 1","1",null));
        model1.add(new Semester1(null, "Paket Program Niaga","3",null));
        model1.add(new Semester1(null, "Bahasa Inggris 1","3",null));
        model1.add(new Semester1(null, "kalkulus","1",null));
        model1.add(new Semester1(null, "Logika informatika","3",null));
        model1.add(new Semester1(null, "fisika","3",null));
        model1.add(new Semester1(null, "pengantar teknologi informasi","1",null));
        //smstr 2
//        model2.add(new Semester2(null, "Algoritma & Pemrograman 2","3",null));
//        model2.add(new Semester2(null, "Pendidikan Agama Islam 2","1",null));
//        model2.add(new Semester2(null, "aljabar linier","3",null));
//        model2.add(new Semester2(null, "Bahasa Inggris 2","3",null));
//        model2.add(new Semester2(null, "elektronika digital","1",null));
//        model2.add(new Semester2(null, "basis data","3",null));
//        model2.add(new Semester2(null, "program internet","3",null));
//        model2.add(new Semester2(null, "program visual","1",null));

        //smsstr3
        model3.add(new Semester3(null, "Algoritma & Pemrograman 3","3",null));
        model3.add(new Semester3(null, "Pendidikan Agama Islam 3","1",null));
        model3.add(new Semester3(null, "bahasa indonesia","3",null));
        model3.add(new Semester3(null, "komunikasi data","3",null));
        model3.add(new Semester3(null, "matematika diskrit","1",null));
        model3.add(new Semester3(null, "statistika dan probabilitas","3",null));
        model3.add(new Semester3(null, "interaksi manusia dan komputer","3",null));
        model3.add(new Semester3(null, "arsitertur organisasi komputer","1",null));

        //smstsr 4

    }

    private void init() {
        btn_submit = findViewById(R.id.btn_submit);
        rv_krs1=findViewById(R.id.rv_krs_1);
        rv_krs2=findViewById(R.id.rv_krs_2);
        rv_krs3=findViewById(R.id.rv_krs_3);
        model1 = new ArrayList<>();
        model2 = new ArrayList<>();
        model3 = new ArrayList<>();
        tampungKRS = new ArrayList<>();

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.getCurrentUser();
    }

}
