package au.edu.federation.itech3107.studentattendance30395756;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AdIncreaseItem extends RecyclerView.ViewHolder {

    CheckBox ch;
    TextView te1;
    TextView te2;

    public AdIncreaseItem(View itemView) {
        super(itemView);
        te1 = itemView.findViewById(R.id.textStudentNumber);
        te2 = itemView.findViewById(R.id.textStudentName);
        ch = itemView.findViewById(R.id.checkBox);
    }

    public CheckBox getCh() {
        return ch;
    }

    public void setCh(CheckBox ch) {
        this.ch = ch;
    }

    public TextView getTe1() {
        return te1;
    }

    public void setTe1(TextView te1) {
        this.te1 = te1;
    }

    public TextView getTe2() {
        return te2;
    }

    public void setTe2(TextView te2) {
        this.te2 = te2;
    }
}