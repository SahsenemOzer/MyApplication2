package com.sahsenemozer.myapplication2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    int sonKart=0;
    int skor = 0;
    int hata = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(s);
        GridLayout  gl =  (GridLayout) findViewById(R.id.kartlar);
        kart kartlar[] = new kart[16];
        for (int j=1;j<=16;j++){
            kartlar[j-1]=new kart (this,j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kart k = (kart)v;
                    k.cevir();
                    if(sonKart>0){
                        kart k2 = (kart)findViewById(sonKart);
                        //k2.cevir();
                        if(k2.onPlanID== k.onPlanID && k2.getId()!= k.getId()){
                            k2.cevirilebilir=false;
                            k.cevirilebilir=false;
                            skor++;
                            //TextView tv = (TextView) findViewById(R.id.text3View);
                            if(skor==8){
                                //oyun bitti
                            }

                        }
                        else{
                            //Eslesmediler iki kartı da geri cevir
                            hata++;
                            k.cevir();
                            k2.cevir();
                            sonKart=0;
                        }
                    }
                    else{
                        sonKart = k.getId();

                    }
                }
            });


            }

        for (int j=0;j<16;j++)    {
            int rg =(int)(Math.random()*16);
            kart k = kartlar[rg];
            kartlar[rg]=kartlar[j];
            kartlar[j]=k;
        }

        for (int j=0;j<16;j++){
            gl.addView(kartlar[j]);

          }
        }

    }
