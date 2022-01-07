package com.example.appbooks.fragmentos;

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

//    @Override
//    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//    }
}