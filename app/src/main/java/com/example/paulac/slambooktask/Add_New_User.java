package com.example.paulac.slambooktask;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Add_New_User extends AppCompatActivity {

    static EditText anufname;
    EditText anumi;
    EditText anulname;
    EditText anuaddress;
    EditText anuemail;
    EditText anubday_year;
    RadioGroup anugender;
    RadioButton anugenderselected;
    Spinner anumonth, anuday;
    Button anusave;
    Context con = this;

    String anuFNAME, anuMI, anuLNAME, anuADDRESS, anuGENDER, anuBDAY_MONTH, anuBDAY_DAY, anuBDAY_YEAR, anuEMAIL;

    public boolean isValidEmail(String anuemail){
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(anuemail);
        return matcher.matches();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__new__user);


        Spinner monthdropdown = (Spinner)findViewById(R.id.monthspinner);
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, months);
        monthdropdown.setAdapter(adapter);

        Spinner daysdropdown = (Spinner)findViewById(R.id.dayspinner);
        String[] days = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17" , "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, days);
        daysdropdown.setAdapter(adapter2);

        anufname = (EditText)findViewById(R.id.fname);
        anumi = (EditText)findViewById(R.id.mi);
        anulname = (EditText)findViewById(R.id.lname);
        anuaddress= (EditText)findViewById(R.id.address);
        anuemail = (EditText)findViewById(R.id.email);
        anubday_year = (EditText)findViewById(R.id.yearText);
        anugender = (RadioGroup)findViewById(R.id.malefemale);
        anumonth = (Spinner)findViewById(R.id.monthspinner);
        anuday = (Spinner)findViewById(R.id.dayspinner);
        anusave = (Button)findViewById(R.id.savebtn);

        anusave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anuFNAME = anufname.getText().toString();
                anuMI = anumi.getText().toString();
                anuLNAME = anulname.getText().toString();
                anuADDRESS = anuaddress.getText().toString();
                int selectedId = anugender.getCheckedRadioButtonId();
                anugenderselected = (RadioButton) findViewById(selectedId);
                String radiovalue = ((RadioButton) findViewById(anugender.getCheckedRadioButtonId())).getText().toString();
                anuGENDER = radiovalue;
                String mSpinner = anumonth.getSelectedItem().toString();
                anuBDAY_MONTH = mSpinner;
                String dSpinner = anuday.getSelectedItem().toString();
                anuBDAY_DAY = dSpinner;
                anuBDAY_YEAR = anubday_year.getText().toString();
                anuEMAIL = anuemail.getText().toString();


                DatabaseOperation DB = new DatabaseOperation(con);
                DB.putInformation(DB, anuFNAME, anuMI, anuLNAME, anuADDRESS, anuGENDER, anuBDAY_MONTH, anuBDAY_DAY, anuBDAY_YEAR, anuEMAIL);
                final String email = anuemail.getText().toString();
                if (isValidEmail(email)){
                    Toast.makeText(getApplicationContext(), "SAVED",
                            Toast.LENGTH_LONG).show();
                    finish();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(getApplicationContext(), "Enter valid email",
                            Toast.LENGTH_LONG).show();
                }



            }
        });


}

    }















//CONVERT SPINNER VALUE TO STRING . . . String Text = mySpinner.getSelectedItem().toString();


/*
public void onClick(View v) {

		        // get selected radio button from radioGroup
			int selectedId = radioSexGroup.getCheckedRadioButtonId();

			// find the radiobutton by returned id
		        radioSexButton = (RadioButton) findViewById(selectedId);

			Toast.makeText(MyAndroidAppActivity.this,
				radioSexButton.getText(), Toast.LENGTH_SHORT).show();
 */

/*
if(maleradio.getCheckedRadioButtonId()!=-1){
    int id= rg1.getCheckedRadioButtonId();
    View radioButton = rg1.findViewById(id);
    int radioId = radioGroup.indexOfChild(radioButton);
    RadioButton btn = (RadioButton) rg1.getChildAt(radioId);
    String selection = (String) btn.getText();
}
 */