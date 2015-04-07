package com.wt.sampleapp;

import android.os.Bundle;
import android.widget.TextView;

import com.kenumir.materialsettings.MaterialSettingsFragment;
import com.kenumir.materialsettings.storage.SimpleStorageInterface;
import com.kenumir.materialsettings.storage.StorageInterface;

public class Settings4Activity extends Settings1Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("SimpleStorage");

		TextView t = new TextView(this);
		t.setText("Simple storage saves settings in memory. When activity is rotated all data is stored in onSaveInstanceState and restored in onCreate");
		t.setPadding(20, 20, 20, 20);
		getContentFrame(MaterialSettingsFragment.ContentFrames.FRAME_TOP_INSIDE).addView(t);
	}

	@Override
	public StorageInterface initStorageInterface() {
		return new SimpleStorageInterface();
	}

}
