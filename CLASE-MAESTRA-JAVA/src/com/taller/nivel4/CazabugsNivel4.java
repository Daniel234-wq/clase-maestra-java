package com.taller.nivel4;

public class CazabugsNivel4 {
    public static void main(String[] args) {
        System.out.println("=== CAZABUGS - NIVEL 4 ===");
        System.out.println("Bug 1 (Linea 6 original): '@Override public int atacar(int bonus)'. Al cambiar los parametros,");
        System.out.println("      es sobrecarga y no sobrescritura; el compilador rechaza el @Override.");
        System.out.println("      Correccion: Cambiar a 'public int atacar()' con @Override o quitar @Override.");
        System.out.println("Bug 2 (Linea 12 original): 'Personaje[] arena = new Personaje[3];' deja arena[2] en null.");
        System.out.println("      Al ejecutar 'p.atacar()', detona NullPointerException.");
        System.out.println("      Correccion: Instanciar arena[2] con un Personaje valido.");
        System.out.println("Bug 3 (Linea 20 original): 'Mago elegido = (Mago) arena[1];' fuerza un cast de un Guerrero a Mago,");
        System.out.println("      detonando ClassCastException en tiempo de ejecucion.");
        System.out.println("      Correccion: Realizar cast sobre arena[0] (que si es Mago) o proteger con instanceof.\n");

        Personaje[] arena = new Personaje[3];
        arena[0] = new Mago("Lira", 70, 12);
        arena[1] = new Guerrero("Brako", 120, 15);
        arena[2] = new Personaje("Aldeano", 30, 2); // Corrección Bug 2

        for (Personaje p : arena) {
            System.out.println(p.getNombre() + ": " + p.atacar());
        }

        // Corrección Bug 3 con validación instanceof
        if (arena[0] instanceof Mago) {
            Mago elegido = (Mago) arena[0];
            elegido.lanzarHechizo();
        }
    }

    static class Personaje {
        protected String nombre;
        protected int vida;
        protected int ataque;

        public Personaje(String nombre, int vida, int ataque) {
            this.nombre = nombre;
            this.vida = vida;
            this.ataque = ataque;
        }

        public String getNombre() {
            return nombre;
        }

        public int atacar() {
            return ataque;
        }
    }

    static class Guerrero extends Personaje {
        public Guerrero(String nombre, int vida, int ataque) {
            super(nombre, vida, ataque);
        }

        @Override
        public int atacar() {
            return ataque + 5;
        }
    }

    static class Mago extends Personaje {
        public Mago(String nombre, int vida, int ataque) {
            super(nombre, vida, ataque);
        }

        // Corrección Bug 1: Sobrescritura correcta
        @Override
        public int atacar() {
            return ataque * 2;
        }

        public void lanzarHechizo() {
            System.out.println(nombre + " lanza un hechizo restaurador!");
        }
    }
}
