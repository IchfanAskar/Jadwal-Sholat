package com.example.hijiriakalender;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hijiriakalender.model.HijriResponse.DataBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<DataBean> dataBeanList;
//    private Context context;

    public RecycleViewAdapter(List<DataBean> dataBeanList){
 //       this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.tvTanggal.setText(dataBeanList.get(i).getDate().getReadable());
        holder.tvSubuh.setText(dataBeanList.get(i).getTimings().getFajr());
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTanggal, tvSubuh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.text_tanggal);
            tvSubuh = itemView.findViewById(R.id.text_subuh);
        }
    }
}
