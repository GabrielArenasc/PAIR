/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

import java.util.ArrayList;
import view.solicitud;
import view.solicitud2;

/**
 *
 * @author FLIA ARENAS CARMONA
 */
public class Pair<T, U> {
    
    private T first;
    private U second;
    static ArrayList<String> datos = new ArrayList<>();

    // Constructor que recibe dos argumentos
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
    
    static solicitud nomdad = new solicitud();
    static solicitud2 rest = new solicitud2();

    public static void main(String[] args) {
        
        nomdad.setVisible(true);
    }
    
    public static void Segunda() {
        rest.setVisible(true);
        nomdad.setVisible(false);
    }
    
    public static void UNION(String x) {
        Pair.datos.add(x);
    }
    
    public static ArrayList<String> getDatos() {
        return datos;
    }
    
}