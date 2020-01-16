package com.example.ganablackjack;

public class Carta implements Comparable{
  private int numero;
  private Figura figura;
  private Posicion posicion;

  public Carta(int numero, Figura figura, Posicion posicion) {
    this.numero = numero;
    this.figura = figura;
    this.posicion = posicion;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public Posicion getPosicion() {
    return posicion;
  }

  public void setPosicion(Posicion posicion) {
    this.posicion = posicion;
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
