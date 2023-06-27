package com.example.hoctiengnhat.BaiMinna;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoctiengnhat.R;


public class Tab extends Fragment {
    private static final String ARG_POSITION = "position";
    private int position;

    public static Tab newInstance(int position) {
        Tab f = new Tab();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    public Tab() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);

        CardView c1, c2, c3, c4, c5;
        c1 = (CardView) rootView.findViewById(R.id.c1mn2);
        c2 = (CardView) rootView.findViewById(R.id.c2mn2);
        c3 = (CardView) rootView.findViewById(R.id.c3mn2);
        c4 = (CardView) rootView.findViewById(R.id.c4mn2);
        c5 = (CardView) rootView.findViewById(R.id.c5mn2);
//            s=getArguments().getInt(ARG_SECTION_NUMBER);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HienThiHoiThoai.class);
                intent.putExtra("tabsht", position + 2);
                startActivity(intent);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HienThiTuVung.class);
                intent.putExtra("tabstv", position + 2);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HienThiNguPhap.class);
                intent.putExtra("tabsnp", position);
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HienThiHoiThoaiMau.class);
                intent.putExtra("tabshtm", position);
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HienThiTuVungThem.class);
                intent.putExtra("tabstvt", position);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
