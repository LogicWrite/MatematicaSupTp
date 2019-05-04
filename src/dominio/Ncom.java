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
        bMultiply.setOnAction(ev -> {
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

            DialogBoxes.showComplexNumber(complexNumber1.multiply(complexNumber2));
        });

        bDivide = new Button("Dividir");
        bDivide.setMinWidth(250);
        bDivide.setOnAction(ev -> {
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

            DialogBoxes.showComplexNumber(complexNumber1.divide(complexNumber2));
        });

        bPow = new Button("Potencia");
        bPow.setMinWidth(250);
        bPow.setOnAction(ev -> {
            ComplexNumber.ComplexType type;
            ComplexNumber complexNumber;
            double exponent;

            type = DialogBoxes.chooseCNType();
            a = DialogBoxes.insertComplexFirstPart(type);
            b = DialogBoxes.insertComplexSecondPart(type);
            complexNumber = new ComplexNumber(a, b, type);

            exponent = DialogBoxes.insertExponent();

            DialogBoxes.showComplexNumber(complexNumber.pow(exponent));
        });

        bRoot = new Button("Radicación");
        bRoot.setMinWidth(250);
        bRoot.setOnAction(ev -> {
            ComplexNumber.ComplexType type;
            ComplexNumber complexNumber;
            double index;

            type = DialogBoxes.chooseCNType();
            a = DialogBoxes.insertComplexFirstPart(type);
            b = DialogBoxes.insertComplexSecondPart(type);
            complexNumber = new ComplexNumber(a, b, type);

            index = DialogBoxes.insertIndex();

            DialogBoxes.showListComplexNumber(complexNumber.root(index));
        });

        bCalcRoot = new Button("Cálculo de raíces n-ésimas y primitivas");
        bCalcRoot.setMinWidth(250);
        bSumPhasor = new Button("Suma de Fasores");
        bSumPhasor.setMinWidth(250);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(bSum, bSubtract, bMultiply, bDivide, bPow, bRoot, bCalcRoot, bSumPhasor);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 320, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
