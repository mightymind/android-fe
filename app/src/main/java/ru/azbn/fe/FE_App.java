package ru.azbn.fe;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;

public class FE_App {

	FE_ForEach FE;

	public static Boolean debug=true;

	public static String appName="ForEach";
	public static String appVersion="0.0.0";
	public static Integer dbVersion=0;
	public String device_id="";

	public static String AzbnAPI_site="http://app.azbn.ru";
	public static String AzbnAPI_url="http://app.azbn.ru/api/call/";
	public static String AzbnAPI_app_key="";
	public static String AzbnAPI_default_service="online";
	public static String AzbnAPI_default_method="check";

	public static Integer PeriodicService_request_code=12345678;
	public static Integer PeriodicService_interval=20000;
	public static Integer PeriodicService_onboot_timeout=5000;

	SharedPreferences Store;

	public FE_App(FE_ForEach fe) {
		FE = fe;

		TelephonyManager phonyMan = (TelephonyManager) FE.appContext.getSystemService(Context.TELEPHONY_SERVICE);
		device_id=phonyMan.getDeviceId();

		Store = FE.appContext.getSharedPreferences(appName, FE.appContext.MODE_PRIVATE);
		/*
		Editor editor = Store.edit();
		editor.putInt(key, val);
		editor.commit();

		Store.getString(key, default)
		*/
	}

}
