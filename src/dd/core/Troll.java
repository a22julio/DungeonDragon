package dd.core;

import java.util.Random;

public class Troll extends Personaje {
    public Troll(String nombre) {
        super(nombre);
        setSalud(1000);
        setAtaque(asignarAtaqueAleatorio());
    }

    @Override
    public int[] ataca(Personaje enemigo) {
        int[] valorAtaque = new int[1];
        valorAtaque[0] = Personaje.calcularValorAtaque(this, enemigo);
        return valorAtaque;
    }

    private Ataque asignarAtaqueAleatorio() {
        Random r = new Random();
        Ataque[] ataques = {new AtaqueEspada(), new AtaqueArco(), new AtaqueCuchillo()};
        int numAleatorio = r.nextInt(ataques.length);
        return ataques[numAleatorio];
    }
}