package com.taller.nivel3;

public class Reto3_2_DiagramaUML {
    public static void main(String[] args) {
        System.out.println("=== RETO 3.2: EL ARBOL DEL GREMIO EN UML ===");
        System.out.println("Simbolos de visibilidad:");
        System.out.println("  '+' Publico");
        System.out.println("  '-' Privado");
        System.out.println("  '#' Protegido");
        System.out.println("  '^' o '--|>' Flecha de herencia apuntando al padre con triangulo vacio\n");

        System.out.println("                +-----------------------------+");
        System.out.println("                |          Personaje          |");
        System.out.println("                +-----------------------------+");
        System.out.println("                | # nombre : String           |");
        System.out.println("                | # vida   : int              |");
        System.out.println("                | # ataque : int              |");
        System.out.println("                +-----------------------------+");
        System.out.println("                | + Personaje(String,int,int) |");
        System.out.println("                | + presentarse() : void      |");
        System.out.println("                +-----------------------------+");
        System.out.println("                               ^");
        System.out.println("                               |");
        System.out.println("             +-----------------+-----------------+");
        System.out.println("             |                                   |");
        System.out.println("   +--------------------+             +--------------------+");
        System.out.println("   |      Guerrero      |             |        Mago        |");
        System.out.println("   +--------------------+             +--------------------+");
        System.out.println("   | - armadura : int   |             | - mana : int       |");
        System.out.println("   +--------------------+             +--------------------+");
        System.out.println("   | + Guerrero(...)    |             | + Mago(...)        |");
        System.out.println("   | + defender() : void|             | + lanzarHechizo()  |");
        System.out.println("   | + presentarse()    |             | + presentarse()    |");
        System.out.println("   +--------------------+             +--------------------+");
        System.out.println("             |");
        System.out.println("             |                        +--------------------+");
        System.out.println("             +----------------------> |      Arquero       |");
        System.out.println("                                      +--------------------+");
        System.out.println("                                      | - flechas : int    |");
        System.out.println("                                      +--------------------+");
        System.out.println("                                      | + Arquero(...)     |");
        System.out.println("                                      | + disparar() : void|");
        System.out.println("                                      | + presentarse()    |");
        System.out.println("                                      +--------------------+");
    }
}
