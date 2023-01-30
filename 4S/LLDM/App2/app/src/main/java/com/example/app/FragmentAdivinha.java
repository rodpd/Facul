package com.example.app;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAdivinha extends Fragment {

    private EditText edtNum;
    private TextView tvEstado;
    private TextView tvTentativas;
    private Button btnEnviar;
    private Button btnReiniciar;
    private int aleatorio, diferenca, num, tentativas;

    public FragmentAdivinha() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_adivinha, container, false);
        edtNum = view.findViewById(R.id.edtNum);
        tvEstado = view.findViewById(R.id.tvEstado);
        tvTentativas = view.findViewById(R.id.tvTentativas);
        btnEnviar = view.findViewById(R.id.btnEnviar);
        btnReiniciar = view.findViewById(R.id.btnReiniciar);

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
        return view;
    }

}
