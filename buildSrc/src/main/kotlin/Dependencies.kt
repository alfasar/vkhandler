const val androidApplication = "com.android.application"
const val androidPlugin = "android"
const val androidLib = "com.android.library"
const val multiplatform = "multiplatform"
const val serialization = "plugin.serialization"
const val sqlDelight = "com.squareup.sqldelight"

object Versions {

    // Project
    const val min_sdk = 21
    const val target_sdk = 32
    const val compile_sdk = 32

    const val android_gradle_plugin_version = "7.2.2"
    const val kotlin_gradle_plugin_version = "1.6.10"

    // Shared
    const val serialization_version = "1.6.10"
    const val ktorVersion_version = "2.1.1"
    const val koin_version = "3.2.0"
    const val settings_version = "1.0.0-RC"

    // Android
    const val material_version = "1.4.0"
    const val appcompat_version = "1.3.1"
    const val constraint_layout_version = "2.1.0"
    const val lifecycle_version = "2.4.1"
    const val fragment_version = "1.5.2"
    const val navigation_version = "2.5.2"
    const val coroutines_version = "1.6.4"
    const val coil_version = "2.2.2"
    const val compose_compiler_version= "1.1.0-rc02"
    const val compose_version= "1.1.0-rc01"
    const val activity_compose = "1.4.0"
    const val navigation_compose = "2.4.1"
}

object Deps {

    // Project
    const val kotlin_gradle_plugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradle_plugin_version}"
    const val android_gradle_plugin =
        "com.android.tools.build:gradle:${Versions.android_gradle_plugin_version}"

    // Shared
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_version}"

    const val koin_core = "io.insert-koin:koin-android:${Versions.koin_version}"
    const val koin_test = "io.insert-koin:koin-test:${Versions.koin_version}"

    const val ktor_server_core = "io.ktor:ktor-server-core:${Versions.ktorVersion_version}"
    const val ktor_client_cio = "io.ktor:ktor-client-cio:${Versions.ktorVersion_version}"
    const val ktor_client_android = "io.ktor:ktor-client-android:${Versions.ktorVersion_version}"
    const val ktor_client_ios = "io.ktor:ktor-client-ios:${Versions.ktorVersion_version}"
    const val ktor_client_content = "io.ktor:ktor-client-content-negotiation:${Versions.ktorVersion_version}"
    const val ktor_serialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktorVersion_version}"
    const val ktor_logging = "io.ktor:ktor-client-logging:2.0.0-beta-1"

    const val multiplatform_settings = "com.russhwolf:multiplatform-settings:${Versions.settings_version}"


    // Android
    const val material = "com.google.android.material:material:${Versions.material_version}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"

    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    const val lifecycle_common = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle_version}"
    const val lifecycle_service = "androidx.lifecycle:lifecycle-service:${Versions.lifecycle_version}"

    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil_version}"

    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation_version}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation_version}"

    const val koin_android = "io.insert-koin:koin-android:${Versions.koin_version}"

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose_version}"
        const val uiUtil = "androidx.compose.ui:ui-util:${Versions.compose_version}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose_version}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose_version}"
        const val material = "androidx.compose.material:material:${Versions.compose_version}"
        const val material_icons = "androidx.compose.material:material-icons-extended:${Versions.compose_version}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.compose_version}"
        const val compiler = "androidx.compose.compiler:compiler:${Versions.compose_version}"
        const val runtime_livedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose_version}"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose_version}"
        const val activity = "androidx.activity:activity-compose:${Versions.activity_compose}"
        const val koin = "io.insert-koin:koin-androidx-compose:${Versions.koin_version}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation_compose}"
    }
}
