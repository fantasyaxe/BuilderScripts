plugins {
    id("java")
    id("com.gradleup.shadow") version("8.3.0")
}

group = "net.minecraft"
version = "1.5.2"

allprojects {
    apply(plugin = "java")
    apply(plugin = "com.gradleup.shadow")

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    dependencies {
        // codec
        implementation("com.jcraft:jogg:0.0.7")
        implementation("com.jcraft:jorbis:0.0.17")
        // render
        implementation("org.lwjgl:lwjgl:3.2.1")
        implementation("org.lwjgl.lwjgl:lwjgl_util:2.9.1")

        // replaced
        implementation("net.sourceforge.argo:argo:7.6")


        implementation("com.paulscode:codecwav:20101023")
        implementation("com.paulscode:codecjorbis:20101023")
        implementation("com.paulscode:soundsystem:201809301515")
        implementation("com.paulscode:librarylwjglopenal:20100824")

        implementation("org.jdom:jdom:1.1.3")
        implementation("org.bouncycastle:bcprov-jdk15on:1.47")
        implementation("org.xerial:sqlite-jdbc:3.7.2")
    }

    repositories {
        mavenCentral()
        maven("https://maven.minecraftforge.net/")
        maven("https://www.beatunes.com/repo/maven2/")
        maven("https://repo.carm.cc/repository/maven-public/")
        maven("https://repo.glaremasters.me/repository/public/")
        maven("https://nexus.velocitypowered.com/repository/maven-public/")
    }

    tasks {
        build {
            dependsOn(shadowJar)
        }

        shadowJar {
            mergeServiceFiles()
            archiveClassifier.set("")
        }

        withType<JavaCompile> {
            options.encoding = "UTF-8"
            options.release = 21
        }

        withType<Jar> {
            manifest { attributes["Main-Class"] = "net.minecraft.client.Minecraft" }
        }
    }
}
