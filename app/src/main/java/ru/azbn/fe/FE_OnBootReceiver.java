package ru.azbn.fe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FE_OnBootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
			Intent serviceLauncher = new Intent(context, FE_PeriodicService.class);
			context.startService(serviceLauncher);
		}
	}
}
