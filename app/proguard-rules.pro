# kotlinx-serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt # core serialization annotations

# kotlinx-serialization-json specific. Add this if you have java.lang.NoClassDefFoundError kotlinx.serialization.json.JsonObjectSerializer
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

-keep,includedescriptorclasses class com.g00fy2.punkapp.**$$serializer { *; }
-keepclassmembers class com.g00fy2.punkapp.** {
    *** Companion;
}
-keepclasseswithmembers class com.g00fy2.punkapp.** {
    kotlinx.serialization.KSerializer serializer(...);
}