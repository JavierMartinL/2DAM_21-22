package es.system.javier.tresenraya.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import es.system.javier.tresenraya.R;
import es.system.javier.tresenraya.model.Logica;

public class TresEnRayaBoard extends View {

    private final int boardColor;
    private final int XColor;
    private final int OColor;
    private final int lineaGanadorColor;

    private boolean lineaGanador = false;

    private final Paint paint = new Paint();

    private final Logica logicaJuego;

    private int cellSize = getWidth()/3;

    public TresEnRayaBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        logicaJuego = new Logica();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TresEnRayaBoard, 0, 0);

        try {
            boardColor = a.getInteger(R.styleable.TresEnRayaBoard_boardColor, 0);
            XColor = a.getInteger(R.styleable.TresEnRayaBoard_XColor, 0);
            OColor = a.getInteger(R.styleable.TresEnRayaBoard_OColor, 0);
            lineaGanadorColor = a.getInteger(R.styleable.TresEnRayaBoard_lineaGanadorColor, 0);

        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);

        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimension/3;

        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawGameBoard(canvas);
        drawMarkers(canvas);

        if (lineaGanador) {
            paint.setColor(lineaGanadorColor);
            drawLineaGanador(canvas);
        }
    }

    /**
     * Evento que controla la pulsacion en las casillas
     * @param event
     * @return
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN) {
            int fila = (int) Math.ceil(y/cellSize);
            int columna = (int) Math.ceil(x/cellSize);

            if (!lineaGanador) {
                if (logicaJuego.modificarPosJuego(fila, columna)) {
                    invalidate();


                    if (logicaJuego.controlarGanador()) {
                        lineaGanador = true;
                        invalidate();
                    }

                    // turnos
                    if (logicaJuego.getJugador() % 2 == 0) {
                        logicaJuego.setJugador(logicaJuego.getJugador() - 1);
                    } else {
                        logicaJuego.setJugador(logicaJuego.getJugador() + 1);
                    }
                }
            }

            return true;
        }

        return false;
    }

    private void drawGameBoard(Canvas canvas) {
        paint.setColor(boardColor);
        paint.setStrokeWidth(16);

        for (int columna = 1; columna < 3; columna++) {
            canvas.drawLine(cellSize*columna, 0, cellSize*columna, canvas.getWidth(), paint);
        }

        for (int fila = 1; fila < 3; fila++) {
            canvas.drawLine(0, cellSize*fila, canvas.getWidth(), cellSize*fila, paint);
        }
    }

    private void drawMarkers(Canvas canvas) {
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (logicaJuego.getPosJuego()[f][c] != 0) {
                    if (logicaJuego.getPosJuego()[f][c] == 1) {
                        drawX(canvas, f, c);
                    } else {
                        drawO(canvas, f, c);
                    }
                }
            }
        }
    }

    /**
     * Metodo que muestra la X
     * @param canvas vista
     * @param fila pos
     * @param columna pos
     */
    private void drawX(Canvas canvas, int fila, int columna) {
        paint.setColor(XColor);

        canvas.drawLine((float) ((columna + 1) * cellSize - cellSize * 0.2),
                        (float) (fila * cellSize + cellSize * 0.2),
                        (float) (columna * cellSize + cellSize * 0.2),
                        (float) ((fila+1) * cellSize - cellSize * 0.2),
                        paint);

        canvas.drawLine((float) (columna * cellSize + cellSize * 0.2),
                        (float) (fila * cellSize + cellSize * 0.2),
                        (float) ((columna + 1) * cellSize - cellSize * 0.2),
                        (float) ((fila+1) * cellSize - cellSize * 0.2),
                        paint);
    }

    /**
     * Metodo que muestra la O
     * @param canvas vista
     * @param fila pos
     * @param columna pos
     */
    private void drawO(Canvas canvas, int fila, int columna) {
        paint.setColor(OColor);

        canvas.drawOval((float) (columna * cellSize + cellSize * 0.2),
                        (float) (fila * cellSize + cellSize * 0.2),
                        (float) ((columna * cellSize + cellSize) - cellSize * 0.2),
                        (float) ((fila * cellSize + cellSize) - cellSize * 0.2),
                        paint);
    }

    /**
     * Metodo que pinta la raya horizontal
     * @param canvas vista
     * @param fila ganadora
     * @param columna ganadora
     */
    private void drawLineaHorizontal(Canvas canvas, int fila, int columna) {
        canvas.drawLine(columna,
                        fila * cellSize + (float) cellSize / 2,
                        cellSize * 3,
                        fila * cellSize + (float) cellSize / 2,
                        paint);
    }

    /**
     * Metodo que pinta la raya vertical
     * @param canvas vista
     * @param fila ganadora
     * @param columna ganadora
     */
    private void drawLineaVertical(Canvas canvas, int fila, int columna) {
        canvas.drawLine(columna * cellSize + (float) cellSize / 2,
                        fila,
                        columna * cellSize + (float) cellSize / 2,
                        cellSize * 3,
                        paint);
    }

    /**
     * Metodo que pinta la raya diagonal 02 -> 11 -> 20
     * @param canvas vista
     */
    private void drawLineaDiagonalPos(Canvas canvas) {
        canvas.drawLine(0, cellSize * 3, cellSize * 3, 0, paint);
    }

    /**
     * Metodo que pinta la raya diagonal 00 -> 11 -> 22
     * @param canvas vista
     */
    private void drawLineaDiagonalNeg(Canvas canvas) {
        canvas.drawLine(0, 0, cellSize * 3, cellSize * 3, paint);
    }

    /**
     * Metodo que controla que linea ganadora mostrar
     * @param canvas vista
     */
    private void drawLineaGanador(Canvas canvas) {
        int fila = logicaJuego.getTipoGanador()[0];
        int columna = logicaJuego.getTipoGanador()[1];
        int tipo = logicaJuego.getTipoGanador()[2];

        switch (tipo) {
            case 1:
                drawLineaHorizontal(canvas, fila, columna);
                break;
            case 2:
                drawLineaVertical(canvas, fila, columna);
                break;
            case 3:
                drawLineaDiagonalNeg(canvas);
                break;
            case 4:
                drawLineaDiagonalPos(canvas);
                break;
        }

    }

    /**
     * Pasar los botones, el texto para el turno y nos nombre de los jugadores
     * @param reinicar boton
     * @param inicio boton
     * @param turnoJugador TextView
     * @param nombres lista con los nombres de los jugadores
     */
    public void setUpGame(Button reinicar, Button inicio, TextView turnoJugador, String[] nombres) {
        logicaJuego.setTurnoJugador(turnoJugador);
        logicaJuego.setBtnInicio(inicio);
        logicaJuego.setBtnReiniciar(reinicar);
        logicaJuego.setNombresJugadores(nombres);
    }

    /**
     * Metodo para reiniciar la partida
     */
    public void reiniciarJuego() {
        logicaJuego.reiniciarJuego();
        lineaGanador = false;
    }
}
