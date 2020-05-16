package com.main.test4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.main.test4.R;
import com.main.test4.model.Table;

import java.util.List;


// This adapter is user to display tables inside the TablesFragment GridVIew
public class TablesAdapter extends ArrayAdapter<Table> {
    private int mTableResource;
    private Context mContext;

    public TablesAdapter(Context context, int resource, List<Table> tables) {
        super(context, android.R.layout.simple_list_item_1, tables);

        mContext = context;
        mTableResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(mTableResource, null);

        Table table = (Table) getItem(position);

        TextView tvTableNumber = (TextView) v.findViewById(R.id.tableNumberText);
        tvTableNumber.setText(String.valueOf(table.getNumber()));

        return v;
    }
}
