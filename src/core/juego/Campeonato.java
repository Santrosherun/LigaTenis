/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.juego;

import java.util.ArrayList;

/**
 *
 * @author sddva
 */
public class Campeonato {
    private ArrayList<Juego> juegos;

    public Campeonato() {
        this.juegos = new ArrayList<>();
    }
    
    public boolean addJuego(Juego juego){
        if(!juegos.contains(juego)){
            juegos.add(juego);
            return true;
        }
        return false;
    }
    
    public Juego getJuego(int index){
        return juegos.get(index);
    }
    
    public void showResumen(){
        for (Juego juego : this.juegos) {
            System.out.println("Jugador 1: " + juego.getJugador1().getNombre());  
            System.out.println("Jugador 2: " + juego.getJugador2().getNombre());  
            System.out.println("Juez: " + juego.getJuez().getNombre());
            int index = 1;
            for (Set set : juego.getSets()) {
                System.out.println("Set "+index+ ": "+set.getPuntosJugador1() + " - " + set.getPuntosJugador2());
                index++;
            }
            System.out.println("Ganador: " + juego.getWinner().getNombre()+"\n");
            
            System.out.println("El ganador del campeonato es: "+juego.getWinner().getNombre()+"\n");
        }
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }
    
    
}
