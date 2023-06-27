package com.example.hoctiengnhat.BoThu;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hoctiengnhat.DatabaseHelper;
import com.example.hoctiengnhat.R;

import java.util.ArrayList;

public class TabBoThu extends Fragment {
    private ListView lv;
    private BoThuAdapter adapter;
    private DatabaseHelper databaseHelper;
    private ArrayList<ThuocTinhBoThu> arrayList;
    private ThuocTinhBoThu tt;

    private static final String ARG_POSITION = "position";
    private int position;
    private View v;

    public static TabBoThu newInstance(int position) {
        TabBoThu f = new TabBoThu();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    public TabBoThu() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tab_bo_thu, container, false);
        lv = (ListView) v.findViewById(R.id.lvBoThu);
        int c=position+1;
        hienThi(c);
        return v;
    }

    private void hienThi(int bo) {
        databaseHelper = new DatabaseHelper(getActivity());
        arrayList = new ArrayList<>();
        databaseHelper.copyDB();

        String query = "SELECT * FROM tblBoThu WHERE bo = " + bo + "";
        Cursor cursor = databaseHelper.getCursor(query);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                tt = new ThuocTinhBoThu(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5));
                arrayList.add(tt);
            } while (cursor.moveToNext());
        }
        cursor.close();
        adapter = new BoThuAdapter(getActivity(), R.layout.item_bothu, arrayList);
        lv.setAdapter(adapter);

    }
}
