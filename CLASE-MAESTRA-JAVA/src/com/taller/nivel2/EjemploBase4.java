package com.taller.nivel2;

public class EjemploBase4 {
    public static void main(String[] args) {
        Heroe kira = new Heroe("Kira", 9999);
        System.out.println("Vida inicial clamp (9999 -> 150): " + kira.getVida());

        kira.setVida(-40);
        System.out.println("Vida con danio excesivo (-40 -> 0): " + kira.getVida());

        // La siguiente linea no compila porque 'vida' es private:
        // kira.vida = 9999;
    }

    static class Heroe {
        private String nombre;
        private int vida;

        public Heroe(String nombre, int vida) {
            this.nombre = nombre;
            setVida(vida);
        }

        public String getNombre() {
            return nombre;
        }

        public int getVida() {
            return vida;
        }

        public void setVida(int vida) {
            if (vida < 0) {
                this.vida = 0;
            } else if (vida > 150) {
                this.vida = 150;
            } else {
                this.vida = vida;
            }
        }
    }
}
