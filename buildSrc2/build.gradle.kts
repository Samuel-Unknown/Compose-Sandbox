plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

//buildscript {
//    repositories {
////        gradlePluginPortal()
//        google()
//        mavenCentral()
//    }
//
//    dependencies {
//        classpath("com.android.tools.build:gradle:7.0.3")
//    }
//}

gradlePlugin {
    // Add fake plugin, if you don't have any
    plugins.register("class-loader-plugin") {
        id = "class-loader-plugin"
        implementationClass = "ClassLoaderPlugin"
    }
    // Or provide your implemented plugins
}

dependencies {
    // Note: we can't use here `implementation(Libraries.gradlePlugin)` and hence,
    // after upgrading version here we also should be changed in `Versions.AndroidTools.gradle`
    implementation("com.android.tools.build:gradle:7.0.3")
}