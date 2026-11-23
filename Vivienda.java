public class Vivienda extends Ciudad{
        private int clima;

    public Vivienda(int medidor, int clima){
        super(medidor);//Determinar el costo de Voltaje
        this.clima = clima;
    }

    //Aqui ira el metodo que llame al metodo del padre para definir el clima
    
    
    public int getClima(){
        return clima;
    }
}
