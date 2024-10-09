/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.personas;

import core.juego.Juego;
import java.util.ArrayList;

/**
 *
 * @author sddva
 */
public class Jugador extends Persona{
    private int sueldo;
    private ArrayList<Juego> juegos;

    public Jugador(String nombre, int sueldo) {
        super(nombre);
        this.sueldo = sueldo;
        this.juegos = new ArrayList<>();
    }
    
    public boolean addJuego(Juego juego){
        if(!juegos.contains(juego)){
            juegos.add(juego);
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }
    
    
}
