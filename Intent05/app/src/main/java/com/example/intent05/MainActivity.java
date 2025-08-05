package com.example.intent05;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Text textview_keyword;
    EditText edittext_keyword;
    Button button_web_search, button_choice_contact;

    private static final int GET_CONTACT = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });


        edittext_keyword = findViewById(R.id.edittext_keyword);
        button_web_search = findViewById(R.id.button_web_search);
        button_choice_contact = findViewById(R.id.button_choice_contact);


        button_web_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strkeyword = edittext_keyword.getText().toString();
                Intent i = new Intent(Intent.ACTION_WEB_SEARCH);   //ACTION_WEB_SEARCH把KFC優惠丟到搜尋引擎
                i.putExtra(SearchManager.QUERY, strkeyword);   //QUERY= KFC優惠
                startActivity(i);
            }
        });

        button_choice_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType(ContactsContract.Contacts.CONTENT_TYPE);
//                startActivityForResult(i, GET_CONTACT);

                launcher_pick_contact.launch(i);
            }
        });
    }

    //新版寫法
    ActivityResultLauncher launcher_pick_contact = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                                                                             new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    Intent intent_returned_contact = o.getData();  // 取得回傳的 Intent
                    String strContact = intent_returned_contact.getData().toString();  // 從 Intent 取得聯絡人 Uri 字串

                    Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(strContact));
                    startActivity(i);
                }
            });


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == GET_CONTACT) {
//            if (resultCode == RESULT_OK) {
//                String strContact = data.getData().toString();
//
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(strContact));  //ACTION_VIEW所以會出現通訊錄畫面
//                startActivity(i);
//            }
//        }
//    }
}