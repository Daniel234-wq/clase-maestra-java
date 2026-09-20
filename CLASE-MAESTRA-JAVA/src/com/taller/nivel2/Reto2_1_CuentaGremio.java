package com.taller.nivel2;

public class Reto2_1_CuentaGremio {
    public static void main(String[] args) {
        System.out.println("=== RETO 2.1: LA BOVEDA DEL GREMIO ===");
        CuentaGremio cuenta = new CuentaGremio("LosNullPointers");

        cuenta.depositar(500);
        cuenta.depositar(-100);

        boolean retiro1 = cuenta.retirar(800);
        boolean retiro2 = cuenta.retirar(200);

        System.out.println("Retiro de 800 exitoso: " + retiro1);
        System.out.println("Retiro de 200 exitoso: " + retiro2);
        System.out.println("Saldo final: " + cuenta.getSaldo());

        System.out.println("\nPor que no existe setSaldo?");
        System.out.println("Explicacion al docente: 'setSaldo' seria una vulnerabilidad critica en la boveda,");
        System.out.println("ya que permitiria sobrescribir el dinero arbitrariamente desde afuera sin pasar");
        System.out.println("por reglas de validacion, sin registrar movimientos y permitiendo hackear la partida.");
    }

    static class CuentaGremio {
        private String titular;
        private int saldo;

        public CuentaGremio(String titular) {
            this.titular = titular;
            this.saldo = 0;
        }

        public void depositar(int monto) {
            if (monto > 0) {
                saldo = saldo + monto;
            }
        }

        public boolean retirar(int monto) {
            if (monto > 0 && monto <= saldo) {
                saldo = saldo - monto;
                return true;
            }
            return false;
        }

        public int getSaldo() {
            return saldo;
        }

        public String getTitular() {
            return titular;
        }
    }
}
