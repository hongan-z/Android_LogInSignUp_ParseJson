package com.self.threeassessment10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Screen3 extends AppCompatActivity {

    ImageSlider imageSlider , imageSlider2;
    private RadioGroup radioGroup;
    JsonParser jsonParser;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        User myUser = (User) getIntent().getSerializableExtra("isUser");

        imageSlider =(ImageSlider) findViewById(R.id.imaID);
        imageSlider2 =(ImageSlider) findViewById(R.id.imageSlideID);
        ArrayList<SlideModel> img = new ArrayList<>();
        ArrayList<SlideModel> img2 = new ArrayList<>();
        img.add(new SlideModel(R.drawable.food1,null));
        img.add(new SlideModel(R.drawable.food2,null));
        img2.add(new SlideModel(R.drawable.food4,null));
        img2.add(new SlideModel(R.drawable.imagesfood1,null));
        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

        imageSlider.setImageList(img);
        imageSlider2.setImageList(img2);

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