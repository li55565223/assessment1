package au.edu.federation.itech3107.studentattendance30395756;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LiteSQL extends SQLiteOpenHelper {

    public LiteSQL(Context context) {
        super(context, "COURSE", null, 0x0111);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        SQL s = new SQL();
        db.execSQL(s.getS1());
        db.execSQL(s.getS2());
        db.execSQL(s.getS3());
        db.execSQL(s.getS4());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        new SQL().getS1();
    }
}
