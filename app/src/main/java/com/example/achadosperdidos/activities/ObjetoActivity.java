package com.example.achadosperdidos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.achadosperdidos.R;
import com.example.achadosperdidos.domain.Endereco;
import com.example.achadosperdidos.domain.Objeto;
import com.example.achadosperdidos.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ObjetoActivity extends AppCompatActivity {

    private EditText nome_objeto, desc_obj, date_objeto, recomp_obj, logradouro, bairro, cep, cidade;

    private Button button_cadastra_obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto);

        nome_objeto = (EditText) findViewById(R.id.nome_objeto);
        desc_obj = (EditText) findViewById(R.id.desc_obj);
        date_objeto = (EditText) findViewById(R.id.date_objeto);
        recomp_obj = (EditText) findViewById(R.id.recomp_obj);
        logradouro = (EditText) findViewById(R.id.logradouro);
        bairro = (EditText) findViewById(R.id.bairro);
        cep = (EditText) findViewById(R.id.cep);
        cidade = (EditText) findViewById(R.id.cidade);

        button_cadastra_obj = (Button) findViewById(R.id.button_cadastra_obj);

        button_cadastra_obj.setOnClickListener(new View.OnClickListener() { //evento do button
            @Override
            public void onClick(View v) {
                Endereco endereco = new Endereco(logradouro.getText().toString(),  bairro.getText().toString()
                        ,cep.getText().toString(), cidade.getText().toString());

                Objeto objeto = new Objeto(nome_objeto.getText().toString(),  desc_obj.getText().toString(),
                        Integer.parseInt(recomp_obj.getText().toString()), date_objeto.getText().toString(),
                        0, endereco);

//                RetrofitService.getServico(getApplication()).save_objeto(objeto).enqueue(new Callback<TokenDTO>() {
//                    @Override
//                    public void onResponse(Call<TokenDTO> call, Response<TokenDTO> response) {
//                        Log.d("resposta","onresponse",response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<TokenDTO> call, Throwable t) {
//                        Log.d("resposta","ononFailure" + t.getMessage());
//                    }
//                });
            }
        });

    }
}