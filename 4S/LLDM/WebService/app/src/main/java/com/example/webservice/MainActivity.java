package com.example.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText edtCep;
    private EditText edtLogradouro;
    private EditText edtComplemento;
    private EditText edtBairro;
    private EditText edtCidade;
    private EditText edtUF;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCep = findViewById(R.id.edtCep);
        edtLogradouro = findViewById(R.id.edtLogradouro);
        edtComplemento = findViewById(R.id.edtComplemento);
        edtBairro = findViewById(R.id.edtBairro);
        edtCidade = findViewById(R.id.edtLocalidade);
        edtUF = findViewById(R.id.edtUf);
    }

    // EXIBE UMA MENSAGEM TOAST PARA O USUÁRIO
    public void print(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public class WebServiceEndereco extends AsyncTask<String, Void, String> {
        // MÉTODO QUE FAZ A REQUISIÇÃO HTTP
        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL("https://viacep.com.br/ws/" + strings[0] +
                        "/json/");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                reader = new BufferedReader(new
                        InputStreamReader(inputStream));
                String linha;
                StringBuffer buffer = new StringBuffer();
                while ((linha = reader.readLine()) != null) {
                    buffer.append(linha);
                    buffer.append("\n");
                }
                return buffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            return null;
        }
        // MÉTODO QUE CONFIGURA A RESPOSTA DO MÉTODO HTTP
        @Override
        protected void onPostExecute(String s) {
            if(s == null)
                print("Não foi possível recuperar os dados...");
            else {
                try {
                    JSONObject json = new JSONObject(s);
                    edtLogradouro.setText(json.getString("logradouro"));
                    edtComplemento.setText(json.getString("complemento"));
                    edtBairro.setText(json.getString("bairro"));
                    edtCidade.setText(json.getString("localidade"));
                    edtUF.setText(json.getString("uf"));
                    print("Endereço recuperado com sucesso!");
                    databaseReference.child("Endereço").child(edtCep.getText().toString()).child("Logradouro").setValue(json.getString("logradouro"));
                    databaseReference.child("Endereço").child(edtCep.getText().toString()).child("Complemento").setValue(json.getString("complemento"));
                    databaseReference.child("Endereço").child(edtCep.getText().toString()).child("Bairro").setValue(json.getString("bairro"));
                    databaseReference.child("Endereço").child(edtCep.getText().toString()).child("Cidade").setValue(json.get("localidade"));
                    databaseReference.child("Endereço").child(edtCep.getText().toString()).child("UF").setValue(json.getString(("uf")));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // PROCEDIMENTO PARA EXECUTAR O ONCLICK DO BOTÃO
    public void onClickPesquisar(View view){
        String cep = edtCep.getText().toString();
        if(cep == null || cep.equals("")){
            print("Obrigatório informar o CEP!");
        }else {
            WebServiceEndereco webServiceEndereco = new WebServiceEndereco();
            webServiceEndereco.execute(cep);
        }
    }



}

