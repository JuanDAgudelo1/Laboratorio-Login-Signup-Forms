package co.edu.unipiloto.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ingreso extends AppCompatActivity implements View.OnClickListener {

    private EditText campoUsuarioLogin;
    private EditText campoContrasenaLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        DatabaseHelper conexion = new DatabaseHelper(this,"bd_usuarios", null,1);

        campoUsuarioLogin = (EditText) findViewById(R.id.usuario);
        campoContrasenaLogin = (EditText) findViewById(R.id.contra);

    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.login:
                login(campoContrasenaLogin);
                viewAll();
                break;
            case R.id.register:
                Intent siguiente = new Intent(this, Registro.class);
                startActivity(siguiente);
                break;
        }
    }

    public void login(EditText contrasena){


        DatabaseHelper conexion = new DatabaseHelper(this,"bd_usuarios", null,1);

        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] parametros = {campoUsuarioLogin.getText().toString()};

        String[] campos = {Utilidades.CAMPO_USUARIOREGISTRADO,Utilidades.CAMPO_CONTRASENA};

        try {
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_USUARIOREGISTRADO + "=?", parametros, null, null, null);
            cursor.moveToFirst();
            if(cursor.getString(1).equals(contrasena.getText().toString())){
                Intent siguiente = new Intent(this, ActivityMain.class);
                startActivity(siguiente);
            }else{
                Toast.makeText(getApplicationContext(),"Contraseña incorrecta", Toast.LENGTH_LONG).show();
            }
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El usuario no existe", Toast.LENGTH_LONG).show();
        }
    }

    public void viewAll(){

        DatabaseHelper conexion = new DatabaseHelper(this,"bd_usuarios", null,1);

        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] campos = {Utilidades.CAMPO_NOMBRECOMPLETO,Utilidades.CAMPO_USUARIOREGISTRADO,Utilidades.CAMPO_CORREO,Utilidades.CAMPO_CONTRASENA, Utilidades.CAMPO_CONFIRMARCONTRASENA, Utilidades.CAMPO_SEXO};

        try {
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, null, null, null, null, null);
            if(cursor.moveToFirst()){
                do {
                    System.out.println(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)
                            +" " + cursor.getString(4)+" "+cursor.getString(5));
                } while (cursor.moveToNext());
            }
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El usuario no existe", Toast.LENGTH_LONG).show();
        }
    }
}
