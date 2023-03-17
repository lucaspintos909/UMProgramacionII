package practicos.practico05;

public class Recursividad {
    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static double potencia(double valor, int potencia) {
        if (potencia == 0) {
            return 1;
        } else {
            return valor * potencia(valor, potencia - 1);
        }
    }

    public static int sumN(int num) {
        if (num == 0) {
            return 0;
        } else {
            return num + sumN(num - 1);
        }
    }

    public static void main(String[] args) {
        int fact6 = factorial(6);
        double pote = potencia(4, 9);
        double suma = sumN(9);

        System.out.println("Factorial de !6: " + fact6);
        System.out.println("Potencia de 4⁹: " + pote);
        System.out.println("SumN de 9: " + suma);
    }
}
