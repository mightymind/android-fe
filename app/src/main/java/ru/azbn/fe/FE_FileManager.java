package ru.azbn.fe;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FE_FileManager {

	FE_ForEach FE;
	String storageDir=Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
	String appDir;

	public FE_FileManager(FE_ForEach fe) {
		FE = fe;

		setAppDir(FE.App.appName);
		//makeAppDirs();
	}

	public void setAppDir(String toDir) {
		appDir = toDir;
	}

	public void makeAppDirs() {
		makeDirIfNotExists(storageDir + appDir);
		//makeDirIfNotExists(storageDir + appDir + "/record/");
	}

	public String getAppFilePath(String filename) {
		return (storageDir + appDir + "/" + filename);
	}

	public void makeDirIfNotExists(String path) {
		File dir = new File(path);
		if(dir.exists()==false) {
			dir.mkdirs();
		}
	}

	public void deleteIfExists(String path) {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
	}

	public byte[] readFile(String path) {
		byte[] file_ = null;

		try {

			FileInputStream fns = new FileInputStream(new File(path));
			file_ = new byte[fns.available()];
			fns.read(file_);
			fns.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file_;
	}

	public void writeFile(String path, String content) {
		try {

			File sdFile = new File(path);
			BufferedWriter bw;
			bw = new BufferedWriter(new FileWriter(sdFile));
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
