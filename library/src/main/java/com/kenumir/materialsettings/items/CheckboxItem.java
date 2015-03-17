package com.kenumir.materialsettings.items;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.kenumir.materialsettings.MaterialSettings;
import com.kenumir.materialsettings.MaterialSettingsItem;
import com.kenumir.materialsettings.R;
import com.kenumir.materialsettings.views.CheckableLinearLayout;

/**
 * Created by Kenumir on 2015-03-16.
 */
public class CheckboxItem extends MaterialSettingsItem {

	private String title, subtitle;
	private boolean checked;

	public CheckboxItem(MaterialSettings ctx, String name) {
		super(ctx, name);
		checked = getStorageInterface().load(name, false);
	}

	@Override
	public int getViewResource() {
		return R.layout.item_checkbox;
	}

	@Override
	public void setupView(View v) {
		((TextView) v.findViewById(R.id.material_dialog_item_title)).setText(title);
		((TextView) v.findViewById(R.id.material_dialog_item_subtitle)).setText(subtitle);

		((CheckableLinearLayout) v).setChecked(checked);
		((CheckableLinearLayout) v).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mContext.getStorageInterface().save(name, isChecked);
			}
		});
	}

	public String getTitle() {
		return title;
	}

	public CheckboxItem setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public CheckboxItem setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	public boolean isChecked() {
		return checked;
	}

	public CheckboxItem setChecked(boolean checked) {
		this.checked = checked;
		return this;
	}
}
