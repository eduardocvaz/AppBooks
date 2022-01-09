package com.example.appbooks.fragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.appbooks.R;
import com.example.appbooks.model.Livro;

public class LivroEditFragment extends Fragment {

    public static final String TAG_EDIT = "tagEdit";
    public static final String LIVRO = "livro";

    private EditText etNome;
    private EditText etAutor;
    private EditText etGenero;
    private EditText etLastPage;
    private EditText etLastLine;

    private Button btnSalvar;

    private Livro myLivro;
    public LivroEditFragment() {
        // Required empty public constructor
    }
    public static LivroEditFragment novaInstance(Livro livro){
        LivroEditFragment fragment = new LivroEditFragment();
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
        View layout = inflater.inflate(R.layout.fragment_livro_dialog_add, container, false);
        etNome = layout.findViewById(R.id.etNome);
        etAutor = layout.findViewById(R.id.etAutor);
        etGenero = layout.findViewById(R.id.etGenero);
        etLastLine = layout.findViewById(R.id.etLastLine);
        etLastPage = layout.findViewById(R.id.etLastPage);
        btnSalvar = layout.findViewById(R.id.btnSalvar);

        etNome.setText(myLivro.getNome());
        etAutor.setText(myLivro.getAutor());
        etGenero.setText(myLivro.getGenero());
        etLastPage.setText(String.valueOf(myLivro.getLastPage()));
        etLastLine.setText(String.valueOf(myLivro.getLastLine()));


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvouLivroEditado();
            }
        });

        return layout;
    }
    public void salvouLivroEditado(){
        Activity activity = getActivity();

        if(activity instanceof AoSalvarLivroEditado){
            myLivro.setNome(etNome.getText().toString());
            myLivro.setAutor(etAutor.getText().toString());
            myLivro.setGenero(etGenero.getText().toString());
            myLivro.setLastPage(Integer.parseInt(etLastPage.getText().toString()));
            myLivro.setLastLine(Integer.parseInt(etLastLine.getText().toString()));
            myLivro.setModificacao();
        }
        AoSalvarLivroEditado listener = (AoSalvarLivroEditado) activity;
        listener.salvouLivroEditadoMethodInterface(myLivro);
    }
    public interface AoSalvarLivroEditado{
        public void salvouLivroEditadoMethodInterface(Livro livro);

    }
}