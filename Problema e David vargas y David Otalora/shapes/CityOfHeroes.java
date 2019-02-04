import javax.swing.ImageIcon;
            import javax.swing.ImageIcon;
            import javax.swing.JFrame;
            import javax.swing.JOptionPane;
            import java.util.List;
            import java.util.ArrayList;
            import java.util.Collections;
            import java.awt.Toolkit;
            import java.util.ArrayList;
            import java.util.Arrays; 
            import java.util.Random;
            
            /**
             * Write a description of class Ceiling here.
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
                private static int numLineas; 
                
                
                /**
                 * Constructor for objects of class Ceiling
                 */
            
               private static void main(){
                   
                }
            
               /**
                 * Builder Method
                 * @param ArrayP,Stringcolor
                */ 
               
               public CityOfHeroes(int widthNew, int heightNew) {
                   // construccion del tablero
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
                   
                   // construccion de limites del tablero en x y y
                   
                   numLineas = widthNew/50;
                   System.out.println(numLineas);
                   int i;
                   int x=50;
                   int y=0;
                   for(i=0;i<numLineas;i++){
                       System.out.println("hola");
                       Rectangle lineaTablero = new Rectangle();
                       lineaTablero.height=20;
                       lineaTablero.width= 5;
                       lineaTablero.changeColor("green");
                       lineaTablero.xPosition=ciudadBlack.xPosition+x;
                       lineaTablero.yPosition=ciudadBlack.yPosition+320;
                       x+=50;
                       lineaTablero.makeVisible();
                    }
                   
                 
                   
                   
                   
                   
                   
                   
                   
                   
                   
                }
                
               
            }