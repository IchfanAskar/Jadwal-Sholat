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
        holder.tvDuhur.setText(dataBeanList.get(i).getTimings().getDhuhr());
        holder.tvAsar.setText(dataBeanList.get(i).getTimings().getAsr());
        holder.tvMagrib.setText(dataBeanList.get(i).getTimings().getMaghrib());
        holder.tvIsa.setText(dataBeanList.get(i).getTimings().getIsha());
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTanggal, tvSubuh, tvAsar, tvDuhur, tvMagrib, tvIsa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.text_tanggal);
            tvSubuh = itemView.findViewById(R.id.text_subuh);
            tvDuhur = itemView.findViewById(R.id.text_duhur);
            tvAsar = itemView.findViewById(R.id.text_asar);
            tvMagrib = itemView.findViewById(R.id.text_magrib);
            tvIsa = itemView.findViewById(R.id.text_isya);
        }
    }
}
