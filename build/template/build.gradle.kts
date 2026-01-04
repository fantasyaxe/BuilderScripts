plugins {
    id("java")
    id("com.gradleup.shadow") version("8.3.0")
}

group = "net.minecraft"
version = "$deVersion"

allprojects {
    apply(plugin = "java")
    apply(plugin = "com.gradleup.shadow")

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of($deJavaVersion)
        }
    }

    dependencies {
        $$dependsImplements
        $$dependsCompileOnly
    }

    repositories {
        mavenCentral()
        $$repositories
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
            options.release = $deJavaVersion
        }

        withType<Jar> {
            manifest { attributes["Main-Class"] = "$deMainClass" }
        }
    }
}
