
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    signingConfigs {
        create("release") {
            storeFile = file("D:\\Keys\\foodrecipes_keystore.jks")
            storePassword = "stopqq"
            keyAlias = "key0"
            keyPassword = "stopqq"
        }
    }
    namespace = "com.kit.foodrecipes"
    compileSdk = 33

    defaultConfig {

        applicationId = "com.kit.foodrecipes"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildTypes {
            release {
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
                )
                isMinifyEnabled =  false


            }
        }


        // Allow references to generated code
        kapt {
            correctErrorTypes = true
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        kotlinOptions {
            jvmTarget = "17"
        }
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = "1.4.3"
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }

//    buildTypes {
////        debug {
////            isMinifyEnabled = true
////            isShrinkResources = true
//////            proguardFiles(
//////                getDefaultProguardFile("proguard-android.txt"),
//////                "proguard-rules.pro"
//////            )
////            versionNameSuffix = "-debug"
////            applicationIdSuffix = ".debug"
////            signingConfig = signingConfigs.getByName("debug")
////        }
//
//        release {
//            // Enables code shrinking, obfuscation, and optimization for only
//            // your project's release build type. Make sure to use a build
//             isDebuggable=true
//            isMinifyEnabled = true
//
//            // Enables resource shrinking, which is performed by the
//            // Android Gradle plugin.
//            isShrinkResources = true
//
//            // Includes the default ProGuard rules files that are packaged with
//            // the Android Gradle plugin. To learn more, go to the section about
//            // R8 configuration files.
////            proguardFiles(
////                getDefaultProguardFile("proguard-android-optimize.txt"),
////                "proguard-rules.pro"
////            )
//
//
//            versionNameSuffix = "-release"
//            applicationIdSuffix = ".release"
//            signingConfig = signingConfigs.getByName("release")
//        }
//
//
//    }


    dependencies {

        implementation(project(mapOf("path" to ":data")))
        implementation("androidx.core:core-ktx:1.10.1")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
        implementation("androidx.activity:activity-compose:1.7.2")
        implementation(platform("androidx.compose:compose-bom:2023.06.01"))
        implementation("androidx.compose.ui:ui:1.4.3")
        implementation("androidx.compose.ui:ui-graphics:1.4.3")
        implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
        implementation("androidx.compose.material3:material3:1.1.1")
        implementation(platform("androidx.compose:compose-bom:2023.03.00"))
        implementation(project(mapOf("path" to ":domain")))
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation(platform("androidx.compose:compose-bom:2023.06.01"))
        androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.3")
        androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
        debugImplementation("androidx.compose.ui:ui-tooling:1.4.3")
        debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.3")

        implementation("androidx.navigation:navigation-compose:2.6.0")

        val multidex_version = "2.0.1"
        implementation("androidx.multidex:multidex:$multidex_version")

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.okhttp3:okhttp:4.11.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.7.2")

        implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")
        annotationProcessor ("com.github.bumptech.glide:compiler:4.15.1")


        implementation("com.google.dagger:hilt-android:2.44")
        kapt("com.google.dagger:hilt-android-compiler:2.44")
        implementation("androidx.hilt:hilt-navigation-compose:1.0.0")


        val room_version = "2.5.2"

        implementation("androidx.room:room-runtime:$room_version")
        annotationProcessor("androidx.room:room-compiler:$room_version")
        implementation("androidx.room:room-ktx:$room_version")
        // To use Kotlin annotation processing tool (kapt)
        kapt("androidx.room:room-compiler:$room_version")
    }

}