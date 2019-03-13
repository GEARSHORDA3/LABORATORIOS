package aplicacion;


/**
 * Write a description of class SuperDeportista here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeportistasAvanzados extends Deportista implements EnSalon
{
        private Salon salon;   
    protected String palabras;
        protected int paso;
        private int conta;
    /**
     * Constructor for objects of class SuperDeportista
     */
    public DeportistasAvanzados(Salon salon,String nombre,int posicionx, int posiciony)
    {
        super(salon,nombre,posicionx,posiciony, 1);
    }
    
    public void inicie(){
        super.PASO=60;
        super.inicie();
        conta+=1;
    }
}
