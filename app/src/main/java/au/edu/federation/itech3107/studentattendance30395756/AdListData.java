package au.edu.federation.itech3107.studentattendance30395756;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AdListData {
    private final String str = "SELECT id, number, name FROM STUDENT where course_id = ?";

    public List<Student> adDataList(Integer index, SQLiteDatabase database) {
        List<Student> students = new ArrayList<>();
        Cursor cursor = database.rawQuery(str, new String[]{String.valueOf(index)});
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
