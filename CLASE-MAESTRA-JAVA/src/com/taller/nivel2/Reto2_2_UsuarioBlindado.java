package com.taller.nivel2;

public class Reto2_2_UsuarioBlindado {
    public static void main(String[] args) {
        System.out.println("=== RETO 2.2: CONTRASENA BLINDADA ===");
        // Usuario: Cronista ("Mateo"), Clave inicial: nombre gremio en minusculas + numero de integrantes ("losnullpointers4")
        Usuario usuario = new Usuario("Mateo", "losnullpointers4");

        System.out.println("1. Intento de cambio con clave actual incorrecta:");
        boolean cambio1 = usuario.cambiarClave("claveFalsa", "nuevaClave123");
        System.out.println("   Resultado: " + cambio1);

        System.out.println("2. Intento de cambio con clave nueva demasiado corta (< 8 caracteres):");
        boolean cambio2 = usuario.cambiarClave("losnullpointers4", "corta");
        System.out.println("   Resultado: " + cambio2);

        System.out.println("3. Intento de cambio valido (actual correcta y nueva >= 8 caracteres):");
        boolean cambio3 = usuario.cambiarClave("losnullpointers4", "gremioSeguro2026");
        System.out.println("   Resultado: " + cambio3);

        System.out.println("\nVerificacion de contrasena final:");
        System.out.println("   Verificar con antigua ('losnullpointers4'): " + usuario.verificar("losnullpointers4"));
        System.out.println("   Verificar con nueva ('gremioSeguro2026'): " + usuario.verificar("gremioSeguro2026"));
        System.out.println("   Nota de seguridad: No existe getClave(), protegiendo el secreto.");
    }

    static class Usuario {
        private String nombre;
        private String clave;

        public Usuario(String nombre, String clave) {
            this.nombre = nombre;
            this.clave = clave;
        }

        public String getNombre() {
            return nombre;
        }

        public boolean verificar(String intento) {
            return this.clave.equals(intento);
        }

        public boolean cambiarClave(String actual, String nueva) {
            if (verificar(actual) && nueva != null && nueva.length() >= 8) {
                this.clave = nueva;
                return true;
            }
            return false;
        }
    }
}
