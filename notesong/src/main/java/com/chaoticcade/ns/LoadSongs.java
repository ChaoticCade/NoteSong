package com.chaoticcade.ns;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;

public class LoadSongs {

	public static HashMap<String, ArrayList<ArrayList<String>>> loadSongs() {
		NoteSong.songDB = new HashMap<String, ArrayList<ArrayList<String>>>();
		File dir = ((NoteSong)Bukkit.getPluginManager().getPlugin("NoteSong")).getDataFolder();
		File[] directoryListing = dir.listFiles();
		for (File child : directoryListing) {
			NoteSong.songArray2D = new ArrayList<ArrayList<String>>();
			try {
				parseSong(child.toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			NoteSong.songDB.put(child.getName().toString(), NoteSong.songArray2D);
		}
		return NoteSong.songDB;
	}

	public static ArrayList<ArrayList<String>> parseSong(Path song) throws IOException {
		int lineCounter = 0;
		List<String> lines = Files.readAllLines(song, StandardCharsets.UTF_8);
		for (String songLine : lines) {
			if (songLine.contains("#") || songLine.length() < 7) {
			}

			else {
				ArrayList<String> songArray = new ArrayList<String>();
				String[] splitData = songLine.split("\\s*,\\s*");
				for (int i = 0; i < splitData.length; i++) {
					if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
						songArray.add(splitData[i].trim());
					}
				}
				NoteSong.songArray2D.add(lineCounter, songArray);
				lineCounter++;
			}
		}

		return NoteSong.songArray2D;
	}
}

