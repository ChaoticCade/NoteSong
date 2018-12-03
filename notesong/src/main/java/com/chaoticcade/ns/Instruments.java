package com.chaoticcade.ns;

import org.bukkit.Sound;

public class Instruments {

	public static Sound getInstrument(int instrument) {
		switch (instrument) {
		case 0:
			return Sound.BLOCK_NOTE_HARP;
		case 1:
			return Sound.BLOCK_NOTE_BASS;
		case 2:
			return Sound.BLOCK_NOTE_BASEDRUM;
		case 3:
			return Sound.BLOCK_NOTE_SNARE;
		case 4:
			return Sound.BLOCK_NOTE_HAT;
		case 5:
			return Sound.BLOCK_NOTE_GUITAR;
		case 6:
			return Sound.BLOCK_NOTE_FLUTE;
		case 7:
			return Sound.BLOCK_NOTE_BELL;
		case 8:
			return Sound.BLOCK_NOTE_CHIME;
		case 9:
			return Sound.BLOCK_NOTE_XYLOPHONE;
		default:
			return Sound.BLOCK_NOTE_HARP;
		}
	}
}