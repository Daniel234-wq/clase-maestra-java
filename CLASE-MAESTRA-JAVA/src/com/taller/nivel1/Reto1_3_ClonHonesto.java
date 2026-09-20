package com.taller.nivel1;

public class Reto1_3_ClonHonesto {
    public static void main(String[] args) {
        System.out.println("=== RETO 1.3: EL CLON HONESTO ===");
        Heroe original = new Heroe();
        original.nombre = "Kira";
        original.vida = 100;
        original.ataque = 15;

        Heroe clon = original.clonar();

        System.out.println("Antes del ataque:");
        System.out.println("   Original: " + original.nombre + " con vida " + original.vida);
        System.out.println("   Clon:     " + clon.nombre + " con vida " + clon.vida);

        clon.recibirDanio(50);

        System.out.println("\nDespues de que el clon recibe 50 de danio:");
        System.out.println("   Original: " + original.nombre + " con vida " + original.vida + " (Conserva su vida)");
        System.out.println("   Clon:     " + clon.nombre + " con vida " + clon.vida + " (Vida reducida)");

        System.out.println("\nMapa de memoria:");
        System.out.println("   Stack: 'original' -> Heap Objeto 1 [nombre='Kira', vida=100]");
        System.out.println("   Stack: 'clon'     -> Heap Objeto 2 [nombre='Kira (clon)', vida=50]");
        System.out.println("   Al usar 'new', son dos rectangulos independientes en el Heap.");
    }

    static class Heroe {
        String nombre;
        int vida;
        int ataque;

        void recibirDanio(int danio) {
            vida = vida - danio;
        }

        Heroe clonar() {
            Heroe nuevo = new Heroe();
            nuevo.nombre = this.nombre + " (clon)";
            nuevo.vida = this.vida;
            nuevo.ataque = this.ataque;
            return nuevo;
        }
    }
}
