package com.example.appbooks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.appbooks.fragmentos.LivroDetalheFragment;
import com.example.appbooks.fragmentos.LivroEditFragment;
import com.example.appbooks.model.Livro;

public class LivroDetalheActivity extends AppCompatActivity implements LivroDetalheFragment.AoEditarLivro{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro_detalhe);

        Intent it = getIntent();

        Livro livro = (Livro) it.getExtras().getSerializable("livro");

        LivroDetalheFragment livroDetalheFragment = LivroDetalheFragment.novaInstancia(livro);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.detalhe,livroDetalheFragment,LivroDetalheFragment.TAG_DETALHE);
        ft.commit();


    }

    @Override
    public void editouLivro(Livro livro) {
        Intent it = new Intent(this,EditLivroActivity.class);
        it.putExtra("Editlivro",livro);
        startActivityForResult(it,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            if(resultCode == RESULT_OK){
                Intent it = getIntent();

                Livro livro = (Livro) data.getExtras().getSerializable("LivroEditado");

                it.putExtra("LivroEditado",livro);
                it.putExtra("id",livro.getId());
                setResult(RESULT_OK,it);
                finish();
            }
        }
    }
}