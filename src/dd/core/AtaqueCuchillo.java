package dd.core;

public class AtaqueCuchillo implements Ataque {
    @Override
    public void lanzaAtaque(Personaje enemigo) {
        enemigo.setSalud(enemigo.getSalud() - this.quitarSaludEnemigo());
    }

    public int quitarSaludEnemigo() {
        return (int) (Ataque.getAciertoFactor() * 25);
    }
}
