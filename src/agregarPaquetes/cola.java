package agregarPaquetes;
import backend.conexion;
import java.sql.*;
import java.util.LinkedList;

public class cola {
    int taman,ingresados;
    int idPaquete, tiempoRuta;
    String destino, nit, localizacion;
    boolean prioridadPaquete, estadoPaquete;
    LinkedList cola = new LinkedList();
    Connection conecta = conexion.conectar();
    
    public cola (int taman){                                                                                        //Metodo para crear colas
        this.taman=taman;
        Paquetes[] paq = new Paquetes[taman];
    }
    
    public void agregarColaNueva(String de,String para){                                                            //Metodo para llenar una cola nueva
        ingresados = 0;                                                                                             //Inicializa los paquetes ingresados en 0
        try{
            String datos = "SELECT * FROM Paquete WHERE Destino ='"+para+
                        "' ORDER BY Prioridad desc, IdPaquete asc";                                                //Datos para añadir a la cola 
            PreparedStatement pst = conecta.prepareStatement(datos);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next() && ingresados<taman){                                                                  //Verifica si el limite del tamaño no es excedido
                idPaquete = rs.getInt("IdPaquete");
                nit = rs.getString("NitCliente");
                destino = rs.getString("Destino");
                prioridadPaquete = rs.getBoolean("Prioridad");
                estadoPaquete = rs.getBoolean("EstadoPaquete");
                localizacion = rs.getString("Localizacion");
                tiempoRuta = rs.getInt("TiempoEnRuta");
                
                Paquetes nuevoPaquete = new Paquetes(idPaquete, tiempoRuta, destino, nit, localizacion, estadoPaquete, prioridadPaquete);   //Se crea el paquete que se añadira a la cola
                datos = "UPDATE Paquete SET localizacion='"+de+"' WHERE IdPaquete="+idPaquete;                     //Cambia la localizacion del paquete
                pst = conecta.prepareStatement(datos);
                pst.executeUpdate();                                                                                //Setea la nueva localizacion del paquete
                cola.add(nuevoPaquete);
                ingresados++;
            }
        }catch(SQLException e){
            System.err.println("Error al agregar cola nueva"+e);
        }
    }
}