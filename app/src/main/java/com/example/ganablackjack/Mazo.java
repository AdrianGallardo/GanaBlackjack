package com.example.ganablackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
  private int nBarajas;
  private ArrayList<Carta> pila = new ArrayList<Carta>();
  private ArrayList<Carta> descartadas = new ArrayList<Carta>();

  public Mazo(int nBarajas) {
    setnBarajas(nBarajas);
    //Se crean y añaden las cartas de cada Baraja a la pila del Mazo
    for(int i=0; i<nBarajas; i++){
      Baraja baraja = new Baraja();
      for (Carta carta :
              baraja.getCartas()) {
        pila.add(carta);
      }
    }
  }

  public void barajar(){
    //Se devuelven las cartas descartadas a la pila del Mazo y se barajan
    for (Carta carta :
            descartadas) {
      carta.setPosicion(Posicion.ABIERTA);
      pila.add(carta);
    }
    descartadas.clear();
    Collections.shuffle(pila);
  }

  public int getnBarajas() {
    return nBarajas;
  }

  public void setnBarajas(int nBarajas) {
    this.nBarajas = nBarajas;
  }

  public Carta getCarta(){;
    Carta descartada = pila.remove(0);
    descartadas.add(descartada);
    return descartada;
  }

  public Carta getCarta(Posicion posicion){;
    Carta descartada = pila.remove(0);
    descartada.setPosicion(posicion);
    descartadas.add(descartada);
    return descartada;
  }

  public int getNumCartasPila(){
    return pila.size();
  }

  public int getNumCartasDescartadas(){
    return descartadas.size();
  }
}
