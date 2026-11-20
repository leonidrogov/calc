plugins {
    java
    pmd
    application
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:6.1.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
pmd {
    isConsoleOutput = true
    toolVersion = "7.29.0"
    rulesMinimumPriority = 5
    ruleSetFiles = files("config/pmd/pmd.xml")
}
application {
    mainClass = "Calculator.Main"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
