package au.edu.federation.itech3107.studentattendance30395756;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CourSett extends AppCompatActivity {
    String str = "SELECT id, name, start_time, end_time FROM COURSE where id = ?";
    SQLiteDatabase db;
    EditText ec;
    EditText e;
    EditText eit;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cour_s);
        id = getIntent().getIntExtra("id", 0);
        ec = findViewById(R.id.etCourseName);
        e = findViewById(R.id.etStartTime);
        eit = findViewById(R.id.etEndTime);
        View btnUpdateCourse = findViewById(R.id.btnUpdateCourse);
        CourClick courClick = new CourClick();
        courClick.b1click(this);
        courClick.b2click(this);
        courClick.b3click(this);
        courClick.b4click(this);
        courClick.b5click(this);
        courClick.b6click(this);
        courClick.b7click(this);
        db = new LiteSQL(this).getReadableDatabase();
        showData();
    }

    public void showData() {
        Cursor cursor = db.rawQuery(str, new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            ec.setText(cursor.getString(1));
            e.setText(cursor.getString(2));
            eit.setText(cursor.getString(3));
        }
        cursor.close();
    }
}