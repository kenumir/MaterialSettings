# MaterialSettings
MaterialSettings - small library to create settings activity

[![Android app on Google Play](https://developer.android.com/images/brand/en_app_rgb_wo_45.png)](https://play.google.com/store/apps/details?id=com.wt.sampleapp)


### Add to project

Repo:
```
repositories {
	maven {
		url "https://jitpack.io"
	}
}
```

Dependences:
```
dependencies {
	compile 'com.github.kenumir:MaterialSettings:v.1.2.2'
}
```

###Simple code:
```java
public class Settings1Activity extends MaterialSettings {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addItem(new HeaderItem(this).setTitle("Sample title 1"));
		addItem(new CheckboxItem(this, "key1").setTitle("Checkbox item 1").setSubtitle("Subtitle text 1").setOnCheckedChangeListener(new CheckboxItem.OnCheckedChangeListener() {
			@Override
			public void onCheckedChange(CheckboxItem cbi, boolean isChecked) {
				Toast.makeText(Settings1Activity.this, "CHECKED: " + isChecked, Toast.LENGTH_SHORT).show();
			}
		}));
	}
	@Override
    public StorageInterface initStorageInterface() {
    	return new PreferencesStorageInterface(this);
    }
}
```

#### Important
If in your app has layout named "activity_material_settings.xml" 
will occur error "NoSuchFieldError: No static field" - [issue #2](https://github.com/kenumir/MaterialSettings/issues/2)

### Style attrs
* msToolbarTheme
* msToolbarThemePopup
* msColorPrimary - primary color
* msColorPrimaryDark - color of status bar (api 21+)
* msColorAccent - accent color
* msWindowBg - default window bg color
* msColorHeader - headers text color (usually same as msColorAccent)
* msColorTextTitle - item title color
* msColorTextSubTitle - subtitle text color
* msDivider - divider drawable
* msItem - whole item color
* msTextStyle - reference to text title style (TextView)
* msSubTextStyle - reference to text sub title style (TextView)
* msHeaderStyle - reference to text title style (TextView)

### Same style
```xml
<style name="MaterialSettings.Red" parent="MaterialSettingsTheme">
<item name="msColorPrimary">@color/redPrimary</item>
    <item name="msColorPrimaryDark">@color/redPrimaryDark</item>
    <item name="msColorAccent">@color/redAccent</item>
    <item name="msColorHeader">@color/redAccent</item>
</style>
```

### StorageInterface
Easiest way to save/load settings

* PreferencesStorageInterface - in shared preferences
* SimpleStorageInterface - in memory
* or write own interface to save data (sqlite, content provider or to file)

Interface:

```java

    public abstract class StorageInterface {
        public StorageInterface() {}

        public abstract void save(String key, Boolean value);
        public abstract boolean load(String key, Boolean defaultValue);

        public abstract void save(String key, String value);
        public abstract String load(String key, String defaultValue);

        public abstract void save(String key, Integer value);
        public abstract Integer load(String key, Integer defaultValue);

        public abstract void save(String key, Float value);
        public abstract Float load(String key, Float defaultValue);

        public abstract void save(String key, Long value);
        public abstract Long load(String key, Long defaultValue);

        public abstract Map<String, ?> getAll();
    }

```

Extend and write own methods.

# Screens
![Default](/screens/theme_default2.png)
![Rec](/screens/theme_red2.png)
![Dark](/screens/theme_dark2.png)

###License

    Copyright 2013-2015 Michał Szwarc

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
