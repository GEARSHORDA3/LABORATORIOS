/**
 * Esta clase sirve para manejar angulos. 
 * La medida de los ángulos podrá especificarse en grados o radianes
 * y podrá solicitarse en cualquiera de estas unidades, independientemente de con cual hayan sido creados.
 * Internamente se harán las conversiones que sean necesarias para mantenerlos en grados
 * Lo trabajaremos mediante objetos inmutables, es decir, sin métodos modificadores. 
 * @author ECI, 
 */
public class Angulo {

	/** Constantes para indicar que el argumento está en radianes */
	public static final int RADIANES = 0;
	/** Constantes para indicar que el argumento está en grados */
	public static final int GRADOS = 1;


	/** Constante para maximo error admitido al comparar dos angulos.  
	 *  Recuerde que los cálculos en el computador con variables de plunto flotante
	 *  tienen una precisión limitada, y se requiere un margen de tolerancia
	 */
    public static final double MAXERROR = 0.00000000000001;

    private double grados;
    
	/** Crea un angulo a partir del valor dado en grados o en radianes
	 * @param valor el valor de medida del angulo
	 * @param tipo Tipo de medida del angulo: puede ser GRADOS, RADIANES, GRADIANES
	 */
	public Angulo (double valor, int tipo){
	}
	
	/**Valor del angulo en grados
	 * @return el valor del angulo en grados, 0 <= result < 360
	 */
	public double grados () {
		return 0.0;
	}
	
	/**Valor del angulo en radianes
	 * @return el valor del angulo en radianes, 0 <= result < 2*PI
	 */
	public double radianes () {
		return 0.0;
	}
	
	
	/**
	 * Suma este angulo con otro. Retorna un nuevo angulo
	 * @param a El angulo a sumar
	 * @return this + a
	 */
	public Angulo sume (Angulo ang) {
		return null;
	}

	/**
	 * Resta este angulo con otro. Retorna un nuevo angulo
	 * @param a El angulo a sumar
	 * @return this - a
	 */
	public Angulo reste (Angulo a) {
		return null;
	}

	/**
	 * Multiplica este angulo con otro. Retorna un nuevo angulo
	 * @param a El angulo a multiplicar
	 * @return this * a
	 */
	public Angulo multiplique (Angulo ang) {
		return null;
	}

	/**
	 * Divide este angulo con otro. Retorna un nuevo angulo
	 * @param a El angulo a dividir
	 * @return this / a
	 */
	public Angulo divida (Angulo a) {
		return null;
	}
	
	
	/**
	 * Multiplica esta angulo por un real
	 * @param r real para hacer el producto 
	 * @return r * this
	 */
	public Angulo multiplique (double r) {
		return null;
	}
	
	/**
	 * Compara a este angulo con otro, para ver si son iguales, 
	 * teniendo en cuenta el margen de error MAXERROR, dado que se trabaja con punto flotante
	 * @param a angulo para compararse
	 * @return |this - a| < MAXERROR
	 */
	public boolean equals (Angulo a) {
		return false;
	}
	
	/** overrides Object.equals()
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals (Object o) {
		Angulo a = (Angulo) o;
		return equals (a) ;
	}

	/**Calcula el seno
	 * @return el seno de este angulo
	 */
	public double seno () {
		return 0.0;
	}

	/**Calcula el coseno
	 * @return el coseno de este angulo
	 */
	public double coseno () {
		return 0.0;
	}

    /**
     * Retorna el valor del angulo en grados
     * @return the information of this object
     */
    public String toString() {
      return "";
    }
}
