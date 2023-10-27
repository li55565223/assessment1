package au.edu.federation.itech3107.studentattendance30395756;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AdShowClick {
    public void b1click(EditText e, AdShow adShow, SQLiteDatabase db, Integer id, RecyclerView view1) {
        e.setOnClickListener(view -> {
            final Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            int y = calendar.get(Calendar.YEAR);
            int d = calendar.get(Calendar.DAY_OF_MONTH);
            new DatePickerDialog(adShow, (datePicker, selectedYear, selectedMonth, selectedDay) -> {
                String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                List<Attendance> atts = new ArrayList<>();
                String query = "SELECT id, student_id, student_number, student_name, status  FROM ATTENDANCE where course_id = ? and date = ?";
                Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id), selectedDate});
                if (cursor.moveToFirst()) {
                    do {
                        Integer i = cursor.getInt(0);
                        Integer sid = cursor.getInt(1);
                        String sn = cursor.getString(2);
                        String sname = cursor.getString(3);
                        Integer status = cursor.getInt(4);
                        Attendance attendance = new Attendance(i, sid, sn, sname, id, status);
                        atts.add(attendance);
                    } while (cursor.moveToNext());
                }
                cursor.close();
                e.setText(selectedDate);
                view1.setAdapter(new RecyclerView.Adapter<AttItemView>() {
                    @NonNull
                    @Override
                    public AttItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        return new AttItemView(adShow.getLayoutInflater().inflate(R.layout.item_att_i, null));
                    }

                    @Override
                    public void onBindViewHolder(@NonNull AttItemView holder, int position) {
                        Attendance attendance = atts.get(position);
                        if (attendance.getType() == 0) {
                            holder.ts.setText("not checked");
                        } else {
                            holder.ts.setText("checked");
                        }
                        holder.tx.setText("Number: " + attendance.getNumber());
                        holder.tv.setText("Name: " + attendance.getName());
                    }

                    @Override
                    public int getItemCount() {
                        return atts.size();
                    }
                });
            }, y, month, d).show();
        });
    }

}
