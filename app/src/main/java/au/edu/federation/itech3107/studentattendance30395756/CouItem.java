package au.edu.federation.itech3107.studentattendance30395756;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CouItem extends RecyclerView.ViewHolder {
    final TextView tv;
    final TextView ti;
    final TextView te;
    public CouItem(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.textCourseName);
        ti = itemView.findViewById(R.id.textCourseStart);
        te = itemView.findViewById(R.id.textCourseEnd);
    }

    public CouItem(@NonNull View itemView, TextView tv, TextView ti, TextView te) {
        super(itemView);
        this.tv = tv;
        this.ti = ti;
        this.te = te;
    }

    public TextView getTv() {
        return tv;
    }

    public TextView getTi() {
        return ti;
    }

    public TextView getTe() {
        return te;
    }
}