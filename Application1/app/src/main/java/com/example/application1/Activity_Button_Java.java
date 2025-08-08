package com.example.application1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Button_Java extends AppCompatActivity {

    Button button01, btn2;
    int i = 0, j = 0;
//    全域變數

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button_java);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets; 系統事件ApplyWindowInsets // (findViewById(R.id.main)=>android:id="@+id/main"
//        });

        button01 = findViewById(R.id.btn_01);
        btn2 = findViewById(R.id.btn2);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                i++;
//                button01.setText("已按下按鈕111:" + i + "次");

                button01.setText("已按下按鈕111");
                button01.setTextColor(Color.CYAN);
                button01.setBackgroundColor(0);
                button01.setClickable(false);

                btn2.setText("按鈕222");
                btn2.setTextColor(Color.rgb(123, 105, 0));
                btn2.setBackgroundResource(R.drawable.button_pressed);
                btn2.setClickable(true);
            }
        });


        btn2.setText("清零按鈕111已按次數");


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });



    }
}