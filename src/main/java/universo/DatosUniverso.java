package universo;

import rectas.Punto;
import rectas.Vector;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public record DatosUniverso(Universo universo, double dt, int sleep) {
    /// Lee e inicializa
    /// @param fichero Fichero de configuracion
    public static DatosUniverso leeDatos(String fichero) throws IOException {
        try (Scanner sc = new Scanner(new File(fichero))) {
            sc.useLocale(Locale.US);
            int numParticulas = sc.nextInt();
            double radioUniverso = sc.nextDouble();
            double dt = sc.nextDouble();
            int sleep = sc.nextInt();
            Particula[] particulas = new Particula[numParticulas];

            for (int i = 0; i < numParticulas; i++) {
                particulas[i] = leeParticula(sc);
            }

            return new DatosUniverso(new Universo(particulas, radioUniverso), dt, sleep);
        }
    }

    ///Método auxiliar que lee la particula y lanza excepción si hay error en el formato
    /// @param sc Scanner con el fichero
    /// @return Particula leida
    /// @throws InputMismatchException, NoSuchElementException en caso de que el formato sea incorrecto
    private static Particula leeParticula(Scanner sc) {

        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double velX = sc.nextDouble();
        double velY = sc.nextDouble();
        double masa = sc.nextDouble();
        double radio = sc.nextDouble();
        return new Particula(new Punto(x, y), new Vector(velX, velY), masa, radio);

    }
}
