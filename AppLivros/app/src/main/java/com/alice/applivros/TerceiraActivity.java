package com.alice.applivros;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;

//import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//import com.alice.applivros.R;
//import com.alice.applivros.fragmentos.ThirdFragment;
//import com.example.appbooks.model.Livro;

// Activity que mostra os dados do livro selecionado da lista.
public class TerceiraActivity extends AppCompatActivity {

    //declarando os componentes visuais
    private ImageButton ib_voltar;
    private ImageButton ib_editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        Intent intent_ = getIntent();
        
        ib_voltar = findViewById(R.id.bot_voltar);
        ib_editar = findViewById(R.id.botao_editar);

        /*Livro book = (Livro) intent_.getExtras().getSerializable("livro");

        ThirdFragment LivroDadosFragment = ThirdFragment.instanciaNova(book);

        FragmentManager gFrag = getSupportFragmentManager();

        FragmentTransaction tFrag = gFrag.beginTransaction();

        tFrag.replace(R.id.dadosLivro, LivroDadosFragment, ThirdFragment.DADOS_LIVRO);
        tFrag.commit();*/
        
        ib_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
        
        ib_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Alterar 'EditActivity' para o nome da Activity seguinte (de edição dos dados do livro):
                //Intent it_ = new Intent(getApplicationContext(), EditActivity.class);

                //startActivity(it_);
            }
        });
    }
}