package application.scenes;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScene extends Scene {

	private static BorderPane secondaryPane = new BorderPane();
	//private static SplitPane primaryPane = new SplitPane();
	
	
	public MainScene(Stage stage) {
		super(secondaryPane); /* primaryPane */
		this.getStylesheets().add("application.css");
		
		HBox bottomBar = new HBox();
		Label currentTime = new Label("00:42");				
		Slider seekbar = new Slider();
		Label endTime = new Label("13:37");
		
		bottomBar.setId("bottomBar");
		bottomBar.getChildren().addAll(currentTime, seekbar, endTime);

		VBox center = new VBox();
		Label mid = new Label("Mitte");
		
		center.setId("center");
		center.getChildren().addAll(mid);
		
		VBox sidemenu = new VBox();
		Image logo = new Image("kida.png");
		ImageView iv = new ImageView();
		iv.setImage(logo);
		iv.setFitWidth(128);
		iv.setFitHeight(54);
		Button home = new Button("Home");
		Button search = new Button("Suchen");
		Button library = new Button("Bibliothek");
		
		sidemenu.setId("sidemenu");
		sidemenu.getChildren().add(iv);
		sidemenu.getChildren().addAll(home, search, library);

		
		secondaryPane.setBottom(bottomBar);
		secondaryPane.setCenter(center);
		secondaryPane.setLeft(sidemenu);
		//primaryPane.getItems().addAll(sidemenu, secondaryPane);

	}

}
