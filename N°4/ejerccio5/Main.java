package ejerccio5;
abstract class Carta {
    protected int valor;
    protected String palo;

    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public abstract void jugar();

    public void mostrarCarta() {
        System.out.println("Carta: " + valor + " de " + palo);
    }
}

interface Accionable {
    void realizarAccion();
}

class CartaNormal extends Carta {
    public CartaNormal(int valor, String palo) {
        super(valor, palo);
    }

    @Override
    public void jugar() {
        System.out.println("Se ha jugado una carta normal: " + valor + " de " + palo);
    }
}

class CartaEspecial extends Carta implements Accionable {
    public CartaEspecial(int valor, String palo) {
        super(valor, palo);
    }

    @Override
    public void jugar() {
        System.out.println("Se ha jugado una carta especial: " + valor + " de " + palo);
    }

    @Override
    public void realizarAccion() {
        System.out.println("¡Acción especial de la carta activada!");
    }
}

abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int velocidadMaxima;

    public Vehiculo(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }

    public abstract void acelerar();

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Velocidad Máxima: " + velocidadMaxima + " km/h");
    }
}

interface Turbo {
    void activarTurbo();
}

class Coche extends Vehiculo {
    public Coche(String marca, String modelo, int velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    @Override
    public void acelerar() {
        System.out.println("El coche " + marca + " " + modelo + " está acelerando.");
    }
}

class Moto extends Vehiculo implements Turbo {
    public Moto(String marca, String modelo, int velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    @Override
    public void acelerar() {
        System.out.println("La moto " + marca + " " + modelo + " está acelerando.");
    }

    @Override
    public void activarTurbo() {
        System.out.println("¡La moto " + marca + " " + modelo + " ha activado el turbo!");
    }
}

abstract class Animal {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract void hacerSonido();

    public void mostrarInfo() {
        System.out.println("Animal: " + nombre + ", Edad: " + edad + " años");
    }
}

interface Productor {
    void producir();
}

class Vaca extends Animal implements Productor {
    public Vaca(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Muuu");
    }

    @Override
    public void producir() {
        System.out.println(nombre + " está produciendo leche.");
    }
}

class Oveja extends Animal implements Productor {
    public Oveja(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Beee");
    }

    @Override
    public void producir() {
        System.out.println(nombre + " está produciendo lana.");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Ejercicio 1: Juego de Cartas ===");
        Carta cartaNormal = new CartaNormal(5, "Corazones");
        CartaEspecial cartaEspecial = new CartaEspecial(10, "Diamantes");

        cartaNormal.mostrarCarta();
        cartaNormal.jugar();
        cartaEspecial.mostrarCarta();
        cartaEspecial.jugar();
        cartaEspecial.realizarAccion();

        System.out.println("\n=== Ejercicio 2: Juego de Carreras ===");
        Vehiculo coche = new Coche("Toyota", "Corolla", 180);
        Moto moto = new Moto("Yamaha", "YZF-R6", 240);

        coche.mostrarInfo();
        coche.acelerar();
        moto.mostrarInfo();
        moto.acelerar();
        moto.activarTurbo();

        System.out.println("\n=== Ejercicio 3: Juego de Simulación de Granjas ===");
        Animal vaca = new Vaca("Lola", 5);
        Animal oveja = new Oveja("Dolly", 3);

        vaca.mostrarInfo();
        vaca.hacerSonido();
        ((Productor) vaca).producir();

        oveja.mostrarInfo();
        oveja.hacerSonido();
        ((Productor) oveja).producir();
    }
}
