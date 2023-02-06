package com.companyname.quranapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.companyname.quranapp.R;

import org.jetbrains.annotations.NotNull;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.ViewHolder> {

    String [] swar;
    OnitemClickListener onitemClickListener;

    public void setOnitemClickListener(OnitemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    public QuranAdapter(String[] swar) {
        this.swar = swar;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sura_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
            String sura=swar[position];
            holder.textViewSura.setText(sura);

            if(onitemClickListener != null){
                holder.itemView.setOnClickListener(v -> {
                    onitemClickListener.onItemClik(position,swar[position]);
                });
            }
    }

    @Override
    public int getItemCount() {
        return swar.length;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView textViewSura;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewSura= itemView.findViewById(R.id.sura_tv);
        }
    }

    public interface OnitemClickListener{
        public void onItemClik(int position,String suraName);
    }

}
