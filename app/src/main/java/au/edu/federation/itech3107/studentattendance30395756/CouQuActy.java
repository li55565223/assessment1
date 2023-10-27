package au.edu.federation.itech3107.studentattendance30395756;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CouQuActy extends AppCompatActivity {
    private RecyclerView rc;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cou_l);
        db = new LiteSQL(this).getReadableDatabase();
        rc = findViewById(R.id.recyclerView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final List<Course> courseList = new CourseData().getData(db);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(new CourAdapt(this, courseList));
        findViewById(R.id.btnAddCourse).setOnClickListener(view -> startActivity(new Intent(CouQuActy.this, CouIncreActy.class)));
    }

}