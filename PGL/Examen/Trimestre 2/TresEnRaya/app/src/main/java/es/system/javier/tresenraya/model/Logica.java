package es.system.javier.tresenraya.model;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Logica {

    private int [][] posJuego;

    private String[] nombresJugadores = {"Jugador 1", "Jugador 2"};

    // Fila, Columna, tipo de linea
    private int[] tipoGanador = {-1, -1, -1};

    private Button btnReiniciar;
    private Button btnInicio;
    private TextView turnoJugador;

    private int jugador = 1;

    /**
     * Constructor que genera el tablero
     */
    public Logica() {
        posJuego = new int[3][3];
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                posJuego[f][c] = 0;
            }
        }
    }

    /**
     * Metodo que controla la seleccion de un jugador y si la casilla esta vacia marcamos al jugador
     * y cambiamos el turno
     * @param fila pulsada
     * @param columna pulsada
     * @return TRUE si la posicion es valida, FALSE si ya ha sido seleccionada
     */
    public boolean modificarPosJuego(int fila, int columna) {
        if (posJuego[fila - 1][columna - 1] == 0) {
            posJuego[fila - 1][columna - 1] = jugador;

            if (jugador == 1) {
                turnoJugador.setText("Turno: " + (nombresJugadores[1]));
            } else {
                turnoJugador.setText("Turno: " + (nombresJugadores[0]));
            }

            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que controla si existe algun ganador o finalizar la partida al no tener mas casillas
     * @return TRUE si existe algun ganador o empate, FALSE si se puede seguir jugando
     */
    public boolean controlarGanador() {
        boolean ganador = false;

        // Comprobar las filas
        // Horizontal (Tipo => 1)
        for (int fila = 0; fila < 3; fila++) {
            if (posJuego[fila][0] == posJuego[fila][1] && posJuego[fila][0] == posJuego[fila][2] && posJuego[fila][0] != 0) {
                ganador = true;
                tipoGanador = new int[] {fila, 0, 1};
            }
        }

        // Comprobar las columnas
        // Vertical (Tipo => 2)
        for (int columna = 0; columna < 3; columna++) {
            if (posJuego[0][columna] == posJuego[1][columna] && posJuego[0][columna] == posJuego[2][columna] && posJuego[0][columna] != 0) {
                ganador = true;
                tipoGanador = new int[] {0, columna, 2};
            }
        }

        //Comprobar la diagonar 00 -> 11 -> 22
        // Diagonal (Tipo => 3)
        if (posJuego[0][0] == posJuego[1][1] && posJuego[0][0] == posJuego[2][2] && posJuego[0][0] != 0) {
            ganador = true;
            tipoGanador = new int[] {0, 2, 3};
        }

        //Comprobar la diagonal 02 -> 11 -> 20
        // Diagonal (Tipo => 4)
        if (posJuego[0][2] == posJuego[1][1] && posJuego[0][2] == posJuego[2][0] && posJuego[0][2] != 0) {
            ganador = true;
            tipoGanador = new int[] {2, 2, 4};
        }

        // Comprobar cuantas celdas han sido ocupadas
        int celdasOcupadas = 0;
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (posJuego[f][c] != 0) {
                    celdasOcupadas += 1;
                    if (!ganador) {
                        tipoGanador = new int[]{0, 0, 0};
                    }
                }
            }
        }

        // Si hay algun ganador o empate se muestra los botones y un mensaje
        if (ganador) {
            btnInicio.setVisibility(View.VISIBLE);
            btnReiniciar.setVisibility(View.VISIBLE);
            turnoJugador.setText("Ganador: " + (nombresJugadores[jugador - 1]));
            return true;
        } else if (celdasOcupadas == 9) {
            btnInicio.setVisibility(View.VISIBLE);
            btnReiniciar.setVisibility(View.VISIBLE);
            turnoJugador.setText("Empate");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que reinicia todas las casillas, oculta los botones y marca el turno
     */
    public void reiniciarJuego() {
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                posJuego[f][c] = 0;
            }
        }

        jugador = 1;

        btnReiniciar.setVisibility(View.GONE);
        btnInicio.setVisibility(View.GONE);

        turnoJugador.setText("Turno: " + (nombresJugadores[0]));

    }

    /**
     * Getters y Setters
     */

    public int[][] getPosJuego() {
        return posJuego;
    }

    public void setBtnReiniciar(Button btnReiniciar) {
        this.btnReiniciar = btnReiniciar;
    }

    public void setBtnInicio(Button btnInicio) {
        this.btnInicio = btnInicio;
    }

    public void setTurnoJugador(TextView turnoJugador) {
        this.turnoJugador = turnoJugador;
    }

    public void setNombresJugadores(String[] nombresJugadores) {
        this.nombresJugadores = nombresJugadores;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public int[] getTipoGanador() {
        return tipoGanador;
    }

    public void setTipoGanador(int[] tipoGanador) {
        this.tipoGanador = tipoGanador;
    }
}
