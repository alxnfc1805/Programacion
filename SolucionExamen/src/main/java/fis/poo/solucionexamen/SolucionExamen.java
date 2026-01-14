/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fis.poo.solucionexamen;
import fis.poo.solucionexamen.controlador.Controlador;
import fis.poo.solucionexamen.modelo.Modelo;
import fis.poo.solucionexamen.vista.VentanaPrincipal;
import fis.poo.solucionexamen.vista.VentanaAsignaturas;
import fis.poo.solucionexamen.vista.VentanaEstudiantes;
import fis.poo.solucionexamen.vista.VentanaCalificaciones;
/**
 *
 * @author Alex
 */
public class SolucionExamen {

    public static void main(String[] args) {
        
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        VentanaAsignaturas ventanaAsignaturas = new VentanaAsignaturas();
        VentanaEstudiantes ventanaEstudiantes = new VentanaEstudiantes();
        VentanaCalificaciones ventanaCalificaciones = new VentanaCalificaciones();
        Modelo modelo = new Modelo();
        
        Controlador controlador = new Controlador(ventanaPrincipal, ventanaAsignaturas, ventanaEstudiantes, ventanaCalificaciones, modelo);

        // Mostrar la ventana principal
        ventanaPrincipal.setVisible(true);
    }
}
