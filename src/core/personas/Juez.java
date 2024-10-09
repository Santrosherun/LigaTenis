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
public class Juez extends Persona{
    private int edad;
    private ArrayList<Juego> juegos;

    public Juez(String nombre, int edad ) {
        super(nombre);
        this.juegos = new ArrayList<>();
        this.edad = edad;
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
    
}
