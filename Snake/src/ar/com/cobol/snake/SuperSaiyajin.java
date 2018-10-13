package ar.com.cobol.snake;

public class SuperSaiyajin implements Estado{

    @Override
    public void hanldeEstado(Salamandra salamandra) {
        salamandra.setmodifVelocidad(2);

    }
}
