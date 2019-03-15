package aplicacion;
import java.awt.Color;
public class PistaDeBaile implements EnSalon{
    private Salon salon;
    public static int paso;
    public int posicionX;
    public int posicionY;
    public String color;
    public String[] colores = new String[]{"ORANGE","PINK","RED","BLUE","YELLOW","GREEN"};
    public PistaDeBaile(Salon salon,int posicionx, int posiciony){
        posicionX=posicionx;
        posicionY=posiciony;
        color=colores[paso];
    }
    
    /**Retorna la forma de la pista que es un rectangulo*/
    public String forma(){
        return EnSalon.FORMAS[2];
    }
    
    /**inicia el movimiento de la pista con colores menos el negro*/
    public void inicie(){
        if (paso==5){
            paso=0;
        }
        color=colores[paso];
        paso+=1;
    }
    
    /**para la pista con color negro*/
    public void pare(){
        color="BLACK";
        paso=0;
        getColor();
    }
    
    /**retorna el color de la pista sea para inicio o pare*/
    public Color getColor(){
        if (color=="ORANGE"){
            return Color.RED;
        }
        else if (color=="PINK"){
            return Color.PINK;
        }
        else if (color=="RED"){
            return Color.RED;
        }
        else if (color=="BLUE"){
            return Color.BLUE;
        }        
        else if (color=="YELLOW"){
            return Color.YELLOW;
        }     
        else if (color=="BLACK"){
            return Color.BLACK;
        }
        return Color.GREEN;
    }
    
    /**retorna la poscision en x de la pista*/
    public int getPosicionX(){
        return posicionX;
    }
    
    /**retorna la poscision en y de la pista*/
    public int getPosicionY(){
        return posicionY;
    }    
}
