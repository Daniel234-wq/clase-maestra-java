package com.taller.nivel1;

public class PracticaPRIMM1 {
    public static void main(String[] args) {
        System.out.println("=== PRACTICA GUIADA PRIMM - NIVEL 1 ===");

        // 1. Predice y Ejecuta: daño 120
        Heroe kira = new Heroe();
        kira.nombre = "Kira";
        kira.vida = 100;
        kira.ataque = 12;

        kira.recibirDanio(120);
        System.out.println("1 y 2. Despues de recibir 120 de danio:");
        System.out.println("   kira.vida: " + kira.vida + " (Prediccion acertada: -20)");
        System.out.println("   kira.estaVivo(): " + kira.estaVivo() + " (Prediccion acertada: false)");
        System.out.println("   Analisis: No tiene sentido una vida negativa en un juego; se debe controlar mediante encapsulamiento.");

        // 3. Investiga: El secreto del fantasma y valores por defecto
        Heroe fantasma = new Heroe();
        System.out.print("3. Fantasma saludando: ");
        fantasma.saludar();
        System.out.println("   Aparece 'null' y '0' porque los atributos de tipo referencia arrancan en null y los enteros en 0.");

        // 4. Modifica: Método curar
        kira.curar(50);
        System.out.println("4. Despues de curar(50) partiendo de -20 de vida:");
        System.out.println("   kira.vida resultante: " + kira.vida + " (-20 + 50 = 30)");

        // Predicciones relámpago
        System.out.println("\n=== PREDICCIONES RELAMPAGO - NIVEL 1 ===");
        // Predicción A
        Heroe a = new Heroe();
        a.vida = 50;
        Heroe b = a;
        b.vida = 10;
        System.out.println("Prediccion A: a.vida = " + a.vida + " (Ambas variables apuntan al mismo objeto en el heap)");

        // Predicción B
        Heroe x = new Heroe();
        x.ataque = 7;
        x.ataque = x.golpeCritico(); // 7 * 2 = 14
        int r = x.golpeCritico();    // 14 * 2 = 28
        System.out.println("Prediccion B: r = " + r + " (Esperado: 28)");

        // Predicción C
        Heroe z = new Heroe();
        System.out.println("Prediccion C:");
        System.out.println("   z.nombre: " + z.nombre + " (null)");
        System.out.println("   z.vida: " + z.vida + " (0)");
        System.out.println("   z.estaVivo(): " + z.estaVivo() + " (false)");
    }

    static class Heroe {
        String nombre;
        int vida;
        int ataque;

        void recibirDanio(int danio) {
            vida = vida - danio;
        }

        boolean estaVivo() {
            return vida > 0;
        }

        int golpeCritico() {
            return ataque * 2;
        }

        void saludar() {
            System.out.println("Soy " + nombre + ", vida " + vida);
        }

        void curar(int puntos) {
            vida = vida + puntos;
        }
    }
}
