public class Regulador {
    protected String tipo;
    protected double eficiencia; // Porcentaje de energía que logra transmitir sin pérdida

    public Regulador() {
        this.tipo = "Regulador Central";
        this.eficiencia = 1.0; // 100% sin pérdidas en el regulador base
    }

    public Regulador(String tipo, double eficiencia) {
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    // Método exigido por Main.actualizarEstado()
    public boolean alcanza(int energiaDisponible, int consumo) {
        int energiaReal = (int) (energiaDisponible * eficiencia);
        return energiaReal >= consumo && energiaReal > 0;
    }

    // Sobrecarga de revisar (sin detalle)
    public String revisar(int energiaDisponible, int consumo) {
        int energiaReal = (int) (energiaDisponible * eficiencia);
        if (alcanza(energiaDisponible, consumo)) {
            return "[" + tipo + "] Suministro estable. Sobrante: " + (energiaReal - consumo) + " unidades.";
        } else {
            return "[" + tipo + "] FALLA DE SUMINISTRO. Faltan: " + (consumo - energiaReal) + " unidades.";
        }
    }

    // Método exigido por Main.prenderCiudad(), verFallas() y apagarDispositivos()
    public String revisar(int energiaDisponible, int consumo, boolean detallar) {
        String resumen = revisar(energiaDisponible, consumo);
        if (!detallar) {
            return resumen;
        }
        int energiaReal = (int) (energiaDisponible * eficiencia);
        return resumen + "\n"
                + " - Energia generada: " + energiaDisponible + "\n"
                + " - Energia regulada (" + (int)(eficiencia * 100) + "%): " + energiaReal + "\n"
                + " - Consumo de ciudad: " + consumo;
    }

    public String getTipo() {
        return tipo;
    }
}
