package com.example.hoctiengnhat.BangChuCai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hoctiengnhat.R;

import java.util.ArrayList;
import java.util.List;


public class BangChuCaiAdapter extends ArrayAdapter<ThuocTinhBangChuCai> {
    private Context context;
    ArrayList<ThuocTinhBangChuCai> listsong = new ArrayList<ThuocTinhBangChuCai>();
    int resource;

    public BangChuCaiAdapter(Context context, int resource, List<ThuocTinhBangChuCai> listsong) {
        super(context, resource, listsong);
        this.context = context;
        this.resource = resource;
        this.listsong = (ArrayList<ThuocTinhBangChuCai>) listsong;

    }
    @Override
    public int getCount() {
        return listsong.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder;

        if (v == null) {
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_bangchucai, null);
            viewHolder = new ViewHolder();

            viewHolder.txtvTuNhat = (TextView) v.findViewById(R.id.txtvBccTuNhat);
            viewHolder.txtvTuViet = (TextView) v.findViewById(R.id.txtvBccTuViet);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ThuocTinhBangChuCai ttbcc = listsong.get(position);

        viewHolder.txtvTuNhat.setText(ttbcc.getTuNhat());
        viewHolder.txtvTuViet.setText(ttbcc.getTuViet());
        return v;
    }

    static class ViewHolder {
        TextView txtvTuNhat;
        TextView txtvTuViet;

    }
}
