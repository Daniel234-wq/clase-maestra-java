package com.taller.nivel4;

public class Reto4_3_FuriaSobrecargada {
    public static void main(String[] args) {
        System.out.println("=== RETO 4.3: FURIA SOBRECARGADA ===");
        Guerrero brako = new Guerrero("Brako", 120, 15);
        Mago lira = new Mago("Lira", 70, 12);

        int golpeBrako = brako.atacar(10);
        int golpeLira = lira.atacar(true);

        System.out.println("brako.atacar(10): " + golpeBrako + " (Esperado: 30)");
        System.out.println("lira.atacar(true): " + golpeLira + " (Esperado: 48)");

        System.out.println("\nAnalisis de compilacion:");
        System.out.println("Si escribimos:");
        System.out.println("   Personaje p = brako;");
        System.out.println("   p.atacar(10); // ERROR DE COMPILACION");
        System.out.println("\nPor que no compila p.atacar(10)?");
        System.out.println("Explicacion: En Java, la verificacion de que metodos pueden llamarse se realiza");
        System.out.println("en tiempo de compilacion basandose en el tipo estatico de la variable (la etiqueta 'Personaje').");
        System.out.println("Como la clase 'Personaje' solo declara 'atacar()' sin parametros y no conoce 'atacar(int)',");
        System.out.println("el compilador bloquea la llamada por seguridad de tipos.");
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

        // Sobrecarga de atacar
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

        // Sobrecarga de atacar
        public int atacar(boolean critico) {
            if (critico) {
                return atacar() * 2;
            }
            return atacar();
        }
    }
}
