package application.uiComponents;

import application.controller.PlayerController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControlElements extends VBox {

	private ImageView videoPlaceholder = new ImageView();
	private HBox infoArea = new HBox();
	private ImageView like = new ImageView();
	private VBox titles = new VBox();
	private Label title = new Label();
	private Label subtitle = new Label();
	private HBox buttonArea = new HBox();
	private Button prevButton = new Button();
	private Button playButton = new Button();
	private Button nextButton = new Button();
	private Button pauseButton = new Button();
	private PlayerController playerController = PlayerController.getInstance();
	

	public ControlElements() {		
		title.setText("Never Gonna Give You Up");
		subtitle.setText("Rick Astley");
		titles.getChildren().addAll(title, subtitle);
		
		infoArea.getChildren().addAll(/* like, new Rectangle(8, 0), */ titles);
		
		buttonArea.getChildren().addAll(prevButton, playButton, nextButton);
		
		prevButton.setOnAction((event) -> playerController.previousSong());
	
		playButton.setOnAction((event) -> {
			playerController.play();
			buttonArea.getChildren().remove(playButton);
			buttonArea.getChildren().add(1, pauseButton);
			
		});
		
		pauseButton.setOnAction((event)->{
			playerController.pause();
			buttonArea.getChildren().remove(pauseButton);
			buttonArea.getChildren().add(1, playButton);
		});
		
		nextButton.setOnAction((event) -> playerController.nextSong());
		
		this.getChildren().addAll(videoPlaceholder, new Rectangle(0, 16), infoArea, new Rectangle(0, 8), buttonArea);
		
		applyStyle();
	}
	
	public void applyStyle() {
		this.setAlignment(Pos.BOTTOM_CENTER);
		buttonArea.setAlignment(Pos.CENTER);
		titles.setAlignment(Pos.CENTER);
		infoArea.setAlignment(Pos.CENTER);
		
		like.setImage(new Image("/like.png"));
		like.setFitWidth(24);
		like.setPreserveRatio(true);
		
		title.setStyle("-fx-font-weight: bold");
		subtitle.setTextFill(Color.rgb(217, 217, 217));
		
		ImageView prevGraphic = new ImageView(new Image("/previous.png"));
		prevGraphic.setFitWidth(24);
		prevGraphic.setPreserveRatio(true);
		prevButton.setGraphic(prevGraphic);
		ImageView playGraphic = new ImageView(new Image("/play.png"));
		playGraphic.setFitWidth(36);
		playGraphic.setPreserveRatio(true);
		playButton.setGraphic(playGraphic);
		ImageView nextGraphic = new ImageView(new Image("/next.png"));
		nextGraphic.setFitWidth(24);
		nextGraphic.setPreserveRatio(true);
		nextButton.setGraphic(nextGraphic);
		ImageView pauseGraphic = new ImageView(new Image("/pause.png"));
		pauseGraphic.setFitWidth(36);
		pauseGraphic.setPreserveRatio(true);
		pauseButton.setGraphic(pauseGraphic);
		
		videoPlaceholder.setImage(new Image("/videoPlaceholder.jpg"));
		videoPlaceholder.setFitWidth(176);
		videoPlaceholder.setPreserveRatio(true);

	}	
}