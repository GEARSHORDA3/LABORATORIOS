package aplicacion;
import java.awt.Color;
public class Bola implements EnSalon{
    private Salon salon;
    public static int paso;
    public int posicionX;
    public int posicionY;
    public String color;
    public String[] colores = new String[]{"ORANGE","PINK","RED","BLUE","YELLOW","GREEN"};
    public Bola (Salon salon,int posicionx, int posiciony){
        posicionX=posicionx;
        posicionY=posiciony;
        color=colores[paso];
    }
    
    /**Retorna la forma de la bola que es circulo*/
    public String forma(){
        return EnSalon.FORMAS[1];
    }
    
    /**inicia el movimiento de la bola con un color menos el negro*/
    public void inicie(){
        if (paso==5){
            paso=0;
        }
        color=colores[paso];
        paso+=1;
    }
    
    /**para el movimiento de la bola con un color negro*/
    public void pare(){
        color="BLACK";
        paso=0;
        getColor();
    }
    
    /**Obtiene el color para la bola, retornando un color*/
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
    
    /**Obtiene la posicion de la bola en x*/
    public int getPosicionX(){
        return posicionX;
    }
    
    /**Obtiene la posicion de la bola en y*/
    public int getPosicionY(){
        return posicionY;
    }
}
