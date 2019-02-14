import database.DbConnection;
import database.DbOperations;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static ServerStarter serverStarter;
    private static Object t;

    public static void main(String[] args) {
        // работа с БД
        DbOperations.createTable();
        DbOperations.fillTestData();
        // запуск сервера
        serverStarter = new ServerStarter(args);
        new Thread(serverStarter).start();
        // запуск главного окна
        launch(args);


        System.exit(0);
    }

    // запуск главного окна
    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "MainForm.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource(fxmlFile));
        stage.setTitle("Server Management");
        stage.setScene(new Scene(root));

        stage.show();
        stage.requestFocus();

        // событие при выходе
        stage.setOnCloseRequest(event -> {
            // остановка сервера
            serverStarter.stop();
            // закрыть форму
            System.out.println("Closing application");
            stage.close();
            // выход из программы НЕПРАВИЛЬНО. СДЕЛАТЬ ПРАВИЛЬНОЕ ЗАВЕРШЕНИЕ ЭТОГО ПОТОКА
            System.exit(0);
        });
    }
}