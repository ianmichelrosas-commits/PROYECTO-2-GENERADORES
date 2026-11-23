public class Ciudad {

    protected int medidor;
    protected int calor;
    protected int viento;
    protected int lluvia;

    Ciudad(int medidor){
        this.medidor = medidor;
        this.calor = 0;
        this.viento = 1;
        this.lluvia = 2;
    }

    public double definirClima(){
        int N = 2;
        int M = 0;
        double clima = Math.floor(Math.random()*(N-M+1)+M);
        if(clima == calor){
            System.out.println("El clima predominante es el calor");
        }else if(clima == viento){
            System.out.println("EL clima predominante es el viento");
        }else System.out.println("El clima predominante es la lluvia");

        return clima;
    }


}
