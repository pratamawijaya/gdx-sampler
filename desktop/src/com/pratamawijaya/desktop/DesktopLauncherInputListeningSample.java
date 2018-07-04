package com.pratamawijaya.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pratamawijaya.InputListeningSample;
import com.pratamawijaya.InputPollingSample;

public class DesktopLauncherInputListeningSample {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new InputListeningSample(), config);
	}
}
