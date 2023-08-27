plugins {
    java
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    jacoco

}

group = "edu.palermo"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        csv.required.set(true)
    }
}
jacoco {
    toolVersion = "0.8.8"
    //reportsDirectory.set(layout.buildDirectory.dir("customJacocoReportDir"))
}