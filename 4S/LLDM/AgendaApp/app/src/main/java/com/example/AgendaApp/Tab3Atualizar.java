package com.example.AgendaApp;

import android.database.Cursor;
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

public class Tab3Atualizar extends Fragment {
    private Button buttonBuscar;
    private EditText editTextNome;
    private EditText editTextEmail;
    private Button buttonAtualizar;
    private Button buttonDeletar;
    private EditText editTextUserId;
    private EditText editTextTelefone;
    private EditText editTextEndereco;
    private EditText editTextDia;
    private EditText editTextMes;
    private EditText editTextAno;
    private EditText editTextCep;

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference contaoDatabaseReference = databaseReference.child("Contatos");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3_atualizar, container, false);
        buttonBuscar = rootView.findViewById(R.id.button_buscar_id);
        editTextNome = rootView.findViewById(R.id.editText_nome_id);
        editTextEmail = rootView.findViewById(R.id.editText_email_id);
        buttonAtualizar = rootView.findViewById(R.id.button_atualizar_id1);
        buttonDeletar = rootView.findViewById((R.id.button_delete_id));
        editTextUserId = rootView.findViewById(R.id.editText_user_id);
        editTextTelefone = rootView.findViewById(R.id.editText_telefone_id);
        editTextEndereco = rootView.findViewById(R.id.editText_endereco_id);
        editTextDia = rootView.findViewById(R.id.editText_dia_id);
        editTextMes = rootView.findViewById(R.id.editText_mes_id);
        editTextAno = rootView.findViewById(R.id.editText_ano_id);
        editTextCep = rootView.findViewById(R.id.editText_cep_id);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email_id =
                        editTextUserId.getText().toString();

                contaoDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       Contato contato = new Contato();
                       String idContato =
                               Base64.encodeToString(email_id.getBytes(),
                                       Base64.DEFAULT).replaceAll("(\\n|\\r)", "");
                       boolean contatoCadastrado = dataSnapshot.hasChild(idContato);
                       if (contatoCadastrado) {

                           contato.setNome(dataSnapshot.child(idContato).child("nome").getValue().toString());

                           contato.setEmail(dataSnapshot.child(idContato).child("email").getValue().toString());

                           contato.setId(dataSnapshot.child(idContato).child("id").getValue().toString());

                           contato.setCep(dataSnapshot.child(idContato).child("cep").getValue().toString());

                           contato.setEndereco(dataSnapshot.child(idContato).child("endereco").getValue().toString());

                           contato.setTelefone(dataSnapshot.child(idContato).child("telefone").getValue().toString());

                           contato.setNascimento(dataSnapshot.child(idContato).child("nascimento").getValue().toString());
                       } else {
                           contato = null;
                       }
                       if (contato != null) {
                           editTextNome.setText(contato.getNome());
                           editTextEmail.setText(contato.getEmail());
                           editTextCep.setText(contato.getCep());
                           editTextEndereco.setText(contato.getEndereco());
                           editTextTelefone.setText(contato.getTelefone());
                           editTextDia.setText(contato.getNascimento().substring(0,2));
                           editTextMes.setText(contato.getNascimento().substring(3,5));
                           editTextAno.setText(contato.getNascimento().substring(6));
                       } else {
                           Toast.makeText(getContext().getApplicationContext(),
                                   "Usuário não encontrado.", Toast.LENGTH_SHORT).show();
                       }
                   }
                   @Override
                   public void onCancelled(DatabaseError databaseError)
                   {
                   }
               });
            }
        });
        buttonAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_id = editTextUserId.getText().toString();
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String cep = editTextCep.getText().toString();
                String endereco = editTextEndereco.getText().toString();
                String telefone = editTextTelefone.getText().toString();

                int dia = Integer.valueOf(editTextDia.getText().toString());
                int mes = Integer.valueOf(editTextMes.getText().toString());
                int ano = Integer.valueOf(editTextAno.getText().toString());
                if ((dia < 32 && dia > 0)
                        && (mes < 13 && mes > 0)
                        && (ano > 1850) && (ano < 2020)) {
                    String nascimento = "";
                    if (String.valueOf(dia).length() == 1) {
                        nascimento = "0" + dia;
                    } else {
                        nascimento = String.valueOf(dia);
                    }
                    if (String.valueOf(mes).length() == 1) {
                        nascimento += "/0" + mes;
                    } else {
                        nascimento += "/" + mes;
                    }
                    nascimento += "/" + ano;
                    String idContato =
                            Base64.encodeToString(email.getBytes(),
                                    Base64.DEFAULT).replaceAll("(\\n|\\r)", "");
                    Contato contato = new Contato(nome, email, telefone, cep, endereco, nascimento);
                    contato.setCep(cep);
                    contato.setEndereco(endereco);
                    contato.setId(idContato);
                    atualizaUsuarios(contato, email_id);
                    editTextNome.setText("");
                    editTextEmail.setText("");
                    editTextCep.setText("");
                    editTextEndereco.setText("");
                    editTextUserId.setText("");
                    editTextTelefone.setText("");
                    editTextDia.setText("");
                    editTextMes.setText("");
                    editTextAno.setText("");
                }
                else {
                    Toast.makeText(getContext().getApplicationContext(),
                            "Data de nascimento invalida", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextUserId.getText().toString();
                deleteUsuarios(email);
                editTextNome.setText("");
                editTextEmail.setText("");
                editTextCep.setText("");
                editTextEndereco.setText("");
                editTextUserId.setText("");
                editTextTelefone.setText("");
                editTextDia.setText("");
                editTextMes.setText("");
                editTextAno.setText("");
            }
        });
        return rootView;
    }
    private void atualizaUsuarios(final Contato contato, final String
            email_id) {
        contaoDatabaseReference.addListenerForSingleValueEvent(new
           ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                   String idContato = contato.getId();
                   boolean contatoJaCadastrado =
                           dataSnapshot.hasChild(idContato);
                   if (!contatoJaCadastrado) {
                       String idContatoAntigo =
                               Base64.encodeToString(email_id.getBytes(),
                                       Base64.DEFAULT).replaceAll("(\\n|\\r)", "");

                       contaoDatabaseReference.child(idContatoAntigo).removeValue();

                       contaoDatabaseReference.child(idContato).setValue(contato);
                       Toast.makeText(getContext().getApplicationContext(), "Contato atualizado com sucesso", Toast.LENGTH_SHORT).show();
                   } else {

                       contaoDatabaseReference.child(idContato).setValue(contato);
                       Toast.makeText(getContext().getApplicationContext(), "Contato atualizado com sucesso", Toast.LENGTH_SHORT).show();
                   }
               }
               @Override
               public void onCancelled(DatabaseError databaseError) {
               }
           });
    }
    private void deleteUsuarios(final String email) {
        contaoDatabaseReference.addListenerForSingleValueEvent(new
           ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                   String idContato =
                           Base64.encodeToString(email.getBytes(),
                                   Base64.DEFAULT).replaceAll("(\\n|\\r)", "");
                   boolean contatoExiste = dataSnapshot.hasChild(idContato);
                   if (!contatoExiste)
                       Toast.makeText(getContext().getApplicationContext(), "Conato não existe.", Toast.LENGTH_SHORT).show();
                   else {

                       contaoDatabaseReference.child(idContato).removeValue();
                       Toast.makeText(getContext().getApplicationContext(), "Contato removido com sucesso.", Toast.LENGTH_SHORT).show();
                   }
               }
               @Override
               public void onCancelled(DatabaseError databaseError) {
               }
           });
    }

}
