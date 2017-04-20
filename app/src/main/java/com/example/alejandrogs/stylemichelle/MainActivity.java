package com.example.alejandrogs.stylemichelle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editUsu,editPass;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPass = (EditText)findViewById(R.id.edit_pass);
        editUsu = (EditText)findViewById(R.id.edit_usu);
        login = (Button)findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(editPass.getText()).equals("mich")&&
                        String.valueOf(editUsu.getText()).equals("mich")){
                    continuar();
                }else{
                    Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void continuar(){
        Intent continuar = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(continuar);
    }



}
