package com.example.saikrishna.jsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Parsing on 2/2/2018.
 */

public class JsonAdapter extends BaseAdapter
{

    Context context;
    ArrayList<JsonDataModel> arrayList;
    public JsonAdapter(Context context, ArrayList<JsonDataModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrayList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View  view = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null)
        {
            view = inflater.inflate(R.layout.listview_item,null);
        }
        else
        {
            view = convertView;
        }
        TextView id_TextView = (TextView) view.findViewById(R.id.id_TextView);
        TextView name_TextView = (TextView) view.findViewById(R.id.name_TextView);
        TextView email_TextView = (TextView) view.findViewById(R.id.email_TextView);
        TextView address_TextView = (TextView) view.findViewById(R.id.address_TextView);
        TextView gender_TextView = (TextView) view.findViewById(R.id.gender_TextView);
        TextView mobile_TextView = (TextView) view.findViewById(R.id.mobile_TextView);
        TextView home_TextView = (TextView) view.findViewById(R.id.home_TextView);
        TextView office_TextView = (TextView) view.findViewById(R.id.office_TextView);

        JsonDataModel jsonDataModel = arrayList.get(position);

        id_TextView.setText(jsonDataModel.getId());
        name_TextView.setText(jsonDataModel.getName());
        email_TextView.setText(jsonDataModel.getEmail());
        address_TextView.setText(jsonDataModel.getAddress());
        gender_TextView.setText(jsonDataModel.getGender());
        mobile_TextView.setText(jsonDataModel.getMobile());
        home_TextView.setText(jsonDataModel.getHome());
        office_TextView.setText(jsonDataModel.getOffice());
        return view;
    }
}
