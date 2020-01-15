package com.example.ganablackjack;

public class Carta implements Comparable{
  private int numero;
  private Figura figura;

  public Carta(int numero, Figura figura) {
    this.numero = numero;
    this.figura = figura;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public Figura getFigura() {
    return figura;
  }

  public void setFigura(Figura figura) {
    this.figura = figura;
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
