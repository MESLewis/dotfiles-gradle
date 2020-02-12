plugins {
    kotlin("jvm") version "1.3.50"
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

gradlePlugin {
    plugins {
        create("dotfiles") {
            id = "dotfiles"
            implementationClass = "DotfilesPlugin"
        }
    }
}