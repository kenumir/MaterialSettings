package com.kenumir.materialsettings.storage;

/**
 * Created by Kenumir on 2015-03-16.
 */
public abstract class StorageInterface {

	public StorageInterface() {}

	public abstract void save(String key, boolean value);
	public abstract boolean load(String key, boolean defaultValue);

}
