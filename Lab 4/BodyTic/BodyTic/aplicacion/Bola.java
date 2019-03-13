package aplicacion;
import java.awt.Color;
public class Bola implements EnSalon{
    private Salon salon;
    protected String palabras;
    public int paso;
    public String forma(){
        return EnSalon.FORMAS[1];
    }
    public void inicie(){}
    public void pare(){}
    public java.awt.Color getColor(){
        return Color.BLACK;}
    public int getPosicionX(){return 100;}
    public int getPosicionY(){return 100;}
}
