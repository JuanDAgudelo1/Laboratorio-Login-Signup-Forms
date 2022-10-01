package co.edu.unipiloto.loginsqlite;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;

public class Registro extends AppCompatActivity {
    private EditText campoNombreCompleto;
    private EditText campoUsuarioRegistado;
    private EditText campoCorreo;
    private EditText campoFecha;
    private EditText campoContrasena;
    private EditText campoConfirmarContrasena;

    private RadioButton campoMasculino;
    private RadioButton campoFemenino;
    private RadioButton campoOtro;

    private Spinner spinner;

    int dia, mes, ano;
    EditText fecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        fecha = (EditText) findViewById(R.id.fecha);
        fecha.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                dia = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                ano = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Registro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        fecha.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                },dia,mes,ano);
                datePickerDialog.show();
            }
        });

        campoNombreCompleto = (EditText) findViewById(R.id.fullname);
        campoUsuarioRegistado = (EditText) findViewById(R.id.username);
        campoCorreo = (EditText) findViewById(R.id.email);
        campoFecha = (EditText) findViewById(R.id.fecha);
        campoContrasena = (EditText) findViewById(R.id.password);
        campoConfirmarContrasena = (EditText) findViewById(R.id.confrimpassword);

        campoMasculino = (RadioButton) findViewById(R.id.radioButton_male);
        campoFemenino = (RadioButton) findViewById(R.id.radioButton_female);
        campoOtro = (RadioButton) findViewById(R.id.radioButton_otro);

        spinner = (Spinner) findViewById(R.id.rol);


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void envioDatos(View view) {
        if (!spinner.getSelectedItem().toString().equals("Comprador")) {
            String[] fecha = campoFecha.getText().toString().split("/");
            LocalDate today = LocalDate.now();
            LocalDate birthday = LocalDate.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]));

            Period p = Period.between(birthday, today);
            if (p.getYears() < 18) {
                //Toast.makeText(this,spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Es menor de edad", Toast.LENGTH_LONG).show();
                return;
            }
        }
        registrarUsuarios();
    }


    public void registrarUsuarios() {


        String campoSexo = "";

        DatabaseHelper conexion = new DatabaseHelper(this, "bd_usuarios", null, 5);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();

        if (campoMasculino.isChecked()) {
            campoSexo = "Masculino";
        }
        if (campoFemenino.isChecked()) {
            campoSexo = "Femenino";
        }
        if (campoOtro.isChecked()) {
            campoSexo = "Otro";
        }


        if(campoContrasena.getText().toString().equals(campoConfirmarContrasena.getText().toString())) {
            values.put(Utilidades.CAMPO_NOMBRECOMPLETO, campoNombreCompleto.getText().toString());
            values.put(Utilidades.CAMPO_USUARIOREGISTRADO, campoUsuarioRegistado.getText().toString());
            values.put(Utilidades.CAMPO_CORREO, campoCorreo.getText().toString());
            values.put(Utilidades.CAMPO_FECHA, campoFecha.getText().toString());
            values.put(Utilidades.CAMPO_CONTRASENA, campoContrasena.getText().toString());
            values.put(Utilidades.CAMPO_CONFIRMARCONTRASENA, campoConfirmarContrasena.getText().toString());
            values.put(Utilidades.CAMPO_SPINNER, spinner.getSelectedItem().toString());
            values.put(Utilidades.CAMPO_SEXO, campoSexo);

            Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_NOMBRECOMPLETO, values);

            Toast.makeText(getApplicationContext(), "Id Registro: " + idResultante, Toast.LENGTH_SHORT).show();

            db.close();
        }else{
            Toast.makeText(getApplicationContext(),"La contraseña no es igual", Toast.LENGTH_LONG).show();
        }
    }
}