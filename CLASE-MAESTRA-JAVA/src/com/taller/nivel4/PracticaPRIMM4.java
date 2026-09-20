package com.taller.nivel4;

public class PracticaPRIMM4 {
    public static void main(String[] args) {
        System.out.println("=== PRACTICA GUIADA PRIMM - NIVEL 4 ===");

        // 1. Predice y ejecuta: Agregar a Nox (ataque 20 -> 20*2 = 40)
        Personaje[] arenaConNox = {
            new Guerrero("Brako", 120, 15),       // 20
            new Mago("Lira", 70, 12),             // 24
            new Personaje("Aldeano", 40, 3),      // 3
            new Mago("Nox", 60, 20)               // 40
        };

        int totalNox = 0;
        for (Personaje p : arenaConNox) {
            totalNox += p.atacar();
        }
        System.out.println("1. Danio total con Nox: " + totalNox + " (Prediccion confirmada: 47 + 40 = 87)");

        // 2. Investiga: Sin sobrescribir en Guerrero
        System.out.println("\n2. Si se borra atacar() de Guerrero:");
        System.out.println("   Brako devuelve 15 (el ataque base definido en Personaje, sin el bonus de +5).");

        // 3. Modifica: Filtrado con instanceof
        System.out.println("\n3. Recorrer la arena y hacer que solo los magos lancen su hechizo:");
        for (Personaje p : arenaConNox) {
            if (p instanceof Mago) {
                Mago m = (Mago) p;
                m.lanzarHechizo();
            }
        }
        System.out.println("   Sin el 'if (p instanceof Mago)', el compilador no puede saber el tipo en tiempo");
        System.out.println("   de ejecucion y lanzaria ClassCastException al intentar convertir a Brako o al Aldeano.");

        // Predicciones relámpago
        System.out.println("\n=== PREDICCIONES RELAMPAGO - NIVEL 4 ===");

        // Predicción A
        Personaje pA = new Guerrero("Brako", 120, 15);
        System.out.println("Prediccion A: " + pA.atacar() + " (Esperado: 20 por enlace dinamico)");

        // Predicción B
        Personaje[] eq = {
            new Mago("A", 50, 4),        // 4 * 2 = 8
            new Mago("B", 50, 4),        // 4 * 2 = 8
            new Guerrero("C", 50, 4)     // 4 + 5 = 9
        };
        int t = 0;
        for (Personaje x : eq) {
            t = t + x.atacar();
        }
        System.out.println("Prediccion B: Total acumulado = " + t + " (8 + 8 + 9 = 25)");

        // Predicción C
        Dado d = new Dado();
        System.out.println("Prediccion C:");
        System.out.println("   " + d.tirar());
        System.out.println("   " + d.tirar(20));
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

        public void lanzarHechizo() {
            System.out.println("   " + nombre + " lanza un hechizo arcano!");
        }
    }

    static class Dado {
        String tirar() {
            return "d6";
        }

        String tirar(int caras) {
            return "d" + caras;
        }
    }
}
