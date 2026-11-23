public class Vivienda extends Ciudad{
        private double clima;

        public Vivienda(int medidor, int clima){
            super(medidor);//Determinar el costo de Voltaje
            this.clima = clima;
        }
        
        public Vivienda(){
            this(0, 0);
        }

        
        public Vivienda(int medidor){
            this(medidor,0);
        } 
    
        
    

    
    //Aqui ira el metodo que asigne el clima
    @Override 
    public void definirClima(){
        int N = 2;
        int M = 0;
        clima = Math.floor(Math.random()*(N-M+1)+M);
        if(clima == calor){
            System.out.println("El clima predominante es el calor");
        }else if(clima == viento){
            System.out.println("EL clima predominante es el viento");
        }else System.out.println("El clima predominante es la lluvia");
    
    }
    
    public double getClima(){
        return clima;
    }
}
