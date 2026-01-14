/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.solucionexamen.modelo;

/**
 *
 * @author Alex
 */
public class Asignatura {
    private String nombre;
    private int creditos;
    private int semestre;
    
     public Asignatura(String nombre, int creditos, int semestre) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getSemestre() {
        return semestre;
    }
     
    @Override
    public String toString() {
        return nombre;
    }
}
