package ru.azbn.fe;

import android.media.MediaRecorder;

import java.io.File;

public class FE_Recorder extends MediaRecorder {

	FE_ForEach FE;

	public static Integer Recorder_ChannelCount=1;
	public static Integer Recorder_MaxDuration=7000;
	public static Integer Recorder_BitRate=256;//24000;
	public static Integer Recorder_SamplingRate=44100;//22050;

	public FE_Recorder(FE_ForEach fe) {
		FE = fe;
	}

	public void init_config() {

		setAudioSource(AudioSource.MIC);
		setOutputFormat(OutputFormat.MPEG_4);
		setAudioEncoder(AudioEncoder.AAC);
		setAudioEncodingBitRate(Recorder_BitRate);
		setAudioSamplingRate(Recorder_SamplingRate);
		setAudioChannels(Recorder_ChannelCount);
		setMaxDuration(Recorder_MaxDuration);

	}

	@Override
	public void setOutputFile(String path) {
		File outFile = new File(path);
		if(outFile.exists()) {
			outFile.delete();
		}
		super.setOutputFile(path);
	}

}
