package com.example.keithfawcett.fawcettkeithworkoutessentials;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import java.util.Random;


public class SoundMixerFragment extends android.support.v4.app.Fragment implements OnClickListener {


    private CountDownTimer countDownTimer;
    private final Random r = new Random();
    private boolean isRunning = false;

    private ToggleButton baseToggle1;
    private ToggleButton baseToggle2;
    private ToggleButton baseToggle3;
    private ToggleButton baseToggle4;

    private ToggleButton overlayToggle1;
    private ToggleButton overlayToggle2;
    private ToggleButton overlayToggle3;
    private ToggleButton overlayToggle4;
    private ToggleButton overlayToggle5;
    private ToggleButton overlayToggle6;
    private ToggleButton overlayToggle7;
    private ToggleButton overlayToggle8;
    private ToggleButton overlayToggle9;
    private ToggleButton overlayToggle10;
    private ToggleButton overlayToggle11;
    private ToggleButton overlayToggle12;

    private MediaPlayer clockChimes;
    private MediaPlayer crow;
    private MediaPlayer dog;
    private MediaPlayer dove;
    private MediaPlayer duck;
    private MediaPlayer falcon;
    private MediaPlayer foghorn;
    private MediaPlayer merlin;
    private MediaPlayer owl;
    private MediaPlayer rooster;
    private MediaPlayer thunder;
    private MediaPlayer train;

    private MediaPlayer ocean;
    private MediaPlayer rain;
    private MediaPlayer fire;
    private MediaPlayer crickets;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ocean = MediaPlayer.create(getActivity().getBaseContext(), R.raw.ocean);
        ocean.setLooping(true);
        rain = MediaPlayer.create(getActivity().getBaseContext(), R.raw.rain);
        rain.setLooping(true);
        fire = MediaPlayer.create(getActivity().getBaseContext(), R.raw.fire);
        fire.setLooping(true);
        crickets = MediaPlayer.create(getActivity().getBaseContext(), R.raw.crickets);
        crickets.setLooping(true);

        clockChimes = MediaPlayer.create(getActivity().getBaseContext(), R.raw.clock_chimes);
        crow = MediaPlayer.create(getActivity().getBaseContext(), R.raw.crow);
        dog = MediaPlayer.create(getActivity().getBaseContext(), R.raw.dog);
        dove = MediaPlayer.create(getActivity().getBaseContext(), R.raw.dove);
        duck = MediaPlayer.create(getActivity().getBaseContext(), R.raw.duck);
        falcon = MediaPlayer.create(getActivity().getBaseContext(), R.raw.falcon);
        foghorn = MediaPlayer.create(getActivity().getBaseContext(), R.raw.foghorn);
        merlin = MediaPlayer.create(getActivity().getBaseContext(), R.raw.merlin);
        owl = MediaPlayer.create(getActivity().getBaseContext(), R.raw.owl);
        rooster = MediaPlayer.create(getActivity().getBaseContext(), R.raw.rooster);
        thunder = MediaPlayer.create(getActivity().getBaseContext(), R.raw.thunder);
        train = MediaPlayer.create(getActivity().getBaseContext(), R.raw.train);

        ocean.start();
        rain.start();
        fire.start();
        crickets.start();
        ocean.pause();
        rain.pause();
        fire.pause();
        crickets.pause();

        baseToggle1 = (ToggleButton) view.findViewById(R.id.baseToggle1);
        baseToggle2 = (ToggleButton) view.findViewById(R.id.baseToggle2);
        baseToggle3 = (ToggleButton) view.findViewById(R.id.baseToggle3);
        baseToggle4 = (ToggleButton) view.findViewById(R.id.baseToggle4);


        overlayToggle1 = (ToggleButton) view.findViewById(R.id.overlayToggle1);
        overlayToggle2 = (ToggleButton) view.findViewById(R.id.overlayToggle2);
        overlayToggle3 = (ToggleButton) view.findViewById(R.id.overlayToggle3);
        overlayToggle4 = (ToggleButton) view.findViewById(R.id.overlayToggle4);
        overlayToggle5 = (ToggleButton) view.findViewById(R.id.overlayToggle5);
        overlayToggle6 = (ToggleButton) view.findViewById(R.id.overlayToggle6);
        overlayToggle7 = (ToggleButton) view.findViewById(R.id.overlayToggle7);
        overlayToggle8 = (ToggleButton) view.findViewById(R.id.overlayToggle8);
        overlayToggle9 = (ToggleButton) view.findViewById(R.id.overlayToggle9);
        overlayToggle10 = (ToggleButton) view.findViewById(R.id.overlayToggle10);
        overlayToggle11 = (ToggleButton) view.findViewById(R.id.overlayToggle11);
        overlayToggle12 = (ToggleButton) view.findViewById(R.id.overlayToggle12);

