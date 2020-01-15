package com.example.ganablackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
  static int NUM_CARTAS = 52;
  private Carta[] cartas = new Carta[NUM_CARTAS];
  private ArrayList<Carta> pila = new ArrayList<Carta>();
  private ArrayList<Carta> descartadas = new ArrayList<Carta>();

  public Mazo() {
    int totalCartas = 0;
    for(int i=1; i<=NUM_CARTAS/4; i++){
      cartas[totalCartas].setNumero(i);
      cartas[totalCartas].setFigura(Figura.ESPADA);
      pila.add(cartas[totalCartas++]);
    }

    for(int i=1; i<=NUM_CARTAS/4; i++){
      cartas[totalCartas].setNumero(i);
      cartas[totalCartas].setFigura(Figura.CORAZON);
      pila.add(cartas[totalCartas++]);
    }

    for(int i=1; i<=NUM_CARTAS/4; i++){
      cartas[totalCartas].setNumero(i);
      cartas[totalCartas].setFigura(Figura.TREBOL);
      pila.add(cartas[totalCartas++]);
    }

    for(int i=1; i<=NUM_CARTAS/4; i++){
      cartas[totalCartas].setNumero(i);
      cartas[totalCartas].setFigura(Figura.DIAMANTE);
      pila.add(cartas[totalCartas++]);
    }
  }

  public void barajar(){
    Collections.shuffle(pila);
  }

  public void barajartodo(){
    pila.clear();
    descartadas.clear();

    for(int i=0; i<cartas.length; i++){
      pila.add(cartas[i]);
    }
    barajar();
  }

  public Carta getCarta(){;
    descartadas.add(pila.remove(0));
    return descartadas.get(0);
  }
}
