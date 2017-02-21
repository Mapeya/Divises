package edu.ub.pis2016.martinperezyarza.divises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializamos constante de cambio
        final float euroToDollar = (float) 1.06205;
        final float dollarToEuro = (float) 0.941575255;

        //Inicializamos variables
        final TextView unitOne = (TextView) findViewById(R.id.txtUnit);
        final TextView unitTwo = (TextView) findViewById(R.id.txtUnitConverted);
        final TextView valorEditable = (TextView) findViewById(R.id.txtEdit);
        final TextView valorConverted = (TextView) findViewById(R.id.txtConverted);

        final Button btnConverter = (Button) findViewById(R.id.btnConverter);
        final Button options = (Button) findViewById(R.id.btnOptions);
        final Switch change = (Switch) findViewById(R.id.switchMoneda);

        //Especificamos la acción al hacer click al botón Convertir.
        btnConverter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float resultado = (float) 0.00;
                float valor = Float.valueOf(valorEditable.getText().toString());

                if(change.isChecked()){
                    resultado = valor * dollarToEuro;
                }else{
                    resultado = valor * euroToDollar;
                }


                valorConverted.setText(String.valueOf(resultado));
            }
        });

        //Especificamos la acción al hacer click al botón Convertir.
        change.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(change.isChecked()){
                    unitOne.setText(R.string.unitTwo);
                    unitTwo.setText(R.string.unitOne);
                    change.setText(R.string.toEuro);
                }else{
                    unitOne.setText(R.string.unitOne);
                    unitTwo.setText(R.string.unitTwo);
                    change.setText(R.string.toDollar);
                }
            }
        });
    }


    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    /** Called when the user clicks the Send button */
    public void enterOptions(View view) {
        final Button btnOptions = (Button) findViewById(R.id.btnOptions);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = btnOptions.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        }


}
