# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

-dontusemixedcaseclassnames
-verbose

# Preserve line numbers for debugging stack traces
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Keep all public classes and their public members
-keep public class * {
    public protected *;
}

# Keep native methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep custom application classes
-keep class com.cashdemo.app.** { *; }

# Keep Kotlin metadata
-keepattributes *Annotation*
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

# Keep Room database classes
-keep class androidx.room.** { *; }
-keepclasseswithmembernames class * {
    @androidx.room.* <methods>;
}

# Keep Compose classes
-keep class androidx.compose.** { *; }

