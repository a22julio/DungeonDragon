package dd.core;

public class Caballero extends Personaje {
    public Caballero(String nombre) {
        super(nombre);
        setSalud(1500);
    }

    @Override
    public int[] ataca(Personaje enemigo) {
        int[] valorAtaque = new int[2];
        for (int i = 0; i < valorAtaque.length; i++) {
            valorAtaque[i] = Personaje.calcularValorAtaque(this, enemigo);
        }
        return valorAtaque;
    }
}