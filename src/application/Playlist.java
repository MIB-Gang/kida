package application;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class Playlist extends SimpleListProperty<Song> {
	
	private String name;
	private boolean hoechstPriolike; 
	
	public Playlist(String name){
		super(FXCollections.observableArrayList());
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
