package com.kenumir.materialsettings.items;

import com.kenumir.materialsettings.MaterialSettings;
import com.kenumir.materialsettings.R;

/**
 * Created by Kenumir on 2015-03-20.
 */
public class SwitcherItem extends CheckboxItem {

	public SwitcherItem(MaterialSettings ctx, String name) {
		super(ctx, name);
	}

	@Override
	public int getViewResource() {
		return R.layout.item_switcher;
	}

}
