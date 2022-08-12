package application;

import java.util.ArrayList;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class Playlist extends SimpleListProperty<Song> {
	
	private String name;
	private boolean hoechstPriolike; 
	
	public Playlist(){
		super(FXCollections.observableArrayList());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
