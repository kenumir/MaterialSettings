package com.kenumir.materialsettings;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.kenumir.materialsettings.storage.StorageInterface;

/**
 * Created by Kenumir on 2015-03-15.
 */
public abstract class MaterialSettings extends ActionBarActivity {

	private LinearLayout material_settings_content;
	private Toolbar toolbar;
	private StorageInterface mStorageInterface;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		material_settings_content = (LinearLayout) findViewById(R.id.material_settings_content);

		mStorageInterface = initStorageInterface();
	}

	public void addItem(MaterialSettingsItem item) {
		View newView = item.getView(material_settings_content);
		if (newView != null)
			material_settings_content.addView(newView);
	}

	public StorageInterface getStorageInterface() {
		return mStorageInterface;
	}

	public abstract StorageInterface initStorageInterface();
}
