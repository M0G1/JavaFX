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
