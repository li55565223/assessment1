package au.edu.federation.itech3107.studentattendance30395756;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourAdapt extends RecyclerView.Adapter<CouItem> {
    private final CouQuActy ca;
    private final List<Course> courseList;

    public CourAdapt(CouQuActy ca, List<Course> courseList) {
        this.ca = ca;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CouItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItemView = ca.getLayoutInflater().inflate(R.layout.couse_item, null);
        return new CouItem(courseItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CouItem holder, int position) {
        Course course = courseList.get(position);
        holder.tv.setText("title: " + course.getName());
        holder.ti.setText("start time: " + course.getSt());
        holder.te.setText("end time: " + course.getEt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ca, CourSett.class);
                intent.putExtra("id", course.getId());
                ca.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }
}

