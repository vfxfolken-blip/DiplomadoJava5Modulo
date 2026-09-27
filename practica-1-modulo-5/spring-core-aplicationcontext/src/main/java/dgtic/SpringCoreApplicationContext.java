package dgtic;

import dgtic.modelo.Edificio;
import dgtic.modelo.Horario;
import dgtic.modelo.Profesor;
import dgtic.modelo.Salon;
import dgtic.servicio.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Práctica Uno - Módulo 5 (SISAHC-ENP5)
 * Clase para probar los beans:
 * 1. Llama a los beans y despliega sus valores.
 * 2. Cambia sus propiedades.
 * 3. Comprueba el enlace entre beans.
 * 4. Usa el servicio para reasignar salón y profesor.
 * 5. Compara scope singleton vs prototype.
 */
public class SpringCoreApplicationContext {

    public static void main(String[] args) {
        ApplicationContext contexto =
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml",
                        "services.xml"          });

        titulo("0. Beans registrados en el contenedor");
        for (String nombre : contexto.getBeanDefinitionNames()) {
            if (!nombre.startsWith("org.springframework")) {
                System.out.println(" - " + nombre);
            }
        }

        // ---------------------------------------------------------------
        titulo("1. Llamado de los beans y despliegue de sus valores");
        Edificio edificioA = (Edificio) contexto.getBean("edificioA");
        Salon salonA101 = (Salon) contexto.getBean("salonA101");
        Profesor profMate = (Profesor) contexto.getBean("profesorMatematicas");
        Profesor profInfo = (Profesor) contexto.getBean("profesorInformatica");
        Profesor profAmbrosio = (Profesor) contexto.getBean("profesorAmbrosio");
        Profesor profHistoria = (Profesor) contexto.getBean("profesorHistoria");
        Profesor profBiologia = (Profesor) contexto.getBean("profesorBiologia");
        Profesor profEFisica = (Profesor) contexto.getBean("profesorEFisica");
        Horario horario = (Horario) contexto.getBean("horario");

        System.out.println(edificioA);
        System.out.println(salonA101);
        System.out.println(profMate);
        System.out.println(profInfo);
        System.out.println(profAmbrosio);
        System.out.println(profHistoria);
        System.out.println(profBiologia);
        System.out.println(profEFisica);
        System.out.println(horario);

        // ---------------------------------------------------------------
        titulo("2. Cambio de propiedades de los beans");
        edificioA.setNombre("Edificio A (remodelado)");
        edificioA.setNumNiveles(4);
        salonA101.setCapacidad(50);
        salonA101.setEstatus("EN MANTENIMIENTO");
        profMate.setCargaMaxima(35);
        profMate.setDepartamento("Matemáticas y Física");
        horario.setDia("Miércoles");
        horario.setHoraInicio("09:00");
        horario.setHoraFin("10:40");

        System.out.println(edificioA);
        System.out.println(salonA101);
        System.out.println(profMate);
        System.out.println(horario);

        // ---------------------------------------------------------------
        titulo("3. Enlace entre beans (singleton: todos comparten la misma instancia)");
        Salon otraVezSalon = (Salon) contexto.getBean("salonA101");
        System.out.println("salonA101.getEdificio() == edificioA  -> "
                + (salonA101.getEdificio() == edificioA));
        System.out.println("horario.getSalon() == salonA101       -> "
                + (horario.getSalon() == salonA101));
        System.out.println("horario.getProfesor() == profMate     -> "
                + (horario.getProfesor() == profMate));
        System.out.println("getBean(salonA101) otra vez: capacidad = "
                + otraVezSalon.getCapacidad() + " (conserva el cambio)");
        System.out.println("Edificio visto desde el horario: "
                + horario.getSalon().getEdificio().getNombre());

        // ---------------------------------------------------------------
        titulo("4. Servicio: reasignar salón y profesor del horario");
        Servicio ser = (Servicio) contexto.getBean("servicio");
        System.out.println("Salones disponibles:    " + ser.getSalones().keySet());
        System.out.println("Profesores disponibles: " + ser.getProfesores().keySet());
        System.out.println("¿Válido para 48 alumnos? " + ser.esValido(48));

        ser.reasignarSalon("salonB205");
        ser.reasignarProfesor("profesorAmbrosio");
        horario.setAsignatura("1610");
        System.out.println(ser);
        System.out.println("horario.getProfesor() == profAmbrosio -> "
                + (horario.getProfesor() == profAmbrosio));
        System.out.println("¿Válido para 48 alumnos? " + ser.esValido(48)
                + " (B-205 solo tiene " + horario.getSalon().getCapacidad() + " lugares)");
        System.out.println("¿Válido para 28 alumnos? " + ser.esValido(28));

        // ---------------------------------------------------------------
        titulo("5. Scope prototype: cada llamado crea un bean nuevo");
        Profesor nuevo1 = (Profesor) contexto.getBean("profesorNuevo");
        Profesor nuevo2 = (Profesor) contexto.getBean("profesorNuevo");
        nuevo1.setNombreCompleto("Profesor de ejemplo");
        nuevo1.setDepartamento("Química");
        System.out.println("nuevo1 == nuevo2 -> " + (nuevo1 == nuevo2));
        System.out.println("nuevo1: " + nuevo1);
        System.out.println("nuevo2: " + nuevo2 + "  (no se ve afectado)");

        ((ClassPathXmlApplicationContext) contexto).close();
    }

    private static void titulo(String texto) {
        System.out.println();
        System.out.println("==================================================================");
        System.out.println(texto);
        System.out.println("==================================================================");
    }
}
