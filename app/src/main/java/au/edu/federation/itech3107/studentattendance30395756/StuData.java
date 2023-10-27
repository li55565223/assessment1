package au.edu.federation.itech3107.studentattendance30395756;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class StuData {
    String str = "SELECT id, number, name FROM STUDENT where course_id = ?";

    public List<Student> data(Integer index, StuQuerActy stuQuerActy) {
        List<Student> students = new ArrayList<>();
        Cursor cursor = new LiteSQL(stuQuerActy).getReadableDatabase().rawQuery(str, new String[]{String.valueOf(index)});
        if (cursor.moveToFirst()) {
            do {
                Integer id = cursor.getInt(0);
                String number = cursor.getString(1);
                String name = cursor.getString(2);
                Student student = new Student(id, name, number, index);
                students.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return students;
    }
}
