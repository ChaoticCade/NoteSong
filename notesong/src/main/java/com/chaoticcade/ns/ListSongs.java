package com.chaoticcade.ns;

import org.bukkit.entity.Player;

public class ListSongs {

	public static void listSongs (Player p, String page) {
			int pageNumber = Integer.parseInt(page);
			for (int i = 0; i < (pageNumber * 5); i++){
				if (i < NoteSong.songList.size()) {
					p.sendMessage((i + 1) +  ". " + NoteSong.songList.get(i));
				}
				else {
					p.sendMessage("End of song list.");
					break;
				}
			}
		}
}
