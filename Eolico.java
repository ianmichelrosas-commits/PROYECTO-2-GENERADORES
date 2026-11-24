
public class Eolico extends Generador {

    public Eolico() {
        this("Eolico", 120);
    }

    public Eolico(String nombre, int capacidadMaxima) {
        super(nombre, capacidadMaxima);
    }

    @Override
    public int generarEnergia(int viento) {

        // Necesita al menos 20% de viento
        if (!encendido || viento < 20) {
            return 0;
        } else {
            return capacidadMaxima * viento / 100;
        }
    }
}
