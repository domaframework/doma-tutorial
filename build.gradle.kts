plugins {
    java
    id("com.diffplug.eclipse.apt") version "3.24.0"
    id("com.diffplug.spotless") version "5.3.0"
    id("org.seasar.doma.compile") version "1.1.0"
}

tasks {
    val encoding = "UTF-8"

    compileJava {
        options.encoding = encoding
        val aptOptions = extensions.getByType<com.diffplug.gradle.eclipse.apt.AptPlugin.AptOptions>()
        aptOptions.processorArgs = mapOf(
                "doma.domain.converters" to "examples.domain.DomainConverterProvider"
        )
    }

    compileTestJava {
        options.encoding = encoding
    }

    test {
        useJUnitPlatform()
    }
}

spotless {
    java {
        googleJavaFormat("1.7")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    mavenLocal()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    val domaVersion: String by project
    annotationProcessor("org.seasar.doma:doma-processor:${domaVersion}")
    implementation("org.seasar.doma:doma-core:${domaVersion}")
    implementation("org.seasar.doma:doma-slf4j:${domaVersion}")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
    runtimeOnly("com.h2database:h2:1.4.200")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

eclipse {
    classpath {
        file {
            whenMerged {
                val classpath = this as org.gradle.plugins.ide.eclipse.model.Classpath
                classpath.entries.removeAll {
                    when (it) {
                        is org.gradle.plugins.ide.eclipse.model.Output -> it.path == ".apt_generated"
                        else -> false
                    }
                }
            }
            withXml {
                val node = asNode()
                node.appendNode("classpathentry", mapOf("kind" to "src", "output" to "bin/main", "path" to ".apt_generated"))
            }
        }
    }
    jdt {
        javaRuntimeName = "JavaSE-11"
    }
}
