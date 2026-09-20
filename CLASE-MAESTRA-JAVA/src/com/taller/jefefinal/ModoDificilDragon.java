package com.taller.jefefinal;

public class ModoDificilDragon {
    public static void main(String[] args) {
        System.out.println("=== JEFE FINAL: MODO DIFICIL (BONUS +30 XP) ===");
        System.out.println("Regla: El dragon inflige danio aleatorio entre 25 y 45 en cada golpe.");
        System.out.println("Formula: 25 + (int)(Math.random() * 21)\n");

        int victorias = 0;
        int derrotas = 0;
        int simulaciones = 5;

        for (int i = 1; i <= simulaciones; i++) {
            System.out.print("Simulacion #" + i + ": ");
            boolean gano = ejecutarSimulacion();
            if (gano) {
                victorias++;
                System.out.println("VICTORIA!");
            } else {
                derrotas++;
                System.out.println("DERROTA / ESCAPE!");
            }
        }

        System.out.println("\nResumen de 5 simulaciones: " + victorias + " Victorias, " + derrotas + " Derrotas.");
        System.out.println("\nPor que la tabla determinista ya no garantiza la victoria al 100%?");
        System.out.println("Explicacion: La aleatoriedad (estocasticidad) introduce variabilidad en el danio recibido.");
        System.out.println("Si el dragon saca consecutivamente golpes altos (cercanos a 45), Brako o Aria pueden caer");
        System.out.println("una ronda antes de lo previsto, disminuyendo el DPS acumulado del escuadron antes de derrotar al dragon.");
    }

    private static boolean ejecutarSimulacion() {
        Guerrero brako = new Guerrero("Brako", 120, 10, 10);
        Arquero aria = new Arquero("Aria", 90, 14, 6);
        Mago lira = new Mago("Lira", 70, 12);

        Escuadron escuadron = new Escuadron();
        escuadron.agregar(brako);
        escuadron.agregar(aria);
        escuadron.agregar(lira);

        DragonAleatorio dragon = new DragonAleatorio();
        int ronda = 0;

        while (dragon.estaVivo() && escuadron.hayVivos() && ronda < Reglas.MAX_RONDAS) {
            ronda++;
            int danio = escuadron.atacarTodos();
            dragon.recibirDanio(danio);

            if (dragon.estaVivo()) {
                Personaje objetivo = escuadron.primeroVivo();
                int golpe = dragon.atacarAleatorio();
                objetivo.recibirDanio(golpe);
            }
        }

        return !dragon.estaVivo();
    }

    static class DragonAleatorio extends Personaje {
        public DragonAleatorio() {
            super("Dragon Null Aleatorio", 330, 35);
        }

        public int atacarAleatorio() {
            return 25 + (int) (Math.random() * 21); // Golpe entre 25 y 45
        }
    }
}
