package com.example.a06;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import static android.content.Context.MODE_PRIVATE;

public class Tab1Cadastrar extends Fragment {
    private Button buttonSalvar;
    private EditText editTextNome;
    private EditText editTextEmail;
    private Button buttonAtualizar;
    private Button buttonDeletar;
    private EditText editTextUser;
    private EditText editTextTelefone;
    private EditText editTextEndereco;
    private EditText editTextDia;
    private EditText editTextMes;
    private EditText editTextAno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_cadastrar,
                container, false);
        buttonSalvar = (Button) rootView.findViewById(R.id.button_salvar_id);
        editTextNome = (EditText) rootView.findViewById(R.id.editText_nome_id);
        editTextEmail = (EditText) rootView.findViewById(R.id.editText_email_id);
        editTextTelefone = rootView.findViewById(R.id.editText_telefone_id);
        editTextEndereco = rootView.findViewById(R.id.editText_endereco_id);
        editTextDia = rootView.findViewById(R.id.editText_dia_id);
        editTextMes = rootView.findViewById(R.id.editText_mes_id);
        editTextAno = rootView.findViewById(R.id.editText_ano_id);
        buttonAtualizar = (Button) rootView.findViewById(R.id.button_atualizar_id);
        buttonDeletar = (Button) rootView.findViewById((R.id.button_delete_id));

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                Integer telefone = Integer.parseInt(editTextTelefone.getText().toString());
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
                                nascimento = "0" + String.valueOf(dia);
                            }
                            else {
                                nascimento = String.valueOf(dia);
                            }
                            if ( String.valueOf(mes).length() == 1 ){
                                nascimento += "/0" + String.valueOf(mes);
                            }
                            else {
                                nascimento += "/" + String.valueOf(mes);
                            }
                            nascimento += "/" + String.valueOf(ano);
                            Contato pessoa = new Contato(nome, email, telefone, endereco, nascimento);
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
    private void cadastrarUsuarios (Contato pessoa)
    {
        try {
            //Apaga o banco de dadados
//getContext().getApplicationContext().deleteDatabase("bancoContatos");
            //definimos o nome e o modo do banco de dados.
            SQLiteDatabase bancoDeDados = getContext().getApplicationContext().openOrCreateDatabase("bancoContatos", MODE_PRIVATE, null);
            //criar tabela no banco de dados


            bancoDeDados.execSQL(" CREATE TABLE IF NOT EXISTS Contato(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, email VARCHAR, telefone INTEGER, endereco VARCHAR, nascimento VARCHAR) ");
            String insert = "INSERT INTO Contato " +
                    "(nome, email, telefone, endereco, nascimento) VALUES " + "('" + pessoa.getNome() +
                    "','" + pessoa.getEmail() + "','" + pessoa.getTelefone() + "','" + pessoa.getEndereco() + "','" + pessoa.getNascimento() + "')";

            //inserir dados na tabela
            bancoDeDados.execSQL(insert);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
