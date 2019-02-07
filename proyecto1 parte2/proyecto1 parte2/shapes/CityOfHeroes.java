import java.util.ArrayList;
import java.util.*;

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
    


    public CityOfHeroes(int widthNew, int heightNew) {
        Builds= new ArrayList<Building>();
        Heroes = new  ArrayList<Heroe>();
        width1=widthNew;
        height1=heightNew;
        canvas = Canvas.getCanvas(widthNew,heightNew);


    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addBuilding(int x, int width, int height, int hardness)
    {
       Building edificio = new Building(x, width, height, hardness) ;
       Builds.add(edificio);
       positionX.add(x);
       int y= edificio.getPositionY();
       infCoordenadas.put(x ,y);
    }
    
    /**
     * Add a Heore
     *
     * @param  color,hidingBuilding,strength
     * @return void
     */
    public void addHeroe(String color,int hidingBuilding, int strength){
        Collections.sort(positionX);
        int x =positionX.get(hidingBuilding-1);
        int y= infCoordenadas.get(x);
        // Condicion de que si no hay edificio salga el error
        int edificioHeroe= Builds.get(hidingBuilding-1).getWidth();
        // System.out.println(edificioHeroe + "aaaaaaaaaaaaaaaaaaaaaaaaaa");
        Heroe heroe= new Heroe(color,hidingBuilding,strength, x,y, edificioHeroe);
        Heroes.add(heroe);        
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
    public void jump(String color, int angulo, int velocidad){
     int i;  
       for(i=0;i<Heroes.size();i++){
           if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color)){
               int posiXHeroe= (Heroes.get(i)).getxPosition();
               int a;
               
               for(a=0;a<Builds.size();a++){
                   Building edificio =Builds.get(a);
                   int xpositionEdi= (edificio.getPositionX());
                   System.out.println(xpositionEdi +"aaaaaa");                  
                   int anchoEdi= edificio.getWidth()+xpositionEdi;
                   System.out.println(anchoEdi); 
                   System.out.println(posiXHeroe);
              
                   if (xpositionEdi<=posiXHeroe && posiXHeroe<=anchoEdi){
                       System.out.println(Heroes.get(i).getHeroeColor(Heroes.get(i)));
                       //(Heroes.get(i)).jump(color, angulo, velocidad,infCoordenadas.get(xpositionEdi));
                       return;
                    }
                }
           }

    }        
       
}
}