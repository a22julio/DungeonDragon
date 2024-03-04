package dd.core;

public class Rey extends Personaje {
    public Rey(String nombre) {
        super(nombre);
        setSalud(2000);
    }

    @Override
    public int[] ataca(Personaje enemigo) {
        int[] valorAtaque = new int[3];
        for (int i = 0; i < valorAtaque.length; i++) {
            valorAtaque[i] = Personaje.calcularValorAtaque(this, enemigo);
        }
        return valorAtaque;
    }
}
