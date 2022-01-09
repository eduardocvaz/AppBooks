package com.example.appbooks.fragmentos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;



public class LivroDialogInfoFragment extends DialogFragment implements
        DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Componentes do Grupo:");
        builder.setMessage("ALICE SOARES PEREIRA DE BARROS\n" +
                "\nDAWERTON EDUARDO CARLOS VAZ\n" +
                "\nMARCOS VINICIO ARAUJO DELGADO JUNIOR\n" +
                "\nVICTOR BITTENCOURT MAFRA VERISSIMO");
        builder.setPositiveButton("Ver Site", this);
        builder.setNegativeButton("Sair", this);
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Activity activity = getActivity();

        if(activity instanceof EscolheuInfo){
            EscolheuInfo listener = (EscolheuInfo) activity;
            listener.clicouInfo(which);
        }
    }
    public interface EscolheuInfo{
        public void clicouInfo(int botao);
    }
}