package com.example.application1;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_ImageView_Java extends AppCompatActivity {

    ImageView imageview_01;

    TextView textview_change_pic, textview_change_scaletype;

    int imageIndex = 0, scaleIndex = 0, i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_view_java);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        imageview_01 = findViewById(R.id.imageview_01);
        textview_change_pic = findViewById(R.id.textview_change_pic);
        textview_change_scaletype = findViewById(R.id.textview_change_scaletype);

        //設定圖片
        textview_change_pic.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {      //ACTION_DOWN 按著螢幕不放開 //ACTION_UP 按下後放開才會換圖片
                    //getAction 抓event
                    if (imageIndex == 2) {
                        imageview_01.setImageResource(R.drawable.picture02);
                        imageIndex = 1;
                    } else {
                        imageview_01.setImageResource(R.drawable.picture03);
                        imageIndex = 2;
                    }
                }
                return false;
            }
        });

//        textview_change_scaletype.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                i++;
//                textview_change_scaletype.setText("變更縮放模式 " + i);
//                if (scaleIndex == 2) {
//                    imageview_01.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                    scaleIndex = 1;
//                } else {
//                    imageview_01.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                    scaleIndex = 2;
//                }
//            }
//        });


        textview_change_scaletype.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    i++;
                    textview_change_scaletype.setText("變更縮放模式 " + i);
                    if (scaleIndex == 2) {
                        imageview_01.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        scaleIndex = 1;
                    } else {
                        imageview_01.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        scaleIndex = 2;
                    }
                }
            }
        });


    }
}