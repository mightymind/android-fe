package ru.azbn.fe;

public class FE_Init {

	FE_ForEach FE;

	public FE_Init(FE_ForEach fe) {
		FE = fe;
	}

	public void App() {
		if(!FE.isInit(FE.App)) {
			FE.App = new FE_App(FE);
			FE.dmsg("Init FE.App");
		}
	}

	public void AzbnAPI() {
		if(!FE.isInit(FE.AzbnAPI)) {
			FE.AzbnAPI = new FE_AzbnAPI(FE);
			FE.dmsg("Init FE.AzbnAPI");
		}
	}

	public void DB() {
		if(!FE.isInit(FE.DB)) {
			FE.DB = new FE_DB(FE, FE.App.appName, null, FE.App.dbVersion);
			FE.dmsg("Init FE.DB");
		}
	}

	public void Thread() {
		if(!FE.isInit(FE.Thread)) {
			FE.Thread = new FE_Thread(FE);
			FE.dmsg("Init FE.Thread");
		}
	}

	public void Notify() {
		if(!FE.isInit(FE.Notify)) {
			FE.Notify = new FE_Notify(FE);
			FE.dmsg("Init FE.Notify");
		}
	}

	public void Player() {
		if(!FE.isInit(FE.Player)) {
			FE.Player = new FE_Player(FE);
			FE.dmsg("Init FE.Player");
		}
	}

	public void Recorder() {
		if(!FE.isInit(FE.Recorder)) {
			FE.Recorder = new FE_Recorder(FE);
			FE.dmsg("Init FE.Recorder");
		}
	}

	public void FM() {
		if(!FE.isInit(FE.FM)) {
			FE.FM = new FE_FileManager(FE);
			FE.dmsg("Init FE.FM");
		}
	}

}
