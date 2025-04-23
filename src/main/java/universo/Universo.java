package universo;

import rectas.Vector;

public class Universo {

    private Particula[] particulas;
    private double radio;

    /** Contrucctor clase Universo
     *
     * @param particulas Array de particulas que forman el universo
     * @param radio Radio del universo
     */

    public Universo (Particula[] particulas, double radio){
        this.particulas = particulas;
        this.radio = radio;
    }

    /** Devuelve el radio del universo
     *
     * @return El radio del universo
     */
    public double radio(){
        return radio;
    }

    /** Devuelve el array de particulas del universo
     *
     * @return Array de particulas
     */
    public Particula[] particulas(){
        return particulas;
    }

    /** Simular	como se	modifican las posiciones y velocidades de las partículas transcurrido un tiempo	dt.
     *  - Calcula la fuerza de atracción total ejercida sobre cada partícula por el resto de partículas.
     *  - Suma todas las fuerzas que actúan sobre cada partícula.
     *  - Actualiza la posición y velocidad de cada partícula en función de la fuerza resultante
     * @param dt Intervalo de tiempo
     */
    public void avanza(double dt){

        // Array para almacenar las fuerzas totales que actuan sobre cada particula
        Vector[] fuerzas = new Vector[particulas.length];

        // Inicializar las fuerzas del array en 0
        for (int i =0; i<particulas.length; i++){
            fuerzas[i] = new Vector(0,0);
        }
        // Calcular la fuerza de atraccion
        for (int i = 0; i < particulas.length; i++) {
            for (int j = i + 1; j < particulas.length; j++) {
                // Fuerza que la partícula j ejerce sobre la partícula i
                Vector fuerzaIJ = particulas[i].fuerzaDesde(particulas[j]);

                // Suma de la fuerza que actúa sobre la partícula i
                fuerzas[i] = fuerzas[i].sum(fuerzaIJ);

                // Suma de la fuerza en dirección opuesta que actúa sobre la partícula j
                fuerzas[j] = fuerzas[j].sum(fuerzaIJ.escalar(-1));
            }
        }
        // Mover cada partícula aplicando la fuerza total calculada y el tiempo dt
        for(int i =0; i <particulas.length; i++){
            particulas[i].mueve(fuerzas[i], dt);
        }
    }
}
