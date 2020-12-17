package com.android.bmi_2;

import android.content.Context;
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
        TextView heighthis = convertView.findViewById(R.id.heighthis);
        TextView weigthhis = convertView.findViewById(R.id.weigthhis);
        TextView bmihis = convertView.findViewById(R.id.bmihis);

        imagehis.setImageResource(data.get(position).getIcon());
        heighthis.setText(data.get(position).getHeight());
        weigthhis.setText(data.get(position).getWeight());
        bmihis.setText(data.get(position).getBmi());

        return convertView;
    }
}
