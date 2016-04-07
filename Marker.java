package edu.lclark.maphomework;

import android.provider.BaseColumns;

/**
 * Created by Peter on 4/5/2016.
 */
public class Marker {

    public Marker(){};

    public static abstract class MarkerEntry implements BaseColumns {
        public static final String TABLE_NAME = "Markers";
        public static final String LAT = "Latitude";
        public static final String LNG = "Longitued";
        public static final String TITLE = "Title";
        public static final String SNIPPET = "Snippet";
        public static final String USER_ID = "User ID";
    }
}
