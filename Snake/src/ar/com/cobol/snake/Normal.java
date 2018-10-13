package ar.com.cobol.snake;

public class Normal implements Estado{

    @Override
    public void hanldeEstado(Salamandra salamandra) {
        salamandra.setmodifVelocidad(1);
    }
}
