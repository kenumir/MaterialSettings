package com.kenumir.materialsettings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kenumir on 2015-03-16.
 */
public abstract class MaterialSettingsItem {

	protected MaterialSettings mContext;
	protected String name;

	public MaterialSettingsItem(MaterialSettings ctx, String name) {
		this.mContext = ctx;
		this.name = name;
	}

	public View initView(ViewGroup parent, int res) {
		return LayoutInflater.from(mContext).inflate(res, parent, false);
	}

	public View getView(ViewGroup parent) {
		if (getViewResource() > 0) {
			View v = initView(parent, getViewResource());
			setupView(v);
			return v;
		} else
			return null;
	}

	public abstract int getViewResource();
	public abstract void setupView(View v);

}
