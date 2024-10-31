val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.21"
    id("io.ktor.plugin") version "3.0.1"
}

group = "com.wird"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.2.4")
    implementation("io.ktor:ktor-server-netty:2.2.4")
    implementation("io.ktor:ktor-server-content-negotiation:2.2.4")
    implementation("io.ktor:ktor-serialization-gson:2.2.4")
    implementation("io.ktor:ktor-client-core:2.2.4")
    implementation("io.ktor:ktor-client-cio:2.2.4") 
    implementation("io.ktor:ktor-client-content-negotiation:2.2.4")
    implementation("io.ktor:ktor-client-logging:2.2.4")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("redis.clients:jedis:4.2.3")
    testImplementation("io.ktor:ktor-server-test-host:2.2.4")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
