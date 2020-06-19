
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;






public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception
    {
    	
        Parent loginRoot = FXMLLoader.load(getClass().getResource("resources/main.fxml"));
        Scene loginScene = new Scene(loginRoot, 600,400);
        primaryStage.setScene(loginScene);

        primaryStage.setTitle("ATM");
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
