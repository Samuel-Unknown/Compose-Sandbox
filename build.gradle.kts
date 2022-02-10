// Top-level build file where you can add configuration options common to all sub-projects/modules.

/*buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }

    project.tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class).all {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }

        kotlinOptions.freeCompilerArgs += listOf(
            "-Xallow-jvm-ir-dependencies",
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xopt-in=kotlin.Experimental"
        )
    }
}*/

plugins {
    //id("com.android.tools.build") version "gradle:7.0.3" apply false
    id("com.android.application") version "7.0.3" apply false
    id("com.android.library") version "7.0.3" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
    print("DELETE:" + rootProject.buildDir)
}