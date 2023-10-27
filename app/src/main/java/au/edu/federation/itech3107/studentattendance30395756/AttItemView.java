package au.edu.federation.itech3107.studentattendance30395756;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AttItemView extends RecyclerView.ViewHolder {


    TextView tx;
    TextView tv;
    TextView ts;

    public AttItemView(View itemView) {
        super(itemView);
        tx = itemView.findViewById(R.id.textStudentNumber);
        tv = itemView.findViewById(R.id.textStudentName);
        ts = itemView.findViewById(R.id.textStatus);
    }

    public TextView getTx() {
        return tx;
    }

    public void setTx(TextView tx) {
        this.tx = tx;
    }

    public TextView getTv() {
        return tv;
    }

    public void setTv(TextView tv) {
        this.tv = tv;
    }

    public TextView getTs() {
        return ts;
    }

    public void setTs(TextView ts) {
        this.ts = ts;
    }
}