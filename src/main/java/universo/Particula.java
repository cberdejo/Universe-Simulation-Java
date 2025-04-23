package universo;

import rectas.Punto;
import rectas.Vector;

public class Particula{
    private Punto posicion;
    private double masa;
    private double radio;
    private Vector velocidad;

    private static final double G = 6.67E-11;

    /** Constructor de particula
     *
     * @param pos Posicion inicial de la particula
     * @param vel La velocidad inicial de la particula
     * @param m Masa de la particula
     * @param r Radio dela particula
     */
    public Particula (Punto pos, Vector vel, double m, double r){
        posicion=pos;
        velocidad=vel;
        masa=m;
        radio=r;
    }

    /** Obtener la posicion
     *
     * @return La posicion de la particula
     */
    public Punto posicion(){
        return posicion;
    }

    /** Obtener radio
     *
     * @return El radio de la particula
     */
    public double radio(){
        return radio;
    }

    /**  Calcular la fuerza	de atracción que ejerce la	partícula part sobre la	receptora
     *
     * @param p La otra particula
     * @return Vector fuerza atraccion
     */


    public Vector fuerzaDesde(Particula p){

        Vector direccion = new Vector(this.posicion, p.posicion());

        // Cálculo de la distancia
        double distancia = direccion.modulo();

        // Cálculo del vector unitarios
        Vector u12 = direccion.direccion();

        // Cálculo de la fuerza usando la fórmula
        double fuerza = (G * this.masa * p.masa) / Math.pow(distancia, 2);

        // Devolver la fuerza como un vector en la dirección de u12
        return u12.escalar(fuerza);
    }

    /** Aplicar	una	fuerza a la partícula durante un tiempo
     *
     * @param vz Fuerza que se le aplica a la particula
     * @param dt El intervalo de tiempo durante el cual se aplica la fuerza
     */
    public void mueve(Vector vz, double dt) {
        // Cálculo de la aceleración a = F / m
        Vector aceleracion = vz.escalar(1 / masa);
        // Nueva velocidad de la particula
        this.velocidad = this.velocidad.sum(aceleracion.escalar(dt));
        // Nueva posicion de la particula

        this.posicion = new Punto(posicion.x() + velocidad.x() * dt, posicion.y() + velocidad.y() * dt);
    }


    /** Representacion de los atributos de la particula
     *
     * @return Cadena con los atributos de la particula
     */
    @Override
    public String toString() {
        return "Particula{" +
                "posicion=" + posicion +
                ", velocidad=" + velocidad +
                ", masa=" + masa +
                ", radio=" + radio +
                '}';
    }

}



