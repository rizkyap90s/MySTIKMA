package com.example.mystikma.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mystikma.R;
import com.example.mystikma.model.ModelKHS;

import java.util.List;

public class AdapterKHS extends RecyclerView.Adapter<AdapterKHS.MyHolder> {

    Context con;
    List<ModelKHS> modelKHS;
    public AdapterKHS(List<ModelKHS> modelKHS){
        this.modelKHS=modelKHS;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cus_khs, null, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {
        myHolder.matkul.setText(modelKHS.get(i).getMatkulkhs());
        myHolder.sks.setText(modelKHS.get(i).getSkskhs());
        myHolder.grade.setText(modelKHS.get(i).getGradekhs());
        myHolder.sksn.setText(modelKHS.get(i).getSksnkhs());
    }

    @Override
    public int getItemCount() {
        return modelKHS.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView matkul, sks, grade, sksn;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            matkul = itemView.findViewById(R.id.txtmatkulkhs);
            sks = itemView.findViewById(R.id.txtskskhs);
            grade = itemView.findViewById(R.id.txtgradekhs);
            sksn = itemView.findViewById(R.id.txtsksnkhs);
        }
    }
}
