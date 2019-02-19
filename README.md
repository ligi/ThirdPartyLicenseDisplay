[![](https://jitpack.io/v/ligi/ThirdpartyLicenseDisplay.svg)](https://jitpack.io/#ligi/ThirdpartyLicenseDisplay)

What?
=====

Displays license information about dependencies you have in your project.

Google is developing the gradle [oss licenses plugin](https://developers.google.com/android/guides/opensource). This is great as you do not have to manually care for adding and removing license information for dependencies you use. Doing this manually is tedious work and it is great that this can be automated by a gradle script that goes through your dependencies and collects the information. Unfortunately the library to display the information is not open source and comes with a lot of closed source dependencies like play-services. This makes it e.g. impossible to distribute your app on FDroid.

So this project is doing the display part and is fully libre software with a permissive license so you can use it in projects while maintaining a small footprint and deploying to FDroid.

How?
====

Add this to your root `build.gradle`:

```groovy
buildscript {
  repositories {
    //...
    maven { google() } // or url "https://maven.google.com" for Gradle <= 3
  }
  dependencies {
    //...
    // Add this line:
    classpath "com.google.gms:oss-licenses:0.9.2"
  }
}
```

and in your app-level `build.gradle` apply this	plugin:

```groovy
apply plugin: 'com.google.gms.oss.licenses.plugin'
```

in the same file put the following in your dependency block after replacing `<version>` with the current version (you can easily see the latest version in the jitpack badge to the very top):

```groovy
implementation 'com.github.ligi:thirdpartylicensedisplay:<version>'
```
You will need need [jitpack](https://jitpack.io) defined as a repository - following the jitpack badge above shows you how - it is very easy.

Now you are all setup and can use the library by adding the fragment e.g. like this in your layout:

```xml
<fragment
        android:name="org.ligi.thirdpartylicensedisplay.lib.ui.LicenseInfoFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/license_fragment"/>
```
Usages
======

* [WallETH](https://walleth.org) - Android Ethereum Wallet

License
=======

MIT
