import java.util.ArrayList;
/**
 * Write a description of class CityOfHeroes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CityOfHeroes
{
               // instance variables - replace the example below with your own
                private static ArrayList<String> colors= new ArrayList<String>(); 
                //private static final String colores[]={"red","yellow","blue","black","brown","white","magenta","green","grey","fucsia"};
                public static ArrayList<Rectangle> lista3; //Define el tamaño de el arreglo
                public static ArrayList<Integer> lista4= new ArrayList<Integer>();
                public static ArrayList<Rectangle> BigSquare;
                public static ArrayList<Circle> circles; //Listas circulos pequeños
                public static String color="";
                public static Integer x=0;
                public static Integer y=0;
                public static ArrayList<Integer> padres= new ArrayList<Integer>();
                public static int tamaño=0;
                public static boolean itera=false;
                public static int MaxCantidad=0;
                public static int suma;

                // Pyoyecto 1 varibales 
                private static int heightNew;
                private static int wightNew;
                private static int numLineasX; 
                private static int numLineasY; 
                private static int width1;
                private static int height1;
                private double posX;
                private double posY;
                public static ArrayList<Rectangle>Builds;
    
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
        posX=ciudadBlack.xPosition;
        posY=ciudadBlack.yPosition;
    }
    
    public void jump(int angulo, int velocidad){
        test Test = new test();
        Test.setHeight(width1);
        Test.setyPosition(posY);  
        Test.setxPosition(posX);
        Test.Jump(angulo, velocidad);
    }
                
}
