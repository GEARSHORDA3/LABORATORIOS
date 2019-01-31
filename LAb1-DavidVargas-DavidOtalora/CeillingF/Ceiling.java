
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class Ceiling here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ceiling 
{
    // instance variables - replace the example below with your own
    private static ArrayList<String> colors= new ArrayList<String>(); 
    //private static final String colores[]={"red","yellow","blue","black","brown","white","magenta","green","grey","fucsia"};
    public static ArrayList<Rectangle> lista3; //Define el tamaño de el arreglo
    public static ArrayList<Integer> lista4= new ArrayList<Integer>();
    public static ArrayList<Rectangle> BigSquare;
    public static ArrayList<Circle> circles; 
    public static String color="";
    public static Integer x=0;
    public static Integer y=0;
    public static ArrayList<Integer> padres= new ArrayList<Integer>();
    
    /**
     * Constructor for objects of class Ceiling
     */

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   private static void main(int[] args, String color) {
      Ceiling iat = new Ceiling(args, color);          
   }

   /**
     * Builder Method
     * @param ArrayP,Stringcolor
    */ 
   public Ceiling(int[] p, String color) {
       // Imprima Rectangulo grande
       Rectangle Rect= new Rectangle();
       Rect.changeHeightWidth(53*p.length);
       Rect.changeColor(color);
       this.color=color;
       Rect.moveHorizontal(x);
       Rect.moveVertical(y);
       Rect.makeVisible();
       
       lista3= new ArrayList<Rectangle>(); //Hacemos la lista
       BigSquare=new ArrayList<Rectangle>(); //Hacemos la lista    
       colors.add("black");colors.add("red");colors.add("yellow");colors.add("white");colors.add("blue");colors.add("grey");colors.add("green");colors.add("magenta");colors.add("pink");colors.add("cyan");colors.add("orange");
       BigSquare.add(Rect);
       //Imprime Rectangulos pequeños
       
       int posicion=(52*p.length)-50;
       int i;

       for (i=0; i<(p.length); i++){
          Rectangle Rect2= new Rectangle();
          Rect2.changeColor(colors.get(p[i]));
          Rect2.changeSize(40,100);
          Rect2.moveHorizontal(10);
          Rect2.moveVertical(posicion);
          Rect2.moveHorizontal(x);
          Rect2.moveVertical(y);
          Rect2.makeVisible();
          posicion-=50;
          lista3.add(Rect2);
          lista4.add(p[i]);
          
       } 
    }

   /**
     * Add the top part of the roof.
     * @param IntM number of roof
    */ 
   public void add(int m){
       //delete
       int posicion3=(52*lista4.size())-50;
       int t1=0;
       for (t1=0; t1<(lista4.size()); t1++){
           Rectangle Rect3= new Rectangle();
           Rect3.changeColor(colors.get(lista4.get(t1)));
           Rect3.changeSize(40,100);
           Rect3.moveHorizontal(10);
           Rect3.moveVertical(posicion3);
           Rect3.moveHorizontal(x);
           Rect3.moveVertical(y);
           Rect3.makeInvisible();
           lista3.get(t1).makeInvisible();
           posicion3-=50;
  
       } 
       int t2=0;
       for (t2=0; t2<(BigSquare.size());t2++){
           BigSquare.get(t2).makeInvisible();
        }       
       //
       lista4.add(m);
       Rectangle Rect= new Rectangle();
       Rect.changeHeightWidth(53*lista4.size());
       Rect.changeColor(color);
       Rect.moveHorizontal(x);
       Rect.moveVertical(y);
       Rect.makeVisible();
       BigSquare=new ArrayList<Rectangle>();
       BigSquare.add(Rect);
       lista3= new ArrayList<Rectangle>(); //Hacemos la lista             
       int posicion=(52*lista4.size())-50;
       int l=0;
       for (l=0; l<(lista4.size()); l++){
           Rectangle Rect3= new Rectangle();
           Rect3.changeColor(colors.get(lista4.get(l)));
           Rect3.changeSize(40,100);
           Rect3.moveHorizontal(10);
           Rect3.moveVertical(posicion);
           Rect3.moveHorizontal(x);
           Rect3.moveVertical(y);
           Rect3.makeVisible();
           posicion-=50;
           lista3.add(Rect3);
          
       }
       BigSquare.add(Rect);
   }
   
   /**
     * Move all the squares of layers according to some coordinates.
     * @param Intx,Inty Two numbers to de coordinates of all squares
     */ 
   public void move(int x, int y){
       //delete 
       int posicion3=(52*lista4.size())-50;
       int t1=0;
       for (t1=0; t1<(lista4.size()); t1++){
           Rectangle Rect3= new Rectangle();
           Rect3.changeColor(colors.get(lista4.get(t1)));
           Rect3.changeSize(40,100);
           Rect3.moveHorizontal(10);
           Rect3.moveVertical(posicion3);
           Rect3.moveHorizontal(x);
           Rect3.moveVertical(y);
           Rect3.makeInvisible();
           lista3.get(t1).makeInvisible();
           posicion3-=50;
  
       } 
       int t2=0;
       for (t2=0; t2<(BigSquare.size());t2++){
           BigSquare.get(t2).makeInvisible();
        }
       
       //mueva e imprima
       Rectangle Rect= new Rectangle();
       Rect.changeHeightWidth(53*lista4.size());
       Rect.changeColor(color);
       this.x =x;
       this.y= y;
       Rect.moveHorizontal(x);
       Rect.moveVertical(y);
       Rect.makeVisible();
       BigSquare=new ArrayList<Rectangle>();
       BigSquare.add(Rect);
       lista3= new ArrayList<Rectangle>(); //Hacemos la lista  
       int posicion=(52*lista4.size())-50;
       int M=0;
       for (M=0; M<(lista4.size()); M++){
           Rectangle Rect3= new Rectangle();
           Rect3.changeColor(colors.get(lista4.get(M)));
           Rect3.changeSize(40,100);
           Rect3.moveHorizontal(10);
           Rect3.moveVertical(posicion);
           Rect3.moveHorizontal(x);
           Rect3.moveVertical(y);
           Rect3.makeVisible();
           posicion-=50;
           lista3.add(Rect3);
   
       }
       BigSquare.add(Rect);
    }
    
    /**
     * Remove the layers from the top of the roof. 
     * @param none
     */  
    public void delete(){
       int posicion3=(52*lista4.size())-50;
       int t1=0;
       for (t1=0; t1<(lista4.size()); t1++){
           Rectangle Rect3= new Rectangle();
           Rect3.changeColor(colors.get(lista4.get(t1)));
           Rect3.changeSize(40,100);
           Rect3.moveHorizontal(10);
           Rect3.moveVertical(posicion3);
           Rect3.moveHorizontal(x);
           Rect3.moveVertical(y);
           Rect3.makeInvisible();
           lista3.get(t1).makeInvisible();
           posicion3-=50;
       } 
       int t2=0;
       for (t2=0; t2<(BigSquare.size());t2++){
           BigSquare.get(t2).makeInvisible();
        } 
       Rectangle Rect= new Rectangle();
       lista4.remove(lista4.size()-1);
       System.out.println(lista4.size());
       Rect.changeHeightWidth(53*lista4.size());
       Rect.changeColor(color);
       Rect.moveHorizontal(x);
       Rect.moveVertical(y);
       Rect.makeVisible();       
       lista3= new ArrayList<Rectangle>(); //Hacemos la lista  
       int posicion=(52*lista4.size())-50;
       int t=0;
       for (t=0; t<(lista4.size()); t++){
           Rectangle Rect3= new Rectangle();
           Rect3.changeColor(colors.get(lista4.get(t)));
           Rect3.changeSize(40,100);
           Rect3.moveHorizontal(10);
           Rect3.moveVertical(posicion);
           Rect3.moveHorizontal(x);
           Rect3.moveVertical(y);
           Rect3.makeVisible();
           posicion-=50;
           lista3.add(Rect3);
   
       }
       BigSquare.add(Rect);
       
    }
    
    public void showTree(){
      
            //escondemos los rectangulos
            int num1=0; int num2=0;
            for (num1=0; num1<lista3.size();num1++){
                lista3.get(num1).makeInvisible();
            }
            for (num2=0; num2<BigSquare.size();num2++){
                BigSquare.get(num2).makeInvisible();
            }
            
            //Creamos un fondo para el arbol
            circles = new ArrayList<Circle>();
            Rectangle rect = new Rectangle();
            rect.changeSize(1000,1000);
            rect.changeColor("orange");
            rect.makeVisible();
            
            //Lista de indicador de hijos izquierdo y derecho de un nodo con otra lista(milista) para las cordenas nodos
            int hijos[] =new int[lista4.size()*2];
            int miLista[] =new int [lista4.size()*2];
            //Lista de nodos ya pintados
            
            boolean nodo_drow[] =new boolean[lista4.size()];
            
            //Se agrega 0 a las cordenas de los nodos para tener valores despues
        
            for (int Var=0; Var<(miLista.length);Var++){
                miLista[Var]=0;
                hijos[Var]=0;
            }
           
            //Se crea el nodo principal
            miLista[0]=270;
            miLista[1]=15;
            Circle cir2= new Circle();
            cir2.changeColor(colors.get(lista4.get(0)));
            cir2.moveHorizontal(270);
            cir2.moveVertical(15);
            cir2.makeVisible();
            circles.add(cir2);
            
          
            //Grafica el arbol
            
            int num;int num3;
            // num3 padre
            // num hijo
            System.out.println(lista4+"lista");
            for (num=1;num<(lista4.size());num++){
                
                System.out.println("----------HIJO ="+lista4.get(num));
                Circle circ= new Circle();
                circ.changeColor(colors.get(lista4.get(num))); //cambia el color del nodo
                for (num3=0;num3<num;num3++){
                    //System.out.println(lista4.get(num3));
                    //System.out.println(lista4.get((hijos[(num3*2)])));
                    //System.out.println(lista4.get(num3));
                    if (nodo_drow[num]!= true){
                    nodo_drow[num]=false;
                    }
                    else{
                    continue;
                    }
                    //hijo izquierdo
                    if (lista4.get(num) < lista4.get(num3) && num3==0 && (hijos[(num3*2)])==0){ 
                        System.out.println("1 IF");
                        System.out.println("PAPA ="+lista4.get(num3));
                        System.out.println("PAPA_X ="+miLista[(num3*2)]);
                        System.out.println("PAPA_Y ="+(miLista[(num3*2)+1]));
                        hijos[(num3*2)]=1;
                        circ.moveHorizontal(miLista[(num3*2)]-50);
                        circ.moveVertical(miLista[(num3*2)+1]+30);
                        circ.makeVisible();
                        miLista[(num*2)]=miLista[(num3*2)]-50;
                        miLista[(num*2)+1]=miLista[(num3*2)+1]+30;
                        System.out.println("HIJO_X ="+miLista[(num*2)]);
                        System.out.println("HIJO_Y ="+miLista[(num*2)+1]);
                        nodo_drow[num]=true;
                    }
                
                    else if (lista4.get(num) < lista4.get(num3)&& num3!=0 && (hijos[(num3*2)])==0){ 
                        System.out.println("2 IF");
                        System.out.println("PAPA ="+lista4.get(num3));
                        System.out.println("PAPA_X ="+miLista[(num3*2)]);
                        System.out.println("PAPA_Y ="+(miLista[(num3*2)+1]+30));
                        System.out.println("HIJO_Y2222 ="+miLista[(num*2)]);
                        System.out.println("num ="+num);
                        hijos[(num3*2)]=1;
                        circ.moveHorizontal(miLista[(num3*2)]-50);
                        circ.moveVertical(miLista[(num3*2)+1]+30);
                        circ.makeVisible();
                        miLista[(num*2)]=miLista[(num3*2)]-50;
                        miLista[(num*2)+1]=miLista[(num3*2)+1]+30;
                        System.out.println("HIJO_X ="+miLista[(num*2)]);
                        System.out.println("HIJO_Y ="+miLista[(num*2)+1]);
                        nodo_drow[num]=true;
                    }
                    //hijo derecho
                    else if(lista4.get(num) > lista4.get(num3) && num3==0 && (hijos[(num3*2)+1])==0){
                        System.out.println("3 IF");
                        System.out.println("PAPA ="+lista4.get(num3));
                        System.out.println("PAPA_X ="+miLista[(num3*2)]);
                        System.out.println("PAPA_Y ="+miLista[(num3*2)+1]);
                        hijos[(num3*2)+1]=1;
                        //System.out.println((miLista[(num3*2)+1]+50)+"x hijo y pa"+(miLista[(num3*2)+1]));
                        //System.out.println((miLista[(num3*2)]+30)+"y hijo y pa"+(miLista[(num3*2)]));
                        circ.moveHorizontal(miLista[(num3*2)]+50);
                        circ.moveVertical(miLista[(num3*2)+1]+30);
                        circ.makeVisible();
                        miLista[(num*2)]=miLista[(num3*2)]+50;
                        miLista[(num*2)+1]=miLista[(num3*2)+1]+30;
                        System.out.println("HIJO_X ="+miLista[(num*2)-1]);
                        System.out.println("HIJO_Y ="+miLista[(num*2)]);
                        nodo_drow[num]=true;
                    }
                    else if(lista4.get(num) > lista4.get(num3)&& num3!=0 && (hijos[(num3*2)+1])==0){
                        System.out.println("4 IF");
                        System.out.println("PAPA ="+lista4.get(num3));
                        System.out.println("PAPA_X ="+miLista[(num3*2)]);
                        System.out.println("PAPA_Y ="+miLista[(num3*2)+1]);
                        hijos[(num3*2)+1]=1;
                        circ.moveHorizontal(miLista[(num3*2)]+50);
                        circ.moveVertical(miLista[(num3*2)+1]+30);
                        circ.makeVisible();
                        miLista[(num*2)]=miLista[(num3*2)]+50;
                        miLista[(num*2)+1]=miLista[(num3*2)+1]+30;
                        System.out.println("HIJO_X ="+miLista[(num*2)-1]);
                        System.out.println("HIJO_Y ="+miLista[(num*2)]);
                        nodo_drow[num]=true;
                    }
                    
                    else if(lista4.get(num)==lista4.get(num3) && (hijos[(num3*2)])==0){
                        System.out.println("5 IF");
                        System.out.println("PAPA ="+lista4.get(num3));
                        System.out.println("PAPA_X ="+miLista[(num3*2)-1]);
                        System.out.println("PAPA_Y ="+miLista[(num3*2)]);
                        hijos[(num3*2)]=1;
                        System.out.println("5");
                        circ.moveHorizontal(miLista[(num3*2)-1]+50);
                        circ.moveVertical(miLista[(num3*2)]+30);
                        circ.makeVisible();
                        miLista[(num*2)]=miLista[(num3*2)-1]+50;
                        miLista[(num*2)+1]=miLista[(num3*2)]+30;
                        System.out.println("HIJO_X ="+miLista[(num*2)-1]);
                        System.out.println("HIJO_Y ="+miLista[(num*2)]);
                        nodo_drow[num]=true;
                    }
                    System.out.println(miLista[num]);
                    System.out.println(miLista[num3]);
                    //Line linea = new Line(miLista[num*2],miLista[num*2]+1,miLista[num3*2],miLista[(num3*2)+1]);
                    Line linea = new Line(270,15,320,25);
                    linea.makeVisible();
                    
                    
                    
                }
               
                circles.add(cir2);
                
                
            }
            
        }
        
    }
            
        
    
    

    
    
       
       
       
       
       
   
   
   
 
    

