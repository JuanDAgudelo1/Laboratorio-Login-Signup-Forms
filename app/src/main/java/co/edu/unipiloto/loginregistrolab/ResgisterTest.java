package co.edu.unipiloto.loginregistrolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResgisterTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister_test);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, LogInTest.class));
        Toast.makeText(this,"Registro cancelado",Toast.LENGTH_LONG).show();

    }

    public void btn_singUp(View view){
        TextView e = (TextView) findViewById(R.id.nombre);
        String nombre = String.valueOf(e.getText());

        TextView n = (TextView) findViewById(R.id.email);
        String email = String.valueOf(n.getText());

        TextView na = (TextView) findViewById(R.id.nacimiento);
        String fnaci = String.valueOf(na.getText());

        TextView c = (TextView) findViewById(R.id.contra);
        String contra = String.valueOf(c.getText());

        TextView c2 = (TextView) findViewById(R.id.contra2);
        String contra2 = String.valueOf(c2.getText());


        if(nombre.isEmpty() || email.isEmpty() || fnaci.isEmpty() || contra.isEmpty() || contra2.isEmpty()){
            Toast.makeText(this,"Campos nulos, intente de nuevo",Toast.LENGTH_LONG).show();
        }else if(!contra.equals(contra2)){
            Toast.makeText(this,"Las contraseñas no coinciden, intente de nuevo",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Usuario Registrado",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, LogInTest.class);
            startActivity(intent);
            finish();
        }


    }
}