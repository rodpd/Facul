package com.example.app;


import android.media.SoundPool;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSons extends Fragment {

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

    public FragmentSons() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sons, container, false);
        sons[0] = soundPool.load(view.getContext(), R.raw.dog, 1);
        sons[1] = soundPool.load(view.getContext(), R.raw.cow, 1);
        sons[2] = soundPool.load(view.getContext(), R.raw.elephant, 1);
        sons[3] = soundPool.load(view.getContext(), R.raw.duck, 1);
        sons[4] = soundPool.load(view.getContext(), R.raw.horse, 1);
        sons[5] = soundPool.load(view.getContext(), R.raw.lion, 1);
        sons[6] = soundPool.load(view.getContext(), R.raw.zebra, 1);
        sons[7] = soundPool.load(view.getContext(), R.raw.turkey, 1);
        sons[8] = soundPool.load(view.getContext(), R.raw.cat, 1);
        sons[9] = soundPool.load(view.getContext(), R.raw.owl, 1);
        sons[10] = soundPool.load(view.getContext(), R.raw.pig, 1);
        sons[11] = soundPool.load(view.getContext(), R.raw.ape, 1);
        sons[12] = soundPool.load(view.getContext(), R.raw.moose, 1);
        sons[13] = soundPool.load(view.getContext(), R.raw.tiger, 1);
        sons[14] = soundPool.load(view.getContext(), R.raw.sheep, 1);
        sons[15] = soundPool.load(view.getContext(), R.raw.rooster, 1);

        imageDog = view.findViewById(R.id.image_dog);
        imageDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[0], 1, 1, 1, 0, 1f);
            }
        });
        imageCow = view.findViewById(R.id.image_cow);
        imageCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[1], 1, 1, 1, 0, 1f);
            }
        });
        imageElephant = view.findViewById(R.id.image_elephant);
        imageElephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[2], 1, 1, 1, 0, 1f);
            }
        });
        imageDuck = view.findViewById(R.id.image_duck);
        imageDuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[3], 1, 1, 1, 0, 1f);
            }
        });
        imageHorse = view.findViewById(R.id.image_horse);
        imageHorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[4], 1, 1, 1, 0, 1f);
            }
        });
        imageLion = view.findViewById(R.id.image_lion);
        imageLion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[5], 1, 1, 1, 0, 1f);
            }
        });
        imageZebra = view.findViewById(R.id.image_zebra);
        imageZebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[6], 1, 1, 1, 0, 1f);
            }
        });
        imageTurkey = view.findViewById(R.id.image_turkey);
        imageTurkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[7], 1, 1, 1, 0, 1f);
            }
        });
        imageCat = view.findViewById(R.id.image_cat);
        imageCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[8], 1, 1, 1, 0, 1f);
            }
        });
        imageOwl = view.findViewById(R.id.image_owl);
        imageOwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[9], 1, 1, 1, 0, 1f);
            }
        });
        imagePig = view.findViewById(R.id.image_pig);
        imagePig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[10], 1, 1, 1, 0, 1f);
            }
        });
        imageGorilla = view.findViewById(R.id.image_ape);
        imageGorilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[11], 1, 1, 1, 0, 1f);
            }
        });
        imageMoose = view.findViewById(R.id.image_moose);
        imageMoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[12], 1, 1, 1, 0, 1f);
            }
        });
        imageTiger = view.findViewById(R.id.image_tiger);
        imageTiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[13], 1, 1, 1, 0, 1f);
            }
        });
        imageSheep = view.findViewById(R.id.image_sheep);
        imageSheep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[14], 1, 1, 1, 0, 1f);
            }
        });
        imageRooster = view.findViewById(R.id.image_rooster);
        imageRooster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sons[15], 1, 1, 1, 0, 1f);
            }
        });

        return view;
    }

}
