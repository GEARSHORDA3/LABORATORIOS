/**
 * Esta clase sirve para manejar angulos. 
 * La medida de los ángulos podrá especificarse en grados, radianes, o gradianes 
 * y podrá solicitarse en cualquiera de estas unidades, independientemente de con cual hayan sido creados.
 * Internamente se harán las conversiones que sean necesarias.
 * Lo trabajaremos mediante objetos inmutables, es decir, sin métodos modificadores. 
 * @author ECI, 
 */
public class Angulo {

    /** Constantes para indicar que el argumento está en radianes */
    public static final int RADIANES = 0;
    /** Constantes para indicar que el argumento está en grados */
    public static final int GRADOS = 1;
    /** Constantes para indicar que el argumento está en gradianes */
    public static final int GRADIANES = 2;

    /** Constante para maximo error admitido al comparar dos angulos.  
     *  Recuerde que los cálculos en el computador con variables de plunto flotante
     *  tienen una precisión limitada, y se requiere un margen de tolerancia
     */
    public static final double MAXERROR = 0.00000000000001;
    private double valorGrados; 

    /** Crea un angulo a partir del valor dado en grados o en radianes
     * @param valor el valor de medida del angulo
     * @param tipo Tipo de medida del angulo: puede ser GRADOS, RADIANES, GRADIANES
     */
    public Angulo (double valor, int tipo){
        switch(tipo){
            case 0: double temp=(valor*360)/(2*Math.PI);
                    int v0=(int) temp;
                    int t0=v0/360;
                    valorGrados=temp-(360*t0);
                    break;
            case 1: int v1=(int) valor;
                    int t1=v1/360;
                    valorGrados=valor-(360*t1);
                    break;
            case 2: double temp2=valor*0.9;
                    int v2=(int) temp2;
                    int t2=v2/360;
                    valorGrados=temp2-(360*t2);
                    break;
        }
        if(valorGrados<0){
            valorGrados=valorGrados+360;
        }
    }
    
    /**Valor del angulo en grados
     * @return el valor del angulo en grados, 0 <= result < 360
     */
    public double grados () {
        return valorGrados;
    }
    
    /**Valor del angulo en radianes
     * @return el valor del angulo en radianes, 0 <= result < 2*PI
     */
    public double radianes () {
        return (valorGrados*2*Math.PI)/360;
    }
    
    /**Valor del angulo en gradianes
     * @return el valor del angulo en gradianes, 0 <= result < 400
     */
    public double gradianes () {
        return (valorGrados/0.9);
    }
    
    /**
     * Suma este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this + a
     */
    public Angulo sume (Angulo ang) {
        return new Angulo(valorGrados+ang.grados(),1);
    }

    /**
     * Resta este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this - a
     */
    public Angulo reste (Angulo a) {
        return new Angulo(valorGrados-a.grados(),1);
    }

    /**
     * Multiplica este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a multiplicar
     * @return this * a
     */
    public Angulo multiplique (Angulo ang) {
        return new Angulo(valorGrados*ang.grados(),1);
    }

    /**
     * Divide este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a dividir
     * @return this / a
     */
    public Angulo divida (Angulo a) {
        return new Angulo(valorGrados/a.grados(),1);
    }
    
    /**
     * Multiplica esta angulo por un real
     * @param r real para hacer el producto 
     * @return r * this
     */
    public Angulo multiplique (double r) {
        return new Angulo(valorGrados*r,1);
    }
    
    /**
     * Compara a este angulo con otro, para ver si son iguales, 
     * teniendo en cuenta el margen de error MAXERROR, dado que se trabaja con punto flotante
     * @param a angulo para compararse
     * @return |this - a| < MAXERROR
     */
    public boolean equals (Angulo a) {
        return Math.abs(this.grados()-a.grados())<MAXERROR;
    }
    
    /** overrides Object.equals()
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals (Object o) {
        Angulo a = (Angulo) o;
        return equals (a);
    }

    /**Calcula el seno
     * @return el seno de este angulo
     */
    public double seno () {
        return Math.sin(radianes());
    }

    /**Calcula el coseno
     * @return el coseno de este angulo
     */
    public double coseno() {
        return Math.cos(radianes());
    }
    /**
     * Devuelve cuadrante en el que esta el angulo
     * @return entero numero cuadrante
     */
    public int cuadrante(){
        int a;
        if(valorGrados>=0 && valorGrados<90){
            a=1;
        }
        else if(valorGrados>=90 && valorGrados<180){
            a=2;
        }
        else if(valorGrados>=180 && valorGrados<270){
            a=3;
        }
        else{
            a=4;
        }
        return a;
    }
    /**
     * Retorna el valor del angulo en grados
     * @return the information of this object
    */
    public String toString() {
      return String.valueOf(valorGrados);
    }
}
