package au.edu.federation.itech3107.studentattendance30395756;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdIncreaseAdapter extends RecyclerView.Adapter<AdIncreaseItem> {
    private final List<AdIncreaseItem> vs;
    private final AdIncrease ad;
    private final List<Student> sl;
    public AdIncreaseAdapter(List<AdIncreaseItem> viewHolderList, AdIncrease adIncrease, List<Student> studentList) {
        this.vs = viewHolderList;
        this.ad = adIncrease;
        this.sl = studentList;
    }

    @NonNull
    @Override
    public AdIncreaseItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItemView = ad.getLayoutInflater().inflate(R.layout.item_atte_s, null);
        AdIncreaseItem adIncreaseItem = new AdIncreaseItem(courseItemView);
        vs.add(adIncreaseItem);
        return adIncreaseItem;
    }

    @Override
    public void onBindViewHolder(@NonNull AdIncreaseItem holder, int position) {
        Student student = sl.get(position);
        holder.te1.setText("Number: " + student.getNumber());
        holder.te2.setText("Name: " + student.getName());
    }

    @Override
    public int getItemCount() {
        return sl.size();
    }
}