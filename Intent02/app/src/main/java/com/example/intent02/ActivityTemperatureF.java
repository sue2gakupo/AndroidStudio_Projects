package com.example.intent02;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTemperatureF extends AppCompatActivity {


    Button button_close;

    TextView textview_temp_f;

    Double c, f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temperature_f);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        textview_temp_f = findViewById(R.id.textview_temp_f);
        button_close = findViewById(R.id.button_close);

        Intent intent_getFromMainActivity = ActivityTemperatureF.this.getIntent();
        Bundle bundle_getTempC = intent_getFromMainActivity.getExtras(); //取出bundle_TempC

        if (bundle_getTempC != null) {   //檢查是不是null值
            String stringTempC = bundle_getTempC.getString("TEMP_C_01");
            c = Double.parseDouble(stringTempC);  //parseDouble轉換成雙精度浮點數，因為字串不行計算
            f = ((9.0 * c) / 5) + 32;  //華氏溫度 = (攝氏溫度 * 9/5) + 32
            textview_temp_f.setText("轉換後的華氏溫度為: " + f.toString());
        } else {
            textview_temp_f.setText("發生錯誤，Bundle物件為Null!!");
        }

        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}