public class Hidroelectrico extends Generador {
    public Hidroelectrico() {
        this("Hidroelectrico", 150);
    }

    public Hidroelectrico(String nombre, int capacidadMaxima) {
        super(nombre, capacidadMaxima);
    }

    @Override
    public int generarEnergia(int agua) {
        // Regla simplificada: necesita al menos 30% de agua.
        if (!encendido || agua < 30) {
            return 0;
        } else {
            return capacidadMaxima * agua / 100;
        }
    }
}
