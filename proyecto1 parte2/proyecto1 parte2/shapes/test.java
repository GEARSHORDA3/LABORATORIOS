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
    private int h;
    private double vo;
    private double vox=0;
    private double voy=0;
    private double y;
    private double posicionY;
    private double posicionX;

    /**
     * Constructor for objects of class test
     */
    public test()
    {
        // initialise instance variables
        x = vox*t;
        y=(h+(voy*t) -(4.9*(t*t)));
    }
    
    public void setxPosition(double a){
        posicionX=a;
    }
    
    public void setyPosition (double b){
        posicionY=b;
    }
    
    public void setHeight(int c){
        h=c/3;
    }
    
    
    public void Jump(int angulo, int velocidad,int alturaEdi){
        h=alturaEdi;
        vo=velocidad;
        Rectangle rect = new Rectangle();  
        voy= vo*Math.sin(angulo);
        vox= vo*Math.cos(angulo);
        Circle circ = new Circle();
        circ.setXYposition(posicionX,posicionY);
        while (y>-posicionY){
                y=((h)+(voy*t) -(4.9*(t*t)));
                x= vox*t;
                t+=0.01;
                circ.setXYposition((posicionY-(y)),(x*2));
                // circ.setP=(posicionY-(y));
                // circ.xPosition=();
                circ.makeVisible();
        }        
    }
    



}