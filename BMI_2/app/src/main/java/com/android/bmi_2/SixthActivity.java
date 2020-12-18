package com.android.bmi_2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;

public class SixthActivity extends Activity {
    VideoView video;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

            Intent intent = getIntent();
            String exerciseTitle = intent.getStringExtra("exercise");

            video= findViewById(R.id.video);
            //Video Uri
            Uri videoUri= Uri.parse("android.resource://" + getPackageName() +"/raw/"+exerciseTitle);

            //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업
            video.setMediaController(new MediaController(this));

            //VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기
            video.setVideoURI(videoUri);

            //동영상을 읽어오는데 시간이 걸리므로..
            //비디오 로딩 준비가 끝났을 때 실행하도록..
            //리스너 설정
            video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    //비디오 시작
                    video.start();
                }
            });

        }//onCreate ..
        //화면에 안보일때...
        @Override
        protected void onPause() {
            super.onPause();

            //비디오 일시 정지
            if(video!=null && video.isPlaying()) video.pause();
        }
        //액티비티가 메모리에서 사라질때..
        @Override
        protected void onDestroy() {
            super.onDestroy();
            //
            if(video!=null) video.stopPlayback();

        }

    }



