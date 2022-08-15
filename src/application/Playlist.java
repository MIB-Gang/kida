package application;

import java.io.Serializable;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("serial")
public class Playlist  implements Serializable{
	
	private ObservableList<Song> songs = FXCollections.observableArrayList();
	private String name;
	private boolean like; 
		
	public Playlist(String name){
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ObservableList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ObservableList<Song> songs) {
		this.songs = songs;
	}

}
