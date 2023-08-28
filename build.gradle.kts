plugins {
    java
    id("org.springframework.boot") version "3.1.0"
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
configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.name == "snakeyaml") {
            useVersion("2.0")
        }
    }
}
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.mysql:mysql-connector-j:8.0.31")
    //testImplementation("com.h2database:h2:2.1.214")
    implementation("com.h2database:h2:2.2.220")

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