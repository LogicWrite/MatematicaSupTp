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
    //static ComplexNumber.ComplexType answer;
    //static FuncionTrigonometrica function;

    public static ComplexNumber.ComplexType chooseCNType() {
        AtomicReference<ComplexNumber.ComplexType> answer = new AtomicReference<>();

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Suma de números complejos");
        window.setMinWidth(450);
        window.setMinHeight(150);

        Label label = new Label("Por favor, elija qué tipo de número complejo desea ingresar para la operación");

        Button binomicButton = new Button("Binómico");
        binomicButton.setMinWidth(70);
        binomicButton.setOnAction(e -> {
            answer.set(ComplexNumber.ComplexType.BINOMICO);
            window.close();
        });

        Button polarButton = new Button("Polar");
        polarButton.setMinWidth(70);
        polarButton.setOnAction(e -> {
            answer.set(ComplexNumber.ComplexType.POLAR);
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, binomicButton, polarButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer.get();
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

    public static void showListComplexNumber(List<ComplexNumber> listPrimitiveRoots,
                                             List<ComplexNumber> listNonPrimitiveRoots) {
        Scene scene1, scene2;
        int height = 0;

        switch(listPrimitiveRoots.size() + listNonPrimitiveRoots.size()) {
            case 1:
                //height = 100;
                height = 150;
                break;
            case 2:
                //height = 130;
                height = 180;
                break;
            case 3:
                //height = 155;
                height = 205;
                break;
            case 4:
                //height = 180;
                height = 240;
                break;
            case 5:
                //height = 210;
                height = 260;
                break;
            default:
                //height = 350;
                height = 420;
                break;
        }

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Resultado");
        window.setMinWidth(200);
        window.setMinHeight(height);


        //Layout1 - Forma Binómica
        Label label1 = new Label("El resultado de la operación es:");
        Label labelPrimitive = new Label("Raíces primitivas:");
        List<Label> listBinomicLabel1 = new ArrayList<Label>();
        Label labelNonPrimitive = new Label("Raíces no primitivas:");
        List<Label> listBinomicLabel2 = new ArrayList<Label>();

        Button bPolar = new Button("Polar");
        bPolar.setMinWidth(70);
        bPolar.setAlignment(Pos.BOTTOM_CENTER);

        VBox layout1 = new VBox(10);
        layout1.setPadding(new Insets(10, 10, 10,10 ));
        layout1.getChildren().add(label1);
        layout1.getChildren().add(labelPrimitive);

        for(int i = 0; i < listPrimitiveRoots.size(); i++) {
            listBinomicLabel1.add(new Label(listPrimitiveRoots.get(i).showAsBinomic()));
            layout1.getChildren().add(listBinomicLabel1.get(i));
        }

        layout1.getChildren().add(labelNonPrimitive);

        for(int i = 0; i < listNonPrimitiveRoots.size(); i++) {
            listBinomicLabel2.add(new Label(listNonPrimitiveRoots.get(i).showAsBinomic()));
            layout1.getChildren().add(listBinomicLabel2.get(i));
        }

        layout1.getChildren().add(bPolar);

        scene1 = new Scene(layout1, 200, height);


        //Layout2 - Forma Polar
        Label label2 = new Label("El resultado de la operación es:");
        Label labelPrimitive2 = new Label("Raíces primitivas:");
        List<Label> listPolarLabel1 = new ArrayList<Label>();
        Label labelNonPrimitive2 = new Label("Raíces no primitivas:");
        List<Label> listPolarLabel2 = new ArrayList<Label>();

        Button bBinomic = new Button("Binómico");
        bBinomic.setMinWidth(70);
        bBinomic.setAlignment(Pos.CENTER);

        VBox layout2 = new VBox(10);
        layout2.setPadding(new Insets(10, 10, 10,10 ));
        layout2.getChildren().add(label2);
        layout2.getChildren().add(labelPrimitive2);

        for(int i = 0; i < listPrimitiveRoots.size(); i++) {
            listPolarLabel1.add(new Label(listPrimitiveRoots.get(i).showAsPolar()));
            layout2.getChildren().add(listPolarLabel1.get(i));
        }

        layout2.getChildren().add(labelNonPrimitive2);

        for(int i = 0; i < listNonPrimitiveRoots.size(); i++) {
            listPolarLabel2.add(new Label(listNonPrimitiveRoots.get(i).showAsPolar()));
            layout2.getChildren().add(listPolarLabel2.get(i));
        }

        layout2.getChildren().add(bBinomic);

        scene2 = new Scene(layout2, 200, height);


        bPolar.setOnAction(e -> window.setScene(scene2));
        bBinomic.setOnAction(e -> window.setScene(scene1));

        window.setScene(scene1);
        window.showAndWait();
    }

    public static FuncionTrigonometrica chooseFunction() {
        AtomicReference<FuncionTrigonometrica> function = new AtomicReference<>();

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Suma de fasores");
        window.setMinWidth(350);
        window.setMinHeight(150);

        Label label = new Label("Por favor, elija qué función desea ingresar para la operación");

        Button sineButton = new Button("Seno");
        sineButton.setMinWidth(55);
        sineButton.setOnAction(e -> {
            function.set(FuncionTrigonometrica.SENO);
            window.close();
        });

        Button cosineButton = new Button("Coseno");
        sineButton.setMinWidth(55);
        cosineButton.setOnAction(e -> {
            function.set(FuncionTrigonometrica.COSENO);
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, sineButton, cosineButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return function.get();
    }

    public static double insertDouble(InsertionOption option) {
        AtomicReference<Double> value = new AtomicReference<>((double) 0);

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        switch(option) {
            case EXPONENT:
                window.setTitle("Exponente");
                break;
            case INDEX:
                window.setTitle("Índice");
                break;
            case AMPLITUDE:
                window.setTitle("Amplitud");
                break;
            case FREQUENCY:
                window.setTitle("Frecuencia");
                break;
            case PHASE:
                window.setTitle("Fase");
                break;
        }

        window.setMinWidth(300);
        window.setMinHeight(100);

        TextField complexInput = new TextField();
        Button bAccept = new Button("Aceptar");

        bAccept.setOnAction(e -> {
            if (isDouble(complexInput.getText()))
                value.set(Double.parseDouble(complexInput.getText()));
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10,10 ));
        layout.getChildren().addAll(complexInput, bAccept);

        Scene scene = new Scene(layout, 300, 100);
        window.setScene(scene);
        window.showAndWait();

        return value.get();
    }

    public static void showPhasor(Fasor phasor) {
        int width = 270, height = 130;
        Scene scene1, scene2, scene3;

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Resultado");
        window.setMinWidth(width);
        window.setMinHeight(height);


        //Layout1
        Label label1 = new Label("El resultado de la operación es:");
        Label label2 = new Label(phasor.mostrarFasor());

        Button bSineCosine;

        if(phasor.getFuncionTrigonometrica() == FuncionTrigonometrica.SENO)
            bSineCosine = new Button("Cambiar a suma de cosenos");
        else
            bSineCosine = new Button("Cambiar a suma de senos");

        bSineCosine.setMinWidth(250);
        bSineCosine.setAlignment(Pos.BOTTOM_CENTER);

        Button bComplexNumber1 = new Button("Número complejo equivalente");
        bComplexNumber1.setMinWidth(250);
        bComplexNumber1.setAlignment(Pos.BOTTOM_CENTER);

        VBox layout1 = new VBox(10);
        layout1.setPadding(new Insets(10, 10, 10,10 ));
        layout1.getChildren().addAll(label1, label2, bSineCosine, bComplexNumber1);
        scene1 = new Scene(layout1, width, height);


        //Layout2
        Label label3 = new Label("El resultado de la operación es:");
        phasor.pasateDeFuncionTrigonometrica();
        Label label4 = new Label(phasor.mostrarFasor());

        Button bSineCosine2;

        if(phasor.getFuncionTrigonometrica() == FuncionTrigonometrica.SENO)
            bSineCosine2 = new Button("Cambiar a suma de cosenos");
        else
            bSineCosine2 = new Button("Cambiar a suma de senos");

        bSineCosine2.setMinWidth(250);
        bSineCosine2.setAlignment(Pos.BOTTOM_CENTER);

        Button bComplexNumber2 = new Button("Número complejo equivalente");
        bComplexNumber2.setMinWidth(250);
        bComplexNumber2.setAlignment(Pos.BOTTOM_CENTER);

        VBox layout2 = new VBox(10);
        layout2.setPadding(new Insets(10, 10, 10,10 ));
        layout2.getChildren().addAll(label3, label4, bSineCosine2, bComplexNumber2);
        scene2 = new Scene(layout2, width, height);


        //Layout3
        Label label5 = new Label("El resultado de la operación es:");
        Label label6 = new Label("En forma binómica:");
        Label label7 = new Label(phasor.obtenerNumeroComplejoEquivalente().showAsBinomic());
        Label label8 = new Label("En forma polar:");
        Label label9 = new Label(phasor.obtenerNumeroComplejoEquivalente().showAsPolar());

        Button bSineCosine3 = new Button("Mostrar como suma de senos/cosenos");

        bSineCosine3.setMinWidth(300);
        bSineCosine3.setAlignment(Pos.BOTTOM_CENTER);

        VBox layout3 = new VBox(10);
        layout3.setPadding(new Insets(10, 10, 10,10 ));
        layout3.getChildren().addAll(label5, label6, label7, label8, label9, bSineCosine3);
        scene3 = new Scene(layout3, 320, 180);


        bSineCosine.setOnAction(e -> window.setScene(scene2));
        bSineCosine2.setOnAction(e -> window.setScene(scene1));
        bComplexNumber1.setOnAction(e -> window.setScene(scene3));
        bComplexNumber2.setOnAction(e -> window.setScene(scene3));
        bSineCosine3.setOnAction(e -> window.setScene(scene1));

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

    enum InsertionOption { EXPONENT, INDEX, AMPLITUDE, FREQUENCY, PHASE }
}
