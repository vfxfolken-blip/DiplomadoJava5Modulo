package dgtic.modelo;

/**
 * Modelo de la entidad "edificio" del DER del SISAHC-ENP5.
 * Catálogo de edificios de la ENP 5.
 * Bean definido en XML (bean-configuration.xml).
 */
public class Edificio {

    private int idEdificio;
    private String clave;
    private String nombre;
    private int numNiveles;
    private String ubicacion;
    private String status;

    public Edificio() {
    }

    // Constructor usado por <constructor-arg> en el XML
    public Edificio(int idEdificio, String clave, String nombre) {
        this.idEdificio = idEdificio;
        this.clave = clave;
        this.nombre = nombre;
    }

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumNiveles() {
        return numNiveles;
    }

    public void setNumNiveles(int numNiveles) {
        this.numNiveles = numNiveles;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "idEdificio=" + idEdificio +
                ", clave='" + clave + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numNiveles=" + numNiveles +
                ", ubicacion='" + ubicacion + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
