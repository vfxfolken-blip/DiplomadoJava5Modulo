package dgtic.modelo;

/**
 * Modelo de la entidad "profesor" del DER del SISAHC-ENP5.
 * Catálogo de profesores, su carga máxima y estatus.
 * Bean definido en XML (bean-configuration.xml).
 */
public class Profesor {

    private int idProfesor;
    private String numeroTrabajador;
    private String nombreCompleto;
    private String correoInstitucional;
    private String departamento;
    private int cargaMaxima;
    private String status;

    public Profesor() {
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNumeroTrabajador() {
        return numeroTrabajador;
    }

    public void setNumeroTrabajador(String numeroTrabajador) {
        this.numeroTrabajador = numeroTrabajador;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor=" + idProfesor +
                ", numeroTrabajador='" + numeroTrabajador + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correoInstitucional='" + correoInstitucional + '\'' +
                ", departamento='" + departamento + '\'' +
                ", cargaMaxima=" + cargaMaxima +
                ", status='" + status + '\'' +
                '}';
    }
}
