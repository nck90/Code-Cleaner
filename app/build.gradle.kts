plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.github.javaparser:javaparser-core:3.25.4")
    implementation("org.javassist:javassist:3.28.0-GA")
    implementation("org.ow2.asm:asm:9.5")
    
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

application {
    mainClass.set("org.example.CodeCleanerApp")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
tasks.named<JavaExec>("bootRun") {
    jvmArgs = listOf("-Xmx1024m", "-Dspring.jmx.enabled=false")
}