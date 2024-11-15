public class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosDeVida;
    protected Inventario inventario;

    public Personaje(String nombre, int nivel, int puntosDeVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosDeVida = puntosDeVida;
        this.inventario = new Inventario();
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre + ", Nivel: " + nivel + ", Puntos de Vida: " + puntosDeVida);
    }

    public void recibirDaño(int daño) {
        puntosDeVida -= daño;
        if (puntosDeVida < 0) puntosDeVida = 0;
    }

    public void curar() {
        puntosDeVida += 20;
    }
}

public class Inventario {
    private ArrayList<String> items;

    public Inventario() {
        items = new ArrayList<>();
    }

    public void agregarItem(String item) {
        items.add(item);
    }

    public void mostrarItems() {
        System.out.println("Inventario: " + items);
    }
}
public class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int nivel, int puntosDeVida, int mana) {
        super(nombre, nivel, puntosDeVida);
        this.mana = mana;
    }

    public void lanzarHechizo() {
        System.out.println(nombre + " lanza un hechizo.");
    }
}
public class Arquero extends Personaje {
    private int destreza;

    public Arquero(String nombre, int nivel, int puntosDeVida, int destreza) {
        super(nombre, nivel, puntosDeVida);
        this.destreza = destreza;
    }

    public void dispararFlecha() {
        System.out.println(nombre + " dispara una flecha.");
    }
}
public class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosDeVida, int fuerza) {
        super(nombre, nivel, puntosDeVida);
        this.fuerza = fuerza;
    }

    public void atacar() {
        System.out.println(nombre + " ataca con fuerza.");
    }
}
public class Enemigo {
    protected String nombre;
    protected int puntosDeVida;
    protected int dañoBase;

    public Enemigo(String nombre, int puntosDeVida, int dañoBase) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.dañoBase = dañoBase;
    }

    public int atacar() {
        return dañoBase;
    }

    public void recibirDaño(int daño) {
        puntosDeVida -= daño;
    }

    public boolean estaVivo() {
        return puntosDeVida > 0;
    }
}
public class Zombie extends Enemigo {
    public Zombie(String nombre, int puntosDeVida, int dañoBase) {
        super(nombre, puntosDeVida, dañoBase);
    }

    @Override
    public int atacar() {
        puntosDeVida += 5; 
        return dañoBase;
    }
}
public class Vampiro extends Enemigo {
    public Vampiro(String nombre, int puntosDeVida, int dañoBase) {
        super(nombre, puntosDeVida, dañoBase);
    }

    @Override
    public int atacar() {
        int daño = dañoBase;
        puntosDeVida += daño / 2; 
        return daño;
    }
}
public class Jefe extends Enemigo {
    private double multiplicadorDaño;

    public Jefe(String nombre, int puntosDeVida, int dañoBase, double multiplicadorDaño) {
        super(nombre, puntosDeVida, dañoBase);
        this.multiplicadorDaño = multiplicadorDaño;
    }

    public void hablar() {
        System.out.println(nombre + " dice: ¡No saldrás vivo de aquí!");
    }

    public int ataqueCritico() {
        return (int) (dañoBase * multiplicadorDaño);
    }
}
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        Mago mago = new Mago("Gandalf", rand.nextInt(10) + 1, 100, 50);
        Guerrero guerrero = new Guerrero("Conan", rand.nextInt(10) + 1, 100, 70);

        System.out.println("¡Comienza el combate!");

        while (mago.puntosDeVida > 0 && guerrero.puntosDeVida > 0) {
            int dañoMago = rand.nextInt(11) + 10;
            int dañoGuerrero = rand.nextInt(11) + 10;

            mago.lanzarHechizo();
            guerrero.recibirDaño(dañoMago);
            guerrero.mostrarEstado();

            if (guerrero.puntosDeVida <= 0) {
                System.out.println("¡El mago ha ganado el combate!");
                break;
            }

            guerrero.atacar();
            mago.recibirDaño(dañoGuerrero);
            mago.mostrarEstado();

            if (mago.puntosDeVida <= 0) {
                System.out.println("¡El guerrero ha ganado el combate!");
                break;
            }
        }

        System.out.println("El combate ha terminado.");
    }
}
