package ru.azbn.fe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FE_PeriodicReceiver extends BroadcastReceiver {

	FE_ForEach FE;

	@Override
	public void onReceive(Context context, Intent intent) {

		FE = new FE_ForEach(context);
		//FE.msg("test");

		FE.Init.Notify();
		FE.Notify.show("ticker", "title", "text", MainActivity.class, 0, 0, false);
	}

}
