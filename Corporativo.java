public class Corporativo extends Ciudad {
    public Corporativo() {
        this(30, new Resistencia("Resistencia Industrial", 2, 0.95));
    }

    public Corporativo(int medidor) {
        super(medidor);
    }

    public Corporativo(int medidor, Resistencia resistencia) {
        super(medidor, resistencia);
    }
}
