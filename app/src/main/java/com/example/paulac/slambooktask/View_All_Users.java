package com.example.paulac.slambooktask;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class View_All_Users extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    DatabaseOperation mdb;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view__all__users);
        ListView lv = (ListView)findViewById(R.id.listViewko);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.viewlayout);
        lv.setAdapter(listDataAdapter);
        mdb = new DatabaseOperation(getApplicationContext());
        sqLiteDatabase = mdb.getReadableDatabase();
        cursor = mdb.getInformation(sqLiteDatabase);
        if(cursor.moveToFirst()){
            do{
                String dpfname, dpmi, dplname, dpaddress, dpgender, dpmonth, dpday, dpyear, dpemail;

                dpfname = cursor.getString(0);
                dpmi = cursor.getString(1);
                dplname = cursor.getString(2);
                dpaddress = cursor.getString(3);
                dpgender = cursor.getString(4);
                dpmonth = cursor.getString(5);
                dpday = cursor.getString(6);
                dpyear = cursor.getString(7);
                dpemail = cursor.getString(8);
                DataProvider dataProvider = new DataProvider(dpfname, dpmi, dplname, dpaddress, dpgender, dpmonth, dpday, dpyear, dpemail);
                listDataAdapter.add(dataProvider);
            }while(cursor.moveToNext());
        }
    }
}

