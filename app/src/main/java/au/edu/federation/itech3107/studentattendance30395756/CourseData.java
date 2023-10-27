package au.edu.federation.itech3107.studentattendance30395756;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CourseData {
    public List<Course> getData(SQLiteDatabase database) {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT id, name, start_time, end_time FROM COURSE";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Integer id = cursor.getInt(0);
                String name = cursor.getString(1);
                String start_name = cursor.getString(2);
                String end_time = cursor.getString(3);
                Course course = new Course(id, name, start_name, end_time);
                courses.add(course);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return courses;
    }
}
