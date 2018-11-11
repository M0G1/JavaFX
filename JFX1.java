import javafx.application.Application;
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
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {    //Stage- окно
        this.window = primaryStage;
        //первое окно

        Label label1 = new Label("Приветствую вас. Вы в первом окне."); //Label - подпись
        Button button1 = new Button("Портал во второе окно");
        button1.setOnAction(e -> {
            window.setScene(scene2);
            window.setTitle("Тупик");//устанавливаем название окна после перехода
        }); //устанавливаем какое окно будет показывать
        //разметка (здесь вертикальная)
        VBox layout1 = new VBox(20);//растояние между объектами по вертикали (в 20 микселей)
        layout1.getChildren().addAll(label1,button1);
        this.scene1 = new Scene(layout1,300,200); //надеваем разметку на окно(сцену)
        //второе окно
        Label label2 = new Label("Приветствую вас. Вы во втором окне.");
        Button button2 = new Button("А го назад?");
        button2.setOnAction(e -> {
            window.setScene(scene1);
            this.window.setTitle("Начало");//устанавливаем название окна после перехода
        });
        HBox layout2 = new HBox(20);//растояние по горизонтали (в 20 пикселей)
        layout2.getChildren().addAll(label2,button2);
        this.scene2 = new Scene(layout2,320,200);
        this.window.setScene(scene1);//то окно которое будет показано в начале программы
        this.window.setTitle("Начало");//устанавливаем название окна в начале
        this.window.show();
    }
}
