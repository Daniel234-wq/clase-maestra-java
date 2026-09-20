package com.taller;

import java.util.ArrayList;

/**
 * Archivo autonomo unificado para la batalla contra el Dragon Null
 * correspondiente a la estructura del Anexo C del taller.
 */
public class MainBatallaJefeFinal {

    public static void main(String[] args) {
        System.out.println("=== BATALLA CONTRA EL DRAGON NULL (PUNTO DE GUARDADO ANEXO C) ===");

        // Fase 5: Estrategia de orden optimo para la victoria
        Guerrero brako = new Guerrero("Brako", 120, 10, 10);
        Arquero aria = new Arquero("Aria", 90, 14, 6);
        Mago lira = new Mago("Lira", 70, 12);

        Escuadron escuadron = new Escuadron();
        escuadron.agregar(brako);
        escuadron.agregar(aria);
        escuadron.agregar(lira);

        Dragon dragon = new Dragon();
        int ronda = 0;

        while (dragon.estaVivo() && escuadron.hayVivos() && ronda < Reglas.MAX_RONDAS) {
            ronda++;
            int danio = escuadron.atacarTodos();
            dragon.recibirDanio(danio);
            System.out.println("Ronda " + ronda + ": danio " + danio + ". Dragon: " + dragon.getVida());

            if (dragon.estaVivo()) {
                Personaje objetivo = escuadron.primeroVivo();
                int golpe = dragon.atacar(ronda);
                objetivo.recibirDanio(golpe);
                System.out.println("  Golpe de " + golpe + " a " + objetivo.getNombre() + ". Vida: " + objetivo.getVida());
            }
        }

        System.out.println();
        if (!dragon.estaVivo()) {
            System.out.println("VICTORIA! en la ronda " + ronda);
        } else if (!escuadron.hayVivos()) {
            System.out.println("GAME OVER en la ronda " + ronda);
        } else {
            System.out.println("El dragon escapa al amanecer");
        }
    }

    // --- REGLAS ---
    final static class Reglas {
        public static final int MAX_MIEMBROS = 3;
        public static final int MAX_RONDAS = 12;
    }

    // --- PERSONAJE BASE ---
    static class Personaje {
        protected final String nombre;
        protected int vida;
        protected int ataque;

        public Personaje(String nombre, int vida, int ataque) {
            this.nombre = nombre;
            this.vida = vida;
            this.ataque = ataque;
        }

        public final String getNombre() {
            return nombre;
        }

        public int getVida() {
            return vida;
        }

        public boolean estaVivo() {
            return vida > 0;
        }

        public int atacar() {
            return ataque;
        }

        public void recibirDanio(int danio) {
            this.vida = Math.max(0, this.vida - danio);
        }
    }

    // --- GUERRERO ---
    static class Guerrero extends Personaje {
        private int armadura;

        public Guerrero(String nombre, int vida, int ataque, int armadura) {
            super(nombre, vida, ataque);
            this.armadura = armadura;
        }

        @Override
        public int atacar() {
            return ataque + 5;
        }

        @Override
        public void recibirDanio(int golpe) {
            int danioReal = Math.max(0, golpe - armadura);
            super.recibirDanio(danioReal);
        }
    }

    // --- MAGO ---
    static class Mago extends Personaje {
        public Mago(String nombre, int vida, int ataque) {
            super(nombre, vida, ataque);
        }

        @Override
        public int atacar() {
            return ataque * 2;
        }
    }

    // --- ARQUERO (Fase 2) ---
    static class Arquero extends Personaje {
        private int precision;

        public Arquero(String nombre, int vida, int ataque, int precision) {
            super(nombre, vida, ataque);
            this.precision = precision;
        }

        @Override
        public int atacar() {
            return ataque + precision;
        }
    }

    // --- DRAGON NULL (Fase 3) ---
    final static class Dragon extends Personaje {
        public Dragon() {
            super("Dragon Null", 330, 35);
        }

        public int atacar(int ronda) {
            if (ronda % 3 == 0) {
                return ataque * 2;
            }
            return ataque;
        }
    }

    // --- ESCUADRON ---
    static class Escuadron {
        private ArrayList<Personaje> miembros = new ArrayList<>();

        public boolean agregar(Personaje p) {
            if (miembros.size() >= Reglas.MAX_MIEMBROS) {
                return false;
            }
            miembros.add(p);
            return true;
        }

        public boolean hayVivos() {
            for (Personaje p : miembros) {
                if (p.estaVivo()) {
                    return true;
                }
            }
            return false;
        }

        public Personaje primeroVivo() {
            for (Personaje p : miembros) {
                if (p.estaVivo()) {
                    return p;
                }
            }
            return null;
        }

        public int atacarTodos() {
            int total = 0;
            for (Personaje p : miembros) {
                if (p.estaVivo()) {
                    total += p.atacar();
                }
            }
            return total;
        }
    }
}
