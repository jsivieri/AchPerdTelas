package com.example.achadosperdidos.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.achadosperdidos.R;
import com.example.achadosperdidos.domain.Objeto;
import com.example.achadosperdidos.domain.ObjetoAdapter;
import com.example.achadosperdidos.domain.ObjetoDto;
import com.example.achadosperdidos.services.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoveObjActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private ObjetoAdapter mAdapter;
    private List<ObjetoDto> listaDeObjetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_obj);

        listaDeObjetos = new ArrayList<ObjetoDto>();
        mRecyclerView = findViewById(R.id.remove_obj);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ObjetoAdapter(RemoveObjActivity.this, listaDeObjetos,this);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(RemoveObjActivity.this));

        buscaObjeto();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final ObjetoDto item = mAdapter.getItem(position);

        AlertDialog.Builder alert = new AlertDialog.Builder(RemoveObjActivity.this);
        alert.setTitle("");
        alert.setMessage("Deseja realmente excluir esse objeto?");
        alert.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removeObjeto(item.getId());

                mAdapter.removeItem(position);
                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyDataSetChanged();


            }
        });
        alert.setNegativeButton("CANCELAR",null);
        alert.show();
    }

    void atualizaAdapter(final List<ObjetoDto> obj) {
        mAdapter.setLista(obj);
        mAdapter.notifyDataSetChanged();
    }

    private void buscaObjeto(){
        RetrofitService.getServico(getApplicationContext()).listarObjetos().enqueue(new Callback<List<ObjetoDto>>() {
            @Override
            public void onResponse(Call<List<ObjetoDto>> call, Response<List<ObjetoDto>> response) {
                if(response.isSuccessful()){
                    atualizaAdapter(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ObjetoDto>> call, Throwable t) {
                Log.d("Falhou na busca", "onFailure: " + t.getMessage());
            }
        });
    }


    private void removeObjeto(long id){
        RetrofitService.getServico(getApplicationContext()).excluir_objeto(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Objeto Excluido com Sucesso!",Toast.LENGTH_LONG).show();
                    Log.d("Remove oBjeto", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("Falhou remover Obj", "onFailure: " + t.getMessage());
            }
        });
    }
}