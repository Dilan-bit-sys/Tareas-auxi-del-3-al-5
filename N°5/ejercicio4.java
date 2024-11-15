import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface FiltroObjeto {
    boolean filtrar(Objeto objeto);
}

class Objeto {
    private String nombre;
    private double peso;

    public Objeto(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Objeto{" +
               "nombre='" + nombre + '\'' +
               ", peso=" + peso +
               '}';
    }
}

class Inventario {
    private List<Objeto> objetos;

    public Inventario() {
        this.objetos = new ArrayList<>();
    }

    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    public List<Objeto> filtrarObjetos(FiltroObjeto filtro) {
        return objetos.stream().filter(filtro::filtrar).collect(Collectors.toList());
    }
}

public class ejercicio4 {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.agregarObjeto(new Objeto("Espada", 3.5));
        inventario.agregarObjeto(new Objeto("Escudo", 5.0));
        inventario.agregarObjeto(new Objeto("Poción", 0.5));
        inventario.agregarObjeto(new Objeto("Armadura", 10.0));
        inventario.agregarObjeto(new Objeto("Botella Vacía", 0.2));

        System.out.println("Objetos con peso menor a 5:");
        List<Objeto> objetosLivianos = inventario.filtrarObjetos(objeto -> objeto.getPeso() < 5);
        objetosLivianos.forEach(System.out::println);

        System.out.println("\nObjetos cuyo nombre contiene 'o':");
        List<Objeto> objetosConO = inventario.filtrarObjetos(objeto -> objeto.getNombre().toLowerCase().contains("o"));
        objetosConO.forEach(System.out::println);

        System.out.println("\nObjetos con peso mayor o igual a 5:");
        List<Objeto> objetosPesados = inventario.filtrarObjetos(objeto -> objeto.getPeso() >= 5);
        objetosPesados.forEach(System.out::println);
    }
}
