package com.taller.nivel1;

public class EjemploBase1 {
    public static void main(String[] args) {
        Heroe kira = new Heroe();
        kira.nombre = "Kira";
        kira.vida = 100;
        kira.ataque = 12;

        Heroe taro = new Heroe();
        taro.nombre = "Taro";
        taro.vida = 80;
        taro.ataque = 18;

        kira.saludar();
        taro.saludar();
    }

    static class Heroe {
        String nombre;
        int vida;
        int ataque;

        void saludar() {
            System.out.println("Soy " + nombre + ", vida " + vida);
        }
    }
}
