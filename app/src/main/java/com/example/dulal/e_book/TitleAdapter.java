package com.example.dulal.e_book;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextServicesManager;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dulal on 1/18/2019.
 */

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<String> titlelist;
    private CustonClickLissenar clickLissenar;

    public TitleAdapter(Context mContext, ArrayList<String> titlelist, CustonClickLissenar clickLissenar) {
        this.titlelist = titlelist;
        this.clickLissenar = clickLissenar;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.title_layout,parent, false);
        final MyViewHolder viewHolder= new MyViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLissenar.onItemClick(view,viewHolder.getPosition());
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.titletext.setText(titlelist.get(position).replace("-", " "));

    }

    @Override
    public int getItemCount() {
        return titlelist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titletext;

        public MyViewHolder(View itemView) {
            super(itemView);

            titletext = (TextView) itemView.findViewById(R.id.title_text);
        }
    }
}
