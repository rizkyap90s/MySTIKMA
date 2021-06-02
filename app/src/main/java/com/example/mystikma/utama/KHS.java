package com.example.mystikma.utama;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mystikma.R;
import com.example.mystikma.detail.IsiKHS;

public class KHS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khs);
    }

    public void smstr1(View view) {
        Intent intent = new Intent(KHS.this, IsiKHS.class);
        intent.putExtra("key", "1");
        startActivity(intent);

    }
    public void smstr2(View view) {
        Intent intent = new Intent(KHS.this, IsiKHS.class);
        intent.putExtra("key", "2");
        startActivity(intent);
    }
    public void smstr3(View view) {
        Intent intent = new Intent(KHS.this, IsiKHS.class);
        intent.putExtra("key", "3");
        startActivity(intent);
    }
    public void smstr4(View view) {
        Intent intent = new Intent(KHS.this, IsiKHS.class);
        intent.putExtra("key", "4");
        startActivity(intent);
    }
    public void smstr5(View view) {
        Intent intent = new Intent(KHS.this, IsiKHS.class);
        intent.putExtra("key", "5");
        startActivity(intent);
    }
    public void smstr6(View view) {
        Intent intent = new Intent(KHS.this, IsiKHS.class);
        intent.putExtra("key", "6");
        startActivity(intent);
    }
    public void smstr7(View view) {
        Intent intent = new Intent(KHS.this, IsiKHS.class);
        intent.putExtra("key", "semester7");
        startActivity(intent);
    }
    public void smstr8(View view) {
        Intent intent = new Intent(KHS.this, IsiKHS.class);
        intent.putExtra("key", "semester8");
        startActivity(intent);
    }

}
