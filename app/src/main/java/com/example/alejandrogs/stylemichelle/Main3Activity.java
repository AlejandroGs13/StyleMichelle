package com.example.alejandrogs.stylemichelle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    CheckBox blush,lips,eyes;
    Button continuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();
        final String usu = bundle.getString("usu");

        blush = (CheckBox)findViewById(R.id.cBlush);
        lips = (CheckBox)findViewById(R.id.cLabial);
        eyes = (CheckBox)findViewById(R.id.cSombras);

        continuar = (Button)findViewById(R.id.btn_continuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( blush.isChecked() ||
                        lips.isChecked() ||
                        eyes.isChecked()
                        ){
                    Intent intent =new Intent(getApplicationContext(),Combinaciones.class);
                    if (blush.isChecked()){
                        intent.putExtra("blush","yes");
                    }else {
                        intent.putExtra("blush","no");
                    }
                    if (lips.isChecked()){
                        intent.putExtra("lips","yes");
                    }else{
                        intent.putExtra("lips","no");
                    }
                    if (eyes.isChecked()){
                        intent.putExtra("eyes","yes");
                    }else{
                        intent.putExtra("eyes","no");
                    }
                    intent.putExtra("usu",usu);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Seleccione a lo menos una opcion",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
