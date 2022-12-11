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

public class RegisterActivity extends AppCompatActivity {

    EditText editTextUsername, editTextName, editTextPassword, editTextHomeAddr ,editTextWorkAddr;
    Button buttonRegister;

    TextView textViewLogin;
    private UserDao userDao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editTextUsername = findViewById(R.id.editTextUsername);
        editTextName= findViewById(R.id.editTextYourname);
        editTextPassword = findViewById(R.id.editPassword);
        editTextHomeAddr = findViewById(R.id.editTextHomeAddr);
        editTextWorkAddr = findViewById(R.id.editTextWorkAddr);
        buttonRegister = findViewById(R.id.buttonRegister);

        textViewLogin = findViewById(R.id.textViewLogin);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

        //userDao = Room.databaseBuilder(this, UserDataBase.class, "User").build().getUserDao();
        userDao = Room.databaseBuilder(this, UserDataBase.class, "User").allowMainThreadQueries()
                .build().getUserDao();


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String userName = editTextUsername.getText().toString().trim();
                String yourName = editTextName.getText().toString().trim();
                String passWord = editTextPassword.getText().toString().trim();
                String homeAddr = editTextHomeAddr.getText().toString().trim();
                String workAddr = editTextWorkAddr.getText().toString().trim();


                if (passWord.equals(passWord) && userName.equals(userName)) {
                    User user = new User( userName, passWord, yourName, homeAddr, workAddr);
                    userDao.insert(user);

                    Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(moveToLogin);

                } else {
                    Toast.makeText(RegisterActivity.this, "Password is Wrong", Toast.LENGTH_SHORT).show();

                }


            }
        });



    }
}