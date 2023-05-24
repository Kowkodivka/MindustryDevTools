allprojects {
    group = "ru.kowkodivka.tools"
    version = "1.0.0"

    ext.set("mindustry-version", "v144.3")
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral()
        maven("https://www.jitpack.io")
    }

    tasks.withType<JavaCompile> {
        val javaVersion = "16"

        options.encoding = "UTF-8"

        sourceCompatibility = javaVersion
        sourceCompatibility = javaVersion
    }

    configure<JavaPluginExtension> {
        withSourcesJar()
        withJavadocJar()
    }

    configure<PublishingExtension> {
        publications {
            create<MavenPublication>("release") {
                artifactId = project.name
                groupId = project.group.toString()
                version = project.version.toString()

                from(components["java"])

                pom {
                    name.set("MindustryDevTools")
                    description.set("Library of helpful utilities")
                    url.set("https://github.com/Kowkodivka/MindustryDevTools")
                }
            }
        }
    }
}
