package aplicacion;


/**
 * Write a description of class DeportistasHabladores here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeportistasHabladores extends Deportista
{
    private Salon salon;   
    protected String palabras;
    protected int paso;
    private int cima;
    /**
     * Constructor for objects of class DeportistasHabladores
     */
    public DeportistasHabladores(Salon salon,String nombre,int posicionx, int posiciony)
    {
        super(salon,nombre,posicionx,posiciony, 1);
    }
    
    /**inicia el movimiento del DeportistasHabladores sobreescribiendo*/
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
    
    /**para el movimiento del DeportistasHabladores sobreescribiendo*/
    public void pare(){
        super.palabras="¿Hola como has estado? "+nombre;
    }
}
