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
    public String forma(){
        return EnSalon.FORMAS[2];
    }
    public void inicie(){
        if (paso==5){
            paso=0;
        }
        color=colores[paso];
        paso+=1;
    }
    public void pare(){
        color="BLACK";
        paso=0;
        getColor();
    }
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
    public int getPosicionX(){
        return posicionX;
    }
    public int getPosicionY(){
        return posicionY;
    }    
}
