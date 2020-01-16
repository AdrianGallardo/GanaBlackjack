package com.example.ganablackjack;

public class Jugador {
  private Jugada jugada;
  private Mano mano;

  public Jugada getJugada() {
    return jugada;
  }

  public void setJugada(Jugada jugada) {
    this.jugada = jugada;
  }

  public Mano getMano() {
    return mano;
  }

  public void setMano(Mano mano) {
    this.mano = mano;
  }

  public Jugador() {
    mano = new Mano();
  }

  public void darCarta(Carta carta){
    mano.sumarCarta(carta);
  }

  public void retirarCartas(){
    mano.retirarCartas();
  }
}
