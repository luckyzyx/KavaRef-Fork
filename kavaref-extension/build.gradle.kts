plugins {
    autowire(libs.plugins.kotlin.jvm)
    autowire(libs.plugins.kotlin.dokka)
    autowire(libs.plugins.maven.publish)
}

group = property.project.groupName
version = property.project.kavaref.extension.version

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

kotlin {
    jvmToolchain(17)
    sourceSets.all { languageSettings { languageVersion = "2.0" } }
    compilerOptions {
        freeCompilerArgs = listOf(
            "-Xno-param-assertions",
            "-Xno-call-assertions",
            "-Xno-receiver-assertions"
        )
    }
}