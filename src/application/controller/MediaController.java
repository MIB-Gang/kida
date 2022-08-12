package application.controller;

import java.util.ArrayList;
import java.util.List;

import application.Playlist;
import application.Song;

public class MediaController {
	
	private static MediaController mediaController = new MediaController();
	
	private Playlist allSongs = new Playlist();
	private List<Playlist> allPlaylists = new ArrayList<>();
	
	public MediaController() {
		allSongs.add(new Song("titleField.getText()", "artistField.getText()", "albumField.getText()",
						"genreField.getText()", false, "selectedFilePath", "video"));
	}
	
	public void addToAllSongs(Song song) {
		allSongs.add(song);
	}

	public List<Playlist> getAllPlaylists() {
		return allPlaylists;
	}


	public void setAllPlaylists(List<Playlist> allPlaylists) {
		this.allPlaylists = allPlaylists;
	}


	public Playlist getAllSongs() {
		return allSongs;
	}
	

	public static MediaController getInstance() {
		return mediaController;
	}
}
