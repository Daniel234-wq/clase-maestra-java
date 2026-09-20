package com.taller.nivel3;

public class CazabugsNivel3 {
    public static void main(String[] args) {
        System.out.println("=== CAZABUGS - NIVEL 3 ===");
        System.out.println("Bug 1 (Linea 21 original): 'public Grifo(int velocidad)' no llamaba a super(velocidad).");
        System.out.println("      Correccion: Agregar 'super(velocidad);' como primera linea.");
        System.out.println("Bug 2 (Linea 26 original): 'public void mostar()'. Tipografia erronea 'mostar' en vez de 'mostrar'.");
        System.out.println("      Correccion: Corregir a 'public void mostrar()'.");
        System.out.println("Bug 3 (Linea 27 original): 'velocidad = velocidad + 10;'. 'velocidad' en Montura es private.");
        System.out.println("      Correccion: Cambiar 'private int velocidad' a 'protected int velocidad' en Montura.");

        Grifo g = new Grifo(40);
        g.mostrar();
    }

    static class Montura {
        protected int velocidad;

        public Montura(int velocidad) {
            this.velocidad = velocidad;
        }

        public void mostrar() {
            System.out.println("Velocidad: " + velocidad);
        }
    }

    static class Grifo extends Montura {
        public Grifo(int velocidad) {
            super(velocidad);
            System.out.println("Nace un grifo");
        }

        @Override
        public void mostrar() {
            velocidad = velocidad + 10;
            super.mostrar();
        }
    }
}
