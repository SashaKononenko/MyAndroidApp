package com.example.sasha.myapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MenuItem;
import android.widget.ToggleButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.Telephony.Mms.Part.FILENAME;

/**
 * Created by sasha on 08.04.17.
 */

public class Tab1 extends Fragment implements View.OnClickListener {
    ToggleButton second1;
    ToggleButton centiseconds1;
    ToggleButton second2;
    ToggleButton centiseconds2;
    ToggleButton second3;
    ToggleButton centiseconds3;
    ToggleButton second4;
    ToggleButton centiseconds4;
    int allNumber[][] = {{0,0,0,0},{0,0,0,0}};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.tab1, container, false);
        Button buttonMinus1 = (Button) layout.findViewById(R.id.buttonMinus1);
        buttonMinus1.setOnClickListener(this);
        Button buttonPlus1 = (Button) layout.findViewById(R.id.buttonPlus1);
        buttonPlus1.setOnClickListener(this);
        Button buttonMinus2 = (Button) layout.findViewById(R.id.buttonMinus2);
        buttonMinus2.setOnClickListener(this);
        Button buttonPlus2 = (Button) layout.findViewById(R.id.buttonPlus2);
        buttonPlus2.setOnClickListener(this);
        Button buttonMinus3 = (Button) layout.findViewById(R.id.buttonMinus3);
        buttonMinus3.setOnClickListener(this);
        Button buttonPlus3 = (Button) layout.findViewById(R.id.buttonPlus3);
        buttonPlus3.setOnClickListener(this);
        Button buttonMinus4 = (Button) layout.findViewById(R.id.buttonMinus4);
        buttonMinus4.setOnClickListener(this);
        Button buttonPlus4 = (Button) layout.findViewById(R.id.buttonPlus4);
        buttonPlus4.setOnClickListener(this);




        second1 = (ToggleButton) layout.findViewById(R.id.second1);
        second1.setOnClickListener(this);
        centiseconds1 = (ToggleButton) layout.findViewById(R.id.centiseconds1);
        centiseconds1.setOnClickListener(this);
        second2 = (ToggleButton) layout.findViewById(R.id.second2);
        second2.setOnClickListener(this);
        centiseconds2 = (ToggleButton) layout.findViewById(R.id.centiseconds2);
        centiseconds2.setOnClickListener(this);
        second3 = (ToggleButton) layout.findViewById(R.id.second3);
        second3.setOnClickListener(this);
        centiseconds3 = (ToggleButton) layout.findViewById(R.id.centiseconds3);
        centiseconds3.setOnClickListener(this);
        second4 = (ToggleButton) layout.findViewById(R.id.second4);
        second4.setOnClickListener(this);
        centiseconds4 = (ToggleButton) layout.findViewById(R.id.centiseconds4);
        centiseconds4.setOnClickListener(this);
        return layout;
    }

    ////Для zone1
    public void onClickPlus1(View view)
    {
        if (second1.isChecked())
        {
            if (allNumber[0][0] < 10)
            {
                allNumber[0][0]++;
                String s = Integer.toString(allNumber[0][0]);
                second1.setText(s);
                second1.setTextOff(s);
                second1.setTextOn(s);
            }
        }
        if (centiseconds1.isChecked())
        {
            if (allNumber[1][0] < 10)
            {
                allNumber[1][0]++;
                String s = Integer.toString(allNumber[1][0]);
                centiseconds1.setText(s);
                centiseconds1.setTextOff(s);
                centiseconds1.setTextOn(s);
            }
        }
    }
    @Override
    public void onClick(View v){
        switch (v.getId() ) {
            case R.id.buttonPlus1:
                onClickPlus1(v);
                break;
            case R.id.buttonMinus1:
                onClickMinus1(v);
                break;
            case R.id.second1:
                onClickSecond1(v);
                break;
            case R.id.centiseconds1:
                onClickCentiseconds1(v);
                break;

            case R.id.buttonPlus2:
                onClickPlus2(v);
                break;
            case R.id.buttonMinus2:
                onClickMinus2(v);
                break;
            case R.id.second2:
                onClickSecond2(v);
                break;
            case R.id.centiseconds2:
                onClickCentiseconds2(v);
                break;

            case R.id.buttonPlus3:
                onClickPlus3(v);
                break;
            case R.id.buttonMinus3:
                onClickMinus3(v);
                break;
            case R.id.second3:
                onClickSecond3(v);
                break;
            case R.id.centiseconds3:
                onClickCentiseconds3(v);
                break;

            case R.id.buttonPlus4:
                onClickPlus4(v);
                break;
            case R.id.buttonMinus4:
                onClickMinus4(v);
                break;
            case R.id.second4:
                onClickSecond4(v);
                break;
            case R.id.centiseconds4:
                onClickCentiseconds4(v);
                break;
        }
    }

    public void onClickMinus1(View view)
    {
        if (second1.isChecked())
        {
            if (allNumber[0][0] > 0)
            {
                allNumber[0][0]--;
                String s = Integer.toString(allNumber[0][0]);
                second1.setText(s);
                second1.setTextOff(s);
                second1.setTextOn(s);
            }
        }
        if (centiseconds1.isChecked())
        {
            if (allNumber[1][0] > 0)
            {
                allNumber[1][0]--;
                String s = Integer.toString(allNumber[1][0]);
                centiseconds1.setText(s);
                centiseconds1.setTextOff(s);
                centiseconds1.setTextOn(s);
            }
        }
    }

    public  void onClickSecond1(View view)
    {
        centiseconds1.setChecked(false);
    }

    public  void onClickCentiseconds1(View view)
    {
        second1.setChecked(false);
    }

    ////для zone2
    public  void onClickSecond2(View view)
    {
        centiseconds2.setChecked(false);
    }

    public  void onClickCentiseconds2(View view)
    {
        second2.setChecked(false);
    }

    public void onClickPlus2(View view)
    {
        if (second2.isChecked())
        {
            if (allNumber[0][1] < 10)
            {
                allNumber[0][1]++;
                String s = Integer.toString(allNumber[0][1]);
                second2.setText(s);
                second2.setTextOff(s);
                second2.setTextOn(s);
            }
        }
        if (centiseconds2.isChecked())
        {
            if (allNumber[1][1] < 10)
            {
                allNumber[1][1]++;
                String s = Integer.toString(allNumber[1][1]);
                centiseconds2.setText(s);
                centiseconds2.setTextOff(s);
                centiseconds2.setTextOn(s);
            }
        }
    }

    public void onClickMinus2(View view)
    {
        if (second2.isChecked())
        {
            if (allNumber[0][1] > 0)
            {
                allNumber[0][1]--;
                String s = Integer.toString(allNumber[0][1]);
                second2.setText(s);
                second2.setTextOff(s);
                second2.setTextOn(s);
            }
        }
        if (centiseconds2.isChecked())
        {
            if (allNumber[1][1] > 0)
            {
                allNumber[1][1]--;
                String s = Integer.toString(allNumber[1][1]);
                centiseconds2.setText(s);
                centiseconds2.setTextOff(s);
                centiseconds2.setTextOn(s);
            }
        }
    }

    ////Для zone3
    public  void onClickSecond3(View view)
    {
        centiseconds3.setChecked(false);
    }

    public  void onClickCentiseconds3(View view)
    {
        second3.setChecked(false);
    }

    public void onClickPlus3(View view)
    {
        if (second3.isChecked())
        {
            if (allNumber[0][2] < 10)
            {
                allNumber[0][2]++;
                String s = Integer.toString(allNumber[0][2]);
                second3.setText(s);
                second3.setTextOff(s);
                second3.setTextOn(s);
            }
        }
        if (centiseconds3.isChecked())
        {
            if (allNumber[1][2] < 10)
            {
                allNumber[1][2]++;
                String s = Integer.toString(allNumber[1][2]);
                centiseconds3.setText(s);
                centiseconds3.setTextOff(s);
                centiseconds3.setTextOn(s);
            }
        }
    }

    public void onClickMinus3(View view)
    {
        if (second3.isChecked())
        {
            if (allNumber[0][2] > 0)
            {
                allNumber[0][2]--;
                String s = Integer.toString(allNumber[0][2]);
                second3.setText(s);
                second3.setTextOff(s);
                second3.setTextOn(s);
            }
        }
        if (centiseconds3.isChecked())
        {
            if (allNumber[1][2] > 0)
            {
                allNumber[1][2]--;
                String s = Integer.toString(allNumber[1][2]);
                centiseconds3.setText(s);
                centiseconds3.setTextOff(s);
                centiseconds3.setTextOn(s);
            }
        }
    }
    //для Zone4
    public  void onClickSecond4(View view)
    {
        centiseconds4.setChecked(false);
    }

    public  void onClickCentiseconds4(View view)
    {
        second4.setChecked(false);
    }

    public void onClickPlus4(View view)
    {
        if (second4.isChecked())
        {
            if (allNumber[0][3] < 10)
            {
                allNumber[0][3]++;
                String s = Integer.toString(allNumber[0][3]);
                second4.setText(s);
                second4.setTextOff(s);
                second4.setTextOn(s);
            }
        }
        if (centiseconds4.isChecked())
        {
            if (allNumber[1][3] < 10)
            {
                allNumber[1][3]++;
                String s = Integer.toString(allNumber[1][3]);
                centiseconds4.setText(s);
                centiseconds4.setTextOff(s);
                centiseconds4.setTextOn(s);
            }
        }
    }

    public void onClickMinus4(View view)
    {
        if (second4.isChecked())
        {
            if (allNumber[0][3] > 0)
            {
                allNumber[0][3]--;
                String s = Integer.toString(allNumber[0][3]);
                second4.setText(s);
                second4.setTextOff(s);
                second4.setTextOn(s);
            }
        }
        if (centiseconds4.isChecked())
        {
            if (allNumber[1][3] > 0)
            {
                allNumber[1][3]--;
                String s = Integer.toString(allNumber[1][3]);
                centiseconds4.setText(s);
                centiseconds4.setTextOff(s);
                centiseconds4.setTextOn(s);
            }
        }
    }

    public int getTimeDownStop(){
        return (allNumber[0][0]*1000)+(allNumber[1][0]*100);
    }
    public int getTimeUpStop(){
        return (allNumber[0][1]*1000)+(allNumber[1][1]*100);
    }
    public int getTimeDown(){
        return (allNumber[0][2]*1000)+(allNumber[1][2]*100);
    }
    public int getTimeUp(){
        return (allNumber[0][3]*1000)+(allNumber[1][3]*100);
    }


    void writeFile() {
        try {
            // отрываем поток для записи
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    getActivity().openFileOutput(FILENAME, MODE_PRIVATE)));
            // пишем данные
            bw.write("Содержимое файла");
            // закрываем поток
            bw.close();
            Log.d("Ol", "Файл записан");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        writeFile();
    }
}