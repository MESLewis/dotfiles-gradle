plugins {
    kotlin("jvm") version "1.3.61"
    `java-gradle-plugin`
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