import javax.swing.JOptionPane;

public class Ciudad {
    protected int medidor;
    protected int clima;
    protected Resistencia resistencia;

    protected static final int CALOR = 0;
    protected static final int VIENTO = 1;
    protected static final int LLUVIA = 2;

    public Ciudad(int medidor) {
        this.medidor = medidor;
        this.clima = CALOR;
        this.resistencia = new Resistencia();
    }

    public Ciudad(int medidor, Resistencia resistencia) {
        this.medidor = medidor;
        this.clima = CALOR;
        this.resistencia = (resistencia != null) ? resistencia : new Resistencia();
    }

    public void definirClima() {
        clima = (int) (Math.random() * 3); // 0, 1 o 2
        if (clima == CALOR) {
            JOptionPane.showMessageDialog(null, "El clima predominante es el calor.");
        } else if (clima == VIENTO) {
            JOptionPane.showMessageDialog(null, "El clima predominante es el viento.");
        } else {
            JOptionPane.showMessageDialog(null, "El clima predominante es la lluvia.");
        }
    }

    public int getClima() {
        return clima;
    }

    public Resistencia getResistencia() {
        return resistencia;
    }

    public void setResistencia(Resistencia resistencia) {
        if (resistencia != null) {
            this.resistencia = resistencia;
        }
    }

    public boolean tieneFallaPorClima() {
        return resistencia == null || !resistencia.soportaClima(clima);
    }

    // Consumo efectivo ajustado por clima y resistencia
    public int getMedidor() {
        double ajusteClima = 1.0;
        if (clima == CALOR) {
            ajusteClima = 1.20; // +20% por aire acondicionado/ventilacion
        } else if (clima == LLUVIA) {
            ajusteClima = 1.15; // +15% por humedad y perdidas en linea
        }
        double factorRes = (resistencia != null) ? resistencia.getFactorConsumo() : 1.0;
        return Math.max(1, (int) Math.round(medidor * ajusteClima * factorRes));
    }
}
