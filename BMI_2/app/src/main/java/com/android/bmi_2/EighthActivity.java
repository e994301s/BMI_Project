package com.android.bmi_2;

import android.app.Activity;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EighthActivity extends Activity {

    private ArrayList<History> data = null;
    private HistoryAdapter adapter = null;
    private ListView listView = null;
    private EditText editSearch;
    private ArrayList<History> search = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth);
        editSearch = findViewById(R.id.search_name);
        data = new ArrayList<History>();
        search = new ArrayList<History>();
        search.addAll(data);
        adapter = new HistoryAdapter(EighthActivity.this, R.layout.eighth_layout, data);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });


    }

    // 검색을 수행하는 메소드
    public void search(String charText) {
        data.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            data.addAll(search);
        }
        // 문자 입력을 할때..
        else {
            // 리스트의 모든 데이터를 검색한다.
            for (int i = 0; i < search.size(); i++) {
                if (search.get(i).getName().contains(charText)) {
                    data.add(search.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }
}


