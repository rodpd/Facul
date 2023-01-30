package com.example.pfinal;


import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;



public class Sons extends Fragment
{
    private TextView nomeAudio;
    private ImageButton playAudio;
    private ImageButton deleteAudio;
    private RecyclerView lista;
    private ListAdapter adaptador;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Audios");
    ArrayList audios = new ArrayList<Audio>();
    SoundPool soundPool = new SoundPool.Builder().setMaxStreams(9).build();
    int[] sons = new int[10];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.sons, container, false);

        sons[0] = soundPool.load(view.getContext(), R.raw.bass, 1);
        sons[1] = soundPool.load(view.getContext(), R.raw.china, 1);
        sons[2] = soundPool.load(view.getContext(), R.raw.crash, 1);
        sons[3] = soundPool.load(view.getContext(), R.raw.floor, 1);
        sons[4] = soundPool.load(view.getContext(), R.raw.hihat, 1);
        sons[5] = soundPool.load(view.getContext(), R.raw.ride, 1);
        sons[6] = soundPool.load(view.getContext(), R.raw.snare, 1);
        sons[7] = soundPool.load(view.getContext(), R.raw.splash, 1);
        sons[8] = soundPool.load(view.getContext(), R.raw.tom1, 1);
        sons[9] = soundPool.load(view.getContext(), R.raw.tom2, 1);

        nomeAudio = (TextView) view.findViewById(R.id.nomeAudio);
        playAudio = (ImageButton) view.findViewById(R.id.playAudio);
        deleteAudio = (ImageButton) view.findViewById(R.id.deleteAudio);
        lista = (RecyclerView) view.findViewById(R.id.lista);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(lista.getContext(),
                layoutManager.getOrientation());
        lista.addItemDecoration(dividerItemDecoration);
        lista.setLayoutManager(layoutManager);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Audio ad = dataSnapshot.getValue(Audio.class);
                audios.add(ad);
                adaptador.notifyItemInserted(audios.size());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        adaptador = new ListAdapter(audios);
        lista.setAdapter(adaptador);

        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
    {
        private ArrayList<Audio> audios;

        public ListAdapter(ArrayList<Audio> audio)
        {
            this.audios = audio;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView tvNome;
            ImageButton imPlay;
            ImageButton imDelete;

            public ViewHolder(View itemView)
            {
                super(itemView);
                this.tvNome = (TextView) itemView.findViewById(R.id.nomeAudio);
                this.imPlay = (ImageButton) itemView.findViewById(R.id.playAudio);
                this.imDelete = (ImageButton) itemView.findViewById(R.id.deleteAudio);
            }
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linha, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
        {
            holder.tvNome.setText(audios.get(position).getNome());
            holder.imPlay.setImageResource(android.R.drawable.ic_media_play);
            holder.imDelete.setImageResource(android.R.drawable.ic_delete);

            holder.imPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Audio temp = audios.get(position);
                    for ( int i = 0; i < temp.notas.size(); i++ ) {
                        switch(temp.notas.get(i)){
                            case 0:
                                soundPool.play(sons[0], 1, 1, 1, 0, 1f);
                                break;
                            case 1:
                                soundPool.play(sons[1], 1, 1, 1, 0, 1f);
                                break;
                            case 2:
                                soundPool.play(sons[2], 1, 1, 1, 0, 1f);
                                break;
                            case 3:
                                soundPool.play(sons[3], 1, 1, 1, 0, 1f);
                                break;
                            case 4:
                                soundPool.play(sons[4], 1, 1, 1, 0, 1f);
                                break;
                            case 5:
                                soundPool.play(sons[5], 1, 1, 1, 0, 1f);
                                break;
                            case 6:
                                soundPool.play(sons[6], 1, 1, 1, 0, 1f);
                                break;
                            case 7:
                                soundPool.play(sons[7], 1, 1, 1, 0, 1f);
                                break;
                            case 8:
                                soundPool.play(sons[8], 1, 1, 1, 0, 1f);
                                break;
                            case 9:
                                soundPool.play(sons[9], 1, 1, 1, 0, 1f);
                                break;
                            default:
                        }
                        try {
                            Thread.sleep(temp.intervalos.get(i));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            holder.imDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    databaseReference.child(audios.get(position).getNome()).removeValue();
                    Arrays.toString(audios.toArray());
                    audios.remove(position);
                    notifyItemRemoved(position);
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                }
            });
        }

        @Override
        public int getItemCount()
        {
            return audios.size();
        }
    }

    public void printar ( String s ) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }
}