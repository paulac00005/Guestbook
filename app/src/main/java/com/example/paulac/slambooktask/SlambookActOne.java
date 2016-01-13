package com.example.paulac.slambooktask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SlambookActOne extends AppCompatActivity {
Button anu,vau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slambook_act_one);
        anu = (Button)findViewById(R.id.add);
        vau = (Button)findViewById(R.id.view);
    }

    public void add(View v){
        Intent gotoAdd = new Intent(this, Add_New_User.class);
        startActivity(gotoAdd);
    }

    public void view(View v){
        Intent gotoView = new Intent(this, View_All_Users.class);
        startActivity(gotoView);
    }
}
