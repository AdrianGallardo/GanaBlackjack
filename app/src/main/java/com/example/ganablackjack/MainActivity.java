package com.example.ganablackjack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.function.ToDoubleBiFunction;

public class MainActivity extends AppCompatActivity {
    int nBarajas = 6;
    Mazo mazo = new Mazo(nBarajas);
    Jugador jugador = new Jugador("Jugador");
    Jugador crupier = new Jugador("Crupier");
    Estadisticas estadisticas = new Estadisticas();
    AlertDialog.Builder alertDialogBuilder;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonPedir = findViewById(R.id.buttonPedir);
        botonPedir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pedir();
            }
        });

        Button botonPlantarse = findViewById(R.id.buttonPlantarse);
        botonPlantarse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plantarse();
            }
        });

        Button botonSeparar = findViewById(R.id.buttonSeparar);
        botonSeparar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                separar();
            }
        });

        Button botonDoblar = findViewById(R.id.buttonDoblar);
        botonDoblar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doblar();
            }
        });

        Button botonBarajar = findViewById(R.id.buttonBarajar);
        botonDoblar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                barajar();
            }
        });

        jugar();
    }

    private void barajar() {
        //Al barajar, se retiran las cartas de las manos de los jugadores, se barajan y se reparten nuevamente.
        retirarCartas();
        jugar();
    }

    private void jugar() {

        /*Se inicia el juego.
          El juego se compone de una ronda con las siguientes acciones:
          Inicio:
            -Se reparten 2 cartas abiertas al jugador.
            -Se reparte 1 carta cerrada y 1 carta abierta al crupier.
          Acciones del jugador:
            -El jugador realiza una serie de jugadas hasta plantarse o pasarse con cada una de sus manos.
                -Pedir
                -Plantarse
                -Separar
                -Doblar
          Acciones del crupier:
            -El crupier añade cartas a su mano hasta alcanzar una suma mayor igual a 17 o pasarse (El crupier se da carta en una mano 17 Suave)
          Fin:
            -Se determina al ganador (jugador con puntuación más cercana a 21)
         */

        //Inicio:
        //Se reparten las cartas a los jugadores.
        retirarCartas();
        mazo.barajar();
        repartirCartas();
        inhabilitarBotones();

        //Se validan las manos de los jugadores. Al repartir cartas es posible que la mano de
        //algún jugador consiga Blackjack.
        if (jugador.getMano(jugador.getManoCurso()).getTipo() == TipoMano.BLACKJACK) {
            //Si el jugador obtiene Blackjack se valida la mano del Crupier para verificar perdida o empate.
            if (crupier.getMano(crupier.getManoCurso()).getTipo() == TipoMano.BLACKJACK) {
                //Empate
                empate(jugador.getManoCurso());
            } else {
                //Victoria del Jugador.
                victoria(jugador.getManoCurso());
            }
        } else {
            //Si el Jugador no obtuvo Blackjack se valida si el Crupier lo obtuvo lo que implicaría
            //una derrota.
            if (crupier.getMano(crupier.getManoCurso()).getTipo() == TipoMano.BLACKJACK) {
                derrota(jugador.getManoCurso());
            }
        }

        //Después de validados los Blackjack iniciales, el juego continua dependiendo de la acción del jugador.
        //Se habilitan los botones.
        habilitarBotones();

        if (jugador.getMano(jugador.getManoCurso()).getTipo() != TipoMano.PAR) {//Se inhabilita el boton de separar si la mano del jugador no es par.
            inhabilitarBoton((Button) findViewById(R.id.buttonSeparar));
        }
    }

    private void inhabilitarBoton(Button boton) {
        boton.setEnabled(false);
    }

    private void inhabilitarBotones() {
        Button botonPedir = findViewById(R.id.buttonPedir);
        Button botonPlantarse = findViewById(R.id.buttonPlantarse);
        Button botonSeparar = findViewById(R.id.buttonSeparar);
        Button botonDoblar = findViewById(R.id.buttonDoblar);

        botonPedir.setEnabled(false);
        botonPlantarse.setEnabled(false);
        botonSeparar.setEnabled(false);
        botonDoblar.setEnabled(false);
    }

    private void habilitarBotones() {
        Button botonPedir = findViewById(R.id.buttonPedir);
        Button botonPlantarse = findViewById(R.id.buttonPlantarse);
        Button botonSeparar = findViewById(R.id.buttonSeparar);
        Button botonDoblar = findViewById(R.id.buttonDoblar);

        botonPedir.setEnabled(true);
        botonPlantarse.setEnabled(true);
        botonSeparar.setEnabled(true);
        botonDoblar.setEnabled(true);
    }

    private void habilitarBoton(Button boton) {
        boton.setEnabled(true);
    }

    private Resultado resultado(Mano manoJugador) {
        Resultado res = null;
        //Validamos los resultados de la mano en curso. El crupier sólo tiene una mano.
        //El ganador será quien tenga una puntuación más cercana a 21 sin pasarse.
        //Blackjack (21 con dos cartas) gana a cualquier otro 21.

        //Verificamos el número de cartas de los jugadores.

        //Blackjack sólo se obtiene con 2 cartas.
        //Validamos si alguno obtuvo BlackJack iniciando por el crupier.
        if (crupier.getMano(crupier.getManoCurso()).getCartas().size() == 2 &&
                manoJugador.getCartas().size() == 2) {
            if (crupier.getMano(crupier.getManoCurso()).getTipo() == TipoMano.BLACKJACK) {
                //Verifica empate
                if (manoJugador.getTipo() == TipoMano.BLACKJACK) {
                    res = Resultado.EMPATE;
                } else {//Derrota del jugador
                    res = Resultado.DERROTA;
                }
            } else if (manoJugador.getTipo() == TipoMano.BLACKJACK) {
                res = Resultado.BLACKJACK;
            }

        } else {//No se obtuvo Blackjack. Validamos quién se acercó más a 21.
            //Este método se ejecuta sólo para validar resultados de una mano que se plantó.
            //El que una mano se pase de 21 se valida al dar una carta a la mano en curso.
            if (manoJugador.getTipo() == TipoMano.PLANTADA) {
                if (crupier.getMano(crupier.getManoCurso()).getTotal() >
                        manoJugador.getTotal()) {//El crupier tiene más puntaje que la mano del jugador. Sabemos que ninguno se pasó de 21.
                    res = Resultado.DERROTA;
                } else if (crupier.getMano(crupier.getManoCurso()).getTotal() <
                        manoJugador.getTotal()) {//La mano del jugador tiene más puntaje que el jugador. Sabemos que ninguno se pasó de 21.
                    res = Resultado.VICTORIA;
                } else {//Empate
                    res = Resultado.EMPATE;
                }
            }
        }
        return res;
    }

    private void actualizarGUI() {
    }

    private void repartirCartas() {
        //Se reparten 2 cartas por Jugador. Las Cartas se toman y retiran del Mazo.
        //Se valida que haya almenos 20 cartas en el Mazo. Si hay menos de 40 se activa una solicitud para bajar cartas.
        //Las cartas se dan abiertas por defecto, es posible darlas cerradas.
        jugador.darCarta(mazo.getCarta(), jugador.getManoCurso());
        mostrarCartas(jugador);
        jugador.darCarta(mazo.getCarta(), jugador.getManoCurso());
        mostrarCartas(jugador);

        crupier.darCarta(mazo.getCarta(), crupier.getManoCurso());
        mostrarCartas(crupier);
        crupier.darCarta(mazo.getCarta(Posicion.CERRADA), crupier.getManoCurso());
        mostrarCartas(crupier);
        limpiarEtiquetas();
        actualizarEtiquetas();
    }

    private void retirarCartas() {
        //Retirar las cartas significa quitar las cartas de cada mano del jugador y del crupier.
        //Las cartas están respaldadas en las cartas descartadas del mazo.

        //Se limpian las vistas de las imagenes y las etiquetas.
        limpiarImagenes();
        limpiarEtiquetas();

        for (int i = 0; i < jugador.getManos().size(); i++) {
            jugador.retirarCartas(i);
        }
        crupier.retirarCartas(crupier.getManoCurso());
        Toast.makeText(this, "Cartas retiradas", Toast.LENGTH_LONG).show();
    }

    private void limpiarImagenes() {
        int pos = 1;
        for (Carta carta : jugador.getMano(jugador.getManoCurso()).getCartas()) {
            String nombreVista;
            switch (jugador.getManoCurso()) {
                case 1:
                    nombreVista = "imageView_ja";
                    break;
                case 2:
                    nombreVista = "imageView_jb";
                    break;
                default:
                    nombreVista = "imageView_j";

            }
            ImageView imageCarta = findViewById(getResources().getIdentifier(nombreVista + (pos++), "id", getPackageName()));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                imageCarta.setBackground(null);
            } else {
                imageCarta.setBackgroundDrawable(null);
            }
            imageCarta.setVisibility(View.INVISIBLE);
        }
        pos = 1;
        for (Carta carta : crupier.getMano(crupier.getManoCurso()).getCartas()) {
            String nombreVista = "imageView_c";
            ImageView imageCarta = findViewById(getResources().getIdentifier(nombreVista + (pos++), "id", getPackageName()));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                imageCarta.setBackground(null);
            } else {
                imageCarta.setBackgroundDrawable(null);
            }
            imageCarta.setVisibility(View.INVISIBLE);
        }

    }

    private void limpiarEtiquetas() {
        TextView tv = (TextView) findViewById((R.id.textView_total_c));
        tv.setText(null);

        tv = (TextView) findViewById(R.id.textView_total_c_x);
        tv.setText(null);

        tv = (TextView) findViewById(R.id.textView_total_j);
        tv.setText(null);

        tv = (TextView) findViewById(R.id.textView_total_j_x);
        tv.setText(null);

        tv = (TextView) findViewById(R.id.textView_total_ja);
        tv.setText(null);

        tv = (TextView) findViewById(R.id.textView_total_ja_x);
        tv.setText(null);

        tv = (TextView) findViewById(R.id.textView_total_jb);
        tv.setText(null);

        tv = (TextView) findViewById(R.id.textView_total_jb_x);
        tv.setText(null);

        tv = (TextView) findViewById(R.id.textView_resultado);
        tv.setText(null);
    }

    private void actualizarEtiquetas() {
        //Actualiza las etiquetas de totales, cartas repartidas y restantes.
        //Actualizando totales
        String nombreTextTipo;
        String nombreTextTotal;
        switch (jugador.getManoCurso()) {
            case 1:
                nombreTextTipo = "textView_total_ja";
                nombreTextTotal = "textView_total_ja_x";
                break;
            case 2:
                nombreTextTipo = "textView_total_jb";
                nombreTextTotal = "textView_total_jb_x";
                break;
            default:
                nombreTextTipo = "textView_total_j";
                nombreTextTotal = "textView_total_j_x";
        }
        TextView totalJugador = findViewById(getResources().getIdentifier(nombreTextTotal, "id", getPackageName()));
        totalJugador.setText(String.valueOf(jugador.getMano(jugador.getManoCurso()).getTotal()));

        TextView tipoManoJugador = findViewById(getResources().getIdentifier(nombreTextTipo, "id", getPackageName()));
        switch (jugador.getMano(jugador.getManoCurso()).getTipo()) {
            case SUAVE:
                tipoManoJugador.setText(R.string.label_total_s);
                break;
            case DURA:
                tipoManoJugador.setText(R.string.label_total_d);
                break;
            case BLACKJACK:
                tipoManoJugador.setText(R.string.label_total_b);
                break;
        }
        totalJugador.setVisibility(View.VISIBLE);
        tipoManoJugador.setVisibility(View.VISIBLE);

        TextView totalCrupier = findViewById(R.id.textView_total_c_x);
        totalCrupier.setText(String.valueOf(crupier.getMano(crupier.getManoCurso()).getTotal()));

        TextView tipoManoCrupier = findViewById(R.id.textView_total_c);
        switch (crupier.getMano(crupier.getManoCurso()).getTipo()) {
            case SUAVE:
                tipoManoCrupier.setText(R.string.label_total_s);
                break;
            case DURA:
                tipoManoCrupier.setText(R.string.label_total_d);
                break;
            case BLACKJACK:
                tipoManoCrupier.setText(R.string.label_total_b);
                break;
        }
        totalCrupier.setVisibility(View.VISIBLE);
        tipoManoCrupier.setVisibility(View.VISIBLE);

        //Actualizando info. del mazo.
        TextView repartidasX = findViewById(R.id.textView_repartidas_x);
        TextView restantesX = findViewById(R.id.textView_restantes_x);

        repartidasX.setText(String.valueOf(mazo.getNumCartasDescartadas()));
        restantesX.setText(String.valueOf(mazo.getNumCartasPila()));
    }

    private void mostrarCartas(Jugador jugador) {
        if (jugador.getNombre() == "Jugador") {
            int pos = 1;
            for (Carta carta : jugador.getMano(jugador.getManoCurso()).getCartas()) {
                String nombreVista;
                switch (jugador.getManoCurso()) {
                    case 1:
                        nombreVista = "imageView_ja";
                        break;
                    case 2:
                        nombreVista = "imageView_jb";
                        break;
                    default:
                        nombreVista = "imageView_j";

                }
                ImageView imageCarta = findViewById(getResources().getIdentifier(nombreVista + (pos++), "id", getPackageName()));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    imageCarta.setBackground(ResourcesCompat.getDrawable(getResources(), carta.getIdRecursoImagen(), null));
                } else {
                    imageCarta.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), carta.getIdRecursoImagen(), null));
                }
                imageCarta.setVisibility(View.VISIBLE);
            }
        } else if (jugador.getNombre() == "Crupier") {
            int pos = 1;
            for (Carta carta : jugador.getMano(jugador.getManoCurso()).getCartas()) {
                String nombreVista = "imageView_c";
                ImageView imageCarta = findViewById(getResources().getIdentifier(nombreVista + (pos++), "id", getPackageName()));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    imageCarta.setBackground(ResourcesCompat.getDrawable(getResources(), carta.getIdRecursoImagen(), null));
                } else {
                    imageCarta.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), carta.getIdRecursoImagen(), null));
                }
                imageCarta.setVisibility(View.VISIBLE);
            }
        }
    }

    private void empate(int mano) {
        mensaje("Empate");
        jugador.getMano(mano).setResultado(Resultado.EMPATE);
    }

    private void victoria(int mano) {
        mensaje("Victoria");
        jugador.getMano(mano).setResultado(Resultado.VICTORIA);
    }

    private void derrota(int mano) {
        mensaje("Derrota");
        jugador.getMano(mano).setResultado(Resultado.DERROTA);
    }

    private void mensaje(String mensaje) {
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(mensaje)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    private void actualizarEstadisticas(Resultado resultado) {
        switch (resultado) {
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

    private void plantarse() {
        //Plantarse significa que el jugador no quiere sumar más cartas a su mano.
        //El crupier se da cartas si el total de su mano es menor o igual a 16 o si tiene un 17 suave.
        while (crupier.getMano(0).getTotal() < 17 ||
                (crupier.getMano(0).getTotal() == 17 && crupier.getMano(0).getTipo() == TipoMano.SUAVE)) {
            crupier.darCarta(mazo.getCarta(), 0);
        }
        //Cuando el crupier termina de darse cartas se valida el resultado de la partida.
        resultado(jugador.getMano(jugador.getManoCurso()));
    }

    private void blackjack(int nMano) {
        jugador.getMano(jugador.getManoCurso()).setResultado(Resultado.BLACKJACK);
        retirarCartas();
        repartirCartas();
        actualizarEstadisticas(Resultado.BLACKJACK);
    }

    private void pedir() {
        //Pedir significa dar cartas a la mano en curso del jugador.
        jugador.darCarta(mazo.getCarta(), jugador.getManoCurso());
        mostrarCartas(jugador);
        actualizarEtiquetas();

        //Una vez dada la carta al jugador, se valida si su mano se pasó de 21.
        if (jugador.getMano(jugador.getManoCurso()).getTipo() == TipoMano.PASADA) {
            derrota(jugador.getManoCurso());
            //Se inhabilitan los botones
            inhabilitarBotones();

            //Se reinicia el juego
            jugar();
        } else if (jugador.getMano(jugador.getManoCurso()).getTipo() == TipoMano.PLANTADA) {//Si al repartir una carta,
            //la mano del jugador se encuentra PLANTADA, es debido a que se alcanzó 21. Se ejecutan las acciones del crupier.
            inhabilitarBotones();
            repartirCrupier();
        }
    }

    private void repartirCrupier() {
        //Abriendo la segunda carta del crupier
        crupier.getMano(crupier.getManoCurso()).getCartas().get(1).setPosicion(Posicion.ABIERTA);

        //Validando la cuenta actual del Crupier.
        //Si la mano del crupier suma 17, se valida si tiene una mano suave para repartir una sola carta.
        if (crupier.getMano(crupier.getManoCurso()).getTotal() == 17) {
            if (crupier.getMano(crupier.getManoCurso()).getTipo() == TipoMano.SUAVE) {
                crupier.darCarta(mazo.getCarta(), crupier.getManoCurso());
                mostrarCartas(crupier);
            }
        } else {
            //Se repartiran cartas a la mano en curso del crupier hasta alcanzar >= 17
            while (crupier.getMano(crupier.getManoCurso()).getTotal() < 17) {
                crupier.darCarta(mazo.getCarta(), crupier.getManoCurso());
                mostrarCartas(crupier);
            }

            //Cuando la cuenta de cartas del crupier ha alcanzado la suma >= 17, se validan los resultados
            //contra las manos activas del jugador.
            //Si la mano del crupier está plantada se valida el resultado,
            if (crupier.getMano(crupier.getManoCurso()).getTipo() == TipoMano.PLANTADA) {
                //Si la mano del crupier está PLANTADA, se invoca al método de resultado para valdiar quién
                //es el ganador.
                int m = 0;
                for(Mano mano: jugador.getManos()) {
                    Resultado res = resultado(jugador.getMano(m));
                    if (res == Resultado.VICTORIA) {
                        victoria(m);
                    } else if (res == Resultado.DERROTA) {
                        derrota(m);
                    }
                }

                //El juego continua finaliza y comienza una nueva ronda.
                jugar();

            } else {
                //La mano del crupier sólo puede estar PLANTADA o PASADA una vez que se han repartido cartas.
                //Esto implica victoria de las manos activas del jugador.
                int m = 0;
                for (Mano mano : jugador.getManos()) {
                    victoria(m++);
                }
            }
        }
    }

    private void separar(){

    }

    private void doblar(){

    }

    private void rendirse(){

    }
}
