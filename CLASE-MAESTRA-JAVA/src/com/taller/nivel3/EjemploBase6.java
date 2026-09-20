package com.taller.nivel3;

public class EjemploBase6 {
    public static void main(String[] args) {
        Guerrero brako = new Guerrero("Brako", 120, 15, 8);
        Mago lira = new Mago("Lira", 70, 10, 50);

        brako.presentarse();
        brako.defender();
        lira.presentarse();
        lira.lanzarHechizo();
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
            System.out.println("   Guerrero con " + armadura + " de armadura");
        }

        public void defender() {
            System.out.println(nombre + " se defiende: +" + armadura);
        }
    }

    static class Mago extends Personaje {
        private int mana;

        public Mago(String nombre, int vida, int ataque, int mana) {
            super(nombre, vida, ataque);
            this.mana = mana;
        }

        public void lanzarHechizo() {
            mana = mana - 20;
            System.out.println(nombre + " hechiza. Mana: " + mana);
        }
    }
}
