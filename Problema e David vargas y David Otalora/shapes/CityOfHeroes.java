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
                private static int numLineasX; 
                private static int numLineasY; 
                private static int width1;
                private static int height1;
                public static ArrayList<Rectangle>Builds;
                
                
                
                
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
                   numLineasX = (widthNew/50)/2;
                   int i;
                   int x=50;
                   for(i=0;i<numLineasX;i++){
                       Rectangle lineaTablerox = new Rectangle();
                       lineaTablerox.height=20;
                       lineaTablerox.width= 5;
                       lineaTablerox.changeColor("green");
                       lineaTablerox.xPosition=((ciudadBlack.xPosition+x)*2)-49;
                       lineaTablerox.yPosition=ciudadBlack.yPosition+(heightNew-10);
                       x+=50;
                       lineaTablerox.makeVisible();
                       
                    }
                    
                   numLineasY = (heightNew/2)/20;
                   int i1;
                   int y1=20;
                   for(i1=0;i1<numLineasY;i1++){
                       Rectangle lineaTableroy = new Rectangle();
                       lineaTableroy.height=5;
                       lineaTableroy.width= 20;
                       lineaTableroy.yPosition=((ciudadBlack.yPosition+y1)*2)-38;
                       lineaTableroy.xPosition=ciudadBlack.xPosition+30;
                       y1+=20;
                       lineaTableroy.makeVisible();
                       
                    }
                   
  
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