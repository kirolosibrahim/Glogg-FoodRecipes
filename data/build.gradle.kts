plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    kotlin("kapt")
}

android {
    namespace = "com.kit.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    signingConfigs {
        create("release") {
            storeFile = file("D:\\Keys\\foodrecipes_keystore.jks")
            storePassword = "stopqq"
            keyAlias = "key0"
            keyPassword = "stopqq"
        }
        buildTypes {
            release {

                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
                )
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        kotlinOptions {
            jvmTarget = "17"
        }
        // Allow references to generated code
        kapt {
            correctErrorTypes = true
        }
    }

    dependencies {

        implementation("androidx.core:core-ktx:1.10.1")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation(project(mapOf("path" to ":domain")))

        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


        implementation("androidx.core:core-ktx:1.10.1")


        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.google.dagger:hilt-android:2.44")
        kapt("com.google.dagger:hilt-android-compiler:2.44")

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")

        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        val room_version = "2.5.2"

        implementation("androidx.room:room-runtime:$room_version")
        annotationProcessor("androidx.room:room-compiler:$room_version")
        // Kotlin Extensions and Coroutines support for Room
        implementation("androidx.room:room-ktx:$room_version")
        // To use Kotlin annotation processing tool (kapt)
        kapt("androidx.room:room-compiler:$room_version")
    }
}