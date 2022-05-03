
# Rapport

- [x] In MainActivity: Read data from Shared Preferences

This code creates a private SharedPreferences variable and instantiates it with the name `"preferences"`.
```java
private SharedPreferences myPreferenceRef;
...
myPreferenceRef = getSharedPreferences("preferences", MODE_PRIVATE);
```

According to the documentation for activities `onResume` is called just before the activity starts interacting with the user.
The code that is executed gets the String value stored in `myPreferenceRef` under the name `"savedPreference"` or the String
`"Data missing"` if the shared preference does not exist.
```java
protected void onResume() {
    super.onResume();
    String data = myPreferenceRef.getString("savedPreference", "Data missing");
    textView.setText(data);
}
```

![](screenshot_1.png)

- [x] Create a new screen called SecondActivity that can be opened from MainActivity

Added `activity_second.xml`, `SecondActivity.java` and an onClickListener in `MainActivity.java`
with the following method to start the second activity.
```java
private void onButtonClick(){
    Intent intent = new Intent(this, SecondActivity.class);
    startActivity(intent);
}
```

- [x] In SecondActivity: Write data to Shared Preferences using EditText

This code creates a private SharedPreferences.Editor variable and instantiates from a local
SharedPreferences variable that has been instantiated the name `"preferences"`.
```java
private SharedPreferences.Editor myPreferenceEditor;
...
SharedPreferences myPreferenceRef = getSharedPreferences("preferences", MODE_PRIVATE);
myPreferenceEditor = myPreferenceRef.edit();
```

With this reference to the Editor the following code saves the value in the EditText to the shared
preference with the name `"savedPreference"` when the button is pressed.
```java
public void onClick(View view) {
    myPreferenceEditor.putString("savedPreference", editText.getText().toString());
    myPreferenceEditor.apply();
}
```

![](screenshot_2.png)

- [x] When closing SecondActivity the data written should be visible in MainActivity

![](screenshot_3.png)