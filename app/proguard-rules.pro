## Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
## EnclosingMethod is required to use InnerClasses.
#-keepattributes Signature, InnerClasses, EnclosingMethod
## Gson specific classes
#-keep class com.kit.domain.dto.AreaDTO { *; }
#-keep class com.kit.domain.dto.AreaResponseDTO { *; }
#-keep class com.kit.domain.dto.CategoryDTO { *; }
#-keep class com.kit.domain.dto.CategoryDTOKt { *; }
#-keep class com.kit.domain.dto.IngredientDTO { *; }
#-keep class com.kit.domain.dto.IngredientResponseDTO { *; }
#-keep class com.kit.domain.dto.MealDTO { *; }
#-keep class com.kit.domain.dto.MealDTOKt { *; }
#-keep class com.kit.domain.dto.MealsResponseDTO { *; }
#
## Retrofit does reflection on method and parameter annotations.
#-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
#
## Keep annotation default values (e.g., retrofit2.http.Field.encoded).
#-keepattributes AnnotationDefault
#
## Retain service method parameters when optimizing.
#-keepclassmembers,allowshrinking,allowobfuscation interface * {
#    @retrofit2.http.* <methods>;
#}
#
#-keep public class * implements com.bumptech.glide.module.GlideModule
#-keep class * extends com.bumptech.glide.module.AppGlideModule {
# <init>(...);
#}
#-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
#  **[] $VALUES;
#  public *;
#}
#-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
#  *** rewind();
#}
#
## Uncomment for DexGuard only
##-keepresourcexmlelements manifest/application/meta-data@value=GlideModule
#
## Ignore JSR 305 annotations for embedding nullability information.
#-dontwarn javax.annotation.**
#
## Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
#-dontwarn kotlin.Unit
#
## Top-level functions that can only be used by Kotlin.
#-dontwarn retrofit2.KotlinExtensions
#-dontwarn retrofit2.KotlinExtensions$*
#
## With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
## and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
#-if interface * { @retrofit2.http.* <methods>; }
#-keep,allowobfuscation interface <1>
#
## Keep inherited services.
#-if interface * { @retrofit2.http.* <methods>; }
#-keep,allowobfuscation interface * extends <1>
#
## With R8 full mode generic signatures are stripped for classes that are not
## kept. Suspend functions are wrapped in continuations where the type argument
## is used.
#-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
#
## R8 full mode strips generic signatures from return types if not kept.
#-if interface * { @retrofit2.http.* public *** *(...); }
#-keep,allowoptimization,allowshrinking,allowobfuscation class <3>
#
#
###---------------Begin: proguard configuration for Gson  ----------
## Gson uses generic type information stored in a class file when working with fields. Proguard
## removes such information by default, so configure it to keep all of it.
#-keepattributes Signature
#
## For using GSON @Expose annotation
#-keepattributes *Annotation*
#
## Gson specific classes
#-dontwarn sun.misc.**
##-keep class com.google.gson.stream.** { *; }
#
## Application classes that will be serialized/deserialized over Gson
#-keep class com.google.gson.examples.android.model.** { <fields>; }
#-keep class com.kit.domain.dto.** { <fields>; }
#
## Prevent proguard from stripping interface information from TypeAdapter, TypeAdapterFactory,
## JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
#-keep class * extends com.google.gson.TypeAdapter
#-keep class * implements com.google.gson.TypeAdapterFactory
#-keep class * implements com.google.gson.JsonSerializer
#-keep class * implements com.google.gson.JsonDeserializer
#
## Prevent R8 from leaving Data object members always null
#-keepclassmembers,allowobfuscation class * {
#  @com.google.gson.annotations.SerializedName <fields>;
#}
#
## Retain generic signatures of TypeToken and its subclasses with R8 version 3.0 and higher.
#-keep,allowobfuscation,allowshrinking class com.google.gson.reflect.TypeToken
#-keep,allowobfuscation,allowshrinking class * extends com.google.gson.reflect.TypeToken
#
###---------------End: proguard configuration for Gson  ----------
#
#
## JSR 305 annotations are for embedding nullability information.
#-dontwarn javax.annotation.**
#
## A resource is loaded with a relative path so the package of this class must be preserved.
#-adaptresourcefilenames okhttp3/internal/publicsuffix/PublicSuffixDatabase.gz
#
## Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
#-dontwarn org.codehaus.mojo.animal_sniffer.*
#
## OkHttp platform used only on JVM and when Conscrypt and other security providers are available.
#-dontwarn okhttp3.internal.platform.**
#-dontwarn org.conscrypt.**
#-dontwarn org.bouncycastle.**
#-dontwarn org.openjsse.**
#-dontwarn kotlinx.atomicfu.**
#
## Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
## EnclosingMethod is required to use InnerClasses.
#-keepattributes Signature, InnerClasses, EnclosingMethod
#
## Retrofit does reflection on method and parameter annotations.
#-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
#
## Keep annotation default values (e.g., retrofit2.http.Field.encoded).
#-keepattributes AnnotationDefault
#
## Retain service method parameters when optimizing.
#-keepclassmembers,allowshrinking,allowobfuscation interface * {
#    @retrofit2.http.* <methods>;
#}
#
#
#
## Ignore JSR 305 annotations for embedding nullability information.
#-dontwarn javax.annotation.**
#
## Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
#-dontwarn kotlin.Unit
#
## Top-level functions that can only be used by Kotlin.
#-dontwarn retrofit2.KotlinExtensions
#-dontwarn retrofit2.KotlinExtensions$*
#
## With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
## and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
#-if interface * { @retrofit2.http.* <methods>; }
#-keep,allowobfuscation interface <1>
#
## Keep inherited services.
#-if interface * { @retrofit2.http.* <methods>; }
#-keep,allowobfuscation interface * extends <1>
#
## With R8 full mode generic signatures are stripped for classes that are not
## kept. Suspend functions are wrapped in continuations where the type argument
## is used.
#-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
#
## R8 full mode strips generic signatures from return types if not kept.
#-if interface * { @retrofit2.http.* public *** *(...); }
#-keep,allowoptimization,allowshrinking,allowobfuscation class <3>
#
#
## Keep generic signature of Call, Response (R8 full mode strips signatures from non-kept items).
# -keep,allowobfuscation,allowshrinking interface retrofit2.Call
# -keep,allowobfuscation,allowshrinking class retrofit2.Response
#
# # With R8 full mode generic signatures are stripped for classes that are not
# # kept. Suspend functions are wrapped in continuations where the type argument
# # is used.
# -keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
#
## region okhttp - https://square.github.io/okhttp/features/r8_proguard/
## JSR 305 annotations are for embedding nullability information.
#-dontwarn javax.annotation.**
#
## A resource is loaded with a relative path so the package of this class must be preserved.
#-adaptresourcefilenames okhttp3/internal/publicsuffix/PublicSuffixDatabase.gz
#
## Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
#-dontwarn org.codehaus.mojo.animal_sniffer.*
#
## OkHttp platform used only on JVM and when Conscrypt and other security providers are available.
#-dontwarn okhttp3.internal.platform.**
#-dontwarn org.conscrypt.**
#-dontwarn org.bouncycastle.**
#-dontwarn org.openjsse.**
#
## https://github.com/square/retrofit/issues/3751#issuecomment-1192043644
## Keep generic signature of Call, Response (R8 full mode strips signatures from non-kept items).
#-keep,allowobfuscation,allowshrinking interface retrofit2.Call
#-keep,allowobfuscation,allowshrinking class retrofit2.Response
## With R8 full mode generic signatures are stripped for classes that are not
## kept. Suspend functions are wrapped in continuations where the type argument
## is used.
#-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
## endregion
#
## region okio - https://square.github.io/okio/#r8-proguard
## Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
#-dontwarn org.codehaus.mojo.animal_sniffer.*
## endregion
#
#
## Crashlytics
#-keep class com.crashlytics.** { *; }
#-dontwarn com.crashlytics.**
#-keepattributes *Annotation*
#-keepattributes SourceFile,LineNumberTable
#-keep public class * extends java.lang.Exception
#-printmapping mapping.txt
#
## Adyen
#-keep class com.adyen.checkout.core.model.** { * ;}
#-keep class com.adyen.checkout.components.model.** { *; }
#-keep class com.adyen.threeds2.** { *; }
#
## Facebook Yoga
## Odyssey components are using facebook yoga, and the components are not called from application
## code (they are part of a SDUI library). R8 will then try to optimise by removing classes from
## yoga, since those does not seem to be called from anywhere.
#-keep class com.facebook.** { *; }
#
## Odyssey classes
## Due to serialization and getting class names we need to keep these classes.
#-keep class com.hedvig.odyssey.** { *; }
#
## Keep `Companion` object fields of serializable classes.
## This avoids serializer lookup through `getDeclaredClasses` as done for named companion objects.
#
#
#
#
## @Serializable and @Polymorphic are used at runtime for polymorphic serialization.
#-keepattributes RuntimeVisibleAnnotations,AnnotationDefault
#
## Datastore - https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:datastore/datastore-preferences/proguard-rules.pro;l=1
#
#
#-keepclasseswithmembers class * {
#    @androidx.annotation.Keep <methods>;
#}
#
#
#-keepclasseswithmembers class * {
#    @androidx.annotation.Keep <fields>;
#}
#
#
#
#-keepclasseswithmembers class * {
#    @androidx.annotation.Keep <init>(...);
#}
#
#-keep public class com.kit.data.datasource** { *; }
#-keep public class com.kit.data.repository** { *; }
#-keep public class com.kit.domain.dto** { *; }
#-keep public class com.kit.domain.usecases** { *; }
#-keep public class com.kit.domain.repository** { *; }
#-dontobfuscate
#-renamesourcefileattribute SourceFile
#-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*,code/removal/simple,code/removal/advanced
#-optimizationpasses 5
#-allowaccessmodification
#-dontpreverify
#-dontusemixedcaseclassnames
#-dontskipnonpubliclibraryclasses
#-verbose
#
#-assumenosideeffects class android.util.Log {
#    public static int v(...);
#    public static int d(...);
#}
#
#-keepattributes *Annotation*
#
#-keep class com.google.firebase.** { *; }
#
## For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
#-keepclasseswithmembernames class * {
#    native <methods>;
#}
#
## keep setters in Views so that animations can still work.
## see http://proguard.sourceforge.net/manual/examples.html#beans
#-keepclassmembers public class * extends android.view.View {
#   void set*(***);
#   *** get*();
#}
#
## We want to keep methods in Activity that could be used in the XML attribute onClick
#-keepclassmembers class * extends android.app.Activity {
#   public void *(android.view.View);
#}
#
## For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
#-keepclassmembers enum * {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}
#
#-keepclassmembers class * implements android.os.Parcelable {
#  public static final android.os.Parcelable$Creator CREATOR;
#}
#
#-keepclassmembers class **.R$* {
#    public static <fields>;
#}
#
## The support library contains references to newer platform versions.
## Don't warn about those in case this app is linking against an older
## platform version.  We know about them, and they are safe.
#-dontwarn android.support.**
#
#
#-dontwarn sun.reflect.**
#-dontwarn android.support.**
#-dontwarn javax.annotation.**
#
#-keep public class * extends android.app.Activity
#
#-keep public class * extends android.app.Application
#-keep public class * extends android.app.Service
#-keep public class * extends android.content.BroadcastReceiver
#-keep public class * extends android.content.ContentProvider
#
#
#################   retrofit2
#-dontwarn retrofit2.**
#-keep class retrofit2.** { *; }
#-keepattributes Signature
#-keepattributes Exceptions
#
#################   butterknife
#-keep class butterknife.** { *; }
#-dontwarn butterknife.internal.**
#-keep class **$$ViewBinder { *; }
#
#-keepclasseswithmembernames class * {
#    @butterknife.* <fields>;
#}
#
#-keepclasseswithmembernames class * {
#    @butterknife.* <methods>;
#}
#
#-keepnames class * implements android.os.Parcelable {
#    public static final ** CREATOR;
#}
#
#################
#-keepattributes Signature
#
## For using GSON @Expose annotation
#-keepattributes *Annotation*
#
#-keepattributes EnclosingMethod
#
## Gson specific classes
##-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }
#
#
#################   Parcel library
#-keep class * implements android.os.Parcelable {
#  public static final android.os.Parcelable$Creator *;
#}
#
#
#
#################   OkHttp
#-keepattributes Signature
#-keepattributes *Annotation*
#-keep class okhttp3.** { *; }
#-keep interface okhttp3.** { *; }
#-dontwarn okhttp3.**
#-dontwarn okio.**
#
#################   design
#-dontwarn android.support.design.**
#-keep class android.support.design.** { *; }
#-keep interface android.support.design.** { *; }
#-keep public class android.support.design.R$* { *; }
#
#################   appcompat
#-keep public class android.support.v7.widget.** { *; }
#-keep public class android.support.v7.internal.widget.** { *; }
#-keep public class android.support.v7.internal.view.menu.** { *; }
#
#
#################   Glide
#-keep public class * implements com.bumptech.glide.module.GlideModule
#-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
#  **[] $VALUES;
#  public *;
#}
#
#-keep class com.kit.domain.** {*;}
#-keep class com.kit.data** {*;}
#-keepclassmembers  class com.kit.domain.** {*;}
#-keepclassmembers  class com.kit.data** {*;}
#
#
#
#
#
#
#
#
###---------------Begin: proguard configuration for Gson  ----------
## Gson uses generic type information stored in a class file when working with fields. Proguard
## removes such information by default, so configure it to keep all of it.
#-keepattributes Signature
#
## For using GSON @Expose annotation
#-keepattributes *Annotation*
#
#
#
##-keep class com.google.gson.stream.** { *; }
#
## Application classes that will be serialized/deserialized over Gson
#-keep class com.google.gson.examples.android.model.** { *; }
#
###---------------End: proguard configuration for Gson  ----------