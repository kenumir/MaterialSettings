package com.kenumir.materialsettings.items;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kenumir.materialsettings.MaterialSettings;
import com.kenumir.materialsettings.MaterialSettingsItem;
import com.kenumir.materialsettings.R;
import com.kenumir.materialsettings.views.CheckableLinearLayout;

/**
 * Created by Kenumir on 2015-03-16.
 */
public class TextItem extends MaterialSettingsItem {

	private String title, subtitle;
	private View.OnClickListener onclick;

	public TextItem(MaterialSettings ctx, String name) {
		super(ctx, name);
	}

	@Override
	public int getViewResource() {
		return R.layout.item_text;
	}

	@Override
	public void setupView(View v) {
		((TextView) v.findViewById(R.id.material_dialog_item_title)).setText(title);
		((TextView) v.findViewById(R.id.material_dialog_item_subtitle)).setText(subtitle);
		v.setOnClickListener(getOnclick());
	}

	public String getTitle() {
		return title;
	}

	public TextItem setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public TextItem setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	public View.OnClickListener getOnclick() {
		return onclick;
	}

	public TextItem setOnclick(View.OnClickListener onclick) {
		this.onclick = onclick;
		return this;
	}
}
