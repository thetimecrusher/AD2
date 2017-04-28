package com.example.keithfawcett.fawcettkeithworkoutessentials;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;


public class TimersFragment extends android.support.v4.app.Fragment {


    private CountDownTimer countDownTimer;
    private CountDownTimer countDownTimer2;
    private String selectedTimer = "stopwatch";

    private TextView line1counter;
    private TextView line1Description;
    private TextView line2counter;
    private TextView line2Description;
    private TextView line3counter;
    private TextView line3Description;

    private LinearLayout line1;
    private LinearLayout line2;
    private LinearLayout line3;

    private LinearLayout background;


    private Long line1Amount = 0L;
    private Long line2Amount = 0L;
    private Long line3Amount = 1L;



    private Long startTime;
    private Handler mHandler;
    private TextView timeCounter;
    private Button startButton;
    private Button stopButton;
    private String startStop = "start";
    private Long stopTime = 0L;
    private Long countDownTimeLeft = 0L;
    private Long countDownTimeLeft2 = 0L;
    private Long rounds = 1L;
    private String workRest = "work";


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Timers");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timers_main, container, false);


        final MediaPlayer timerEndSound = MediaPlayer.create(getActivity().getBaseContext(), R.raw.timer_end_sound);

        Button line1Subtract = (Button) view.findViewById(R.id.button_subtract_1);
        Button line1Add = (Button) view.findViewById(R.id.button_add_1);
        Button line2Subtract = (Button) view.findViewById(R.id.button_subtract_2);
        Button line2Add = (Button) view.findViewById(R.id.button_add_2);
        Button line3Subtract = (Button) view.findViewById(R.id.button_subtract_3);
        Button line3Add = (Button) view.findViewById(R.id.button_add_3);

        line1counter = (TextView) view.findViewById(R.id.tv_counter_1);
        line1Description = (TextView) view.findViewById(R.id.tv_description_1);
        line2counter = (TextView) view.findViewById(R.id.tv_counter_2);
        line2Description = (TextView) view.findViewById(R.id.tv_description_2);
        line3counter = (TextView) view.findViewById(R.id.tv_counter_3);
        line3Description = (TextView) view.findViewById(R.id.tv_description_3);

        line1 = (LinearLayout) view.findViewById(R.id.chooser_line_1);
        line2= (LinearLayout) view.findViewById(R.id.chooser_line_2);
        line3 = (LinearLayout) view.findViewById(R.id.chooser_line_3);

        background = (LinearLayout) view.findViewById(R.id.background);

        line1.setVisibility(View.INVISIBLE);
        line2.setVisibility(View.INVISIBLE);
        line3.setVisibility(View.INVISIBLE);


        mHandler = new Handler();




