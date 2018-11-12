import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class JFX1 extends Application {
    Stage window;
    Button button;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {    //Stage- окно
        this.window = primaryStage;
        this.window.setTitle("Всплывающее окно");

        window.setOnCloseRequest(e -> {         //Обработка собития (закрыть окно красный крестик в правом верхнем углу).
            e.consume();        //мы сами заботимся о событии   (закрытие)
            closeProgramm();

        });

        button = new Button("Закрыть");
        button.setPrefSize(120, 60);//задаем размер кнопки
        button.setOnAction(e -> {
            closeProgramm();
        });

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        this.scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }

    /**
     * метод, выполнящие некоторые действия перед закрытием
     * Этот код не выполниться, если нажать на кнопку закрытия справа сверху, если вызвать его у button
     */
    private void closeProgramm() {
        Boolean answer = ConfirmWindow.display("", "Вы действительно хотите закрытьт окно?");
        if (answer) {
            window.close();
        }
    }
}


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;  //модификация шрифта
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class ConfirmWindow {
    static boolean ansver;
    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        window.setMinHeight(200);

        Label label =  new Label(message);
        label.setFont(Font.font(20));

        Button yesButton = new Button("Да");
        Button noButton = new Button("Нет");

        yesButton.setOnAction(e->{
            ansver = true;
            window.close();
        });

        noButton.setOnAction(e->{
            ansver = false;
            window.close();
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();   //запустить и подождать, что вернет этот метод(класс)
        return ansver;
    }
}
