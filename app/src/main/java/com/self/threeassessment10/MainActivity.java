package com.self.threeassessment10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editTextUserName, editTextPassWord;
    TextView Login;
    Button buttonRegister;
    UserDao db;
    UserDataBase dataBase;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.login);
        editTextUserName = (EditText) findViewById(R.id.editTextTextPersonName7);
        editTextPassWord =(EditText) findViewById(R.id.editTextTextPersonName8);

        Login=(TextView) findViewById(R.id.textView14);
        buttonRegister =(Button)findViewById(R.id.button);

        dataBase = Room.databaseBuilder(this,UserDataBase.class,"User")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });

        //Login
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUserName.getText().toString().trim();
                String password = editTextPassWord.getText().toString().trim();
                User user = db.getUser(username,password);
                if(user != null)
                {
                    Intent intent = new Intent(MainActivity.this, Screen3.class);
                    intent.putExtra("isUser",user);
                    //Toast.makeText(MainActivity.this, "Register successfully", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    //finish();

                }else{
                    Toast.makeText(MainActivity.this, "Unregister or incorrect user name or password", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}