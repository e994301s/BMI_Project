package com.android.bmi_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SeventhActivity extends Activity {

    TextView resultBMI, resultRecommend;
    ImageView resultImage;
    int height, weight;
    double bmiResultCalc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);

        resultImage = findViewById(R.id.resultImage_seventh);
        resultBMI = findViewById(R.id.resultBMI_seventh);
        resultRecommend = findViewById(R.id.resultRecommend_seventh);

        resultBMI.setText(Double.toString(bmiCalc()));
        resultRecommend.setText("당신은 " + bmiType() + "입니다.");

        findViewById(R.id.btnExercise_seventh).setOnClickListener(mClick);
    }


    // bmi 계산 method
    private double bmiCalc(){
        Intent intent = getIntent();
        height = intent.getIntExtra("height", 0);
        weight = intent.getIntExtra("weight", 0);

        bmiResultCalc = weight / (height * height * 0.00001);

        return bmiResultCalc;
    }

    // bmi 결과에 따른 타입
    private String bmiType(){
        bmiResultCalc = bmiCalc();
        String type ="";

        if(bmiResultCalc<18.6){
            resultImage.setImageResource(R.drawable.lower);
            type = "저체중";
        } else if (bmiResultCalc>=18.6 && bmiResultCalc<22.9){
            resultImage.setImageResource(R.drawable.normal);
            type = "정상";
        } else if (bmiResultCalc>=22.9 && bmiResultCalc<24.9) {
            resultImage.setImageResource(R.drawable.over);
            type = "과체중";
        } else{
            resultImage.setImageResource(R.drawable.fat);
            type = "비만";
        }
        return type;
    }


    // 추천 운동 보기
    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SeventhActivity.this , SixthActivity.class);
            startActivity(intent);
        }
    };
}
