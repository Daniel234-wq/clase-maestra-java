package com.taller.nivel1;

public class Reto1_1_MascotaDigital {
    public static void main(String[] args) {
        System.out.println("=== RETO 1.1: MASCOTA DIGITAL ===");
        Mascota mascota = new Mascota();
        mascota.nombre = "Firulais";
        mascota.energia = 60;
        System.out.println("Energia inicial: " + mascota.energia);

        mascota.jugar();
        System.out.println("Despues de jugar 1 vez: " + mascota.energia);
        mascota.jugar();
        System.out.println("Despues de jugar 2 veces: " + mascota.energia);

        mascota.comer(20);
        System.out.println("Despues de comer 20: " + mascota.energia);

        System.out.println("Estado final: " + mascota.estado());
    }

    static class Mascota {
        String nombre;
        int energia;

        void jugar() {
            energia = energia - 15;
        }

        void comer(int porcion) {
            energia = energia + porcion;
        }

        String estado() {
            if (energia >= 50) {
                return "Feliz";
            } else {
                return "Cansada";
            }
        }
    }
}
