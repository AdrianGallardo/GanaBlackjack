package com.example.ganablackjack;

public class Carta implements Comparable{
  private int numero;
  private Figura figura;
  private Posicion posicion;
  private int idRecursoImagen;

  public Carta(int numero, Figura figura, Posicion posicion, int idRecursoImagen) {
    this.numero = numero;
    this.figura = figura;
    this.posicion = posicion;
    this.idRecursoImagen = idRecursoImagen;
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
    setIdRecursoImagen(R.drawable.ic_1b);
  }

  public Figura getFigura() {
    return figura;
  }

  public void setFigura(Figura figura) {
    this.figura = figura;
  }

  public int getIdRecursoImagen() {
    return idRecursoImagen;
  }

  public void setIdRecursoImagen(int idRecursoImagen) {
    this.idRecursoImagen = idRecursoImagen;
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
