package com.example.ganablackjack;

public class Jugador {
  private Jugada jugada;
  private Carta[] mano = new Carta[2];

  public Jugada getJugada() {
    return jugada;
  }

  public void setJugada(Jugada jugada) {
    this.jugada = jugada;
  }

  public Carta[] getMano() {
    return mano;
  }

  public void setMano(Carta[] mano) {
    this.mano = mano;
  }

  public Jugador() {
  }
}
