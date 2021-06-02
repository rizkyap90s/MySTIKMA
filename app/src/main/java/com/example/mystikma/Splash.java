package com.example.mystikma;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.wang.avi.AVLoadingIndicatorView;

public class Splash extends AppCompatActivity {
    private AVLoadingIndicatorView avi,avi2,avi3,avi4,avi6,avi7,avi5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int interval = 500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                startActivity(intent);
                finish();

            }
        },interval);

        String indicator=getIntent().getStringExtra("indicator");
        avi=findViewById(R.id.avi);
//        avi2=findViewById(R.id.avi2);
//        avi3=findViewById(R.id.avi3);
//        avi4=findViewById(R.id.avi4);
//        avi5=findViewById(R.id.avi5);
//        avi6=findViewById(R.id.avi6);
//        avi7=findViewById(R.id.avi7);

        avi.setIndicator(indicator);
//        avi2.setIndicator(indicator);
//        avi3.setIndicator(indicator);
//        avi4.setIndicator(indicator);
//        avi5.setIndicator(indicator);
//        avi6.setIndicator(indicator);
//        avi7.setIndicator(indicator);



    }

}
