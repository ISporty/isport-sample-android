# isport-sample-android

<b>Installation</b>

1. Add repository

The easiest way to get started using wiinventtv-sdk-android is to add it as a Gradle dependency. You need to make sure you have the wiinventtv-sdk-android repository included in the build.gradle file in the root of your project:

```gradle
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://maven.fptscore.com/repository/maven-releases/" }
    }
}
```
2. Add wiinventtv-sdk-android module dependency

```gradle
implementation 'tv.wiinvent:wiinvent-sdk-android:X.X.X'

```

where X.X.X is your preferred version.

```
Latest released version to Maven is 1.1.2
```

