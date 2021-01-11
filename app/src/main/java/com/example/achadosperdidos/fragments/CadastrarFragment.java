package com.example.achadosperdidos.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achadosperdidos.R;

public class CadastrarFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_cadastrar, container, false);
        }

        public static com.example.achadosperdidos.fragments.CadastrarFragment newInstance() {
            return new com.example.achadosperdidos.fragments.CadastrarFragment();
        }
    }