package co.edu.unipiloto.loginregistrolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class LogInTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);
    }

    public void btn_Registro(View view){
        //Toast.makeText(this,"aaaaaaaaaaaaa siuuuuu",Toast.LENGTH_LONG);
        //startActivity(new Intent(this, Registro.class));

        Intent intent = new Intent(this, ResgisterTest.class);
        startActivity(intent);
        finish();
    }

    public void btn_Ingreso(View view){
        TextView e = (TextView) findViewById(R.id.emailL);
        String email = String.valueOf(e.getText());

        TextView c = (TextView) findViewById(R.id.contrasena);
        String contra = String.valueOf(c.getText());

        if(email.isEmpty() || contra.isEmpty()){
            Toast.makeText(this,"Campos nulos, intente de nuevo",Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
           // finish();

            Toast.makeText(this,"Ingreso exitoso",Toast.LENGTH_LONG).show();
        }




        //startActivity(new Intent(this, Registro.class));
    }
}