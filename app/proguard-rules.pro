# https://github.com/Kotlin/kotlinx.serialization#android
# Keep `Companion` object fields of serializable classes.
# This avoids serializer lookup through `getDeclaredClasses` as done for named companion objects.
-if @kotlinx.serialization.Serializable class **
-keepclassmembers class <1> {
    static <1>$Companion Companion;
}

# Keep `serializer()` on companion objects (both default and named) of serializable classes.
-if @kotlinx.serialization.Serializable class ** {
    static **$* *;
}
-keepclassmembers class <2>$<3> {
    kotlinx.serialization.KSerializer serializer(...);
}

# Keep `INSTANCE.serializer()` of serializable objects.
-if @kotlinx.serialization.Serializable class ** {
    public static ** INSTANCE;
}
-keepclassmembers class <1> {
    public static <1> INSTANCE;
    kotlinx.serialization.KSerializer serializer(...);
}

# @Serializable and @Polymorphic are used at runtime for polymorphic serialization.
-keepattributes RuntimeVisibleAnnotations,AnnotationDefault

# https://www.guardsquare.com/blog/eliminating-data-leaks-caused-by-kotlin-assertions
# Remove Kotlin assertions
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
	public static void checkNotNull(...);
	public static void checkExpressionValueIsNotNull(...);
	public static void checkNotNullExpressionValue(...);
	public static void checkParameterIsNotNull(...);
	public static void checkNotNullParameter(...);
	public static void checkReturnedValueIsNotNull(...);
	public static void checkFieldIsNotNull(...);
	public static void throwUninitializedPropertyAccessException(...);
	public static void throwNpe(...);
	public static void throwJavaNpe(...);
	public static void throwAssert(...);
	public static void throwIllegalArgument(...);
	public static void throwIllegalState(...);
}