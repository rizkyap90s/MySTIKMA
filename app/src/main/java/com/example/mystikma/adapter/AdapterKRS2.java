package com.example.mystikma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mystikma.R;
import com.example.mystikma.model.Semester2;

import java.util.List;

public class AdapterKRS2 extends RecyclerView.Adapter<AdapterKRS2.MyHolder> {

    List<Semester2> model;
    Context con;

    public AdapterKRS2(Context con, List<Semester2> model) {
        this.model = model;
        this.con = con;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cus_krs,null, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i) {
        holder.matkulkrs.setText(model.get(i).getMatkulkrs());
        holder.skskrs.setText(model.get(i).getSkskrs());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        CheckBox cekkrs;
        TextView matkulkrs, skskrs;
        Spinner spinnerkrs;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            cekkrs = itemView.findViewById(R.id.cekkrs);
            matkulkrs = itemView.findViewById(R.id.matkulkrs);
            skskrs = itemView.findViewById(R.id.skskrs);
            spinnerkrs = itemView.findViewById(R.id.spinkrs);
        }
    }
}
