/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.solucionexamen.modelo;

/**
 *
 * @author Alex
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private String numUnico;
    private Asignatura asignatura;
    
    public Estudiante(String nombre, String apellido, String numUnico, Asignatura asignatura){
        this.nombre = nombre;
        this.apellido = apellido;
        this.numUnico = numUnico;
        this.asignatura = asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumUnico() {
        return numUnico;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }
}
