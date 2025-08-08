package com.example.application1;


import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Radiobutton_Java extends AppCompatActivity {

    TextView textview_answer_q1, textview_answer_q2;

    RadioGroup radioGroup_01, radioGroup_02;

    RadioButton radioButton_01, radioButton_02, radioButton_03, radioButton_04, radioButton_05, radioButton_06;


    @Override
    protected void onCreate(Bundle savedInstanceState) {  //onCreate就是建立內容的初期函式
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radiobutton_java);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        textview_answer_q1 = findViewById(R.id.textview_answer_q1);
        textview_answer_q2 = findViewById(R.id.textview_answer_q2);

        radioGroup_01 = findViewById(R.id.radioGroup_01);
        radioGroup_02 = findViewById(R.id.radioGroup_02);

        radioButton_01 = findViewById(R.id.radioButton_01);
        radioButton_02 = findViewById(R.id.radioButton_02);
        radioButton_03 = findViewById(R.id.radioButton_03);
        radioButton_04 = findViewById(R.id.radioButton_04);
        radioButton_05 = findViewById(R.id.radioButton_05);
        radioButton_06 = findViewById(R.id.radioButton_06);

        radioGroup_01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {  //哪一個group的哪一個id
                int selectedId = radioGroup_01.getCheckedRadioButtonId();

                if (selectedId == R.id.radioButton_01) {
                    textview_answer_q1.setText("第一題選擇了：" + radioButton_01.getText().toString());
                } else if (selectedId == R.id.radioButton_02) {
                    textview_answer_q1.setText("第一題選擇了：" + radioButton_02.getText().toString());
                } else if (selectedId == R.id.radioButton_03) {
                    textview_answer_q1.setText("第一題選擇了：" + radioButton_03.getText().toString());
                }
            }
        });

        radioButton_04.setOnClickListener(radioClickListener);
        radioButton_05.setOnClickListener(radioClickListener);
        radioButton_06.setOnClickListener(radioClickListener);
    }

    //具名委派要寫在onCreate外面
    // 要先定義一個點擊事件監聽器radioClickListener
    View.OnClickListener radioClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int selectedId = radioGroup_02.getCheckedRadioButtonId(); // 取得當前在 radioGroup_02 中被選中的 RadioButton 的 ID
            View v1 = findViewById(selectedId); // 使用 findViewById 找到對應 ID 的 View 元件
            RadioButton rb1 = (RadioButton) v1; // 將 View 轉型為 RadioButton
            textview_answer_q2.setText("第二題選擇了：" + rb1.getText().toString()); // 設置 textview_answer_q2 的文字，顯示被選中的選項文字
        }
    };


}