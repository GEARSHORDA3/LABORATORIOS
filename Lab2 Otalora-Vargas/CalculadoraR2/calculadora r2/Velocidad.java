
/**
 * @author Otalora
 * @author Vargas
 */
public class Velocidad{

    public static final double MAXERROR = 0.00000000000001;
    
    private double longitud;
    private Angulo angulo;
    
    /**
     * Constructor de la velocidad, en componentes polares
     * @param l longitud de la velocidad
     * @param a angulo de la velocidad
     */
    public Velocidad (double l, Angulo angulo) {
        longitud=l;
        this.angulo=angulo;
    }

    /**
     * Retorna el componente horizontal
     * @return componente horizontal de la velocidad
     */
    public double componenteH() {
        return longitud*Math.cos(angulo.radianes());
    }

    /**
     * Retorna el componente vertical de la velocidad
     * @return componente vertical de la velocidad
     */
    public double componenteV() {
        return longitud *Math.sin(angulo.radianes());
    }


    /**
     * Retorna el angulo de la velocidad
     * @return angulo de la velocidad
     */
    public Angulo angulo () {
        return angulo;
    }


    /**
     * Retorna la longitud de la velocidad
     * @return la longitud del origen al velocidad
     */
    public double longitud() {
        return longitud;
    }
    
    /**
     * Compara este velocidad con otro. Serán iguales si la distancia entre ellos es menor que MAXERROR
     * @param v el velocidad a comparar con este
     */
    private boolean equals (Velocidad v) {
        double distancia=Math.sqrt(Math.pow(componenteH()-v.componenteH(),2)+(Math.pow(componenteV()-v.componenteH(),2)));
        if (distancia<MAXERROR){
            return true;
        }
        return false;
    }

    /** 
     * Compara si este velocidad es igual al parametro (debe ser tambien un velocidad)
     * (Es el método que usa JUnit)
     */
    @Override
    public boolean equals (Object v) {
            Velocidad v2 = (Velocidad) v;
            return equals (v2) ;
    }
    

    /**
     * Rota el velocidad el angulo dado, con respecto al origen. 
     * Es decir que el angulo resultante, es la suma del angulo dado con el angulo inicial de la velocidad, 
     * y la distancia es la misma.
     */
    public void rote(Angulo a) {
    }
    
    /**
     * Suma esta velocidad con otra. Retorna una nueva velocidad
     * @param v velocidad a sumar
     * @return this + a
     */
    public  void sume(Velocidad v){
        double sumaX=(angulo.coseno()*longitud)+(v.angulo.coseno()*v.longitud);
        double sumaY=(angulo.seno()*longitud)+(v.angulo.seno()*v.longitud);
        longitud=Math.sqrt(Math.pow(sumaX,2)+Math.pow(sumaY,2));
        angulo=new Angulo(Math.acos(sumaX/longitud),Angulo.RADIANES);
    }
    
    /**
     * Resta esta velocidad con otra. Retorna una nueva velocidad
     * @param v velocidad a restar
     * @return this + a
     */
    public void reste(Velocidad v){
        double restaX=(this.angulo.coseno()*this.longitud)-(v.angulo.coseno()*v.longitud);
        double restaY=(this.angulo.seno()*this.longitud)-(v.angulo.seno()*v.longitud);
        System.out.println(restaX+"  "+restaY);
        longitud=Math.sqrt(Math.pow(restaX,2)+Math.pow(restaY,2));
        angulo=new Angulo(Math.acos(restaX/longitud),Angulo.RADIANES);        
    }
    
    /**
     * Calcula el producto escalar de un vector
     * @param operando
     * @return numEscalar producto escalar
     */
    public void escalar(int operando){
        double u=operando*componenteH();
        double v=operando*componenteV();
        longitud=Math.sqrt(Math.pow(u,2)+Math.pow(v,2));
        angulo= new Angulo(Math.atan(v/u),angulo.RADIANES);
    }    
    
    /**
     * Calcula el producto vectorial 
     * @param velocidad
     * @return vector vector nuevo del producto vectorial 
     */
    public void vectorial(Velocidad v){
    }
    
    //Adicione los métodos que requiera
    
    /** 
     * Retorna una cadena que describe a este velocidad (en componentes polares)
     */
    @Override
    public String toString () {
          String s =String.valueOf(longitud);
          String a=String.valueOf(angulo.grados());
          return "r="+s+" grados="+a;
    }

}
