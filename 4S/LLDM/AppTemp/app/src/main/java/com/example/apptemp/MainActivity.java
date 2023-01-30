package com.example.apptemp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @SuppressLint("SetTextI18n")
    public void converter(View view) {
        EditText edtCelsius = (EditText) findViewById(R.id.edtCelsius);
        RadioButton rbKelvin = (RadioButton) findViewById(R.id.rbKelvin);
        RadioButton rbFahrenheit = (RadioButton) findViewById(R.id.rbFahrenheit);
        RadioButton rbRankine = (RadioButton) findViewById(R.id.rbRankine);
        RadioButton rbReamur = (RadioButton) findViewById(R.id.rbReaumur);
        TextView lblResultado = (TextView) findViewById(R.id.lblResultado);
        if ( !(edtCelsius.getText().toString().equals("")) ) {
            double temperatura = Double.parseDouble(edtCelsius.getText().toString());
            if (rbKelvin.isChecked()) {
                lblResultado.setText(converterKelvin(temperatura));
            } else if (rbFahrenheit.isChecked()) {
                lblResultado.setText(converterFahrenheit(temperatura));
            } else if (rbRankine.isChecked()) {
                lblResultado.setText(converterRankine(temperatura));
            } else if (rbReamur.isChecked()) {
                lblResultado.setText(converterReamur(temperatura));
            } else {
                lblResultado.setText("Escolha uma opcão para converter");
            }
        }
        else {
            lblResultado.setText("Temperatura Inválida");
        }
    }

    private String converterKelvin(double temperatura) {
        double kelvin = temperatura + 273.15;
        return String.valueOf(kelvin);
    }

    private String converterFahrenheit(double temperatura) {
        double fahrenheit = (temperatura*1.8)+32;
        return String.valueOf(fahrenheit);
    }

    private String converterRankine(double temperatura) {
        double rankine = (temperatura + 273.15)*1.8;
        return String.valueOf(rankine);
    }

    private String converterReamur(double temperatura) {
        double reamur = temperatura*0.8;
        return String.valueOf(reamur);
    }

    public void checarGrupo1(View view) {
        RadioButton rbKelvin = (RadioButton) findViewById(R.id.rbKelvin);
        RadioButton rbFahrenheit = (RadioButton) findViewById(R.id.rbFahrenheit);
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
        TextView lblResultado = (TextView) findViewById(R.id.lblResultado);
        if ( rbKelvin.isChecked() || rbFahrenheit.isChecked() ) {
            rg1.clearCheck();
        }
    }

    public void checarGrupo2(View view) {
        RadioButton rbRankine = (RadioButton) findViewById(R.id.rbRankine);
        RadioButton rbReamur = (RadioButton) findViewById(R.id.rbReaumur);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);
        if ( rbRankine.isChecked() || rbReamur.isChecked() ) {
            rg2.clearCheck();
        }
    }


}
