package edu.ub.pis2016.martinperezyarza.divises;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        //Inicializo Variables
        Bundle bundle = getIntent().getExtras();
        final TextView factor1 = (TextView) findViewById(R.id.editFactor1);
        final TextView factor2 = (TextView) findViewById(R.id.editFactor2);
        final Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        final Button btnReiniciar1 = (Button) findViewById(R.id.btnReiniciarFactor1);
        final Button btnReiniciar2 = (Button) findViewById(R.id.btnReiniciarFactor2);

        //Capturamos los extra
        final String factorEuro = bundle.getString("factorEuro");
        final String factorDollar = (String) bundle.get("factorDollar");

        //Mostramos los valores
        factor1.setText(factorEuro);
        factor2.setText(factorDollar);

        //Especificamos la acción al hacer click al botón Guardar.
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Los cambios han sido guardados.";
                int duration = Toast.LENGTH_SHORT;

                Intent returnIntent = new Intent();
                returnIntent.putExtra("factorEuro",factor1.getText());
                returnIntent.putExtra("factorDollar",factor2.getText());
                setResult(Activity.RESULT_OK,returnIntent);

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                finish();
            }
        });

        //Especificamos la acción al hacer click al botón Reiniciar Factor 1.
        btnReiniciar1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                factor1.setText(R.string.editFactor1);

            }
        });

        //Especificamos la acción al hacer click al botón Reiniciar Factor 2.
        btnReiniciar2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                factor2.setText(R.string.editFactor2);

            }
        });





    }
}
