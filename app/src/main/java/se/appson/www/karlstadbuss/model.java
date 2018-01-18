package se.appson.www.karlstadbuss;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by andyw on 2018-01-18.
 */

public class model {

    private TextView counterText;
    public CountDownTimer countDownTimer;
    public long timeLeftInMillisecond = 3600000;


    /**
     * Sets the start time when app is starting.
     * @param clock
     */
    public String getStartTime() {

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => "+c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formattedDate = df.format(c.getTime());

        return formattedDate;
    }

    /**
     * Sets and returns the time the ticket is valide.
     * @param clock
     * @return
     */
    public String getEndTime(TextClock clock) {
        //Todo:Fix the timer to show one hour later.
        //String endTime = clock.getText().toString();
        //Log.d("TIMER", "EndTimer: " + endTime);
        //String location = "moskva";
        //clock.setTimeZone(location);
        //String hell = clock.getText().toString();

        //Log.d("TIMER", "EndTimer: " + hell);
        return "hello";
    }

    public void startTimer() {
        this.countDownTimer = new CountDownTimer(timeLeftInMillisecond,1000) {

            @Override
            public void onTick(long l) {
                timeLeftInMillisecond = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
            }

        }.start();
    }

    private void updateTimer() {
        int minutes = (int) timeLeftInMillisecond / 60000;
        int seconds = (int) timeLeftInMillisecond % 60000 /1000;

        String timeLeftText;

        timeLeftText = "00:" + minutes;
        timeLeftText += ":";
        if(seconds < 10) {
            timeLeftText += "0";
        }
        timeLeftText += seconds;
        counterText.setText(timeLeftText);
    }
}
