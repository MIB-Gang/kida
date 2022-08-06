package application;

import application.canvas.ArtistCanva;
import application.scenes.Scaffold;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Window extends Application {

	public void start(Stage stage) throws Exception {		
		Image icon = new Image("kida_icon.png");
		stage.getIcons().add(icon);
		stage.setTitle("kiɗa");

		stage.setMinWidth(1000);
		stage.setMinHeight(700);
		stage.setScene(new Scaffold(stage, new ArtistCanva()));
				
		stage.show();
	}

	public static void open() {
		launch();
	}

}
