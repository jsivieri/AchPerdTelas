package com.example.achadosperdidos.domain;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.achadosperdidos.R;

import java.util.List;

public class ObjetoAdapter extends RecyclerView.Adapter<ObjetoAdapter.ObjetoViewHolder> {


    private Context context;
    private List<ObjetoDto> lista;
    private LayoutInflater mInflater;
    private AdapterView.OnItemClickListener onItemClickListener;

    private static final String TAG = "UsuarioAdapter";

    public ObjetoAdapter(Context context, List<ObjetoDto> lista,AdapterView.OnItemClickListener onItemClickListener) {
        this.context = context;
        this.lista = lista;
        this.onItemClickListener = onItemClickListener;
        this.mInflater = LayoutInflater.from(context);
    }

    public List<ObjetoDto> getLista() {
        return lista;
    }

    public void setLista(List<ObjetoDto> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ObjetoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View linha = mInflater.inflate(R.layout.item_objeto, parent, false);
        return new ObjetoViewHolder(linha, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjetoViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        ObjetoDto objeto = lista.get(position);

        holder.nome.setText(objeto.getNome());
    }

    public ObjetoDto getItem(int position) {
        return lista.get(position);
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void removeItem(int position){
        lista.remove(position);

    }


    public class ObjetoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView nome;
        public final ImageButton btnExcluir;

        public final ObjetoAdapter mAdapter;

        public ObjetoViewHolder(@NonNull View itemView, ObjetoAdapter adapter) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            btnExcluir= itemView.findViewById(R.id.excluir);

            btnExcluir.setOnClickListener(this);

            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(null, v, getAdapterPosition(), v.getId());
        }
    }
}
