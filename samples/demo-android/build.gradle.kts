plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hikage)
}

android {
    namespace = gropify.project.samples.demo.android.packageName
    compileSdk = gropify.project.android.compileSdk

    defaultConfig {
        applicationId = gropify.project.samples.demo.android.packageName
        minSdk = gropify.project.android.minSdk
        targetSdk = gropify.project.android.targetSdk
        versionName = gropify.project.samples.demo.android.versionName
        versionCode = gropify.project.samples.demo.android.versionCode
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.kavarefCore)
    implementation(projects.kavarefAndroid)
    implementation(projects.kavarefExtension)

    implementation(platform(libs.betterandroid.bom))
    implementation(libs.betterandroid.ui.component)
    implementation(libs.betterandroid.ui.component.adapter)
    implementation(libs.betterandroid.ui.extension)
    implementation(libs.betterandroid.system.extension)

    implementation(platform(libs.hikage.bom))
    implementation(libs.hikage.core)
    implementation(libs.hikage.runtime)
    implementation(libs.hikage.runtime.attribute)
    implementation(libs.hikage.extension)
    implementation(libs.hikage.widget.androidx)
    implementation(libs.hikage.widget.material)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}