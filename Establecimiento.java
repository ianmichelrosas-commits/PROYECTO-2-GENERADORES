public class Establecimiento extends Ciudad {
    public Establecimiento() {
        this(20, new Resistencia("Resistencia Comercial", 1, 1.0));
    }

    public Establecimiento(int medidor) {
        super(medidor);
    }

    public Establecimiento(int medidor, Resistencia resistencia) {
        super(medidor, resistencia);
    }
}
