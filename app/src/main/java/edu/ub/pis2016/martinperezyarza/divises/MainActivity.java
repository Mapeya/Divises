package edu.ub.pis2016.martinperezyarza.divises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Inicializamos constantes globales de cambio
    float euroToDollar = (float) 1.06205;
    float dollarToEuro = (float) 0.941575255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos variables
        final TextView unitOne = (TextView) findViewById(R.id.txtUnit);
        final TextView unitTwo = (TextView) findViewById(R.id.txtUnitConverted);
        final TextView valorEditable = (TextView) findViewById(R.id.txtEdit);
        final TextView valorConverted = (TextView) findViewById(R.id.txtConverted);

        final Button btnConverter = (Button) findViewById(R.id.btnConverter);
        final Button btnOptions = (Button) findViewById(R.id.btnOptions);
        final Switch change = (Switch) findViewById(R.id.switchMoneda);

        //Especificamos la acción al hacer click al botón Convertir.
        btnConverter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Inicializamos variables locales
                float resultado = (float) 0.00;
                //Capturamos el valor que queremos convertir
                float valor = Float.valueOf(valorEditable.getText().toString());
                //Calculamos al conversión
                resultado = convertirDivisa(change, valor);
                //Mostramos el resultado
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

        //Especificamos la acción al hacer click a Opciones
        btnOptions.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                // create an Intent using the current Activity
                Bundle bundle;
                String result1;
                String result2;
                Intent i = new Intent(MainActivity.this,OptionsActivity.class);
                String euro = String.valueOf(euroToDollar);
                String dollar = String.valueOf(dollarToEuro);

                i.putExtra("factorEuro",euro);
                i.putExtra("factorDollar",dollar);

                // using the specified action defined in StartPage
                startActivityForResult(i, 1);

                //Capturamos los extra retornados
                 result1 = i.getStringExtra("factorEuro");
                 result2 = i.getStringExtra("factorDollar");

                euroToDollar = Float.valueOf(result1);
                dollarToEuro = Float.valueOf(result2);
            }
        });
    }

    /**
     * Método para calcular la conversión de divisas
     * @param change Componente para comprobar si estamos en Euro a Dollar o viceversa.
     * @param valor Valor que queremos convertir
     * @return
     */
    protected float convertirDivisa(Switch change, Float valor){
        float resultado = (float) 0.00;

        if(change.isChecked()){
            resultado = valor * dollarToEuro;
        }else{
            resultado = valor * euroToDollar;
        }

        return resultado;

    }

}
