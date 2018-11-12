import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class JFX1 extends Application  {
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

        button = new Button("Нажми меня");
        button.setPrefSize(120,60);//задаем размер кнопки
        button.setOnAction(e ->{
            boolean result = ConfirmWindow.display("Окно потверждения","И оно реально работает?");
            System.out.println(result);
            //window.close();
        });

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        this.scene = new Scene(layout,400,300);
        window.setScene(scene);
        window.show();
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
