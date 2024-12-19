import java.util.Scanner;
import java.util.ArrayList;

public class Actividad7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> resultados = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese una operación matemática (ejemplo: 5 + 3) o 'salir' para terminar:");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("salir")) {
                continuar = false;
            } else {
                try {
                    // Extraer los operandos y el operador
                    String[] partes = entrada.split(" ");
                    double operando1 = Double.parseDouble(partes[0]);
                    String operador = partes[1];
                    double operando2 = Double.parseDouble(partes[2]);

                    // Realizar la operación según el operador
                    double resultado = 0;
                    switch (operador) {
                        case "+":
                            resultado = sumar(operando1, operando2);
                            break;
                        case "-":
                            resultado = restar(operando1, operando2);
                            break;
                        case "*":
                            resultado = multiplicar(operando1, operando2);
                            break;
                        case "/":
                            if (operando2 == 0) {
                                throw new ArithmeticException("No se puede dividir entre cero.");
                            }
                            resultado = dividir(operando1, operando2);
                            break;
                        case "^":
                            resultado = potencia(operando1, (int) operando2);
                            break;
                        default:
                            throw new IllegalArgumentException("Operador no válido.");
                    }

                    // Almacenar el resultado en el arreglo
                    resultados.add(resultado);
                    System.out.println("Resultado: " + resultado);

                } catch (NumberFormatException e) {
                    System.out.println("Error: Por favor, ingrese números válidos.");
                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        // Mostrar todos los resultados almacenados
        System.out.println("Resultados almacenados:");
        for (Double res : resultados) {
            System.out.println(res);
        }

        scanner.close();
    }

    // Métodos para las operaciones básicas
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }

    // Método recursivo para el cálculo de la potencia
    public static double potencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente < 0) {
            return 1 / potencia(base, -exponente);
        } else {
            return base * potencia(base, exponente - 1);
        }
    }
}