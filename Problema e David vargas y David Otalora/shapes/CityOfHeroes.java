import java.util.ArrayList;
/**
 * Write a description of class CityOfHeroes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CityOfHeroes
{
    public static ArrayList<Rectangle> Squares;
    public static int width1;
    public static int height1;
    public static ArrayList<Rectangle> Builds;
    
    public CityOfHeroes(int widthNew, int heightNew) {
        this.width1=widthNew;
        this.height1=heightNew;
        widthNew*=2;
        heightNew*=2;
        Rectangle ciudadBlack = new Rectangle();
        ciudadBlack.height=heightNew;
        ciudadBlack.width= widthNew;
        ciudadBlack.xPosition+=30;
        ciudadBlack.yPosition+=15;
        ciudadBlack.changeColor("black");
        ciudadBlack.makeVisible();
        Rectangle ciudadWhite = new Rectangle();
        ciudadWhite.height=heightNew-10;
        ciudadWhite.width= widthNew-10;
        ciudadWhite.xPosition+=35;
        ciudadWhite.yPosition+=20;
        ciudadWhite.changeColor("white");
        ciudadWhite.makeVisible();
                }
    public void addBuilding(int x, int width, int height, int hardness){
            ArrayList<Integer> Builder= new ArrayList<Integer>();
            Rectangle cuadrados = new Rectangle();
            cuadrados.height=height;
            cuadrados.width= width;
            cuadrados.xPosition+=30+x;
            cuadrados.yPosition+=(height1*2)-height+11;
            cuadrados.changeColor("black");
            cuadrados.makeVisible();
            Rectangle cuad = new Rectangle();
            cuad.height=height-10;
            cuad.width= width-10;
            cuad.xPosition+=35+x;
            cuad.yPosition+=((height1*2)-height)+5+11;
            cuad.changeColor("white");
            cuad.makeVisible();          
            Builds.add(cuadrados);
    }
                
}
