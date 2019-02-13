import java.util.Stack;

/** Calculadora.java
 * Representa una calculadora de vectores 
 * @author ESCUELA 2017-02
 */
    
public class Calculadora{
    private Stack<Vector> operandos;
    private boolean pasoOK;
    /**
     * Este es el constructor
     */
    public Calculadora(){
        operandos=new Stack<Vector>();
        pasoOK = true;
    }
    
    /**
     * Adiciona un vector a la calculadora
     * @param longitud del vector
     * @param grados del vector
     */
    public void adicione(double longitud, double grados){
        if(longitud<0){
            operandos.add(new Vector((-1)*longitud,new Angulo(grados+180,Angulo.GRADOS)));
        }
        else{
            operandos.add(new Vector(longitud,new Angulo(grados,Angulo.GRADOS)));
        }
    }
    /**
     * Elimina un vector de la calculadora en la ultima posicion del Stack
     */
    public void elimine(){
        if(!operandos.isEmpty()){
            operandos.pop();
            pasoOK = true;
        }else{
            System.out.println("Esta vacio");
            pasoOK = false;
        }
    }
    /**
     * Duplica el vector en la calculadora
     */
    public void duplique(){
        if(!operandos.isEmpty()){
            operandos.add(operandos.peek());
            pasoOK = true;
        }else{
            System.out.println("Esta vacio, no se puede duplicar");
            pasoOK = false;
        }
    }
    
    //Los caracteres de las operaciones posibles son: +, -, * (producto escalar), x (producto vectorial)
    
    /**
     * Hace una operacion determinada en la calculadora
     * @param operacion a realizar
     */
    public void opere(char operacion){
        Vector temp=operandos.peek();
        operandos.pop();
        switch(operacion){
            case '+': temp.sume(operandos.peek());
                      operandos.add(temp);
                      pasoOK = true;
                      break;
            case '-': temp.reste(operandos.peek());
                      operandos.add(temp);
                      pasoOK = true;
                      break;
            case '*': temp.productoEscalar(5.0);
                      operandos.add(temp);
                      pasoOK = true;
                      break;
            case 'x':
                      temp.multiplique(operandos.peek());
                      operandos.add(temp);
                      pasoOK = true;
                      break;
            default: System.out.println("Operacion invalida");
                     pasoOK = false;
                     break;
        }
    }
    
    /**
     * Consulta la ultima posicion de la calculadora
     * @return ultimo vector
     */
    public String consulte(){
        return operandos.peek().toString();
    }
    
    public boolean ok(){
        return pasoOK;
    }
}
    



