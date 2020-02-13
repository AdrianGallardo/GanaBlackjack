package com.example.ganablackjack;

import java.util.ArrayList;

public class Jugador {
  private String nombre;
  private Jugada jugada;
  private int manoCurso;
  private ArrayList<Mano> manos = new ArrayList<Mano>();

  public Jugada getJugada() {
    return jugada;
  }

  public void setJugada(Jugada jugada) {
    this.jugada = jugada;
  }

  public ArrayList<Mano> getManos() {
    return manos;
  }

  public void setManos(ArrayList<Mano> manos) {
    this.manos = manos;
  }

  public Jugador(String nombre) {
    this.nombre = nombre;
    this.manoCurso = 0;
    agregarMano();
  }

  public void darCarta(Carta carta, int mano){
    manos.get(mano).sumarCarta(carta);
  }

  public void retirarCartas(int mano){
    manos.get(mano).retirarCartas();
  }

  public void agregarMano(){
    manos.add(new Mano());
  }

  public int getNumManos(){
    return manos.size();
  }

  public Mano getMano(int mano){
    return manos.get(mano);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getManoCurso() {
    return manoCurso;
  }

  public void setManoCurso(int manoCurso) {
    this.manoCurso = manoCurso;
  }
}
