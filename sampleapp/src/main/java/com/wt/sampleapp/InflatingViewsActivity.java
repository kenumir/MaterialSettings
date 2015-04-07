package com.wt.sampleapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.kenumir.materialsettings.items.SwitcherItem;
import com.kenumir.materialsettings.items.TextItem;

public class InflatingViewsActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inflating_views);

		ViewGroup content = (ViewGroup) findViewById(R.id.content);

		/*
		SwitcherItem item = new SwitcherItem(getBaseContext(), "key1");
		item.setTitle("Title of item ");
		item.setSubtitle("Subtitle text");
		content.addView(item.getView(content));

		TextItem item2 = new TextItem(getBaseContext(), "key2");
		item2.setTitle("Title of item - second line");
		item2.setSubtitle("Subtitle text");
		content.addView(item2.getView(content));
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_inflating_views, menu);
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
