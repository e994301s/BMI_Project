package com.android.bmi_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;

public class FourthActivity extends Activity {

    SeekBar sb01;
    EditText editKg;
    ImageView image1;
    Button nextBtn;
    int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        int size;
        sb01 = findViewById(R.id.sb01);
        editKg = findViewById(R.id.editKg);
        image1 = findViewById(R.id.image1);
        nextBtn = findViewById(R.id.next);

        Intent intent = getIntent();
        String female = intent.getStringExtra("female");
        String male = intent.getStringExtra("male");
        int height = intent.getIntExtra("height", 0);


        sb01.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                editKg.setText("" + progress);
                weight =progress;

                if (progress >=150&&progress<160){
                    image1.setImageResource(R.drawable.m1);
                }else if(progress>=160&&progress<170){
                    image1.setImageResource(R.drawable.m2);
                }else if(progress>=170&&progress<180){
                    image1.setImageResource(R.drawable.m3);
                }else if (progress>=180&&progress<300){
                    image1.setImageResource(R.drawable.m4);
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
}
