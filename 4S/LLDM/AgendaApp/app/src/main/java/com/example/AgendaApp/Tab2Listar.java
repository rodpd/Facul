package com.example.AgendaApp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Tab2Listar extends Fragment {
    private ListView listView;
    private Button botaoAtualizar;
    private ArrayAdapter<Contato> adapter;
    private List<Contato> contatos;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference contaoDatabaseReference = databaseReference.child("Contatos");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_listar, container,
                false);
        listView = rootView.findViewById(R.id.listView_id);
        botaoAtualizar = rootView.findViewById(R.id.button_atualizar_id);

        botaoAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);

                contaoDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       List<Contato> contatos = new
                               ArrayList<Contato>();
                       int num = 0;
                       for (DataSnapshot postSnapshot :
                               dataSnapshot.getChildren()) {
                           Contato contato = new Contato();

                           contato.setNome(postSnapshot.child("nome").getValue().toString());

                           contato.setEmail(postSnapshot.child("email").getValue().toString());

                           contato.setCep(postSnapshot.child("cep").getValue().toString());

                           contato.setEndereco(postSnapshot.child("endereco").getValue().toString());

                           contato.setNascimento(postSnapshot.child("nascimento").getValue().toString());

                           contato.setTelefone(postSnapshot.child("telefone").getValue().toString());

                           contatos.add(contato);
                           contato = null;
                       }
                       adapter = new
                               ArrayAdapter<Contato>(getContext().getApplicationContext(),
                               android.R.layout.simple_list_item_1,
                               contatos);
                       listView.setAdapter(adapter);
                   }
                   @Override
                   public void onCancelled(DatabaseError databaseError)
                   {
                   }
                });
                }
                });
        return rootView;
    }
}
