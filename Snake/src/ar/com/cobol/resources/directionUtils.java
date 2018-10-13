package ar.com.cobol.resources;

public class directionUtils {

    public static final int QUIETO = 0;
    public static final int IZQUIERDA = 1;
    public static final int DERECHA = 2;
    public static final int ARRIBA = 3;
    public static final int ABAJO = 4;

    public static final int MOVER_IZQ_O_ABAJO = -1;
    public static final int MOVER_DER_O_ARRIBA = 1;

    public static boolean sonOpuestos(int x, int y){
        return ((x == IZQUIERDA && y == DERECHA) || (x == ARRIBA && y == ABAJO) ||
                (x == DERECHA && y == IZQUIERDA) || (x == ABAJO && y == ARRIBA))? true : false;
    }


}
