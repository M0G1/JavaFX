import javafx.application.Application;import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;  //модификация шрифта
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class AlertWindow {
    public static void display(String title, String message) {  //название окна, надпись в окне
        Stage window = new Stage();  //новое окно новый объект
        window.initModality(Modality.APPLICATION_MODAL);    //юлокирование пользователя с другими окнами
        window.setTitle(title);
        window.setMinWidth(350);    //минимальная ширина
        window.setMinHeight(200);
        Label label =  new Label(message);  //сообщение
        //делаем надпись покрупнее
        label.setFont(Font.font(20));       //размер шрифта

        Button closeButton = new Button("Да");
        closeButton.setOnAction(e ->window.close());
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);                    //по центру окна
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();



    }
}

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.event.EventHandler;

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
            AlertWindow.display("Типо окно со свойствами","И оно реально работает?");
            window.close();
        });

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        this.scene = new Scene(layout,400,300);
        window.setScene(scene);
        window.show();

    }
}
