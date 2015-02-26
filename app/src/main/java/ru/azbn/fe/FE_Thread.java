package ru.azbn.fe;

import java.util.HashMap;

public class FE_Thread {

	FE_ForEach FE;

	HashMap<String, Thread> threads;

	public FE_Thread(FE_ForEach fe) {
		FE = fe;

		threads = new HashMap<String, Thread>();
	}

	public Thread get(String name) {
		return threads.get(name);
	}

	public Thread add(String name, Runnable runnable) {
		/*
		new Runnable() {
			@Override
			public void run() {

			}
		}
		*/
		Thread th = new Thread(runnable);
		threads.put(name, th);
		return get(name);
	}

	public void remove(String name) {
		threads.remove(name);
	}

	public void start(String name) {
		get(name).start();
	}

	public void stop(String name) {
		get(name).stop();
	}

}
