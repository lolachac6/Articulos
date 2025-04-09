/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea8;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.Db4oIOException;


/**
 *
 * @author lolachaconcarrion
 */
public class DbHandler {
    
    private String urlDB = "/Users/lolachaconcarrion/Desktop/Tarea8.yap";
    
    
  public  ObjectContainer crearBD(){
     
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), urlDB);
          return db; 
  }
  
  
  public  String insertar(Articulos art){
      try{
        Articulos insertarArticulo = new Articulos(art.getCodigo(),null,null,null);
        ObjectContainer db = crearBD();
        ObjectSet<Articulos> resultado = db.queryByExample(insertarArticulo);
        if(resultado.isEmpty()){
            db.store(art);
            db.close();
            return "Producto insertado con éxito";
        }else{
            db.close();
            return "Producto no se puede insertar ya está insertado en la base de datos";
        }  
      }catch(DatabaseClosedException | Db4oIOException ex){
          return ex.getMessage();
      }
      
      
  }
  
  public Articulos buscar(String codigo){
      try{
            Articulos artObjeto = new Articulos(codigo, null,null,null);
            ObjectContainer db = crearBD();
            ObjectSet<Articulos> resultado = db.queryByExample(artObjeto);
            if(resultado.isEmpty()){
                db.close();
                return null;
            }else{
                Articulos artEncontrado = resultado.next();
                db.close();
                return artEncontrado; 
            }
            
        }catch(DatabaseClosedException | Db4oIOException ex){
          System.out.println(ex.getMessage());
            return null; 
        }
       
  }
  
  public String encabezado(){
      StringBuilder mostrarPantalla = new StringBuilder();
            mostrarPantalla.append("LISTADO DE PRODUCTOS\n");
            mostrarPantalla.append("---------------------\n");
            mostrarPantalla.append(String.format("%-10s %-15s %-15s %-10s\n","Código", "Nombre", "Cantidad", "Descripción"));
            mostrarPantalla.append("------------------------------------------------------\n");
            return mostrarPantalla.toString();
  }
  
  public String mostrar(){
      try{
            String resultadoCabecera = encabezado();
            StringBuilder mostrarPantalla = new StringBuilder(resultadoCabecera);
            Articulos artObjeto = new Articulos();
            ObjectContainer db = crearBD();
            ObjectSet<Articulos> resultado = db.queryByExample(artObjeto);
            
                for(Articulos art: resultado){
                mostrarPantalla.append(String.format("%-10s %-15s %-15s %-10s\n",
                        art.getCodigo(),
                        art.getNombre(),
                        art.getCantidad(),
                        art.getDescripcion()));   
                }
            
            db.close();
            return mostrarPantalla.toString();
        }catch(DatabaseClosedException | Db4oIOException ex){
              System.out.println(ex.getMessage());
              return null;
       
        }
  
  }
  
  public String borrar(String codigo){
      try{
          ObjectContainer db = crearBD();
          Articulos art = new Articulos (codigo,null,null,null);
          ObjectSet<Articulos> resultado = db.queryByExample(art);
          if(resultado.isEmpty()){
            db.close();
            return "Producto no borrado";
          }else{
            Articulos artBorrar = resultado.next();
            db.delete(artBorrar);
            db.close(); 
            return "Producto borrado con éxito";
          }
        }catch(DatabaseClosedException | Db4oIOException ex){
            return ex.getMessage();
        } 
      
      
  }
  
 
  
 public String modificar(String codigo, String nombre, String cantidad, String descripcion){
       ObjectContainer db = crearBD();
       Articulos art = new Articulos (codigo,null,null,null);
       ObjectSet<Articulos> resultado = db.queryByExample(art); //aqui lo busca en la bbdd 
       if(resultado.isEmpty()){
           db.close();
           return "no existe producto";
       }else{
           Articulos nuevoArt = resultado.next();
            nuevoArt.setNombre(nombre);
            nuevoArt.setCantidad(cantidad);
            nuevoArt.setDescripcion(descripcion);
            db.store(nuevoArt);
            db.close();
            return "Producto modificado con éxito";  
       }
       
 }
 
 public String buscadorEspecial(String codigo){
     try{
        String resultadoCabecera = encabezado();
     StringBuilder mostrarPantalla = new StringBuilder(resultadoCabecera);
     Articulos art = new Articulos (null,null,null,null);
     ObjectContainer db = crearBD();
     ObjectSet<Articulos> resultado = db.queryByExample(art);
     for(Articulos artBuscador: resultado){
         if(artBuscador.getCodigo().contains(codigo) && !artBuscador.getCodigo().isEmpty()){
             mostrarPantalla.append(String.format("%-10s %-15s %-15s %-10s\n",
                        artBuscador.getCodigo(),
                        artBuscador.getNombre(),
                        artBuscador.getCantidad(),
                        artBuscador.getDescripcion()));   
         }
         
         
     }
     db.close();
     return mostrarPantalla.toString(); 
     }catch(DatabaseClosedException | Db4oIOException ex){
         return ex.getMessage();
     }
     
     
 }
  
  

  
  
}
