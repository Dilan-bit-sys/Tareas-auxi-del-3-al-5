@FunctionalInterface
interface CalculadoraBonificacion {
    int calcular(int puntosBase);
}

class Jugador {
    private String nombre;
    private int puntos;

    public Jugador(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public void aplicarBonificacion(CalculadoraBonificacion calculadora) {
        puntos += calculadora.calcular(puntos);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }
}

public class ejercicio2 {
    public static void main(String[] args) {

        Jugador jugador1 = new Jugador("Alice", 100);
        Jugador jugador2 = new Jugador("Bob", 200);

        CalculadoraBonificacion dobleBonificacion = puntosBase -> puntosBase * 2;
        CalculadoraBonificacion bonoFijo = puntosBase -> 50;

        jugador1.aplicarBonificacion(dobleBonificacion);
        jugador2.aplicarBonificacion(bonoFijo);

        System.out.println(jugador1.getNombre() + " tiene ahora " + jugador1.getPuntos() + " puntos.");
        System.out.println(jugador2.getNombre() + " tiene ahora " + jugador2.getPuntos() + " puntos.");
    }
}
