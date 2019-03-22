package com.example.saikrishna.jsonparsing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{
    Context context;
    ArrayList<JsonDataModel> arrayList;

    public RecyclerViewAdapter(Context context, ArrayList<JsonDataModel> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        JsonDataModel model  = arrayList.get(position);
        holder.id_TextView.setText(model.getId());
        holder.name_TextView.setText(model.getName());
        holder.email_TextView.setText(model.getEmail());
        holder.address_TextView.setText(model.getAddress());
        holder.gender_TextView.setText(model.getGender());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView id_TextView,name_TextView,email_TextView,address_TextView,gender_TextView;
        public MyViewHolder(View itemView)

        {
            super(itemView);
            id_TextView = (TextView)itemView.findViewById(R.id.id_TextView);
            name_TextView = (TextView)itemView.findViewById(R.id.name_TextView);
            email_TextView = (TextView)itemView.findViewById(R.id.email_TextView);
            address_TextView = (TextView)itemView.findViewById(R.id.address_TextView);
            gender_TextView = (TextView)itemView.findViewById(R.id.gender_TextView);
        }
    }
}
