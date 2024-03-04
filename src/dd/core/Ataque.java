package dd.core;

import java.util.Random;

public interface Ataque {
    void lanzaAtaque(Personaje enemigo);
    //La implementación del método es siempre la misma, por lo que lo hago estático
    //De este modo, evito código duplicado en los algoritmos concretos
    static double getAciertoFactor() {
        Random r = new Random();
        return r.nextInt(2) * r.nextDouble();
    }
}