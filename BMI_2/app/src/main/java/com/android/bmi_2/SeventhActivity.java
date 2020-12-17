package com.android.bmi_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class SeventhActivity extends Activity {

    TextView resultBMI, resultRecommend, resultRecommend1;
    ImageView resultImage;
    int height, weight, weightGoal;
    double bmiResultCalc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);

        Intent intent = getIntent();
        height = intent.getIntExtra("height", 0);
        weight = intent.getIntExtra("weight", 0);

        TextView current = findViewById(R.id.weightCurrent_seventh);
        current.setText(Integer.toString(weight) + "kg");

        TextView goal = findViewById(R.id.weightGoal_seventh);
        goal.setText(Integer.toString(weightCalc())+ "kg");

        resultImage = findViewById(R.id.resultImage_seventh);
        resultBMI = findViewById(R.id.resultBMI_seventh);
        resultRecommend = findViewById(R.id.resultRecommend_seventh);
        resultRecommend1 = findViewById(R.id.resultRecommend1_seventh);

        TextView lowerMax = findViewById(R.id.lowerMax_seventh);
        lowerMax.setText(" < "+ lowerMaxCalc() + "kg");

        TextView normalMin = findViewById(R.id.normalMin_seventh);
        normalMin.setText(lowerMaxCalc() + "kg < ");

        TextView normalMax = findViewById(R.id.normalMax_seventh);
        normalMax.setText(" < "+ normalMaxCalc() + "kg");

        TextView fatMin = findViewById(R.id.fatMin_seventh);
        fatMin.setText(normalMaxCalc() + "kg < ");

        bmiType();
        findViewById(R.id.btnExercise_seventh).setOnClickListener(mClick);
    }


    // bmi 계산 method
    private double bmiCalc(){

        bmiResultCalc = weight / (height * height * 0.0001);

        return bmiResultCalc;
    }

    // 정상 체중 계산 method (bmi 20 기준)
    private int weightCalc(){

        weightGoal = (int)(20 * height * height * 0.0001);

        return weightGoal;
    }

    // 저체중 체중 Max 계산 method (bmi 18.6 기준)
    private String lowerMaxCalc(){

        int weightMax = (int)(18.6 * height * height * 0.0001);
        String max = Integer.toString(weightMax);
        return max;
    }

    // 정상 체중 Max 계산 method (bmi 22.9 기준)
    private String normalMaxCalc(){

        int weightMax = (int)(22.9 * height * height * 0.0001);
        String max = Integer.toString(weightMax);
        return max;
    }

    // bmi 결과에 따른 타입
    @SuppressLint("SetTextI18n")
    private void bmiType(){
        bmiResultCalc = bmiCalc();
        //String type ="";

        if(bmiResultCalc<18.6){
           // resultBMI.setTextColor(ContextCompat.getColor(this, R.color.sky));
            resultBMI.setText(Double.toString(bmiCalc()).substring(0, 5));
            resultImage.setImageResource(R.drawable.lower);
            resultRecommend.setTextColor(ContextCompat.getColor(this, R.color.sky));
            resultRecommend.setText("저체중");
            resultRecommend1.setText("당신은 근육량을 " + (weightCalc()-weight) + "kg 증량을 추천합니다!");

        } else if (bmiResultCalc>=18.6 && bmiResultCalc<22.9){
           // resultBMI.setTextColor(ContextCompat.getColor(this, R.color.green));
            resultBMI.setText(Double.toString(bmiCalc()).substring(0, 5));
            resultImage.setImageResource(R.drawable.normal);
            resultRecommend.setTextColor(ContextCompat.getColor(this, R.color.green));
            resultRecommend.setText("정상");
            resultRecommend1.setText("당신은 꾸준한 운동으로 현재 몸을 유지하세요!");


        } else if (bmiResultCalc>=22.9 && bmiResultCalc<24.9) {
           // resultBMI.setTextColor(ContextCompat.getColor(this, R.color.red));
            resultBMI.setText(Double.toString(bmiCalc()).substring(0, 5));
            resultImage.setImageResource(R.drawable.over);
            resultRecommend.setTextColor(ContextCompat.getColor(this, R.color.red));
            resultRecommend.setText("과체중");
            resultRecommend1.setText("당신은 체중을 " + (weight - weightCalc()) + "kg 감량을 위해\n운동이 필요합니다!");


        } else if (bmiResultCalc>=24.9){
           // resultBMI.setTextColor(ContextCompat.getColor(this, R.color.red));
            resultBMI.setText(Double.toString(bmiCalc()).substring(0, 5));
            resultImage.setImageResource(R.drawable.fat);
            resultRecommend.setTextColor(ContextCompat.getColor(this, R.color.red));
            resultRecommend.setText("비만");
            resultRecommend1.setText("당신은 체중을 " + (weight - weightCalc()) + "kg 감량을 위해\n운동과 식이요법을 병행하셔야 합니다!");

        }
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
