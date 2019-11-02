package com.example.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends
        RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    List<MovieModel> listItem;
    TextView tvJudul,tvTahun,tvPenulis;
    View view;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener {
        void onClick(int position);
    }
    public void setOnItemClickListener(final OnItemClickListener
                                               mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }
    public MovieAdapter(Context ctx) {
        this.ctx = ctx;
        listItem = new ArrayList<>();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View v) {
            super(v);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_movie, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final
    int position) {
        MovieModel item = listItem.get(position);
        tvJudul = holder.itemView.findViewById(R.id.txt_judul_movie);
        tvPenulis = holder.itemView.findViewById(R.id.txt_penulis);
        tvTahun = holder.itemView.findViewById(R.id.txt_tahun);
        tvJudul.setText(item.getJudul());
        tvTahun.setText(item.getTahun());
        tvPenulis.setText(item.getPenulis());
        holder.itemView.setOnClickListener(new

    View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return listItem.size();
    }
    public void add(MovieModel item) {
        listItem.add(item);
        notifyItemInserted(listItem.size() + 1);
    }
    public void addAll(List<MovieModel> listItem) {
        for (MovieModel item : listItem) {
            add(item);
        }
    }
    public void removeAll() {
        listItem.clear();
        notifyDataSetChanged();
    }
    public void remove(int pos) {
        listItem.remove(pos);
        notifyDataSetChanged();
    }
    public void swap(List<MovieModel> datas) {
        if (datas == null || datas.size() == 0) listItem.clear();
        if (listItem != null && listItem.size() > 0)
            listItem.clear();
        listItem.addAll(datas);
        notifyDataSetChanged();
    }
    public MovieModel getItem(int pos) {
        return listItem.get(pos);
    }
    public void setFilter(List<MovieModel> list) {
        listItem = new ArrayList<>();
        listItem.addAll(list);
        notifyDataSetChanged();
    }
    public List<MovieModel> getListItem() {
        return listItem;
    }
}