package agregarPaquetes;

public class Paquetes {
    int idPaquete, tiempoEnRuta;
    String nitCliente, destino, localizacion;
    boolean prioridad, estadoPaquete;

    public Paquetes(int idPaquete, int tiempoEnRuta, String nitCliente, String destino, String localizacion, boolean prioridad, boolean estadoPaquete) {
        this.idPaquete = idPaquete;
        this.tiempoEnRuta = tiempoEnRuta;
        this.nitCliente = nitCliente;
        this.destino = destino;
        this.localizacion = localizacion;
        this.prioridad = prioridad;
        this.estadoPaquete = estadoPaquete;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getTiempoEnRuta() {
        return tiempoEnRuta;
    }

    public void setTiempoEnRuta(int tiempoEnRuta) {
        this.tiempoEnRuta = tiempoEnRuta;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isEstadoPaquete() {
        return estadoPaquete;
    }

    public void setEstadoPaquete(boolean estadoPaquete) {
        this.estadoPaquete = estadoPaquete;
    }
    
    
    
}
