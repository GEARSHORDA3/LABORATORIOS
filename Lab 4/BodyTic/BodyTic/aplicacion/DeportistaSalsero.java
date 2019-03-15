package aplicacion;



/**
 * Write a description of class NuevoDeportista here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeportistaSalsero extends Deportista
{
    private Salon salon;   
    protected String palabras;
    protected int paso;
    private int cima;
    private int posicionXoriginal;
    private int posicionYoriginal;
    private int conta;
    /**
     * Constructor for objects of class NuevoDeportista
     */
    public DeportistaSalsero(Salon salon,String nombre,int posicionx, int posiciony)
    {
        super(salon,nombre,posicionx,posiciony,1);
        posicionXoriginal=posicionx;
        posicionYoriginal=posiciony;        
    }
    
    /**inicia el movimiento del DeportistaSalsero  sobreescribiendo*/
    public void inicie(){
        if (conta==20){
            for (int i =0; i<6; i++){
                super.muevase('N');
            }
            conta=0;
        }
        else if (paso==0){
            super.muevase('N');
            conta+=1;
        }
        else if (paso==1){
            super.muevase('E');
            super.muevase('E');
            super.muevase('E');
            conta+=1;
        }
        else if (paso==2){
            super.muevase('S');
            conta+=1;
        }        
        else {
            super.muevase('O');
            super.muevase('O');
            super.muevase('O');
            paso=0;
            conta+=1;
        }   
        super.inicie();
        
        paso+=1;
    }

}
