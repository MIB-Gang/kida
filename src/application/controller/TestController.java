package application.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Paths;

import application.Song;

public class TestController {
	
	/*
	 * Diese Methode, sowie die TestController-Klasse, existieren
	 * ausschlieﬂlich zum Testen des Programms. Hiermit werden
	 * beim ersten Start automatisch Beispiellieder importiert.
	 */
	public static void generateExampleSongs() {
		MediaController mediaController = MediaController.getInstance();

		mediaController.addToAllSongs(new Song(
					"Titel", "Interpret", "Album", "Genre",
					false, addKidaPath("Dateinamen"), 
					mediaController.randomVideoPath()));
		
	}
	
	
	private static String addKidaPath(String raw) {
		try {
			return (Paths.get(Paths.get("").toAbsolutePath().toString() + "/examplesSongs/" + raw)).toUri().toURL().toExternalForm();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
}
