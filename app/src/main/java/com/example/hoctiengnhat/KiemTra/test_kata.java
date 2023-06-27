package com.example.hoctiengnhat.KiemTra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoctiengnhat.R;

import java.util.Random;

public class test_kata extends AppCompatActivity {
    boolean ok=false;
    Button button1,button2;
    int randomId = new Random().nextInt(104)+0 ;
    String[] katakana={"ア","イ","ウ","エ","オ","カ","キ","ク","ケ","コ","ガ","ギ","グ","ゲ","ゴ","サ","シ","ス","セ","ソ","ザ","ジ","ズ","ゼ","ゾ","タ","チ","ツ","テ","ト","ダ","ヂ","ヅ","デ","ド","ナ","ニ","ヌ","ネ","ノ","ハ","ヒ","フ","へ","ホ","バ","ビ","ブ","ベ","ボ","パ","ピ","プ","ペ","ポ","マ","ミ","ム","メ","モ","ヤ","ユ","ヨ","ラ","リ","ル","レ","ロ","ワ","ヲ","ン","キャ","キュ","キョ","ギャ","ギュ","ギョ","シャ","シュ","ショ","ジャ","ジュ","ジョ","チャ","チュ","チョ","ニャ","ニュ","ニョ","ヒャ","ヒュ","ヒョ","ビャ","ビュ","ビョ","ピャ","ピュ","ピョ","ミャ","ミュ","ミョ","リャ","リュ","リョ"};
    String[] romanji={"a" ,"i","u","e","o","ka","ki","ku","ke","ko","ga","gi","gu","ge","go","sa","shi","su","se","so","za","ji","zu","ze","zo","ta","chi","tsu","te","to","da","ji","zu","de","do","na","ni","nu","ne","no","ha","hi","fu","he","ho","ba","bi","bu","be","bo","pa","pi","pu","pe","po","ma","mi","mu","me","mo","ya","yu","yo","ra","ri","ru","re","ro","wa","wo","n","kya","kyu","kyo","gya","gyu","gyo","sha","shu","sho","ja","ju","jo","cha","chu","cho","nya","nyu","nyo","hya","hyu","hyo","bya","byu","byo","pya","pyu","pyo","mya","myu","myo","rya","ryu","ryo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_kata);
        TextView kView = (TextView) findViewById(R.id.KView);
        kView.setText(katakana[randomId]);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button1 = findViewById(R.id.check);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer, answer2;
                EditText rView = (EditText) findViewById(R.id.RView);
                answer = rView.getText().toString();
                answer2 = answer.toLowerCase();
                if (romanji[randomId].equals(answer2)) {
                    Toast.makeText(test_kata.this,
                            "Đúng rồi !", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(test_kata.this, test_kata.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(test_kata.this,
                            "Sai rồi!", Toast.LENGTH_LONG).show();
                    TextView aView = (TextView) findViewById(R.id.AView);
                    aView.setText(romanji[randomId]);
                    rView.setText("");
                    Intent intent = new Intent(test_kata.this, test_kata.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        button2 = findViewById(R.id.swwtichkata);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test_kata.this, test_hira.class));
                finish();
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



}
