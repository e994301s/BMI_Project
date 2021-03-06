package com.android.bmi_2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {
    private Context hContext = null;
    private int layout = 0;
    private ArrayList<History> data = null;
    private LayoutInflater inflater = null;
    private final String TAG = "Adapter";

    public HistoryAdapter(Context hContext, int layout, ArrayList<History> data) {
        this.hContext = hContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) hContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getIcon();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
        }
        ImageView imagehis = convertView.findViewById(R.id.imagehis);
        TextView namehis = convertView.findViewById(R.id.namehis);
        TextView heighthis = convertView.findViewById(R.id.heighthis);
        TextView weigthhis = convertView.findViewById(R.id.weigthhis);
        TextView bmihis = convertView.findViewById(R.id.bmihis);
        TextView needhis = convertView.findViewById(R.id.needhis);

        imagehis.setImageResource(data.get(position).getIcon());
        namehis.setText(data.get(position).getName());
        heighthis.setText(Integer.toString(data.get(position).getHeight()));
        weigthhis.setText(Integer.toString(data.get(position).getWeight()));
        bmihis.setText(Integer.toString(data.get(position).getBmi()));
        needhis.setText(Integer.toString(data.get(position).getUserneed()));

        Log.v(TAG, Integer.toString(data.get(position).getIcon()));
        Log.v(TAG, data.get(position).getName());
        Log.v(TAG, Integer.toString(data.get(position).getHeight()));
        Log.v(TAG, Integer.toString((data.get(position).getWeight())));
        Log.v(TAG, Integer.toString(data.get(position).getBmi()));
        Log.v(TAG, Integer.toString(data.get(position).getUserneed()));

        return convertView;
    }
}
