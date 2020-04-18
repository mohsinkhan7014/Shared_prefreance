package com.mohsin.shared_prefreance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    CardView studentd,addst,cgpa,exam;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        studentd=findViewById(R.id.card_view);
        addst=findViewById(R.id.card_view2);
        cgpa=findViewById(R.id.card_view3);
        exam=findViewById(R.id.card_view4);

        studentd.setRadius(30);
        addst.setRadius(30);
        cgpa.setRadius(30);
        exam.setRadius(30);
        logout=findViewById(R.id.btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences("admin_id", MODE_PRIVATE);
                settings.edit().clear().apply();
                finish();
            }
        });


    }
}
