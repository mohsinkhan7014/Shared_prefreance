package com.mohsin.shared_prefreance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText admin_id,pass;
    Button login;
    CheckBox x;
    SharedPreferences shr;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin_id=findViewById(R.id.admin);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.btn);
        x=findViewById(R.id.checkbox);


        final Intent ii=new Intent(MainActivity.this,Homepage.class);
        shr=getSharedPreferences("admin_id",MODE_PRIVATE);
        editor = shr.edit();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(admin_id.getText().toString().equals("Mohsin") && pass.getText().toString().equals("Golu"))
                {

                    if(x.isChecked()) {
                        editor.putString("admin", admin_id.getText().toString());
                        editor.putString("pass", pass.getText().toString());
                        editor.putBoolean("save",true);
                        editor.apply();
                    }
                    Toast.makeText(MainActivity.this,"Login Succesful ",Toast.LENGTH_LONG).show();
                    startActivity(ii);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        boolean p;
        p = shr.getBoolean("save",false);
        if(p)
        {
            startActivity(ii);
        }
    }
}
