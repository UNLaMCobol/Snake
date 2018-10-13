package ar.com.cobol.snake;

import static ar.com.cobol.resources.directionUtils.*;

public class Muerto implements Estado{

    @Override
    public void hanldeEstado(Salamandra salamandra) {
        salamandra.setDireccion(QUIETO);
        salamandra.setmodifVelocidad(0);
    }
}
