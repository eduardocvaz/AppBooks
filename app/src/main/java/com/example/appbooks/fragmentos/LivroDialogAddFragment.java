package com.example.appbooks.fragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.appbooks.R;
import com.example.appbooks.model.Livro;


public class LivroDialogAddFragment extends DialogFragment {
    public static final String LIVRO_EDIT = "livroEdit";
    public static final String TAG_EDIT = "tagEdit";
    public static final String ADD_TAG = "LivroAdd";

    private EditText etNome;
    private EditText etAutor;
    private EditText etGenero;
    private EditText etLastPage;
    private EditText etLastLine;

    private Button btnSalvar;

    private Livro myLivro;
    public LivroDialogAddFragment() {
        // Required empty public constructor
    }

    public static LivroDialogAddFragment newInstance() {
        LivroDialogAddFragment livroDialogAddFragment = new LivroDialogAddFragment();
        return livroDialogAddFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLivro = new Livro();
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

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarLivro();
            }
        });
        getDialog().setTitle("Novo Livro");

        return layout;
    }
    public void adicionarLivro(){
        Activity activity = getActivity();

        if(activity instanceof AdicionaLivro){
            myLivro.setNome(etNome.getText().toString());
            myLivro.setAutor(etAutor.getText().toString());
            myLivro.setGenero(etGenero.getText().toString());
            myLivro.setLastPage(Integer.parseInt(etLastPage.getText().toString()));
            myLivro.setLastLine(Integer.parseInt(etLastLine.getText().toString()));
            myLivro.setModificacao();
        }
        AdicionaLivro listener = (AdicionaLivro) activity;
        listener.adicionouLivro(myLivro);

        dismiss();
    }
    public interface AdicionaLivro{
        void adicionouLivro(Livro livro);
    }
}