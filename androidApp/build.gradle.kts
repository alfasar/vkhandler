plugins {
    id(androidApplication)
    kotlin(androidPlugin)
}

android {
    compileSdk = Versions.compile_sdk
    defaultConfig {
        applicationId = "com.example.vkhandler.android"
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
}

dependencies {
    implementation(project(":shared"))
    with(Deps) {
        implementation(material)
        implementation(appcompat)
        implementation(constraint_layout)

        implementation(lifecycle_viewmodel)
        implementation(lifecycle_livedata)
        implementation(lifecycle_common)
        implementation(lifecycle_service)

        implementation(fragment)

        implementation(coroutines)

        implementation(coil)

        implementation(navigation_fragment)
        implementation(navigation_ui)

        implementation(koin_android)
        implementation(koin_test)
    }
}