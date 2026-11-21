public class Ciudad extends Lugar {

    private int clima;

    public Ciudad(int medidor, int clima){
        super(medidor);
        this.clima = clima;
    }

    //Aqui ira el metodo que llame al metodo del padre para definir el clima
    
    
    public int getClima(){
        return clima;
    }


}
