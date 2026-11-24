// Herencia: Solar es un tipo de Generador.
public class Solar extends Generador {
    public Solar() {
        this("Solar", 100); // Llama a constructor de la misma clase.
    }

    public Solar(String nombre, int capacidadMaxima) {
        super(nombre, capacidadMaxima); // Llama al constructor del padre.
    }

    @Override
    public int generarEnergia(int luzSolar) {
        if (!encendido || luzSolar <= 0) {
            return 0;
        } else {
            return capacidadMaxima * luzSolar / 100;
        }
    }
}
