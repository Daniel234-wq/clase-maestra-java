package com.taller.jefefinal;

public class BatallaFase4Derrota {
    public static void main(String[] args) {
        System.out.println("=== JEFE FINAL: FASE 4 - BATALLA CON ORDEN ORIGINAL ===");
        System.out.println("Orden original del escuadron: 1. Lira (Mago), 2. Aria (Arquero), 3. Brako (Guerrero)\n");

        Escuadron escuadron = new Escuadron();
        escuadron.agregar(new Mago("Lira", 70, 12));
        escuadron.agregar(new Arquero("Aria", 90, 14, 6));
        escuadron.agregar(new Guerrero("Brako", 120, 10, 10));

        Dragon dragon = new Dragon();
        int ronda = 0;

        while (dragon.estaVivo() && escuadron.hayVivos() && ronda < Reglas.MAX_RONDAS) {
            ronda++;
            int danio = escuadron.atacarTodos();
            dragon.recibirDanio(danio);
            System.out.println("Ronda " + ronda + ": danio " + danio + ". Dragon: " + dragon.getVida());

            if (dragon.estaVivo()) {
                Personaje objetivo = escuadron.primeroVivo();
                int golpe = dragon.atacar(ronda);
                objetivo.recibirDanio(golpe);
                System.out.println("  Golpe de " + golpe + " a " + objetivo.getNombre() + ". Vida: " + objetivo.getVida());
            }
        }

        System.out.println();
        if (!dragon.estaVivo()) {
            System.out.println("VICTORIA! en la ronda " + ronda);
        } else if (!escuadron.hayVivos()) {
            System.out.println("GAME OVER en la ronda " + ronda);
        } else {
            System.out.println("El dragon escapa al amanecer");
        }

        System.out.println("\nAnalisis de la derrota:");
        System.out.println("El dragon ataca siempre al primer heroe vivo de la lista.");
        System.out.println("Al poner a Lira (Mago, 70 HP) de primera, muere en la ronda 2, perdiendo 24 de DPS.");
        System.out.println("Luego Aria (Arquero) recibe el impacto critico de 70 en la ronda 3 y muere en la 4.");
        System.out.println("Brako queda solo y no logra vencer al dragon antes de caer.");
    }
}
