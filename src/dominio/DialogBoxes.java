package dominio;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class DialogBoxes {
    static ComplexNumber.ComplexType answer;

    public static ComplexNumber.ComplexType chooseCNType() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Suma de números complejos");
        window.setMinWidth(450);
        window.setMinHeight(150);

        Label label = new Label("Por favor, elija qué tipo de número complejo desea ingresar para la operación");

        Button binomicButton = new Button("Binómico");
        binomicButton.setOnAction(e -> {
            answer = ComplexNumber.ComplexType.BINOMICO;
            window.close();
        });

        Button polarButton = new Button("Polar");
        polarButton.setOnAction(e -> {
            answer = ComplexNumber.ComplexType.POLAR;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, binomicButton, polarButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

    public static double insertComplexFirstPart(ComplexNumber.ComplexType type) {
        AtomicReference<Double> a = new AtomicReference<>((double) 0);

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        if(type == ComplexNumber.ComplexType.BINOMICO)
            window.setTitle("Parte real");
        else
            window.setTitle("Módulo");

        window.setMinWidth(300);
        window.setMinHeight(100);

        TextField complexInput = new TextField();
        Button bAccept = new Button("Aceptar");

        bAccept.setOnAction(e -> {
            if (isDouble(complexInput.getText()))
                a.set(Double.parseDouble(complexInput.getText()));
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10,10 ));
        layout.getChildren().addAll(complexInput, bAccept);

        Scene scene = new Scene(layout, 300, 100);
        window.setScene(scene);
        window.showAndWait();

        return a.get();
    }

    public static double insertComplexSecondPart(ComplexNumber.ComplexType type) {
        AtomicReference<Double> b = new AtomicReference<>((double) 0);
        Button bAccept;
        Scene scene;

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(300);
        window.setMinHeight(100);

        TextField complexInput = new TextField();
        bAccept = new Button("Aceptar");

        if(type == ComplexNumber.ComplexType.BINOMICO)
            window.setTitle("Parte imaginaria");
        else
            window.setTitle("Argumento");

        bAccept.setOnAction(e -> {
            if (isDouble(complexInput.getText()))
                b.set(Double.parseDouble(complexInput.getText()));
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10,10 ));
        layout.getChildren().addAll(complexInput, bAccept);

        scene = new Scene(layout, 300, 100);
        window.setScene(scene);
        window.showAndWait();

        return b.get();
    }

    public static void showComplexNumber(ComplexNumber complexNumber) {
        Scene scene1, scene2;

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Resultado");
        window.setMinWidth(200);
        window.setMinHeight(100);


        //Layout1
        Label label1 = new Label("El resultado de la operación es:");
        Label label2 = new Label(complexNumber.showAsBinomic());

        Button bPolar = new Button("Polar");
        bPolar.setMinWidth(70);
        bPolar.setAlignment(Pos.BOTTOM_CENTER);

        VBox layout1 = new VBox(10);
        layout1.setPadding(new Insets(10, 10, 10,10 ));
        layout1.getChildren().addAll(label1, label2, bPolar);
        scene1 = new Scene(layout1, 200, 100);


        //Layout2
        Label label3 = new Label("El resultado de la operación es:");
        Label label4 = new Label(complexNumber.showAsPolar());

        Button bBinomic = new Button("Binómico");
        bBinomic.setMinWidth(70);
        bBinomic.setAlignment(Pos.CENTER);

        VBox layout2 = new VBox(10);
        layout2.setPadding(new Insets(10, 10, 10,10 ));
        layout2.getChildren().addAll(label3, label4, bBinomic);
        scene2 = new Scene(layout2, 200, 100);


        bPolar.setOnAction(e -> window.setScene(scene2));
        bBinomic.setOnAction(e -> window.setScene(scene1));

        window.setScene(scene1);
        window.showAndWait();
    }

    public static double insertExponent() {
        //double exp;
        AtomicReference<Double> exp = new AtomicReference<>((double) 0);

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Exponente");

        window.setMinWidth(300);
        window.setMinHeight(100);

        TextField complexInput = new TextField();
        Button bAccept = new Button("Aceptar");

        bAccept.setOnAction(e -> {
            if (isDouble(complexInput.getText()))
                exp.set(Double.parseDouble(complexInput.getText()));
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10,10 ));
        layout.getChildren().addAll(complexInput, bAccept);

        Scene scene = new Scene(layout, 300, 100);
        window.setScene(scene);
        window.showAndWait();

        return exp.get();
    }

    public static double insertIndex() {
        AtomicReference<Double> index = new AtomicReference<>((double) 0);

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Índice");

        window.setMinWidth(300);
        window.setMinHeight(100);

        TextField complexInput = new TextField();
        Button bAccept = new Button("Aceptar");

        bAccept.setOnAction(e -> {
            if (isDouble(complexInput.getText()))
                index.set(Double.parseDouble(complexInput.getText()));
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10,10 ));
        layout.getChildren().addAll(complexInput, bAccept);

        Scene scene = new Scene(layout, 300, 100);
        window.setScene(scene);
        window.showAndWait();

        return index.get();
    }

    public static void showListComplexNumber(List<ComplexNumber> listComplexNumbers) {
        Scene scene1, scene2;
        int height = 0;

        switch(listComplexNumbers.size()) {
            case 1:
                height = 100;
                break;
            case 2:
                height = 130;
                break;
            case 3:
                height = 155;
                break;
            case 4:
                height = 180;
                break;
            case 5:
                height = 210;
                break;
            default:
                height = 350;
                break;
        }

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Resultado");
        window.setMinWidth(200);
        window.setMinHeight(height);


        //Layout1
        Label label1 = new Label("El resultado de la operación es:");
        List<Label> listBinomicLabel = new ArrayList<Label>();

        Button bPolar = new Button("Polar");
        bPolar.setMinWidth(70);
        bPolar.setAlignment(Pos.BOTTOM_CENTER);

        VBox layout1 = new VBox(10);
        layout1.setPadding(new Insets(10, 10, 10,10 ));
        layout1.getChildren().add(label1);

        for(int i = 0; i < listComplexNumbers.size(); i++) {
            listBinomicLabel.add(new Label(listComplexNumbers.get(i).showAsBinomic()));
            layout1.getChildren().add(listBinomicLabel.get(i));
        }

        layout1.getChildren().add(bPolar);

        scene1 = new Scene(layout1, 200, height);


        //Layout2
        Label label2 = new Label("El resultado de la operación es:");
        List<Label> listPolarLabel = new ArrayList<Label>();

        Button bBinomic = new Button("Binómico");
        bBinomic.setMinWidth(70);
        bBinomic.setAlignment(Pos.CENTER);

        VBox layout2 = new VBox(10);
        layout2.setPadding(new Insets(10, 10, 10,10 ));
        layout2.getChildren().add(label2);

        for(int i = 0; i < listComplexNumbers.size(); i++) {
            listPolarLabel.add(new Label(listComplexNumbers.get(i).showAsPolar()));
            layout2.getChildren().add(listPolarLabel.get(i));
        }

        layout2.getChildren().add(bBinomic);

        scene2 = new Scene(layout2, 200, height);


        bPolar.setOnAction(e -> window.setScene(scene2));
        bBinomic.setOnAction(e -> window.setScene(scene1));

        window.setScene(scene1);
        window.showAndWait();
    }

    public static boolean isDouble(String value) {
        try {
            double a = Double.parseDouble(value);
            return true;
        } catch(NumberFormatException e) {
            //VENTANA DE ERROR
            return false;
        }
    }

}
