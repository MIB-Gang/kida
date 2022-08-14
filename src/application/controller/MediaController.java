package application.controller;

import java.util.HashMap;
import java.util.Map;

import application.Playlist;
import application.Song;
import javafx.collections.transformation.FilteredList;

public class MediaController {
	
	private static MediaController mediaController = new MediaController();
	
	private Playlist allSongs = new Playlist("All Songs");
	private Map<String,Playlist> allPlaylists = new HashMap<>();
	private Playlist selectedPlaylist;
	private FilteredList<Song> filteredSongs = new FilteredList<>(allSongs);
	
	public static MediaController getInstance() {
		return mediaController;
	}
	
	public MediaController() {

	}
	
	public void addToAllSongs(Song song) {
		allSongs.add(song);
	}

	public Playlist getAllSongs() {
		return allSongs;
	}	

	public Map<String,Playlist> getAllPlaylists() {
		return allPlaylists;
	}

	public void setAllPlaylists(Map<String,Playlist> allPlaylists) {
		this.allPlaylists = allPlaylists;
	}
	
	public Playlist getSelectedPlaylist() {
		return selectedPlaylist;
	}

	public void setSelectedPlaylist(Playlist selectedPlaylist) {
		this.selectedPlaylist = selectedPlaylist;
	}
	
	public void createPlaylist(String name) {
		allPlaylists.put(name, new Playlist(name));
	}
	
	public void deletePlaylist(String name) {
		allPlaylists.remove(name);
	}

	public void addSong(Song song, Playlist playlist) {
		allPlaylists.get(playlist.getName()).add(song);
	}
	
	public void removeSong(Song song, Playlist playlist) {
		allPlaylists.get(playlist.getName()).remove(song);
	}
	
	public void search() {
		
	}

	public FilteredList<Song> getFilteredSongs() {
		return filteredSongs;
	}

	public void setFilteredSongs(FilteredList<Song> filteredSongs) {
		this.filteredSongs = filteredSongs;
	}


	
}
