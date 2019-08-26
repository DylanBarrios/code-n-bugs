package agregarPaquetes;

public class Paquetes {
    int idPaquete, tiempoEnRuta;
    String nitCliente, destino, localizacion;
    boolean prioridad, estadoPaquete;

    //Contructor del metodo que me servira al crear colas para manipular paquetes de la base de datos
    public Paquetes(int idPaquete, int tiempoEnRuta, String nitCliente, String destino, String localizacion, boolean prioridad, boolean estadoPaquete) {
        this.idPaquete = idPaquete;
        this.tiempoEnRuta = tiempoEnRuta;
        this.nitCliente = nitCliente;
        this.destino = destino;
        this.localizacion = localizacion;
        this.prioridad = prioridad;
        this.estadoPaquete = estadoPaquete;
    }
}
