package jacobtelford.com.assessmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.button_start_pause);

        updateCountDownText();
    }

    public void onClick(View view) {
        if(mTimerRunning) {
            pauseTimer();
        } else {
            startTimer();
        }
    }

    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
    }

    private void updateCountDownText(){
        int minutes = (int) mTimeLeftInMillis/1000/60;
        int seconds = (int) mTimeLeftInMillis/1000%60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d, minutes, seconds");

        mTextViewCountDown.setText(timeLeftFormatted);
    }
}