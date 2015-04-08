package com.kenumir.materialsettings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.kenumir.materialsettings.storage.SimpleStorageInterface;
import com.kenumir.materialsettings.storage.StorageInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kenumir on 2015-03-15.
 */
public class MaterialSettingsFragment extends Fragment {

	public static enum ContentFrames {
		FRAME_TOP(0),
		FRAME_TOP_INSIDE(1),
		FRAME_BOTTOM(2),
		FRAME_BOTTOM_INSIDE(3);

		private int id;

		ContentFrames(int idx) {
			id = idx;
		}
		public int getValue() {
			return this.id;
		}
	}

	private LinearLayout material_settings_content;
	private Toolbar toolbar;
	private StorageInterface mStorageInterface;
	private HashMap<String, MaterialSettingsItem> items;
	private FrameLayout[] frames;

	public MaterialSettingsFragment() {
		//
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_material_settings, container, false);

		items = new HashMap<>();

		material_settings_content = (LinearLayout) root.findViewById(R.id.material_settings_content);
		frames = new FrameLayout[4];
		frames[0] = (FrameLayout) root.findViewById(R.id.material_settings_top_frame);
		frames[1] = (FrameLayout) root.findViewById(R.id.material_settings_top_frame_inside);
		frames[2] = (FrameLayout) root.findViewById(R.id.material_settings_bottom_frame_inside);
		frames[3] = (FrameLayout) root.findViewById(R.id.material_settings_bottom_frame);

		mStorageInterface = initStorageInterface();

		return root;
	}

	public FrameLayout getContentFrame(ContentFrames frame) {
		return frames[frame.getValue()];
	}

	/**
	 * save all settings values at StorageInterface
	 */
	public void saveAll() {
		for(String key : items.keySet()) {
			items.get(key).save();
		}
	}

	public void addItem(MaterialSettingsItem item) {
		View newView = item.getView(material_settings_content);
		if (newView != null) {
			material_settings_content.addView(newView);
			items.put(item.getName(), item);
		}
	}

	public MaterialSettingsItem getItem(String keyName) {
		return items.get(keyName);
	}

	public StorageInterface getStorageInterface() {
		return mStorageInterface;
	}

	public StorageInterface initStorageInterface(){
		if (getActivity() != null && (getActivity() instanceof MaterialSettingsActivity)) {
			return ((MaterialSettingsActivity) getActivity()).initStorageInterface();
		} else {
			return null;
		}
	}
}
