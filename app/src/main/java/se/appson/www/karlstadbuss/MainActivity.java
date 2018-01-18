package se.appson.www.karlstadbuss;

import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.VideoView;



public class MainActivity extends AppCompatActivity {

    private TextView counterText;
    public CountDownTimer countDownTimer;
    public long timeLeftInMillisecond = 3600000;
    private TextClock clock;
    private VideoView videoView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Standard
        super.onCreate(savedInstanceState);

        //Removes all the notification bar on the top of the screen.
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        getWindow().setFormat(PixelFormat.UNKNOWN);

        //Clock
        this.clock =  (TextClock) findViewById(R.id.currentTimeClock);
        clock.setTextColor(Color.WHITE);
        clock.setFormat24Hour("hh:mm");

        Log.d("hello ", "hello" +this.clock.getTimeZone());




        //Setting timer
        //String startTime = getStartTime(clock);
        //String endTime = getEndTime(clock);


        //Video
        this.videoView = (VideoView) findViewById(R.id.authenticationVideo);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);

        if(videoView != null) {
            videoView.start();
        }

        this.counterText = findViewById(R.id.countDownText);
        startTimer();

    }

    /**
     * Sets the start time when app is starting.
     * @param clock
     */
    private String getStartTime(TextClock clock) {

        //String startTime = clock.getText().toString();


        //Print to Logcat
        //Log.d("TIMER", "setTimer: " + startTime);

        return "";//startTime;
    }

    /**
     * Sets and returns the time the ticket is valide.
     * @param clock
     * @return
     */
    private String getEndTime(TextClock clock) {
        //Todo:Fix the timer to show one hour later.
        //String endTime = clock.getText().toString();
        //Log.d("TIMER", "EndTimer: " + endTime);
        //String location = "moskva";
        //clock.setTimeZone(location);
        //String hell = clock.getText().toString();

        //Log.d("TIMER", "EndTimer: " + hell);
        return "hello";
    }

    private void startTimer() {
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
