package com.kenumir.materialsettings.items;

import android.content.Context;

import com.kenumir.materialsettings.MaterialSettingsFragment;
import com.kenumir.materialsettings.R;

/**
 * Created by Kenumir on 2015-03-20.
 */
public class SwitcherItem extends CheckboxItem {

	public SwitcherItem(MaterialSettingsFragment ctx, String name) {
		super(ctx, name);
	}

	@Override
	public int getViewResource() {
		return R.layout.item_switcher;
	}

}
