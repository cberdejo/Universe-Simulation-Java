package rectas;

import java.util.Optional;

public record Recta(Vector vectorDirector,Punto punto ) {

    private static final double EPSILON = 0.000001;



    /** Constructor2 clase recta
     *
     * @param p1 Primer punto de la recta
     * @param p2 Segundo punto de la recta
     */
    public Recta(Punto p1, Punto p2) {
        this(new Vector(p1, p2),p1);
    }

    /** Comprueba si esta recta es paralela a otra recta
     *
     * @param r Otra recta
     * @return 'true' si son paralelas, 'false' si no lo son
     */
    public boolean esParalelaA (Recta r){
        return this.vectorDirector.esParaleloA(r.vectorDirector);
    }

    /** Calcula la ecuacion implicita de la recta
     *
     * @return Implicta que representa la acuacion implicita
     */
    public Implicita implicita() {
        double a = vectorDirector.y();
        double b = -vectorDirector.x();
        double c = - (a * punto.x() + b * punto.y());
        return new Implicita(a, b, c);
    }

    /** Calcula el determinante de una matriz 2x2
     *
     * @param a11 Primer elemento de la primera fila
     * @param a12 Segundo elemento de la primera fila
     * @param a21 Primer elemento de la segunda fila
     * @param a22 Segundo elemento de la segunda fila
     * @return El determinante
     */
    private double determinante(double a11, double a12, double a21, double a22) {
        return a11 * a22 - a12 * a21;
    }

    /** Calcula la interseccion con otra recta (si la hay)
     *
     * @param r Otra recta
     * @return Un `Optional<Punto>` que contiene el punto de intersección si las rectas se cruzan,
     *           o `Optional.empty()` si son paralelas y no tienen intersección.
     */
    public Optional<Punto> interseccionCon(Recta r) {

        double a1 = vectorDirector.y();
        double b1 = -vectorDirector.x();
        double c1 = -(a1 * punto.x() + b1 * punto.y());

        double a2 = r.vectorDirector.y();
        double b2 = -r.vectorDirector.x();
        double c2 = -(a2 * r.punto.x() + b2 * r.punto.y());


        double determinante = determinante(a1, b1, a2, b2);
        if (Math.abs(determinante) < EPSILON) {
            return Optional.empty();
        }

        double x = (b1 * c2 - b2 * c1) / determinante;
        double y = (a2 * c1 - a1 * c2) / determinante;

        return Optional.of(new Punto(x, y));
    }

    /** Nueva recta paralela a la original que pasa por un punto p
     *
     * @param p El punto por el que debe pasar la nueva recta
     * @return Nueva recta
     */
    public Recta paralelaPor(Punto p){
        return new Recta ( vectorDirector,p);
    }

    /** Nueva recta perpendicular a la actual que pasa por un punto p
     *
     * @param p Punto por el que debe pasar la nueva recta perpendicular
     * @return Nueva recta
     */
    public Recta perpendicularPor(Punto p){
        Vector vectorPerpendicular = new Vector(-vectorDirector.y(), vectorDirector.x());
        return new Recta(vectorPerpendicular,p);
    }

    /**Distancia desde un punto a la recta
     *
     * @param p El punto desde el cual se calcular la distancia
     * @return La distancia entre el punto y la recta
     */
    public double distanciaDesde (Punto p){
        Recta perpendicular = perpendicularPor(p);

        Optional<Punto> interseccion = this.interseccionCon(perpendicular);

        if (interseccion.isPresent()) {
            Punto puntoInterseccion = interseccion.get();
            return p.distancia(puntoInterseccion);
        }
        return -1; // si no hay interseccion
    }

    /** Obtener el punto base de la recta
     *
     * @return El punto base
     */
    public Punto punto() {
        return this.punto;
    }

    /**Comprueba si un punto esta en la recta
     *
     * @param p El punto a comprobar
     * @return `true` si el punto está en la recta; `false` en caso contrario.
     */
    public boolean contieneA(Punto p) {
        Implicita impl = this.implicita();
        return Math.abs(impl.a() * p.x() + impl.b() * p.y() + impl.c()) < EPSILON;
    }
}
