package com.example.achadosperdidos.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.achadosperdidos.fragments.BuscarFragment;
import com.example.achadosperdidos.R;
import com.example.achadosperdidos.fragments.CadastrarFragment;
import com.example.achadosperdidos.fragments.ListarFragment;
import com.example.achadosperdidos.fragments.SairFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_search: {
                getSupportActionBar().setTitle("Buscar");
                Fragment buscarFragment = BuscarFragment.newInstance();
                openFragment(buscarFragment);
            break;
            }
            case R.id.navigation_register: {
                getSupportActionBar().setTitle("Cadastrar");
                Fragment cadastrarFragment = CadastrarFragment.newInstance();
                openFragment(cadastrarFragment);
            break;
            }
            case R.id.navigation_listar: {
                getSupportActionBar().setTitle("Meus cadastros");
                Fragment listarFragment = ListarFragment.newInstance();
                openFragment(listarFragment);
            break;
            }
            case R.id.navigation_logout: {
                getSupportActionBar().setTitle("Sair");
                Fragment sairFragment = SairFragment.newInstance();
                openFragment(sairFragment);
            break;
            }
        }

        return true;
    }
    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}