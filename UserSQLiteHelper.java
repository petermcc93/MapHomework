package edu.lclark.maphomework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Peter on 4/5/2016.
 */
public class UserSQLiteHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "users.db";
    private static UserSQLiteHelper sInstance;

    public UserSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static UserSQLiteHelper getInstance(LoginFragment context){
        if(sInstance == null){
            sInstance = new UserSQLiteHelper(context.getContext(),DB_NAME, null, 1);
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + User.UserEntry.TABLE_NAME + " ( "
                + User.UserEntry.COLUMN_NAME_NAME + " TEXT, "
                + User.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT )");

        db.execSQL("CREATE TABLE " + Marker.MarkerEntry.TABLE_NAME + " ( "
                + Marker.MarkerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Marker.MarkerEntry.LAT + " REAL, "
                + Marker.MarkerEntry.LNG + " REAL, "
                + Marker.MarkerEntry.TITLE + " TEXT, "
                + Marker.MarkerEntry.SNIPPET + " TEXT, "
                + Marker.MarkerEntry.USER_ID + " INTEGER )");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + Marker.MarkerEntry.TABLE_NAME);
        db.execSQL("DROP TABLE " + User.UserEntry.TABLE_NAME);
        onCreate(db);
    }

    public boolean addUser( String user){
        user = user.trim();
        String sql = "SELECT * FROM Users WHERE Username = ?";
        Cursor cursor = sInstance.getReadableDatabase().rawQuery(sql,new String[] {user});
        if(!cursor.moveToFirst()){
            //User not found, add one
            ContentValues contentValue = new ContentValues();
            contentValue.put(User.UserEntry.COLUMN_NAME_NAME, user);
            sInstance.getWritableDatabase().insert(User.UserEntry.TABLE_NAME,null,contentValue);
            return true;
        }
        else{
            //Already has User
            return false;
        }
    }


}
