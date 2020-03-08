package com.example.ganablackjack;

import java.util.ArrayList;

public class Mano {
  private ArrayList<Carta> cartas = new ArrayList<Carta>();
  private TipoMano tipo;
  private int totalDuro;
  private int totalSuave;
  private Resultado resultado;

  public Mano() {
    tipo = null;
    totalDuro = 0;
    totalSuave = 0;
    resultado = null;
  }

  public ArrayList<Carta> getCartas() {
    return cartas;
  }

  public void setCartas(ArrayList<Carta> cartas) {
    this.cartas = cartas;
  }

  public TipoMano getTipo() {
    return tipo;
  }

  public void setTipo(TipoMano tipo) {
    this.tipo = tipo;
  }

  public void sumarCarta(Carta carta){
    cartas.add(carta);
    if(carta.getNumero()==1) {
      totalDuro = totalDuro + carta.getNumero();
      totalSuave = totalSuave + carta.getNumero() + 10;
    }else{
      totalDuro = totalDuro + carta.getNumero();
      totalSuave = totalDuro;
    }
    tipo = validarTipo();
  }

  public TipoMano validarTipo() {
    TipoMano tipo = TipoMano.PLANTADA;
    if(cartas.size()==2){
      if(cartas.get(0).getNumero()+cartas.get(1).getNumero()==21){
        tipo = TipoMano.BLACKJACK;
      }else if(cartas.get(0).getNumero()==cartas.get(1).getNumero()){
        tipo = TipoMano.PAR;
      }else if(cartas.get(0).getNumero()==1||cartas.get(1).getNumero()==1){
        tipo = TipoMano.SUAVE;
      }else {
        tipo = TipoMano.DURA;
      }
    }else{
      if(getTotal()>21){
        tipo = TipoMano.PASADA;
      }
    }
    return tipo;
  }

  public void retirarCartas(){
    cartas.clear();
    totalDuro = 0;
    totalSuave = 0;
    tipo = null;
  }

  public int getTotal() {
    if(tipo==TipoMano.DURA)
      return totalDuro;
    else
      return totalSuave;
  }

  public Carta getCartaAbierta(){
    Carta cartaAbierta = null;
    for(Carta carta: cartas){
      if(carta.getPosicion()==Posicion.ABIERTA){
        cartaAbierta = carta;
      }
    }
    return cartaAbierta;
  }

  public Resultado getResultado() {
    return resultado;
  }

  public void setResultado(Resultado resultado) {
    this.resultado = resultado;
  }
}
