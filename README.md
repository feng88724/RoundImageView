# RoundImageView





# How to use

## Step 1
* You need to add jitpack repository infomaition to build.gradle in your project.

```
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.0'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }

    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```

## step 2


* You need to add library dependencies infomation to build.gradle in your module.

- [![](https://jitpack.io/v/feng88724/RoundImageView.svg)](https://jitpack.io/#feng88724/RoundImageView)

```
 implementation 'com.github.feng88724:RoundImageView:Tag'
```

## step 3


###such as:

```

    <com.zhuyefeng.riv.RoundImageView
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:radius="15dp"
        android:src="@color/purple_200" />

```

