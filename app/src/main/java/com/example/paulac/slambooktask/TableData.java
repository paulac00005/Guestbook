package com.example.paulac.slambooktask;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by paulac on 11/16/15.
 */
public class TableData {


    public static abstract class TableInfo implements BaseColumns
    {
        public static final String USER_FNAME = "user_fname";
        public static final String USER_MI = "user_mi";
        public static final String USER_LNAME = "user_lname";
        public static final String USER_ADDRESS = "user_address";
        public static final String USER_GENDER = "user_gender";
        public static final String USER_BDAY_MONTH = "user_bday_month";
        public static final String USER_BDAY_DAY = "user_bday_day";
        public static final String USER_BDAY_YEAR = "user_bday_year";
        public static final String USER_EMAIL = "user_email";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "Information";
    }



}
