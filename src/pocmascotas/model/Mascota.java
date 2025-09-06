package pocmascotas.model;


public class Mascota {
    
    private int documentoMascota;
    private String estado, nombre;
    private boolean estadoDeVenta;
    private double precio;
    
    //CONTRUCTOR

    public Mascota(String nombre, String estado, int id , boolean estadoDeVenta, double precio) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.estadoDeVenta = estadoDeVenta;
        this.precio = precio;
    }
    
    //GETERS Y SETTERS


        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstadoDeVenta() {
        return estadoDeVenta;
    }

    public void setEstadoDeVenta(boolean estadoDeVenta) {
        this.estadoDeVenta = estadoDeVenta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}


