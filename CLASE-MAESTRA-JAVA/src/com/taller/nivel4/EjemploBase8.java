package com.taller.nivel4;

public class EjemploBase8 {
    public static void main(String[] args) {
        // La etiqueta es Personaje; el objeto real es un Mago
        Personaje p = new Mago("Lira", 70, 12);
        System.out.println("p.atacar(): " + p.atacar()); // Imprime 24

        // La siguiente linea no compila porque la etiqueta 'Personaje' no conoce el metodo:
        // p.lanzarHechizo();

        // Downcasting seguro con instanceof
        if (p instanceof Mago) {
            Mago m = (Mago) p;
            m.lanzarHechizo();
        }

        // Sobrecarga de atacar en Guerrero
        Guerrero brako = new Guerrero("Brako", 120, 15);
        System.out.println("brako.atacar(): " + brako.atacar());
        System.out.println("brako.atacar(10): " + brako.atacar(10));
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

        // Sobrecarga
        public int atacar(int furia) {
            return atacar() + furia;
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

        public void lanzarHechizo() {
            System.out.println(nombre + " lanza un rayo");
        }
    }
}
