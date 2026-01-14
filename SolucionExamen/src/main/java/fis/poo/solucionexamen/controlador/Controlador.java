/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.solucionexamen.controlador;
import fis.poo.solucionexamen.modelo.Asignatura;
import fis.poo.solucionexamen.modelo.Calificacion;
import fis.poo.solucionexamen.modelo.Estudiante;
import fis.poo.solucionexamen.modelo.Modelo;
import fis.poo.solucionexamen.vista.VentanaPrincipal;
import fis.poo.solucionexamen.vista.VentanaAsignaturas;
import fis.poo.solucionexamen.vista.VentanaEstudiantes;
import fis.poo.solucionexamen.vista.VentanaCalificaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Alex
 */
public class Controlador implements ActionListener {
    private VentanaPrincipal ventanaPrincipal;
    private VentanaAsignaturas ventanaAsignaturas;
    private VentanaEstudiantes ventanaEstudiantes;
    private VentanaCalificaciones ventanaCalificaciones;
    private Modelo modelo;

    public Controlador(VentanaPrincipal ventanaPrincipal, VentanaAsignaturas ventanaAsignaturas,
                       VentanaEstudiantes ventanaEstudiantes, VentanaCalificaciones ventanaCalificaciones,
                       Modelo modelo) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaAsignaturas = ventanaAsignaturas;
        this.ventanaEstudiantes = ventanaEstudiantes;
        this.ventanaCalificaciones = ventanaCalificaciones;
        this.modelo = modelo;

        // Asignar el controlador a las vistas
        ventanaPrincipal.setControlador(this);
        ventanaAsignaturas.setControlador(this);
        ventanaEstudiantes.setControlador(this);
        ventanaCalificaciones.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // Navegación desde VentanaPrincipal
        if (e.getSource() == ventanaPrincipal.getBtnAsignaturas()) {
            ventanaPrincipal.setVisible(false);
            ventanaAsignaturas.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnEstudiantes()) {
            ventanaEstudiantes.actualizarAsignaturas(modelo.getAsignaturas());
            ventanaPrincipal.setVisible(false);
            ventanaEstudiantes.setVisible(true);
        } else if (e.getSource() == ventanaPrincipal.getBtnCalificaciones()) {
            ventanaCalificaciones.actualizarAsignaturas(modelo.getAsignaturas());
            ventanaPrincipal.setVisible(false);
            ventanaCalificaciones.setVisible(true);
        }

        
        if (e.getSource() == ventanaAsignaturas.getBtnRegresar() ||
            e.getSource() == ventanaEstudiantes.getBtnRegresar() ||
            e.getSource() == ventanaCalificaciones.getBtnRegresar()) {
            ventanaAsignaturas.setVisible(false);
            ventanaEstudiantes.setVisible(false);
            ventanaCalificaciones.setVisible(false);
            ventanaPrincipal.setVisible(true);
        }

       // Ingresar una asignatura
        if (e.getSource() == ventanaAsignaturas.getBtnAnadirAsignatura()) {
            try {
                String nombre = ventanaAsignaturas.getTxtNombre().getText().trim();
                int creditos = Integer.parseInt(ventanaAsignaturas.getTxtCreditos().getText().trim());
                int semestre = (Integer)ventanaAsignaturas.getCmbSemestre().getSelectedItem();

               
                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(ventanaAsignaturas, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (creditos <= 0) {
                    JOptionPane.showMessageDialog(ventanaAsignaturas, "Los créditos deben ser un número positivo", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Asignatura asignatura = new Asignatura(nombre, creditos, semestre);
                modelo.agregarAsignatura(asignatura);
                ventanaAsignaturas.limpiarCampos();
                JOptionPane.showMessageDialog(ventanaAsignaturas, "Asignatura añadida con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventanaAsignaturas, "Los créditos deben ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Ingresar un estudiante
        if (e.getSource() == ventanaEstudiantes.getBtnIngresarEstudiante()) {
            try {
                String nombre = ventanaEstudiantes.gettxtNombreEstudiante().getText().trim();
                String apellido = ventanaEstudiantes.gettxtApellidoEstudiante().getText().trim();
                String numeroUnico = ventanaEstudiantes.gettxtNuEstudiante().getText().trim();
                Asignatura asignatura = (Asignatura) ventanaEstudiantes.getCmbAsignaturas().getSelectedItem();

                if (nombre.isEmpty() || apellido.isEmpty() || numeroUnico.isEmpty()) {
                    JOptionPane.showMessageDialog(ventanaEstudiantes, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (asignatura == null) {
                    JOptionPane.showMessageDialog(ventanaEstudiantes, "Debe seleccionar una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Estudiante estudiante = new Estudiante(nombre, apellido, numeroUnico, asignatura);
                modelo.agregarEstudiante(estudiante);
                ventanaEstudiantes.actualizarTablaEstudiantes(modelo.getEstudiantes());
                ventanaEstudiantes.limpiarCampos();
                JOptionPane.showMessageDialog(ventanaEstudiantes, "Estudiante añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(ventanaEstudiantes, "Error al añadir estudiante   ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Ingresar una calificacion
        if(e.getSource() == ventanaCalificaciones.getBtnIngresarNota()){
            try{
                String numUnico = ventanaCalificaciones.getTxtNU().getText().trim();
                Asignatura asignatura = (Asignatura)ventanaCalificaciones.getCmbAsignaturas().getSelectedItem();
                String notaUnoS = ventanaCalificaciones.getTxtNotaUno().getText().trim();
                String notaDosS = ventanaCalificaciones.getTxtNotaDos().getText().trim();
                String recuperacionS = ventanaCalificaciones.getTxtRec().getText().trim();
                
                if(numUnico.isEmpty() || notaUnoS.isBlank() || notaDosS.isEmpty() || recuperacionS.isEmpty()){
                    JOptionPane.showMessageDialog(ventanaCalificaciones, "Todos los campos deben estar llenados", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(!modelo.verificarEstudiante(numUnico)){
                    JOptionPane.showMessageDialog(ventanaCalificaciones, "Número único no registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(asignatura == null){
                    JOptionPane.showMessageDialog(ventanaCalificaciones, "Selecciones una asignatura", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                double notaUno = Double.parseDouble(notaUnoS);
                double notaDos = Double.parseDouble(notaDosS);
                double recuperacion = Double.parseDouble(recuperacionS);
                
                if((notaUno < 0 || notaUno > 20) || (notaDos < 0 || notaDos > 20) || (recuperacion < 0 || recuperacion > 20)){
                    JOptionPane.showMessageDialog(ventanaCalificaciones, "Las notas deben ser entre 0 y 20", "Error" , JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Calificacion calificacion = new Calificacion(numUnico, asignatura, notaUno, notaDos, recuperacion);
                modelo.agregarCalificacion(calificacion);
                ventanaCalificaciones.actualizarTablaCal(modelo.getCalificaciones());
                ventanaCalificaciones.limpiarCampos();
                JOptionPane.showMessageDialog(ventanaCalificaciones, "Calificación añadida", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(ventanaCalificaciones, "Las notas deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}   
