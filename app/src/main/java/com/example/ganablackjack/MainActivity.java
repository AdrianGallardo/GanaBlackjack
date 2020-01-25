package com.example.ganablackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.function.ToDoubleBiFunction;

public class MainActivity extends AppCompatActivity {
    int nBarajas = 6;
    Mazo mazo;
    Jugador jugador;
    Jugador crupier;
    Estadisticas estadisticas;
    int manoCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jugar();
    }

    private void jugar() {
        //Se crea el Mazo del juego con el número de Barajas definido
        mazo = new Mazo(nBarajas);

        //Se crean los jugadores (el jugador tiene una mano por defecto)
        jugador = new Jugador("Jugador");
        crupier = new Jugador("Crupier");

        /*Se inicia el juego.
          El juego se compone de una ronda con las siguientes acciones:
          -Se reparten 2 cartas abiertas al jugador.
          -Se reparte 1 carta cerrada y 1 carta abierta al crupier.
          -El jugador realiza una serie de jugadas hasta plantarse o pasarse con cada una de sus manos.
          -El crupier añade cartas a su mano hasta alcanzar una suma mayor igual a 17 o pasarse (El crupier se da carta en una mano 17 Suave)
          -Se determina al ganador (jugador con puntuación más cercana a 21)
          -Se descartan las cartas repartidas del megamazo (el mazo se vuelve a barajar hasta que reste un número determinado de cartas).
         */

        //Se reparten las cartas a los jugadores y se determina la mano inicial como mano en curso.
        manoCurso = 0;
        repartirCartas();
        //Al repartir cartas, se debe validar si hay algún jugador con Blackjack, por lo que se invoca
        //al método de resultados de la mano en curso.
        Resultado res = resultado(manoCurso);
        //Ejecutamos la acción del resultado.
        if (res == null) {
            //No se obtuvo Blackjack, el juego continua.
            //Esperamos la acción del jugador.
        } else{//Se obtuvo Blackjack de algún jugador.
            switch (res){
                //TODO: implementar las acciones de estas funciones
                case VICTORIA:
                    victoria(manoCurso);
                    break;
                case DERROTA:
                    derrota(manoCurso);
                    break;
                case EMPATE:
                    empate(manoCurso);
                    break;
                case BLACKJACK:
                    blackjack(manoCurso);
                    break;
            }
        }
        //Actualizamos la interfaz.
        actualizarGUI();
    }

    private Resultado resultado(int manoCurso) {
        Resultado res = null;
        //Validamos los resultados de la mano en curso. El crupier sólo tiene una mano.
        //El ganador será quien tenga una puntuación más cercana a 21 sin pasarse.
        //Blackjack (21 con dos cartas) gana a cualquier otro 21.

        //Verificamos el número de cartas de los jugadores.
        //Blackjack sólo se obtiene con 2 cartas.
        //Validamos si alguno obtuvo BlackJack iniciando por el crupier.
        if(crupier.getMano(0).getCartas().size() == 2&&jugador.getMano(manoCurso).getCartas().size() == 2){
            if (crupier.getMano(0).getTotal() == 21) {//Blackjack
                //Validando si el jugador tiene Blackjack (Empate)
                if (jugador.getMano(manoCurso).getTotal() == 21) {
                    res = Resultado.EMPATE;
                }
            } else {//El crupier no obtuvo Blackjack. Validamos si el jugador lo obtuvo.
                if (jugador.getMano(manoCurso).getTotal() == 21) {//Blackjack
                    res = Resultado.BLACKJACK;
                }
            }

        //Al tener más de 2 cartas, ya no es posible obtener Blackjack.
        }else{
            //Validamos si alguno se pasó de 21
            if(crupier.getMano(0).getTotal()>21){//El crupier se pasó de 21.
                res = Resultado.VICTORIA;
            }else if(jugador.getMano(manoCurso).getTotal()>21){//El jugador se pasó de 21.
                res = Resultado.DERROTA;
            //Ninguno se pasó de 21.
            }else {
                //Ningún jugador se pasó. Validamos quien ganó.
                if (crupier.getMano(0).getTotal() > jugador.getMano(manoCurso).getTotal()) {
                    //Victoria del crupier.
                    res = Resultado.DERROTA;
                } else if (crupier.getMano(0).getTotal() > jugador.getMano(manoCurso).getTotal()) {
                    //Victoria del jugador.
                    res = Resultado.VICTORIA;
                } else if (crupier.getMano(0).getTotal() == jugador.getMano(manoCurso).getTotal()) {
                    //Empate.
                    res = Resultado.EMPATE;
                }

            }
        }
        return res;
    }

    private void actualizarGUI() {
    }

    private void repartirCartas() {
        int nMano = 0;
        //Se reparten 2 cartas por Jugador. Las Cartas se toman y retiran del Mazo.
        //Se valida que haya almenos 20 cartas en el Mazo. Si hay menos de 40 se activa una solicitud para bajar cartas.
        //Las cartas se dan abiertas por defecto, es posible darlas cerradas.
        jugador.darCarta(mazo.getCarta(), nMano);
        jugador.darCarta(mazo.getCarta(), nMano);

        crupier.darCarta(mazo.getCarta(), nMano);
        crupier.darCarta(mazo.getCarta(Posicion.CERRADA), nMano);
    }

    private void empate(int nMano) {
        //En caso de empate se retiran las cartas de la mano empatada del jugador.
        jugador.retirarCartas(nMano);
        //Se actualizan las estadisticas
        actualizarEstadisticas(Resultado.EMPATE);
    }

    private void victoria(int nMano) {
        //En caso de victoria se .
        jugador.retirarCartas(nMano);
        //Se actualizan las estadisticas
        actualizarEstadisticas(Resultado.VICTORIA);
    }

    private void derrota(int nMano) {
        //En caso de empate se retiran las cartas de la mano empatada del jugador.
        jugador.retirarCartas(nMano);
        //Se actualizan las estadisticas
        actualizarEstadisticas(Resultado.DERROTA);
    }

    private void actualizarEstadisticas(Resultado resultado) {
        switch (resultado){
            case VICTORIA:
                estadisticas.victoria();
                break;
            case DERROTA:
                estadisticas.derrota();
                break;
            case EMPATE:
                estadisticas.empate();
                break;
            case BLACKJACK:
                estadisticas.blackjack();
                break;
        }
    }

    private void plantarse(){
        //Plantarse significa que el jugador no quiere sumar más cartas a su mano.
        //El crupier se da cartas si el total de su mano es menor o igual a 16 o si tiene un 17 suave.
        while (crupier.getMano(0).getTotal()<17||
                (crupier.getMano(0).getTotal()==17&&crupier.getMano(0).getTipo()==TipoMano.SUAVE)){
            crupier.darCarta(mazo.getCarta(), 0);
        }
        //Cuando el crupier termina de darse cartas se valida el resultado de la partida.
        resultado(manoCurso);
    }

    private void blackjack(int nMano) {
        //Si el crupier obtiene blackjack:
        //1.- Se retiran las cartas del jugador y del crupier
        //2.- Se actualizan las estadisticas
    }

    private void pedir(){
        //Pedir significa dar cartas a la mano en curso del jugador.
        jugador.darCarta(mazo.getCarta(), manoCurso);
    }

    private void separar(){
        //Separar significa quitar una carta del jugador y colocarla en una nueva mano.
        //Se crea una nueva mano para el jugador.

    }

    private void doblar(){

    }

    private void rendirse(){

    }
}
