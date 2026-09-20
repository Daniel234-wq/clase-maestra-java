package com.taller.jefefinal;

import java.util.ArrayList;

public class Escuadron {
    private ArrayList<Personaje> miembros = new ArrayList<>();

    public boolean agregar(Personaje p) {
        if (miembros.size() >= Reglas.MAX_MIEMBROS) {
            return false;
        }
        miembros.add(p);
        return true;
    }

    public boolean hayVivos() {
        for (Personaje p : miembros) {
            if (p.estaVivo()) {
                return true;
            }
        }
        return false;
    }

    public Personaje primeroVivo() {
        for (Personaje p : miembros) {
            if (p.estaVivo()) {
                return p;
            }
        }
        return null;
    }

    public int atacarTodos() {
        int total = 0;
        for (Personaje p : miembros) {
            if (p.estaVivo()) {
                total += p.atacar();
            }
        }
        return total;
    }

    public ArrayList<Personaje> getMiembros() {
        return miembros;
    }
}
