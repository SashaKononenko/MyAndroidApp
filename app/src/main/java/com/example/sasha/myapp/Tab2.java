package com.example.sasha.myapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.provider.Telephony.Mms.Part.FILENAME;

/**
 * Created by sasha on 08.04.17.
 */

public class Tab2 extends Fragment implements View.OnClickListener {
    ImageView body;
    Animation bodyTurnDown;
    Animation bodyTurnUp;
    Button start;
    AnimationSet set;
    TextView score;

    boolean animationWork = false;
    private int scoreNumber;
    private int timeDown;
    private int timeUp;
    private int timeDownStop;
    private int timeUpStop;

    public void setTimeUpStop(int timeUpStop) {
        this.timeUpStop = timeUpStop;
    }

    public void setTimeDown(int timeDown) {
        this.timeDown = timeDown;
    }

    public void setTimeUp(int timeUp) {
        this.timeUp = timeUp;
    }

    public void setTimeDownStop(int timeDownStop) {
        this.timeDownStop = timeDownStop;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2, container, false);
        start = (Button) rootView.findViewById(R.id.start);
        start.setOnClickListener(this);
        score = (TextView) rootView.findViewById(R.id.score);
        body = (ImageView) rootView.findViewById(R.id.body);
        bodyTurnDown = AnimationUtils.loadAnimation(getContext(), R.anim.body_turn_down);
        bodyTurnUp = AnimationUtils.loadAnimation(getContext(), R.anim.body_turn_up);
        return rootView;
    }

    @Override
    public void onClick(View v){
        switch (v.getId() ) {
            case R.id.start:
                onClickStart(v);
                break;
        }
    }

    public void onClickStart(View v){
        if (animationWork == false) {
            animationWork = true;

            bodyTurnDown.setStartOffset(timeUpStop);
            bodyTurnDown.setDuration(timeDown);
            bodyTurnUp.setStartOffset(timeDownStop);
            bodyTurnUp.setDuration(timeUp);
            body.startAnimation(bodyTurnDown);
            scoreNumber = 0;
            score.setText("" + (scoreNumber));

            bodyTurnDown.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (animationWork == true)
                        body.startAnimation(bodyTurnUp);


                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            bodyTurnUp.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    scoreNumber++;
                    score.setText("" + (scoreNumber));
                    if(animationWork == true)
                        body.startAnimation(bodyTurnDown);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            start.setText(getString(R.string.stop));
        }
        else{
            stop();
        }
    }

    void stop(){
        bodyTurnDown.cancel();
        bodyTurnUp.cancel();
        body.clearAnimation();
        //body.animate().cancel();
        animationWork = false;
        start.setText(getString(R.string.start));
    }

    void readFile() {
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    getActivity().openFileInput(FILENAME)));
            String str = "";
            // читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d("Ok", str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}