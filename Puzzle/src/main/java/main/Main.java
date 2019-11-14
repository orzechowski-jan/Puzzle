package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
		StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane, 1000, 700);
        
        stage.setTitle("Moja aplikacja");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
		
	}

}
