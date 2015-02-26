package ru.azbn.fe;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

	FE_ForEach FE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FE = new FE_ForEach(getApplicationContext());

		//FE.Init.DB();

		/*
		FE.Init.Notify();
		FE.Notify.show("ticker", "title", "text", MainActivity.class, 0, 0, false);
		*/

		/*
		FE.Init.Thread();
		FE.Thread.add("test", new Runnable() {
			@Override
			public void run() {

			}
		}).start();
		*/

		/*
		FE.Init.FM();
		FE.FM.makeAppDirs();
		*/

		/*
		FE.Init.Recorder();
		if(FE.isInit(FE.Recorder)) {
			FE.msg("yes");
		} else {
			FE.msg("no");
		}
		*/

		/*
		startService(new Intent(FE.appContext, FE_PeriodicService.class));
		*/

		//FE.dmsg("23432432");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
