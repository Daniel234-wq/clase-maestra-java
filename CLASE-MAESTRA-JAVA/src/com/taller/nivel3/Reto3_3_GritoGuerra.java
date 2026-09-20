package com.taller.nivel3;

public class Reto3_3_GritoGuerra {
    public static void main(String[] args) {
        System.out.println("=== RETO 3.3: GRITO DE GUERRA ===");
        Personaje g = new Guerrero("Brako", 120, 15, 10);
        Personaje m = new Mago("Lira", 70, 12, 60);
        Personaje a = new Arquero("Robin", 90, 14, 8);

        g.presentarse();
        System.out.println();
        m.presentarse();
        System.out.println();
        a.presentarse();
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

        public void presentarse() {
            System.out.println(nombre + " | vida " + vida + " | ataque " + ataque);
        }
    }

    static class Guerrero extends Personaje {
        private int armadura;

        public Guerrero(String nombre, int vida, int ataque, int armadura) {
            super(nombre, vida, ataque);
            this.armadura = armadura;
        }

        @Override
        public void presentarse() {
            super.presentarse();
            System.out.println("   [Grito Guerrero]: Por la gloria de LosNullPointers, mi armadura de " 
                    + armadura + " resistira cualquier embate!");
        }
    }

    static class Mago extends Personaje {
        private int mana;

        public Mago(String nombre, int vida, int ataque, int mana) {
            super(nombre, vida, ataque);
            this.mana = mana;
        }

        @Override
        public void presentarse() {
            super.presentarse();
            System.out.println("   [Grito Mago]: Que los arcanos de LosNullPointers ardan con mis " 
                    + mana + " puntos de mana!");
        }
    }

    static class Arquero extends Personaje {
        private int flechas;

        public Arquero(String nombre, int vida, int ataque, int flechas) {
            super(nombre, vida, ataque);
            this.flechas = flechas;
        }

        @Override
        public void presentarse() {
            super.presentarse();
            System.out.println("   [Grito Arquero]: Ojo certero de LosNullPointers, mis " 
                    + flechas + " flechas nunca fallan el blanco!");
        }
    }
}
