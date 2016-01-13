package com.example.paulac.slambooktask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by paulac on 11/16/15.
 */
public class DatabaseOperation extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TableData.TableInfo.TABLE_NAME+"("+
            TableData.TableInfo.USER_FNAME + " Text,"+ TableData.TableInfo.USER_MI+
            " Text,"+ TableData.TableInfo.USER_LNAME+" Text,"
            +TableData.TableInfo.USER_ADDRESS+" Text,"+ TableData.TableInfo.USER_GENDER+ " Text," + TableData.TableInfo.USER_BDAY_MONTH +" Text,"
            + TableData.TableInfo.USER_BDAY_DAY+" Text,"+ TableData.TableInfo.USER_BDAY_YEAR + " Text," + TableData.TableInfo.USER_EMAIL+" Text" + ");" ;

    public DatabaseOperation(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database", "Database Created");

    }

    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + TableData.TableInfo.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }




    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database", "Table Created");
    }

    public Cursor getInformation(SQLiteDatabase db)
        {
            String[] data = {TableData.TableInfo.USER_FNAME, TableData.TableInfo.USER_MI,
                    TableData.TableInfo.USER_LNAME, TableData.TableInfo.USER_ADDRESS, TableData.TableInfo.USER_GENDER,
                    TableData.TableInfo.USER_BDAY_MONTH, TableData.TableInfo.USER_BDAY_DAY,
                    TableData.TableInfo.USER_BDAY_YEAR, TableData.TableInfo.USER_EMAIL};
            Cursor CR = db.query(TableData.TableInfo.TABLE_NAME, data, null, null, null, null, null);
            return CR;
        }

    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    public void putInformation(DatabaseOperation dop, String cvFNAME, String cvMI, String cvLNAME, String cvADDRESS, String cvGENDER,
                               String cvBDAY_MONTH, String cvBDAY_DAY, String cvBDAY_YEAR, String cvEMAIL) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_FNAME, cvFNAME);
        cv.put(TableData.TableInfo.USER_MI, cvMI);
        cv.put(TableData.TableInfo.USER_LNAME, cvLNAME);
        cv.put(TableData.TableInfo.USER_ADDRESS, cvADDRESS);
        cv.put(TableData.TableInfo.USER_GENDER, cvGENDER);
        cv.put(TableData.TableInfo.USER_BDAY_MONTH, cvBDAY_MONTH);
        cv.put(TableData.TableInfo.USER_BDAY_DAY, cvBDAY_DAY);
        cv.put(TableData.TableInfo.USER_BDAY_YEAR, cvBDAY_YEAR);
        cv.put(TableData.TableInfo.USER_EMAIL, cvEMAIL);
        SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);

    }
        }


