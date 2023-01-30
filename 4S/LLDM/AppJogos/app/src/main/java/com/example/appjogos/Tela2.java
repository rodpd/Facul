package com.example.appjogos;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class Tela2 extends AppCompatActivity {


    SoundPool soundPool = new SoundPool.Builder()
            .setMaxStreams(16)
            .build();
    int [] sons = new int[16];
    private ImageView imageDog;
    private ImageView imageCow;
    private ImageView imageElephant;
    private ImageView imageDuck;
    private ImageView imageHorse;
    private ImageView imageLion;
    private ImageView imageZebra;
    private ImageView imageTurkey;
    private ImageView imageCat;
    private ImageView imageOwl;
    private ImageView imagePig;
    private ImageView imageGorilla;
    private ImageView imageMoose;
    private ImageView imageTiger;
    private ImageView imageSheep;
    private ImageView imageRooster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);


        sons[0] = soundPool.load(getApplicationContext(), R.raw.dog, 1);
        sons[1] = soundPool.load(getApplicationContext(), R.raw.cow, 1);
        sons[2] = soundPool.load(getApplicationContext(), R.raw.elephant, 1);
        sons[3] = soundPool.load(getApplicationContext(), R.raw.duck, 1);
        sons[4] = soundPool.load(getApplicationContext(), R.raw.horse, 1);
        sons[5] = soundPool.load(getApplicationContext(), R.raw.lion, 1);
        sons[6] = soundPool.load(getApplicationContext(), R.raw.zebra, 1);
        sons[7] = soundPool.load(getApplicationContext(), R.raw.turkey, 1);
        sons[8] = soundPool.load(getApplicationContext(), R.raw.cat, 1);
        sons[9] = soundPool.load(getApplicationContext(), R.raw.owl, 1);
        sons[10] = soundPool.load(getApplicationContext(), R.raw.pig, 1);
        sons[11] = soundPool.load(getApplicationContext(), R.raw.ape, 1);
        sons[12] = soundPool.load(getApplicationContext(), R.raw.moose, 1);
        sons[13] = soundPool.load(getApplicationContext(), R.raw.tiger, 1);
        sons[14] = soundPool.load(getApplicationContext(), R.raw.sheep, 1);
        sons[15] = soundPool.load(getApplicationContext(), R.raw.rooster, 1);

        imageDog = findViewById(R.id.image_dog);
        imageDog.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[0], 1, 1, 1, 0, 1f);
            }
        });
        imageCow = findViewById(R.id.image_cow);
        imageCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[1], 1, 1, 1, 0, 1f);
            }
        });
        imageElephant = findViewById(R.id.image_elephant);
        imageElephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[2], 1, 1, 1, 0, 1f);
            }
        });
        imageDuck = findViewById(R.id.image_duck);
        imageDuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[3], 1, 1, 1, 0, 1f);
            }
        });
        imageHorse = findViewById(R.id.image_horse);
        imageHorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[4], 1, 1, 1, 0, 1f);
            }
        });
        imageLion = findViewById(R.id.image_lion);
        imageLion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[5], 1, 1, 1, 0, 1f);
            }
        });
        imageZebra = findViewById(R.id.image_zebra);
        imageZebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[6], 1, 1, 1, 0, 1f);
            }
        });
        imageTurkey = findViewById(R.id.image_turkey);
        imageTurkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[7], 1, 1, 1, 0, 1f);
            }
        });
        imageCat = findViewById(R.id.image_cat);
        imageCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[8], 1, 1, 1, 0, 1f);
            }
        });
        imageOwl = findViewById(R.id.image_owl);
        imageOwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[9], 1, 1, 1, 0, 1f);
            }
        });
        imagePig = findViewById(R.id.image_pig);
        imagePig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[10], 1, 1, 1, 0, 1f);
            }
        });
        imageGorilla = findViewById(R.id.image_ape);
        imageGorilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[11], 1, 1, 1, 0, 1f);
            }
        });
        imageMoose = findViewById(R.id.image_moose);
        imageMoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[12], 1, 1, 1, 0, 1f);
            }
        });
        imageTiger = findViewById(R.id.image_tiger);
        imageTiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[13], 1, 1, 1, 0, 1f);
            }
        });
        imageSheep = findViewById(R.id.image_sheep);
        imageSheep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[14], 1, 1, 1, 0, 1f);
            }
        });
        imageRooster = findViewById(R.id.image_rooster);
        imageRooster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[15], 1, 1, 1, 0, 1f);
            }
        });

    }


}
