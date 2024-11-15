import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface EventoNotificacion {
    void notificar(String mensaje);
}

class Evento {
    private String nombre;
    private List<EventoNotificacion> notificaciones;

    public Evento(String nombre) {
        this.nombre = nombre;
        this.notificaciones = new ArrayList<>();
    }

    public void registrarNotificacion(EventoNotificacion notificacion) {
        notificaciones.add(notificacion);
    }

    public void activar() {
        for (EventoNotificacion notificacion : notificaciones) {
            notificacion.notificar("Evento activado: " + nombre);
        }
    }
}

public class SistemaDeNotificaciones {
    public static void main(String[] args) {
        Evento evento1 = new Evento("Torneo de Batalla");

        evento1.registrarNotificacion(mensaje -> System.out.println("Jugador 1: " + mensaje));
        evento1.registrarNotificacion(mensaje -> System.out.println("Jugador 2: " + mensaje));
        evento1.registrarNotificacion(mensaje -> System.out.println("Administrador: " + mensaje));

        evento1.activar();
    }
}

