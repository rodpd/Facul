package com.example.pfinal;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Bateria extends Fragment {

    SoundPool soundPool = new SoundPool.Builder()
            .setMaxStreams(9)
            .build();
    int[] sons = new int[10];
    private ImageView bass;
    private ImageView china;
    private ImageView crash;
    private ImageView floor;
    private ImageView hihat;
    private ImageView ride;
    private ImageView snare;
    private ImageView splash;
    private ImageView tom1;
    private ImageView tom2;
    private ImageView start;
    private ImageView pause;
    private EditText nome;
    private boolean iniciado = false;
    private boolean pausado = true;
    private long inicio;
    Audio audio;
    private long pausaInicio;
    private long tempoPausa;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Audios");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bateria,
                container, false);
        sons[0] = soundPool.load(rootView.getContext(), R.raw.bass, 1);
        sons[1] = soundPool.load(rootView.getContext(), R.raw.china, 1);
        sons[2] = soundPool.load(rootView.getContext(), R.raw.crash, 1);
        sons[3] = soundPool.load(rootView.getContext(), R.raw.floor, 1);
        sons[4] = soundPool.load(rootView.getContext(), R.raw.hihat, 1);
        sons[5] = soundPool.load(rootView.getContext(), R.raw.ride, 1);
        sons[6] = soundPool.load(rootView.getContext(), R.raw.snare, 1);
        sons[7] = soundPool.load(rootView.getContext(), R.raw.splash, 1);
        sons[8] = soundPool.load(rootView.getContext(), R.raw.tom1, 1);
        sons[9] = soundPool.load(rootView.getContext(), R.raw.tom2, 1);
        bass = rootView.findViewById(R.id.bass);
        china = rootView.findViewById(R.id.china);
        crash = rootView.findViewById(R.id.crash);
        floor = rootView.findViewById(R.id.floor);
        hihat = rootView.findViewById(R.id.hihat);
        ride = rootView.findViewById(R.id.ride);
        snare = rootView.findViewById(R.id.snare);
        splash = rootView.findViewById(R.id.splash);
        tom1 = rootView.findViewById(R.id.tom1);
        tom2 = rootView.findViewById(R.id.tom2);
        start = rootView.findViewById(R.id.start);
        pause = rootView.findViewById(R.id.pause);
        pause.setVisibility(View.INVISIBLE);
        nome = rootView.findViewById(R.id.nome);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( iniciado ) {
                    iniciado = false;
                    start.setImageResource(R.drawable.start);
                    pause.setVisibility(View.INVISIBLE);
                    databaseReference.child(audio.nome).setValue(audio);
                }
                else {
                    if ( !(nome.getText().toString().equals(""))) {
                        tempoPausa = 0;
                        pause.setVisibility(View.VISIBLE);
                        pause.setImageResource(R.drawable.pause);
                        iniciado = true;
                        pausado = false;
                        audio = new Audio();
                        audio.nome = nome.getText().toString();
                        inicio = System.currentTimeMillis();
                        start.setImageResource(R.drawable.stop);
                    }
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( pausado ) {
                    tempoPausa = System.currentTimeMillis() - pausaInicio;
                    pause.setImageResource(R.drawable.pause);
                    pausado = false;
                }
                else {
                    pausaInicio = System.currentTimeMillis();
                    pause.setImageResource(R.drawable.play);
                    pausado = true;
                }
            }
        });

        bass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[0], 1, 1, 1, 0, 1f);
                adicionarToque(0);
            }
        });

        china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[1], 1, 1, 1, 0, 1f);
                adicionarToque(1);
            }
        });

        crash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[2], 1, 1, 1, 0, 1f);
                adicionarToque(2);
            }
        });

        floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[3], 1, 1, 1, 0, 1f);
                adicionarToque(3);
            }
        });

        hihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[4], 1, 1, 1, 0, 1f);
                adicionarToque(4);
            }
        });

        ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[5], 1, 1, 1, 0, 1f);
                adicionarToque(5);
            }
        });

        snare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[6], 1, 1, 1, 0, 1f);
                adicionarToque(6);
            }
        });

        splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[7], 1, 1, 1, 0, 1f);
                adicionarToque(7);
            }
        });

        tom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[8], 1, 1, 1, 0, 1f);
                adicionarToque(8);
            }
        });

        tom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[9], 1, 1, 1, 0, 1f);
                adicionarToque(9);
            }
        });

        return rootView;
    }

    public void adicionarToque ( int nota ) {
        if ( !pausado ) {
            Date fim = Calendar.getInstance().getTime();
            long intervalo = System.currentTimeMillis() - inicio - tempoPausa;
            tempoPausa = 0;
            audio.notas.add(nota);
            audio.intervalos.add(intervalo);
            inicio = System.currentTimeMillis();
        }
    }

}
