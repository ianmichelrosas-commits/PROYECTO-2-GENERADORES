public class Vivienda extends Ciudad{
    public Vivienda(int medidor, int clima){
        super(medidor);//Determinar el costo de Voltaje
        this.clima = clima;

    }

    public Vivienda(){
        this(10,new Resistencia("Resistencia residencial", 1,1.0));
    }

    public Vivienda(int medidor){
        super(medidor);
    }
public Vivienda(int medidor, Resistencia resistencia){
        super(medidor,resistencia);
}

}
