package application.scenes;

import application.uiComponents.DefaultTextField;
import application.uiComponents.SongTable;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class BodySearch extends VBox {
	
	DefaultTextField searchField = new DefaultTextField();
	SongTable table = new SongTable();
	
	public BodySearch() {
		this.setSpacing(12);
		this.getChildren().addAll(searchField, table);
		
		applyStyle();
	}
	
	private void applyStyle() {
		this.setPadding(new Insets(31.25, 32, 0, 32));
	}

}
