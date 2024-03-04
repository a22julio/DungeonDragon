package dd.core;

public abstract class Personaje {
    private String nombre;
    private Ataque ataque;
    private int salud;

    public String getNombre() {
        return nombre;
    }
    public Ataque getAtaque() {
        return ataque;
    }
    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }
    public int getSalud() {
        return salud;
    }
    public void setSalud(int salud) {
        this.salud = salud;
    }

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public abstract int[] ataca(Personaje enemigo);

    //El cálculo del valor del ataque es exactamente igual para todos los objetos de cualquier personaje,
    //por lo que hago el método estático para evitar duplicar código en las clases hijas y para ganar eficiencia
    public static int calcularValorAtaque(Personaje atacante, Personaje enemigo) {
        int saludPreAtaque = enemigo.getSalud();
        atacante.getAtaque().lanzaAtaque(enemigo);
        int saludPostAtaque = enemigo.getSalud();
        return saludPreAtaque - saludPostAtaque;
    }

    /*
     * Personalmente, considero que sobreescribir el toString() supone mezclar la lógica de entrada/salida con la
     * lógica de negocio.
     * Sin embargo, en el boletín 3B, en el que se habla sobre la separación de lógicas, el ejemplo emplea un toString()
     * en usuarios, por lo que me he decidido por resolver así el ejercicio tras darle mil vueltas.
     *
     * Después de romperme la cabeza con esta cuestión y tras realizar una labor de investigación, considero que la
     * forma idónea para resolver este ejercicio sería combinar el patrón MVC con el patrón Strategy, pero como este primero
     * no lo hemos abordado a día de hoy y, especialmente, por la falta de tiempo, he decidido resolverlo con el toString()
     * sobreescrito.
     *
     * Quedo pendiente de la corrección para recibir feedback sobre esta cuestión
     * */
    @Override
    public String toString() {
        return "[" + this.nombre + ", " + this.salud + "]";
    }
}