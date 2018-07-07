package com.example.ero.week2_homework_2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Serializable {
    private Context context;
    private List<Model> list;
    private int i = 0;


    public MyAdapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder (final MyViewHolder holder, final int position) {
        final Model model = list.get(position);
        holder.title.setText(model.getTitle());
        Picasso.get().load(model.getImageUrl()).into(holder.image);
        holder.likeCounter.setText(String.valueOf(i));
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2ActivitySecond.class);
               // intent.putExtra("e", list.get(position).getTitle());
                intent.putExtra("e", model.getTitle());
                intent.putExtra("q", model.getImageUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView title;
        private final ImageButton like;
        private final ImageButton comment;
        private final TextView likeCounter;
        private final TextView commenCounter;

        public MyViewHolder(final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image1);
            title = itemView.findViewById(R.id.title);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            likeCounter = itemView.findViewById(R.id.likeCounter);
            commenCounter = itemView.findViewById(R.id.commentCounter);

            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.like:
                            ++i;
                            likeCounter.setText(String.valueOf(i));
                            break;
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int i = getAdapterPosition();
                    list.remove(i);
                    notifyDataSetChanged();
                    return false;
                }
            });
        }
    }
}
