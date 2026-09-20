package com.taller.nivel2;

public class CazabugsNivel2 {
    public static void main(String[] args) {
        System.out.println("=== CAZABUGS - NIVEL 2 ===");
        System.out.println("Bug 1 (Linea 12 original): 'public void Arma(...)'. Al tener void, Java lo trata como metodo comun y no como constructor.");
        System.out.println("      Correccion: Eliminar 'void' -> 'public Arma(String nombre, int danio)'.");
        System.out.println("Bug 2 (Linea 13 original): 'nombre = nombre;'. El parametro sombrea al atributo y este queda en null.");
        System.out.println("      Correccion: Usar 'this.nombre = nombre;'.");
        System.out.println("Bug 3 (Linea 21 original): 'private int getDanio()'. Al ser privado, no puede llamarse desde el main.");
        System.out.println("      Correccion: Cambiar a 'public int getDanio()'.");

        Arma espada = new Arma("Espada", 25);
        System.out.println("Salida corregida: " + espada.getNombre() + ": " + espada.getDanio());
    }

    static class Arma {
        private String nombre;
        private int danio;

        public Arma(String nombre, int danio) {
            this.nombre = nombre;
            this.danio = danio;
        }

        public String getNombre() {
            return nombre;
        }

        public int getDanio() {
            return danio;
        }
    }
}
