package com.taller.nivel3;

public class PracticaPRIMM3 {
    public static void main(String[] args) {
        System.out.println("=== PRACTICA GUIADA PRIMM - NIVEL 3 ===");

        // 1. Predice y ejecuta: Borrar super(...)
        System.out.println("1. Si se borra super(nombre, vida, ataque) del constructor de Guerrero:");
        System.out.println("   Prediccion: El compilador busca un constructor vacio Personaje(), y como no existe, no compila.");
        System.out.println("   Mensaje de error: 'constructor Personaje in class Personaje cannot be applied to given types'");

        // 2. Investiga: protected vs private
        System.out.println("\n2. Si se cambia 'protected String nombre;' por 'private String nombre;':");
        System.out.println("   Falla: Guerrero.defender() y Mago.lanzarHechizo() porque no pueden acceder al atributo privado del padre.");
        System.out.println("   No falla: presentarse() no falla porque esta definido dentro de Personaje, donde 'nombre' si es visible.");

        // 3. Modifica: Mago sobrescribe presentarse()
        System.out.println("\n3. Mago con presentarse() sobrescrito usando super.presentarse():");
        Mago lira = new Mago("Lira", 70, 10, 50);
        lira.presentarse();

        // Predicciones relámpago y rompecabezas
        System.out.println("\n=== PREDICCIONES Y ROMPECABEZAS - NIVEL 3 ===");

        // Predicción A: Encadenamiento de constructores
        System.out.println("Prediccion A (new C()):");
        new C(); // Imprime A, luego B, luego C

        // Predicción B: Sobrescritura con super
        System.out.println("\nPrediccion B (gato.sonido()):");
        Gato g = new Gato();
        System.out.println(g.sonido()); // Imprime Miau...

        // Predicción C
        System.out.println("\nPrediccion C:");
        System.out.println("   'lira.defender()' NO compila porque el metodo 'defender()' pertenece exclusivamente");
        System.out.println("   a la clase Guerrero, y la referencia 'lira' es de tipo Mago.");
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

    static class Mago extends Personaje {
        private int mana;

        public Mago(String nombre, int vida, int ataque, int mana) {
            super(nombre, vida, ataque);
            this.mana = mana;
        }

        @Override
        public void presentarse() {
            super.presentarse();
            System.out.println("   Mago con " + mana + " de mana");
        }
    }

    // Clases para Predicción A
    static class A {
        A() { System.out.println("A"); }
    }
    static class B extends A {
        B() { System.out.println("B"); }
    }
    static class C extends B {
        C() { System.out.println("C"); }
    }

    // Clases para Predicción B
    static class Animal {
        String sonido() { return "..."; }
    }
    static class Gato extends Animal {
        @Override
        String sonido() {
            return "Miau" + super.sonido();
        }
    }
}
