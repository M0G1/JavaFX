import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.event.EventHandler;

public class JFX1 extends Application  {
    //EventHandler - управление событиями

    Button button;

    public static void main(String[] args) {

        launch(args);       //этот метод из класса application, этот метод скажет программе, что это не просто java, а javaFX
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //здесь отображаются фх компоненты
        /*термины окно
         Stage - сцена(название, свернуть, закрыть во весь экрасн)
         scene - место действия, то что внутри окна(поля вкладки)

         */
        primaryStage.setTitle("Первый урок по JAVAFX");          //название окна
        button = new Button("Йа есть кнопко. Нажни меня");  //инициализация кнопки с надписью на ней
        button.setOnAction(new EventHandler<ActionEvent>() {//анонимный внутренний класс, который наследует интерфэйс ...(смотри предыдущую версию)
            @Override           //при таком описываиии слушателя не надо указывать какой класс генерирует событие(д)
            public void handle(ActionEvent event) {
                System.out.println("Ткни меня еще раз!!!");
            }
        });//устновить дейсвие, которое "прослушает" класс this

        //создать разметку для окна(сцены- место действия)
        // разметка- размещение элементов в окне - layout
        StackPane layout = new StackPane();
        layout.getChildren().add(button);//простая разметка(по центру)
        Scene scene = new Scene(layout, 300, 300); //элементы в конструкторе 1 РАЗМЕТКА и размер окна
        primaryStage.setScene(scene);   //указать где происходит действие. В каком окне расположиться контент
        primaryStage.show();    //отображение на сцене
    }
}
