// Clase padre abstracta: define lo que todos los generadores comparten.
public abstract class Generador {
    protected String nombre;
    protected int capacidadMaxima; // Capacidad en unidades simuladas de energia
    protected boolean encendido;

    // Sobrecarga de constructores y llamada a otro constructor con this()
    public Generador() {
        this("Generador", 100);
    }

    public Generador(String nombre) {
        this(nombre, 100);
    }

    public Generador(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.encendido = false;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean estaEncendido() {
        return encendido;
    }

    // Cada tipo de generador debe calcular la energia a su manera.
    public abstract int generarEnergia(int recurso);

    // Sobrecarga de metodos (mismo nombre, distintos parametros).
    public String mostrarDatos() {
        return mostrarDatos(false);
    }

    public String mostrarDatos(boolean detallado) {
        String texto = "Generador: " + nombre;
        if (detallado) {
            texto += "\nCapacidad maxima: " + capacidadMaxima;
            texto += "\nEstado: " + (encendido ? "Encendido" : "Apagado");
        }
        return texto;
    }
}
