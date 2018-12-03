package com.chaoticcade.ns;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PlaySong {
	public static <E> void playSong(final Player p, String songToPlay, Plugin plugin) {

		if (NoteSong.songList.contains(songToPlay) && songToPlay != null) {
			final Location loc = p.getLocation();
			ArrayList<ArrayList<String>> songPlayArray = new ArrayList<ArrayList<String>>();
			songPlayArray = NoteSong.songDB.get(songToPlay);
			int count = 0;
			for (Iterator<ArrayList<String>> iter = songPlayArray.iterator(); iter.hasNext(); ) {
			    final ArrayList<String> element = iter.next();
				count = count + Integer.parseInt(element.get(2));
				//Play the actual song now
				new BukkitRunnable() {
					public void run() {
						p.playSound(loc,  Instruments.getInstrument(Integer.parseInt(element.get(0))), 10.0F, Pitch.NotePitch.getPitch(Integer.parseInt(element.get(1))));
					}
				}.runTaskLater(plugin, count);
			}
		}
		else {
			p.sendMessage("Invalid song selection.");
		}
	}
}
