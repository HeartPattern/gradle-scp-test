plugins {
    kotlin("jvm") version "1.4.0"
}

group = "io.heartpattern"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

tasks {
    val jarTask = getByName("jar")

    create<Exec>("upload") {
        dependsOn("jar")

        workingDir = project.rootDir

        commandLine = listOf(
            "scp",
            "-P",
            "${project.properties["port"]}",
            "-i",
            "${project.properties["identity"]}"
        ) + jarTask.outputs.files.map {
            it.absolutePath
        } + listOf(
            "${project.properties["username"]}@${project.properties["host"]}:${project.properties["remote_path"]}"
        )
    }
}