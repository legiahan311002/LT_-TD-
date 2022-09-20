package com.example.listviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;



    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        ImageView intHinh ;
        TextView txtTen,txtMoTa;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;
        if(view == null ){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view  = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.txtTen = (TextView) view.findViewById(R.id.textview1);
            holder.txtMoTa = (TextView) view.findViewById(R.id.textview2);
            holder.intHinh = (ImageView) view.findViewById(R.id.image1);
            view.setTag(holder);


        }else{
            holder = (ViewHolder) view.getTag();
        }

        TraiCay traiCay = traiCayList.get(position);
        holder.txtTen.setText(traiCay.getTen());
        holder.txtMoTa.setText(traiCay.getMoTa());
        holder.intHinh.setImageResource(traiCay.getHinh());


        return view;
    }
}
