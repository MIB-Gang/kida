package application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
	private Playlist favorites = new Playlist("Favoriten");
	private ObservableList<Playlist> myPlaylists = FXCollections.observableArrayList();
	private ObservableList<Playlist> artistPlaylists = FXCollections.observableArrayList();
	private ObservableList<Playlist> albumPlaylists = FXCollections.observableArrayList();
	private ObservableList<Playlist> genrePlaylists = FXCollections.observableArrayList();
	private Playlist selectedPlaylist;
	private File allSongsFile = new File("./allSongsFile.txt");
	
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

	public ObservableList<Playlist> getAllPlaylists() {
		return myPlaylists;
	}

	public void setAllPlaylists(ObservableList<Playlist> allPlaylists) {
		this.myPlaylists = allPlaylists;
	}
	
	public Playlist getPlaylistByName(String name) {
		return myPlaylists.stream().filter(element-> element.getName().equals(name)).findFirst().orElse(null);
	}
	
	public Playlist getSelectedPlaylist() {
		return selectedPlaylist;
	}

	public void setSelectedPlaylist(Playlist selectedPlaylist) {
		this.selectedPlaylist = selectedPlaylist;
	}
	
	public void createPlaylist(String name) {
		myPlaylists.add(new Playlist(name));
	}
	
	public void deletePlaylist(Playlist playlist) {
		myPlaylists.remove(playlist);
	}
	
	public void deletePlaylistByName(String name) {
		myPlaylists.remove(getPlaylistByName(name));
	}


	public void addSong(Song song, Playlist playlist) {
		getPlaylistByName(playlist.getName()).getSongs().add(song);
	}
	
	public void removeSong(Song song, Playlist playlist) {
		getPlaylistByName(playlist.getName()).getSongs().remove(song);
	}
	
	public void setOnFavorites(Song s) {
		s.setLike(true);
	}
	
	public void deleteOnFavorites(Song s) {
		s.setLike(false);
	}
	
	public Playlist getOnFavorite() {
		favorites = (Playlist) allSongs.getSongs().stream().filter(element->element.isLike());
		return favorites;
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

	public ObservableList <Playlist> getArtistPlaylists() {
		return artistPlaylists;
	}
	
	public ObservableList<Playlist> getAlbumPlaylists() {
		return albumPlaylists;
	}

	public ObservableList<Playlist> getGenrePlaylists() {
		return genrePlaylists;
	}

	public void setArtistPlaylists() {
		Set <String> artistList=new HashSet<>(allSongs.getSongs().stream().map(Song::getArtist).collect(Collectors.toList()));
		for(String s:artistList) {
			artistPlaylists.add(new Playlist(s));
		}
		for(Song song:allSongs.getSongs()) {
			artistPlaylists.stream().filter(element-> element.getName().equals(song.getArtist())).findFirst().orElse(null).getSongs().add(song);
		}
	}

	public void setAlbumPlaylists() {
		Set <String> albumList=new HashSet<>(allSongs.getSongs().stream().map(Song::getAlbum).collect(Collectors.toList()));
		for(String s:albumList) {
			albumPlaylists.add(new Playlist(s));
		}
		for(Song song:allSongs.getSongs()) {
			albumPlaylists.stream().filter(element-> element.getName().equals(song.getAlbum())).findFirst().orElse(null).getSongs().add(song);
		}
	}
	
	public void setGenrePlaylists() {
		Set <String> genreList=new HashSet<>(allSongs.getSongs().stream().map(Song::getGenre).collect(Collectors.toList()));
		for(String s:genreList) {
			genrePlaylists.add(new Playlist(s));
		}
		for(Song song:allSongs.getSongs()) {
			genrePlaylists.stream().filter(element-> element.getName().equals(song.getGenre())).findFirst().orElse(null).getSongs().add(song);
		}
	}
	
}
