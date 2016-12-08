# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\ruanjian\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#基本配置信息----------start--------
-dontshrink
-dontpreverify
-dontoptimize
-dontusemixedcaseclassnames
-flattenpackagehierarchy
-allowaccessmodification
#当库文件修改的时候 必须重新输出mapping.txt
#-printmapping mapping.txt

-optimizationpasses 7
-verbose
-keepattributes Exceptions,InnerClasses
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-ignorewarnings
#保持相同的混淆映射（规则）否则AndFix不能成功
#-applymapping ./mapping.txt

-keepclassmembers class * {
   private native <methods>;
   public native <methods>;
   protected native <methods>;
   public static native <methods>;
   private static native <methods>;
   static native <methods>;
   native <methods>;
}
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

-dontwarn android.support.**
-dontwarn java.lang.invoke.*
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#基本配置信息----------end--------

#不混淆所有的指定包下的类和这些类的所有成员变量-------start
#-keep class com.qpwa.bclient.bean.**{*;}
#-keep class com.qpwa.b2bclient.network.model.**{*;}
#-keep class com.qpwa.app.update.bean.**{*;}
#-keep class com.qpwa.library_chat.domain.**{*;}
#-keep class com.hyphenate.easeui.domain.**{*;}
#-keep class com.hyphenate.easeui.model.**{*;}
#不混淆所有的指定包下的类和这些类的所有成员变量-------end

# retrofit2----------start--------
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
# retrofit2----------end--------

#Okhttp3----------start--------
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
#Okhttp3----------end--------

#EventBus 3.0----------start--------
-keepattributes *Annotation*
-keepclassmembers class ** {
      @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode {
        *;
}
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
      <init>(java.lang.Throwable);
}
#EventBus 3.0----------end--------

#fastjson混淆配置----------start--------
-dontnote com.alibaba.**
-keep class com.alibaba.fastjson.**{*;}
#fastjson混淆配置----------end--------

##---------------Begin: proguard configuration for Gson  ----------
-keepattributes Signature
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.examples.android.model.** { *; }
##---------------End: proguard configuration for Gson  ----------

#RxJava----------start--------
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    long producerNode;
    long consumerNode;
}
#RxJava----------end--------

#Glide-----------start------
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
#Glide-----------end------

#Picasso-----------Start------
-dontwarn com.squareup.okhttp.**
#picasso-----------end------


#ButterKnife 7.0-----------Start------
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
 @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
@butterknife.* <methods>;
}
#ButterKnife 7.0-----------end------
