/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Planta;

/**
 *
 * @author mvlop
 */
public class Phones {
    public int id = 0;
    public int level = 0;
    public int counter = 0;
    public int trophies = 0;
    public int plant = 0;
    
    public Phones (int id, int level, int trophies, int plant){
        this.id = id;
        this.level = level;
        this.counter = 0;
        this.trophies = trophies;
        this.plant = plant;
    }
    
    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    
    public void sumCounter() {
        this.counter++;
    }
    
    public void resetCounter() {
        this.counter = 1;
    }
    
    
}
