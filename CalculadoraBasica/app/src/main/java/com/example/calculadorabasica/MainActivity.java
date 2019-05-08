package com.example.calculadorabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner opcion;
    private Button btnOperacion;
    private TextView valor1, valor2, resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOperacion = (Button)findViewById(R.id.btnCalcular);
        valor1 = (TextView)findViewById(R.id.txtVal1);
        valor2 = (TextView)findViewById(R.id.txtVal2);
        resul = (TextView)findViewById(R.id.txtResul);
        opcion = (Spinner)findViewById(R.id.spinner);

        String[] opciones = {"Operaciones","Suma","Resta","Multiplicación","Division","Potencia","Porcentaje"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        opcion.setAdapter(adapter);

        btnOperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valor1.getText().toString().isEmpty() && valor2.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Campos vacíos",Toast.LENGTH_SHORT).show();
                    resul.setText(String.valueOf(""));
                }else{
                    double val1 = Double.parseDouble(valor1.getText().toString());
                    double val2 = Double.parseDouble(valor2.getText().toString());

                    String opc = opcion.getSelectedItem().toString();
                    switch (opc){
                        case "Suma":
                            double suma = val1 + val2;
                            resul.setText(String.valueOf(suma));
                            break;
                        case "Resta":
                            double resta = val1 - val2;
                            resul.setText(String.valueOf(resta));
                            break;
                        case "Multiplicación":
                            double mult = val1 * val2;
                            resul.setText(String.valueOf(mult));
                            break;
                        case "Division":
                            double division = val1 / val2;
                            resul.setText(String.valueOf(division));
                            break;
                        case "Potencia":
                            double potencia = Math.pow(val1,val2);
                            resul.setText(String.valueOf(potencia));
                            break;
                        case "Porcentaje":
                            double porcentaje = (val1 * val2)/100;
                            resul.setText(String.valueOf(porcentaje));
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), "La opcion no es una operacion",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
