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
    private  int numLineasX; 
    private  int numLineasY; 
    public   int width1;
    private  int height1;
    public  ArrayList<Building>Builds;
    private Canvas canvas;
    private Rectangle ciudadBlack;

    public CityOfHeroes(int widthNew, int heightNew) {
        Builds= new ArrayList<Building>();
        width1=widthNew;
        height1=heightNew;
        Canvas canvas = Canvas.getCanvas(widthNew,heightNew);


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
       System.out.println(Builds.size());

    }

    
    



    


    
                
}
