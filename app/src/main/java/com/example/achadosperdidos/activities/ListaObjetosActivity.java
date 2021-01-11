package com.example.achadosperdidos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.achadosperdidos.R;
import com.example.achadosperdidos.domain.ObjetoAdapter;
import com.example.achadosperdidos.domain.ObjetoAdapter2;
import com.example.achadosperdidos.domain.ObjetoDto;
import com.example.achadosperdidos.domain.ObjetoDto2;
import com.example.achadosperdidos.services.RetrofitService;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaObjetosActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ObjetoAdapter2 mAdapter;
    private List<ObjetoDto2> listaDeObjetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_objeto);




        listaDeObjetos = new ArrayList<ObjetoDto2>();
        mRecyclerView = findViewById(R.id.lista_objetos);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ObjetoAdapter2(ListaObjetosActivity.this, listaDeObjetos);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ListaObjetosActivity.this));

        buscaObjeto();//busca os objetos da API
    }

    void atualizaAdapter(final List<ObjetoDto2> obj) {
        mAdapter.setLista(obj);
        mAdapter.notifyDataSetChanged();
    }

    private void buscaObjeto(){
//        ObjetoDto2 obj1 = new ObjetoDto2("nome", "descricao", "01-01-2021");
//        ObjetoDto2 obj2 = new ObjetoDto2("nome2", "descricao3", "02-02-2022");
//        ObjetoDto2 obj3 = new ObjetoDto2("nome3", "descricao3", "03-03-2023");
//
//        listaDeObjetos.addAll(Arrays.asList(obj1,obj2,obj3));


        RetrofitService.getServico(getApplicationContext()).listar().enqueue(new Callback<List<ObjetoDto2>>() {
            @Override
            public void onResponse(Call<List<ObjetoDto2>> call, Response<List<ObjetoDto2>> response) {
                if(response.isSuccessful()){
                    atualizaAdapter(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ObjetoDto2>> call, Throwable t) {
                Log.d("Falhou na busca", "onFailure: " + t.getMessage());
            }
        });
    }
}