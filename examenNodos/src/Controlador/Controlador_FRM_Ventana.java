/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodosNodo;
import Vista.FRM_Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Marianghel
 */
public class Controlador_FRM_Ventana implements ActionListener {
    MetodosNodo metodos;
   FRM_Ventana ventana;

    public Controlador_FRM_Ventana(FRM_Ventana ventana) {
       this.ventana=ventana;
        this.metodos = new MetodosNodo();
    }
   
   
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Registrar")){
            System.out.println("registarar");
            ventana.mostrarFecha(metodos.asiganacionFecha());
            ventana.mensaje();
            registrarPrioridad();
            JOptionPane.showMessageDialog(null,"Se registró cliente");
            //imprimir en consola
        }
        if(e.getActionCommand().equals("Siguiente")){
              ventana.setJt_NombreLlamado(metodos.llamarPrimerClienteFila());
                metodos.eliminarPrimerNodo();
        }
        if(e.getActionCommand().equals("Cancelar")){
            metodos.CancelarNodo(ventana.getJt_CancelarCedula());
            JOptionPane.showMessageDialog(null,"Cita cancelada");
        }
        if(e.getActionCommand().equals("Modificar datos")){
            metodos.modificarDatos(ventana.getJt_Cedula(), ventana.getJt_NombreCompleto(), Integer.parseInt(ventana.getJt_Edad()));
           ventana.mostrarFecha(metodos.asiganacionFecha());
           JOptionPane.showMessageDialog(null,"Se modificó los datos");
        }
        if(e.getActionCommand().equals("Cantidad fila")){
            ventana.setArea(metodos.cantidadPersonasCola());
        }
        if(e.getActionCommand().equals("Información")){
             ventana.setArea(metodos.mostrarInformacionCola());
        }
        if(e.getActionCommand().equals("Mayor-menor")){
            metodos.ordenarMayorMenor();
           ventana.setArea(metodos.imprimirTodoNodosOrdenadosArea());
        }
        if(e.getActionCommand().equals("Menor-mayor")){
            metodos.ordenarMenorrMenor();
       ventana.setArea(metodos.imprimirTodoNodosOrdenadosArea());
        }
    }
    public void registrarPrioridad(){
        if(ventana.opcionPrioridad()){
            metodos.crearNodoPrioridad(ventana.getJt_Cedula(), ventana.getJt_NombreCompleto(),Integer.parseInt (ventana.getJt_Edad()),ventana.getJt_Fecha());
        }else{
            metodos.crearNodosNormal(ventana.getJt_Cedula(), ventana.getJt_NombreCompleto(),Integer.parseInt (ventana.getJt_Edad()),ventana.getJt_Fecha());
        }
    }
}
