package com.kenumir.materialsettings;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.kenumir.materialsettings.storage.StorageInterface;

/**
 * Created by Kenumir on 2015-04-07.
 */
public abstract class MaterialSettingsActivity extends ActionBarActivity {

	private MaterialSettingsFragment fragment;

	@Override
	public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
		super.onCreate(savedInstanceState, persistentState);
		setContentView(R.layout.activity_material_settings_base);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		fragment = (MaterialSettingsFragment) getSupportFragmentManager().findFragmentById(R.id.material_settings_fragment);
	}

	public void addItem(MaterialSettingsItem item) {
		if (fragment != null)
			fragment.addItem(item);
	}

	public void saveAll() {
		if (fragment != null) {
			fragment.saveAll();
		}
	}

	public MaterialSettingsItem getItem(String keyName) {
		if (fragment != null) {
			return fragment.getItem(keyName);
		} else {
			return null;
		}
	}

	public StorageInterface getStorageInterface() {
		if (fragment != null) {
			return fragment.getStorageInterface();
		} else {
			return null;
		}
	}

	public MaterialSettingsFragment getFragment() {
		return fragment;
	}

	public FrameLayout getContentFrame(MaterialSettingsFragment.ContentFrames frame) {
		if (fragment != null)
			return fragment.getContentFrame(frame);
		else
			return null;
	}

	public abstract StorageInterface initStorageInterface();
}
