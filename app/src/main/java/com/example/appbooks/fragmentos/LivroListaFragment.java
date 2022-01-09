package com.example.appbooks.fragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appbooks.R;
import com.example.appbooks.model.Livro;

import java.util.ArrayList;
import java.util.List;


public class LivroListaFragment extends ListFragment {

    List<Livro> myLivros;
    ArrayAdapter<Livro> myAdapter;


    public LivroListaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLivros = new ArrayList<Livro>();
        myAdapter = new ArrayAdapter<Livro>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                myLivros
        );
        setListAdapter(myAdapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Activity activity = getActivity();
        if(activity instanceof AoEscolherLivro){
            Livro livro = (Livro) l.getItemAtPosition(position);
            AoEscolherLivro listener = (AoEscolherLivro) activity;
            listener.ciclouNoLivro(livro);
        }
    }
    public void buscar(String string){
        if(string == null || string.trim().equals("")){
            erase();
            return;
        }
        List<Livro> livrosBuscados = new ArrayList<Livro>();
        for(int i=0; i<myLivros.size(); i++){
            Livro livro = myLivros.get(i);
            if(livro.getNome().toUpperCase().contains(string.toUpperCase())){
               livrosBuscados.add(livro);
            }
        }
        myAdapter = new ArrayAdapter<Livro>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                livrosBuscados
        );
        setListAdapter(myAdapter);
    }

    public interface AoEscolherLivro{
        void ciclouNoLivro(Livro livro);
    }
    public void erase() {
        myAdapter = new ArrayAdapter<Livro>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                myLivros
        );
        setListAdapter(myAdapter);
    }

    public void adicionar(Livro livro){
        myLivros.add(livro);
        myAdapter.notifyDataSetChanged();
    }
    public void atualizar(Livro livro, int idLivro){
        for(Livro e : myLivros){
            if(e.getId() == idLivro){
                e.setNome(livro.getNome());
                e.setAutor(livro.getAutor());
                e.setGenero(livro.getGenero());
                e.setLastPage(livro.getLastPage());
                e.setLastLine(livro.getLastLine());
                myAdapter.notifyDataSetChanged();
            }
        }
    }
}