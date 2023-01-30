package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calcularIMC( View view ) {
        TextView lblIMC = findViewById ( R.id.lblImc );
        TextView lblClasseImc = findViewById ( R.id.lblClasseImc);
        EditText edtPeso = findViewById ( R.id.edtPeso );
        EditText edtAltura = findViewById ( R.id.edtAltura );
        double peso = Double.valueOf ( edtPeso.getText().toString() );
        double altura = Double.valueOf( edtAltura.getText().toString())/100;
        double imc = Math.round ( peso/(altura*altura) );
        lblIMC.setText ( String.valueOf(imc) );
        String classe = "";
        if ( imc > 0 ) {
            if (imc < 16) {
                classe ="Magreza grave";
            } else if ( imc < 17 ) {
                classe ="Magreza moderada";
            } else if ( imc < 18.5 ){
                classe ="Magreza leve";
            } else if ( imc < 25 ) {
                classe ="Saudável";
            } else if ( imc < 30 ) {
                classe ="Sobrepeso";
            } else if ( imc < 35 ) {
                classe ="Obesidade Grau I";
            } else if ( imc < 40 ) {
                classe ="Obesidade Grau II(severa)";
            } else {
                classe ="Obesidade Grau III(mórbida)";
            }
        }
        lblClasseImc.setText ( classe );
    }


}
