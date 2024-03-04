package dd.core;

public class AtaqueArco implements Ataque {
    @Override
    public void lanzaAtaque(Personaje enemigo) {
        enemigo.setSalud(enemigo.getSalud() - this.quitarSaludEnemigo());
    }

    public int quitarSaludEnemigo() {
        return (int) (Ataque.getAciertoFactor() * 50);
    }
}
