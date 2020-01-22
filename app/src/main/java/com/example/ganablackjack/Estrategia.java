package com.example.ganablackjack;

public class Estrategia {

  public Estrategia() {
  }

  public Jugada dicta(Mano jugador, Mano crupier){
    Jugada jugada = null;

    if(jugador.getTipo()==TipoMano.SUAVE){
      switch(crupier.getCartaAbierta().getNumero()){
        case 2:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.DOBLAR;
              break;
            case 17:
              jugada = Jugada.PEDIR;
              break;
            case 16:
              jugada = Jugada.PEDIR;
              break;
            case 15:
              jugada = Jugada.PEDIR;
              break;
            case 14:
              jugada = Jugada.PEDIR;
              break;
            case 13:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
        case 3:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.DOBLAR;
              break;
            case 17:
              jugada = Jugada.DOBLAR;
              break;
            case 16:
              jugada = Jugada.PEDIR;
              break;
            case 15:
              jugada = Jugada.PEDIR;
              break;
            case 14:
              jugada = Jugada.PEDIR;
              break;
            case 13:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
        case 4:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.DOBLAR;
              break;
            case 17:
              jugada = Jugada.DOBLAR;
              break;
            case 16:
              jugada = Jugada.DOBLAR;
              break;
            case 15:
              jugada = Jugada.DOBLAR;
              break;
            case 14:
              jugada = Jugada.PEDIR;
              break;
            case 13:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
        case 5:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.DOBLAR;
              break;
            case 17:
              jugada = Jugada.DOBLAR;
              break;
            case 16:
              jugada = Jugada.DOBLAR;
              break;
            case 15:
              jugada = Jugada.DOBLAR;
              break;
            case 14:
              jugada = Jugada.DOBLAR;
              break;
            case 13:
              jugada = Jugada.DOBLAR;
              break;
          }
          break;
        case 6:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.DOBLAR;
              break;
            case 18:
              jugada = Jugada.DOBLAR;
              break;
            case 17:
              jugada = Jugada.DOBLAR;
              break;
            case 16:
              jugada = Jugada.DOBLAR;
              break;
            case 15:
              jugada = Jugada.DOBLAR;
              break;
            case 14:
              jugada = Jugada.DOBLAR;
              break;
            case 13:
              jugada = Jugada.DOBLAR;
              break;
          }
          break;
        case 7:
        case 8:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.PLANTARSE;
              break;
            case 17:
              jugada = Jugada.PEDIR;
              break;
            case 16:
              jugada = Jugada.PEDIR;
              break;
            case 15:
              jugada = Jugada.PEDIR;
              break;
            case 14:
              jugada = Jugada.PEDIR;
              break;
            case 13:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
        case 9:
        case 10:
        case 1:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.PEDIR;
              break;
            case 17:
              jugada = Jugada.PEDIR;
              break;
            case 16:
              jugada = Jugada.PEDIR;
              break;
            case 15:
              jugada = Jugada.PEDIR;
              break;
            case 14:
              jugada = Jugada.PEDIR;
              break;
            case 13:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
      }
    }else if(jugador.getTipo()==TipoMano.PAR){
      switch(crupier.getCartaAbierta().getNumero()){
        case 2:
        case 3:
        case 4:
          switch (jugador.getTotal()){
            case 22:
              jugada = Jugada.SEPARAR;
              break;
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.SEPARAR;
              break;
            case 16:
              jugada = Jugada.SEPARAR;
              break;
            case 14:
              jugada = Jugada.SEPARAR;
              break;
            case 12:
              jugada = Jugada.SEPARAR;
              break;
            case 10:
              jugada = Jugada.DOBLAR;
              break;
            case 8:
              jugada = Jugada.PEDIR;
              break;
            case 6:
              jugada = Jugada.SEPARAR;
              break;
            case 4:
              jugada = Jugada.SEPARAR;
              break;
          }
          break;
        case 5:
        case 6:
          switch (jugador.getTotal()){
            case 22:
              jugada = Jugada.SEPARAR;
              break;
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.SEPARAR;
              break;
            case 16:
              jugada = Jugada.SEPARAR;
              break;
            case 14:
              jugada = Jugada.SEPARAR;
              break;
            case 12:
              jugada = Jugada.SEPARAR;
              break;
            case 10:
              jugada = Jugada.DOBLAR;
              break;
            case 8:
              jugada = Jugada.SEPARAR;
              break;
            case 6:
              jugada = Jugada.SEPARAR;
              break;
            case 4:
              jugada = Jugada.SEPARAR;
              break;
          }
          break;
        case 7:
          switch (jugador.getTotal()){
            case 22:
              jugada = Jugada.SEPARAR;
              break;
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.PLANTARSE;
              break;
            case 16:
              jugada = Jugada.SEPARAR;
              break;
            case 14:
              jugada = Jugada.SEPARAR;
              break;
            case 12:
              jugada = Jugada.PEDIR;
              break;
            case 10:
              jugada = Jugada.DOBLAR;
              break;
            case 8:
              jugada = Jugada.PEDIR;
              break;
            case 6:
              jugada = Jugada.SEPARAR;
              break;
            case 4:
              jugada = Jugada.SEPARAR;
              break;
          }
          break;
        case 8:
        case 9:
          switch (jugador.getTotal()){
            case 22:
              jugada = Jugada.SEPARAR;
              break;
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.SEPARAR;
              break;
            case 16:
              jugada = Jugada.SEPARAR;
              break;
            case 14:
              jugada = Jugada.PEDIR;
              break;
            case 12:
              jugada = Jugada.PEDIR;
              break;
            case 10:
              jugada = Jugada.DOBLAR;
              break;
            case 8:
              jugada = Jugada.PEDIR;
              break;
            case 6:
              jugada = Jugada.PEDIR;
              break;
            case 4:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
        case 10:
        case 1:
          switch (jugador.getTotal()){
            case 22:
              jugada = Jugada.SEPARAR;
              break;
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.PLANTARSE;
              break;
            case 16:
              jugada = Jugada.SEPARAR;
              break;
            case 14:
              jugada = Jugada.PEDIR;
              break;
            case 12:
              jugada = Jugada.PEDIR;
              break;
            case 10:
              jugada = Jugada.PEDIR;
              break;
            case 8:
              jugada = Jugada.PEDIR;
              break;
            case 6:
              jugada = Jugada.PEDIR;
              break;
            case 4:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
      }
    }else if(jugador.getTipo()==TipoMano.DURA){
      switch(crupier.getCartaAbierta().getNumero()){
        case 2:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.PLANTARSE;
              break;
            case 17:
              jugada = Jugada.PLANTARSE;
              break;
            case 16:
              jugada = Jugada.PLANTARSE;
              break;
            case 15:
              jugada = Jugada.PLANTARSE;
              break;
            case 14:
              jugada = Jugada.PLANTARSE;
              break;
            case 13:
              jugada = Jugada.PLANTARSE;
              break;
            case 12:
              jugada = Jugada.PEDIR;
              break;
            case 11:
              jugada = Jugada.DOBLAR;
              break;
            case 10:
              jugada = Jugada.DOBLAR;
              break;
            case 9:
              jugada = Jugada.PEDIR;
              break;
            case 8:
              jugada = Jugada.PEDIR;
              break;
            case 7:
              jugada = Jugada.PEDIR;
              break;
            case 6:
              jugada = Jugada.PEDIR;
              break;
            case 5:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
        case 3:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.PLANTARSE;
              break;
            case 17:
              jugada = Jugada.PLANTARSE;
              break;
            case 16:
              jugada = Jugada.PLANTARSE;
              break;
            case 15:
              jugada = Jugada.PLANTARSE;
              break;
            case 14:
              jugada = Jugada.PLANTARSE;
              break;
            case 13:
              jugada = Jugada.PLANTARSE;
              break;
            case 12:
              jugada = Jugada.PEDIR;
              break;
            case 11:
              jugada = Jugada.DOBLAR;
              break;
            case 10:
              jugada = Jugada.DOBLAR;
              break;
            case 9:
              jugada = Jugada.DOBLAR;
              break;
            case 8:
              jugada = Jugada.PEDIR;
              break;
            case 7:
              jugada = Jugada.PEDIR;
              break;
            case 6:
              jugada = Jugada.PEDIR;
              break;
            case 5:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
        case 4:
        case 5:
        case 6:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.PLANTARSE;
              break;
            case 17:
              jugada = Jugada.PLANTARSE;
              break;
            case 16:
              jugada = Jugada.PLANTARSE;
              break;
            case 15:
              jugada = Jugada.PLANTARSE;
              break;
            case 14:
              jugada = Jugada.PLANTARSE;
              break;
            case 13:
              jugada = Jugada.PLANTARSE;
              break;
            case 12:
              jugada = Jugada.PLANTARSE;
              break;
            case 11:
              jugada = Jugada.DOBLAR;
              break;
            case 10:
              jugada = Jugada.DOBLAR;
              break;
            case 9:
              jugada = Jugada.DOBLAR;
              break;
            case 8:
              jugada = Jugada.PEDIR;
              break;
            case 7:
              jugada = Jugada.PEDIR;
              break;
            case 6:
              jugada = Jugada.PEDIR;
              break;
            case 5:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
        case 7:
        case 8:
        case 9:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.PLANTARSE;
              break;
            case 17:
              jugada = Jugada.PLANTARSE;
              break;
            case 16:
              jugada = Jugada.PEDIR;
              break;
            case 15:
              jugada = Jugada.PEDIR;
              break;
            case 14:
              jugada = Jugada.PEDIR;
              break;
            case 13:
              jugada = Jugada.PEDIR;
              break;
            case 12:
              jugada = Jugada.PEDIR;
              break;
            case 11:
              jugada = Jugada.DOBLAR;
              break;
            case 10:
              jugada = Jugada.DOBLAR;
              break;
            case 9:
              jugada = Jugada.PEDIR;
              break;
            case 8:
              jugada = Jugada.PEDIR;
              break;
            case 7:
              jugada = Jugada.PEDIR;
              break;
            case 6:
              jugada = Jugada.PEDIR;
              break;
            case 5:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
        case 10:
        case 1:
          switch (jugador.getTotal()){
            case 20:
              jugada = Jugada.PLANTARSE;
              break;
            case 19:
              jugada = Jugada.PLANTARSE;
              break;
            case 18:
              jugada = Jugada.PLANTARSE;
              break;
            case 17:
              jugada = Jugada.PLANTARSE;
              break;
            case 16:
              jugada = Jugada.PEDIR;
              break;
            case 15:
              jugada = Jugada.PEDIR;
              break;
            case 14:
              jugada = Jugada.PEDIR;
              break;
            case 13:
              jugada = Jugada.PEDIR;
              break;
            case 12:
              jugada = Jugada.PEDIR;
              break;
            case 11:
              jugada = Jugada.DOBLAR;
              break;
            case 10:
              jugada = Jugada.PEDIR;
              break;
            case 9:
              jugada = Jugada.PEDIR;
              break;
            case 8:
              jugada = Jugada.PEDIR;
              break;
            case 7:
              jugada = Jugada.PEDIR;
              break;
            case 6:
              jugada = Jugada.PEDIR;
              break;
            case 5:
              jugada = Jugada.PEDIR;
              break;
          }
          break;
      }
    }

    return jugada;
  }
}
