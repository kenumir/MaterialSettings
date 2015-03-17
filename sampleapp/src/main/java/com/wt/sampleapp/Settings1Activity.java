package com.wt.sampleapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kenumir.materialsettings.MaterialSettings;
import com.kenumir.materialsettings.items.CheckboxItem;
import com.kenumir.materialsettings.items.DividerItem;
import com.kenumir.materialsettings.items.HeaderItem;
import com.kenumir.materialsettings.items.TextItem;
import com.kenumir.materialsettings.storage.SimpleStorageInterface;
import com.kenumir.materialsettings.storage.StorageInterface;

public class Settings1Activity extends MaterialSettings {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addItem(new HeaderItem(this).setTitle("Sample title 1"));
		addItem(new CheckboxItem(this, "key1").setTitle("Checkbox item 1").setSubtitle("Subtitle text 1"));
		addItem(new DividerItem(this));
		addItem(new CheckboxItem(this, "key2").setTitle("Checkbox item 2").setSubtitle("Subtitle text 2").setChecked(true));
		addItem(new DividerItem(this));
		addItem(new TextItem(this, "key3").setTitle("Simple text item 1").setSubtitle("Subtitle of simple text item 1").setOnclick(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(Settings1Activity.this, "Clicked", Toast.LENGTH_SHORT).show();
			}
		}));
		addItem(new HeaderItem(this).setTitle("Sample title 2"));
		addItem(new TextItem(this, "key4").setTitle("Simple text item 2").setSubtitle("Subtitle of simple text item 2").setOnclick(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(Settings1Activity.this, "Clicked 2", Toast.LENGTH_SHORT).show();
			}
		}));
		addItem(new DividerItem(this));
	}

	@Override
	public StorageInterface initStorageInterface() {
		return new SimpleStorageInterface();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_settings1, menu);
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
