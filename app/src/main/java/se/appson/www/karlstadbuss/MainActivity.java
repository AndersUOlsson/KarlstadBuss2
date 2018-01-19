package se.appson.www.karlstadbuss;


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
    model model = new model();
    private TextView startDate;
    private TextView endDate;



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

        this.startDate = (TextView) findViewById(R.id.startDateText);
        this.endDate = (TextView) findViewById(R.id.validTimeEnds);
        this.clock = (TextClock) findViewById(R.id.currentTimeClock);
        this.videoView = (VideoView) findViewById(R.id.authenticationVideo);


        model.clock(this.clock);
        video(this.videoView);






        startTimer();
        //Setting timer
        String startTime = model.getStartTime();
        this.startDate.setText(startTime);
        Log.d("Timer", "StartTime" +startTime );
        String endTime = model.getEndTime(this.clock);





    }




    /**
     * This is to display the video
     */
    public void video(VideoView videoView) {

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);

        if(videoView != null) {
            videoView.start();
        }

        this.counterText = findViewById(R.id.countDownText);
        startTimer();
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
