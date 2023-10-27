package au.edu.federation.itech3107.studentattendance30395756;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class StuInActu extends AppCompatActivity {
    private Button bu;
    private EditText en;
    private EditText ei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_a);
        bu = findViewById(R.id.btnAddStudent);
        ei = findViewById(R.id.etNumber);
        en = findViewById(R.id.etName);
        bu.setOnClickListener(view -> {
            SQLiteDatabase db = new LiteSQL(StuInActu.this).getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", en.getText().toString());
            values.put("number", ei.getText().toString());
            values.put("course_id", getIntent().getIntExtra("id", 0));
            db.insert("STUDENT", null, values);
            finish();
        });
    }
}