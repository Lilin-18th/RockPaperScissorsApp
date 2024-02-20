import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "jp.com.janken.project.app"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

// If we use jvmToolchain, we need to install JDK 17
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "17"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.bundles.plugins)
    // https://github.com/google/dagger/issues/3068#issuecomment-1470534930
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "janken.primitive.android.application.plugin"
            implementationClass = "jp.com.janken.project.app.primitive.AndroidApplicationPlugin"
        }
        register("android") {
            id = "janken.primitive.android.plugin"
            implementationClass = "jp.com.janken.project.app.primitive.AndroidPlugin"
        }
        register("androidKotlin") {
            id = "janken.primitive.android.kotlin.plugin"
            implementationClass = "jp.com.janken.project.app.primitive.AndroidKotlinPlugin"
        }
        register("androidCompose") {
            id = "janken.primitive.android.compose.plugin"
            implementationClass = "jp.com.janken.project.app.primitive.AndroidComposePlugin"
        }
        // Conventions
        register("androidFeature") {
            id = "janken.convention.android.feature"
            implementationClass = "jp.com.janken.project.app.convention.AndroidFeaturePlugin"
        }
    }
}
