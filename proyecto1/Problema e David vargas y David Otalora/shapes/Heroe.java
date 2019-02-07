
/**
 * Write a description of class Heroe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heroe
{
    // instance variables - replace the example below with your own
    private int x;
    private static final String colores[]={"red","yellow","blue","black","magenta","green","grey","pink","orange","cyan"};
    private int strength;
    private Circle cabeza;
    private Rectangle torzo;
    private Rectangle cuerpo;
    private Rectangle pierna1;
    private Rectangle pierna2; 
    /**
     * Constructor for objects of class Heroe
     */
    public Heroe(){
        
        cabeza = new Circle();
        torzo = new Rectangle();
        cuerpo = new Rectangle();
        pierna1 = new Rectangle();
        pierna2 = new Rectangle();
        
        //torzo
        torzo.onlyChangeSize(20,15);
        torzo.moveHorizontal((int)cabeza.getxPosition()-15);
        torzo.moveVertical((int)cabeza.getyPosition()+25);

        System.out.println(torzo.getHeight());
        //System.out.println(torzo.width);
        
        //cuerpo
        cuerpo.onlyChangeSize(-20,30);
        cuerpo.moveHorizontal((int)cabeza.getxPosition()+5);
        cuerpo.moveVertical((int)cabeza.getyPosition()+25);

        // pierna1
        pierna1.onlyChangeSize(5,30);
        pierna1.moveHorizontal((int)cabeza.getxPosition()+20);
        pierna1.moveVertical((int)cabeza.getyPosition()+70);
        
        // pierna2
        pierna2.onlyChangeSize(5,30);
        pierna1.moveHorizontal((int)cabeza.getxPosition()+6);
        pierna1.moveVertical((int)cabeza.getyPosition()+70);

        
        
        System.out.println(torzo.getHeight());

        //System.out.println(torzo.width);
        //torzo.makeVisible();
    }
    
    
    // public void addHeroe(String color,int hidingBuilding, int strength){
        // cabeza.changeColor(color);
        // torzo.changeColor(color);
        // cuerpo.changeColor(color);
        // pierna1.changeColor(color);
        // pierna2.changeColor(color);
        
        // //cuerpo.makeVisible();
        // //pierna1.makeVisible();
        // //pierna2.makeVisible();
        // //cabeza.makeVisible();
            
    // }

    // /**
     // * An example of a method - replace this comment with your own
     // *
     // * @param  y  a sample parameter for a method
     // * @return    the sum of x and y
     // */
    // public int sampleMethod(int y)
    // {
        // // put your code here
        // return x + y;
    // }
}
