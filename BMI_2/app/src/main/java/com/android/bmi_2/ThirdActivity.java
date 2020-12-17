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
    int height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        sb01 = findViewById(R.id.sb01);
        editCm = findViewById(R.id.editCm);
        image1 = findViewById(R.id.image1);
        nextBtn = findViewById(R.id.next);

        Intent intent = getIntent();
        String female = intent.getStringExtra("female");
        String male = intent.getStringExtra("male");

        nextBtn.setOnClickListener(mClickListener);

        sb01.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                editCm.setText("" + progress);
                height =progress;

                image1.setScaleType(ImageView.ScaleType.CENTER);



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
                    startActivity(intent);
                    break;
//                case  R.id.back:
//                    intent = new Intent(MainActivity.this, SubActivity.class);
//                    startActivity(intent);
//                    break;
                default:
            }
        }
    };
}
