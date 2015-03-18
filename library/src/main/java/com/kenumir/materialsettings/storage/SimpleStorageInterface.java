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

	@Override
	public void save(String key, String value) {

	}

	@Override
	public String load(String key, String defaultValue) {
		return null;
	}

	@Override
	public void save(String key, Integer value) {

	}

	@Override
	public Integer load(String key, Integer defaultValue) {
		return null;
	}

	@Override
	public void save(String key, Float value) {

	}

	@Override
	public Float load(String key, Float defaultValue) {
		return null;
	}

	@Override
	public void save(String key, Long value) {

	}

	@Override
	public Long load(String key, Long defaultValue) {
		return null;
	}

}