        baseToggle1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(baseToggle1.isChecked()){
                    ocean.start();
                    rain.pause();
                    fire.pause();
                    crickets.pause();
                    baseToggle2.setChecked(false);
                    baseToggle3.setChecked(false);
                    baseToggle4.setChecked(false);
                }else {
                    ocean.pause();
                }
            }
        });

        baseToggle2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(baseToggle2.isChecked()){
                    ocean.pause();
                    rain.start();
                    fire.pause();
                    crickets.pause();
                    baseToggle1.setChecked(false);
                    baseToggle3.setChecked(false);
                    baseToggle4.setChecked(false);
                }else {
                    rain.pause();

                }
            }
        });

        baseToggle3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(baseToggle3.isChecked()){
                    ocean.pause();
                    rain.pause();
                    fire.start();
                    crickets.pause();
                    baseToggle1.setChecked(false);
                    baseToggle2.setChecked(false);
                    baseToggle4.setChecked(false);
                }else {
                    fire.pause();

                }
            }
        });

        baseToggle4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(baseToggle4.isChecked()){
                    ocean.pause();
                    rain.pause();
                    fire.pause();
                    crickets.start();
                    baseToggle1.setChecked(false);
                    baseToggle2.setChecked(false);
                    baseToggle3.setChecked(false);
                }else {
                    crickets.pause();

                }
            }
        });


        overlayToggle1.setOnClickListener(this);
        overlayToggle2.setOnClickListener(this);
        overlayToggle3.setOnClickListener(this);
        overlayToggle4.setOnClickListener(this);
        overlayToggle5.setOnClickListener(this);
        overlayToggle6.setOnClickListener(this);
        overlayToggle7.setOnClickListener(this);
        overlayToggle8.setOnClickListener(this);
        overlayToggle9.setOnClickListener(this);
        overlayToggle10.setOnClickListener(this);
        overlayToggle11.setOnClickListener(this);
        overlayToggle12.setOnClickListener(this);




    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ocean.pause();
        rain.pause();
        fire.pause();
        crickets.pause();
        if(countDownTimer != null) {
            countDownTimer.cancel();
        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sound_mixer_main, container, false);
    }

    @Override
    public void onClick(View view) {
        if(!overlayToggle1.isChecked() && !overlayToggle2.isChecked() && !overlayToggle3.isChecked() && !overlayToggle4.isChecked()
                && !overlayToggle5.isChecked() && !overlayToggle6.isChecked() && !overlayToggle7.isChecked() && !overlayToggle8.isChecked()
                && !overlayToggle9.isChecked() && !overlayToggle10.isChecked() && !overlayToggle11.isChecked() && !overlayToggle12.isChecked()){
            countDownTimer.cancel();
            isRunning = false;
        }else if(!isRunning) {

            int randomTime = r.nextInt(30) + 15;



            countDownTimer = new CountDownTimer(randomTime * 1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    playRandomSound();
                }

                private void playRandomSound() {
                    int randomSound = r.nextInt(11);

                    if(randomSound == 0 && overlayToggle1.isChecked()){
                        clockChimes.start();
                        countDownTimer.start();
                    }else if(randomSound == 1 && overlayToggle2.isChecked()){
                        crow.start();
                        countDownTimer.start();
                    }else if(randomSound == 2 && overlayToggle3.isChecked()){
                        dog.start();
                        countDownTimer.start();
                    }else if(randomSound == 3 && overlayToggle4.isChecked()){
                        dove.start();
                        countDownTimer.start();
                    }else if(randomSound == 4 && overlayToggle5.isChecked()){
                        duck.start();
                        countDownTimer.start();
                    }else if(randomSound == 5 && overlayToggle6.isChecked()){
                        falcon.start();
                        countDownTimer.start();
                    }else if(randomSound == 6 && overlayToggle7.isChecked()){
                        foghorn.start();
                        countDownTimer.start();
                    }else if(randomSound == 7 && overlayToggle8.isChecked()){
                        merlin.start();
                        countDownTimer.start();
                    }else if(randomSound == 8 && overlayToggle9.isChecked()){
                        owl.start();
                        countDownTimer.start();
                    }else if(randomSound == 9 && overlayToggle10.isChecked()){
                        rooster.start();
                        countDownTimer.start();
                    }else if(randomSound == 10 && overlayToggle11.isChecked()){
                        thunder.start();
                        countDownTimer.start();
                    }else if(randomSound == 11 && overlayToggle12.isChecked()){
                        train.start();
                        countDownTimer.start();
                    }else{
                        playRandomSound();
                    }
                }
            };

            countDownTimer.start();
            isRunning = true;
        }

    }


}
