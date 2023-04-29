package com.j0nathan550.multitoolapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TimerFragment extends Fragment {
    private int hours = 0, minutes = 0, seconds = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        LoadUI(view);
        return view;
    }
    @SuppressLint("SetTextI18n")
    private void LoadUI(View view) {
        TextView hoursText = view.findViewById(R.id.timer_hours);
        TextView minutesText = view.findViewById(R.id.timer_minutes);
        TextView secondsText = view.findViewById(R.id.timer_seconds);

        Button upArrowHours = view.findViewById(R.id.hours_button_up);
        upArrowHours.setOnClickListener(v -> {
            if (hours == 23) {
                hours = -1;
            }
            hours++;
            if(hours < 10) {
                hoursText.setText("0" + hours);
            }
            else {
                hoursText.setText(Integer.toString(hours));
            }
        });
        Button upArrowMinutes = view.findViewById(R.id.minute_button_up);
        upArrowMinutes.setOnClickListener(v -> {
            if (minutes == 59) {
                minutes = -1;
            }
            minutes++;
            if(minutes < 10) {
                minutesText.setText("0" + minutes);
            }
            else {
                minutesText.setText(Integer.toString(minutes));
            }
        });
        Button upArrowSeconds = view.findViewById(R.id.seconds_button_up);
        upArrowSeconds.setOnClickListener(v -> {
            if (seconds == 59) {
                seconds = -1;
            }
            seconds++;
            if(seconds < 10) {
                secondsText.setText("0" + seconds);
            }
            else {
                secondsText.setText(Integer.toString(seconds));
            }
        });

        Button downArrowHours = view.findViewById(R.id.hours_button_down);
        downArrowHours.setOnClickListener(v -> {
            if (hours == 0) {
                hours = 24;
            }
            hours--;
            if(hours < 10) {
                hoursText.setText("0" + hours);
            }
            else {
                hoursText.setText(Integer.toString(hours));
            }
        });
        Button downArrowMinutes = view.findViewById(R.id.minute_button_down);
        downArrowMinutes.setOnClickListener(v -> {
            if (minutes == 0) {
                minutes = 60;
            }
            minutes--;
            minutesText.setText(Integer.toString(minutes));
            if(minutes < 10) {
                minutesText.setText("0" + minutes);
            }
            else {
                minutesText.setText(Integer.toString(minutes));
            }
        });
        Button downArrowSeconds = view.findViewById(R.id.seconds_button_down);
        downArrowSeconds.setOnClickListener(v -> {
            if (seconds == 0) {
                seconds = 60;
            }
            seconds--;
            if(seconds < 10) {
                secondsText.setText("0" + seconds);
            }
            else {
                secondsText.setText(Integer.toString(seconds));
            }
        });
    }
}