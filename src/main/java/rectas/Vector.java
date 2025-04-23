package rectas;

public record Vector(Punto extremo) {

    private static final double EPSILON = 0.000001;

    /**
     * Constructor que inicializa un vector desde el origen (0,0) hasta el punto
     * (x, y).
     *
     * @param x Coordenada x del extremo del vector.
     * @param y Coordenada y del extremo del vector.
     */
    public Vector(double x, double y) {
        this(new Punto(x, y));
    }

    /**
     * Constructor que crea un vector desde un punto origen hasta un punto extremo.
     *
     * @param origen  Punto de origen del vector.
     * @param extremo Punto de extremo del vector.
     */
    public Vector(Punto origen, Punto extremo) {
        this(new Punto(extremo.x() - origen.x(), extremo.y() - origen.y()));
    }

    /**
     * Suma el vector actual con otro vector dado.
     *
     * @param v El vector a sumar.
     * @return Un nuevo vector resultado de la suma.
     */
    public Vector sum(Vector v) {
        return new Vector(this.x() + v.x(), this.y() + v.y());
    }

    /**
     * Retorna un vector ortogonal (rotado 90 grados en sentido antihorario).
     *
     * @return Un nuevo vector ortogonal al actual.
     */
    public Vector ortogonal() {
        return new Vector(-y(), x());
    }

    /**
     * Verifica si el vector actual es paralelo a otro vector dado.
     *
     * @param otro El vector a comparar.
     * @return `true` si los vectores son paralelos, `false` en caso contrario.
     */
    public boolean esParaleloA(Vector otro) {
        return Math.abs(this.x() * otro.y() - this.y() * otro.x()) < EPSILON;
    }

    /**
     * Calcula y retorna el módulo del vector.
     *
     * @return El módulo del vector.
     */
    public double modulo() {
        return Math.sqrt(x() * x() + y() * y());

    }

    /**
     * Retorna un vector unitario en la misma dirección y sentido del vector actual.
     * @throws RuntimeException Si el módulo del vector es cero.
     * @return Un vector unitario en la dirección del vector actual.
     */
    public Vector direccion() {
        double modulo = modulo();
        if (modulo == 0) {
            throw new RuntimeException("El módulo del vector es cero, no se puede definir dirección.");
        }
        return new Vector(x() / modulo, y() / modulo);
    }

    /**
     * Calcula el extremo del vector cuando el origen se coloca en un punto dado.
     *
     * @param org El punto de origen desde el cual calcular el nuevo extremo.
     * @return Un nuevo punto que representa el extremo del vector desde el origen
     *         dado.
     */
    public Punto extremoDesde(Punto org) {
        return new Punto(org.x() + x(), org.y() + y());
    }

    /**
     * Obtiene la componente x del vector.
     *
     * @return La coordenada x del extremo del vector.
     */
    public double x() {
        return extremo.x();
    }

    /**
     * Obtiene la componente y del vector.
     *
     * @return La coordenada y del extremo del vector.
     */
    public double y() {
        return extremo.y();
    }

    /**
     * Calcula la diferencia entre este vector y otro vector dado.
     * Devuelve un nuevo vector que representa la resta (este vector - otro).
     *
     * @param otro El vector a restar del vector actual.
     * @return Un nuevo vector que es la diferencia entre este vector y el otro vector.
     */
    public Vector dif(Vector otro) {
        return new Vector(new Punto(this.x() - otro.x(), this.y() - otro.y()));
    }

    /**
     * Escala el vector actual por un valor escalar dado.
     * Devuelve un nuevo vector que es el resultado de multiplicar cada componente por el escalar.
     *
     * @param factor El factor escalar por el cual multiplicar el vector.
     * @return Un nuevo vector que es el resultado de escalar este vector por el factor dado.
     */
    public Vector escalar(double factor) {
        return new Vector(new Punto(this.x() * factor, this.y() * factor));
    }

    /**
     * Representación en cadena del vector.
     *
     * @return Una cadena que describe el vector en formato "(x, y)".
     */
    @Override
    public String toString() {
        return "Vector(" + extremo.x() + ", " + extremo.y() + ")";
    }
}
