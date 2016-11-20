package id.sch.smktelkom_mlg.project.xiirpl503132333.resep_makan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Priski on 11/20/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    public void Oncreate(SQLiteDatabase _db){
        _db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase _db,int _oldVersion, int _newVersion){
        Log.w("TaskDBAdapter","Upgrading from version"+ _oldVersion + "to"
        + _newVersion+",which will destroy all old data");
        _db.execSQL("DROP TABLE IF EXISTS" + "TEMPELATE");

        onCreate(_db);
    }
}
