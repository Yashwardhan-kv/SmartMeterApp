plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services") // Firebase plugin
}

android {
    namespace = "com.example.smartmeterapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.smartmeterapp"
        minSdk = 16
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
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

dependencies {
    // Android Core Libraries
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation ("androidx.appcompat:appcompat:1.6.1") // Ensure the latest stable version
    implementation ("com.google.android.material:material:1.9.0") // For Material Design components


    // AndroidX Replacements for Legacy Support Libraries
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.10.0")

    // Firebase
    implementation("com.google.firebase:firebase-auth:22.0.0")
    implementation("com.google.firebase:firebase-database:20.2.0")
    implementation("com.google.firebase:firebase-messaging:24.1.0")
    implementation(platform("com.google.firebase:firebase-bom:32.1.1"))

    // TensorFlow Lite (for ML Models)
    implementation("org.tensorflow:tensorflow-lite:2.11.0")
    implementation("org.tensorflow:tensorflow-lite-support:0.4.3")

    // MPAndroidChart (for visualizing energy consumption)
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0") // Ensure that this version is correct. You can change to another if necessary.

    // MQTT (for IoT communication)
    implementation("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5")
    implementation("org.eclipse.paho:org.eclipse.paho.android.service:1.1.1")

    // Testing Libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    

}
