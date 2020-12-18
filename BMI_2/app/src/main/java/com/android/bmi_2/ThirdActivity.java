package com.android.bmi_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ThirdActivity extends Activity {
    final static int RValue = 0;
    SeekBar sb01;
    EditText editCm;
    ImageView image1;
    Button nextBtn;
    Button back;
    String TAG = "MainActivity";
    int height = 0;
    String female;
    String male;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView tv = findViewById(R.id.tv);
        sb01 = findViewById(R.id.sb01);
        editCm = findViewById(R.id.editCm);
        image1 = findViewById(R.id.image1);
        nextBtn = findViewById(R.id.next);
        back = findViewById(R.id.back);


        Intent intent = getIntent();
        female = intent.getStringExtra("gender");
        male = intent.getStringExtra("gender");
        Log.v(TAG, String.valueOf(intent));
        Log.v(TAG, female);

        if (female.equals("female")) {
            image1.setImageResource(R.drawable.w1);
        }else if (male.equals("male")) {
            image1.setImageResource(R.drawable.m1);
        }

        nextBtn.setOnClickListener(mClickListener);
        back.setOnClickListener(mClickListener);

        sb01.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                editCm.setText("" + progress);
//                tv.setTextSize(progress);
                height = progress;

                if (female.equals("female")) {
                    image1.setImageResource(R.drawable.w1);

                    if (progress >= 150 && progress < 160) {
                        image1.setImageResource(R.drawable.wh1);
                    } else if (progress >= 160 && progress < 170) {
                        image1.setImageResource(R.drawable.wh2);
                    } else if (progress >= 170 && progress < 180) {
                        image1.setImageResource(R.drawable.wh3);
                    } else if (progress >= 180 && progress < 300) {
                        image1.setImageResource(R.drawable.wh4);
                    }
                }
                if (male.equals("male")) {
                    image1.setImageResource(R.drawable.m1);
                    if (progress >= 150 && progress < 160) {
                        image1.setImageResource(R.drawable.mh4);
                    } else if (progress >= 160 && progress < 170) {
                        image1.setImageResource(R.drawable.mh3);
                    } else if (progress >= 170 && progress < 180) {
                        image1.setImageResource(R.drawable.mh2);
                    } else if (progress >= 180 && progress < 300) {
                        image1.setImageResource(R.drawable.mh1);
                    }
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {

                case R.id.next:
                    intent = new Intent(ThirdActivity.this, FourthActivity.class);
                    intent.putExtra("height", height);
                    intent.putExtra("gender", female);
                    intent.putExtra("gender", male);
                    startActivity(intent);
                    break;
                case  R.id.back:
                    intent = new Intent(ThirdActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                default:
            }
        }
    };
}
