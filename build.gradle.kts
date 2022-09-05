plugins {
    kotlin("js") version "1.7.10"
    id("com.github.gmazzo.buildconfig") version "3.1.0"
}

group = "org.keru"
version = "0.0.3-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.7.2")
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}

buildConfig {
    buildConfigField("String", "APP_VERSION", provider { "\"${project.version}\"" })
    buildConfigField("String", "APP_NAME", provider { "\"${project.name}\"" })
}