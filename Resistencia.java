public class Resistencia {
    protected String tipo;
    protected int toleranciaHumedad; // 0 = baja, 1 = media, 2 = alta (soporta lluvia)
    protected double factorConsumo;  // Multiplicador de consumo (ej. 1.0 = normal, 1.1 = con ajuste)

    public Resistencia() {
        this("Resistencia Basica", 0, 1.10);
    }

    public Resistencia(String tipo, int toleranciaHumedad) {
        this(tipo, toleranciaHumedad, toleranciaHumedad >= 2 ? 1.0 : 1.10);
    }

    public Resistencia(String tipo, int toleranciaHumedad, double factorConsumo) {
        this.tipo = tipo;
        this.toleranciaHumedad = toleranciaHumedad;
        this.factorConsumo = factorConsumo;
    }

    // Verifica si la resistencia soporta el clima actual (0=calor, 1=viento, 2=lluvia/humedad)
    public boolean soportaClima(int clima) {
        if (clima == 2) { // Lluvia / alta humedad
            return toleranciaHumedad >= 2;
        }
        if (clima == 0) { // Calor
            return toleranciaHumedad >= 1;
        }
        return true; // Viento
    }

    public double getFactorConsumo() {
        return factorConsumo;
    }

    public String getTipo() {
        return tipo;
    }

    public String mostrarInfo() {
        return tipo + " (tolerancia humedad: " + toleranciaHumedad + ")";
    }
}
