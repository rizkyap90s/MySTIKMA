package com.example.mystikma.utama;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mystikma.R;
import com.example.mystikma.adapter.AdapterKRS1;
import com.example.mystikma.detail.IsiKRS;
import com.google.android.material.textfield.TextInputEditText;

public class KRS extends AppCompatActivity {

    TextInputEditText nimkrs, smstrkrs, iplalu;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krs);
        nimkrs = findViewById(R.id.editnimkrs);
        smstrkrs = findViewById(R.id.edit_semester_krs);
        submit = findViewById(R.id.submit);
        iplalu = findViewById(R.id.editiplalu);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nim = nimkrs.getText().toString();
                final String smstr = smstrkrs.getText().toString();
                final String ip = iplalu.getText().toString();

                Intent dataKRS = new Intent(KRS.this, IsiKRS.class);
                dataKRS.putExtra("nim", nim);
                dataKRS.putExtra("smstr", smstr);
                dataKRS.putExtra("ip", ip);
                startActivity(dataKRS);
            }
        });

    }


}
