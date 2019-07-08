package sg.edu.rp.c346.pdapp4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shows.db";
    private static final int DATABASE_VERSION = 5;
    private static final String TABLE_SHOW = "show";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SHOW_TITLE = "show_title";
    private static final String COLUMN_SHOW_GENRE = "show_genre";
    private static final String COLUMN_SHOW_LANGUAGE = "show_language";
    private static final String COLUMN_SONG_STARS = "song_stars";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSongTableSql =  "CREATE TABLE " + TABLE_SHOW + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SHOW_TITLE + " TEXT ," + COLUMN_SHOW_GENRE + " TEXT, " + COLUMN_SHOW_LANGUAGE + " INTEGER, " + COLUMN_SONG_STARS + " INTEGER )";

        db.execSQL(createSongTableSql);
        Log.i("info","created tables");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "SHOW");
        onCreate(db);
    }
    public long insertShow(String title, String language, String genre, int stars) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_SHOW_TITLE, title);
        values.put(COLUMN_SHOW_GENRE, language);
        values.put(COLUMN_SHOW_LANGUAGE, genre);
        values.put(COLUMN_SONG_STARS, stars);

        long result = db.insert(TABLE_SHOW, null, values);

        //check if record is inserted successfully
        if (result == -1){
            Log.d("DBHelper", "Insert failed");
        }

        db.close();
        Log.d("SQL Insert ", "" + result);
        //id returned, shouldn’t be -1

        return result;

    }
    public String updateShow(Show data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_SHOW_TITLE, data.getShows());
        values.put(COLUMN_SHOW_GENRE, data.getGenre());
        values.put(COLUMN_SHOW_LANGUAGE, data.getLanguage());
        values.put(COLUMN_SONG_STARS, data.getStars());

        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};

        int result = db.update(TABLE_SHOW, values, condition, args);

        //check if record is updated successfully if the affected record is 1
        if (result < 1){
            return "unsuccessful";
        }

        db.close();
        return "successful";

    }
    public String deleteShow(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};

        int result = db.delete(TABLE_SHOW, condition, args);

        //check if record is successfully updated if the affected record is 1
        if (result < 1){
            return "unsuccessful";
        }

        db.close();
        return "successful";

    }

    public ArrayList<Show> getAllShows() {
        ArrayList<Show> shows = new ArrayList<Show>();

        String selectQuery = "SELECT " + COLUMN_ID + "," + COLUMN_SHOW_TITLE +
                "," + COLUMN_SHOW_GENRE + "," + COLUMN_SHOW_LANGUAGE + "," + COLUMN_SONG_STARS +
                " FROM " + TABLE_SHOW;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String genre = cursor.getString(2);
                String language = cursor.getString(3);
                int stars = cursor.getInt(4);
                Show obj = new Show(id, title, genre, language, stars);
                shows.add(obj);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return shows;

    }

}

