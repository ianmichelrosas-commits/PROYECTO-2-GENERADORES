
public class Ciudad {

    protected int medidor;
    protected int calor;
    protected int viento;
    protected int lluvia;

    Ciudad(int medidor) {
        this.medidor = medidor;
        this.calor = 0;
        this.viento = 1;
        this.lluvia = 2;
    }

    public int getMedidor() {
        return medidor;
    }

    public void definirClima() {
        System.out.println(
            "Se presenta clima en el lugar.."
        );
    }
}
