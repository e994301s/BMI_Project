package com.android.bmi_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;

    public class MainActivity extends Activity {
        ImageView imageView;
        Button button;
        EditText editText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
            editText = findViewById(R.id.username);
            imageView = findViewById(R.id.mainimg);
            Glide.with(this).load(R.raw.main).apply(new BaseRequestOptions() {
                @Override
                public BaseRequestOptions centerCrop() {
                    return super.centerCrop();
                }
            }.circleCrop()).into(imageView);


            findViewById(R.id.bmidetail).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final LinearLayout linear = (LinearLayout) View.inflate(com.android.bmi_2.MainActivity.this, R.layout.bmidetail, null);
                    new AlertDialog.Builder(com.android.bmi_2.MainActivity.this)
                            .setView(linear)
                            .setPositiveButton("돌아가기", null)
                            .show();
                }

            });

      button = findViewById(R.id.enter_main);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String username = editText.getText().toString();
              if(username.length()==0){
                  Toast.makeText(MainActivity.this, "이럼을 입력해주세요.", Toast.LENGTH_SHORT).show();
              } else {

              Intent intent = new Intent(MainActivity.this, SecondActivity.class);
              intent.putExtra("username", username);
              startActivity(intent);
              }
          }
      });

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }
    }