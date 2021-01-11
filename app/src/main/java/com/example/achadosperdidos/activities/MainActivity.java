package com.example.achadosperdidos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import com.example.achadosperdidos.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listarObjetos();

    }

    public void abrirCadastrar(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void abrirRecuperarSenha(View view) {
        startActivity(new Intent(this, RecuperarSenhaActivity.class));
    }

    public void listarObjetos() {
        startActivity(new Intent(this, ListaObjetosActivity.class));
    }

    public void logar(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}