package com.kenumir.materialsettings.storage;

import java.util.HashMap;

/**
 * Created by Kenumir on 2015-03-16.
 */
public class SimpleStorageInterface extends StorageInterface {

	private HashMap<String, Object> mem;

	public SimpleStorageInterface() {
		mem = new HashMap<String, Object>();
	}

	@Override
	public void save(String key, boolean value) {
		mem.put(key, Boolean.valueOf(value));
	}

	@Override
	public boolean load(String key, boolean defaultValue) {
		if (mem.containsKey(key))
			return (boolean) mem.get(key);
		return defaultValue;
	}
}
