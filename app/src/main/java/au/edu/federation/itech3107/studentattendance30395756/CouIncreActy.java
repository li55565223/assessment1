package au.edu.federation.itech3107.studentattendance30395756;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CouIncreActy extends AppCompatActivity {
    private Button bon;
    private EditText edi;
    private EditText et;
    private EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cou_a);
        bon = findViewById(R.id.btnAddCourse);
        edi = findViewById(R.id.etCourseName);
        et = findViewById(R.id.etStartTime);
        e = findViewById(R.id.etEndTime);
        CouIncreaseClick couIncreaseClick = new CouIncreaseClick();
        couIncreaseClick.b1click(et, this);
        couIncreaseClick.b2click(this, e);
        bon.setOnClickListener(view -> {
            ContentValues values = new ContentValues();
            values.put("name", edi.getText().toString());
            values.put("start_time", et.getText().toString());
            values.put("end_time", e.getText().toString());
            new LiteSQL(CouIncreActy.this).getWritableDatabase().insert("COURSE", null, values);
            finish();
        });
    }
}