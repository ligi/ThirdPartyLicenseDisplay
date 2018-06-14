[![](https://jitpack.io/v/ligi/ThirdpartyLicenseDisplay.svg)](https://jitpack.io/#ligi/ThirdpartyLicenseDisplay)

What?
=====

Displays license information about dependencies you have in your project.

Google is developing the gradle [oss licenses plugin](https://developers.google.com/android/guides/opensource). This is great as you do not have to manually care for adding and removing license information for dependencies you use. Doing this manually is tedious work and it is great that this can be automated by a gradle script that goes through your dependencies and collects the information. Unfortunately the library to display the information is not open source and comes with a lot of closed source dependencies like play-services. This makes it e.g. impossible to distribut your app on FDroid.

So this project is doing the display part and is fully libre software with a permissive license so you can use it in projects while maintaining a small footprint and deploying to FDroid.

License
=======

MIT
