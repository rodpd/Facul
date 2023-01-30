package com.example.appjogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela3 extends AppCompatActivity {

    private EditText edtNum;
    private TextView tvEstado;
    private TextView tvTentativas;
    private Button btnEnviar;
    private Button btnReiniciar;
    private int aleatorio, diferenca, num, tentativas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        edtNum = findViewById(R.id.edtNum);
        tvEstado = findViewById(R.id.tvEstado);
        tvTentativas = findViewById(R.id.tvTentativas);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnReiniciar = findViewById(R.id.btnReiniciar);

        aleatorio = (int) (Math.random()*101);
        tentativas = 0;

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtNum.getText().toString().equals("")) {
                    num = Integer.parseInt(edtNum.getText().toString());
                    if (aleatorio == num) {
                        tvEstado.setText("Acertou"); // mizeravi
                        btnReiniciar.setVisibility(View.VISIBLE);
                        btnEnviar.setVisibility(View.GONE);
                        tvTentativas.setText("Você errou " + Integer.toString(tentativas) + " vezes");
                    } else {
                        diferenca = Math.abs(num - aleatorio);
                        tentativas++;
                        if ( diferenca > 40 ) {
                            tvEstado.setText("Errou feio");
                        }
                        else if ( diferenca > 20 ) {
                            tvEstado.setText("Está perto");
                        }
                        else if ( diferenca > 10 ) {
                            tvEstado.setText("Quase lá");
                        }
                        else {
                            tvEstado.setText("Na trave");
                        }
                        edtNum.setText("");
                    }
                }
            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aleatorio = (int) (Math.random()*101);
                btnReiniciar.setVisibility(View.INVISIBLE);
                btnEnviar.setVisibility(View.VISIBLE);
                tvEstado.setText("");
                edtNum.setText("");
                tvTentativas.setText("");
                tentativas = 0;
            }
        });
    }
}
