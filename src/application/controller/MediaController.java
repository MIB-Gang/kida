package application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import application.Playlist;
import application.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class MediaController {
	
	private static MediaController mediaController = new MediaController();
	
	private Playlist allSongs = new Playlist("All Songs");
	private Map<String,Playlist> allPlaylists = new HashMap<>();
	private Playlist selectedPlaylist;
	private File allSongsFile = new File("./allSongsFile.txt");
	private File allPlaylistsFile = new File("./allPlaylists.txt");
	private File currentSongFile  = new File ("./currentSongFile.txt");
	private File currentPlaylistFile = new File ("./currentPlaylist.txt");
	
	public static MediaController getInstance() {
		return mediaController;
	}
	
	public MediaController() {
		readFromFile();
	}
	
	public void addToAllSongs(Song song) {
		allSongs.getSongs().add(song);
		saveToFile();
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
		allPlaylists.get(playlist.getName()).getSongs().add(song);
	}
	
	public void removeSong(Song song, Playlist playlist) {
		allPlaylists.get(playlist.getName()).getSongs().remove(song);
	}
	
	public ObservableList<Song> search(String input, String type) {
		Stream<Song> result;
		String word = input.toLowerCase();
		switch (type) {
		case "Titel":
			result = allSongs.getSongs().stream().filter(item -> item.getTitle().toLowerCase().contains(word));	
			break;
		case "Interpret":
			result = allSongs.getSongs().stream().filter(item -> item.getArtist().toLowerCase().contains(word));	     	
			break;
		case "Album":
			result = allSongs.getSongs().stream().filter(item -> item.getAlbum().toLowerCase().contains(word));     
			break;
		case "Genre":
			result = allSongs.getSongs().stream().filter(item -> item.getGenre().toLowerCase().contains(word));
			break;
		default:
			result = allSongs.getSongs().stream().filter(item -> item.getTitle().toLowerCase().contains(word));	     
			break;
		}
		return  FXCollections.observableArrayList(result.collect(Collectors.toList()));
	}

	public void saveToFile() {
		
        try {
        	if (!allSongsFile.exists()) {
        		allSongsFile.createNewFile();
        		}
            FileOutputStream fos = new FileOutputStream(allSongsFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<Song>(allSongs.getSongs()));
            System.out.println("\n(i) Data has been saved to file!");
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("\n(!) " + e.getMessage());
        }
        System.out.println("save: " + allSongs.getSongs());
    }

    @SuppressWarnings("unchecked")
	public void readFromFile() {
        try {
            FileInputStream fis = new FileInputStream(allSongsFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Song> so = (ArrayList<Song>)ois.readObject();
            allSongs.setSongs(FXCollections.observableArrayList(so));
            System.out.println("\n(i) Data has been read from file!");
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("\n(!) " + e.getMessage());
        }
        System.out.println("read: " + allSongs.getSongs());
    }


	
}
