# MaterialSettings
MaterialSettings - small library to create settings activity

[ ![Download](https://api.bintray.com/packages/kenumir/MaterialDialogs/MaterialSettings/images/download.svg) ](https://bintray.com/kenumir/MaterialDialogs/MaterialSettings/_latestVersion)

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