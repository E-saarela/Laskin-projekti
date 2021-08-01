package LaskinFx;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	public void start(Stage primaryStage) {
		try {
			final FXMLLoader ldr = new FXMLLoader(getClass().getResource("menu.fxml"));
			final Pane root = (Pane)ldr.load();
			Scene scene = new Scene(root,430,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Laskin");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
