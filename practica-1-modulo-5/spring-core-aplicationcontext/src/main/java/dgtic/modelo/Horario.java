package dgtic.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Modelo de la entidad central "horario" del DER del SISAHC-ENP5.
 * Asigna profesor + salón a una clase (asignatura, grupo, día y hora).
 *
 * Relaciones (1:N en el DER):
 *   - Un Profesor imparte muchos Horarios  -> Horario tiene un Profesor
 *   - Un Salón alberga muchos Horarios     -> Horario tiene un Salon
 *
 * Este bean se configura con ANOTACIONES:
 *   @Component  -> Spring lo detecta con <context:component-scan> (services.xml)
 *   @Value      -> inyecta los valores simples
 *   @Autowired + @Qualifier -> enlaza los beans Salon y Profesor definidos en XML
 *
 * Simplificación: asignatura, grupo y bloque horario (día/hora) se manejan como
 * atributos simples, ya que la práctica pide cuatro clases modelo.
 */
@Component("horario")
public class Horario {

    @Value("1")
    private int idHorario;

    @Value("1501")
    private String asignatura;      // clave de la asignatura (id_asignatura)

    @Value("401")
    private String grupo;           // clave del grupo (id_grupo)

    @Value("Lunes")
    private String dia;             // bloque_horario.dia

    @Value("07:00")
    private String horaInicio;      // bloque_horario.horario_inicio

    @Value("08:40")
    private String horaFin;         // bloque_horario.horario_fin

    @Value("VALIDADO")
    private String estatus;

    private Salon salon;
    private Profesor profesor;

    public Horario() {
    }

    // ---- Enlaces con beans definidos en XML (inyección por anotaciones) ----

    public Salon getSalon() {
        return salon;
    }

    @Autowired
    public void setSalon(@Qualifier("salonA101") Salon salon) {
        this.salon = salon;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    @Autowired
    public void setProfesor(@Qualifier("profesorMatematicas") Profesor profesor) {
        this.profesor = profesor;
    }

    // ---- Propiedades simples ----

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "idHorario=" + idHorario +
                ", asignatura='" + asignatura + '\'' +
                ", grupo='" + grupo + '\'' +
                ", dia='" + dia + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", estatus='" + estatus + '\'' +
                ",\n    salon=" + salon +
                ",\n    profesor=" + profesor +
                '}';
    }
}
