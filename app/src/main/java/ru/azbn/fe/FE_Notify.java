package ru.azbn.fe;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import org.json.JSONObject;

public class FE_Notify {

	FE_ForEach FE;

	public Integer NotifyDefaultId=19;
	public static String NotifyIntentId="FE.Notify.hdlr";

	public FE_Notify(FE_ForEach fe) {
		FE = fe;
	}

	public void show(String ticker, String title, String text, Class cl, Integer hdlr, Integer number, Boolean autocansel) {

		Intent notificationIntent = new Intent(FE.appContext, cl);
		notificationIntent.putExtra(NotifyIntentId, hdlr);
		PendingIntent contentIntent = PendingIntent.getActivity(
				FE.appContext,
				0,
				notificationIntent,
				PendingIntent.FLAG_CANCEL_CURRENT);
		NotificationManager nm = (NotificationManager) FE.appContext.getSystemService(Context.NOTIFICATION_SERVICE);

		//Resources res = context.getResources();
		Notification.Builder builder = new Notification.Builder(FE.appContext);
		builder.setContentIntent(contentIntent)
				.setSmallIcon(R.drawable.ic_launcher)
				.setDefaults(Notification.DEFAULT_SOUND)//(DEFAULT_ALL|DEFAULT_SOUND|DEFAULT_VIBRATE|DEFAULT_LIGHTS)
						//.setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher))
				.setTicker(ticker)
				.setWhen(FE.now())//(System.currentTimeMillis())
				.setAutoCancel(true)
				.setContentTitle(title)
				.setContentText(text)
		;
		if(number > 0) {
			builder.setNumber(number);
		}

		Notification n = builder.getNotification();

		nm.notify(NotifyDefaultId, n);

		if(autocansel) {
			nm.cancel(NotifyDefaultId);
		}

	}

	public FE_NotifyItem genNotifyFromJSON(JSONObject json) {
		FE_NotifyItem nt = new FE_NotifyItem();

		try {

			nt
					.setHdlr(0)
					.setActionClass(this.getClass())
					.setAutocansel(true)
					.setId(json.getInt("id"))
					.setInfo(
							json.getInt("number"),
							json.getString("ticker"),
							json.getString("title"),
							json.getString("text")
					);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nt;
	}

	public void showNotify(FE_NotifyItem notify) {

		if(notify.id > 0) {

		} else {
			notify.id = NotifyDefaultId;
		}

		Intent notificationIntent = new Intent(FE.appContext, notify.actionClass);
		notificationIntent.putExtra(NotifyIntentId, notify.hdlr);
		PendingIntent contentIntent = PendingIntent.getActivity(
				FE.appContext,
				0,
				notificationIntent,
				PendingIntent.FLAG_CANCEL_CURRENT);
		NotificationManager nm = (NotificationManager) FE.appContext.getSystemService(Context.NOTIFICATION_SERVICE);

		//Resources res = context.getResources();
		Notification.Builder builder = new Notification.Builder(FE.appContext);
		builder.setContentIntent(contentIntent)
				.setSmallIcon(R.drawable.ic_launcher)
				//.setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher))
				.setDefaults(Notification.DEFAULT_SOUND)//(DEFAULT_ALL|DEFAULT_SOUND|DEFAULT_VIBRATE|DEFAULT_LIGHTS)
				.setTicker(notify.ticker)
				.setWhen(FE.now())//(System.currentTimeMillis())
				.setAutoCancel(true)
				.setContentTitle(notify.title)
				.setContentText(notify.text)
		;
		if(notify.number > 0) {
			builder.setNumber(notify.number);
		}

		Notification n = builder.getNotification();

		nm.notify(notify.id, n);

		if(notify.autocansel) {
			nm.cancel(notify.id);
		}

	}

}
