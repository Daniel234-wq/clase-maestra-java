package com.taller.nivel1;

public class CazabugsNivel1 {
    public static void main(String[] args) {
        System.out.println("=== CAZABUGS - NIVEL 1 ===");
        System.out.println("Bug 1 (Linea 3 original): 'Heroe luna;' no inicializaba el objeto.");
        System.out.println("      Correccion: 'Heroe luna = new Heroe();'");
        System.out.println("Bug 2 (Linea 11 original): 'void saludar()' intentaba retornar un String con 'return'.");
        System.out.println("      Correccion: Cambiar tipo de retorno a 'String saludar()'.");

        Heroe luna = new Heroe();
        luna.nombre = "Luna";
        System.out.println("Salida corregida: " + luna.saludar());
    }

    static class Heroe {
        String nombre;

        String saludar() {
            return "Hola, soy " + nombre;
        }
    }
}
