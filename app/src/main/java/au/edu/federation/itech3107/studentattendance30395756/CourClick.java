package au.edu.federation.itech3107.studentattendance30395756;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class CourClick {
    public void b1click(CourSett courSett) {
        courSett.findViewById(R.id.btnUpdateCourse).setOnClickListener(view -> {
            ContentValues values = new ContentValues();
            values.put("name", courSett.ec.getText().toString());
            values.put("start_time", courSett.e.getText().toString());
            values.put("end_time", courSett.eit.getText().toString());
            courSett.db.update("COURSE", values, "id = ?", new String[]{String.valueOf(courSett.id)});
            Toast.makeText(courSett, "success", Toast.LENGTH_SHORT).show();
        });
    }

    public void b2click(CourSett courSett) {
        courSett.findViewById(R.id.btnStudentList).setOnClickListener(view -> {
            Intent intent = new Intent(courSett, StuQuerActy.class);
            intent.putExtra("id", courSett.id);
            courSett.startActivity(intent);
        });
    }

    public void b3click(CourSett courSett) {
        courSett.findViewById(R.id.btnDeleteCourse).setOnClickListener(view -> {
            courSett.db.delete("COURSE", "id = ?", new String[]{String.valueOf(courSett.id)});
            courSett.finish();
        });
    }

    public void b4click(CourSett courSett) {
        courSett.findViewById(R.id.btnQueryAttendance).setOnClickListener(view -> {
            Intent intent = new Intent(courSett, AdShow.class);
            intent.putExtra("id", courSett.id);
            courSett.startActivity(intent);
        });
    }

    public void b5click(CourSett courSett) {
        courSett.findViewById(R.id.btnAddAttendance).setOnClickListener(view -> {
            Intent intent = new Intent(courSett, AdIncrease.class);
            intent.putExtra("id", courSett.id);
            courSett.startActivity(intent);
        });

    }
    public void b6click(CourSett courSett) {
        courSett.e.setOnClickListener(view -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog d = new DatePickerDialog(courSett, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                    String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                    EditText editText = courSett.findViewById(R.id.etStartTime);
                    editText.setText(selectedDate);
                }
            }, year, month, day);
            d.show();
        });
    }




    public void b7click(CourSett courSett) {
        courSett.eit.setOnClickListener(view -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(courSett, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                    String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                    EditText editText = courSett.findViewById(R.id.etEndTime);
                    editText.setText(selectedDate);
                }
            }, year, month, day);
            datePickerDialog.show();
        });
    }
}
