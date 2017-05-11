package com.example.dark.work2activity;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dark on 5/6/2017.
 */

public class EmployeeAdapter extends ArrayAdapter<ObjEmployee>{
    private Context context;
    private int mLayout;
    private List<ObjEmployee> mListData;

    public EmployeeAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ObjEmployee> ListData) {
        super(context, resource, ListData);
        this.context=context;
        this.mLayout=resource;
        this.mListData=ListData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ObjEmployee item=mListData.get(position);
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(mLayout,parent,false);
        TextView tvname=(TextView)convertView.findViewById(R.id.tvName);
        TextView tvaddress=(TextView)convertView.findViewById(R.id.tvAddress);
        TextView tvphone=(TextView)convertView.findViewById(R.id.tvPhone);
        tvname.setText(item.getName());
        tvaddress.setText(item.getAddress());
        tvphone.setText(item.getPhone());

        return convertView;

    }
}
