package com.example.application1;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Textview_Java extends AppCompatActivity {

    TextView textView_1, textView_2, textView_3;

    String strText1;

    int colorText2;

    float sizeText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_textview_java);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        textView_1 = findViewById(R.id.textView_1);
        textView_2 = findViewById(R.id.textView_2);
        textView_3 = findViewById(R.id.textView_3);

        strText1 = textView_1.getText().toString();
        colorText2 = textView_2.getCurrentTextColor();
        sizeText3 = textView_3.getTextSize();

        textView_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    textView_1.setText("目前焦點：Focus on TextView 1 ");
                } else {
                    textView_1.setText(strText1);
                }
            }
        });
//        hasFocus用來判斷目前的UI元件

        textView_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    textView_2.setText("目前焦點：Focus on TextView 2 ");
                    textView_2.setTextColor(0xFF00FFFF); // 設定文字顏色為藍色(ARGB格式)
                } else {
                    textView_2.setText(strText1);
                    textView_2.setTextColor(colorText2); // 恢復原來的文字顏色
                }
            }
        });

        textView_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    textView_3.setText("目前焦點：Focus on TextView 3");
                    textView_3.setTextSize(30f); // 設定文字大小為30sp
                } else {
                    textView_3.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeText3);
                    textView_3.setTextColor(colorText2); // 恢復原來的文字顏色
                }
            }
        });


    }
}