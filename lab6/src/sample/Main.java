package sample;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class Main extends Application {

    public static boolean runVar = false; // Глобальная переменная для остановки или запуска анимации

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Я название программы!");
        StackPane root = new StackPane();

        // Создание красного круга (по умолчанию фигуру не видно)
        Circle circle = new Circle(100);
        circle.setStroke(Color.web("FF0033"));
        circle.setFill(Color.web("CC0033"));
        circle.setStrokeWidth(10);
        circle.setVisible(false);

        // Создание жёлтого квадрата (по умолчанию фигуру не видно)
        Rectangle square = new Rectangle(150, 150);
        square.setStroke(Color.web("CCCC00"));
        square.setFill(Color.web("#FFFF00"));
        square.setStrokeWidth(10);
        square.setVisible(false);

        // Создание зелёного треугольника (по умолчанию фигуру не видно)
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(0.0,0.0,  150.0,-150.0, 300.0,000.0);
        triangle.setFill(Color.web("#33CC33"));
        triangle.setStroke(Color.web("00FF00"));
        triangle.setStrokeWidth(10);
        triangle.setVisible(false);

        // Создание кнопок
        Button stop_button = new Button("Остановите это!");
            stop_button.setStyle("-fx-background-color: #FFFF00");
        Button start_button = new Button("Начинаем!");
            start_button.setStyle("-fx-background-color: #33FF00");
        Button exit_button = new Button("ВЫХОД");
            exit_button.setStyle("-fx-background-color: #ff0000");

        // Добавлений фигур на экран
        root.getChildren().add(circle);
        root.getChildren().add(square);
        root.getChildren().add(triangle);

        // Добавдение кнопок на экран
        root.getChildren().add(stop_button);
        root.getChildren().add(start_button);
        root.getChildren().add(exit_button);

        // Выравнивание кнопок
        StackPane.setAlignment(stop_button, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(start_button, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(exit_button, Pos.BOTTOM_CENTER);

        // Создание сцены
        Scene scene = new Scene(root, 500, 500, Color.web("#006699"));
        root.setBackground(Background.EMPTY);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Старт анимации
        Thread thread = new Thread(new FigureTask(circle, square, triangle, primaryStage));
        thread.start();

        // Присваивание действий кнопкам
        start_button.setOnAction(this::StartThread);
        stop_button.setOnAction(this::StopThread);
        exit_button.setOnAction(this::ExitProg);


    }

    // функция для старта анимации (присваивание значения true)
    private void StartThread(ActionEvent actionEvent) {
        runVar = true;
    }

    // функция для остановки анимации (присваивание значения false)
    private void StopThread(ActionEvent actionEvent) {
        runVar = false;
    }

    // функция для завершения программы
    private void ExitProg(ActionEvent actionEvent) {
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
