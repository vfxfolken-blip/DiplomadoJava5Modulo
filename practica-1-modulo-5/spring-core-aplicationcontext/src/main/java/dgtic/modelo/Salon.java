package dgtic.modelo;

/**
 * Modelo de la entidad "salon" del DER del SISAHC-ENP5.
 * Relación: un Edificio tiene muchos Salones (1:N) -> Salon tiene un Edificio.
 * Bean definido en XML; el enlace con Edificio se hace con <property ref="...">.
 */
public class Salon {

    private int idSalon;
    private String clave;
    private Edificio edificio;   // FK id_edificio -> asociación con Edificio
    private int nivel;
    private int capacidad;
    private String tipoAula;
    private String estatus;

    public Salon() {
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "idSalon=" + idSalon +
                ", clave='" + clave + '\'' +
                ", nivel=" + nivel +
                ", capacidad=" + capacidad +
                ", tipoAula='" + tipoAula + '\'' +
                ", estatus='" + estatus + '\'' +
                ", edificio=" + (edificio != null ? edificio.getClave() + " - " + edificio.getNombre() : "null") +
                '}';
    }
}
