package com.example.alejandrogs.stylemichelle;

import android.content.Intent;
import android.support.v4.app.AppLaunchChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editUsu,editPass;
    private Button login,regitrar;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        editPass = (EditText)findViewById(R.id.edit_pass);
        editUsu = (EditText)findViewById(R.id.edit_usu);
        login = (Button)findViewById(R.id.btn_login);
        regitrar = (Button)findViewById(R.id.btn_registrar);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (editPass.getText().toString().equals(
                            dbHelper.getUsuario(editUsu.getText().toString(),v)) && !editUsu.getText().toString().equals("")
                    ){
                        Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                        intent.putExtra("usu",editUsu.getText().toString());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"Error al logearse",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        );

        regitrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DatosActivity.class);
                startActivity(intent);
            }
        });
    }





}
