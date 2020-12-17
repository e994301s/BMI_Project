package com.android.bmi_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import androidx.annotation.Nullable;

public class FifthActivity extends Activity {

    RatingBar ratingBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        findViewById(R.id.ratingBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ratingBar = findViewById(R.id.rating);
//                String rating = getText(ratingBar).toString();

                new AlertDialog.Builder(FifthActivity.this)
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle("* 별점 등록 완료! *")
                        .setMessage("감사합니다! 😍")
                        // 버튼명   // 버튼 리스너명
                        .setPositiveButton("닫기", null)
                        .show();
            }
        });

        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
