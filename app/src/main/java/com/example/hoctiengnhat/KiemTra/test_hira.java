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

public class test_hira extends AppCompatActivity {
    boolean ok=false;
    Button button1,button2;
    int randomId = new Random().nextInt(104)+0 ;
    String[] hiragana={"あ","い","う","え","お","か","き","く","け","こ","が","ぎ","ぐ","げ","ご","さ","し","す","せ","そ","ざ","じ","ず","ぜ","ぞ","た","ち","つ","て","と","だ","ぢ","づ","で","ど","な","に","ぬ","ね","の","は","ひ","ふ","へ","ほ","ば","び","ぶ","べ","ぼ","ぱ","ぴ","ぷ","ぺ","ぽ","ま","み","む","め","も","や","ゆ","よ","ら","り","る","れ","ろ","わ","を","ん","きゃ","きゅ","きょ","ぎゃ","ぎゅ","ぎょ","しゃ","しゅ","しょ","じゃ","じゅ","じょ","ちゃ","ちゅ","ちょ","にゃ","にゅ","にょ","ひゃ","ひゅ","ひょ","びゃ","びゅ","びょ","ぴゃ","ぴゅ","ぴょ","みゃ","みゅ","みょ","りゃ","りゅ","りょ"};
    String[] romanji={"a" ,"i","u","e","o","ka","ki","ku","ke","ko","ga","gi","gu","ge","go","sa","shi","su","se","so","za","ji","zu","ze","zo","ta","chi","tsu","te","to","da","ji","zu","de","do","na","ni","nu","ne","no","ha","hi","fu","he","ho","ba","bi","bu","be","bo","pa","pi","pu","pe","po","ma","mi","mu","me","mo","ya","yu","yo","ra","ri","ru","re","ro","wa","wo","n","kya","kyu","kyo","gya","gyu","gyo","sha","shu","sho","ja","ju","jo","cha","chu","cho","nya","nyu","nyo","hya","hyu","hyo","bya","byu","byo","pya","pyu","pyo","mya","myu","myo","rya","ryu","ryo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_hira);
        TextView hView = (TextView) findViewById(R.id.HView);
        hView.setText(hiragana[randomId]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer,answer2;
                EditText rView = (EditText) findViewById(R.id.RView);
                answer=rView.getText().toString();
                answer2=answer.toLowerCase();
                if(romanji[randomId].equals(answer2)) {
                    Toast.makeText(test_hira.this,
                            "Đúng rồi !", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(test_hira.this,test_hira.class));
                    finish();
                } else {
                    TextView aView = (TextView) findViewById(R.id.AView);
                    aView.setText(romanji[randomId]);
                    rView.setText("");
                    Toast.makeText(test_hira.this,
                            "Sai rồi!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(test_hira.this,test_hira.class));
                    finish();
                }

            }
        });

        button2 = findViewById(R.id.swtich);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test_hira.this, test_kata.class));
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