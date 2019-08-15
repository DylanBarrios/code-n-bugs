package backend;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class backendUsuarios {
    private String cuiUsuario;
    private String rol;
    private String telefono; 
    private String nombre; 
    private String direccion; 
    private String usuario;
    private Boolean estado;
                    
                    
    public backendUsuarios(String cuiUsuario,String nombre, String rol, String telefono, String direccion, String usuario, Boolean estado){

        this.cuiUsuario = cuiUsuario;
        this.rol = rol;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.usuario = usuario;
        this.estado = estado;
    }

    public String getCuiUsuario() {
        return cuiUsuario;
    }

    public void setCuiUsuario(String cuiUsuario) {
        this.cuiUsuario = cuiUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
