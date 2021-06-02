package com.example.mystikma.detail;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.mystikma.R;
import com.example.mystikma.adapter.AdapterKHS;
import com.example.mystikma.model.ModelKHS;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.List;

public class IsiKHS extends AppCompatActivity {

    ImageView imageView2;
    SubsamplingScaleImageView subsamplingScaleImageView;
    RecyclerView rv_khs;
    AdapterKHS adapter;
    List<ModelKHS> model;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    ProgressBar progressBar;

    String nim;
    String semester;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_print_pdf, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.print:

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_khs);

//        rv_khs = findViewById(R.id.isikhs);
//        rv_khs.setLayoutManager(new LinearLayoutManager(IsiKHS.this));
//        rv_khs.setHasFixedSize(true);
        imageView2 = findViewById(R.id.dark_khs);
        progressBar = findViewById(R.id.prog_khs);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.getCurrentUser();
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        semester = getIntent().getStringExtra("key");

        StorageReference ref = firebaseStorage.getReferenceFromUrl("gs://mystikma2.appspot.com/image_krs/")
                .child(firebaseAuth.getUid()).child(semester+".jpg");
        progressBar.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.VISIBLE);


        try{
            final File file = File.createTempFile("image_krs", "jpg");
            ref.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                    subsamplingScaleImageView = findViewById(R.id.imageView_khs);
                    subsamplingScaleImageView.setImage(ImageSource.bitmap(bitmap));

                    progressBar.setVisibility(View.GONE);
                    imageView2.setVisibility(View.GONE);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

//        firebaseFirestore.collection("db_mahasiswa").document("angkatan").collection("2016").document(firebaseAuth.getUid())
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        if (task.isSuccessful()){
//                            DocumentSnapshot doc = task.getResult();
//                            nim = doc.getString("nim");
//
//                            firebaseFirestore.collection("db_nilai").document(semester).collection(nim)
//                                    .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                    model = new ArrayList<>();
//                                    if (task.isSuccessful()){
//                                        for (QueryDocumentSnapshot doc : task.getResult()){
//                                            String matkul = doc.getString("nama");
//                                            String nilai = doc.getString("nilai");
//                                            String sks = doc.getString("sks");
//                                            model.add(new ModelKHS(matkul,sks,nilai,"sksn"));
//                                            Log.d("firestore", doc.getData().toString());
//                                        }
//                                        adapter1 = new AdapterKHS(model);
//                                        rv_khs.setAdapter(adapter1);
//                                    }
//                                }
//                            });
//
//                        }
//                    }
//                });




    }

}
