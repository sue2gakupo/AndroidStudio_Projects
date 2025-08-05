package com.example.intent02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edittext_input_c;

    Button button_ctoF;


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


        button_ctoF = findViewById(R.id.button_ctoF);
        edittext_input_c = findViewById(R.id.edittext_input_c);

        button_ctoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_Call_TemperatureF = new Intent(MainActivity.this, ActivityTemperatureF.class); //MainActivity呼叫端，ActivityTemperatureF被呼叫端

                Bundle bundle_TempC = new Bundle();
                bundle_TempC.putString("TEMP_C_01", edittext_input_c.getText().toString());

                intent_Call_TemperatureF.putExtras(bundle_TempC);  //putExtras可以把(bundle_TempC)附加到intent_Call_TemperatureF

                startActivity(intent_Call_TemperatureF);
            }
        });








    }
}