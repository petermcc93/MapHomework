package edu.lclark.maphomework;

import android.provider.BaseColumns;

/**
 * Created by Peter on 4/5/2016.
 */
public class User {

    public User() {}

    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_NAME = "Username";
    }

}
