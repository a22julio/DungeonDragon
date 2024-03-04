package dd.main;

import dd.core.*;

import java.util.Random;

public class ControlLucha {
    private Personaje[] ejercitoHombres;
    private Personaje[] ejercitoTrolls; //Son cinco trolls

    public ControlLucha() {
        crearEjercitoHombres();
        crearEjercitoTrolls();
        luchar();
    }

    private void crearEjercitoHombres() {
        this.ejercitoHombres = new Personaje[3]; //Son tres hombres
        Rey r = new Rey("Rey Arturo");
        r.setAtaque(new AtaqueEspada()); //No lo incluyo en el constructor por si se quisieran crear más reyes con otros ataques en un futuro
        this.ejercitoHombres[0] = r;
        Caballero c1 = new Caballero("Lancelot");
        c1.setAtaque(new AtaqueEspada());
        this.ejercitoHombres[1] = c1;
        Caballero c2 = new Caballero("Percival");
        c2.setAtaque(new AtaqueArco());
        this.ejercitoHombres[2] = c2;
    }

    private void crearEjercitoTrolls() {
        this.ejercitoTrolls = new Personaje[5]; //Son cinco trolls
        Troll t1 = new Troll("Troll 1");
        this.ejercitoTrolls[0] = t1;
        Troll t2 = new Troll("Troll 2");
        this.ejercitoTrolls[1] = t2;
        Troll t3 = new Troll("Troll 3");
        this.ejercitoTrolls[2] = t3;
        Troll t4 = new Troll("Troll 4");
        this.ejercitoTrolls[3] = t4;
        Troll t5 = new Troll("Troll 5");
        this.ejercitoTrolls[4] = t5;
    }

    private void luchar() {
        mensajeInicial();
        while (comprobarSalud(this.ejercitoTrolls) && comprobarSalud(this.ejercitoHombres)) {
            turno(this.ejercitoHombres, this.ejercitoTrolls);
            turno(this.ejercitoTrolls, this.ejercitoHombres);
        }
        mensajeFinal();
    }

    private void mensajeInicial() {
        System.out.println("TESTIMONIO DE LA BATALLA");
        System.out.println("================================================================");
        System.out.println("================================================================");
        System.out.println("================================================================");
    }

    private boolean comprobarSalud(Personaje[] ejercito) {
        int contador = 0;
        for (Personaje p : ejercito) {
            if (p.getSalud() <= 0) {
                contador++;
                if (contador == ejercito.length) {
                    return false;
                }
            }
        }
        return true;
    }

    private void turno(Personaje[] ejercitoAtacante, Personaje[] ejercitoNoAtacante) {
        int contador = 0;
        while (contador < ejercitoAtacante.length) {
            Personaje p1 = ejercitoAtacante[contador];
            if (p1.getSalud() > 0) {
                Personaje p2 = personajeAleatorio(ejercitoNoAtacante);
                System.out.println(p1 + " lucha contra " + p2);
                imprimirAtaque(p1, p2, p1.ataca(p2));
                if (p2.getSalud() <= 0) {
                    System.out.println("[" + p2.getNombre().toUpperCase() + ": MUERTO]");
                    if (!comprobarSalud(ejercitoNoAtacante)) {
                        break;
                    }
                }
            }
            contador++;
        }
    }

    private Personaje personajeAleatorio(Personaje[] ejercito) {
        Random r = new Random();
        int personaje = r.nextInt(ejercito.length);
        //Aseguramos que el personaje aleatorio que escojamos tenga salud > 0
        while (ejercito[personaje].getSalud() <= 0) {
            personaje = r.nextInt(ejercito.length);
        }
        return ejercito[personaje];
    }

    private void imprimirAtaque(Personaje p1, Personaje p2, int[] valoresAtaque) {
        for (int valorAtaque : valoresAtaque) {
            if (valorAtaque == 0) {
                System.out.println("[" + p1.getNombre() + "] ataca a [" + p2.getNombre() + "] y el valor del ataque es: (falla)");
            } else {
                System.out.println("[" + p1.getNombre() + "] ataca a [" + p2.getNombre() + "] y el valor del ataque es: (-" + valorAtaque + ")");
            }
        }
    }

    private void mensajeFinal() {
        System.out.println("================================================================");
        System.out.println("================================================================");
        System.out.println("================================================================");
        if (!comprobarSalud(this.ejercitoTrolls)) {
            System.out.println("Finalmente, el ejército del Rey Arturo venció!!!");
            System.out.println("Los supervivientes de la batalla fueron: ");
            supervivientes(this.ejercitoHombres);
        } else if (!comprobarSalud(this.ejercitoHombres)) {
            System.out.println("Finalmente, el ejército del Rey Arturo perdió!!!");
            System.out.println("Los supervivientes de la batalla fueron: ");
            supervivientes(this.ejercitoTrolls);
        }
    }

    private void supervivientes(Personaje[] ejercito) {
        for (Personaje p : ejercito) {
            if (p.getSalud() > 0) {
                System.out.print(p + " ");
            }
        }
    }
}