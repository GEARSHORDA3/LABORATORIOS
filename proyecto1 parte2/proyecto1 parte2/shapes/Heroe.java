 




import java.util.ArrayList;
/**
 * Write a description of class Heroe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heroe
{
    // instance variables - replace the example below with your own
    private int strength;
    private Circle heroe;
    private int hidingBuilding;
    private ArrayList<Building>Builds;
    private double posY;        
    private double posX;
    /**
     * Add a Heore
     *
     * @param  color,hidingBuilding,strength
     * @return void
     */
    public Heroe(String color,int hidingBuilding, int strength, int x, int y, int edificioX){
        this.strength=strength;
        this.hidingBuilding=hidingBuilding;
        heroe= new Circle ();
        heroe.changeColor(color);
        heroe.setXYposition(x+((edificioX/2)-8),y-19);
        System.out.println(x);
        //Lista = CityOfHeroes.Builds;
        heroe.makeVisible();
        
    }
    
    /**
     * Remove a heroe
     *
     * @param     Object Building
     * @return    void
     */
    public void removeHeroe(Object Building)
    {
         heroe.makeInvisible();  
    }
    
    /**
     * get color heroe
     *
     * @param  Object Building
     * @return color
     */
    public String getHeroeColor(Object Building)
    {
        // put your code here
        return heroe.getColor();
    }
    
    public void jump(String color, int angulo, int velocidad,int alturaEdi){
        test Test = new test();
        Test.setHeight(alturaEdi);
        Test.setyPosition(posY);  
        Test.setxPosition(posX);
        Test.Jump(angulo, velocidad, alturaEdi);
    }    
    
    public int getxPosition(){
        return heroe.getPositionX();
    }


}