package com.kenumir.materialsettings.items;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.kenumir.materialsettings.MaterialSettingsItem;
import com.kenumir.materialsettings.R;

/**
 * Created by Kenumir on 2015-03-16.
 */
public class TextItem extends MaterialSettingsItem {

	public static interface OnClickListener {
		public void onClick(TextItem item);
	}


	private String title, subtitle;
	private OnClickListener onclick;
	private TextView titleView, subtitleView;

	public TextItem(Context ctx, String name) {
		super(ctx, name);
	}

	@Override
	public int getViewResource() {
		return R.layout.item_text;
	}

	@Override
	public void setupView(View v) {
		titleView = (TextView) v.findViewById(R.id.material_dialog_item_title);
		subtitleView = (TextView) v.findViewById(R.id.material_dialog_item_subtitle);

		updateTitle(title);
		updateSubTitle(subtitle);

		v.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (getOnclick() != null)
					getOnclick().onClick(TextItem.this);
			}
		});
	}

	@Override
	public void save() {
		// NOP
	}

	public TextItem updateTitle(String newTitle) {
		if (titleView != null)
			titleView.setText(newTitle);
		return this;
	}

	public TextItem updateSubTitle(String newSubTitle) {
		if (subtitleView != null) {
			subtitleView.setText(newSubTitle);
			subtitleView.setVisibility(subtitle != null && subtitle.trim().length() > 0 ? View.VISIBLE : View.GONE);
		}
		return this;
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

	public OnClickListener getOnclick() {
		return onclick;
	}

	public TextItem setOnclick(OnClickListener onclick) {
		this.onclick = onclick;
		return this;
	}
}
