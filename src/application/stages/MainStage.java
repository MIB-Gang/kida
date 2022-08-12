package application.stages;

import application.scenes.BodyLibrary;
import application.scenes.Scaffold;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainStage extends Stage {
	
	public MainStage() {
		this.getIcons().add(new Image("/kida_icon.png"));
		this.setTitle("kida");
		this.setMinWidth(1000);
		this.setMinHeight(700);
		
		this.setScene(new Scene(new Scaffold(new BodyLibrary())));		
//		stage.show();
	}
	
}
