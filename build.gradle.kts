import java.util.Properties

plugins {
    id("java-library")
    id("maven-publish")
}

group = "dev.booky"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains:annotations:23.0.0")
    api("com.google.code.gson:gson:2.9.1")
}

java {
    withSourcesJar()
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

publishing {
    publications.create<MavenPublication>("maven") {
        artifactId = project.name.toLowerCase()
        from(components["java"])
    }

    val mvnRepoPropsFile = file("mvnrepo.properties")
    if (mvnRepoPropsFile.exists()) {
        val props = Properties()
        props.load(mvnRepoPropsFile.inputStream())

        repositories.maven(props.getProperty("url")) {
            name = props.getProperty("name")
            authentication { create<HttpHeaderAuthentication>("header") }
            credentials(HttpHeaderCredentials::class)
        }
    }
}
