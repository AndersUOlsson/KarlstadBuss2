package se.appson.www.karlstadbuss;


import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextClock;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class model {

    private TextView counterText;

    private long timeLeftInMillisecond = 3600000;

    public void clock(TextClock clock) {

        clock.setTextColor(Color.WHITE);
        clock.setFormat24Hour("HH:mm");
    }

    /**
     * Sets the start time when app is starting.

     */
    public String getStartTime() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formattedDate = df.format(c.getTime());

        return formattedDate;
    }

    /**
     * Sets and returns the time the ticket is valide.
     *
     * @return
     */
    public String getEndTime() {

        Calendar c = Calendar.getInstance();
        c.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formattedDate = simpleDateFormat.format(c.getTime());

        return formattedDate;
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

