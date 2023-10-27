package au.edu.federation.itech3107.studentattendance30395756;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdIncrease extends AppCompatActivity {
    private SQLiteDatabase d1;


    public void setOp() {
        String query = "SELECT id, name, start_time, end_time FROM COURSE where id  = ?";
        Cursor cursor = d1.rawQuery(query, new String[]{String.valueOf(getIntent().getIntExtra("id", 0))});
        if (cursor.moveToFirst()) {
            String start_name = cursor.getString(2);
            String end_time = cursor.getString(3);

            Spinner sss = findViewById(R.id.sin);

            String startDateStr = start_name;
            String endDateStr = end_time;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();
            ArrayList<String> dates = new ArrayList<>();
            try {
                Date startDateParsed = sdf.parse(startDateStr);
                Date endDateParsed = sdf.parse(endDateStr);

                startDate.setTime(startDateParsed);
                endDate.setTime(endDateParsed);
                int dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
                while (startDate.before(endDate)) {
                    if (startDate.get(Calendar.DAY_OF_WEEK) == dayOfWeek) {
                        dates.add(sdf.format(startDate.getTime()));
                    }
                    startDate.add(Calendar.DAY_OF_MONTH, 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dates.toArray(new String[0]));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sss.setAdapter(adapter);
        }
        cursor.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_a);
        RecyclerView ryvie = findViewById(R.id.recyclerView);
        Spinner inner = findViewById(R.id.sin);
        d1 = new LiteSQL(this).getWritableDatabase();
        Button bon = findViewById(R.id.btnSubmit);
        setOp();
        AdIncreaseClickHandle adIncreaseClickHandle = new AdIncreaseClickHandle();
        AdListData adListData = new AdListData();
        List<Student> slist = adListData.adDataList(getIntent().getIntExtra("id", 0), d1);
        final List<AdIncreaseItem> viewHolderList = new ArrayList<>();
        ryvie.setLayoutManager(new LinearLayoutManager(this));
        ryvie.setAdapter(new AdIncreaseAdapter(viewHolderList, this, slist));
        adIncreaseClickHandle.b2Click(bon, slist, viewHolderList, inner, d1, this);
    }
}