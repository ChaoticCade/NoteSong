package com.chaoticcade.ns;

public class Pitch {

	public enum NotePitch {
		NOTE_0(0, 0.5F),
		NOTE_1(1, 0.529731547179648F),
		NOTE_2(2, 0.561231024154687F),
		NOTE_3(3, 0.594603557501361F),
		NOTE_4(4, 0.629960524947437F),
		NOTE_5(5, 0.667419927085017F),
		NOTE_6(6, 0.707106781186548F),
		NOTE_7(7, 0.749153538438341F),
		NOTE_8(8, 0.7937005259841F),
		NOTE_9(9, 0.840896415253715F),
		NOTE_10(10, 0.890898718140339F),
		NOTE_11(11, 0.943874312681693F),
		NOTE_12(12, 1.0F),
		NOTE_13(13, 1.0594630943593F),
		NOTE_14(14, 1.12246204830937F),
		NOTE_15(15, 1.18920711500272F),
		NOTE_16(16, 1.25992104989487F),
		NOTE_17(17, 1.33483985417003F),
		NOTE_18(18, 1.4142135623731F),
		NOTE_19(19, 1.49830707687668F),
		NOTE_20(20, 1.5874010519682F),
		NOTE_21(21, 1.68179283050743F),
		NOTE_22(22, 1.78179743628068F),
		NOTE_23(23, 1.88774862536339F),
		NOTE_24(24, 2.0F);


		public int note;
		public float pitch;

		private NotePitch(int note, float pitch) {
			this.note = note;
			this.pitch = pitch;
		}

		public static float getPitch(int note) {
			for (NotePitch notePitch : values()) {
				if (notePitch.note == note) {
					return notePitch.pitch;
				}
			}

			return 0.0F;
		}
	}
}
