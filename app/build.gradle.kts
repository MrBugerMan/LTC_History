plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.ltchistory"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ltchistory"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }

    // вроде это нужно для избавления от конфликта зависимостей
    packagingOptions {
        pickFirst("META-INF/gradle/incremental.annotation.processors")
    }

}

dependencies {
    // My dependencies
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.glide)
    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.hilt)
    implementation(libs.splash)
    implementation(libs.navigation.fragment.ktx)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}