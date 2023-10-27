package au.edu.federation.itech3107.studentattendance30395756;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StuAdap {

    private final StuQuerActy stuQuerActy;
    private final List<Student> studentList;
    public RecyclerView.Adapter<StuItem> ad = new RecyclerView.Adapter<StuItem>() {
        @NonNull
        @Override
        public StuItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View courseItemView = stuQuerActy.getLayoutInflater().inflate(R.layout.item_stu, null);
            return new StuItem(courseItemView);
        }

        @Override
        public void onBindViewHolder(@NonNull StuItem holder, int position) {
            Student student = studentList.get(position);
            holder.TN.setText("number: " + student.getNumber());
            holder.tv.setText("name: " + student.getName());
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }
    };

    public StuAdap(StuQuerActy stuQuerActy, List<Student> studentList) {
        this.stuQuerActy = stuQuerActy;
        this.studentList = studentList;
    }
}
