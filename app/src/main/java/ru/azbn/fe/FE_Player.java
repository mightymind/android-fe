package ru.azbn.fe;

import android.media.AudioManager;
import android.media.MediaPlayer;

public class FE_Player extends MediaPlayer {

	FE_ForEach FE;

	public FE_Player(FE_ForEach fe) {
		FE = fe;
	}

	public void init_config() {

		this.setVolume(1, 1);
		this.setAudioStreamType(AudioManager.STREAM_MUSIC);

	}

}
