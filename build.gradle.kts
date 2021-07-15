/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.0.1/userguide/tutorial_java_projects.html
 */

plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application.
    application
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
}

dependencies {

    // Use JUnit test framework
    testImplementation("junit:junit:4.13.2")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("org.springframework:spring-context:5.3.9")
}

application {
    // Define the main class for the application.
    mainClass.set("com.github.sebPasieka.weltCrawler.App")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.github.sebPasieka.weltCrawler.App"
    }
}

