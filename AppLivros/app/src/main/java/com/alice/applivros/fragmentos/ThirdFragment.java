package com.alice.applivros.fragmentos;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.alice.applivros.R;
//import com.example.appbooks.model.Livro;

public class ThirdFragment extends Fragment {

    private TextView tv_bookNome;
    private TextView tv_bookGenero;
    private TextView tv_numLinha;
    private TextView tv_num_Pag;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String DADOS_LIVRO = "dadosLivro";
    public static final String LIVRO = "livros";

    //Livro dLivros;

    /*public static ThirdFragment instanciaNova (Livro livro){

        ThirdFragment fragmentoDadosLivro = new ThirdFragment();

        Bundle param = new Bundle();
        param.putSerializable(LIVRO, livro);

        fragmentoDadosLivro.setArguments(param);

        return fragmentoDadosLivro;
    }*/

    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //dLivros = (Livro) getArguments().getSerializable(LIVRO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_third, container, false);

        tv_bookNome = layout.findViewById(R.id.nome_livro);
        tv_bookGenero = layout.findViewById(R.id.genero_livro);
        //tvLeitura = layout.findViewById(R.id.tv_leitura);
        //tvPage = layout.findViewById(R.id.tv_pagina);
        tv_num_Pag = layout.findViewById(R.id.pag_livro);
        //tvLine = layout.findViewById(R.id.tv_linha);
        tv_numLinha = layout.findViewById(R.id.linha_livro);

        /*
        if (dLivros != null){
            tv_bookNome.setText(dLivros.getNome);
            tv_bookGenero.setText(dLivros.getGenero);
            //tvLeitura.setText();
            //tvPage.setText();
            tv_num_Pag.setText(String.valueOf(dLivros.getLastPage()));
            //tvLine.setText();
            tv_numLinha.setText(String.valueof(dLivros.getLastline()));
        }*/

        return layout;
    }
}