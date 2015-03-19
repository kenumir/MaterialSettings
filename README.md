# MaterialSettings
MaterialSettings - small library to create settings activity

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

# Screens
![Default](/screens/theme_default.png)
![Rec](/screens/theme_red.png)
![Dark](/screens/theme_dark.png)