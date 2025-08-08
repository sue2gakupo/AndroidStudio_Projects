package com.example.application1;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckedTextView mCheckedTextView01,mCheckedTextView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hw_linearlayout);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });



//        mCheckedTextView01 =(CheckedTextView) findViewById(R.id.checkedTextView01);
//        mCheckedTextView01.setChecked(true);
//        mCheckedTextView01.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v) {
//                mCheckedTextView01.toggle();
//            }
//        });
//
//        mCheckedTextView02 = (CheckedTextView) findViewById(R.id.checkedTextView02);
//        mCheckedTextView02.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v) {
//                mCheckedTextView02.toggle();
//            }
//        });



    }
}