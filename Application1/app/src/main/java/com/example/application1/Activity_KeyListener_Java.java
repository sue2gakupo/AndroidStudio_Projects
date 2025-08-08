package com.example.application1;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.security.Key;

public class Activity_KeyListener_Java extends AppCompatActivity {

    Button btn_add; //這裡的btn_add是指XML檔案中的Button元件，所以要跟button的id名一樣

    TextView textview_add, textview_answer;

    EditText edittext_input01, edittext_input02;

    String strKeyArray[] = new String[10];

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edittext_java);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        btn_add = findViewById(R.id.btn_add);
        textview_add = findViewById(R.id.textView_add);
        textview_answer = findViewById(R.id.textView_answer);
        edittext_input01 = findViewById(R.id.edittext_input01);
        edittext_input02 = findViewById(R.id.edittext_input02);

        textview_answer.setVisibility(View.INVISIBLE);
        edittext_input02.setVisibility(View.INVISIBLE);
        btn_add.setVisibility(View.INVISIBLE);  //設定INVISIBLE，可以讓UI元件不出現，不會遮蓋住其他元件

        for (i = 0; i < strKeyArray.length; i++) {
            strKeyArray[i] = new String("when you press key: " + i);
        }


        edittext_input01.setKeyListener(new KeyListener() {
            @Override
            public int getInputType() {
                return 0;
            }

            @Override
            public boolean onKeyDown(View view, Editable text, int keyCode, KeyEvent event) {
               //檢查是否為按鍵按下事件
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    //清除輸入框的提示文字
                    edittext_input01.setHint("");
                    // 將keyCode轉換為0-9的數字
                    // keyCode減7是因為Android鍵盤事件的keyCode從7開始，將系統鍵碼值轉換為0-9的數字
//                  edittext_input01.setText(new Integer(keyCode -7).toString());
                    Integer integerkey = new Integer(keyCode - 7);
                    String outputString = integerkey.toString();
                    // 在輸入框顯示按下的數字
                    edittext_input01.setText(outputString);

//                  textview_add.setText(":" + strKeyArray[keyCode - 7]);
                    // 計算陣列索引
                    int indexkeyMessage = keyCode - 7;
                    // 在TextView中顯示對應的訊息
                    textview_add.setText(":" + strKeyArray[indexkeyMessage]);

                    return true;// 表示已處理此事件，不需要往下傳遞
                }
                return false;
            }

            @Override
            public boolean onKeyUp(View view, Editable text, int keyCode, KeyEvent event) {
                return false;
            }

            @Override
            public boolean onKeyOther(View view, Editable text, KeyEvent event) {
                return false;
            }

            @Override
            public void clearMetaKeyState(View view, Editable content, int states) {

            }
        });


    }
}