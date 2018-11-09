package ar.com.cobol.resources;

public class DirectionUtils {

	public enum Direcciones {
		QUIETO, IZQUIERDA, DERECHA, ARRIBA, ABAJO;

		public static Direcciones opuesto(Direcciones direccion) {
			if (direccion == IZQUIERDA) {
				return DERECHA;
			}
			if (direccion == DERECHA) {
				return IZQUIERDA;
			}
			if (direccion == ARRIBA) {
				return ABAJO;
			}
			if (direccion == ABAJO) {
				return ARRIBA;
			}
			return QUIETO;
		}
	}

	public static final int MOVER_IZQ_O_ABAJO = -1;
	public static final int MOVER_DER_O_ARRIBA = 1;
	public static final int MOVIMIENTO = 10;

}
