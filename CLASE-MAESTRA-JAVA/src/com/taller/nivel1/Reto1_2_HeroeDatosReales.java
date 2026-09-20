package com.taller.nivel1;

public class Reto1_2_HeroeDatosReales {
    public static void main(String[] args) {
        System.out.println("=== RETO 1.2: TU HEROE, TUS DATOS ===");
        Heroe heroe = new Heroe();
        heroe.nombre = "JAC"; // Iniciales de los integrantes del equipo
        heroe.vida = 43;      // Suma de dias de cumpleanos (12 + 3 + 28)
        heroe.ataque = 6;     // Letras del nombre del Piloto ("Carlos" = 6)

        System.out.println("Heroe del equipo: " + heroe.nombre);
        System.out.println("Vida base: " + heroe.vida);
        System.out.println("Ataque: " + heroe.ataque);

        int golpes100 = heroe.golpesParaVencer(100);
        int golpes250 = heroe.golpesParaVencer(250);

        System.out.println("Golpes necesarios contra enemigo de 100 HP: " + golpes100);
        System.out.println("Golpes necesarios contra enemigo de 250 HP: " + golpes250);
    }

    static class Heroe {
        String nombre;
        int vida;
        int ataque;

        int golpesParaVencer(int vidaEnemigo) {
            int golpes = 0;
            int vidaRestante = vidaEnemigo;
            while (vidaRestante > 0) {
                vidaRestante = vidaRestante - ataque;
                golpes++;
            }
            return golpes;
        }
    }
}
