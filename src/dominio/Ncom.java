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
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ncom extends Application {
    Stage window;
    //Button bSum, bSubtract, bMultiply, bDivide, bPow, bRoot, bCalcRoot, bSumPhasor, bMinusPhasor;
    Button bSum, bSubtract, bMultiply, bDivide, bPow, bRoot, bSumPhasor, bMinusPhasor;
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

            //exponent = DialogBoxes.insertExponent();
            exponent = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.EXPONENT);

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

            //index = DialogBoxes.insertIndex();
            index = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.INDEX);

            DialogBoxes.showListComplexNumber(complexNumber.raicesPrimitivas(index), complexNumber.raicesNoPrimitivas(index));
            //DialogBoxes.showListComplexNumber(complexNumber.root(index));
        });

        //bCalcRoot = new Button("Cálculo de raíces n-ésimas y primitivas");
        //bCalcRoot.setMinWidth(250);

        bSumPhasor = new Button("Suma de Fasores");
        bSumPhasor.setMinWidth(250);
        bSumPhasor.setOnAction(ev -> {
            FuncionTrigonometrica funcionTrigonometrica1, funcionTrigonometrica2;
            double amplitude1, amplitude2;
            double frequency1, frequency2;
            double phase1, phase2;
            Fasor phasor1, phasor2;

            funcionTrigonometrica1 = DialogBoxes.chooseFunction();
            amplitude1 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.AMPLITUDE);
            frequency1 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.FREQUENCY);
            phase1 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.PHASE);

            phasor1 = new Fasor(amplitude1, funcionTrigonometrica1, frequency1, phase1);

            funcionTrigonometrica2 = DialogBoxes.chooseFunction();
            amplitude2 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.AMPLITUDE);
            frequency2 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.FREQUENCY);
            phase2 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.PHASE);

            phasor2  = new Fasor(amplitude2, funcionTrigonometrica2, frequency2, phase2);

            //System.out.println(funcionTrigonometrica1 + " " + amplitude1 + " " + frequency1 + " " + phase1);
            //System.out.println(funcionTrigonometrica2 + " " + amplitude2 + " " + frequency2 + " " + phase2);

            DialogBoxes.showPhasor(phasor1.plus(phasor2));
        });

        bMinusPhasor = new Button("Resta de Fasores");
        bMinusPhasor.setMinWidth(250);
        bMinusPhasor.setOnAction(ev -> {
            FuncionTrigonometrica funcionTrigonometrica1, funcionTrigonometrica2;
            double amplitude1, amplitude2;
            double frequency1, frequency2;
            double phase1, phase2;
            Fasor phasor1, phasor2;

            funcionTrigonometrica1 = DialogBoxes.chooseFunction();
            amplitude1 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.AMPLITUDE);
            frequency1 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.FREQUENCY);
            phase1 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.PHASE);

            phasor1 = new Fasor(amplitude1, funcionTrigonometrica1, frequency1, phase1);

            funcionTrigonometrica2 = DialogBoxes.chooseFunction();
            amplitude2 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.AMPLITUDE);
            frequency2 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.FREQUENCY);
            phase2 = DialogBoxes.insertDouble(DialogBoxes.InsertionOption.PHASE);

            phasor2  = new Fasor(amplitude2, funcionTrigonometrica2, frequency2, phase2);

            DialogBoxes.showPhasor(phasor1.minus(phasor2));
        });

        VBox layout = new VBox(10);
        //layout.getChildren().addAll(bSum, bSubtract, bMultiply, bDivide, bPow, bRoot, bCalcRoot, bSumPhasor, bMinusPhasor);
        layout.getChildren().addAll(bSum, bSubtract, bMultiply, bDivide, bPow, bRoot, bSumPhasor, bMinusPhasor);
        layout.setAlignment(Pos.CENTER);

        //Scene scene = new Scene(layout, 320, 300);
        Scene scene = new Scene(layout, 280, 290);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
