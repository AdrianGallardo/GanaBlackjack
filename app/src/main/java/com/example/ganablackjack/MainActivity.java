package com.example.ganablackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int numMazos = 6;
    Jugador jugador;
    Jugador crupier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jugar();
    }

    private void jugar() {
        //Se crean las barajas para el juego y se añaden al Mazo
        mazos = new ArrayList<Baraja>();
        for(int i=0; i<numMazos; i++){
            Baraja mazo = new Baraja();
            mazo.barajar();
            mazos.add(mazo);
        }

        //Se crean los jugadores (el jugador tiene una mano por defecto)
        jugador = new Jugador();
        crupier = new Jugador();

        /*Se inicia el juego.
          El juego se compone de una ronda con las siguientes acciones:
          -Se reparten 2 cartas abiertas al jugador.
          -Se reparte 1 carta cerrada y 1 carta abierta al crupier.
          -El jugador realiza una serie de jugadas hasta plantarse o pasarse con cada una de sus manos.
          -El crupier añade cartas a su mano hasta alcanzar una suma mayor igual a 17 o pasarse.
          -Se determina al ganador (jugador con puntuación más cercana a 21)
          -Se descartan las cartas repartidas del megamazo (el mazo se vuelve a barajar hasta que reste un número determinado de cartas).
         */

        //Se reparten las cartas a los jugadores.
        repartirCartas();
    }

    private void repartirCartas() {
        //Se reparten 2 cartas por Jugador. Las Cartas se toman y retiran de los mazos.
        //Se valida que haya almenos 40 cartas en el mazo. Si hay menos de 40 se activa una solicitud para bajar cartas.
        if()
    }
}
