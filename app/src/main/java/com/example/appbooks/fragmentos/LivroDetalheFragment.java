package com.example.appbooks.fragmentos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.appbooks.EditLivroActivity;
import com.example.appbooks.R;
import com.example.appbooks.model.Livro;

public class LivroDetalheFragment extends Fragment {

    public static final String TAG_DETALHE = "tagDetalhe";
    public static final String LIVRO = "livro";

    Livro myLivro;
    TextView tvNome;
    TextView tvAutor;
    TextView tvGenero;
    TextView tvLastPage;
    TextView tvLastLine;
    TextView tvModificacao;
    ImageButton ibEditar;

    public LivroDetalheFragment() {
        // Required empty public constructor
    }


    public static LivroDetalheFragment novaInstancia(Livro livro) {
        LivroDetalheFragment fragment = new LivroDetalheFragment();
        Bundle args = new Bundle();
        args.putSerializable(LIVRO,livro);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLivro = (Livro) getArguments().getSerializable(LIVRO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_livro_detalhe, container, false);
        tvNome = layout.findViewById(R.id.tvNome);
        tvAutor = layout.findViewById(R.id.tvAutor);
        tvGenero = layout.findViewById(R.id.tvGenero);
        tvLastPage = layout.findViewById(R.id.tvLastPage);
        tvLastLine = layout.findViewById(R.id.tvLastLine);
        tvModificacao = layout.findViewById(R.id.tvModificacao);
        ibEditar = layout.findViewById(R.id.ibEditar);



        if(myLivro!=null){
            tvNome.setText(myLivro.getNome());
            tvAutor.setText(myLivro.getAutor());
            tvGenero.setText(myLivro.getGenero());
            tvLastPage.setText(String.valueOf(myLivro.getLastPage()));
            tvLastLine.setText(String.valueOf(myLivro.getLastLine()));
            tvModificacao.setText(myLivro.getModificacao());
        }

        ibEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarLivro();

            }
        });

        return layout;
    }
    public void editarLivro(){
        Activity activity = getActivity();
        Livro edLivro = new Livro();
        if(activity instanceof AoEditarLivro){
            edLivro = myLivro;
        }
        AoEditarLivro listener = (AoEditarLivro) activity;
        listener.editouLivro(edLivro);
    }

    public interface AoEditarLivro{
        void editouLivro(Livro livro);
    }

}