package ejercicio2;
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

public class Main {
    public static void main(String[] args) {

        Vehiculo coche = new Coche("Toyota", "Corolla", 180);
        Moto moto = new Moto("Yamaha", "YZF-R6", 240);

        coche.mostrarInfo();
        coche.acelerar();

        moto.mostrarInfo();
        moto.acelerar();
        moto.activarTurbo();  
}
 }