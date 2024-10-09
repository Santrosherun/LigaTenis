/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.demas;

import core.juego.Campeonato;
import core.juego.Juego;
import core.juego.Set;
import core.personas.Juez;
import core.personas.Jugador;
import java.util.ArrayList;

/**
 *
 * @author sddva
 */
public class LigaTenis {
    private ArrayList<Campeonato> campeonatos; 
    private ArrayList<Juez> jueces;
    private ArrayList<Jugador> jugadores;

    public LigaTenis() {
        this.campeonatos = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.jueces = new ArrayList<>();
    }   
    
    public boolean addJuez(Juez juez){
        if(!jueces.contains(juez)) {
            jueces.add(juez);
            return true;
        }
        return false;
    }
    
    public boolean addJugador(Jugador jugador){
        if(!jugadores.contains(jugador)) {
            jugadores.add(jugador);
            return true;
        }
        return false;
    }
    
    public boolean addCampeonato(Campeonato campeonato){
        if(!campeonatos.contains(campeonato)) {
            campeonatos.add(campeonato);
            return true;
        }
        return false;
    }
    
    public Juez getJuez(int index) {
        return this.jueces.get(index);
    }
    
    public Jugador getJugador(int index) {
        return this.jugadores.get(index);
    }
    
    public Campeonato getCampeonato(int index) {
        return this.campeonatos.get(index);
    }
    
    public void calcSetsGanadosJugadoresCampeonato(int index){
        ArrayList<Jugador> jugadoresCamp = new ArrayList<>();
        for (Campeonato campeonato : this.campeonatos) {
            int index1 = 0;
            if(index == index1){
                for (Juego juego : campeonato.getJuegos()) {
                    if(!jugadoresCamp.contains(juego.getJugador1())){
                        jugadoresCamp.add(juego.getJugador1());
                    }
                    if(!jugadoresCamp.contains(juego.getJugador2())){
                        jugadoresCamp.add(juego.getJugador2());
                    }
                }
            }else{
                index1++;
            }
        }
        for (Jugador jugador : jugadoresCamp) {
            int setsGanados = 0;
            for (Juego juego : jugador.getJuegos()) {
                for(Set set : juego.getSets()){
                    if(juego.getJugador1() == jugador){
                        if(set.getPuntosJugador1() > set.getPuntosJugador2()){
                            setsGanados++;
                        }
                    }else{
                        if(set.getPuntosJugador1() < set.getPuntosJugador2()){
                            setsGanados++;
                        }
                    }
                }
            }
            System.out.println("El jugador: " + jugador.getNombre() + " gano " + setsGanados + " sets en el campeonato");
        }
    }
}
