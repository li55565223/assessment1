package au.edu.federation.itech3107.studentattendance30395756;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.List;

public class AdIncreaseClickHandle {
    public AdIncreaseClickHandle() {
    }


    public void b1Click(EditText etDate, AdIncrease adIncrease) {
        etDate.setOnClickListener(view -> {
            final Calendar calendar = Calendar.getInstance();
            int yr = calendar.get(Calendar.YEAR);
            int dy = calendar.get(Calendar.DAY_OF_MONTH);
            int mt = calendar.get(Calendar.MONTH);

            DatePickerDialog dp = new DatePickerDialog(adIncrease, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                    String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                    EditText e = adIncrease.findViewById(R.id.etDate);
                    e.setText(selectedDate);
                }
            }, yr, mt, dy);
            dp.show();
        });
    }

    public void b2Click(Button button, List<Student> stus, List<AdIncreaseItem> hos, Spinner e1, SQLiteDatabase d1, AdIncrease adIncrease) {
        button.setOnClickListener(view -> {
            for (int i = 0; i < stus.size(); i++) {
                Student student = stus.get(i);
                AdIncreaseItem adIncreaseItem = hos.get(i);
                ContentValues values = new ContentValues();
                values.put("student_id", student.getId());
                values.put("student_number", student.getNumber());
                values.put("student_name", student.getName());
                values.put("course_id", student.getIid());
                values.put("date", e1.getSelectedItem().toString());
                values.put("status", !adIncreaseItem.ch.isChecked() ? 0 : 1);
                d1.insert("ATTENDANCE", null, values);
            }
            adIncrease.finish();
        });
    }
}

