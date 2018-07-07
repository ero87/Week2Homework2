package com.example.ero.week2_homework_2;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter2Second extends RecyclerView.Adapter<MyAdapter2Second.MyViewHolder2> {

    private Context context2;
    private List<Model2Second> list2;

    public MyAdapter2Second(List<Model2Second> list2, Context context2) {
        this.list2 = list2;
        this.context2 = context2;
    }

    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list2_item, parent, false);
        return new MyAdapter2Second.MyViewHolder2(itemView2);
    }

    @Override
    public void onBindViewHolder(MyViewHolder2 holder, final int position) {
        final Model2Second model22 = list2.get(position);
        holder.title22.setText(model22.getTitle2());
        holder.textView22.setText(model22.getTextView8());

    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {

        private final TextView title22;
        private final TextView textView22;

        public MyViewHolder2(View itemView2) {
            super(itemView2);
            title22 = itemView2.findViewById(R.id.title2);
            textView22 = itemView2.findViewById(R.id.text8);
        }
    }

}
