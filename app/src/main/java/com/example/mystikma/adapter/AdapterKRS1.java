package com.example.mystikma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mystikma.R;
import com.example.mystikma.model.JumlahSKS;
import com.example.mystikma.model.Semester1;
import com.example.mystikma.model.TampungKRS;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterKRS1 extends RecyclerView.Adapter<AdapterKRS1.MyHolder> {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    List<Semester1> model;
    List<TampungKRS> tampungKRS = new ArrayList<>();
    List<JumlahSKS> jumlahKRS = new ArrayList<>();
    Context con;
    String getNIM, getSMSTR;

    public AdapterKRS1(Context con, List<Semester1> model, String getNIM, String getSMSTR) {
        this.con=con;
        this.model=model;
        this.getNIM=getNIM;
        this.getSMSTR=getSMSTR;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent,final int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cus_krs,null, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int i) {
        holder.matkulkrs.setText(model.get(i).getMatkulkrs());
        holder.skskrs.setText(model.get(i).getSkskrs());

        holder.cekkrs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String angkatan = getNIM.substring(0,2);

                if (isChecked){
                    String barulang = holder.spinnerkrs.getSelectedItem().toString();
                    String mk = model.get(i).getMatkulkrs();
                    String sks = model.get(i).getSkskrs();
                    String bu = model.get(i).getBaruulang();
                    tampungKRS.add(new TampungKRS(mk, sks, barulang));

                    int skss = Integer.parseInt(sks);
                    jumlahKRS.add(new JumlahSKS(skss));

                    Map<String, Object> krs = new HashMap<>();
                    krs.put("mata_kuliah", tampungKRS.get(i).getMatkulkrs());
                    krs.put("sks", tampungKRS.get(i).getSkskrs());
                    krs.put("Baru/Ulang", barulang);

                    firebaseFirestore.collection("db_isi_krs")
                            .document("angkatan")
                            .collection(angkatan)
                            .document(getNIM)
                            .collection("Semester "+getSMSTR)
                            .document(mk)
                            .set(krs)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){

                                    }
                                }
                            });
                }
                else {
                    String mk2 = model.get(i).getMatkulkrs();

                    firebaseFirestore.collection("db_isi_krs")
                            .document("angkatan")
                            .collection(angkatan)
                            .document(getNIM)
                            .collection("Semester "+getSMSTR)
                            .document(mk2)
                            .delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                }
                            });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        CheckBox cekkrs;
        LinearLayout itemkrs;
        TextView matkulkrs, skskrs;
        final Spinner spinnerkrs;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            cekkrs = itemView.findViewById(R.id.cekkrs);
            itemkrs = itemView.findViewById(R.id.item_isi_krs);
            matkulkrs = itemView.findViewById(R.id.matkulkrs);
            skskrs = itemView.findViewById(R.id.skskrs);
            spinnerkrs = itemView.findViewById(R.id.spinkrs);
        }
    }
}
