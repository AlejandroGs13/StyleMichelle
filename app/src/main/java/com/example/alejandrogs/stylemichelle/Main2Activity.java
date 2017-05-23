package com.example.alejandrogs.stylemichelle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private Button continuar;
    private TextView tono;
    private boolean seleccion;
    private ImageView img1,img2,img3,img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tono = (TextView)findViewById(R.id.tono);
        continuar = (Button)findViewById(R.id.btn_continuar);

        Bundle bundle = getIntent().getExtras();
        final String usu = bundle.getString("usu");
        final String con = bundle.getString("con");
        seleccion=false;
        img1 = (ImageView)findViewById(R.id.image1);
        img2 = (ImageView)findViewById(R.id.image2);
        img3 = (ImageView)findViewById(R.id.image3);
        img4 = (ImageView)findViewById(R.id.image4);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seleccion){
                    Intent continuar =new Intent(getApplicationContext(),EyesActivity.class);
                    continuar.putExtra("piel",String.valueOf(tono.getText()));
                    continuar.putExtra("usu",usu);
                    continuar.putExtra("con",con);
                    startActivity(continuar);
                }
            }
        });
    }

    public void imgBlanco(View v){
        tono.setText("Blanco");
        seleccion=true;
    }
    public void imgMoreno(View v){
        tono.setText("Moreno");
        seleccion=true;
    }
    public void imgMorenoClaro(View v){
        tono.setText("Monero Claro");
        seleccion=true;
    }
    public void imgMorenoOs(View v){
        seleccion=true;
        tono.setText("Moreno Oscuro");
    }




}
