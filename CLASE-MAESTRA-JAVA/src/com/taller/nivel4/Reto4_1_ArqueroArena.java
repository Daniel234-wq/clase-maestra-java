package com.taller.nivel4;

public class Reto4_1_ArqueroArena {
    public static void main(String[] args) {
        System.out.println("=== RETO 4.1: EL ARQUERO ENTRA A LA ARENA ===");

        Personaje[] arena = {
            new Guerrero("Brako", 120, 15),
            new Mago("Lira", 70, 12),
            new Personaje("Aldeano", 40, 3),
            new Arquero("Navegante", 90, 8, 1) // 1 flecha inicial
        };

        for (int ronda = 1; ronda <= 2; ronda++) {
            System.out.println("--- RONDA " + ronda + " ---");
            int totalRonda = 0;
            for (Personaje p : arena) {
                int danio = p.atacar();
                System.out.println("  " + p.getNombre() + " hace " + danio + " de danio");
                totalRonda += danio;
            }
            System.out.println("Danio total de la ronda " + ronda + ": " + totalRonda + "\n");
        }

        System.out.println("Explicacion del equipo:");
        System.out.println("El bucle polimorfico trata a todos como 'Personaje' sin consultar su clase.");
        System.out.println("La ronda 1 produce mas danio que la ronda 2 porque el Arquero consumio su unica flecha");
        System.out.println("en el primer ataque (8 * 3 = 24), y en la segunda ronda al no tener flechas ataco con 1.");
    }

    static class Personaje {
        protected String nombre;
        protected int vida;
        protected int ataque;

        public Personaje(String nombre, int vida, int ataque) {
            this.nombre = nombre;
            this.vida = vida;
            this.ataque = ataque;
        }

        public String getNombre() {
            return nombre;
        }

        public int atacar() {
            return ataque;
        }
    }

    static class Guerrero extends Personaje {
        public Guerrero(String nombre, int vida, int ataque) {
            super(nombre, vida, ataque);
        }

        @Override
        public int atacar() {
            return ataque + 5;
        }
    }

    static class Mago extends Personaje {
        public Mago(String nombre, int vida, int ataque) {
            super(nombre, vida, ataque);
        }

        @Override
        public int atacar() {
            return ataque * 2;
        }
    }

    static class Arquero extends Personaje {
        private int flechas;

        public Arquero(String nombre, int vida, int ataque, int flechas) {
            super(nombre, vida, ataque);
            this.flechas = flechas;
        }

        @Override
        public int atacar() {
            if (flechas > 0) {
                flechas--;
                return ataque * 3;
            }
            return 1;
        }
    }
}
