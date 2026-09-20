package com.taller.jefefinal;

public class BatallaFase5Victoria {
    public static void main(String[] args) {
        System.out.println("=== JEFE FINAL: FASE 5 - ESTRATEGIA DEMOSTRADA (VICTORIA) ===");
        System.out.println("Estrategia del gremio: Poner a Brako (Guerrero) de primero como tanque.");
        System.out.println("Gracias a su armadura de 10, reduce cada golpe del dragon.");
        System.out.println("Orden estrategico: 1. Brako (Guerrero), 2. Aria (Arquero), 3. Lira (Mago)\n");

        Guerrero brako = new Guerrero("Brako", 120, 10, 10);
        Arquero aria = new Arquero("Aria", 90, 14, 6);
        Mago lira = new Mago("Lira", 70, 12);

        Escuadron escuadron = new Escuadron();
        escuadron.agregar(brako);
        escuadron.agregar(aria);
        escuadron.agregar(lira);

        Dragon dragon = new Dragon();
        int ronda = 0;

        System.out.println(String.format("%-6s | %-12s | %-15s | %-10s | %-8s | %-10s | %-10s | %-10s",
                "Ronda", "Danio Esc.", "Vida Dragon", "Objetivo", "Golpe", "Vida Brako", "Vida Aria", "Vida Lira"));
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("%-6s | %-12s | %-15s | %-10s | %-8s | %-10s | %-10s | %-10s",
                "inicio", "--", "330", "--", "--", "120", "90", "70"));

        while (dragon.estaVivo() && escuadron.hayVivos() && ronda < Reglas.MAX_RONDAS) {
            ronda++;
            int danio = escuadron.atacarTodos();
            dragon.recibirDanio(danio);

            String objetivoNombre = "--";
            String golpeStr = "--";

            if (dragon.estaVivo()) {
                Personaje objetivo = escuadron.primeroVivo();
                int golpe = dragon.atacar(ronda);
                objetivo.recibirDanio(golpe);
                objetivoNombre = objetivo.getNombre();
                golpeStr = String.valueOf(golpe);
            }

            System.out.println(String.format("%-6d | %-12d | %-15d | %-10s | %-8s | %-10d | %-10d | %-10d",
                    ronda, danio, dragon.getVida(), objetivoNombre, golpeStr,
                    brako.getVida(), aria.getVida(), lira.getVida()));
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println();
        if (!dragon.estaVivo()) {
            System.out.println("VICTORIA! en la ronda " + ronda);
            System.out.println("El Dragon Null ha sido derrotado!");
        } else if (!escuadron.hayVivos()) {
            System.out.println("GAME OVER en la ronda " + ronda);
        } else {
            System.out.println("El dragon escapa al amanecer");
        }

        System.out.println("\nPor que funciona esta estrategia?");
        System.out.println("1. Brako resiste como tanque 4 rondas completas (absorbiendo 10 de danio en cada golpe).");
        System.out.println("2. Al mantener con vida a Lira (24 DPS) y Aria (20 DPS), el escuadron inflige 59 de danio");
        System.out.println("   por ronda durante las 4 primeras rondas, dejando al dragon moribundo.");
        System.out.println("3. En la ronda 7, el escuadron remata los ultimos puntos de vida del dragon antes de que pueda atacar.");
    }
}
