package com.android.bmi_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    Button back;
    int weight;
    int height = 0;
    String female;
    String male;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        int size;
        sb01 = findViewById(R.id.sb01);
        editKg = findViewById(R.id.editKg);
        image1 = findViewById(R.id.image1);
        nextBtn = findViewById(R.id.next);
        back = findViewById(R.id.back);

        nextBtn.setOnClickListener(mClickListener);
        back.setOnClickListener(mClickListener);

        Intent intent = getIntent();
        female = intent.getStringExtra("gender");
        male = intent.getStringExtra("gender");
        height = intent.getIntExtra("height", 0);
        username  = intent.getStringExtra("username");

        sb01.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                editKg.setText("" + progress);
                weight =progress;

                if (female.equals("female")) {
                    if (progress >= 0 && progress < 43) {
                        image1.setImageResource(R.drawable.w1);
                    } else if (progress >= 43 && progress < 56) {
                        image1.setImageResource(R.drawable.w2);
                    } else if (progress >= 56 && progress < 61) {
                        image1.setImageResource(R.drawable.w3);
                    } else if (progress >= 61 && progress < 100) {
                        image1.setImageResource(R.drawable.w4);
                    }
                }
                if (male.equals("male")) {
                    if (progress >= 0 && progress < 58) {
                        image1.setImageResource(R.drawable.m1);
                    } else if (progress >= 58 && progress < 76) {
                        image1.setImageResource(R.drawable.m2);
                    } else if (progress >= 76 && progress < 83) {
                        image1.setImageResource(R.drawable.m3);
                    } else if (progress >= 83 && progress < 150) {
                        image1.setImageResource(R.drawable.m4);
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
                    intent = new Intent(FourthActivity.this, SeventhActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("height", height);
                    intent.putExtra("weight", weight);
                    intent.putExtra("female", female);
                    intent.putExtra("male", height);
                    startActivity(intent);
                    break;
                case  R.id.back:
                    intent = new Intent(FourthActivity.this, ThirdActivity.class);
                    startActivity(intent);
                    break;
                default:
            }
        }
    };
}
