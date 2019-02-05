
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    private double x;
    private double t=0;
    private double h;
    private double vo;
    private double vox=0;
    private double voy=0;
    private double y;

    /**
     * Constructor for objects of class test
     */
    public test(int altura, int angulo, int velocidad)
    {
        // initialise instance variables
        vo=velocidad;
        h=altura;
        voy= vo*Math.sin(angulo);
        vox= vo*Math.cos(angulo);
        x = vox*t;
        y=(h+(voy*t) -(4.9*(t*t)));
        Circle circ = new Circle();
        for (int i=0; i<1500;i++){
            
            if (y>=0){
                y=(h+(voy*t) -(4.9*(t*t)));
                x= vox*t;
                t+=0.01;
                circ.yPosition=-y;
                circ.xPosition=x;
                circ.makeVisible();
                //System.out.println(y);
            }
            else{
                break;
            }
        }
        
    }



}
