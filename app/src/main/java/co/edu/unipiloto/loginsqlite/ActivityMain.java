package co.edu.unipiloto.loginsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DatabaseHelper conexion = new DatabaseHelper(this, "bd_usuarios", null, 1);
        //SQLiteDatabase db = conexion.getWritableDatabase();
        //db.execSQL("DROP TABLE IF EXISTS usuario");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
