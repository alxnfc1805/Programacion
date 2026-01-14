/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.solucionexamen.modelo;

/**
 *
 * @author Alex
 */
public class Calificacion {
    private String numUnico;
    private Asignatura asignatura;
    private double notaUno;
    private double notaDos;
    private double recuperacion;
    private String aprobado;
    
    public Calificacion(String numeroUnico, Asignatura asignatura, double notaUno, double notaDos, double recuperacion) {
        this.numUnico = numeroUnico;
        this.asignatura = asignatura;
        this.notaUno = notaUno;
        this.notaDos = notaDos;
        this.recuperacion = recuperacion;
        this.aprobado = calcularAprobado();
    }
    
    private String calcularAprobado(){
        double promedio;
        promedio = (notaUno + notaDos) / 2;
        if(promedio >= 14.0){
            return "Aprobado";
        }else if(promedio >= 9.0 && recuperacion >= 15){
            return "Aprobado en recuperacion";
        }else{
            return "Reprobado";
        }
    }

    public String getNumUnico() {
        return numUnico;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public double getNotaUno() {
        return notaUno;
    }

    public double getNotaDos() {
        return notaDos;
    }

    public double getRecuperacion() {
        return recuperacion;
    }

    public String getAprobado() {
        return aprobado;
    }
}
