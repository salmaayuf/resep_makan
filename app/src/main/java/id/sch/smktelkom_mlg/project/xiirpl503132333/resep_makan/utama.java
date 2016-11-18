package id.sch.smktelkom_mlg.project.xiirpl503132333.resep_makan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class utama extends Activity implements View.OnClickListener {
    ImageView Display;
    TextView informasi, nama;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display = (ImageView) findViewById(R.id.gambarutama);
        ImageView gambar1 = (ImageView) findViewById(R.id.daftargambar1);
        ImageView gambar2 = (ImageView) findViewById(R.id.daftargambar2);
        ImageView gambar3 = (ImageView) findViewById(R.id.daftargambar3);
        ImageView gambar4 = (ImageView) findViewById(R.id.daftargambar4);
        ImageView gambar5 = (ImageView) findViewById(R.id.daftargambar5);
        ImageView gambar6 = (ImageView) findViewById(R.id.daftargambar6);
        informasi = (TextView) findViewById(R.id.informasi);
        nama = (TextView) findViewById(R.id.nama);
        gambar1.setOnClickListener(this);
        gambar2.setOnClickListener(this);
        gambar3.setOnClickListener(this);
        gambar4.setOnClickListener(this);
        gambar5.setOnClickListener(this);
        gambar6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        String nama1 = "ZZZZZ";
        String nama2 = "ZZZZZ";
        String nama3 = "ZZZZZ";
        String nama4 = "ZZZZZ";
        String nama5 = "ZZZZZ";
        String nama6 = "ZZZZZ";
        String info1 = "ZZZZ memiliki rasa yang lezat dan nikmat, Hamburger dijual dengan harga Rp. 15.000.";
        String info2 = "ZZZZ memiliki rasa yang lezat dan nikmat, Steak dijual dengan harga Rp. 35.000.";
        String info3 = "ZZZZ memiliki rasa yang lezat dan nikmat, Sate dijual dengan harga Rp. 15.000.";
        String info4 = "ZZZZ memiliki rasa yang lezat dan nikmat, Pizza dijual dengan harga Rp. 85.000.";
        String info5 = "ZZZZ  memiliki rasa yang lezat dan nikmat, Pudding dijual dengan harga Rp. 25.000.";
        String info6 = "ZZZZ memiliki rasa yang lezat dan nikmat, Brownies dijual dengan harga Rp. 35.000.";

        switch (v.getId()) {
            case R.id.daftargambar1:
                nama.setText(String.valueOf(nama1));
                Display.setImageResource(R.drawable.a);
                informasi.setText(String.valueOf(info1));
                break;
            case R.id.daftargambar2:
                nama.setText(String.valueOf(nama2));
                Display.setImageResource(R.drawable.b);
                informasi.setText(String.valueOf(info2));
                break;
            case R.id.daftargambar3:
                nama.setText(String.valueOf(nama3));
                Display.setImageResource(R.drawable.c);
                informasi.setText(String.valueOf(info3));
                break;
            case R.id.daftargambar4:
                nama.setText(String.valueOf(nama4));
                Display.setImageResource(R.drawable.d);
                informasi.setText(String.valueOf(info4));
                break;
            case R.id.daftargambar5:
                nama.setText(String.valueOf(nama5));
                Display.setImageResource(R.drawable.e);
                informasi.setText(String.valueOf(info5));
                break;
            case R.id.daftargambar6:
                nama.setText(String.valueOf(nama6));
                Display.setImageResource(R.drawable.f);
                informasi.setText(String.valueOf(info6));
                break;
        }
    }
}