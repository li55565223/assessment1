package au.edu.federation.itech3107.studentattendance30395756;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AdShow extends AppCompatActivity {
    EditText ed;
    private RecyclerView rc;
    private SQLiteDatabase db;
    private Integer ind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_l);
        db = new LiteSQL(this).getReadableDatabase();
        ind = getIntent().getIntExtra("id", 0);
        rc = findViewById(R.id.recyclerView);
        rc.setLayoutManager(new LinearLayoutManager(this));
        ed = findViewById(R.id.etDate);
        AdShowClick adShowClick = new AdShowClick();
        adShowClick.b1click(ed, this, db, ind, rc);
    }

}