package com.studio.contraband;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.studio.contraband.Contraband;

import java.lang.annotation.Target;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;
		initialize(new Contraband(), config);

		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
		{
			hideVirtualButtons();
		}
	}


	@TargetApi(19)
	private  void hideVirtualButtons()
	{
		getWindow().getDecorView().setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
				View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
				View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
				View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
				View.SYSTEM_UI_FLAG_FULLSCREEN |
				View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
	}

	public void onWindowFocusChange(boolean hasFocus)
	{
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus)
		{
			if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
			{
				hideVirtualButtons();
			}
		}
	}
}
