package com.example.appbooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.appbooks.fragmentos.LivroDetalheFragment;
import com.example.appbooks.fragmentos.LivroDialogAddFragment;
import com.example.appbooks.fragmentos.LivroEditFragment;
import com.example.appbooks.model.Livro;

public class EditLivroActivity extends AppCompatActivity implements  LivroEditFragment.AoSalvarLivroEditado{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_livro);

        Intent it = getIntent();

        Livro livro = (Livro) it.getExtras().getSerializable("Editlivro");

        LivroEditFragment livroEditFragment = LivroEditFragment.novaInstance(livro);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.editActivity,livroEditFragment,LivroEditFragment.TAG_EDIT);
        ft.commit();
    }

    @Override
    public void salvouLivroEditadoMethodInterface(Livro livro) {
        Intent it = new Intent();
        it.putExtra("LivroEditado",livro);
        setResult(RESULT_OK,it);
        finish();
    }
}