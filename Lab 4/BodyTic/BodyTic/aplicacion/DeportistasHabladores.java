package aplicacion;


/**
 * Write a description of class DeportistasHabladores here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeportistasHabladores extends Deportista
{
    // instance variables - replace the example below with your own
    private Salon salon;   
    protected String palabras;
    protected int paso;
    private int cima;
    private int otro;
    /**
     * Constructor for objects of class DeportistasHabladores
     */
    public DeportistasHabladores(Salon salon,String nombre,int posicionx, int posiciony)
    {
        super(salon,nombre,posicionx,posiciony, 1);
    }

    public void inicie(){
        if (cima<7){
            super.muevase('S');
            super.inicie();
        }
        else{
            super.PASO=40;
            super.inicie();
        }
        cima+=1;
    }
    
    public void pare(){
        super.palabras="¿Hola como has estado? "+nombre;
    }
}
