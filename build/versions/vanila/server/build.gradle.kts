plugins {
    id("java")
}

group = "net.minecraft"
version = "1.5.2"

java {
    sourceCompatibility = JavaVersion.VERSION_1_6
    targetCompatibility = JavaVersion.VERSION_1_6
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.lwjgl.lwjgl:lwjgl:2.9.0")
    implementation("org.lwjgl.lwjgl:lwjgl_util:2.9.0")

    runtimeOnly("org.lwjgl.lwjgl:lwjgl-platform:2.9.0") {
        artifact {
            classifier = "natives-windows"
        }
    }
    runtimeOnly("org.lwjgl.lwjgl:lwjgl-platform:2.9.0") {
        artifact {
            classifier = "natives-linux"
        }
    }

    implementation("net.java.jinput:jinput:2.0.5")
    implementation("net.java.jutils:jutils:1.0.0")
    implementation("com.google.guava:guava:14.0.1")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.jar {
    archiveFileName.set("minecraft-server-1.5.2.jar")

    manifest {
        attributes(
            "Main-Class" to "net.minecraft.server.MinecraftServer",
            "Implementation-Version" to project.version.toString()
        )
    }
}

tasks.register<JavaExec>("runServer") {
    group = "tests"
  
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("net.minecraft.server.MinecraftServer")

    workingDir = file("run")

    jvmArgs("-Xmx1024M", "-Xms512M")
    systemProperty("java.library.path", layout.buildDirectory.dir("natives").get().asFile.absolutePath)

    args("nogui")
}

tasks.register<Copy>("copyNatives") {
    from(configurations.runtimeClasspath.get().filter {
        it.name.contains("lwjgl-platform")
    })
    into(layout.buildDirectory.dir("natives"))
}

tasks.named("runServer") {
    dependsOn("copyNatives")
}

tasks.clean {
    delete("run")
}
