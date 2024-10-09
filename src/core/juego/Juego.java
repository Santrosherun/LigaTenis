/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.juego;

import core.personas.Juez;
import core.personas.Jugador;
import java.util.ArrayList;

/**
 *
 * @author sddva
 */
public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Juez juez;
    private Juego juegoPrevio1;
    private Juego juegoPrevio2;
    private Juego juegoSiguiente;
    private ArrayList<Set> sets;

    public Juego(Jugador jugador1, Jugador jugador2, Juez juez) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.juez = juez;
        this.juegoPrevio1 = null;
        this.juegoPrevio2 = null;
        this.juegoSiguiente = null;
        this.sets = new ArrayList<>();
        
        this.jugador1.addJuego(this);
        this.jugador2.addJuego(this);
        this.juez.addJuego(this);
    }

    public Juego(Juego juegoPrevio1, Juego juegoPrevio2, Juez juez) {
        this.juez = juez;
        this.juegoPrevio1 = juegoPrevio1;
        this.juegoPrevio2 = juegoPrevio2;
        this.jugador1 = juegoPrevio1.getWinner();
        this.jugador2 = juegoPrevio2.getWinner();
        this.juegoSiguiente = null;
        this.sets = new ArrayList<>();
        this.juegoPrevio1.setJuegoSiguiente(this);
        this.juegoPrevio2.setJuegoSiguiente(this);
        
        this.jugador1.addJuego(this);
        this.jugador2.addJuego(this);
        this.juez.addJuego(this);
    }
    
    public boolean addSets(Set set1, Set set2, Set set3){
        if(!sets.contains(set1)){
            sets.add(set1);
        }
        if(!sets.contains(set2)){
            sets.add(set2);
        }
        if(!sets.contains(set3)){
            sets.add(set3);
            return true;
        }
        return false;
    }
    
    public boolean addSets(Set set1, Set set2){
        if(!sets.contains(set1)){
            sets.add(set1);
        }
        if(!sets.contains(set2)){
            sets.add(set2);
            return true;
        }
        return false;
    }
    
    public Jugador getWinner(){
        Set lastSet = this.sets.get(this.sets.size() - 1);
        if(lastSet.getPuntosJugador1() > lastSet.getPuntosJugador2()){
            return this.jugador1;
        }
        return this.jugador2;
    }
    
    public void setJuegoSiguiente(Juego juegoSiguiente) {
        this.juegoSiguiente = juegoSiguiente;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Juez getJuez() {
        return juez;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }
    
}
