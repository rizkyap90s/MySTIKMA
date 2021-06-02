package com.example.mystikma;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Setting extends AppCompatActivity {
    LinearLayout akun, out, help;
    FirebaseFirestore fire;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        akun=findViewById(R.id.akun);
        out=findViewById(R.id.out);
        help=findViewById(R.id.help);

        auth = FirebaseAuth.getInstance();
        auth.getCurrentUser();
        fire = FirebaseFirestore.getInstance();

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent back = new Intent(Setting.this, Login.class);
                startActivity(back);
            }
        });


    }


}
