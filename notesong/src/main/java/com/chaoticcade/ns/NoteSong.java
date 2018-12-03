package com.chaoticcade.ns;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NoteSong extends JavaPlugin {


	public static HashMap<String, ArrayList<ArrayList<String>>> songDB = new HashMap<String, ArrayList<ArrayList<String>>>();
	public static ArrayList<ArrayList<String>> songArray2D = new ArrayList<ArrayList<String>>();
	public static ArrayList<String> songList = new ArrayList<String>(songDB.keySet());



	@Override
	public void onEnable() {
		getDataFolder().mkdir();
		LoadSongs.loadSongs();
		songList = new ArrayList<String>(songDB.keySet());
	}


	@Override
	public void onDisable() {
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  {
		if (cmd.getName().equalsIgnoreCase("notesong") && sender instanceof Player && args.length == 1)  {
			String song = args[0];
			PlaySong.playSong(((Player) sender), song, this);
			return true;
		}


		if (cmd.getName().equalsIgnoreCase("nsreload") && sender instanceof Player)  {
			sender.sendMessage("Reloading SongDB!");
			LoadSongs.loadSongs();
			songList = new ArrayList<String>(songDB.keySet());
			sender.sendMessage("Done!");
			return true;
		}


		if (cmd.getName().equalsIgnoreCase("nslist") && sender instanceof Player && args.length == 1)  {
			if (isStringInt(args[0]) == false || Integer.parseInt(args[0]) <= 0) {
			//throws error on null
				sender.sendMessage("Invalid page number!");
				return true;
			}
			else {
				ListSongs.listSongs((Player) sender, (String) args[0]);
				return true;
			}
		}

		return false;
	}

	public static boolean isStringInt(String s)
	{
		try
		{
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex)
		{
			return false;
		}
	}
}



