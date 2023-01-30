package com.example.AgendaApp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Context.MODE_PRIVATE;

public class Tab1Cadastrar extends Fragment {
    private Button buttonSalvar;
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextTelefone;
    private EditText editTextEndereco;
    private EditText editTextCep;
    private EditText editTextDia;
    private EditText editTextMes;
    private EditText editTextAno;

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference contaoDatabaseReference = databaseReference.child("Contatos");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_cadastrar,
                container, false);
        buttonSalvar = rootView.findViewById(R.id.button_salvar_id);
        editTextNome = rootView.findViewById(R.id.editText_nome_id);
        editTextEmail = rootView.findViewById(R.id.editText_email_id);
        editTextTelefone = rootView.findViewById(R.id.editText_telefone_id);
        editTextEndereco = rootView.findViewById(R.id.editText_endereco_id);
        editTextDia = rootView.findViewById(R.id.editText_dia_id);
        editTextMes = rootView.findViewById(R.id.editText_mes_id);
        editTextAno = rootView.findViewById(R.id.editText_ano_id);
        editTextCep = rootView.findViewById(R.id.editText_cep_id);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String telefone = editTextTelefone.getText().toString();
                String cep = editTextCep.getText().toString();
                String endereco = editTextEndereco.getText().toString();
                int dia = Integer.parseInt(editTextDia.getText().toString());
                int mes = Integer.parseInt(editTextMes.getText().toString());
                int ano = Integer.parseInt(editTextAno.getText().toString());
                if ((nome != "") && (email != "") && (telefone != null) && (endereco != "") ){
                    if ( ( dia < 32 && dia > 0 )
                            && (mes < 13 && mes > 0 )
                            && ( ano >  1850 ) && ( ano < 2020 ) ) {
                        String nascimento = "";
                            if ( String.valueOf(dia).length() == 1 ){
                                nascimento = "0" + dia;
                            }
                            else {
                                nascimento = String.valueOf(dia);
                            }
                            if ( String.valueOf(mes).length() == 1 ){
                                nascimento += "/0" + mes;
                            }
                            else {
                                nascimento += "/" + mes;
                            }
                            nascimento += "/" + ano;
                            Contato pessoa = new Contato(nome, email, telefone, cep, endereco, nascimento);
                            cadastrarUsuarios(pessoa);
                            Toast.makeText(getContext().getApplicationContext(),
                        "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                            editTextNome.setText("");
                            editTextEmail.setText("");
                            editTextTelefone.setText("");
                            editTextEndereco.setText("");
                            editTextDia.setText("");
                            editTextMes.setText("");
                            editTextAno.setText("");
                            editTextCep.setText("");
                    }
                    else {
                        Toast.makeText(getContext().getApplicationContext(),
                                "Data de nascimento invalida", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return rootView;
    }

    private void cadastrarUsuarios (final Contato pessoa)
    {
        contaoDatabaseReference.addListenerForSingleValueEvent(new
           ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                   String idContato =
                           Base64.encodeToString(pessoa.getEmail().getBytes(),
                                   Base64.DEFAULT).replaceAll("(\\n|\\r)", "");
                   pessoa.setId(idContato);
                   boolean contatoJaCadastrado =
                           dataSnapshot.hasChild(idContato);
                   if (contatoJaCadastrado)
                       Toast.makeText(getContext().getApplicationContext(), "Contato já cadastrado anteriormente.", Toast.LENGTH_SHORT).show();
                   else {

                       contaoDatabaseReference.child(idContato).setValue(pessoa);
                   }
               }
               @Override
               public void onCancelled(DatabaseError databaseError) {
               }
           });
    }
}
