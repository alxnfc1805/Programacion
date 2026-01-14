/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.solucionexamen.modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Modelo {
    private List<Estudiante> estudiantes;
    private List<Asignatura> asignaturas;
    private List<Calificacion> calificaciones;
    
    public Modelo(){
        asignaturas = new ArrayList<>();
        estudiantes = new ArrayList<>();
        calificaciones = new ArrayList<>();
    }
    
    public void agregarAsignatura(Asignatura asignatura){
        asignaturas.add(asignatura);
    }
    
    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }
    
    public void agregarCalificacion(Calificacion calificacion){
        calificaciones.add(calificacion);
    }
    
    public List<Asignatura> getAsignaturas(){
        return asignaturas;
    }
    
    public List<Estudiante> getEstudiantes(){
        return estudiantes;
    }
    
    public List<Calificacion> getCalificaciones(){
        return calificaciones;
    }
    
    public boolean verificarEstudiante(String numUnico){
        return estudiantes.stream().anyMatch(e -> e.getNumUnico().equals(numUnico));    
    }
            
}
