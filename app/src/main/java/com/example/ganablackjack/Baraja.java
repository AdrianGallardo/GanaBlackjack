package com.example.ganablackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
  static int NUM_CARTAS = 52;
  private ArrayList<Carta> cartas;

  public Baraja() {
    cartas = new ArrayList<Carta>();
    for(int i=1; i<=NUM_CARTAS/4; i++){
      Carta carta = new Carta(i, Figura.ESPADA, Posicion.ABIERTA);
      cartas.add(carta);
    }

    for(int i=1; i<=NUM_CARTAS/4; i++){
      Carta carta = new Carta(i, Figura.CORAZON, Posicion.ABIERTA);
      cartas.add(carta);
    }

    for(int i=1; i<=NUM_CARTAS/4; i++){
      Carta carta = new Carta(i, Figura.TREBOL, Posicion.ABIERTA);
      cartas.add(carta);
    }

    for(int i=1; i<=NUM_CARTAS/4; i++){
      Carta carta = new Carta(i, Figura.DIAMANTE, Posicion.ABIERTA);
      cartas.add(carta);
    }
  }

  public void barajar(){
    Collections.shuffle(cartas);
  }

  public static int getNumCartas() {
    return NUM_CARTAS;
  }

  public static void setNumCartas(int numCartas) {
    NUM_CARTAS = numCartas;
  }

  public ArrayList<Carta> getCartas() {
    return cartas;
  }

  public void setCartas(ArrayList<Carta> cartas) {
    this.cartas = cartas;
  }
}
