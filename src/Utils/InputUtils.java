package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
    public static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                int entero = scanner.nextInt();
                scanner.nextLine(); // Añadimos estos scanners, por que .nexInt y .nextDouble
                                    // Dejan \n en buffer, y esto ocasiona errores en ocasiones,
                                    // añadiendo estos scanner extras los "consumimos".
                return entero;
            } catch (InputMismatchException e) {
                System.out.print("Entrada no válida. Por favor, ingrese un número entero: ");
                scanner.nextLine();
            }
        }
    }

    public static double leerDouble(Scanner scanner) {
        while (true) {
            try {
                double doble = scanner.nextDouble();
                scanner.nextLine();
                return doble;
            } catch (InputMismatchException e) {
                System.out.print("Entrada no válida. Por favor, ingrese un número decimal: ");
                scanner.nextLine();
            }
        }
    }
}