        timeCounter = (TextView) view.findViewById(R.id.textView_Timer);
        startButton = (Button) view.findViewById(R.id.start_button);
        stopButton = (Button) view.findViewById(R.id.stop_button);
        stopButton.setVisibility(View.INVISIBLE);
        Button resetButton = (Button) view.findViewById(R.id.reset_button);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.TimersArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    selectedTimer = "stopwatch";
                    line1.setVisibility(View.INVISIBLE);
                    line2.setVisibility(View.INVISIBLE);
                    line3.setVisibility(View.INVISIBLE);
                }else if(position == 1){
                    selectedTimer = "countdown";
                    line1.setVisibility(View.VISIBLE);
                    line2.setVisibility(View.VISIBLE);
                    line3.setVisibility(View.INVISIBLE);
                    line1Description.setText(R.string.minutes);
                    line2Description.setText(R.string.seconds);
                }else if(position == 2) {
                    selectedTimer = "resetting";
                    line1.setVisibility(View.VISIBLE);
                    line2.setVisibility(View.VISIBLE);
                    line3.setVisibility(View.VISIBLE);
                    line1Description.setText(R.string.minutes);
                    line2Description.setText(R.string.seconds);
                    line3Description.setText(R.string.rounds);
                }else if(position == 3) {
                    selectedTimer = "interval";
                    line1.setVisibility(View.VISIBLE);
                    line2.setVisibility(View.VISIBLE);
                    line3.setVisibility(View.VISIBLE);
                    line1Description.setText(R.string.seconds_work);
                    line2Description.setText(R.string.seconds_rest);
                    line3Description.setText(R.string.rounds);
                    workRest = "work";
                }

                mHandler.removeCallbacks(mRunnable);
                if(countDownTimer != null){
                    countDownTimer.cancel();
                }
                timeCounter.setText(R.string.defaultTime);
                stopTime = 0L;
                startStop = "start";
                startButton.setText(R.string.start);
                line1Amount = 0L;
                line1counter.setText("0");
                line2Amount = 0L;
                line2counter.setText("0");
                line3Amount = 1L;
                line3counter.setText("1");
                rounds = 1L;
                countDownTimeLeft = 0L;
                countDownTimeLeft2 = 0L;
                startButton.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        line1Subtract.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (line1Amount != 0) {
                        line1Amount -= 1;
                        line1counter.setText(Long.toString(line1Amount));
                    }
            }
        });

        line1Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    line1Amount += 1;
                    line1counter.setText(Long.toString(line1Amount));
            }
        });

        line2Subtract.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.equals(selectedTimer, "interval")) {
                    if (line2Amount != 0) {
                        line2Amount -= 5;
                        line2counter.setText(Long.toString(line2Amount));
                    }
                }else {
                    if (line2Amount != 0) {
                        line2Amount -= 1;
                        line2counter.setText(Long.toString(line2Amount));
                    }
                }
            }
        });

        line2Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!Objects.equals(selectedTimer, "interval")) {
                        line2Amount += 5;
                        line2counter.setText(Long.toString(line2Amount));
                }else{
                        line2Amount += 1;
                        line2counter.setText(Long.toString(line2Amount));
                }
            }
        });

        line3Subtract.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (line3Amount != 1) {
                        line3Amount -= 1;
                        line3counter.setText(Long.toString(line3Amount));
                    }
            }
        });

        line3Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    line3Amount += 1;
                    line3counter.setText(Long.toString(line3Amount));
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {


                if(countDownTimeLeft == 0) {
                    if(selectedTimer.equals("interval")){
                        countDownTimeLeft = line1Amount;
                    }else {
                        countDownTimeLeft = line1Amount * 60L + line2Amount;
                    }
                }
                if(countDownTimeLeft2 == 0){
                    countDownTimeLeft2 = line2Amount;
                }

                if (rounds == 1) {
                    rounds = line3Amount;
                }

                countDownTimer = new CountDownTimer(countDownTimeLeft * 1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        countDownTimeLeft = l / 1000;
                        timeCounter.setText(String.format("%02d:%02d" ,countDownTimeLeft/60, countDownTimeLeft % 60));
                    }

                    @Override
                    public void onFinish() {
                        if (selectedTimer.equals("interval")) {
                            workRest = "rest";
                            timerEndSound.start();
                            background.setBackgroundColor(Color.RED);
                            countDownTimer2.start();
                        } else {

                            if (rounds > 1) {
                                rounds--;
                                timerEndSound.start();
                                countDownTimer.start();
                            } else {
                                timeCounter.setText(R.string.done);
                                countDownTimeLeft = 0L;
                                startButton.setVisibility(View.VISIBLE);
                                stopButton.setVisibility(View.INVISIBLE);
                                timerEndSound.start();

                            }
                        }
                    }
                };

                countDownTimer2 = new CountDownTimer(countDownTimeLeft2 * 1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        countDownTimeLeft2 = l / 1000;
                        timeCounter.setText(String.format("%02d:%02d" ,countDownTimeLeft2/60, countDownTimeLeft2 % 60));
                    }

                    @Override
                    public void onFinish() {
                        if (selectedTimer.equals("interval")) {
                            if(rounds == 1){
                                timeCounter.setText(R.string.done);
                                countDownTimeLeft = 0L;
                                countDownTimeLeft2 = 0L;
                                workRest = "work";
                                startButton.setVisibility(View.VISIBLE);
                                stopButton.setVisibility(View.INVISIBLE);
                                background.setBackgroundColor(Color.WHITE);
                                timerEndSound.start();
                            }else {
                                workRest = "work";
                                rounds --;
                                background.setBackgroundColor(Color.GREEN);
                                timerEndSound.start();
                                countDownTimer.start();
                            }
                        }
                    }
                };




                    switch(selectedTimer){
                        case "stopwatch":
                            mHandler.postDelayed(mRunnable, 10L);
                            startTime = System.currentTimeMillis();
                            startButton.setVisibility(View.INVISIBLE);
                            stopButton.setVisibility(View.VISIBLE);
                            break;
                        case "countdown":
                            countDownTimer.start();
                            startButton.setVisibility(View.INVISIBLE);
                            stopButton.setVisibility(View.VISIBLE);
                            break;
                        case "resetting":
                            countDownTimer.start();
                            startButton.setVisibility(View.INVISIBLE);
                            stopButton.setVisibility(View.VISIBLE);
                            break;
                        case "interval":
                            if(workRest.equals("work")) {
                                background.setBackgroundColor(Color.GREEN);
                                countDownTimer.start();
                            }else if (workRest.equals("rest")) {
                                background.setBackgroundColor(Color.RED);
                                countDownTimer2.start();
                            }
                            startButton.setVisibility(View.INVISIBLE);
                            stopButton.setVisibility(View.VISIBLE);
                            break;
                    }


                    stopButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            switch(selectedTimer){
                                case "stopwatch":
                                    mHandler.removeCallbacks(mRunnable);
                                    startButton.setVisibility(View.VISIBLE);
                                    stopButton.setVisibility(View.INVISIBLE);
                                    stopTime = System.currentTimeMillis() - startTime + stopTime;
                                    break;
                                case "countdown":
                                    startButton.setVisibility(View.VISIBLE);
                                    stopButton.setVisibility(View.INVISIBLE);
                                    countDownTimer.cancel();
                                    break;
                                case "resetting":
                                    startButton.setVisibility(View.VISIBLE);
                                    stopButton.setVisibility(View.INVISIBLE);
                                    countDownTimer.cancel();
                                    break;
                                case "interval":
                                    startButton.setVisibility(View.VISIBLE);
                                    stopButton.setVisibility(View.INVISIBLE);
                                    if(countDownTimer != null){
                                        countDownTimer.cancel();
                                    }
                                    if(countDownTimer2 != null){
                                        countDownTimer2.cancel();
                                    }
                                    break;
                            }

                        }
                    });


                }

        });





        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch(selectedTimer){
                    case "stopwatch":
                        mHandler.removeCallbacks(mRunnable);
                        timeCounter.setText(R.string.defaultTime);
                        stopTime = 0L;
                        startStop = "start";
                        startButton.setText(R.string.start);
                        startButton.setVisibility(View.VISIBLE);
                        stopButton.setVisibility(View.INVISIBLE);
                        break;
                    case "countdown":
                        if(countDownTimer != null) {
                            countDownTimer.cancel();
                        }
                        startButton.setVisibility(View.VISIBLE);
                        stopButton.setVisibility(View.INVISIBLE);
                        countDownTimeLeft = line1Amount * 60L + line2Amount;
                        timeCounter.setText(String.format("%02d:%02d" ,countDownTimeLeft/60, countDownTimeLeft % 60));
                        break;
                    case "resetting":
                        if(countDownTimer != null) {
                            countDownTimer.cancel();
                        }
                        startButton.setVisibility(View.VISIBLE);
                        stopButton.setVisibility(View.INVISIBLE);
                        countDownTimeLeft = line1Amount * 60L + line2Amount;
                        timeCounter.setText(String.format("%02d:%02d" ,countDownTimeLeft/60, countDownTimeLeft % 60));
                        break;
                    case "interval":
                        if(countDownTimer != null) {
                            countDownTimer.cancel();
                        }
                        startButton.setVisibility(View.VISIBLE);
                        stopButton.setVisibility(View.INVISIBLE);
                        workRest = "work";
                        background.setBackgroundColor(Color.WHITE);
                        countDownTimeLeft = line1Amount;
                        countDownTimeLeft2 = line2Amount;
                        timeCounter.setText(String.format("%02d:%02d" ,countDownTimeLeft/60, countDownTimeLeft % 60));
                        break;
                }

            }
        });






        return view;
    }


    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = (System.currentTimeMillis() - startTime + stopTime);
            long seconds = millis / 1000;
            timeCounter.setText(String.format("%02d:%02d" ,seconds/60, seconds % 60));
            mHandler.postDelayed(mRunnable, 10L);

        }
    };


}
