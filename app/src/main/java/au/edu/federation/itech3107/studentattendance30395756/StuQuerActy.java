package au.edu.federation.itech3107.studentattendance30395756;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StuQuerActy extends AppCompatActivity {
    private RecyclerView rw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_l);
        findViewById(R.id.btnAddStudent).setOnClickListener(view -> {
            Intent intent = new Intent(StuQuerActy.this, StuInActu.class);
            intent.putExtra("id", getIntent().getIntExtra("id", 0));
            startActivity(intent);
        });
        rw = findViewById(R.id.recyclerView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final List<Student> studentList = new StuData().data(getIntent().getIntExtra("id", 0), this);
        rw.setLayoutManager(new LinearLayoutManager(this));
        StuAdap stuAdap = new StuAdap(this, studentList);
        rw.setAdapter(stuAdap.ad);
    }


}