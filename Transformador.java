public class Transformador extends Regulador {
    private int voltajeSalida;

    public Transformador() {
        super("Transformador de Subestacion", 0.95); // 95% de eficiencia
        this.voltajeSalida = 110;
    }

    public Transformador(int voltajeSalida) {
        super("Transformador de Subestacion", 0.95);
        this.voltajeSalida = voltajeSalida;
    }

    public int regularVoltaje(int energiaEntrada) {
        return (int) (energiaEntrada * eficiencia);
    }

    @Override
    public String revisar(int energiaDisponible, int consumo, boolean detallar) {
        String base = super.revisar(energiaDisponible, consumo, detallar);
        if (detallar) {
            return base + "\n - Voltaje estabilizado a: " + voltajeSalida + "V";
        }
        return base;
    }
}
