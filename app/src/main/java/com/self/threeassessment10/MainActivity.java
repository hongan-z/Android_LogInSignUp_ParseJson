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
    Button buttonLogin;
    TextView textViewRegister;
    UserDao db;
    UserDataBase dataBase;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = (EditText) findViewById(R.id.editUserName);
        editTextPassWord =(EditText) findViewById(R.id.editTextPassword);

        buttonLogin=(Button) findViewById(R.id.buttonLogin);
        textViewRegister =(TextView) findViewById(R.id.textViewRegister);

        dataBase = Room.databaseBuilder(this,UserDataBase.class,"User")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
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