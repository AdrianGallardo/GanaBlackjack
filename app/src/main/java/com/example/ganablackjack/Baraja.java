package com.example.ganablackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
  static int NUM_CARTAS = 52;
  private ArrayList<Carta> cartas;

  public Baraja() {
    cartas = new ArrayList<Carta>();

    cartas.add(new Carta(1, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_ace_of_clubs));
    cartas.add(new Carta(2, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_2_of_clubs));
    cartas.add(new Carta(3, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_3_of_clubs));
    cartas.add(new Carta(4, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_4_of_clubs));
    cartas.add(new Carta(5, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_5_of_clubs));
    cartas.add(new Carta(6, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_6_of_clubs));
    cartas.add(new Carta(7, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_7_of_clubs));
    cartas.add(new Carta(8, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_8_of_clubs));
    cartas.add(new Carta(9, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_9_of_clubs));
    cartas.add(new Carta(10, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_10_of_clubs));
    cartas.add(new Carta(11, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_10_of_clubs));
    cartas.add(new Carta(12, Figura.TREBOL, Posicion.ABIERTA, R.drawable.ic_10_of_clubs));

    cartas.add(new Carta(1, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_ace_of_diamonds));
    cartas.add(new Carta(2, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_2_of_diamonds));
    cartas.add(new Carta(3, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_3_of_diamonds));
    cartas.add(new Carta(4, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_4_of_diamonds));
    cartas.add(new Carta(5, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_5_of_diamonds));
    cartas.add(new Carta(6, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_6_of_diamonds));
    cartas.add(new Carta(7, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_7_of_diamonds));
    cartas.add(new Carta(8, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_8_of_diamonds));
    cartas.add(new Carta(9, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_9_of_diamonds));
    cartas.add(new Carta(10, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_10_of_diamonds));
    cartas.add(new Carta(11, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_10_of_diamonds));
    cartas.add(new Carta(12, Figura.DIAMANTE, Posicion.ABIERTA, R.drawable.ic_10_of_diamonds));

    cartas.add(new Carta(1, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_ace_of_spades));
    cartas.add(new Carta(2, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_2_of_spades));
    cartas.add(new Carta(3, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_3_of_spades));
    cartas.add(new Carta(4, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_4_of_spades));
    cartas.add(new Carta(5, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_5_of_spades));
    cartas.add(new Carta(6, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_6_of_spades));
    cartas.add(new Carta(7, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_7_of_spades));
    cartas.add(new Carta(8, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_8_of_spades));
    cartas.add(new Carta(9, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_9_of_spades));
    cartas.add(new Carta(10, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_10_of_spades));
    cartas.add(new Carta(11, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_10_of_spades));
    cartas.add(new Carta(12, Figura.ESPADA, Posicion.ABIERTA, R.drawable.ic_10_of_spades));

    cartas.add(new Carta(1, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_ace_of_hearts));
    cartas.add(new Carta(2, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_2_of_hearts));
    cartas.add(new Carta(3, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_3_of_hearts));
    cartas.add(new Carta(4, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_4_of_hearts));
    cartas.add(new Carta(5, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_5_of_hearts));
    cartas.add(new Carta(6, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_6_of_hearts));
    cartas.add(new Carta(7, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_7_of_hearts));
    cartas.add(new Carta(8, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_8_of_hearts));
    cartas.add(new Carta(9, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_9_of_hearts));
    cartas.add(new Carta(10, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_10_of_hearts));
    cartas.add(new Carta(11, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_10_of_hearts));
    cartas.add(new Carta(12, Figura.CORAZON, Posicion.ABIERTA, R.drawable.ic_10_of_hearts));
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
