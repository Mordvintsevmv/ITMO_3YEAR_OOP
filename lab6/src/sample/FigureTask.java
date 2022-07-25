package sample;

import javafx.concurrent.Task;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FigureTask extends Task<Void> {

    private Circle circle;
    private Rectangle rectangle;
    private Polygon polygon;
    private Stage stage;

    public FigureTask(Circle circleIn, Rectangle rectangleIn, Polygon polygonIn, Stage stageIn) {
        circle = circleIn;
        rectangle = rectangleIn;
        polygon = polygonIn;
        stage = stageIn;
    }

    @Override
    protected Void call() throws Exception {
        while (stage.isShowing()) { // Цикл работает пока открыта программа
            if (!Main.runVar) {Thread.sleep(10);} // Проверка. Если нажата кнопка "стоп", то анимация уходит в "сон"
            else { // Если проверка не проходит (Анимация запущена), фигуры появляются и исчезают
                polygon.setVisible(false);
                rectangle.setVisible(false);
                circle.setVisible(true);
                Thread.sleep(1000);
            }
            if (!Main.runVar) {Thread.sleep(10);}
            else {
                circle.setVisible(false);
                polygon.setVisible(false);
                rectangle.setVisible(true);
                Thread.sleep(1000);
            }
            if (!Main.runVar) {Thread.sleep(10);}
            else {
                rectangle.setVisible(false);
                circle.setVisible(false);
                polygon.setVisible(true);
                Thread.sleep(1000);

            }
        }
        return null;
    }
}

