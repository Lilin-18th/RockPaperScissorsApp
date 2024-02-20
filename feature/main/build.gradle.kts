plugins {
    id("janken.convention.android.feature")
}

android.namespace = "jp.com.janken.feature.main"

dependencies {
    implementation(libs.compose.hilt.navigation)
    implementation(libs.compose.material.icon)
    implementation(libs.compose.navigation)
}
