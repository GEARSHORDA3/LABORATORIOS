
/**
 * @author ECI, 2017
 *
 */
public class Vector{

    public static final double MAXERROR = 0.00000000000001;
    private double longitud;
    private Angulo angulo;
    
    /**
     * Constructor del vector, en coordenadas polares
     * @param d longitud del vector
     * @param a angulo del vector
     */
    public Vector(double l, Angulo a) {
        longitud=l;
        angulo=a;
    }
   
    /**
     * Retorna la coordenada X del vector
     * @return coordenada X del vector
     */
    public double coordenadaX() {
        return longitud*Math.cos(angulo.radianes());
    }

    /**
     * Retorna la coordenada Y del Vector
     * @return coordenada Y del vector
     */
    public double coordenadaY() {
        return longitud*Math.sin(angulo.radianes());
    }


    /**
     * Retorna el angulo del vector
     * @return angulo del vector
     */
    public Angulo angulo () {
        return angulo;
    }


    /**
     * Retorna la longitud del vector
     * @return la longitud del origen al vector
     */
    public double longitud() {
        return longitud;
    }
    
    /**
     * Retorna la distancia entre este vector y otro vector
     * @return distancia del origen al vector
     */
    public double distancia(Vector otro) {
        double dis=Math.sqrt((Math.pow(otro.coordenadaX()-this.coordenadaX(),2))+(Math.pow(otro.coordenadaY()-this.coordenadaY(),2)));
        return dis;
    }
    
    /**
     * Compara este vector con otro. Serán iguales si la distancia entre ellos es menor que MAXERROR
     * @param v el vector a comparar con este
     * @return comparacion entre dos vectores
     */
    private boolean equals (Vector v) {
        return distancia(v)<MAXERROR;
    }

    /** 
     * Compara si este Vector es igual al parametro (debe ser tambien un vector)
     * @return comparacion entre dos vectores
     */
    @Override
    public boolean equals (Object o) {
        return this.equals((Vector) o);
    }
    
    /**
     * Translada el vector, dados los desplazamientos en x, y
     * @param dx Desplazamiento en el eje x
     * @param dy Desplazamiento en el eje Y
     */
    public void traslade (double dx, double dy) {
        longitud = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
        angulo = new Angulo(Math.atan(dy/dx),angulo.RADIANES);
    }
    
    /**
     * Calcula el producto escalar
     * @param escalar El factor de multiplicación de la distancia respecto al centro.
     */
    public void productoEscalar(double escalar) {
        traslade(coordenadaX()*escalar,coordenadaY()*escalar);
    }

    /**
     * Rota el vector el angulo dado, con respecto al origen. 
     * Es decir que el angulo resultante, es la suma del angulo dado con el angulo inicial del vector, 
     * y la distancia es la misma.
     * @param angulo
     */
    public void rote(Angulo a) {
        angulo=angulo.sume(a);
    }
    
    /**
     * Suma dos vectores
     * @param otro vector
     */
    public  void  sume(Vector v){
        double i=(this.angulo.coseno()*this.longitud)+(v.angulo.coseno()*v.longitud);
        double j=(this.angulo.seno()*this.longitud)+(v.angulo.seno()*v.longitud);
        longitud=Math.sqrt(Math.pow(i,2)+Math.pow(j,2));
        angulo=new Angulo (Math.acos(i/longitud),Angulo.RADIANES);
    }
    
    /**
     * Resta dos vectores
     * @param otro vector
     */
    public void reste(Vector v){
        double i=(this.angulo.coseno()*this.longitud)-(v.angulo.coseno()*v.longitud);
        double j=(this.angulo.seno()*this.longitud)-(v.angulo.seno()*v.longitud);
        longitud=Math.sqrt(Math.pow(i,2)+Math.pow(j,2));
        angulo=new Angulo (Math.acos(i/longitud),Angulo.RADIANES);
    }
    
    /**
     * Multiplica dos vectores
     * Se multiplica el producto punto al vector
     * @param otro vector
     */
    public void multiplique(Vector v){
        double escalar = (this.coordenadaX()*v.coordenadaX())+(this.coordenadaY()*v.coordenadaY());
        productoEscalar(escalar);
    }
    
    
    /** 
     * Retorna una cadena que describe a este vector (en coordenadas polares)
     */
    @Override
    public String toString () {
          String s =String.valueOf(longitud);
          String a=String.valueOf(angulo.grados());
          return "r="+s+" grados="+a;
    }

}
