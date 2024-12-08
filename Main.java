import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static double trapezoidalIntegration(Function<Double, Double> func, double a, double b, int n) {
        double h = (b - a) / n;
        double integral = 0.5 * (func.apply(a) + func.apply(b));

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            integral += func.apply(x);
        }

        return integral * h;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите границы интегрирования (a и b): ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        System.out.println("Введите количество разбиений (n): ");
        int n = scanner.nextInt();

        Function<Double, Double> func = x -> Math.pow(x, 2); // f(x) = x^2

        double result = trapezoidalIntegration(func, a, b, n);

        System.out.println("Результат интегрирования методом трапеций: " + result);
    }
}
