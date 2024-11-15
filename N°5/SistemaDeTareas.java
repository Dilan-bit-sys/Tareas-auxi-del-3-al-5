import java.util.ArrayList;
import java.util.List;


@FunctionalInterface
interface Tarea {
    void ejecutar();
}

class Aventura {
    private List<Tarea> tareas;

    public Aventura() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void iniciar() {
        System.out.println("Iniciando la aventura...");
        for (Tarea tarea : tareas) {
            tarea.ejecutar();
        }
        System.out.println("¡Aventura completada!");
    }
}

public class SistemaDeTareas {
    public static void main(String[] args) {
        Aventura aventura = new Aventura();

        aventura.agregarTarea(() -> System.out.println("Recolectar materiales."));
        aventura.agregarTarea(() -> System.out.println("Construir una herramienta."));
        aventura.agregarTarea(() -> System.out.println("Derrotar al enemigo final."));
        aventura.agregarTarea(() -> System.out.println("Encontrar un tesoro escondido."));


        aventura.iniciar();
    }
}
