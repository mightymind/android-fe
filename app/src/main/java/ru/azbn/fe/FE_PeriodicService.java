package ru.azbn.fe;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

public class FE_PeriodicService extends Service {

	FE_ForEach FE;
	AlarmManager alarmManager;

	@Override
	public void onCreate() {
		super.onCreate();

		FE = new FE_ForEach(getApplicationContext());

		startService();
	}

	private void startService() {

		Intent intent = new Intent(this, FE_PeriodicReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, FE_App.PeriodicService_request_code, intent, 0);

		alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(
				AlarmManager.ELAPSED_REALTIME_WAKEUP,
				SystemClock.elapsedRealtime() + FE_App.PeriodicService_onboot_timeout,
				FE_App.PeriodicService_interval,
				pendingIntent);
	}

	@Override
	public void onDestroy() {
		if (alarmManager != null) {
			Intent intent = new Intent(this, FE_PeriodicReceiver.class);
			alarmManager.cancel(PendingIntent.getBroadcast(this, FE_App.PeriodicService_request_code, intent, 0));
		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {



		return super.onStartCommand(intent, flags, startId);
		//return START_NOT_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

}
