package com.example.hoctiengnhat.TimKiem;


import android.app.ActionBar;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.hoctiengnhat.BaiMinna.HienThiTuVung;
import com.example.hoctiengnhat.BaiMinna.ThuocTinhTuVung;
import com.example.hoctiengnhat.DatabaseHelper;
import com.example.hoctiengnhat.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class timkiemtuvung extends AppCompatActivity{

    private DatabaseHelper databaseHelper;
    private ThuocTinhTuVung ttbcc;
    private timkiemtuvung.TuVungAdapter adapter;
    private ArrayList<ThuocTinhTuVung> arrayList;
    private ArrayList<ThuocTinhTuVung> arrayListFiltered;
    private ListView lv;
    private TextToSpeech toSpeech;
    private SearchView editsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiemtuvung);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        databaseHelper=new DatabaseHelper(this);
        databaseHelper.copyDB();
        lv=(ListView)findViewById(R.id.listviewtimkiem);
        arrayList=new ArrayList<>();
        Cursor cursor=databaseHelper.getCursor("SELECT * FROM tblTuVung ");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ttbcc = new ThuocTinhTuVung(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getInt(4),cursor.getInt(5));
            arrayList.add(ttbcc);

            cursor.moveToNext();
        }
        nghe();
        adapter=new timkiemtuvung.TuVungAdapter(this, R.layout.item_tuvung,arrayList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        editsearch = findViewById(R.id.timkiem);
        editsearch.setActivated(true);
        editsearch.setQueryHint("Type your keyword here");
        editsearch.onActionViewExpanded();
        editsearch.setIconified(false);
        editsearch.clearFocus();
        editsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return true;
            }
        });

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }


    private void nghe() {
        toSpeech = new TextToSpeech(timkiemtuvung.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    toSpeech.setLanguage(Locale.getDefault());
                    toSpeech.setLanguage(Locale.JAPANESE);
                }
            }
        });
    }

    class TuVungAdapter extends ArrayAdapter<ThuocTinhTuVung>  {
        private Context context;
        ArrayList<ThuocTinhTuVung> listsong = new ArrayList<ThuocTinhTuVung>();
        ArrayList<ThuocTinhTuVung> mdataCopy= new ArrayList<ThuocTinhTuVung>();;
        ValueFilter valueFilter;
        int resource;

        public TuVungAdapter(Context context, int resource, List<ThuocTinhTuVung> listsong) {
            super(context, resource, listsong);
            this.context = context;
            this.resource = resource;
            this.listsong = (ArrayList<ThuocTinhTuVung>) listsong;
        }


        @Override
        public int getCount() {
            return listsong.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            final timkiemtuvung.TuVungAdapter.ViewHolder viewHolder;
            if (v == null) {
                LayoutInflater inflater;
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.item_tuvung, null);
                viewHolder = new timkiemtuvung.TuVungAdapter.ViewHolder();
                viewHolder.txtvAmNhat = (TextView) v.findViewById(R.id.txtvTuNhatTV);
                viewHolder.txtvAmViet = (TextView) v.findViewById(R.id.txtvTuVietTV);
                viewHolder.txtvHanTu = (TextView) v.findViewById(R.id.txtvHanTuTV);
                viewHolder.img=(ImageView)v.findViewById(R.id.imgloaTV);
                v.setTag(viewHolder);
            } else {
                viewHolder = (timkiemtuvung.TuVungAdapter.ViewHolder) convertView.getTag();
            }


            ThuocTinhTuVung ttbcc = listsong.get(position);
            viewHolder.txtvAmNhat.setText(ttbcc.getAmNhat());
            viewHolder.txtvAmViet.setText(ttbcc.getHanTu());
            viewHolder.txtvHanTu.setText(ttbcc.getAmViet());
            viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String txt = viewHolder.txtvAmNhat.getText().toString().trim();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        toSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            });
            return v;
        }
        @Override
        public Filter getFilter() {
            if (valueFilter == null) {
                valueFilter = new ValueFilter();
            }
            return valueFilter;
        }

        private class ValueFilter extends Filter {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                if(mdataCopy.size() == 0) {
                    mdataCopy = listsong;
                }
                if (constraint != null && constraint.length() > 0) {
                    List<ThuocTinhTuVung> filterList = new ArrayList<>();
                    for (int i = 0; i < mdataCopy.size(); i++) {
                        if ((mdataCopy.get(i).getAmNhat().toUpperCase()).startsWith(constraint.toString().toUpperCase())) {
                            filterList.add(mdataCopy.get(i));
                        }
                    }
                    results.count = filterList.size();
                    results.values = filterList;
                } else {
                    results.count = mdataCopy.size();
                    results.values = mdataCopy;
                }
                return results;

            }

            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                if(results.count > 0) {
                    listsong = (ArrayList<ThuocTinhTuVung>) results.values;
                }

                notifyDataSetChanged();
            }

        }
        class ViewHolder {
            TextView txtvAmNhat;
            TextView txtvAmViet;
            TextView txtvHanTu;
            ImageView img;
        }

    }
}