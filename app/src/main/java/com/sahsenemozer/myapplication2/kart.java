package com.sahsenemozer.myapplication2;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

public class kart extends AppCompatButton {
    boolean acikMi = false;
    boolean cevirilebilir = true;
    int resimID;
    int arkaPlanID;
    int onPlanID=0;
    Drawable arka;
    Drawable on;

    public kart(Context context,int id) {
        super(context);
        setId(id);
        arkaPlanID = R.drawable.fonresim;
        int onPlanID=0;
        if(id%8 == 1)
            onPlanID = R.drawable.cartman;
        if(id%8 == 2)
            onPlanID = R.drawable.kyle;
        if(id%8 == 3)
            onPlanID = R.drawable.kenny;
        if(id%8 == 4)
            onPlanID = R.drawable.stan;
        if(id%8 == 5)
            onPlanID = R.drawable.archives;
        if(id%8 == 6)
            onPlanID = R.drawable.clyde;
        if(id%8 == 7)
            onPlanID = R.drawable.randy;
        if(id%8 == 0)
            onPlanID = R.drawable.stevens;
        arka = ContextCompat.getDrawable(context,arkaPlanID);
        on = ContextCompat.getDrawable(context,onPlanID);
        setBackground(arka);
    }

    public void cevir(){
        if(cevirilebilir) {
            if (!acikMi) {
                setBackground(on);
                acikMi = true;
            } else {
                setBackground(arka);
                acikMi = false;

            }

        }


    }
}