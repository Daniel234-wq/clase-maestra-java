package com.taller.nivel2;

public class PracticaPRIMM2 {
    public static void main(String[] args) {
        System.out.println("=== PRACTICA GUIADA PRIMM - NIVEL 2 ===");

        // 1 y 2. Predice y Ejecuta: Atributo privado
        System.out.println("1 y 2. Al intentar 'kira.vida = 9999':");
        System.out.println("   Respuesta: (c) No compila.");
        System.out.println("   Mensaje del compilador: 'vida has private access in Heroe'");

        // 3. Investiga: Constructor por defecto
        System.out.println("3. 'Heroe nadie = new Heroe();' ya no compila porque al definir constructores");
        System.out.println("   personalizados con parametros, Java retira el constructor vacio por defecto.");

        // 4. Modifica: recibirDanio usando setVida
        Heroe kira = new Heroe("Kira", 100);
        kira.setVida(80);
        kira.recibirDanio(200);
        System.out.println("4. kira con vida 80 recibe 200 de danio:");
        System.out.println("   Vida restante: " + kira.getVida() + " (Nunca sera negativa gracias a la validacion en setVida)");

        // Predicciones relámpago
        System.out.println("\n=== PREDICCIONES RELAMPAGO - NIVEL 2 ===");
        // Predicción A
        Cofre c = new Cofre();
        System.out.println("Prediccion A: c.monedas = " + c.monedas + " (Esperado: 100, delegacion this(50) -> 50*2)");

        // Predicción B
        Gema g = new Gema(30);
        System.out.println("Prediccion B: g.valor = " + g.valor + " (Esperado: 0 por sombreado de variable sin 'this.')");

        // Predicción C
        Heroe rin = new Heroe("Rin", 80);
        rin.setVida(rin.getVida() + 100);
        System.out.println("Prediccion C: rin.getVida() = " + rin.getVida() + " (Esperado: 150 por limite superior)");
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

        public void recibirDanio(int danio) {
            setVida(vida - danio);
        }
    }

    static class Cofre {
        int monedas;

        Cofre() {
            this(50);
        }

        Cofre(int monedas) {
            this.monedas = monedas * 2;
        }
    }

    static class Gema {
        int valor;

        Gema(int valor) {
            valor = valor; // Sombra del parámetro
        }
    }
}
