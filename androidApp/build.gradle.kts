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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =
            Versions.compose_compiler_version
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

        implementation(coroutines)

        implementation(coil)

        implementation(koin_android)
        implementation(koin_test)
    }
    with(Deps.Compose) {
        implementation(compiler)
        implementation(runtime)
        implementation(runtime_livedata)
        implementation(ui)
        implementation(uiUtil)
        implementation(tooling)
        implementation(foundation)
        implementation(foundationLayout)
        implementation(material)
        implementation(material_icons)
        implementation(activity)
        implementation(koin)
    }

    implementation("androidx.navigation:navigation-compose:2.4.1")


}