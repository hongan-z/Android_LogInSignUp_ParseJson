package com.self.threeassessment10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Screen3 extends AppCompatActivity {

    TextView displayname;
    private User user;

    ImageSlider imageSlider , imageSlider2;
    private RadioGroup radioGroup;
    JsonParser jsonParser;


    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);


        User myUser = (User) getIntent().getSerializableExtra("isUser");

        displayname = findViewById(R.id.helloname);

        imageSlider =(ImageSlider) findViewById(R.id.imaID);
        imageSlider =(ImageSlider) findViewById(R.id.imaID);
        imageSlider2 =(ImageSlider) findViewById(R.id.imageSlideID);
        ArrayList<SlideModel> img = new ArrayList<>();
        ArrayList<SlideModel> img2 = new ArrayList<>();

        img.add(new SlideModel(R.drawable.newfoodpict,null));
        img.add(new SlideModel(R.drawable.food2,null));
        img2.add(new SlideModel(R.drawable.food4,null));
        img2.add(new SlideModel(R.drawable.imagesfood1,null));

        imageSlider.setImageList(img);
        imageSlider2.setImageList(img2);
        //radioGroup =(RadioGroup) findViewById(R.id.radio_group);

        if(myUser != null){
            displayname.setText("Hello " + myUser.getUserName());

        }
        radioGroup =(RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedButId) {
                switch (checkedButId){
                    case R.id.deliver1:
                        Intent intent = new Intent(Screen3.this, DisplayAdress.class);
                        intent.putExtra("myUser",myUser);
                        startActivity(intent);
                        //finish();
                        break;
                    case R.id.takeaway2:
                        Intent intentMap = new Intent(Screen3.this,Maps.class);
                        startActivity(intentMap);
                        finish();
                        break;

                    case R.id.dine3:
                       // Intent intent1 = new Intent(Screen3.this,DisplayAdress.class);
                       // startActivity(intent1);
                        Toast.makeText(Screen3.this, "Dine-in", Toast.LENGTH_SHORT).show();break;

                }
            }
        });


        try
        {
            jsonParser = (JsonParser) new JsonParser(this, this).execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "something wrong !", Toast.LENGTH_SHORT).show();
        }


    }
}