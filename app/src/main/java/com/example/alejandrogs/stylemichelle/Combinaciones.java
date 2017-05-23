package com.example.alejandrogs.stylemichelle;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Combinaciones extends AppCompatActivity {
    TextView label,label2;
    ImageView image1,image2,image3;
    DBHelper dbHelper;
    String color;
    String piel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinaciones);

        Bundle bundle = getIntent().getExtras();
        String usu = bundle.getString("usu");
        String lips = bundle.getString("lips");
        String blush = bundle.getString("blush");
        String eyes = bundle.getString("eyes");

        dbHelper = new DBHelper(this);
        image1 = (ImageView)findViewById(R.id.image1);
        image2 = (ImageView)findViewById(R.id.image2);
        image3 = (ImageView)findViewById(R.id.image3);

        label = (TextView)findViewById(R.id.label);
        label2 = (TextView)findViewById(R.id.label2);
         color = dbHelper.getOjo(usu);
         piel = dbHelper.getPiel(usu);

        if (lips.equals("yes")){
                    lips();
        }else {
            label2.setText("");
        }
        if (blush.equals("yes")){
            blush();
        }else {
            label.setText("");
        }
        if (eyes.equals("yes")){
                eyes();
        }
    }

    public void lips(){
        if (piel.equals("Blanco")){
            image3.setImageResource(R.drawable.lipstickclaro);
        }
        if (piel.equals("Moreno")){
            image3.setImageResource(R.drawable.lipstickmedio);
        }
        if (piel.equals("Moreno Claro")){
            image3.setImageResource(R.drawable.lipstickoliva);
        }

        if (piel.equals("Moreno Oscuro")){
            image3.setImageResource(R.drawable.lipstickoscuro);
        }
    }

    public void blush(){
        if (piel.equals("Blanco")){
            image2.setImageResource(R.drawable.blushblanca);
        }
        if (piel.equals("Moreno")){
            image2.setImageResource(R.drawable.blushmorena);
        }
        if (piel.equals("Moreno Claro")){
            image2.setImageResource(R.drawable.blushmedia);
        }

        if (piel.equals("Moreno Oscuro")){
            image2.setImageResource(R.drawable.blushoscura);
        }
    }

    public void eyes(){
        if (color.equals("Azul")){
            image1.setImageResource(R.drawable.ojosazules);
        }
        if (color.equals("Verde")){
            image1.setImageResource(R.drawable.ojosverdes);
        }
        if (color.equals("Cafe")){
            image1.setImageResource(R.drawable.ojoscafes);
        }

    }
}
