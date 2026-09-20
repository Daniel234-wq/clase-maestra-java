package com.taller.nivel3;

public class RompecabezasLinaje {
    public static void main(String[] args) {
        System.out.println("=== ROMPECABEZAS DEL LINAJE - NIVEL 3 ===");
        System.out.println("Piezas descartadas (Trampas):");
        System.out.println("  1. 'public void Sanador(...)': Lleva void, por lo que deja de ser constructor.");
        System.out.println("  2. 'class Sanador implements Personaje': Usa 'implements' en lugar de 'extends'.");
        System.out.println("\nOrden de piezas validas ensambladas:");
        System.out.println("  1. class Sanador extends Personaje {");
        System.out.println("  2.   private int hierbas;");
        System.out.println("  3.   public Sanador(String n, int v, int a, int hierbas) {");
        System.out.println("  4.     super(n, v, a);");
        System.out.println("  5.     this.hierbas = hierbas;");
        System.out.println("  6.   }");
        System.out.println("  7.   @Override");
        System.out.println("  8.   public void presentarse() {");
        System.out.println("  9.     super.presentarse();");
        System.out.println(" 10.     System.out.println(\"   Sanador con \" + hierbas);");
        System.out.println(" 11.   }");
        System.out.println(" 12. }");

        System.out.println("\nEjecucion de la clase ensamblada:");
        Sanador mira = new Sanador("Mira", 80, 6, 3);
        mira.presentarse();
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

        public void presentarse() {
            System.out.println(nombre + " | vida " + vida + " | ataque " + ataque);
        }
    }

    static class Sanador extends Personaje {
        private int hierbas;

        public Sanador(String n, int v, int a, int hierbas) {
            super(n, v, a);
            this.hierbas = hierbas;
        }

        @Override
        public void presentarse() {
            super.presentarse();
            System.out.println("   Sanador con " + hierbas);
        }
    }
}
