package com.apps.kunalfarmah.connect_my_match_assign;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudyAdapter extends RecyclerView.Adapter<StudyAdapter.myViewHolder> {

    Context mContext;
    List<Study> studylist;

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView title,perc;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.name);
            perc = itemView.findViewById(R.id.percent);
        }
    }

    public StudyAdapter(Context context, ArrayList<Study> studylist){
        mContext = context;
        this.studylist = studylist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item_main,viewGroup,false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder viewHolder, int i) {

        Study data = studylist.get(i);
        viewHolder.img.setBackground(mContext.getResources().getDrawable(data.getImgID())
        );
        viewHolder.title.setText(data.getHeader());
        viewHolder.perc.setText(String.valueOf(data.getPerc()));
    }

    @Override
    public int getItemCount() {
        return studylist.size();
    }
}
