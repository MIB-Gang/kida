package application.screens;

import application.nodes.BottomBar;
import application.nodes.Sidemenu;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Scaffold extends BorderPane {
	
	public Scaffold(Node canva) {
		this.getStylesheets().add("application.css");
				
		BottomBar bottomBar = new BottomBar();
		Sidemenu sidemenu = new Sidemenu();
		
		this.setBottom(bottomBar);
		this.setLeft(sidemenu);
		this.setCenter(canva);
				
	}

}