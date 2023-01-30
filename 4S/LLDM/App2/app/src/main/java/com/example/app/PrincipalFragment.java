package com.example.app;


import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

    ImageView imageSons;
    ImageView imageAdivinha;

    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_principal, container, false);
        imageSons = view.findViewById(R.id.image_sons);
        imageAdivinha = view.findViewById(R.id.image_adivinha);
        imageSons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new FragmentSons()).commit();
            }
        });
        imageAdivinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new FragmentAdivinha()).commit();
            }
        });
        return view;
    }

}
