package com.example.appbooks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.appbooks.fragmentos.LivroDialogAddFragment;
import com.example.appbooks.fragmentos.LivroDialogInfoFragment;
import com.example.appbooks.fragmentos.LivroListaFragment;
import com.example.appbooks.model.Livro;

public class LivroActivity extends AppCompatActivity implements
        LivroListaFragment.AoEscolherLivro,
        SearchView.OnQueryTextListener,
        MenuItemCompat.OnActionExpandListener,
        LivroDialogInfoFragment.EscolheuInfo,
        LivroDialogAddFragment.AdicionaLivro{

    private LivroListaFragment livroListaFragment;
    private FragmentManager myFragmentManager;

    @Override
    public void ciclouNoLivro(Livro livro) {
        Intent it = new Intent(this,LivroDetalheActivity.class);
        it.putExtra("livro",livro);
        startActivityForResult(it,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            if(resultCode == RESULT_OK){
                Livro livro = (Livro) data.getExtras().getSerializable("LivroEditado");
                int idLivro = data.getExtras().getInt("id");

                livroListaFragment.atualizar(livro,idLivro);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);
        myFragmentManager = getSupportFragmentManager();
        livroListaFragment = (LivroListaFragment) myFragmentManager.findFragmentById(R.id.fragmentoLista);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem searchItem = menu.findItem(R.id.acao_pesquisar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        MenuItemCompat.setOnActionExpandListener(searchItem,this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.acao_adicionar:
                LivroDialogAddFragment livroDialogAddFragment =
                        LivroDialogAddFragment.newInstance();
                livroDialogAddFragment.show(myFragmentManager,livroDialogAddFragment.ADD_TAG);
                break;
            case R.id.acao_info:
                LivroDialogInfoFragment livroDialogInfoFragment = new LivroDialogInfoFragment();
                livroDialogInfoFragment.show(myFragmentManager,"INFO");

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void adicionouLivro(Livro livro){livroListaFragment.adicionar(livro);}

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        livroListaFragment.buscar(newText);
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        livroListaFragment.erase();
        return true;
    }

    @Override
    public void clicouInfo(int botao) {
        if(botao == DialogInterface.BUTTON_POSITIVE){
            Intent it = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/eduardocvaz/AppBooks"));
            startActivity(it);
        }
    }
}