package se.appson.www.karlstadbuss;


import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextClock;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class model {

    private TextView counterText;

    private long timeLeftInMillisecond = 3600000;

    public void clock(TextClock clock) {

        clock.setTextColor(Color.WHITE);
        clock.setFormat24Hour("hh:mm");
    }

    /**
     * Sets the start time when app is starting.

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

        Calendar c = Calendar.getInstance();
        Date d = null;
        try{

            long t =  d.getTime()+60;;

            Log.d("Timer", "Time" + t +"");
        }
        catch(NullPointerException e) {
            e.getMessage();
        }
        //d.setHours( (Date)c.getTime().getHours() +1);
        //c.setTime();

        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //String formattedDate = df.format(c.getTime());


        return "hello";
    }

    public void startTimer() {
        CountDownTimer countDownTimer
                = new CountDownTimer(timeLeftInMillisecond,
                1000) {

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

