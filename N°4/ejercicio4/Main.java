package ejercicio4;
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

    public void pastar() {
        System.out.println(nombre + " está pastando en el campo.");
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
    
    public void saltar() {
        System.out.println(nombre + " está saltando alegremente.");
    }
}

public class Main {
    public static void main(String[] args) {

        Vaca vaca = new Vaca("Lola", 5);
        Oveja oveja = new Oveja("Dolly", 3);

        vaca.mostrarInfo();
        vaca.hacerSonido();
        vaca.producir();  
        vaca.pastar();    

        oveja.mostrarInfo();
        oveja.hacerSonido();
        oveja.producir(); 
        oveja.saltar();   
    }
}
