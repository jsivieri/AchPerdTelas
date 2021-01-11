package com.example.achadosperdidos.domain;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.achadosperdidos.R;

import java.util.List;

public class ObjetoAdapter2 extends RecyclerView.Adapter<ObjetoAdapter2.ObjetoViewHolder> {

    private Context context;
    private List<ObjetoDto2> lista;
    private LayoutInflater mInflater;

    private static final String TAG = "UsuarioAdapter";

    public ObjetoAdapter2(Context context, List<ObjetoDto2> lista) {
        this.context = context;
        this.lista = lista;
        this.mInflater = LayoutInflater.from(context);
    }

    public List<ObjetoDto2> getLista() {
        return lista;
    }

    public void setLista(List<ObjetoDto2> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ObjetoAdapter2.ObjetoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View linha = mInflater.inflate(R.layout.item_list_objeto, parent, false);
        return new ObjetoAdapter2.ObjetoViewHolder(linha, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjetoAdapter2.ObjetoViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        ObjetoDto2 objeto = lista.get(position);

        holder.nome.setText(objeto.getNome());
        holder.descricao.setText(objeto.getDescricao());
        holder.data.setText(objeto.getData());
    }

    public ObjetoDto2 getItem(int position) {
        return lista.get(position);
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void removeItem(int position){
        lista.remove(position);

    }


    public class ObjetoViewHolder extends RecyclerView.ViewHolder{
        public final TextView nome;
        public final TextView descricao;
        public final TextView data;

        public final ObjetoAdapter2 mAdapter;

        public ObjetoViewHolder(@NonNull View itemView, ObjetoAdapter2 adapter) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomedObjeto);
            descricao = itemView.findViewById(R.id.descricaoObjeto);
            data = itemView.findViewById(R.id.dataObjeto);

            this.mAdapter = adapter;
        }

    }
}
