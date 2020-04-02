package com.example.ganablackjack;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {
  private int recursoTexto;

  public void setRecursoTexto(int recursoTexto){
      this.recursoTexto = recursoTexto;
  }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
      // Use the Builder class for convenient dialog construction
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      builder.setMessage(recursoTexto)
              .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  //Acciones
                }
              })
              .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                  //Acciones
                }
              });
      // Create the AlertDialog object and return it
      return builder.create();
    }
}
