package com.taller.nivel5;

public class Reto5_2_SelloArena {
    public static void main(String[] args) {
        System.out.println("=== RETO 5.2: SELLA LA ARENA ===");
        System.out.println("Demostracion de las 3 trampas bloqueadas por el modificador 'final':\n");

        System.out.println("Trampa 1: Intentar heredar de una clase final:");
        System.out.println("   Codigo: 'class ReglasTramposas extends Reglas { }'");
        System.out.println("   Respuesta del compilador: 'cannot inherit from final Reglas'");

        System.out.println("\nTrampa 2: Intentar modificar una constante static final:");
        System.out.println("   Codigo: 'Reglas.VIDA_MAXIMA = 9999;'");
        System.out.println("   Respuesta del compilador: 'cannot assign a value to static final variable VIDA_MAXIMA'");

        System.out.println("\nTrampa 3: Intentar sobrescribir un metodo final:");
        System.out.println("   Codigo: '@Override public String getNombre() { return \"Hacker\"; }'");
        System.out.println("   Respuesta del compilador: 'getNombre() in Tramposo cannot override getNombre() in Personaje; overridden method is final'");
    }

    final static class Reglas {
        public static final int VIDA_MAXIMA = 150;
    }

    // Trampa 1 comentada para permitir compilacion limpia:
    // static class ReglasTramposas extends Reglas { }

    static class Personaje {
        private final String nombre;

        public Personaje(String nombre) {
            this.nombre = nombre;
        }

        public final String getNombre() {
            return nombre;
        }
    }

    // Trampa 3 comentada para permitir compilacion limpia:
    /*
    static class Tramposo extends Personaje {
        public Tramposo(String nombre) {
            super(nombre);
        }
        @Override
        public String getNombre() {
            return "Hacker";
        }
    }
    */
}
