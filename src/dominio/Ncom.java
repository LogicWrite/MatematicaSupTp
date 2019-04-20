package dominio;
import javax.imageio.IIOException;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ncom {

    public static void main(String args[]){
        //Punto de entrada del programa
        /*TODO Aqui se inicializa la interfaz grafica*/
        System.out.println("Este es un alpha de un programa para trabajar con fasores y numeros complejos\n" +
                "Porfavor presione: 1. para ingresar un numero complejo en forma binomica\n" +
                "\t 2. para ingresar un numero complejo en forma polar");

        Scanner in = new Scanner(System.in);
        String input;

            ComplexNumber complexNumber;
            do {
                input = in.nextLine();
            } while (!input.equals("1") && !input.equals("2"));


            if (input.contains("1")) {
                System.out.println("Ingrese la parte real del numero complejo:");
                double a = Double.valueOf( in.nextLine());
                System.out.println("Ingrese la parte imaginaria del numero complejo:");
                double b = Double.valueOf( in.nextLine());
                complexNumber = new ComplexNumber(a, b, ComplexNumber.ComplexType.BINOMICO);
            } else {
                System.out.println("Ingrese el modulo del numero complejo:");
                double a = Double.valueOf( in.nextLine());
                System.out.println("Ingrese el argumento del numero complejo:");
                double b = Double.valueOf( in.nextLine());
                complexNumber = new ComplexNumber(a, b, ComplexNumber.ComplexType.POLAR);

            }

            System.out.println("presione 1 para obtener el numero ingresado en forma binomica, 2 en forma polar");
            input =  in.nextLine();

                if (input.contains("1")) {

                    System.out.println(complexNumber.showAsBinomic() + "\n");
                } else if (input.contains("2")) {
                    System.out.println(complexNumber.showAsPolar() + "\n");

                }






    }


}
