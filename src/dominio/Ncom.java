package dominio;

import javax.imageio.IIOException;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ncom extends Application {
    Stage window;
    Button bSum, bSubtract, bMultiply, bDivide, bPow, bRoot, bCalcRoot, bSumPhasor;
    double a, b;

    public static void main(String args[]) {
        //Punto de entrada del programa
        /*TODO Aqui se inicializa la interfaz grafica*/
        launch(args);


        /*System.out.println("Este es un alpha de un programa para trabajar con fasores y numeros complejos\n" +
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
          */
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Numeros Complejos");

        bSum = new Button("Sumar");
        bSum.setMinWidth(250);
        bSum.setOnAction(ev -> {
            ComplexNumber.ComplexType type;
            ComplexNumber complexNumber1, complexNumber2;

            type = DialogBoxes.chooseCNType();
            a = DialogBoxes.insertComplexFirstPart(type);
            b = DialogBoxes.insertComplexSecondPart(type);
            complexNumber1 = new ComplexNumber(a, b, type);

            type = DialogBoxes.chooseCNType();
            a = DialogBoxes.insertComplexFirstPart(type);
            b = DialogBoxes.insertComplexSecondPart(type);
            complexNumber2 = new ComplexNumber(a, b, type);

            DialogBoxes.showComplexNumber(complexNumber1.plus(complexNumber2));
        });

        bSubtract = new Button("Restar");
        bSubtract.setMinWidth(250);
        bSubtract.setOnAction(ev -> {
            ComplexNumber.ComplexType type;
            ComplexNumber complexNumber1, complexNumber2;

            type = DialogBoxes.chooseCNType();
            a = DialogBoxes.insertComplexFirstPart(type);
            b = DialogBoxes.insertComplexSecondPart(type);
            complexNumber1 = new ComplexNumber(a, b, type);

            type = DialogBoxes.chooseCNType();
            a = DialogBoxes.insertComplexFirstPart(type);
            b = DialogBoxes.insertComplexSecondPart(type);
            complexNumber2 = new ComplexNumber(a, b, type);

            DialogBoxes.showComplexNumber(complexNumber1.minus(complexNumber2));
        });

        bMultiply = new Button("Multiplicar");
        bMultiply.setMinWidth(250);

        bDivide = new Button("Dividir");
        bDivide.setMinWidth(250);

        bPow = new Button("Potencia");
        bPow.setMinWidth(250);
        bRoot = new Button("Radicación");
        bRoot.setMinWidth(250);

        bCalcRoot = new Button("Cálculo de raíces n-ésimas y primitivas");
        bCalcRoot.setMinWidth(250);
        bSumPhasor = new Button("Suma de Fasores");
        bSumPhasor.setMinWidth(250);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(bSum, bSubtract, bMultiply, bDivide, bPow, bRoot, bCalcRoot, bSumPhasor);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 280, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
