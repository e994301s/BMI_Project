package com.android.bmi_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EighthActivity extends Activity {

    private ArrayList<History> data = null;
    private HistoryAdapter adapter = null;
    private ListView listView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth);

        data = new ArrayList<History>();
        adapter = new HistoryAdapter(EighthActivity.this, R.layout.eighth_layout, data);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
