package jacobtelford.com.assessmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public int tOneS = 0;
    public int tTwoS = 0;
    public int tOneTO = 3;
    public int tTwoTO = 3;
    public int tOneF = 0;
    public int tTwoF = 0;
    public int PerNum = 1;
    private TextView mtOneTO;
    private TextView mtTwoTO;
    private TextView mShowCountOne;
    private TextView mShowCountTwo;
    private TextView mtOneF;
    private TextView mtTwoF;
    private TextView mPerNum;
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
        mShowCountOne = (TextView) findViewById(R.id.t1Score);
        mShowCountTwo = (TextView) findViewById(R.id.t2Score);
        mtOneTO = (TextView) findViewById(R.id.t1_to);
        mtTwoTO = (TextView) findViewById(R.id.t2_to);
        mtOneF = (TextView) findViewById(R.id.t1F_Num);
        mtTwoF = (TextView) findViewById(R.id.t2F_Num);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.button_start_pause);

        updateCountDownText();
    }



    public void onTimerClick(View view) {
        if (mTimerRunning) {
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

    public void tOneOne(){
        tOneS=tOneS+ 1;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
    }

    public void tTwoOne(){
        tTwoS=tTwoS+ 1;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
    }

    public void tOneTwo(){
        tOneS=tOneS+ 2;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
    }

    public void tTwoTwo(){
        tTwoS=tTwoS+ 2;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
    }

    public void tOneThree(){
        tOneS=tOneS+ 3;
        if (mShowCountOne != null)
            mShowCountOne.setText(Integer.toString(tOneS));
    }

    public void tTwoThree(){
        tTwoS=tTwoS+ 3;
        if (mShowCountTwo != null)
            mShowCountTwo.setText(Integer.toString(tTwoS));
    }

    public void tOneTOs(){
        ++tOneTO;
        if(mtOneTO != null)
            mtOneTO.setText(Integer.toString((tOneTO)));
    }

    public void tTwoTOs(){
        ++tTwoTO;
        if (mtTwoTO != null)
            mtTwoTO.setText(Integer.toString(tTwoTO));
    }

    public void tOneFs(){
        ++tOneF;
        if(mtOneF != null)
            mtOneF.setText(Integer.toString((tOneF)));
    }

    public void tTwoFs(){
        ++tTwoF;
        if (mtTwoF != null)
            mtTwoF.setText(Integer.toString(tTwoF));
    }

    public void perNum(){
        ++PerNum;
        if (mPerNum != null)
            mPerNum.setText(Integer.toString(PerNum));
    }
}