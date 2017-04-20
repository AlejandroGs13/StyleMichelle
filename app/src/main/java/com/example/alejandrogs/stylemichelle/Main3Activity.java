package com.example.alejandrogs.stylemichelle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private TextView tono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle = getIntent().getExtras();
        String extra = bundle.getString("extra");
        tono = (TextView)findViewById(R.id.tono);
        tono.setText(extra);
    }
}
