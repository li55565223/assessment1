package au.edu.federation.itech3107.studentattendance30395756;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class CouIncreaseClick {

    public void b1click(EditText etStartTime, CouIncreActy couIncreActy) {
        etStartTime.setOnClickListener(view -> {
            final Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);

            DatePickerDialog d = new DatePickerDialog(couIncreActy, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                    String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                    EditText e = couIncreActy.findViewById(R.id.etStartTime);
                    e.setText(selectedDate);
                }
            }, year, month, day);
            d.show();
        });
    }
    public DatePickerDialog showDate(int year, int month, int day, CouIncreActy couIncreActy) {
        DatePickerDialog d = new DatePickerDialog(couIncreActy, (datePicker, selectedYear, selectedMonth, selectedDay) -> {
            String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
            EditText ed = couIncreActy.findViewById(R.id.etEndTime);
            ed.setText(selectedDate);
        }, year, month, day);
        return d;
    }
    public void b2click(CouIncreActy couIncreActy, EditText etEndTime) {

        etEndTime.setOnClickListener(view -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            showDate(year, month, day, couIncreActy).show();
        });
    }


}
