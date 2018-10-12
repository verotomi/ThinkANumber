package com.example.diak.thinkanumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button Button_plus, Button_minus, Button_kuldes;
    private TextView Text_View1, Text_View2;
    private ImageView Image_View1, Image_View2, Image_View3, Image_View4, Image_View5;
    private int szam=0, veletlenszam = 0, eletekszama=0;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        veletlenszam = rand.nextInt(10);
        eletekszama = 5;

        Button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (szam==10) {
                    Toast.makeText(MainActivity.this, "Elértük a maximumot! (" + szam + ")", Toast.LENGTH_SHORT).show();
                }
                else {
                    Text_View1.setText("" + ++szam);
                }
            }
        });

        Button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (szam==0) {
                    Toast.makeText(MainActivity.this, "Elértük a minimumot! (" + szam + ")", Toast.LENGTH_SHORT).show();
                }
                else {
                    Text_View1.setText("" + --szam);
                }
            }
        });

        Button_kuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vegevanmar();
                osszehasonlit();
            }
        });
    }

    public void init() {
        Button_minus = (Button) findViewById(R.id.Button_minus); // ctrl+D - duplicate!!
        Button_plus = (Button) findViewById(R.id.Button_plus);
        Button_kuldes = (Button) findViewById(R.id.Button_kuldes);
        Text_View1 = (TextView) findViewById(R.id.Text_View1);
        Text_View2 = (TextView) findViewById(R.id.Text_View2);
        Image_View1 = (ImageView) findViewById(R.id.Image_View1);
        Image_View2 = (ImageView) findViewById(R.id.Image_View2);
        Image_View3 = (ImageView) findViewById(R.id.Image_View3);
        Image_View4 = (ImageView) findViewById(R.id.Image_View4);
        Image_View5 = (ImageView) findViewById(R.id.Image_View5);
    }
    public void osszehasonlit(){
        if (veletlenszam == Double.parseDouble(Text_View1.getText().toString())) {
            Toast.makeText(MainActivity.this, "Gratulálok, nyertél", Toast.LENGTH_SHORT).show();
            Button_kuldes.setEnabled(false);
            Button_plus.setEnabled(false);
            Button_minus.setEnabled(false);
        }
        else if (veletlenszam > Double.parseDouble(Text_View1.getText().toString())){
            Toast.makeText(MainActivity.this, "Feljebb", Toast.LENGTH_SHORT).show();
            eletet_csokkent();
        }
        else if (veletlenszam < Double.parseDouble(Text_View1.getText().toString())){
            Toast.makeText(MainActivity.this, "Lejjebb", Toast.LENGTH_SHORT).show();
            eletet_csokkent();
        }
    }
    public void vegevanmar(){
        if (eletekszama == 0){
            Toast.makeText(MainActivity.this, "Vesztettél!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    public void eletet_csokkent(){
        switch (eletekszama)
        {
            case 5:
                eletekszama--;
                vegevanmar();
                Image_View1.setBackgroundResource(R.drawable.heart1);
                break;
            case 4:
                eletekszama--;
                vegevanmar();
                Image_View2.setBackgroundResource(R.drawable.heart1);
                break;
            case 3:
                eletekszama--;
                vegevanmar();
                Image_View3.setBackgroundResource(R.drawable.heart1);
                break;
            case 2:
                eletekszama--;
                vegevanmar();
                Image_View4.setBackgroundResource(R.drawable.heart1);
                break;
            case 1:
                eletekszama--;
                vegevanmar();
                Image_View5.setBackgroundResource(R.drawable.heart1);
                break;

        }
    }
}
