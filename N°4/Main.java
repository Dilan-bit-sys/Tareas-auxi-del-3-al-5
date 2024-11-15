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

public class Main {
    public static void main(String[] args) {
  
        Carta cartaNormal = new CartaNormal(5, "Corazones");
        CartaEspecial cartaEspecial = new CartaEspecial(10, "Diamantes");

        cartaNormal.mostrarCarta();
        cartaNormal.jugar();

        cartaEspecial.mostrarCarta();
        cartaEspecial.jugar();
        cartaEspecial.realizarAccion();  
    }
}
