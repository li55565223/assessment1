package au.edu.federation.itech3107.studentattendance30395756;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StuItem extends RecyclerView.ViewHolder {
    TextView TN;
    TextView tv;

    public StuItem(View itemView) {
        super(itemView);
        TN = itemView.findViewById(R.id.textStudentNumber);
        tv = itemView.findViewById(R.id.textStudentName);
    }

    public StuItem(@NonNull View itemView, TextView TN, TextView tv) {
        super(itemView);
        this.TN = TN;
        this.tv = tv;
    }

    public TextView getTN() {
        return TN;
    }

    public void setTN(TextView TN) {
        this.TN = TN;
    }

    public TextView getTv() {
        return tv;
    }

    public void setTv(TextView tv) {
        this.tv = tv;
    }
}