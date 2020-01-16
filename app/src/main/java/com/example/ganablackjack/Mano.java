package com.example.ganablackjack;

import java.util.ArrayList;

public class Mano {
  private ArrayList<Carta> cartas = new ArrayList<Carta>();
  private TipoMano tipo;
  private int total1;
  private int total2;

  public Mano() {
    tipo = null;
    total1 = 0;
    total2 = 0;
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
      total1 = total1 + carta.getNumero() + 10;
      total2 = total2 + carta.getNumero();
    }else{
      total1 = total1 + carta.getNumero();
      total2 = total1;
    }
    tipo = validarTipo();
  }

  public TipoMano validarTipo() {
    TipoMano tipo = null;
    if(cartas.size()>2) {
      tipo = TipoMano.DURA;
    }else{
      if(cartas.size()==2){
        if(cartas.get(0).getNumero()==cartas.get(1).getNumero()){
          tipo = TipoMano.PAR;
        }else if(cartas.get(0).getNumero()==1||cartas.get(1).getNumero()==1){
          tipo = TipoMano.BLANDA;
        }else {
          tipo = TipoMano.DURA;
        }
      }
    }
    return tipo;
  }

  public void retirarCartas(){
    cartas.clear();
    total1 = 0;
    total2 = 0;
    tipo = null;
  }

  public int getTotal1() {
    return total1;
  }

  public void setTotal1(int total1) {
    this.total1 = total1;
  }

  public int getTotal2() {
    return total2;
  }

  public void setTotal2(int total2) {
    this.total2 = total2;
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
}
