package com.self.threeassessment10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayAdress extends AppCompatActivity {
    private Button addrReturn;
    private TextView tvUser , tvHome, tvWorkaddress;

    private User user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_adress);
        //setContentView(R.layout.newdisplayresult);

        user = (User) getIntent().getSerializableExtra("myUser");

        tvUser = findViewById(R.id.tvUser);
        tvHome = findViewById(R.id.tvHome);
        tvWorkaddress = findViewById(R.id.tvWork);
        addrReturn = (Button) findViewById(R.id.buttonAddrReturn);

        if(user != null){

            tvUser.setText("Welcome " + user.getUserName());
            tvHome.setText("Home Address:" + user.getHomeAddr() );
            tvWorkaddress.setText("Work address:" + user.getWorkAddr());
        }


        addrReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayAdress.this,Screen3.class);
                startActivity(intent);
            }
        });


    }
}