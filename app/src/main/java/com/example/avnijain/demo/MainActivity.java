package com.example.avnijain.demo;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    ProgressBar Progressbar;
    TextView textView;
    int progressBarValue = 0;
    Button b;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        b = (Button) findViewById(R.id.b);
        Progressbar = (ProgressBar) findViewById(R.id.progressBar1);
        textView = (TextView) findViewById(R.id.text);

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (progressBarValue < 100) {
                    progressBarValue++;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                            Progressbar.setProgress(progressBarValue);
                            textView.setText(progressBarValue + "% Complete");
                        }
                    });
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
