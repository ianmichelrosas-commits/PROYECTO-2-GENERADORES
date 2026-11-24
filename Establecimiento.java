import javax.swing.JOptionPane;

public class Establecimiento extends Ciudad {
    private double clima;
  
    public Establecimiento(){
        this(0,0);
    }

    public Establecimiento(int medidor){
        this(medidor, 0);
    }
    
    public Establecimiento(int medidor, double clima){
        super(medidor);//Determinar el costo del Voltaje
        this.clima = clima;
    }
    //Aqui ira el metodo que asigne el clima
    @Override 
    public void definirClima(){
        int N = 2;
        int M = 0;
        clima = Math.floor(Math.random()*(N-M+1)+M);
        if(clima == calor){
            JOptionPane.showMessageDialog(
                                null,
                                "El clima predominante es el calor"
                        );
        }else if(clima == viento){
            JOptionPane.showMessageDialog(
                                null,
                                "El clima predominante es el Viento"
                        );
        }else JOptionPane.showMessageDialog(
                                null,
                                "El clima predominante es la lluvia"
                        );
    }
    
    public double getClima(){
        return clima;
    }
}
