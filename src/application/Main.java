package application;

import application.scenes.BodyHome;
import application.scenes.Scaffold;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	
	public void start(Stage stage) throws Exception {		
		stage.getIcons().add(new Image("/kida_icon.png"));
		stage.setTitle("kiɗa");
		stage.setMinWidth(1000);
		stage.setMinHeight(700);
		
		stage.setScene(new Scene(new Scaffold(new BodyHome())));		
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
