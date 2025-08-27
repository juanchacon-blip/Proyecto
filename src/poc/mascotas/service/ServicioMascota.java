package poc.mascotas.service;

import pocmascotas.model.Mascota;
import java.util.List;        
import java.util.ArrayList;  


import java.io.RandomAccessFile;
import javax.swing.JOptionPane;



public class ServicioMascota {
    //para hacer que la cadena mida 15
    public static final int TAM_CADENA = 15;
    // suma de los bytes del registro (4(int)+17(string)+17+8(booleano)+8(double))
    public static final int TAM_REGISTRO = 47;
    
     public static String formatearCadena(String cadena) {
        int faltan;
        if (cadena != null && !cadena.isEmpty() && cadena.length() > TAM_CADENA) {
            return cadena.substring(0, TAM_CADENA);
        } else {

            faltan = TAM_CADENA - cadena.length();
            return cadena + " ".repeat(faltan);
        }
    }
     
     public static boolean  verificarExistencia(int idBuscar){
         try{
             
             RandomAccessFile file = new RandomAccessFile("data//mascota.dat", "rw");
             file.seek(0);
             
             
             while (file.getFilePointer()<file.length()){
                 file.readUTF();
                 file.readUTF();
                 int idClave = file.readInt();
                 file.readBoolean();
                 file.readDouble();
                 
                 if (idClave == idBuscar){
                     
                     return true;}
                 
             }
         }catch (Exception e){}
         
         return false;
         
     }

    
     public static boolean grabarMascota(Mascota pet) {
        try {
            
        if (verificarExistencia(pet.getId())) {
            JOptionPane.showMessageDialog(null, 
                "Error: El ID " + pet.getId() + " ya existe.\nNo se pueden tener mascotas con ID duplicado.", 
                "ID Duplicado", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        RandomAccessFile file = new RandomAccessFile("data//mascota.dat", "rw");
        file.seek(file.length());
        
        file.writeUTF(formatearCadena(pet.getNombre()));
        file.writeUTF(formatearCadena(pet.getEstado()));
        file.writeInt(pet.getId());
        file.writeBoolean(pet.isEstadoDeVenta());
        file.writeDouble(pet.getPrecio());
        
        file.close();
        System.out.println("Mascota grabada exitosamente");
        return true;
    } catch (Exception ex) {
        System.out.println("Error detallado: " + ex.getMessage());
        ex.printStackTrace();
        return false;
    }

    }
     
     
     
    public static List<Mascota> listarMascotas(){
        String nombre, estado;
        int id;
        boolean estadoDeVenta;
        double precio;
        Mascota mascota = null;
        List<Mascota> mascotas = new ArrayList<>();

        try {
            RandomAccessFile file = new RandomAccessFile("data//mascota.dat", "rw");
            file.seek(0);

            while(file.getFilePointer() < file.length()){
                // Lee los datos en el mismo orden en que se grabaron
                nombre = file.readUTF().trim();
                estado = file.readUTF().trim();
                id = file.readInt();
                estadoDeVenta = file.readBoolean();
                precio = file.readDouble();

                // Crea el objeto Mascota con los valores leídos
                mascota = new Mascota(nombre, estado, id, estadoDeVenta, precio);
                mascotas.add(mascota);
        }
        file.close();
    } catch (Exception ex) {
        System.out.println("Error! " + ex);
    }
    
    return mascotas;
}
    
    
  
     
    
    
    
}
