# HtmlUnit Android
A port of HtmlUnit to Android (currently based on HtmlUnit 2.30)

## Caveats
- Image data is not loaded. You can still access the image URL and download the image yourself if you need the data. There is just no shortcut to do this in HtmlUnit Android anymore
    - As a result, you can't automatically get the dimensions of an image anymore, you have to download the image yourself to find it's dimensions
- Canvas is currently a NO-OP. That means that although using the canvas in JS won't crash the app, nothing will appear on the canvas
- You cannot customize the DNS resolver. Normally in HtmlUnit you can customize the DNS resolver. This option is not implemented in HtmlUnit Android.
- The HTML applet tag doesn't work. Obviously.
- You **MUST** specify the following in the `android` block in your `build.gradle`:
    ```
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    ```
- HtmlUnit is so large that to include it, you must enable multidex!

## Usage
Maven package coming soon!

## How did you do this?
You can find a log of all the changes I performed to the original HtmlUnit source code in [CHANGES.md](https://github.com/null-dev/HtmlUnit-Android/blob/master/huandroid/CHANGES.md)

Note that it does not include any of the shim classes I added

## License
My changes are license under HtmlUnit's license: The Apache License, Version 2.0

Some of the shim code is licensed differently, including but not limited to:
- GNU GPL v2