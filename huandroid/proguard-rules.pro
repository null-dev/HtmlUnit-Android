# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep public class com.gargoylesoftware.**
-keep public class java.**
-keep public class javax.**
-keep public class netscape.javascript.**
-keep public class org.w3c.dom.**
-keep public class sun.awt.**
-keep public class xyz.nulldev.huandroid.**
-dontwarn org.apache.xerces.dom.DocumentImpl
-dontwarn net.sourceforge.htmlunit.**
-dontwarn org.apache.bcel.verifier.**
-dontwarn org.apache.commons.logging.**
-dontwarn org.apache.regexp.**
-dontwarn org.apache.xalan.**
-dontwarn org.apache.xerces.**
-dontwarn org.eclipse.jetty.**
-dontwarn org.xmlpull.**
-dontwarn javax.**
-dontwarn android.util.Xml
