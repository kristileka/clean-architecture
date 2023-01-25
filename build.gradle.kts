plugins {
    `java-library`
    `jacoco`
}

subprojects {
    apply {
        plugin("java")
        plugin("jacoco")
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

dependencies {
    testImplementation("junit:junit:4.13")
}