plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "6.0.0"
    application
}

group = "eu.feather"
version = "0.1"

application.mainClassName = "eu.feather.featherengine.Main"

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")

    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-core:1.2.3")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("io.ktor:ktor-network:1.3.2")
    implementation("io.ktor:ktor-server-core:1.3.2")

    implementation("org.koin:koin-core:2.1.6")
    testImplementation("org.koin:koin-test:2.1.6")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}