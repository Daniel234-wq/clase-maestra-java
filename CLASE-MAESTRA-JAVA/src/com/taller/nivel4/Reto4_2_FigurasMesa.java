package com.taller.nivel4;

public class Reto4_2_FigurasMesa {
    public static void main(String[] args) {
        System.out.println("=== RETO 4.2: FIGURAS DE TU MESA ===");
        System.out.println("Medidas reales registradas en la mesa:");
        System.out.println("  1. Tapa de termo (Circular): Radio = 4.0 cm");
        System.out.println("  2. Celular del Cronista (Rectangular): Base = 14.0 cm, Altura = 7.0 cm");
        System.out.println("  3. Escuadra de dibujo (Triangular): Base = 8.0 cm, Altura = 6.0 cm\n");

        Figura[] figuras = {
            new Circulo(4.0),
            new Rectangulo(14.0, 7.0),
            new Triangulo(8.0, 6.0)
        };

        double areaTotal = 0.0;
        int index = 1;
        for (Figura f : figuras) {
            double a = f.area();
            System.out.printf("Figura %d [%s]: Area = %.2f cm2\n", index++, f.getClass().getSimpleName(), a);
            areaTotal += a;
        }

        System.out.printf("\nArea total acumulada (recorrido en un solo bucle): %.2f cm2\n", areaTotal);
    }

    static class Figura {
        public double area() {
            return 0.0;
        }
    }

    static class Circulo extends Figura {
        private double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public double area() {
            return Math.PI * radio * radio;
        }
    }

    static class Rectangulo extends Figura {
        private double base;
        private double altura;

        public Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double area() {
            return base * altura;
        }
    }

    static class Triangulo extends Figura {
        private double base;
        private double altura;

        public Triangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double area() {
            return (base * altura) / 2.0;
        }
    }
}
