import java.util.ArrayList;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Collections;
import java.awt.Toolkit; 
import java.util.ArrayList;
import java.util.ArrayList;
/**
* Write a description of class CityOfHeroes here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class CityOfHeroes
{

// Pyoyecto 1 varibales 
    private  int heightNew;
    private  int wightNew; 
    public   int width1;
    private  int height1;
    private  ArrayList<Building>Builds;
    private  ArrayList<Heroe>Heroes;
    private  Canvas canvas;
    private  Rectangle ciudadBlack;
    private Hashtable<Integer,Integer> infCoordenadas = new Hashtable<Integer,Integer>();
    private ArrayList<Integer>positionX = new ArrayList<Integer>();
    private Hashtable<Integer,Integer> infCoordenadasAncho = new Hashtable<Integer,Integer>();
    private int xNumeroColores=-1;
    private static final String colores[]={"red","yellow","blue","black","brown","magenta","green","grey","fucsia"};
    private boolean isVisible=false;
    public CityOfHeroes(int widthNew, int heightNew) {
        Builds= new ArrayList<Building>();
        Heroes = new  ArrayList<Heroe>();
        width1=widthNew;
        height1=heightNew;
        canvas = Canvas.getCanvas(widthNew,heightNew);
    }
    
    /**
     * Make this circle visible. If it was already visible, do nothing.
     */    
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * darw the heroe.
     */    
    private void draw() {
        if(isVisible) {
           int i; 
           for(i=0;i<Heroes.size();i++){
               Heroes.get(i).makeVisible();
                  
                }
           int a;
           for(a=0;a<Builds.size();a++){
               Builds.get(a).makeVisible();
                }
    }
    } 
    
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Erase the rectangle on screen.
     */
    private void erase(){
        if(isVisible) {
           int i; 
           for(i=0;i<Heroes.size();i++){
               Heroes.get(i).makeInvisible();
                  
                }
           int a;
           for(a=0;a<Builds.size();a++){
               Builds.get(a).makeInvisible();
                } 
        }
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addBuilding(int x, int width, int height, int hardness)
    {
       if (xNumeroColores==colores.length-1){
                            xNumeroColores=0;
                        }
                        else{
                            xNumeroColores++;
       };
       Building edificio = new Building(x, width, height, hardness,xNumeroColores) ;
       Builds.add(edificio);
       positionX.add(x);
       int y= edificio.getPositionY();
       infCoordenadas.put(x ,y);
       infCoordenadasAncho.put(x,(edificio.getWidth()));
       if (isVisible==true){
       edificio.makeVisible();
       };
    }
   
    /**
     * Add a Heore
     *
     * @param  color,hidingBuilding,strength
     * @return void
     */
    public void addHeroe(String color,int hidingBuilding, int strength){
        Collections.sort(positionX);
        
        try{
            int x =positionX.get(hidingBuilding-1);
            int y= infCoordenadas.get(x);          
            int edificioHeroe= infCoordenadasAncho.get(x);
            Heroe heroe= new Heroe(color,hidingBuilding,strength, x,y, edificioHeroe);
            Heroes.add(heroe);
            if (isVisible==true){
                heroe.makeVisible();
            };
        }
        catch(IndexOutOfBoundsException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No existe un edificio al cual");
        }
    }
    
    /**
     * Remove a Building
     *
     * @param     int position
     * @return    void
     */
    public void removeBuilding(int position)
    {
       position-=1; 
       Builds.get(position).removeBuilding(Builds.get(position)); 
       Builds.remove(position); 
    }
    
    /**
     * Remove a Heroe
     *
     * @param     int position
     * @return    void
     */
    public void removeHeroe(String color)
    {
       int i; 
       for(i=0;i<Heroes.size();i++){
           if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color)){
               Heroes.get(i).removeHeroe(Heroes.get(i));
               Heroes.remove(i);
               return;
            }

    }
    }
    
    /**
     * The function of the coordenates y,x for the parabolic
     * 
     * @param String color, int angulo, int velocidad
     * @return void
     */
     public void jump(String color, int angulo, int velocidad, boolean slow){  
     int altCanvas= canvas.getWidth();
       for(int i=0;i<Heroes.size();i++){
           if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color)){
               int posiXHeroe= (Heroes.get(i)).getxPosition();
               int posiYHeroe= (Heroes.get(i)).getyPosition();
               int a;
               for(a=0;a<Builds.size();a++){
                   Building edificio =Builds.get(a);
                   int xpositionEdi= (edificio.getPositionX());
                   int anchoEdi= edificio.getWidth()+xpositionEdi;
                   if (xpositionEdi<=posiXHeroe && posiXHeroe<=anchoEdi){
                       if (slow){
                           (Heroes.get(i)).Jump(color, angulo, velocidad, altCanvas-posiYHeroe,
                           posiYHeroe, posiXHeroe,altCanvas, 0.0001,isVisible);
                       }
                       else{
                           (Heroes.get(i)).Jump(color, angulo, velocidad, altCanvas-posiYHeroe,
                           posiYHeroe, posiXHeroe,altCanvas, 0.01,isVisible);
                        }
                       return;
                    }
                }
           }
    }       
       
}
}
