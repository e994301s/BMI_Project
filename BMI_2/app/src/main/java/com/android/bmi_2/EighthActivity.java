package com.android.bmi_2;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    private SQLiteDatabase DB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth);

        editSearch = findViewById(R.id.search_name);

        settingList();
        search = new ArrayList<History>();
        search.addAll(data);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editSearch.getText().toString();
                search(text);
            }
        });


    }

    // 검색을 수행하는 메소드
    public void search(String charText) {
        data.clear();
        if (charText.length() == 0) {
            data.addAll(search);
        }
        else {
            for (int i = 0; i < search.size(); i++) {
                if (search.get(i).getName().contains(charText)) {
                    data.add(search.get(i));
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void settingList() {
        data = new ArrayList<History>();
        HistoryDB historyDB;
        historyDB = new HistoryDB(EighthActivity.this);
        try {
            DB = historyDB.getReadableDatabase();
            String query = "SELECT * FROM user;";

            Cursor cursor = DB.rawQuery(query, null);

            while (cursor.moveToNext()) {
                String username = cursor.getString(1);
                int userheight = cursor.getInt(2);
                int userweight = cursor.getInt(3);
                int userbmi = cursor.getInt(4);
                int userneed = cursor.getInt(5);
                int usericon = cursor.getInt(6);

                data.add(new History(usericon, userheight, userweight, userbmi, userneed, username));
            }
            adapter = new HistoryAdapter(EighthActivity.this, R.layout.eighth_layout, data);
            listView = findViewById(R.id.list);
            listView.setAdapter(adapter);
            cursor.close();
            historyDB.close();
        } catch(Exception e){
            e.printStackTrace();
        }


    }
}


