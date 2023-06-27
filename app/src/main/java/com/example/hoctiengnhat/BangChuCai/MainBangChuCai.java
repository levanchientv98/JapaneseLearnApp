package com.example.hoctiengnhat.BangChuCai;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hoctiengnhat.DatabaseHelper;
import com.example.hoctiengnhat.R;

import java.util.ArrayList;
import java.util.Locale;

public class MainBangChuCai extends AppCompatActivity {
    // khai báo lớp SectionsPagerAdapter
    private SectionsPagerAdapter mSectionsPagerAdapter;
    // khai báo viewPager
    private ViewPager mViewPager;
    public static ArrayList<Integer> arrWriting;
    public static ArrayList<Integer> arrWriting1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bang_chu_cai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Bảng chữ cái");

        // khởi tạo SectionsPagerAdapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // tham chiếu ViewPager tới ViewPager tại layout activity_main_bang_chu_cai
        mViewPager = (ViewPager) findViewById(R.id.containerbcc);
        // thiết lập các giá trị cho tab
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // khai báo TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsbcc);
        // thiết lập khung nhìn cho TabLayout
        tabLayout.setupWithViewPager(mViewPager);

        arrWriting = new ArrayList<>();
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.i);
        arrWriting.add(R.drawable.u);
        arrWriting.add(R.drawable.e);
        arrWriting.add(R.drawable.o);
        arrWriting.add(R.drawable.ka);
        arrWriting.add(R.drawable.ki);
        arrWriting.add(R.drawable.ku);
        arrWriting.add(R.drawable.ke);
        arrWriting.add(R.drawable.ko);
        arrWriting.add(R.drawable.sa);
        arrWriting.add(R.drawable.shi);
        arrWriting.add(R.drawable.su);
        arrWriting.add(R.drawable.se);
        arrWriting.add(R.drawable.so);
        arrWriting.add(R.drawable.ta);
        arrWriting.add(R.drawable.chi);
        arrWriting.add(R.drawable.tsu);
        arrWriting.add(R.drawable.te);
        arrWriting.add(R.drawable.to);
        arrWriting.add(R.drawable.na);
        arrWriting.add(R.drawable.ni);
        arrWriting.add(R.drawable.nu);
        arrWriting.add(R.drawable.ne);
        arrWriting.add(R.drawable.no);
        arrWriting.add(R.drawable.ha);
        arrWriting.add(R.drawable.hi);
        arrWriting.add(R.drawable.fu);
        arrWriting.add(R.drawable.he);
        arrWriting.add(R.drawable.ho);
        arrWriting.add(R.drawable.ma);
        arrWriting.add(R.drawable.mi);
        arrWriting.add(R.drawable.mu);
        arrWriting.add(R.drawable.me);
        arrWriting.add(R.drawable.mo);
        arrWriting.add(R.drawable.ya);
        arrWriting.add(R.drawable.ri);
        arrWriting.add(R.drawable.yu);
        arrWriting.add(R.drawable.re);
        arrWriting.add(R.drawable.yo);
        arrWriting.add(R.drawable.ra);
        arrWriting.add(R.drawable.ri);
        arrWriting.add(R.drawable.ru);
        arrWriting.add(R.drawable.re);
        arrWriting.add(R.drawable.ro);
        arrWriting.add(R.drawable.wa);
        arrWriting.add(R.drawable.i);
        arrWriting.add(R.drawable.u);
        arrWriting.add(R.drawable.e);
        arrWriting.add(R.drawable.wo);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.i);
        arrWriting.add(R.drawable.u);
        arrWriting.add(R.drawable.e);
        arrWriting.add(R.drawable.n);
        arrWriting.add(R.drawable.ga);
        arrWriting.add(R.drawable.gi);
        arrWriting.add(R.drawable.gu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.go);
        arrWriting.add(R.drawable.za);
        arrWriting.add(R.drawable.zi);
        arrWriting.add(R.drawable.zu);
        arrWriting.add(R.drawable.ze);
        arrWriting.add(R.drawable.zo);
        arrWriting.add(R.drawable.da);
        arrWriting.add(R.drawable.di);
        arrWriting.add(R.drawable.du);
        arrWriting.add(R.drawable.de);
        arrWriting.add(R.drawable.ddo);
        arrWriting.add(R.drawable.ba);
        arrWriting.add(R.drawable.bi);
        arrWriting.add(R.drawable.bu);
        arrWriting.add(R.drawable.be);
        arrWriting.add(R.drawable.bo);
        arrWriting.add(R.drawable.pa);
        arrWriting.add(R.drawable.pi);
        arrWriting.add(R.drawable.pu);
        arrWriting.add(R.drawable.pe);
        arrWriting.add(R.drawable.po);
        arrWriting.add(R.drawable.kya);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.kyu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.kyo);
        arrWriting.add(R.drawable.sha);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.shu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.sho);
        arrWriting.add(R.drawable.cha);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.chu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.cho);
        arrWriting.add(R.drawable.nya);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.nyu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.nyo);
        arrWriting.add(R.drawable.hya);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.hyu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.hyo);
        arrWriting.add(R.drawable.mya);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.myu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.myo);
        arrWriting.add(R.drawable.rya);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.ryu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.ryo);
        arrWriting.add(R.drawable.gya);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.gyu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.gyo);
        arrWriting.add(R.drawable.ja);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.ju);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.jo);
        arrWriting.add(R.drawable.bya);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.byu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.byo);
        arrWriting.add(R.drawable.pya);
        arrWriting.add(R.drawable.a);
        arrWriting.add(R.drawable.pyu);
        arrWriting.add(R.drawable.ge);
        arrWriting.add(R.drawable.pyo);


        arrWriting1 = new ArrayList<>();
        arrWriting1.add(R.drawable.a_kata);
        arrWriting1.add(R.drawable.i_kata);
        arrWriting1.add(R.drawable.u_kata);
        arrWriting1.add(R.drawable.e_kata);
        arrWriting1.add(R.drawable.o_kata);
        arrWriting1.add(R.drawable.ka_kata);
        arrWriting1.add(R.drawable.ki_kata);
        arrWriting1.add(R.drawable.ku_kata);
        arrWriting1.add(R.drawable.ke_kata);
        arrWriting1.add(R.drawable.ko_kata);
        arrWriting1.add(R.drawable.sa_kata);
        arrWriting1.add(R.drawable.shi_kata);
        arrWriting1.add(R.drawable.su_kata);
        arrWriting1.add(R.drawable.se_kata);
        arrWriting1.add(R.drawable.so_kata);
        arrWriting1.add(R.drawable.ta_kat);
        arrWriting1.add(R.drawable.chi_kata);
        arrWriting1.add(R.drawable.tsu_kata);
        arrWriting1.add(R.drawable.te_kata);
        arrWriting1.add(R.drawable.to_kata);
        arrWriting1.add(R.drawable.na_kata);
        arrWriting1.add(R.drawable.ni_kata);
        arrWriting1.add(R.drawable.nu_kata);
        arrWriting1.add(R.drawable.ne_kata);
        arrWriting1.add(R.drawable.no_kata);
        arrWriting1.add(R.drawable.ha_kata);
        arrWriting1.add(R.drawable.hi_kata);
        arrWriting1.add(R.drawable.fu_kata);
        arrWriting1.add(R.drawable.he_kata);
        arrWriting1.add(R.drawable.ho_kata);
        arrWriting1.add(R.drawable.ma_kata);
        arrWriting1.add(R.drawable.mi_kata);
        arrWriting1.add(R.drawable.mu_kata);
        arrWriting1.add(R.drawable.me_kata);
        arrWriting1.add(R.drawable.mo_kata);
        arrWriting1.add(R.drawable.ya_kata);
        arrWriting1.add(R.drawable.ri_kata);
        arrWriting1.add(R.drawable.yu_kata);
        arrWriting1.add(R.drawable.re_kana);
        arrWriting1.add(R.drawable.yo_kata);
        arrWriting1.add(R.drawable.ra_kata);
        arrWriting1.add(R.drawable.ri_kata);
        arrWriting1.add(R.drawable.ru_kata);
        arrWriting1.add(R.drawable.re_kana);
        arrWriting1.add(R.drawable.ro_kata);
        arrWriting1.add(R.drawable.wa_kata);
        arrWriting1.add(R.drawable.i_kata);
        arrWriting1.add(R.drawable.u_kata);
        arrWriting1.add(R.drawable.e_kata);
        arrWriting1.add(R.drawable.wo_kata);
        arrWriting1.add(R.drawable.a_kata);
        arrWriting1.add(R.drawable.i_kata);
        arrWriting1.add(R.drawable.u_kata);
        arrWriting1.add(R.drawable.e_kata);
        arrWriting1.add(R.drawable.n_kata);
        arrWriting1.add(R.drawable.ga_kata);
        arrWriting1.add(R.drawable.gi_kata);
        arrWriting1.add(R.drawable.gu_kata);
        arrWriting1.add(R.drawable.ge_kata);
        arrWriting1.add(R.drawable.go_kata);
        arrWriting1.add(R.drawable.za_kata);
        arrWriting1.add(R.drawable.zi__kata);
        arrWriting1.add(R.drawable.zu_kata);
        arrWriting1.add(R.drawable.ze_kata);
        arrWriting1.add(R.drawable.zo_kata);
        arrWriting1.add(R.drawable.da_kata);
        arrWriting1.add(R.drawable.de_kata);
        arrWriting1.add(R.drawable.do_kata);
        arrWriting1.add(R.drawable.ba_kata);
        arrWriting1.add(R.drawable.bi_kata);
        arrWriting1.add(R.drawable.bu_kata);
        arrWriting1.add(R.drawable.be_kata);
        arrWriting1.add(R.drawable.bo_kata);
        arrWriting1.add(R.drawable.pa_kata);
        arrWriting1.add(R.drawable.pi_kata);
        arrWriting1.add(R.drawable.pu_kata);
        arrWriting1.add(R.drawable.pe_kata);
        arrWriting1.add(R.drawable.po_kata);
        arrWriting1.add(R.drawable.kya_kata);
        arrWriting1.add(R.drawable.a_kata);
        arrWriting1.add(R.drawable.kyu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.kyo_kata);
        arrWriting1.add(R.drawable.sha_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.shu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.sho_kata);
        arrWriting1.add(R.drawable.cha_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.chu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.cho_kata);
        arrWriting1.add(R.drawable.nya_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.nyu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.nyo_kata);
        arrWriting1.add(R.drawable.hya_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.hyu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.hyo_kata);
        arrWriting1.add(R.drawable.mya_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.myu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.myo_kata);
        arrWriting1.add(R.drawable.rya_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.ryu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.ryo_kata);
        arrWriting1.add(R.drawable.gya_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.gyu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.gyo_kata);
        arrWriting1.add(R.drawable.ja_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.ju_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.jo_kata);
        arrWriting1.add(R.drawable.bya_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.byu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.byo_kata);
        arrWriting1.add(R.drawable.pya_kata);
        arrWriting1.add(R.drawable.a);
        arrWriting1.add(R.drawable.pyu_kata);
        arrWriting1.add(R.drawable.ge);
        arrWriting1.add(R.drawable.pyo_kata);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        private TextToSpeech toSpeech;
        private DatabaseHelper databaseHelper;
        private ArrayList<ThuocTinhBangChuCai> arrayList;
        private GridView gv;
        private ThuocTinhBangChuCai ttbcc;
        private BangChuCaiAdapter adapter;
        private Animation animation1;
        private String chucai, vidu, colum, nghia;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_bang_chu_cai, container, false);
            arrayList = new ArrayList<>();
            databaseHelper = new DatabaseHelper(getActivity());
            gv = (GridView) rootView.findViewById(R.id.gvBCC);
            animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_in);

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                hienThi("seion");
                gv.setNumColumns(5);
            }
            else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                hienThi2("seion");
                gv.setNumColumns(5);
            }
            nghe();
            return rootView;
        }

        private void nghe() {
            toSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        toSpeech.setLanguage(Locale.getDefault());
                        toSpeech.setLanguage(Locale.JAPANESE);
                    }
                }
            });
        }

        private void hienThi(String t) {
            databaseHelper.copyDB();

            Cursor cursor = databaseHelper.getCursor("SELECT * FROM tblBCC WHERE Loai = '" + t + "'");
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                ttbcc = new ThuocTinhBangChuCai(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),cursor.getInt(7),cursor.getString(8));
                arrayList.add(ttbcc);
                cursor.moveToNext();
            }
            cursor.close();

            adapter = new BangChuCaiAdapter(getActivity(), R.layout.item_bangchucai, arrayList);
            gv.setAdapter(adapter);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    chucai = arrayList.get(position).getTuNhat();
                    vidu = arrayList.get(position).getChuThich();
                    colum = arrayList.get(position).getColum();
                    nghia = arrayList.get(position).getNghia();

                    final Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_bcc);
                    dialog.setTitle("Chi tiết từ");

                    TextView text1 = (TextView) dialog.findViewById(R.id.txtvViDuNhatBCCMain);
                    text1.setText(vidu);
                    TextView text2 = (TextView) dialog.findViewById(R.id.txtvViDuColumBCCMain);
                    text2.setText(colum);
                    TextView text3 = (TextView) dialog.findViewById(R.id.txtvViDuNghiaBCCMain);
                    text3.setText(nghia);
                    ImageView image = (ImageView) dialog.findViewById(R.id.imgLoaBCCMain);
                    ImageView imgWriting = dialog.findViewById(R.id.imgWriting);
                    if (chucai!=null) {Glide.with(getView()).load(arrWriting.get(position)).into(imgWriting);}
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String txt = chucai;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                toSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null, null);
                            }
                        }
                    });


                    ImageView dialogButton = (ImageView) dialog.findViewById(R.id.okiBCCMain2);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            });
        }

        private void hienThi2(String t) {

            databaseHelper.copyDB();
            Cursor cursor = databaseHelper.getCursor("SELECT * FROM tblBCC WHERE Loai = '" + t + "'");
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                ttbcc = new ThuocTinhBangChuCai(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),cursor.getInt(7),cursor.getString(8));
                arrayList.add(ttbcc);
                cursor.moveToNext();
            }
            cursor.close();

            BangChuCaiAdapterKata adapter22= new BangChuCaiAdapterKata(getActivity(), R.layout.item_bangchucai, arrayList);
            gv.setAdapter(adapter22);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    final String chucai2 = arrayList.get(position).getKata();
                    vidu = arrayList.get(position).getChuThich();
                    colum = arrayList.get(position).getColum();
                    nghia = arrayList.get(position).getNghia();

                    final Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_bcc);
                    dialog.setTitle("Chi tiết từ");

                    TextView text1 = (TextView) dialog.findViewById(R.id.txtvViDuNhatBCCMain);
                    text1.setText(vidu);
                    TextView text2 = (TextView) dialog.findViewById(R.id.txtvViDuColumBCCMain);
                    text2.setText(colum);
                    TextView text3 = (TextView) dialog.findViewById(R.id.txtvViDuNghiaBCCMain);
                    text3.setText(nghia);
                    ImageView image = (ImageView) dialog.findViewById(R.id.imgLoaBCCMain);
                    ImageView imgWriting = (ImageView) dialog.findViewById(R.id.imgWriting);
                    if(chucai2!= null) {Glide.with(getView()).load(arrWriting1.get(position)).into(imgWriting);}
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String txt = chucai2;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                toSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null, null);
                            }
                        }
                    });

                    ImageView dialogButton = (ImageView) dialog.findViewById(R.id.okiBCCMain2);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            });
        }

    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SEION";
                case 1:
                    return "SEION(KATA)";
            }
            return null;
        }
    }

}