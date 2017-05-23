package com.example.alejandrogs.stylemichelle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosActivity extends AppCompatActivity {

    Button continuar;
    EditText usu,con,con2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);


        continuar = (Button)findViewById(R.id.btn_continuar);
        usu = (EditText)findViewById(R.id.edit_usu);
        con = (EditText)findViewById(R.id.edit_pass);
        con2 = (EditText)findViewById(R.id.edit_pass2);


        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (con.getText().toString().equals(con2.getText().toString())) {
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.putExtra("usu", usu.getText().toString());
                    intent.putExtra("con", con.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
