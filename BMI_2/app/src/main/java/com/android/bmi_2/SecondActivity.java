package com.android.bmi_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    Button backBtn, nextBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        ImageView female = findViewById(R.id.female);

        Switch sw = (Switch)findViewById(R.id.selectGender);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public
            void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // TODO Auto-generated method stub

                if(sw.isChecked()){
                    female.setImageResource(R.drawable.female);
                } else {
                    female.setImageResource(R.drawable.male);
                }
            }
        });

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 화면 넘길때는 intent가 필요하다! ,를 기준으로 from & to 지정해줘야 함.
                // MainActivity 에서 SubActivity 로 보내겠다!
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                 startActivity(intent);
            }
        });

        findViewById(R.id.nextBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 화면 넘길때는 intent가 필요하다! ,를 기준으로 from & to 지정해줘야 함.
                // MainActivity 에서 SubActivity 로 보내겠다!
                 Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                if (sw.isChecked()) {
                    intent.putExtra("gender", "female");
                } else{
                    intent.putExtra("gender", "male");
                }
                 startActivity(intent);
            }
        });
    } // onCreate End


} // end