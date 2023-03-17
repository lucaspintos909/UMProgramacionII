package practico0.clases;

public class Conversion {
    public static float conversionAFharenheit(int gradosCelsius) {

        float gradosFharenheit = (float) ((gradosCelsius * 1.8) + 32);

        return gradosFharenheit;
    }

    /*public static void main(String[] args) {
        int num = 40;
        float resultado = conversionAFharenheit(num);

        System.out.println(resultado);
    }*/
}
