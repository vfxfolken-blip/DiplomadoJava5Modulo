package dgtic.servicio;

import dgtic.modelo.Horario;
import dgtic.modelo.Profesor;
import dgtic.modelo.Salon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Servicio configurado con anotaciones (@Service + @Autowired).
 * Recibe el bean Horario y todos los beans Salon y Profesor del contenedor,
 * y permite reasignar el salón o el profesor de un horario.
 */
@Service("servicio")
public class Servicio {

    private final Horario horario;
    private final Map<String, Salon> salones;       // todos los beans Salon (clave = id del bean)
    private final Map<String, Profesor> profesores; // todos los beans Profesor

    // Inyección por constructor
    @Autowired
    public Servicio(Horario horario,
                           Map<String, Salon> salones,
                           Map<String, Profesor> profesores) {
        this.horario = horario;
        this.salones = salones;
        this.profesores = profesores;
    }

    public Horario getHorario() {
        return horario;
    }

    public Map<String, Salon> getSalones() {
        return salones;
    }

    public Map<String, Profesor> getProfesores() {
        return profesores;
    }

    /** Cambia el salón del horario por otro bean Salon, buscándolo por su id. */
    public void reasignarSalon(String idBeanSalon) {
        Salon nuevo = salones.get(idBeanSalon);
        if (nuevo == null) {
            throw new IllegalArgumentException("No existe el bean Salon: " + idBeanSalon);
        }
        horario.setSalon(nuevo);
    }

    /** Cambia el profesor del horario por otro bean Profesor, buscándolo por su id. */
    public void reasignarProfesor(String idBeanProfesor) {
        Profesor nuevo = profesores.get(idBeanProfesor);
        if (nuevo == null) {
            throw new IllegalArgumentException("No existe el bean Profesor: " + idBeanProfesor);
        }
        horario.setProfesor(nuevo);
    }

    /** Valida que el salón tenga capacidad y el profesor esté activo. */
    public boolean esValido(int alumnosDelGrupo) {
        return horario.getSalon().getCapacidad() >= alumnosDelGrupo
                && "ACTIVO".equals(horario.getProfesor().getStatus());
    }

    @Override
    public String toString() {
        return "Servicio{\n  " + horario + "\n}";
    }
}
