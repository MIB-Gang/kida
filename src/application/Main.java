package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import application.scenes.BodyAdmin;
import application.scenes.BodyLibrary;
import application.scenes.Scaffold;
import application.stages.ImportStage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	
	public void start(Stage stage) throws Exception {		
		stage.getIcons().add(new Image("/kida_icon.png"));
		stage.setTitle("kida");
		stage.setMinWidth(1000);
		stage.setMinHeight(700);
		
		stage.setScene(new Scene(new Scaffold(new BodyLibrary())));		
		stage.show();
		
//		ImportStage importStage = new ImportStage(List.of(
//				new File("C:/Users/" + System.getProperty("user.name") + "/Music/Get-Through_NEFFEX.mp3"),
//				new File("C:/Users/" + System.getProperty("user.name") + "/Music/Hush-Little-Baby_The-Green-Orbs.mp3"),
//				new File("C:/Users/" + System.getProperty("user.name") + "/Music/Positive-Fuse_French-Fuse.mp3")			
//		));
//		importStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
	