package ru.azbn.fe;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

public class FE_ForEach {

	Context appContext;
	FE_ForEach FE;

	public static String version = "0.1.0 Vanila";

	FE_Init Init=null;
	FE_App App=null;
	FE_AzbnAPI AzbnAPI=null;
	FE_DB DB=null;
	FE_Thread Thread=null;
	FE_Notify Notify=null;
	FE_Player Player=null;
	FE_Recorder Recorder=null;
	FE_FileManager FM=null;

	public FE_ForEach(Context context) {
		this.appContext = context;
		FE = this;
		Init = new FE_Init(FE);
		Init.App();

	}

	public long now() {
		return System.currentTimeMillis();
	}

	public void msg(String text) {
		Toast.makeText(appContext, text, Toast.LENGTH_SHORT).show();
	}

	public void dmsg(String text) {
		Log.d(FE_App.appName, text);
	}

	public Integer random(Integer min, Integer max) {
		Random rnd = new Random(System.currentTimeMillis());
		return (rnd.nextInt(max-min)+min);
	}

	public Boolean isInit(Object o) {
		if(o==null) {
			/*
			if(FE_App.debug) {
				msg("Object is null");
			}
			*/
			return false;
		} else {
			return true;
		}
	}

}
