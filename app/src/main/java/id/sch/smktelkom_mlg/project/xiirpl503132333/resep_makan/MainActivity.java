package id.sch.smktelkom_mlg.project.xiirpl503132333.resep_makan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class MainActivity extends Activity {

    protected ListView lv;
    protected ListAdapter adapter;
    SQLiteDatabase db;
    Cursor cursor;
    EditText et_db;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        db = (new DB_Resep(this)).getWritableDatabase();
        lv = (ListView) findViewById(R.id.lv);
        et_db = (EditText) findViewById(R.id.et);

        try {
            cursor = db.rawQuery("SELECT * FROM resep ORDER BY nama ASC", null);
            adapter = new SimpleCursorAdapter(this, R.layout.isi_lv, cursor,
                    new String[] { "nama", "bahan", "img" }, new int[] {
                    R.id.tv_nama, R.id.tvBahan, R.id.imV });
            lv.setAdapter(adapter);
            lv.setTextFilterEnabled(true);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    detail(position);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate dari menu; disini akan menambahkan item menu pada Actionbar
        getMenuInflater().inflate(R.menu.menu, menu);//Memanggil file bernama menu di folder menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(getApplicationContext(), "Menu Home dipilih", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(), "Menu About dipilih", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu3:
                Toast.makeText(getApplicationContext(), "Menu Petunjuk dipilih", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu4:
                Toast.makeText(getApplicationContext(), "Menu Kontak dipilih", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu5:
                Toast.makeText(getApplicationContext(), "Menu Keluar dipilih", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("deprecation")
    public void search_db(View v) {
        String edit_db = et_db.getText().toString();
        if (!edit_db.equals("")) {
            try {
                cursor = db.rawQuery("SELECT * FROM resep WHERE nama LIKE ?",
                        new String[] { "%" + edit_db + "%" });
                adapter = new SimpleCursorAdapter(
                        this,
                        R.layout.isi_lv,
                        cursor,
                        new String[] { "nama", "bahan", "img" },
                        new int[] { R.id.tv_nama, R.id.tvBahan, R.id.imV });
                if (adapter.getCount() == 0) {
                    Toast.makeText(
                            this,
                            "Tidak ditemukan data dengan kata kunci " + edit_db
                                    + "", Toast.LENGTH_SHORT).show();
                } else {
                    lv.setAdapter(adapter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                cursor = db.rawQuery("SELECT * FROM resep ORDER BY nama ASC",
                        null);
                adapter = new SimpleCursorAdapter(
                        this,
                        R.layout.isi_lv,
                        cursor,
                        new String[] { "nama", "bahan", "img" },
                        new int[] { R.id.tv_nama, R.id.tvBahan, R.id.imV });
                lv.setAdapter(adapter);
                lv.setTextFilterEnabled(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void detail(int position) {
        int im = 0;
        String _id = "";
        String nama = "";
        String bahan = "";
        String cara = "";
        if (cursor.moveToFirst()) {
            cursor.moveToPosition(position);
            im = cursor.getInt(cursor.getColumnIndex("img"));
            nama = cursor.getString(cursor.getColumnIndex("nama"));
            bahan = cursor.getString(cursor.getColumnIndex("bahan"));
            cara = cursor.getString(cursor.getColumnIndex("cara"));
        }

        Intent iIntent = new Intent(this, DB_Parse.class);
        iIntent.putExtra("dataIM", im);
        iIntent.putExtra("dataNama", nama);
        iIntent.putExtra("dataBahan", bahan);
        iIntent.putExtra("dataCara", cara);
        setResult(RESULT_OK, iIntent);
        startActivityForResult(iIntent, 99);
    }

}
