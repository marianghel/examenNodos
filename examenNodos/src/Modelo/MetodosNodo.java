/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Marianghel
 */
public class MetodosNodo {
    
   Nodo primero;

    public MetodosNodo() {
        
    }
   public void crearNodoPrioridad(String cedula, String nombreCompleto, int edad, String fecha){
       Nodo nuevoNodo;
       Nodo temporal=primero;
        if(primero==null){
           primero=new Nodo(cedula, nombreCompleto, edad,fecha, null);  
        }else{
            nuevoNodo=new Nodo(cedula, nombreCompleto, edad,fecha, null);
            temporal=nuevoNodo; 
        }
   } 
   public void crearNodosNormal(String cedula, String nombreCompleto, int edad, String fecha){
       Nodo temporal=primero;
       if(primero==null){
         primero=new Nodo(cedula, nombreCompleto, edad,fecha, null);
    }else{
      agregarNodoFinal(cedula, nombreCompleto, edad,fecha);
    } 
   }
    public Nodo devolverUltimoNodo(){
       Nodo temporal=primero;
          while(temporal.getSiguiente()!=null){
         temporal=temporal.getSiguiente();
     }
     return temporal;
    }
     public void agregarNodoFinal(String cedula, String nombreCompleto, int edad, String fecha){
          Nodo temporal=devolverUltimoNodo();
     temporal.setSiguiente(new Nodo(cedula, nombreCompleto, edad,fecha, null));
   }
   public String asiganacionFecha(){
       String fecha="";
      int dia = 1 + (int) (Math.random() * 31);
      int mes= 1 + (int)(Math.random() * 12);
      int año=2017;
      return fecha="La fecha cita: "+dia+"/"+mes+"/"+año;
    }
   public String llamarPrimerClienteFila(){
       String cliente="";
       cliente=""+ primero.getNombreCompleto();
       return cliente;
   } 
      public void eliminarPrimerNodo(){
       if(primero==null){
         llamarPrimerClienteFila();
       }else{
        primero=primero.getSiguiente();
       }
   }  
      public void CancelarNodo(String cedula){
          if(primero.getCedula().equals(cedula)){
              primero=primero.getSiguiente();
          }else{
              Nodo temporal=primero;
              while(temporal!=null){
                   if(temporal.getSiguiente().getCedula().equals(cedula)){
                     temporal=temporal.getSiguiente().getSiguiente();
                   }
              }
          }
      }
      public void modificarDatos(String cedula,String nombre, int edad){
          Nodo temporal=primero;
          while(!temporal.getCedula().equals(cedula)){
              temporal=temporal.getSiguiente();
          }
          temporal.setNombreCompleto(nombre);
          temporal.setEdad(edad);
      }
   public int devolverCantidadNodos()
    {
        int contador=1;
        Nodo auxiliar=primero;
        while(auxiliar.getSiguiente()!=null)
        {
            contador++;
            auxiliar=auxiliar.getSiguiente();
        }
        
        return contador;
    }
   public String cantidadPersonasCola(){
       int cantidad=devolverCantidadNodos();
       String InformePersonas="La cantidad de personas en la cola es :"+cantidad;
       return InformePersonas;
   }
   public void mostrarInformacionCola(){
      Nodo temporal=primero;
      String informacion="Cédula\t\tNombre\t\tEdad\t\tFecha\n";
       while(temporal.getSiguiente()!=null){
           informacion+=temporal.getCedula()+"\t\t"+temporal.getNombreCompleto()+"\t\t"+temporal.getEdad()+"\n";
             temporal=temporal.getSiguiente();
       }
      return informacion;
   }
   
     public String imprimirArea(){
        String jugador="";
        String puntos="";
        String informacion="Nombre\t\t\t\tPuntos\n";
        for(int contador=0; contador<array.size();contador++){
            jugador=arreglo[0]=array.get(contador).getNombre();
            puntos=arreglo[1]=""+array.get(contador).getPuntos();
            informacion+=jugador+"\t\t\t\t"+puntos+"\n";
        }
        return informacion;
    }
}//Fin de la clase

