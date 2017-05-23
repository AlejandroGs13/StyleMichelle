package com.example.alejandrogs.stylemichelle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class EyesActivity extends AppCompatActivity {


    private ImageView img1,img2,img3,img4;
    String color="";
    Button btn;
    DBHelper dbHelper;
    private boolean seleccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eyes);
        seleccion = false;
        img1 = (ImageView)findViewById(R.id.image1);
        img2 = (ImageView)findViewById(R.id.image2);
        img3 = (ImageView)findViewById(R.id.image3);
        btn = (Button)findViewById(R.id.btn_continuar);
        dbHelper = new DBHelper(this);
        Bundle bundle = getIntent().getExtras();
        final String usu = bundle.getString("usu");
        final String con = bundle.getString("con");
        final String piel = bundle.getString("piel");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seleccion){
                    dbHelper.addusu(usu,con,piel,color,v);
                    Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                    intent.putExtra("usu",usu);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Seleccione su color de ojo",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void imgAzul(View view) {
        color = "Azul";
        seleccion = true;
        Toast.makeText(getApplicationContext(),"Color Azul",Toast.LENGTH_SHORT).show();

    }

    public void imgVerde(View view) {
        color = "Verde";
        seleccion = true;
        Toast.makeText(getApplicationContext(),"Color Verde",Toast.LENGTH_SHORT).show();
    }

    public void imgCafe(View view) {
        color = "Cafe";
        seleccion = true;
        Toast.makeText(getApplicationContext(),"Color Cafe",Toast.LENGTH_SHORT).show();
    }
}
