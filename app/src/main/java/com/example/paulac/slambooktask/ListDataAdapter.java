package com.example.paulac.slambooktask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulac on 11/25/15.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList<>();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }


    static class LayoutHandler{
        TextView fname, mi, lname, address, gender, month, day, year, email;
    }

    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;

        if(row==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.viewlayout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.fname = (TextView) row.findViewById(R.id.fnametext);
            layoutHandler.mi = (TextView) row.findViewById(R.id.mitext);
            layoutHandler.lname = (TextView) row.findViewById(R.id.lnametext);
            layoutHandler.address = (TextView) row.findViewById(R.id.addresstext);
            layoutHandler.gender = (TextView) row.findViewById(R.id.gendertext);
            layoutHandler.month = (TextView) row.findViewById(R.id.birthmonth);
            layoutHandler.day = (TextView) row.findViewById(R.id.birthday);
            layoutHandler.year = (TextView) row.findViewById(R.id.birthyear);
            layoutHandler.email = (TextView) row.findViewById(R.id.emailtext);
            row.setTag(layoutHandler);
        }

        else{
            layoutHandler = (LayoutHandler) row.getTag();
        }
            DataProvider dataProvider = (DataProvider) this.getItem(position);
            layoutHandler.fname.setText(dataProvider.getFname());
            layoutHandler.mi.setText(dataProvider.getMi() + ".");
            layoutHandler.lname.setText(dataProvider.getLname());
            layoutHandler.address.setText(dataProvider.getAddress());
            layoutHandler.gender.setText(dataProvider.getGender());
            layoutHandler.month.setText(dataProvider.getMonth());
            layoutHandler.day.setText(dataProvider.getDay() + ",");
            layoutHandler.year.setText(dataProvider.getYear());
            layoutHandler.email.setText(dataProvider.getEmail());
        return row;
    }
}
